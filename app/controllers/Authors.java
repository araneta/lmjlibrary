package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.libs.Json;
import scala.util.parsing.json.JSON;
import static play.libs.Json.toJson;
import java.util.*;

import models.*;
import org.codehaus.jackson.JsonNode;
import views.html.*;
import views.html.authors.*;
import viewmodels.BookAuthor;
/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class Authors extends Controller {
	/**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Authors.list(0, "name", "asc", "")
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
     * Display the 'new author form'.
     */
    public static Result create() {
        Form<Author> authorForm = form(Author.class);
        return ok(        		
            createForm.render(        		
        		authorForm
    		)
        );
    }
	public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            list.render(				
                Author.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
	 /**
     * Handle the 'new author form' submission 
     */
    public static Result save() {
        Form<Author> authorForm = form(Author.class).bindFromRequest();
        if(authorForm.hasErrors()) {
            return badRequest(createForm.render(            		
            		authorForm
        		));
        }
        authorForm.get().save();
        flash("success", "Author " + authorForm.get().name + " has been created");
        return GO_HOME;
    }
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the author to edit
     */
    public static Result update(Long id) {
        Form<Author> authorForm = form(Author.class).bindFromRequest();
        if(authorForm.hasErrors()) {
            return badRequest(editForm.render(id, authorForm));
        }
        authorForm.get().update(id);
        flash("success", "Author " + authorForm.get().name + " has been updated");
        return GO_HOME;
    }
    /**
     * Display the 'edit form' of a existing author.
     *
     * @param id Id of the author to edit
     */
    public static Result edit(Long id) {
        Form<Author> authorForm = form(Author.class).fill(
        		Author.find.byId(id)
        );
        return ok(
        		editForm.render(id, authorForm)
        );
    }
    /**
     * Handle book deletion
     */
    public static Result delete(Long id) {
    	Author.find.ref(id).delete();
        flash("success", "Author has been deleted");
        return GO_HOME;
    }
    
    public static Result listajax() {
    	String term = form().bindFromRequest().get("term");
    	StringBuilder sb = new StringBuilder();
    	sb.append("%");
    	sb.append(term);
    	sb.append("%");
    	List<BookAuthor> lba = new ArrayList<BookAuthor>(); 
    	List<Author> authors = Author.find.where()
        .ilike("name", sb.toString())
        .findList();
    	if(authors!=null){
    		for(Author a:authors){    			
    			lba.add(new BookAuthor(a));
    		}
    	}
        return ok(
            toJson(lba)
        );
    }
}

