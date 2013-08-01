package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.io.File;
import java.util.*;

import com.avaje.ebean.Page;

import models.*;

import views.html.*;
import views.html.catalogues.*;
import play.Logger;
@Security.Authenticated(Secured.class)
public class Catalogues extends Controller {
	
    /**
     * Display the dashboard.
     */
    public static Result index() {
        return ok(
            dashboard.render(				
            )
        );
    }
    public static Result list(Long bookid,int page, String sortBy, String order, String filter) {
    	Book book = Book.find.byId(bookid);
        return ok(
            list.render(				
        		bookid,book.title,Catalogue.page(bookid,page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
    /**
     * Display the 'new catalogue form'.
     */
    public static Result create(Long bookid) {
    	Book book = Book.find.byId(bookid);
        Form<Catalogue> catalogueForm = form(Catalogue.class);
        return ok(        		
            createForm.render(bookid,book.title,catalogueForm)
        );
    }
	
	 /**
     * Handle the 'new catalogue form' submission 
     */
    public static Result save(Long bookid) {
    	Book book = Book.find.byId(bookid);  
        Form<Catalogue> catalogueForm = form(Catalogue.class).bindFromRequest();
        if(catalogueForm.hasErrors()) {
            return badRequest(createForm.render(bookid,book.title,catalogueForm));
        }
        
        catalogueForm.get().save();
          	
        flash("success", "Catalogue " + book.title + " has been created");
        
        return redirect(
                routes.Catalogues.list(bookid,0, "status", "asc", "")
        );
    }
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the catalogue to edit
     */
    public static Result update(Long id,Long bookid) {    	    	
    	Book book = Book.find.byId(bookid);
        Form<Catalogue> catalogueForm = form(Catalogue.class).bindFromRequest();        
        if(catalogueForm.hasErrors()) {        	
            return badRequest(editForm.render(id,bookid,book.title, catalogueForm));
        }
        
        catalogueForm.get().update(id);
        
        flash("success", "Catalogue " + book.title + " has been updated");
        
        return redirect(
                routes.Catalogues.list(bookid,0, "status", "asc", "")
        );
        
    }
    /**
     * Display the 'edit form' of a existing catalogue.
     *
     * @param id Id of the catalogue to edit
     */
    public static Result edit(Long id) {
    	Catalogue cat = Catalogue.find.byId(id);
    	Book book = Book.find.byId(cat.book.id);
        Form<Catalogue> catalogueForm = form(Catalogue.class).fill(
        		cat
        );        
        return ok(
        		editForm.render(id,cat.book.id,book.title, catalogueForm)
        );
    }
    /**
     * Handle catalogue deletion
     */
    public static Result delete(Long id) {
    	Long bookid = Catalogue.find.byId(id).book.id;
        Catalogue.find.ref(id).delete();
        flash("success", "Catalogue has been deleted");
        return redirect(
                routes.Catalogues.list(bookid,0, "status", "asc", "")
        );
    }
    /*
     * print barcodes of selected book
     * */
    public static Result printBarcodes(String barcodesText) {
    	String dir = Play.application().getFile("public/images/barcode").getAbsolutePath();
    	//String dir = System.getenv("PWD")+ "/public/images/barcode";

    	Logger.info("barcodepath1:"+dir);    	
    	
    	String[] barcodes = barcodesText.split(",");    	
    	for(int i =0; i < barcodes.length ; i++){
    		String barcode = barcodes[i];    		
    		BarcodePrinter.print(barcode,dir + "/"+barcode+".png");    		
    	}    	   
    	return ok(
			views.html.catalogues.barcodes.render(barcodes)
        );    	
    }
}
