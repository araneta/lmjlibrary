package viewmodels;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Page;

import models.Book;
import models.Borrowing;
import models.LibraryConfig;
import models.Student;

public class ReportBorrowedBook {
	public Long catalogue_id;
	public String borrowed_date;
	public String title;
	public String barcode;
	public String author;
	public String publisher;
	public String nim;
	public String name;
	public static int count(Calendar cal,String filter){
		Calendar cStart = Calendar.getInstance();			
		cStart.set(
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE),
				0,
				0
				);
		Calendar cEnd = Calendar.getInstance();			
		cEnd.set(
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE),
				23,
				59
				);
				
		return Borrowing.find
		.where(
				Expr.and(
						Expr.between("borrow_date", cStart.getTime(), cEnd.getTime()),						
						Expr.or(Expr.ilike("student.nim", "%"+filter+"%"),
								Expr.or(
										Expr.ilike("student.name", "%"+filter+"%"),
										Expr.or(
												Expr.ilike("catalogue.book.title", "%"+filter+"%"),								
												Expr.ilike("catalogue.book.authors_text", "%"+filter+"%")
										)
								)
						)
				)
				
		)	
		.findRowCount();
	}
	public static List<ReportBorrowedBook> get(Calendar cal,int page,int pageSize, String sortBy, String order,String filter){
		List<ReportBorrowedBook> ret = new ArrayList<ReportBorrowedBook>();
		Calendar cStart = Calendar.getInstance();			
		cStart.set(
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE),
				0,
				0
				);
		Calendar cEnd = Calendar.getInstance();			
		cEnd.set(
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE),
				23,
				59
				);
				
		Page<Borrowing> trans = Borrowing.find
		.fetch("student")
		.fetch("catalogue")
		.fetch("catalogue.book")
		.where(
				Expr.and(
						Expr.between("borrow_date", cStart.getTime(), cEnd.getTime()),						
						Expr.or(Expr.ilike("student.nim", "%"+filter+"%"),
								Expr.or(
										Expr.ilike("student.name", "%"+filter+"%"),
										Expr.or(
												Expr.ilike("catalogue.book.title", "%"+filter+"%"),								
												Expr.ilike("catalogue.book.authors_text", "%"+filter+"%")
										)
								)
						)
				)
				
		)				
		.orderBy(sortBy + " " + order + ", id " + order)
        .findPagingList(pageSize).setFetchAhead(false)
        .getPage(page);
		if(trans!=null){
			DateFormat formatter = new SimpleDateFormat(LibraryConfig.dateFormat());
			for(Borrowing tran:trans.getList()){
				Book book = tran.catalogue.book;
				Student student = tran.student;
				
				ReportBorrowedBook item = new ReportBorrowedBook();
				item.author = book.authors_text;
				item.barcode = tran.catalogue.barcode;
				item.borrowed_date = formatter.format(tran.borrowDate);
				item.catalogue_id = tran.catalogue.id;
				item.name = student.name;
				item.nim = student.nim;
				item.publisher = book.publisher_text;
				item.title = book.title;
				ret.add(item);
			}
		}
		return ret;
	}
}
