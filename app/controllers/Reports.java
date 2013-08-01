package controllers;

import play.*;
import play.libs.Json;
import play.mvc.*;
import play.data.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

import com.avaje.ebean.Page;

import models.*;
import viewmodels.BorrowedBook;
import viewmodels.ReportBorrowedBook;
import viewmodels.ReportOverdueBook;
import viewmodels.ReportReturnedBook;
import views.html.reports.*;

@Security.Authenticated(Secured.class)
public class Reports extends Controller {
	
   
    public static Result borrowedBooks() {    	
        return ok(
            borrowedbooks.render()
        );
    }
    public static Result listBorrowedBooks() {
        /**
         * Get needed params
         */
        Map<String, String[]> params = request().queryString();
        Calendar cal = Calendar.getInstance();       
        DateFormat df = new SimpleDateFormat(LibraryConfig.dateFormat()); 
        Date startDate;
        try {
        	String strdate = params.get("seldate")[0];        	
            startDate = df.parse(strdate);
            cal.setTime(startDate);    
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        String filter = params.get("sSearch")[0];
        Integer pageSize = Integer.valueOf(params.get("iDisplayLength")[0]);
        Integer page = Integer.valueOf(params.get("iDisplayStart")[0]) / pageSize;
     
        /**
         * Get sorting order and column
         */
        String sortBy = "borrowed_date";
        String order = params.get("sSortDir_0")[0];
     
        switch(Integer.valueOf(params.get("iSortCol_0")[0])) {
          case 0 : sortBy = "borrow_date"; break;
          case 1 : sortBy = "catalogue.barcode"; break;
          case 2 : sortBy = "catalogue.book.title"; break;
          case 4 : sortBy = "student.nim"; break;
          case 5 : sortBy = "student.name"; break;                    
        }
     
        List<ReportBorrowedBook> borrowedBook = ReportBorrowedBook.get(cal, page, pageSize, sortBy, order,filter);     
        Integer iTotalDisplayRecords = borrowedBook.size();
        Integer iTotalRecords = ReportBorrowedBook.count(cal,filter);
     
        /**
         * Construct the JSON to return
         */
        ObjectNode result = Json.newObject();
     
        result.put("sEcho", Integer.valueOf(params.get("sEcho")[0]));
        result.put("iTotalRecords", iTotalRecords);
        result.put("iTotalDisplayRecords", iTotalDisplayRecords);
     
        ArrayNode an = result.putArray("aaData");
        
        for(ReportBorrowedBook c : borrowedBook) {
          ObjectNode row = Json.newObject();
          row.put("0", c.borrowed_date);
          row.put("1", c.barcode);
          row.put("2", c.title);
          row.put("3", c.author);
          row.put("4", c.nim);
          row.put("5", c.name);
          an.add(row);
        }
     
        return ok(result);
     }
    
    public static Result returnedBooks() {    	
        return ok(
            returnedbooks.render()
        );
    }
    public static Result listReturnedBooks() {
        /**
         * Get needed params
         */
        Map<String, String[]> params = request().queryString();
        Calendar cal = Calendar.getInstance();       
        DateFormat df = new SimpleDateFormat(LibraryConfig.dateFormat()); 
        Date startDate;
        try {
        	String strdate = params.get("seldate")[0];        	
            startDate = df.parse(strdate);
            cal.setTime(startDate);    
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        String filter = params.get("sSearch")[0];
        Integer pageSize = Integer.valueOf(params.get("iDisplayLength")[0]);
        Integer page = Integer.valueOf(params.get("iDisplayStart")[0]) / pageSize;
     
        /**
         * Get sorting order and column
         */
        String sortBy = "return_date";
        String order = params.get("sSortDir_0")[0];
     
        switch(Integer.valueOf(params.get("iSortCol_0")[0])) {
	        case 0 : sortBy = "return_date"; break;
	        case 1 : sortBy = "catalogue.barcode"; break;
	        case 2 : sortBy = "catalogue.book.title"; break;
	        case 4 : sortBy = "student.nim"; break;
	        case 5 : sortBy = "student.name"; break; 
        }
     
        List<ReportReturnedBook> returnedBook = ReportReturnedBook.get(cal, page, pageSize, sortBy, order,filter);     
        Integer iTotalDisplayRecords = returnedBook.size();
        Integer iTotalRecords = ReportReturnedBook.count(cal,filter);
     
        /**
         * Construct the JSON to return
         */
        ObjectNode result = Json.newObject();
     
        result.put("sEcho", Integer.valueOf(params.get("sEcho")[0]));
        result.put("iTotalRecords", iTotalRecords);
        result.put("iTotalDisplayRecords", iTotalDisplayRecords);
     
        ArrayNode an = result.putArray("aaData");
        
        for(ReportReturnedBook c : returnedBook) {
          ObjectNode row = Json.newObject();
          row.put("0", c.return_date);
          row.put("1", c.barcode);
          row.put("2", c.title);
          row.put("3", c.author);
          row.put("4", c.nim);
          row.put("5", c.name);
          an.add(row);
        }
     
        return ok(result);
    }
    public static Result overdueBooks() {    	
        return ok(
            overduebooks.render()
        );
    }
    public static Result listOverdueBooks() {
        /**
         * Get needed params
         */
        Map<String, String[]> params = request().queryString();
        Calendar cal = Calendar.getInstance();       
        DateFormat df = new SimpleDateFormat(LibraryConfig.dateFormat()); 
        Date startDate;
        try {
        	String strdate = params.get("seldate")[0];        	
            startDate = df.parse(strdate);
            cal.setTime(startDate);    
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        String filter = params.get("sSearch")[0];
        Integer pageSize = Integer.valueOf(params.get("iDisplayLength")[0]);
        Integer page = Integer.valueOf(params.get("iDisplayStart")[0]) / pageSize;
     
        /**
         * Get sorting order and column
         */
        String sortBy = "must_return_date";
        String order = params.get("sSortDir_0")[0];
     
        switch(Integer.valueOf(params.get("iSortCol_0")[0])) {
	        case 0 : sortBy = "must_return_date"; break;
	        case 1 : sortBy = "catalogue.barcode"; break;
	        case 2 : sortBy = "catalogue.book.title"; break;
	        case 4 : sortBy = "student.nim"; break;
	        case 5 : sortBy = "student.name"; break; 
        }
     
        List<ReportOverdueBook> overdueBook = ReportOverdueBook.get(cal, page, pageSize, sortBy, order,filter);     
        Integer iTotalDisplayRecords = overdueBook.size();
        Integer iTotalRecords = ReportOverdueBook.count(cal,filter);
     
        /**
         * Construct the JSON to return
         */
        ObjectNode result = Json.newObject();
     
        result.put("sEcho", Integer.valueOf(params.get("sEcho")[0]));
        result.put("iTotalRecords", iTotalRecords);
        result.put("iTotalDisplayRecords", iTotalDisplayRecords);
     
        ArrayNode an = result.putArray("aaData");
        
        for(ReportOverdueBook c : overdueBook) {
          ObjectNode row = Json.newObject();
          row.put("0", c.due_date);
          row.put("1", c.barcode);
          row.put("2", c.title);
          row.put("3", c.author);
          row.put("4", c.nim);
          row.put("5", c.name);
          an.add(row);
        }
     
        return ok(result);
     }
}

