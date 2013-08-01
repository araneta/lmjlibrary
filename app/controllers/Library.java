package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;
import views.html.*;
import views.html.libraries.*;
import viewmodels.BookCatalogueDetails;



/**
 * Manage projects related operations.
 */
//@Security.Authenticated(Secured.class)
public class Library extends Controller {
	
    //p:Int ?= 0,f ?="",fb ?= "", s ?= "name", o ?= "asc"
    public static Result search(int page, String filter,String filterBy, String sortBy, String order) {
    	int pageSize = 10;
    	if(filter.isEmpty())
    		return ok(
				searchForm.render()
			);
        return ok(
            searchResultForm.render(				
				Book.search(page, pageSize, filter, filterBy, sortBy, order),
				filter,filterBy,sortBy, order
            )
        );
    }
    public static Result details(Long bookId){    	    	    	 
    	return ok(bookDetails.render(BookCatalogueDetails.getDetails(bookId)));
    }
}

