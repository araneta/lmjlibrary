package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.persistence.*;

import play.Logger;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import viewmodels.ReportBorrowedBook;


import com.avaje.ebean.*;


/**
 * Borrowing entity managed by Ebean
 */

@Entity 
public class Borrowing extends Model {

    @Id
    public Long id;
    
    @Constraints.Required
    @ManyToOne
    public Userx user;
    
    @Constraints.Required
    @ManyToOne
    public Student student;
    
    @Constraints.Required
    @ManyToOne
    public Catalogue catalogue;
    
    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    public Date borrowDate;
    
    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    public Date mustReturnDate;
    
    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    public Date renewalDate;
    
    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    public Date returnDate;
    
    public int renewalCount=0;
    public Long fine;
    /**
     * Generic query helper for entity Borrowing with id Long
     */
    public static Model.Finder<Long,Borrowing> find = new Model.Finder<Long,Borrowing>(Long.class, Borrowing.class);
/*
    public static Page<Borrowing> page(int page, int pageSize, String sortBy, String order, String filter) {
        return 
            find.where()
                .ilike("title", "%" + filter + "%")                
                .orderBy(sortBy + " " + order)     
                .fetch("publisher")
                .findPagingList(pageSize)
                .getPage(page);
    }
    */
    public static Borrowing getBorrowedCatalogue(Long catalogId){
    	return 
    		find.where()
    		.eq("catalogue_id", catalogId)    	
    		.isNull("return_date")
    		.findUnique();
    }
    public static List<Borrowing> getBorrowedCatalogueByStudent(Long studentId){
    	return 
    		find.where()
    		.eq("student_id", studentId)
    		.isNull("return_date")
    		.findList();
    }
    public static Borrowing New(Userx user,Student student,Catalogue cat){
    	Date today = Calendar.getInstance().getTime();  
    	Borrowing newtrans = new Borrowing();
		newtrans.borrowDate = today;
		newtrans.catalogue = cat;					
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, LibraryConfig.maxBorrowingDay());
		newtrans.mustReturnDate = cal.getTime();					
		newtrans.student = student;
		newtrans.user = user;
		Logger.info("4s");
		newtrans.save();
		Logger.info("5");
		return newtrans;
    }
    
    public static Long calculateFine(Date mustReturnDate){
    	Date today = Calendar.getInstance().getTime();    	
    	long fine = 0; 
		if(today.getTime()>mustReturnDate.getTime()){
			//long daylate = (today.getTime()-mustReturnDate.getTime())/(60*60*24);
			long timeDiff = Math.abs(today.getTime() - mustReturnDate.getTime());
			long daylate = TimeUnit.MILLISECONDS.toDays(timeDiff);
			if(daylate>0){
				fine = daylate * LibraryConfig.finePerDay();
			}
		}
		return fine;
    }
    public static Borrowing Resume(Long id,Userx user){
    	Date today = Calendar.getInstance().getTime();
    	Borrowing resumetrans = Borrowing.find.ref(id);
    	resumetrans.fine = Borrowing.calculateFine(resumetrans.mustReturnDate);
		resumetrans.renewalCount++;					  
		resumetrans.renewalDate = today;
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, LibraryConfig.maxBorrowingDay());
		resumetrans.mustReturnDate = cal.getTime();
		resumetrans.user = user;
		resumetrans.save();
		return resumetrans;
    }
    public static Borrowing Return(Long id,Userx user){
    	Date today = Calendar.getInstance().getTime();
    	Borrowing returntrans = Borrowing.find.ref(id);
    	returntrans.fine = Borrowing.calculateFine(returntrans.mustReturnDate);		
		returntrans.returnDate = today;
		returntrans.user = user;
		returntrans.save();
		return returntrans;
    }
    public static Borrowing getResumeInfo(Long catId){
    	Borrowing resumetrans = Borrowing.find.where()
			.eq("catalogue_id", catId)
			.isNull("return_date")
			.findUnique();
    	if(resumetrans==null)
    		return null;
    	Date today = Calendar.getInstance().getTime();
		resumetrans.renewalCount++;					  
		resumetrans.renewalDate = today;
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, LibraryConfig.maxBorrowingDay());
		resumetrans.mustReturnDate = cal.getTime();
		return resumetrans;
    }
    public static Boolean hasReachedMaxBorrowedBookLimit(Long studentId){
    	int borrowedBookCount = 
		find.where()
		.eq("student_id", studentId)
		.isNull("return_date")
		.findRowCount();
    	if(borrowedBookCount>=LibraryConfig.maxBorrowedBook())
    		return true;
    	return false;    
    
    }
}

