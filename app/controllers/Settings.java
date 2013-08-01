package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;
import views.html.settings.*;
import views.html.students.createForm;
import play.Logger;
import viewmodels.SettingsForm;
@Security.Authenticated(Secured.class)
public class Settings extends Controller {
	
	public static Result GO_HOME = redirect(
	        routes.Settings.index()
	    );
    /**
     * Display the dashboard.
     */
    public static Result index() {
    	Form<SettingsForm> sf = form(SettingsForm.class);
    	SettingsForm settings = new SettingsForm();    	
        return ok(
            editForm.render(
            		sf.fill(settings.getData())
            )
        );
    }
    public static Result save() {
    	Form<SettingsForm> sf = form(SettingsForm.class).bindFromRequest();
        if(sf.hasErrors()) {
            return badRequest(editForm.render(            		
            		sf
        		));
        }
        sf.get().save();
        flash("success", "Settings has been updated");
        return GO_HOME;
    }
    public static Result generateCataloguesCode(){
    	List<Book> books = Book.find.all();
    	for(Book book:books){
    		 Catalogue.createCatalogue(book);
    	}
    	flash("success", "Barcodes generated");
        return GO_HOME;
    }
}
