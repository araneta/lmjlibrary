package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * User entity managed by Ebean
 */
@Entity 
//@Table(name="account")
public class Userx extends Model {

    @Id
    @Constraints.Required
    @Formats.NonEmpty
    public String username;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String password;
    
    // -- Queries
    
    public static Model.Finder<String,Userx> find = new Model.Finder(String.class, Userx.class);
    
    /**
     * Retrieve all users.
     */
    public static List<Userx> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from username.
     */
    public static Userx findByUsername(String username) {
        return find.where().eq("username", username).findUnique();
    }
    
    /**
     * Authenticate a User.
     */
    public static Userx authenticate(String username, String password) {
        return find.where()
            .eq("username", username)
            .eq("password", password)
            .findUnique();
    }
    
    // --
    
    public String toString() {
        return "User(" + username + ")";
    }

}

