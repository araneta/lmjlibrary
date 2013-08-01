// @SOURCE:/media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/conf/routes
// @HASH:c419daf57e55c302ff5497e4b7d15e2e6e13b76b
// @DATE:Fri Dec 28 19:06:25 WIT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:96
// @LINE:94
// @LINE:92
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:59
// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:96
class ReverseAssets {
    


 
// @LINE:96
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            

// @LINE:81
// @LINE:80
// @LINE:79
class ReverseSettings {
    


 
// @LINE:81
def generateCataloguesCode() = {
   Call("GET", "/settings/generatecatscode")
}
                                                        
 
// @LINE:80
def save() = {
   Call("POST", "/settings/save")
}
                                                        
 
// @LINE:79
def index() = {
   Call("GET", "/settings")
}
                                                        

                      
    
}
                            

// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
class ReverseBooks {
    


 
// @LINE:35
def delete(id:Long) = {
   Call("POST", "/books/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                        
 
// @LINE:29
def create() = {
   Call("GET", "/books/new")
}
                                                        
 
// @LINE:27
def list(p:Int = 0, s:String = "title", o:String = "asc", f:String = "") = {
   Call("GET", "/books" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == "title") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:33
def update(id:Long) = {
   Call("POST", "/books/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:30
def save() = {
   Call("POST", "/books")
}
                                                        
 
// @LINE:32
def edit(id:Long) = {
   Call("GET", "/books/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
class ReverseTransBorrowing {
    


 
// @LINE:71
def getStudentInfo(nim:String) = {
   Call("GET", "/borrowing/studentinfo/" + implicitly[PathBindable[String]].unbind("nim", nim))
}
                                                        
 
// @LINE:73
def save(studentId:Long) = {
   Call("POST", "/borrowing/save/" + implicitly[PathBindable[Long]].unbind("studentId", studentId))
}
                                                        
 
// @LINE:76
def getMaxBorrowedBook() = {
   Call("GET", "/borrowing/maxborrowedbook")
}
                                                        
 
// @LINE:75
def getBorrowedCatalogue(studentId:Long) = {
   Call("GET", "/borrowing/borrowedcatalogue/" + implicitly[PathBindable[Long]].unbind("studentId", studentId))
}
                                                        
 
// @LINE:70
def index() = {
   Call("GET", "/borrowing")
}
                                                        
 
// @LINE:72
def getCatalogeInfo(barcode:String, studentid:Long) = {
   Call("GET", "/borrowing/cataloginfo/" + implicitly[PathBindable[String]].unbind("barcode", barcode) + "/" + implicitly[PathBindable[Long]].unbind("studentid", studentid))
}
                                                        
 
// @LINE:74
def getResumeInfo(catId:Long) = {
   Call("GET", "/borrowing/resumeinfo/" + implicitly[PathBindable[Long]].unbind("catId", catId))
}
                                                        

                      
    
}
                            

// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:59
class ReverseStudents {
    


 
// @LINE:67
def delete(id:Long) = {
   Call("POST", "/students/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                        
 
// @LINE:61
def create() = {
   Call("GET", "/students/new")
}
                                                        
 
// @LINE:59
def list(p:Int = 0, s:String = "name", o:String = "asc", f:String = "") = {
   Call("GET", "/students" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == "name") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:65
def update(id:Long) = {
   Call("POST", "/students/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:62
def save() = {
   Call("POST", "/students")
}
                                                        
 
// @LINE:64
def edit(id:Long) = {
   Call("GET", "/students/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseLibrary {
    


 
// @LINE:7
// @LINE:6
def search(p:Int = 0, f:String = "", fb:String = "", s:String, o:String) = {
   (p, f, fb, s, o) match {
// @LINE:6
case (p, f, fb, s, o) if true => Call("GET", "/" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)), if(fb == "") None else Some(implicitly[QueryStringBindable[String]].unbind("fb", fb)), if(s == "") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)))))
                                                                
// @LINE:7
case (p, f, fb, s, o) if true => Call("GET", "/search" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)), if(fb == "") None else Some(implicitly[QueryStringBindable[String]].unbind("fb", fb)), if(s == "title") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)))))
                                                                    
   }
}
                                                        
 
// @LINE:8
def details(id:Long) = {
   Call("GET", "/details/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
class ReverseReports {
    


 
// @LINE:89
def listOverdueBooks() = {
   Call("GET", "/report/ajax/overduebook")
}
                                                        
 
// @LINE:85
def listBorrowedBooks() = {
   Call("GET", "/report/ajax/borrowedbook")
}
                                                        
 
// @LINE:87
def listReturnedBooks() = {
   Call("GET", "/report/ajax/returnedbook")
}
                                                        
 
// @LINE:88
def overdueBooks() = {
   Call("GET", "/report/overduebooks")
}
                                                        
 
// @LINE:86
def returnedBooks() = {
   Call("GET", "/report/returnedbooks")
}
                                                        
 
// @LINE:84
def borrowedBooks() = {
   Call("GET", "/report/borrowedbooks")
}
                                                        

                      
    
}
                            

// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseCatalogues {
    


 
// @LINE:38
def list(bookid:Long, p:Int = 0, s:String = "barcode", o:String = "asc", f:String = "") = {
   Call("GET", "/catalogues/" + implicitly[PathBindable[Long]].unbind("bookid", bookid) + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == "barcode") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:39
def create(bookid:Long) = {
   Call("GET", "/catalogues/new/" + implicitly[PathBindable[Long]].unbind("bookid", bookid))
}
                                                        
 
// @LINE:46
def printBarcodes(barcodestext:String) = {
   Call("GET", "/catalogues/printbarcodes/" + implicitly[PathBindable[String]].unbind("barcodestext", barcodestext))
}
                                                        
 
// @LINE:40
def save(bookid:Long) = {
   Call("POST", "/catalogues/" + implicitly[PathBindable[Long]].unbind("bookid", bookid))
}
                                                        
 
// @LINE:43
def update(id:Long, bookid:Long) = {
   Call("POST", "/catalogues/" + implicitly[PathBindable[Long]].unbind("id", id) + "/" + implicitly[PathBindable[Long]].unbind("bookid", bookid) + "/update")
}
                                                        
 
// @LINE:45
def delete(id:Long) = {
   Call("POST", "/catalogues/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                        
 
// @LINE:42
def edit(id:Long) = {
   Call("GET", "/catalogues/" + implicitly[PathBindable[Long]].unbind("id", id) + "/edit")
}
                                                        

                      
    
}
                            

// @LINE:92
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseApplication {
    


 
// @LINE:12
def authenticate() = {
   Call("POST", "/login")
}
                                                        
 
// @LINE:13
def logout() = {
   Call("GET", "/logout")
}
                                                        
 
// @LINE:11
def login() = {
   Call("GET", "/login")
}
                                                        
 
// @LINE:92
def javascriptRoutes() = {
   Call("GET", "/javascriptRoutes")
}
                                                        

                      
    
}
                            

// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
class ReversePublishers {
    


 
// @LINE:24
def delete(id:Long) = {
   Call("POST", "/publishers/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                        
 
// @LINE:18
def create() = {
   Call("GET", "/publishers/new")
}
                                                        
 
// @LINE:16
def list(p:Int = 0, s:String = "name", o:String = "asc", f:String = "") = {
   Call("GET", "/publishers" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == "name") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:22
def update(id:Long) = {
   Call("POST", "/publishers/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:19
def save() = {
   Call("POST", "/publishers")
}
                                                        
 
// @LINE:21
def edit(id:Long) = {
   Call("GET", "/publishers/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseAuthors {
    


 
// @LINE:57
def delete(id:Long) = {
   Call("POST", "/authors/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                        
 
// @LINE:51
def create() = {
   Call("GET", "/authors/new")
}
                                                        
 
// @LINE:49
def list(p:Int = 0, s:String = "name", o:String = "asc", f:String = "") = {
   Call("GET", "/authors" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == "name") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:55
def update(id:Long) = {
   Call("POST", "/authors/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:52
def save() = {
   Call("POST", "/authors")
}
                                                        
 
// @LINE:54
def edit(id:Long) = {
   Call("GET", "/authors/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:50
def listajax() = {
   Call("GET", "/ajax/authors")
}
                                                        

                      
    
}
                            

// @LINE:94
class ReverseBarcodeImages {
    


 
// @LINE:94
def getFile(file:String) = {
   Call("GET", "/files/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:96
// @LINE:94
// @LINE:92
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:59
// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:96
class ReverseAssets {
    


 
// @LINE:96
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:81
// @LINE:80
// @LINE:79
class ReverseSettings {
    


 
// @LINE:81
def generateCataloguesCode = JavascriptReverseRoute(
   "controllers.Settings.generateCataloguesCode",
   """
      function() {
      return _wA({method:"GET", url:"/settings/generatecatscode"})
      }
   """
)
                                                        
 
// @LINE:80
def save = JavascriptReverseRoute(
   "controllers.Settings.save",
   """
      function() {
      return _wA({method:"POST", url:"/settings/save"})
      }
   """
)
                                                        
 
// @LINE:79
def index = JavascriptReverseRoute(
   "controllers.Settings.index",
   """
      function() {
      return _wA({method:"GET", url:"/settings"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
class ReverseBooks {
    


 
// @LINE:35
def delete = JavascriptReverseRoute(
   "controllers.Books.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"/books/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:29
def create = JavascriptReverseRoute(
   "controllers.Books.create",
   """
      function() {
      return _wA({method:"GET", url:"/books/new"})
      }
   """
)
                                                        
 
// @LINE:27
def list = JavascriptReverseRoute(
   "controllers.Books.list",
   """
      function(p,s,o,f) {
      return _wA({method:"GET", url:"/books" + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == null ? """ +  implicitly[JavascriptLitteral[String]].to("title") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == null ? """ +  implicitly[JavascriptLitteral[String]].to("asc") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:33
def update = JavascriptReverseRoute(
   "controllers.Books.update",
   """
      function(id) {
      return _wA({method:"POST", url:"/books/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:30
def save = JavascriptReverseRoute(
   "controllers.Books.save",
   """
      function() {
      return _wA({method:"POST", url:"/books"})
      }
   """
)
                                                        
 
// @LINE:32
def edit = JavascriptReverseRoute(
   "controllers.Books.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/books/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
class ReverseTransBorrowing {
    


 
// @LINE:71
def getStudentInfo = JavascriptReverseRoute(
   "controllers.TransBorrowing.getStudentInfo",
   """
      function(nim) {
      return _wA({method:"GET", url:"/borrowing/studentinfo/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nim", nim)})
      }
   """
)
                                                        
 
// @LINE:73
def save = JavascriptReverseRoute(
   "controllers.TransBorrowing.save",
   """
      function(studentId) {
      return _wA({method:"POST", url:"/borrowing/save/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("studentId", studentId)})
      }
   """
)
                                                        
 
// @LINE:76
def getMaxBorrowedBook = JavascriptReverseRoute(
   "controllers.TransBorrowing.getMaxBorrowedBook",
   """
      function() {
      return _wA({method:"GET", url:"/borrowing/maxborrowedbook"})
      }
   """
)
                                                        
 
// @LINE:75
def getBorrowedCatalogue = JavascriptReverseRoute(
   "controllers.TransBorrowing.getBorrowedCatalogue",
   """
      function(studentId) {
      return _wA({method:"GET", url:"/borrowing/borrowedcatalogue/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("studentId", studentId)})
      }
   """
)
                                                        
 
// @LINE:70
def index = JavascriptReverseRoute(
   "controllers.TransBorrowing.index",
   """
      function() {
      return _wA({method:"GET", url:"/borrowing"})
      }
   """
)
                                                        
 
// @LINE:72
def getCatalogeInfo = JavascriptReverseRoute(
   "controllers.TransBorrowing.getCatalogeInfo",
   """
      function(barcode,studentid) {
      return _wA({method:"GET", url:"/borrowing/cataloginfo/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("barcode", barcode) + "/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("studentid", studentid)})
      }
   """
)
                                                        
 
// @LINE:74
def getResumeInfo = JavascriptReverseRoute(
   "controllers.TransBorrowing.getResumeInfo",
   """
      function(catId) {
      return _wA({method:"GET", url:"/borrowing/resumeinfo/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("catId", catId)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:59
class ReverseStudents {
    


 
// @LINE:67
def delete = JavascriptReverseRoute(
   "controllers.Students.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"/students/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:61
def create = JavascriptReverseRoute(
   "controllers.Students.create",
   """
      function() {
      return _wA({method:"GET", url:"/students/new"})
      }
   """
)
                                                        
 
// @LINE:59
def list = JavascriptReverseRoute(
   "controllers.Students.list",
   """
      function(p,s,o,f) {
      return _wA({method:"GET", url:"/students" + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == null ? """ +  implicitly[JavascriptLitteral[String]].to("name") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == null ? """ +  implicitly[JavascriptLitteral[String]].to("asc") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:65
def update = JavascriptReverseRoute(
   "controllers.Students.update",
   """
      function(id) {
      return _wA({method:"POST", url:"/students/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:62
def save = JavascriptReverseRoute(
   "controllers.Students.save",
   """
      function() {
      return _wA({method:"POST", url:"/students"})
      }
   """
)
                                                        
 
// @LINE:64
def edit = JavascriptReverseRoute(
   "controllers.Students.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/students/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseLibrary {
    


 
// @LINE:7
// @LINE:6
def search = JavascriptReverseRoute(
   "controllers.Library.search",
   """
      function(p, f, fb, s, o) {
      if (true) {
      return _wA({method:"GET", url:"/" + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f)), (fb == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fb", fb)), (s == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o))])})
      }
      if (true) {
      return _wA({method:"GET", url:"/search" + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f)), (fb == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fb", fb)), (s == null ? """ +  implicitly[JavascriptLitteral[String]].to("title") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == null ? """ +  implicitly[JavascriptLitteral[String]].to("asc") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o))])})
      }
      }
   """
)
                                                        
 
// @LINE:8
def details = JavascriptReverseRoute(
   "controllers.Library.details",
   """
      function(id) {
      return _wA({method:"GET", url:"/details/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
class ReverseReports {
    


 
// @LINE:89
def listOverdueBooks = JavascriptReverseRoute(
   "controllers.Reports.listOverdueBooks",
   """
      function() {
      return _wA({method:"GET", url:"/report/ajax/overduebook"})
      }
   """
)
                                                        
 
// @LINE:85
def listBorrowedBooks = JavascriptReverseRoute(
   "controllers.Reports.listBorrowedBooks",
   """
      function() {
      return _wA({method:"GET", url:"/report/ajax/borrowedbook"})
      }
   """
)
                                                        
 
// @LINE:87
def listReturnedBooks = JavascriptReverseRoute(
   "controllers.Reports.listReturnedBooks",
   """
      function() {
      return _wA({method:"GET", url:"/report/ajax/returnedbook"})
      }
   """
)
                                                        
 
// @LINE:88
def overdueBooks = JavascriptReverseRoute(
   "controllers.Reports.overdueBooks",
   """
      function() {
      return _wA({method:"GET", url:"/report/overduebooks"})
      }
   """
)
                                                        
 
// @LINE:86
def returnedBooks = JavascriptReverseRoute(
   "controllers.Reports.returnedBooks",
   """
      function() {
      return _wA({method:"GET", url:"/report/returnedbooks"})
      }
   """
)
                                                        
 
// @LINE:84
def borrowedBooks = JavascriptReverseRoute(
   "controllers.Reports.borrowedBooks",
   """
      function() {
      return _wA({method:"GET", url:"/report/borrowedbooks"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseCatalogues {
    


 
// @LINE:38
def list = JavascriptReverseRoute(
   "controllers.Catalogues.list",
   """
      function(bookid,p,s,o,f) {
      return _wA({method:"GET", url:"/catalogues/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("bookid", bookid) + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == null ? """ +  implicitly[JavascriptLitteral[String]].to("barcode") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == null ? """ +  implicitly[JavascriptLitteral[String]].to("asc") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:39
def create = JavascriptReverseRoute(
   "controllers.Catalogues.create",
   """
      function(bookid) {
      return _wA({method:"GET", url:"/catalogues/new/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("bookid", bookid)})
      }
   """
)
                                                        
 
// @LINE:46
def printBarcodes = JavascriptReverseRoute(
   "controllers.Catalogues.printBarcodes",
   """
      function(barcodestext) {
      return _wA({method:"GET", url:"/catalogues/printbarcodes/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("barcodestext", barcodestext)})
      }
   """
)
                                                        
 
// @LINE:40
def save = JavascriptReverseRoute(
   "controllers.Catalogues.save",
   """
      function(bookid) {
      return _wA({method:"POST", url:"/catalogues/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("bookid", bookid)})
      }
   """
)
                                                        
 
// @LINE:43
def update = JavascriptReverseRoute(
   "controllers.Catalogues.update",
   """
      function(id,bookid) {
      return _wA({method:"POST", url:"/catalogues/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("bookid", bookid) + "/update"})
      }
   """
)
                                                        
 
// @LINE:45
def delete = JavascriptReverseRoute(
   "controllers.Catalogues.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"/catalogues/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:42
def edit = JavascriptReverseRoute(
   "controllers.Catalogues.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/catalogues/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/edit"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:92
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseApplication {
    


 
// @LINE:12
def authenticate = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"/login"})
      }
   """
)
                                                        
 
// @LINE:13
def logout = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"/logout"})
      }
   """
)
                                                        
 
// @LINE:11
def login = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"/login"})
      }
   """
)
                                                        
 
// @LINE:92
def javascriptRoutes = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"/javascriptRoutes"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
class ReversePublishers {
    


 
// @LINE:24
def delete = JavascriptReverseRoute(
   "controllers.Publishers.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"/publishers/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:18
def create = JavascriptReverseRoute(
   "controllers.Publishers.create",
   """
      function() {
      return _wA({method:"GET", url:"/publishers/new"})
      }
   """
)
                                                        
 
// @LINE:16
def list = JavascriptReverseRoute(
   "controllers.Publishers.list",
   """
      function(p,s,o,f) {
      return _wA({method:"GET", url:"/publishers" + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == null ? """ +  implicitly[JavascriptLitteral[String]].to("name") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == null ? """ +  implicitly[JavascriptLitteral[String]].to("asc") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:22
def update = JavascriptReverseRoute(
   "controllers.Publishers.update",
   """
      function(id) {
      return _wA({method:"POST", url:"/publishers/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:19
def save = JavascriptReverseRoute(
   "controllers.Publishers.save",
   """
      function() {
      return _wA({method:"POST", url:"/publishers"})
      }
   """
)
                                                        
 
// @LINE:21
def edit = JavascriptReverseRoute(
   "controllers.Publishers.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/publishers/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseAuthors {
    


 
// @LINE:57
def delete = JavascriptReverseRoute(
   "controllers.Authors.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"/authors/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:51
def create = JavascriptReverseRoute(
   "controllers.Authors.create",
   """
      function() {
      return _wA({method:"GET", url:"/authors/new"})
      }
   """
)
                                                        
 
// @LINE:49
def list = JavascriptReverseRoute(
   "controllers.Authors.list",
   """
      function(p,s,o,f) {
      return _wA({method:"GET", url:"/authors" + _qS([(p == null ? """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == null ? """ +  implicitly[JavascriptLitteral[String]].to("name") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == null ? """ +  implicitly[JavascriptLitteral[String]].to("asc") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o)), (f == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:55
def update = JavascriptReverseRoute(
   "controllers.Authors.update",
   """
      function(id) {
      return _wA({method:"POST", url:"/authors/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:52
def save = JavascriptReverseRoute(
   "controllers.Authors.save",
   """
      function() {
      return _wA({method:"POST", url:"/authors"})
      }
   """
)
                                                        
 
// @LINE:54
def edit = JavascriptReverseRoute(
   "controllers.Authors.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/authors/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:50
def listajax = JavascriptReverseRoute(
   "controllers.Authors.listajax",
   """
      function() {
      return _wA({method:"GET", url:"/ajax/authors"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:94
class ReverseBarcodeImages {
    


 
// @LINE:94
def getFile = JavascriptReverseRoute(
   "controllers.BarcodeImages.getFile",
   """
      function(file) {
      return _wA({method:"GET", url:"/files/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:96
// @LINE:94
// @LINE:92
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:59
// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:96
class ReverseAssets {
    


 
// @LINE:96
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:81
// @LINE:80
// @LINE:79
class ReverseSettings {
    


 
// @LINE:81
def generateCataloguesCode() = new play.api.mvc.HandlerRef(
   controllers.Settings.generateCataloguesCode(), HandlerDef(this, "controllers.Settings", "generateCataloguesCode", Seq())
)
                              
 
// @LINE:80
def save() = new play.api.mvc.HandlerRef(
   controllers.Settings.save(), HandlerDef(this, "controllers.Settings", "save", Seq())
)
                              
 
// @LINE:79
def index() = new play.api.mvc.HandlerRef(
   controllers.Settings.index(), HandlerDef(this, "controllers.Settings", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:30
// @LINE:29
// @LINE:27
class ReverseBooks {
    


 
// @LINE:35
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Books.delete(id), HandlerDef(this, "controllers.Books", "delete", Seq(classOf[Long]))
)
                              
 
// @LINE:29
def create() = new play.api.mvc.HandlerRef(
   controllers.Books.create(), HandlerDef(this, "controllers.Books", "create", Seq())
)
                              
 
// @LINE:27
def list(p:Int, s:String, o:String, f:String) = new play.api.mvc.HandlerRef(
   controllers.Books.list(p, s, o, f), HandlerDef(this, "controllers.Books", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:33
def update(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Books.update(id), HandlerDef(this, "controllers.Books", "update", Seq(classOf[Long]))
)
                              
 
// @LINE:30
def save() = new play.api.mvc.HandlerRef(
   controllers.Books.save(), HandlerDef(this, "controllers.Books", "save", Seq())
)
                              
 
// @LINE:32
def edit(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Books.edit(id), HandlerDef(this, "controllers.Books", "edit", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
class ReverseTransBorrowing {
    


 
// @LINE:71
def getStudentInfo(nim:String) = new play.api.mvc.HandlerRef(
   controllers.TransBorrowing.getStudentInfo(nim), HandlerDef(this, "controllers.TransBorrowing", "getStudentInfo", Seq(classOf[String]))
)
                              
 
// @LINE:73
def save(studentId:Long) = new play.api.mvc.HandlerRef(
   controllers.TransBorrowing.save(studentId), HandlerDef(this, "controllers.TransBorrowing", "save", Seq(classOf[Long]))
)
                              
 
// @LINE:76
def getMaxBorrowedBook() = new play.api.mvc.HandlerRef(
   controllers.TransBorrowing.getMaxBorrowedBook(), HandlerDef(this, "controllers.TransBorrowing", "getMaxBorrowedBook", Seq())
)
                              
 
// @LINE:75
def getBorrowedCatalogue(studentId:Long) = new play.api.mvc.HandlerRef(
   controllers.TransBorrowing.getBorrowedCatalogue(studentId), HandlerDef(this, "controllers.TransBorrowing", "getBorrowedCatalogue", Seq(classOf[Long]))
)
                              
 
// @LINE:70
def index() = new play.api.mvc.HandlerRef(
   controllers.TransBorrowing.index(), HandlerDef(this, "controllers.TransBorrowing", "index", Seq())
)
                              
 
// @LINE:72
def getCatalogeInfo(barcode:String, studentid:Long) = new play.api.mvc.HandlerRef(
   controllers.TransBorrowing.getCatalogeInfo(barcode, studentid), HandlerDef(this, "controllers.TransBorrowing", "getCatalogeInfo", Seq(classOf[String], classOf[Long]))
)
                              
 
// @LINE:74
def getResumeInfo(catId:Long) = new play.api.mvc.HandlerRef(
   controllers.TransBorrowing.getResumeInfo(catId), HandlerDef(this, "controllers.TransBorrowing", "getResumeInfo", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:67
// @LINE:65
// @LINE:64
// @LINE:62
// @LINE:61
// @LINE:59
class ReverseStudents {
    


 
// @LINE:67
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Students.delete(id), HandlerDef(this, "controllers.Students", "delete", Seq(classOf[Long]))
)
                              
 
// @LINE:61
def create() = new play.api.mvc.HandlerRef(
   controllers.Students.create(), HandlerDef(this, "controllers.Students", "create", Seq())
)
                              
 
// @LINE:59
def list(p:Int, s:String, o:String, f:String) = new play.api.mvc.HandlerRef(
   controllers.Students.list(p, s, o, f), HandlerDef(this, "controllers.Students", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:65
def update(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Students.update(id), HandlerDef(this, "controllers.Students", "update", Seq(classOf[Long]))
)
                              
 
// @LINE:62
def save() = new play.api.mvc.HandlerRef(
   controllers.Students.save(), HandlerDef(this, "controllers.Students", "save", Seq())
)
                              
 
// @LINE:64
def edit(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Students.edit(id), HandlerDef(this, "controllers.Students", "edit", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseLibrary {
    


 
// @LINE:6
def search(p:Int, f:String, fb:String, s:String, o:String) = new play.api.mvc.HandlerRef(
   controllers.Library.search(p, f, fb, s, o), HandlerDef(this, "controllers.Library", "search", Seq(classOf[Int], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:8
def details(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Library.details(id), HandlerDef(this, "controllers.Library", "details", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
class ReverseReports {
    


 
// @LINE:89
def listOverdueBooks() = new play.api.mvc.HandlerRef(
   controllers.Reports.listOverdueBooks(), HandlerDef(this, "controllers.Reports", "listOverdueBooks", Seq())
)
                              
 
// @LINE:85
def listBorrowedBooks() = new play.api.mvc.HandlerRef(
   controllers.Reports.listBorrowedBooks(), HandlerDef(this, "controllers.Reports", "listBorrowedBooks", Seq())
)
                              
 
// @LINE:87
def listReturnedBooks() = new play.api.mvc.HandlerRef(
   controllers.Reports.listReturnedBooks(), HandlerDef(this, "controllers.Reports", "listReturnedBooks", Seq())
)
                              
 
// @LINE:88
def overdueBooks() = new play.api.mvc.HandlerRef(
   controllers.Reports.overdueBooks(), HandlerDef(this, "controllers.Reports", "overdueBooks", Seq())
)
                              
 
// @LINE:86
def returnedBooks() = new play.api.mvc.HandlerRef(
   controllers.Reports.returnedBooks(), HandlerDef(this, "controllers.Reports", "returnedBooks", Seq())
)
                              
 
// @LINE:84
def borrowedBooks() = new play.api.mvc.HandlerRef(
   controllers.Reports.borrowedBooks(), HandlerDef(this, "controllers.Reports", "borrowedBooks", Seq())
)
                              

                      
    
}
                            

// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseCatalogues {
    


 
// @LINE:38
def list(bookid:Long, p:Int, s:String, o:String, f:String) = new play.api.mvc.HandlerRef(
   controllers.Catalogues.list(bookid, p, s, o, f), HandlerDef(this, "controllers.Catalogues", "list", Seq(classOf[Long], classOf[Int], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:39
def create(bookid:Long) = new play.api.mvc.HandlerRef(
   controllers.Catalogues.create(bookid), HandlerDef(this, "controllers.Catalogues", "create", Seq(classOf[Long]))
)
                              
 
// @LINE:46
def printBarcodes(barcodestext:String) = new play.api.mvc.HandlerRef(
   controllers.Catalogues.printBarcodes(barcodestext), HandlerDef(this, "controllers.Catalogues", "printBarcodes", Seq(classOf[String]))
)
                              
 
// @LINE:40
def save(bookid:Long) = new play.api.mvc.HandlerRef(
   controllers.Catalogues.save(bookid), HandlerDef(this, "controllers.Catalogues", "save", Seq(classOf[Long]))
)
                              
 
// @LINE:43
def update(id:Long, bookid:Long) = new play.api.mvc.HandlerRef(
   controllers.Catalogues.update(id, bookid), HandlerDef(this, "controllers.Catalogues", "update", Seq(classOf[Long], classOf[Long]))
)
                              
 
// @LINE:45
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Catalogues.delete(id), HandlerDef(this, "controllers.Catalogues", "delete", Seq(classOf[Long]))
)
                              
 
// @LINE:42
def edit(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Catalogues.edit(id), HandlerDef(this, "controllers.Catalogues", "edit", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:92
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseApplication {
    


 
// @LINE:12
def authenticate() = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq())
)
                              
 
// @LINE:13
def logout() = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq())
)
                              
 
// @LINE:11
def login() = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq())
)
                              
 
// @LINE:92
def javascriptRoutes() = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq())
)
                              

                      
    
}
                            

// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
class ReversePublishers {
    


 
// @LINE:24
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Publishers.delete(id), HandlerDef(this, "controllers.Publishers", "delete", Seq(classOf[Long]))
)
                              
 
// @LINE:18
def create() = new play.api.mvc.HandlerRef(
   controllers.Publishers.create(), HandlerDef(this, "controllers.Publishers", "create", Seq())
)
                              
 
// @LINE:16
def list(p:Int, s:String, o:String, f:String) = new play.api.mvc.HandlerRef(
   controllers.Publishers.list(p, s, o, f), HandlerDef(this, "controllers.Publishers", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:22
def update(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Publishers.update(id), HandlerDef(this, "controllers.Publishers", "update", Seq(classOf[Long]))
)
                              
 
// @LINE:19
def save() = new play.api.mvc.HandlerRef(
   controllers.Publishers.save(), HandlerDef(this, "controllers.Publishers", "save", Seq())
)
                              
 
// @LINE:21
def edit(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Publishers.edit(id), HandlerDef(this, "controllers.Publishers", "edit", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:57
// @LINE:55
// @LINE:54
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseAuthors {
    


 
// @LINE:57
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Authors.delete(id), HandlerDef(this, "controllers.Authors", "delete", Seq(classOf[Long]))
)
                              
 
// @LINE:51
def create() = new play.api.mvc.HandlerRef(
   controllers.Authors.create(), HandlerDef(this, "controllers.Authors", "create", Seq())
)
                              
 
// @LINE:49
def list(p:Int, s:String, o:String, f:String) = new play.api.mvc.HandlerRef(
   controllers.Authors.list(p, s, o, f), HandlerDef(this, "controllers.Authors", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:55
def update(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Authors.update(id), HandlerDef(this, "controllers.Authors", "update", Seq(classOf[Long]))
)
                              
 
// @LINE:52
def save() = new play.api.mvc.HandlerRef(
   controllers.Authors.save(), HandlerDef(this, "controllers.Authors", "save", Seq())
)
                              
 
// @LINE:54
def edit(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Authors.edit(id), HandlerDef(this, "controllers.Authors", "edit", Seq(classOf[Long]))
)
                              
 
// @LINE:50
def listajax() = new play.api.mvc.HandlerRef(
   controllers.Authors.listajax(), HandlerDef(this, "controllers.Authors", "listajax", Seq())
)
                              

                      
    
}
                            

// @LINE:94
class ReverseBarcodeImages {
    


 
// @LINE:94
def getFile(file:String) = new play.api.mvc.HandlerRef(
   controllers.BarcodeImages.getFile(file), HandlerDef(this, "controllers.BarcodeImages", "getFile", Seq(classOf[String]))
)
                              

                      
    
}
                            
}
                    
                