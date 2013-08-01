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
public class CatalogueStatus extends Model {

    @Id
    public Long id;        
    
    public String status;
    
    /**
     * Generic query helper for entity Catalogue with id Long
     */
    public static Model.Finder<Long,CatalogueStatus> find = new Model.Finder<Long,CatalogueStatus>(Long.class, CatalogueStatus.class);
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(CatalogueStatus cs: CatalogueStatus.find.orderBy("status").findList()) {
            options.put(cs.id.toString(), cs.status);
        }
        return options;
    }
}

