package models;

import java.util.*;
import javax.persistence.*;

import play.Logger;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


import com.avaje.ebean.*;




/**
 * Company entity managed by Ebean
 */
/*
 * insert into book(title,authors_text,publisher_text,isbn,catalogue_count)
 * SELECT `col 1`,`col 2`,`col 3`,`col 4`,`col 5`,`col 6`FROM `TABLE 1` order by `col 1`
 */

@Entity 
public class Book extends Model {

    @Id    
    public Long id;
    
    @Constraints.Required
    public String title;
    
    public String isbn;
    //public int publish_year;
        
    @ManyToOne
    //@Constraints.Required
    public Publisher publisher;
    public String publisher_text;
    
    @Constraints.Required
    //@OneToMany(cascade=CascadeType.PERSIST)    
    @ManyToMany(cascade=CascadeType.ALL,mappedBy="books") 
    //public List<Author> authors = new ArrayList<Author>();
    public Set<Author> authors = new HashSet<Author>(); 
    
    public String authors_text;
    
    public int catalogue_count=0;
    public Long publish_year;
    /**
     * Generic query helper for entity Book with id Long
     */
    public static Model.Finder<Long,Book> find = new Model.Finder<Long,Book>(Long.class, Book.class);

    public static Page<Book> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("title", "%" + filter + "%")                
                .orderBy(sortBy + " " + order)     
                .fetch("publisher")
                .findPagingList(pageSize)
                .getPage(page);
    }
    public static void createCatalog(Book book){
    	Catalogue.createCatalogue(book);
    }
    public static Page<Book> search(int page,int pageSize, String filter,String filterBy, String sortBy, String order) {
    	Logger.info("filterBy"+filterBy+"filter"+filterBy);
    	return Book.find.where()
        .ilike(filterBy, "%" + filter + "%")                
        .orderBy(sortBy + " " + order)     
        .fetch("publisher")
        .fetch("authors")
        .findPagingList(pageSize)
        .getPage(page);
    }
}

