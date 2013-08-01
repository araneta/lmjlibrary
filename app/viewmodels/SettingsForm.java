package viewmodels;
import models.LibraryConfig;
import play.data.*;
import play.data.format.*;
import play.data.validation.Constraints.*;

public class SettingsForm {
	@Required
	public int maxBorrowingDay;
	@Required
	public int finePerDay;
	@Required
	public int maxRenewalCount;
	@Required
	public String dateFormat;
	@Required
	public int maxBorrowedBook;
	public SettingsForm save(){
		LibraryConfig.set("maxBorrowingDay", String.valueOf(maxBorrowingDay));
		LibraryConfig.set("finePerDay", String.valueOf(finePerDay));
		LibraryConfig.set("maxRenewalCount", String.valueOf(maxRenewalCount));
		LibraryConfig.set("dateFormat", dateFormat);
		LibraryConfig.set("maxBorrowedBook", String.valueOf(maxBorrowedBook));
		return getData();
	}
	public SettingsForm getData(){
		SettingsForm settings = new SettingsForm();
    	settings.dateFormat = LibraryConfig.dateFormat();
    	settings.finePerDay = LibraryConfig.finePerDay();
    	settings.maxBorrowedBook = LibraryConfig.maxBorrowedBook();
    	settings.maxRenewalCount = LibraryConfig.maxRenewalCount();
    	settings.maxBorrowingDay = LibraryConfig.maxBorrowingDay();
    	return settings;
	}
}
