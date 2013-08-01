package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;
import views.html.publishers.*;

/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class Publishers extends Controller {
	/**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Publishers.list(0, "name", "asc", "")
    );
    /**
     * Display the dashboard.
     */
    public static Result index() {
        return ok(
            dashboard.render(				
            )
        );
    }
    
    /**
     * Display the 'new publisher form'.
     */
    public static Result create() {
        Form<Publisher> publisherForm = form(Publisher.class);
        return ok(        		
            createForm.render(        		
        		publisherForm
    		)
        );
    }
	public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            list.render(				
                Publisher.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
	 /**
     * Handle the 'new publisher form' submission 
     */
    public static Result save() {
        Form<Publisher> publisherForm = form(Publisher.class).bindFromRequest();
        if(publisherForm.hasErrors()) {
            return badRequest(createForm.render(            		
            		publisherForm
        		));
        }
        publisherForm.get().save();
        flash("success", "Publisher " + publisherForm.get().name + " has been created");
        return GO_HOME;
    }
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the publisher to edit
     */
    public static Result update(Long id) {
        Form<Publisher> publisherForm = form(Publisher.class).bindFromRequest();
        if(publisherForm.hasErrors()) {
            return badRequest(editForm.render(id, publisherForm));
        }
        publisherForm.get().update(id);
        flash("success", "Publisher " + publisherForm.get().name + " has been updated");
        return GO_HOME;
    }
    /**
     * Display the 'edit form' of a existing publisher.
     *
     * @param id Id of the publisher to edit
     */
    public static Result edit(Long id) {
        Form<Publisher> publisherForm = form(Publisher.class).fill(
        		Publisher.find.byId(id)
        );
        return ok(
        		editForm.render(id, publisherForm)
        );
    }
    /**
     * Handle book deletion
     */
    public static Result delete(Long id) {
    	Publisher.find.ref(id).delete();
        flash("success", "Publisher has been deleted");
        return GO_HOME;
    }
}

