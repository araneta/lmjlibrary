package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.*;


import com.avaje.ebean.*;


/**
 * Company entity managed by Ebean
 */
@Entity 
public class Catalogue extends Model {

    @Id
    public Long id;
    
    @ManyToOne
    @Constraints.Required
    public Book book;
    @Column(unique=true)
    public String barcode;
    
    @ManyToOne
    @Constraints.Required
    //public Boolean available;
    public CatalogueStatus status;
    /**
     * Generic query helper for entity Catalogue with id Long
     */
    public static Model.Finder<Long,Catalogue> find = new Model.Finder<Long,Catalogue>(Long.class, Catalogue.class);

    public static Page<Catalogue> page(Long bookid,int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
            	.eq("book_id", bookid)
                .ilike("barcode", "%" + filter + "%")                
                .orderBy(sortBy + " " + order)     
                .fetch("book")
                .fetch("status")
                .findPagingList(pageSize)
                .getPage(page);
    }
    public static void createCatalogue(Book book){
    	List<Catalogue> cats = find.where().eq("book_id", book.id).findList();
    	int remind = 0;
    	if(cats==null)
    		remind = book.catalogue_count;
		if(cats!=null && cats.size()<book.catalogue_count)
			remind = book.catalogue_count-cats.size();
		//final String barcodeDir = "/media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/barcode";
		CatalogueStatus status = CatalogueStatus.find.byId(new Long(1));
		for(int i=cats.size();i<book.catalogue_count;i++){
			Catalogue cat = new Catalogue();
			cat.book = book;
			cat.status = status;
			cat.barcode = generateBarcode();
			cat.save();
			//Save_image(getBarcode(cat.barcode, new Code128Bean()),barcodeDir + cat.barcode);
    	}    	
    }
    public static String generateBarcode(){
    	final Random random = new Random(System.nanoTime());
    	String code;
    	boolean repeat = false;
    	do{
			code = generateString(random,"0123456789",8);
			if(Catalogue.findByBarcode(code)!=null)
				repeat = true;
    	}while(repeat);
    	return code;
    }
    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
    public static Catalogue findByBarcode(String barcode){
    	return 
        find.where()
        	.eq("barcode", barcode)
            .findUnique();    
    }
   
}

