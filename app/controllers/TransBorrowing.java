package controllers;

import play.*;
import play.libs.Json;
import play.mvc.*;

import play.data.*;
import scala.util.parsing.json.JSON;
import static play.libs.Json.toJson;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonNode;

import models.*;
import viewmodels.BorrowedBook;
import viewmodels.BorrowedBookSaveData;
import views.html.*;
import views.html.transactions.*;


/**
 * Manage TransBorrowing related operations.
 */
@Security.Authenticated(Secured.class)
public class TransBorrowing extends Controller {
	public static Result index() {
        return ok(
            borrowing.render(				
            )
        );
    }	
	public static Result getStudentInfo(String nim){
		Student student = Student.findByNim(nim);
		if(student==null)
			return badRequest("Student not found");
		return ok(toJson(student));
	}
	/*
	 * input from barcode reader
	 * 1. cek apakah ada catalog sesuai barcode jika ya next
	 * 2. cek apakah buku telah dipinjam student sesuai nim 
	 * 	  jika ya go to 3 (BUKU SUDAH DIPINJAM)
	 * 		3. cek apakah buku telat dikembalikan(date>mustreturndate) jika ya tampilkan denda (buku telat bisa diperpanjang)
	 * 		4. cek apakah renewalcount<maxrenewalcount 
	 * 			jika ya cek masih ingin diperpanjang jika
	 * 				ya : set renewal date n renewal count n must return date
	 * 				tidak : set return date -> status:buku dikembalikan
	 * 			jika tidak set return date 	-> status:buku dikembalikan
	 *    jika tidak go to 5 (BUKU BLOM DIPINJAM)
	 *    	5. set borrowdate n mustreturndate
	 * 
	 * */	
	public static Result getCatalogeInfo(String barcode,Long studentId){
		Catalogue cat = Catalogue.findByBarcode(barcode);
		if(cat==null)
			return badRequest("Catalogue not found");
		if(!cat.status.id.equals(new Long(1))){
			return badRequest("Catalogue not available");
		}
		
		Book book = cat.book;		
		BorrowedBook borrowed = new BorrowedBook();
		borrowed.title = book.title;
		borrowed.author = book.authors_text;
		borrowed.catalogId = cat.id;
		
		DateFormat formatter = new SimpleDateFormat(LibraryConfig.dateFormat());
		Borrowing trans = Borrowing.getBorrowedCatalogue(cat.id);
				
		Date today = Calendar.getInstance().getTime();  
		if(trans == null){//blom dipinjam	
			if(Borrowing.hasReachedMaxBorrowedBookLimit(studentId)){
				return badRequest("This student already borrowed: "+LibraryConfig.maxBorrowedBook()+" books");
			}
			borrowed.borrowDate = formatter.format(today);						
			borrowed.fine = 0;
			Calendar cal = Calendar.getInstance();		
			cal.add(Calendar.DATE, LibraryConfig.maxBorrowingDay());			
			borrowed.mustReturnDate = formatter.format(cal.getTime());
			borrowed.renewalDate = "";
			borrowed.action = "remove";
			borrowed.status = "newbook";
		}else{//buku sudah dipinjam
			if(!trans.student.id.equals(studentId)){
				return badRequest("This book is borrowed by :"+trans.student.nim+" "+trans.student.name);
			}
			
			borrowed.borrowDate = formatter.format(trans.borrowDate);
			borrowed.catalogId = trans.catalogue.id;
			
			//cek keterlambatan						
			Date mustReturnDate = trans.mustReturnDate;
			borrowed.mustReturnDate = formatter.format(mustReturnDate);			
			//mustReturnDate.compareTo(arg0)						
			borrowed.fine = Borrowing.calculateFine(mustReturnDate);
			//cek perpanjangan
			borrowed.renewalCount = trans.renewalCount;
			if(trans.returnDate!=null)
				borrowed.renewalDate = formatter.format(trans.returnDate);			
			else
				borrowed.renewalDate = "";
			if(trans.renewalCount<LibraryConfig.maxRenewalCount()){
				borrowed.action = "renew";
			}else
			{
				borrowed.action = "return";
			}
			borrowed.status = "booked";
		}
		return ok(toJson(borrowed));
	}
	public static Result getResumeInfo(Long catId){
		Borrowing resume = Borrowing.getResumeInfo(catId);
		if(resume==null)
			return badRequest("Catalogue not available");
		DateFormat formatter = new SimpleDateFormat(LibraryConfig.dateFormat());
		BorrowedBook borrowed = new BorrowedBook();
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, LibraryConfig.maxBorrowingDay());			
		borrowed.mustReturnDate = formatter.format(resume.mustReturnDate);
		borrowed.renewalDate = formatter.format(resume.renewalDate);
		borrowed.renewalCount = resume.renewalCount;
		return ok(toJson(borrowed));
	}
	public static Result save(Long studentId){
		Userx user = Userx.findByUsername(session("username"));
		if(user==null)
			return badRequest("User not found");
		
		Student student = Student.find.byId(studentId);
		if(student==null)
			return badRequest("Student not found");
		
		Date today = Calendar.getInstance().getTime();
		
		JsonNode json = Json.parse(form().bindFromRequest().get("books"));		
		if(json == null) {
			return badRequest("Expecting Json data");
		} else {			
			for(JsonNode node: json){
				String status = node.findPath("status").getTextValue();				
				Long catId = node.findPath("catalogId").getLongValue();
				
				Catalogue cat = Catalogue.find.byId(catId);
				if(cat==null){
					return badRequest("catalog "+catId+" not found");
				}
				String booktitle = cat.book.title;
				if(status.equals("new")){			
					if(Borrowing.hasReachedMaxBorrowedBookLimit(studentId)){
						return badRequest("This student already borrowed: "+LibraryConfig.maxBorrowedBook()+" books");
					}
					Borrowing newtrans = Borrowing.New(user,student,cat);
					if(newtrans==null)
						return badRequest("Error saving book: "+booktitle);
				}else if(status.equals("resume")){					
					//checking
					Borrowing resumetrans = Borrowing.getBorrowedCatalogue(catId);
					if(resumetrans==null){
						return badRequest("Could not find borrowed book: "+booktitle);
					}
					if(!resumetrans.student.id.equals(studentId)){
						return badRequest("This book is borrowed by :"+resumetrans.student.nim+ " "+resumetrans.student.name);
					}
					int maxRenewalCount = LibraryConfig.maxRenewalCount();
					if(resumetrans.renewalCount>maxRenewalCount){
						return badRequest("This book:"+booktitle+" has been borrowed "+maxRenewalCount);
					}
					resumetrans = Borrowing.Resume(resumetrans.id,user);
					if(resumetrans==null)
						return badRequest("Error saving book: "+booktitle);														
				}else if(status.equals("return")){	
					//checking
					Borrowing returntrans = Borrowing.getBorrowedCatalogue(catId);
					if(returntrans==null){
						return badRequest("Could not find borrowed book: "+booktitle);
					}
					if(!returntrans.student.id.equals(studentId)){
						return badRequest("This book is borrowed by :"+returntrans.student.nim+" "+returntrans.student.name);
					}
					returntrans = Borrowing.Return(returntrans.id,user);
					if(returntrans==null)
						return badRequest("Error saving book: "+booktitle);
				}
			}			
		}
		return ok();
	}
	public static Result getBorrowedCatalogue(Long studentId){
		List<BorrowedBook> result = new ArrayList<BorrowedBook>();
		List<Borrowing> borrowedTrans = Borrowing.getBorrowedCatalogueByStudent(studentId);
		if(borrowedTrans!=null){
			DateFormat formatter = new SimpleDateFormat(LibraryConfig.dateFormat());
			for(Borrowing item:borrowedTrans){
				Book book = item.catalogue.book;
				BorrowedBook borrowed = new BorrowedBook();		
				borrowed.action = "";
				borrowed.author = book.authors_text;
				borrowed.borrowDate = formatter.format(item.borrowDate);
				borrowed.catalogId = item.catalogue.id;
				borrowed.fine = 0;
				borrowed.mustReturnDate = formatter.format(item.mustReturnDate);
				borrowed.renewalCount = item.renewalCount;
				if(item.renewalDate!=null)
					borrowed.renewalDate = formatter.format(item.renewalDate);
				else
					borrowed.renewalDate = "";
				borrowed.status = "borrowed";
				borrowed.title = book.title;
				result.add(borrowed);
			}
		}
		return ok(toJson(result)); 
	}
	public static Result getMaxBorrowedBook(){
		return ok(toJson(LibraryConfig.maxBorrowedBook()));
	}
	
}

 