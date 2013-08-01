package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


import com.avaje.ebean.*;
@Entity 
public class LibraryConfig extends Model{
	@Id
    public Long id;
	
	@Constraints.Required
	public String name;
	
	public String value;
	public static Model.Finder<Long,LibraryConfig> find = new Model.Finder<Long,LibraryConfig>(Long.class, LibraryConfig.class);
	public static String get(String name){
		LibraryConfig config =  
		find.where()
		.eq("name", name)		
		.findUnique();
		if(config!=null)
			return config.value;
		return "";
	}
	public static String set(String name,String value){
		LibraryConfig config =  
			find.where()
			.eq("name", name)		
			.findUnique();
			if(config!=null){
				config.update();
				config.value = value;
				config.save();
			}
			return get(name);			
	}
	public static int maxBorrowingDay(){
		return Integer.parseInt(get("maxBorrowingDay"));
	}
	public static int finePerDay(){
		return Integer.parseInt(get("finePerDay"));
	}
	public static int maxRenewalCount(){
		return Integer.parseInt(get("maxRenewalCount"));
	}
	public static String dateFormat(){
		return get("dateFormat");
	}
	public static int maxBorrowedBook(){
		return  Integer.parseInt(get("maxBorrowedBook"));
	}
	
}
