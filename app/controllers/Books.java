package controllers;

import play.*;
import play.libs.Json;
import play.mvc.*;
import play.data.*;

import java.util.*;

import org.codehaus.jackson.JsonNode;

import models.*;

import views.html.*;
import views.html.books.*;


/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class Books extends Controller {
	/**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Books.list(0, "title", "asc", "")
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
    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            list.render(				
				Book.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
    /**
     * Display the 'new book form'.
     */
    public static Result create() {
        Form<Book> bookForm = form(Book.class);
        return ok(        		
            createForm.render(        		
        		bookForm        		
    		)
        );
    }
	
	 /**
     * Handle the 'new book form' submission 
     */
    public static Result save() {
    	/*
    	Map<String, String> newData = new HashMap<String, String>();
    	Map<String, String[]> urlFormEncoded = play.mvc.Controller.request().body().asFormUrlEncoded();
    	if (urlFormEncoded != null) {
	    	for (String key : urlFormEncoded.keySet()) {
		    	String[] value = urlFormEncoded.get(key);
		    	if (value.length == 1) {
		    		Logger.info(key+value[0]);
		    		newData.put(key, value[0]);
		    	} else if (value.length > 1) {
		    		for (int i = 0; i < value.length; i++) {
		    			newData.put(key + "[" + i + "].id", value[i]);
		    			Logger.info(key+value[i]);
		    		}
		    	}
	    	}
    	}
    	
        Form<Book> bookForm = form(Book.class).bindFromRequest();
    	//Form<Book> bookForm = new Form<Book>(Book.class).bind(newData);
        if(bookForm.hasErrors()) {
            return badRequest(createForm.render(            		
            		bookForm
        		));
        }
        Book b = bookForm.get();        
        //b.authors.add(Author.find.byId(Long.parseLong("1")));
        //b.authors.add(Author.find.byId(Long.parseLong("2")));
        Logger.info("tetile"+b.title);
        for(Author a:b.authors)
        {
        	Logger.info(a.id + " "+a.name);
        }
        b.save();
        */    	
    	String title = form().bindFromRequest().get("title");
    	if(title.isEmpty())
    		return badRequest("Please enter a title");
    	String publishert = form().bindFromRequest().get("publisher.id");
    	Long publisher = null;
    	if(!publishert.isEmpty())
    		publisher = Long.valueOf(publishert);
    	//if(publishert.isEmpty()) 
			//return badRequest("Please select publisher");
    	String publish_yeart = form().bindFromRequest().get("publish_year");
    	Long publish_year = null;
    	if(!publish_yeart.isEmpty())
    		publish_year = Long.valueOf(publish_yeart);
    	JsonNode json = Json.parse(form().bindFromRequest().get("author_ids"));		
		//if(json == null) 
			//return badRequest("Expecting author id");
		String isbn = form().bindFromRequest().get("isbn");
		int catalog = Integer.valueOf(form().bindFromRequest().get("catalogue_count"));	
		Book book = save(Long.valueOf(-1),title,publisher,json,publish_year,isbn,catalog);	
        flash("success", "Book " + book.title + " has been created");
        
        return GO_HOME;
    }
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the book to edit
     */
    public static Result update(Long id) {
    	String title = form().bindFromRequest().get("title");
    	if(title.isEmpty())
    		return badRequest("Please enter a title");
    	String publishert = form().bindFromRequest().get("publisher.id");
    	Long publisher = null;
    	if(!publishert.isEmpty())
    		publisher = Long.valueOf(publishert);
    	//if(publishert.isEmpty()) 
		//	return badRequest("Please select publisher");
    	String publish_yeart = form().bindFromRequest().get("publish_year");
    	Long publish_year = null;
    	if(!publish_yeart.isEmpty())
    		publish_year = Long.valueOf(publish_yeart);
    	JsonNode json = Json.parse(form().bindFromRequest().get("author_ids"));		
		//if(json == null) 
		//	return badRequest("Expecting author id");
		String isbn = form().bindFromRequest().get("isbn");
		int catalog = Integer.valueOf(form().bindFromRequest().get("catalogue_count"));	
		Book book = save(id,title,publisher,json,publish_year,isbn,catalog);	
        flash("success", "Book " + book.title + " has been updated");        
        
        return GO_HOME;
    }
    /**
     * Display the 'edit form' of a existing book.
     *
     * @param id Id of the book to edit
     */
    public static Result edit(Long id) {
    	Book book = Book.find.byId(id);
    	if(book==null)
    		return badRequest("Book not found");
    	//dont remove this line, or die
    	for(Author a:book.authors){
    		Logger.info(a.id+" "+a.name);
    	}
        Form<Book> bookForm = form(Book.class).fill(
    		book
        );
        return ok(
    		editForm.render(id, bookForm,book.authors)
        );
    }
    /**
     * Handle book deletion
     */
    public static Result delete(Long id) {
        Book.find.ref(id).delete();
        flash("success", "Book has been deleted");
        return GO_HOME;
    }
    public static Result createCatalogue(Long id) {
    	Form<Book> bookForm = form(Book.class).bindFromRequest();
        if(bookForm.hasErrors()) {
            return badRequest(editForm.render(id, bookForm,new HashSet<Author>()));
        }
        Catalogue.createCatalogue(Book.find.byId(id));
        flash("success", "Book " + bookForm.get().title + " catalogue has been updated");
        return GO_HOME;
    	
        
    }
    public static Book save(Long id,String title,Long publisherId,JsonNode author_ids,Long publish_year,String isbn,int catalogCount){
    	Book book;
    	if(id==Long.valueOf(-1)){
    		book = new Book();
    	}else
    	{
    		book = Book.find.setId(id).fetch("authors").findUnique();    		
    		book.authors.clear();    		
    	}
		if(author_ids!=null){
			StringBuilder sb = new StringBuilder();
			int n = author_ids.size();
			int i=0;
			for(JsonNode node: author_ids){	
				Author author = Author.find.ref(node.asLong());
				if(author!=null){
					book.authors.add(author);
					sb.append(author.name);
					if(i<(n-1)){
						sb.append(", ");
					}				
				}
				i++;
			}
			book.authors_text = sb.toString();
		}
		book.isbn = isbn;	
		book.publish_year = publish_year;
		book.catalogue_count = catalogCount;
		if(publisherId!=null){
			Publisher publisher = Publisher.find.byId(publisherId);
			if(publisher!=null){
				book.publisher =publisher;
				book.publisher_text = publisher.name;
			}
		}
		book.title = title;
		if(id==Long.valueOf(-1)){
			book.save();			
		}else
		{
			book.save();
			book.saveManyToManyAssociations("authors");
		}
		return book;
    	
    }
}

