package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.html.*;

public class Application extends Controller {
  
    // -- Authentication
    
    public static class Login {
        
        public String username;
        public String password;
        
        public String validate() {
            if(Userx.authenticate(username, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
        
    }

    /**
     * Login page.
     */
    public static Result login() {
        return ok(
            login.render(form(Login.class))
        );
    }
    
    /**
     * Handle login form submission.
     */
    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("username", loginForm.get().username);
            session("fullname", Userx.find.byId(loginForm.get().username).name);
            /*
            return redirect(
                //routes.Projects.index()
                routes.Library.index()
            );
            */
            return ok(dashboard.render());
        }
    }

    /**
     * Logout and clean the session.
     */
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
    }
  
    // -- Javascript routing
    
    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
            Routes.javascriptRouter("jsRoutes",
            
                // Routes for borrowing trans
                routes.javascript.TransBorrowing.getStudentInfo(),
                routes.javascript.TransBorrowing.getCatalogeInfo(),
                routes.javascript.TransBorrowing.save(),
                routes.javascript.TransBorrowing.getResumeInfo(),
                routes.javascript.TransBorrowing.getBorrowedCatalogue(),
                routes.javascript.TransBorrowing.getMaxBorrowedBook()
                
            )
        );
    }
    

}
