import play.*;
import play.libs.*;

import java.util.*;

import com.avaje.ebean.*;

import models.*;

public class Global extends GlobalSettings {
    
    public void onStart(Application app) {
        InitialData.insert(app);
    }
    
    static class InitialData {
        
        public static void insert(Application app) {    
        	/*
        	Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
            if(Ebean.find(Userx.class).findRowCount() == 0) {                                
 
                Ebean.save(all.get("userx"));                                
            }
            if(Ebean.find(Book.class).findRowCount() == 0) {            	                
                Ebean.save(all.get("book"));                                
            }
            if(Ebean.find(Faculty.class).findRowCount() == 0) {                                
                Ebean.save(all.get("faculty"));                                
            }
            if(Ebean.find(Student.class).findRowCount() == 0) {                                 
                Ebean.save(all.get("student"));                                
            }
            if(Ebean.find(LibraryConfig.class).findRowCount() == 0) {                                
 
                Ebean.save(all.get("library_config"));                                
            }
            if(Ebean.find(CatalogueStatus.class).findRowCount() == 0) {                                
                Ebean.save(all.get("catalogue_status"));                                
            }
            */
        }
        
    }
    
}