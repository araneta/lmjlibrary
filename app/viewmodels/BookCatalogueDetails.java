package viewmodels;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import models.Book;
import models.Borrowing;
import models.Catalogue;
import models.LibraryConfig;
import models.Student;
public class BookCatalogueDetails {
	public String title;
	public String author;
	public String isbn;
	public String publisher;
	public Long publish_year;
	public List<BookCatalogue> catalogues = new ArrayList<BookCatalogue>();
	public static BookCatalogueDetails getDetails(Long bookId){
		BookCatalogueDetails ret = new BookCatalogueDetails();
		Book book = Book.find.byId(bookId);
    	if(book!=null){
    		ret.title = book.title;
    		ret.author = book.authors_text;
    		ret.isbn = book.isbn;
    		ret.publish_year = book.publish_year;
    		ret.publisher = book.publisher_text;
    		List<Catalogue> cats = Catalogue
    		.find.where()
        	.eq("book_id", book.id)
        	.findList();
    		if(cats!=null){   
    			DateFormat formatter = new SimpleDateFormat(LibraryConfig.dateFormat());
    			for(Catalogue cat:cats){
    				BookCatalogue bookcat = new BookCatalogue();
        			bookcat.barcode = cat.barcode;
        			Borrowing trans = Borrowing.getBorrowedCatalogue(cat.id);
        			if(trans!=null)//not available
        			{
        				Student student = trans.student;
        				bookcat.borrowed_by = student.nim + " "+student.name;
        				bookcat.borrowed_date = formatter.format(trans.borrowDate.getTime());
        				bookcat.status = "Not Available";        				
        			}else
        			{        				
        				bookcat.status = cat.status.status;
        			}
        			ret.catalogues.add(bookcat);
    			}    			
    		}
    	}
    	return ret;
	}
}
