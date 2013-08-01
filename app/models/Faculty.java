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
public class Faculty extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    /**
     * Generic query helper for entity Faculty with id Long
     */
    public static Model.Finder<Long,Faculty> find = new Model.Finder<Long,Faculty>(Long.class, Faculty.class);

    public static Page<Faculty> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)                
                .findPagingList(pageSize)
                .getPage(page);
    }
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Faculty f: Faculty.find.orderBy("name").findList()) {
            options.put(f.id.toString(), f.name);
        }
        return options;
    }
}

