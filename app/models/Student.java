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
public class Student extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String nim;
    
    @Constraints.Required
    @ManyToOne
    public Faculty faculty;
    /**
     * Generic query helper for entity Student with id Long
     */
    public static Model.Finder<Long,Student> find = new Model.Finder<Long,Student>(Long.class, Student.class);

    public static Page<Student> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("name", "%" + filter + "%")                
                .orderBy(sortBy + " " + order)    
                .fetch("faculty")
                .findPagingList(pageSize)
                .getPage(page);
    }
    public static Student findByNim(String nim){
    	return find.where()
    	.eq("nim", nim)
    	.findUnique();
    }
}

