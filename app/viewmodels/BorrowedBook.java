package viewmodels;
import java.util.Date;


public class BorrowedBook {
	//public String barcode;
	public Long catalogId;
	public String title;
	public String author;
	public String borrowDate;        
    public String mustReturnDate;
    public String renewalDate;
    //public Date returnDate;    
    public int renewalCount=0;
    public long fine=0;
    public String action;
    public String status;
}
