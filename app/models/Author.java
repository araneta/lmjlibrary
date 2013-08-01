package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import models.Book;

import com.avaje.ebean.*;


/**
 * Company entity managed by Ebean
 */
@Entity 
public class Author extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    @ManyToMany(cascade=CascadeType.ALL) 
    public Set<Book> books = new HashSet<Book>(); 
    //public List<Book> books = new ArrayList<Book>();    
    /**
     * Generic query helper for entity Author with id Long
     */
    public static Model.Finder<Long,Author> find = new Model.Finder<Long,Author>(Long.class, Author.class);

    public static Page<Author> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)                
                .findPagingList(pageSize)
                .getPage(page);
    }
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Author p: Author.find.orderBy("name").findList()) {
            options.put(p.id.toString(), p.name);
        }
        return options;
    }
}

