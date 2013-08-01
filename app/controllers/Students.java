package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;
import views.html.students.*;

/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class Students extends Controller {
	/**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Students.list(0, "name", "asc", "")
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
     * Display the 'new student form'.
     */
    public static Result create() {
        Form<Student> studentForm = form(Student.class);
        return ok(        		
            createForm.render(        		
        		studentForm
    		)
        );
    }
	public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
            list.render(				
                Student.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
	 /**
     * Handle the 'new student form' submission 
     */
    public static Result save() {
        Form<Student> studentForm = form(Student.class).bindFromRequest();
        if(studentForm.hasErrors()) {
            return badRequest(createForm.render(            		
            		studentForm
        		));
        }
        studentForm.get().save();
        flash("success", "Student " + studentForm.get().name + " has been created");
        return GO_HOME;
    }
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the student to edit
     */
    public static Result update(Long id) {
        Form<Student> studentForm = form(Student.class).bindFromRequest();
        if(studentForm.hasErrors()) {
            return badRequest(editForm.render(id, studentForm));
        }
        studentForm.get().update(id);
        flash("success", "Student " + studentForm.get().name + " has been updated");
        return GO_HOME;
    }
    /**
     * Display the 'edit form' of a existing student.
     *
     * @param id Id of the student to edit
     */
    public static Result edit(Long id) {
        Form<Student> studentForm = form(Student.class).fill(
        		Student.find.byId(id)
        );
        return ok(
        		editForm.render(id, studentForm)
        );
    }
    /**
     * Handle book deletion
     */
    public static Result delete(Long id) {
    	Student.find.ref(id).delete();
        flash("success", "Student has been deleted");
        return GO_HOME;
    }
}

