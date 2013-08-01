package viewmodels;
import models.Author;
import play.data.*;
import play.data.format.*;
import play.data.validation.Constraints.*;

public class BookAuthor {
	@Required
	public String id;
	@Required
	public String label;
	@Required
	public String value;
	public BookAuthor(Author a){
		this.id = String.valueOf(a.id);
		this.label = a.name;
		this.value = a.name;		
	}
}
