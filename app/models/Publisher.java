package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


import com.avaje.ebean.*;


/**
 * Company entity managed by Ebean
 */
@Entity 
public class Publisher extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    @Column(unique=true)
    public String name;
      
    /**
     * Generic query helper for entity Publisher with id Long
     */
    public static Model.Finder<Long,Publisher> find = new Model.Finder<Long,Publisher>(Long.class, Publisher.class);

    public static Page<Publisher> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)                
                .findPagingList(pageSize)
                .getPage(page);
    }
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Publisher p: Publisher.find.orderBy("name").findList()) {
            options.put(p.id.toString(), p.name);
        }
        return options;
    }
}

