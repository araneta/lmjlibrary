package controllers;
import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;
import java.io.File;
@Security.Authenticated(Secured.class)
public class BarcodeImages extends Controller{
	 static String path = "/public/images/barcode/";
     public static Result getFile(String file){
            File myfile = new File (System.getenv("PWD")+path+file);
            return ok(myfile);
     }
}
