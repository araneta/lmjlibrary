// @SOURCE:/media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/conf/routes
// @HASH:c419daf57e55c302ff5497e4b7d15e2e6e13b76b
// @DATE:Fri Dec 28 19:06:25 WIT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Library_search0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_Library_search1 = Route("GET", PathPattern(List(StaticPart("/search"))))
                    

// @LINE:8
val controllers_Library_details2 = Route("GET", PathPattern(List(StaticPart("/details/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:11
val controllers_Application_login3 = Route("GET", PathPattern(List(StaticPart("/login"))))
                    

// @LINE:12
val controllers_Application_authenticate4 = Route("POST", PathPattern(List(StaticPart("/login"))))
                    

// @LINE:13
val controllers_Application_logout5 = Route("GET", PathPattern(List(StaticPart("/logout"))))
                    

// @LINE:16
val controllers_Publishers_list6 = Route("GET", PathPattern(List(StaticPart("/publishers"))))
                    

// @LINE:18
val controllers_Publishers_create7 = Route("GET", PathPattern(List(StaticPart("/publishers/new"))))
                    

// @LINE:19
val controllers_Publishers_save8 = Route("POST", PathPattern(List(StaticPart("/publishers"))))
                    

// @LINE:21
val controllers_Publishers_edit9 = Route("GET", PathPattern(List(StaticPart("/publishers/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:22
val controllers_Publishers_update10 = Route("POST", PathPattern(List(StaticPart("/publishers/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:24
val controllers_Publishers_delete11 = Route("POST", PathPattern(List(StaticPart("/publishers/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:27
val controllers_Books_list12 = Route("GET", PathPattern(List(StaticPart("/books"))))
                    

// @LINE:29
val controllers_Books_create13 = Route("GET", PathPattern(List(StaticPart("/books/new"))))
                    

// @LINE:30
val controllers_Books_save14 = Route("POST", PathPattern(List(StaticPart("/books"))))
                    

// @LINE:32
val controllers_Books_edit15 = Route("GET", PathPattern(List(StaticPart("/books/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:33
val controllers_Books_update16 = Route("POST", PathPattern(List(StaticPart("/books/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:35
val controllers_Books_delete17 = Route("POST", PathPattern(List(StaticPart("/books/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:38
val controllers_Catalogues_list18 = Route("GET", PathPattern(List(StaticPart("/catalogues/"),DynamicPart("bookid", """[^/]+"""))))
                    

// @LINE:39
val controllers_Catalogues_create19 = Route("GET", PathPattern(List(StaticPart("/catalogues/new/"),DynamicPart("bookid", """[^/]+"""))))
                    

// @LINE:40
val controllers_Catalogues_save20 = Route("POST", PathPattern(List(StaticPart("/catalogues/"),DynamicPart("bookid", """[^/]+"""))))
                    

// @LINE:42
val controllers_Catalogues_edit21 = Route("GET", PathPattern(List(StaticPart("/catalogues/"),DynamicPart("id", """[^/]+"""),StaticPart("/edit"))))
                    

// @LINE:43
val controllers_Catalogues_update22 = Route("POST", PathPattern(List(StaticPart("/catalogues/"),DynamicPart("id", """[^/]+"""),StaticPart("/"),DynamicPart("bookid", """[^/]+"""),StaticPart("/update"))))
                    

// @LINE:45
val controllers_Catalogues_delete23 = Route("POST", PathPattern(List(StaticPart("/catalogues/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:46
val controllers_Catalogues_printBarcodes24 = Route("GET", PathPattern(List(StaticPart("/catalogues/printbarcodes/"),DynamicPart("barcodestext", """[^/]+"""))))
                    

// @LINE:49
val controllers_Authors_list25 = Route("GET", PathPattern(List(StaticPart("/authors"))))
                    

// @LINE:50
val controllers_Authors_listajax26 = Route("GET", PathPattern(List(StaticPart("/ajax/authors"))))
                    

// @LINE:51
val controllers_Authors_create27 = Route("GET", PathPattern(List(StaticPart("/authors/new"))))
                    

// @LINE:52
val controllers_Authors_save28 = Route("POST", PathPattern(List(StaticPart("/authors"))))
                    

// @LINE:54
val controllers_Authors_edit29 = Route("GET", PathPattern(List(StaticPart("/authors/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:55
val controllers_Authors_update30 = Route("POST", PathPattern(List(StaticPart("/authors/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:57
val controllers_Authors_delete31 = Route("POST", PathPattern(List(StaticPart("/authors/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:59
val controllers_Students_list32 = Route("GET", PathPattern(List(StaticPart("/students"))))
                    

// @LINE:61
val controllers_Students_create33 = Route("GET", PathPattern(List(StaticPart("/students/new"))))
                    

// @LINE:62
val controllers_Students_save34 = Route("POST", PathPattern(List(StaticPart("/students"))))
                    

// @LINE:64
val controllers_Students_edit35 = Route("GET", PathPattern(List(StaticPart("/students/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:65
val controllers_Students_update36 = Route("POST", PathPattern(List(StaticPart("/students/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:67
val controllers_Students_delete37 = Route("POST", PathPattern(List(StaticPart("/students/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:70
val controllers_TransBorrowing_index38 = Route("GET", PathPattern(List(StaticPart("/borrowing"))))
                    

// @LINE:71
val controllers_TransBorrowing_getStudentInfo39 = Route("GET", PathPattern(List(StaticPart("/borrowing/studentinfo/"),DynamicPart("nim", """[^/]+"""))))
                    

// @LINE:72
val controllers_TransBorrowing_getCatalogeInfo40 = Route("GET", PathPattern(List(StaticPart("/borrowing/cataloginfo/"),DynamicPart("barcode", """[^/]+"""),StaticPart("/"),DynamicPart("studentid", """[^/]+"""))))
                    

// @LINE:73
val controllers_TransBorrowing_save41 = Route("POST", PathPattern(List(StaticPart("/borrowing/save/"),DynamicPart("studentId", """[^/]+"""))))
                    

// @LINE:74
val controllers_TransBorrowing_getResumeInfo42 = Route("GET", PathPattern(List(StaticPart("/borrowing/resumeinfo/"),DynamicPart("catId", """[^/]+"""))))
                    

// @LINE:75
val controllers_TransBorrowing_getBorrowedCatalogue43 = Route("GET", PathPattern(List(StaticPart("/borrowing/borrowedcatalogue/"),DynamicPart("studentId", """[^/]+"""))))
                    

// @LINE:76
val controllers_TransBorrowing_getMaxBorrowedBook44 = Route("GET", PathPattern(List(StaticPart("/borrowing/maxborrowedbook"))))
                    

// @LINE:79
val controllers_Settings_index45 = Route("GET", PathPattern(List(StaticPart("/settings"))))
                    

// @LINE:80
val controllers_Settings_save46 = Route("POST", PathPattern(List(StaticPart("/settings/save"))))
                    

// @LINE:81
val controllers_Settings_generateCataloguesCode47 = Route("GET", PathPattern(List(StaticPart("/settings/generatecatscode"))))
                    

// @LINE:84
val controllers_Reports_borrowedBooks48 = Route("GET", PathPattern(List(StaticPart("/report/borrowedbooks"))))
                    

// @LINE:85
val controllers_Reports_listBorrowedBooks49 = Route("GET", PathPattern(List(StaticPart("/report/ajax/borrowedbook"))))
                    

// @LINE:86
val controllers_Reports_returnedBooks50 = Route("GET", PathPattern(List(StaticPart("/report/returnedbooks"))))
                    

// @LINE:87
val controllers_Reports_listReturnedBooks51 = Route("GET", PathPattern(List(StaticPart("/report/ajax/returnedbook"))))
                    

// @LINE:88
val controllers_Reports_overdueBooks52 = Route("GET", PathPattern(List(StaticPart("/report/overduebooks"))))
                    

// @LINE:89
val controllers_Reports_listOverdueBooks53 = Route("GET", PathPattern(List(StaticPart("/report/ajax/overduebook"))))
                    

// @LINE:92
val controllers_Application_javascriptRoutes54 = Route("GET", PathPattern(List(StaticPart("/javascriptRoutes"))))
                    

// @LINE:94
val controllers_BarcodeImages_getFile55 = Route("GET", PathPattern(List(StaticPart("/files/"),DynamicPart("file", """[^/]+"""))))
                    

// @LINE:96
val controllers_Assets_at56 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Library.search(p:Int ?= 0, f:String ?= "", fb:String ?= "", s:String ?= "", o:String ?= "")"""),("""GET""","""/search""","""controllers.Library.search(p:Int ?= 0, f:String ?= "", fb:String ?= "", s:String ?= "title", o:String ?= "asc")"""),("""GET""","""/details/$id<[^/]+>""","""controllers.Library.details(id:Long)"""),("""GET""","""/login""","""controllers.Application.login()"""),("""POST""","""/login""","""controllers.Application.authenticate()"""),("""GET""","""/logout""","""controllers.Application.logout()"""),("""GET""","""/publishers""","""controllers.Publishers.list(p:Int ?= 0, s:String ?= "name", o:String ?= "asc", f:String ?= "")"""),("""GET""","""/publishers/new""","""controllers.Publishers.create()"""),("""POST""","""/publishers""","""controllers.Publishers.save()"""),("""GET""","""/publishers/$id<[^/]+>""","""controllers.Publishers.edit(id:Long)"""),("""POST""","""/publishers/$id<[^/]+>""","""controllers.Publishers.update(id:Long)"""),("""POST""","""/publishers/$id<[^/]+>/delete""","""controllers.Publishers.delete(id:Long)"""),("""GET""","""/books""","""controllers.Books.list(p:Int ?= 0, s:String ?= "title", o:String ?= "asc", f:String ?= "")"""),("""GET""","""/books/new""","""controllers.Books.create()"""),("""POST""","""/books""","""controllers.Books.save()"""),("""GET""","""/books/$id<[^/]+>""","""controllers.Books.edit(id:Long)"""),("""POST""","""/books/$id<[^/]+>""","""controllers.Books.update(id:Long)"""),("""POST""","""/books/$id<[^/]+>/delete""","""controllers.Books.delete(id:Long)"""),("""GET""","""/catalogues/$bookid<[^/]+>""","""controllers.Catalogues.list(bookid:Long, p:Int ?= 0, s:String ?= "barcode", o:String ?= "asc", f:String ?= "")"""),("""GET""","""/catalogues/new/$bookid<[^/]+>""","""controllers.Catalogues.create(bookid:Long)"""),("""POST""","""/catalogues/$bookid<[^/]+>""","""controllers.Catalogues.save(bookid:Long)"""),("""GET""","""/catalogues/$id<[^/]+>/edit""","""controllers.Catalogues.edit(id:Long)"""),("""POST""","""/catalogues/$id<[^/]+>/$bookid<[^/]+>/update""","""controllers.Catalogues.update(id:Long, bookid:Long)"""),("""POST""","""/catalogues/$id<[^/]+>/delete""","""controllers.Catalogues.delete(id:Long)"""),("""GET""","""/catalogues/printbarcodes/$barcodestext<[^/]+>""","""controllers.Catalogues.printBarcodes(barcodestext:String)"""),("""GET""","""/authors""","""controllers.Authors.list(p:Int ?= 0, s:String ?= "name", o:String ?= "asc", f:String ?= "")"""),("""GET""","""/ajax/authors""","""controllers.Authors.listajax()"""),("""GET""","""/authors/new""","""controllers.Authors.create()"""),("""POST""","""/authors""","""controllers.Authors.save()"""),("""GET""","""/authors/$id<[^/]+>""","""controllers.Authors.edit(id:Long)"""),("""POST""","""/authors/$id<[^/]+>""","""controllers.Authors.update(id:Long)"""),("""POST""","""/authors/$id<[^/]+>/delete""","""controllers.Authors.delete(id:Long)"""),("""GET""","""/students""","""controllers.Students.list(p:Int ?= 0, s:String ?= "name", o:String ?= "asc", f:String ?= "")"""),("""GET""","""/students/new""","""controllers.Students.create()"""),("""POST""","""/students""","""controllers.Students.save()"""),("""GET""","""/students/$id<[^/]+>""","""controllers.Students.edit(id:Long)"""),("""POST""","""/students/$id<[^/]+>""","""controllers.Students.update(id:Long)"""),("""POST""","""/students/$id<[^/]+>/delete""","""controllers.Students.delete(id:Long)"""),("""GET""","""/borrowing""","""controllers.TransBorrowing.index()"""),("""GET""","""/borrowing/studentinfo/$nim<[^/]+>""","""controllers.TransBorrowing.getStudentInfo(nim:String)"""),("""GET""","""/borrowing/cataloginfo/$barcode<[^/]+>/$studentid<[^/]+>""","""controllers.TransBorrowing.getCatalogeInfo(barcode:String, studentid:Long)"""),("""POST""","""/borrowing/save/$studentId<[^/]+>""","""controllers.TransBorrowing.save(studentId:Long)"""),("""GET""","""/borrowing/resumeinfo/$catId<[^/]+>""","""controllers.TransBorrowing.getResumeInfo(catId:Long)"""),("""GET""","""/borrowing/borrowedcatalogue/$studentId<[^/]+>""","""controllers.TransBorrowing.getBorrowedCatalogue(studentId:Long)"""),("""GET""","""/borrowing/maxborrowedbook""","""controllers.TransBorrowing.getMaxBorrowedBook()"""),("""GET""","""/settings""","""controllers.Settings.index()"""),("""POST""","""/settings/save""","""controllers.Settings.save()"""),("""GET""","""/settings/generatecatscode""","""controllers.Settings.generateCataloguesCode()"""),("""GET""","""/report/borrowedbooks""","""controllers.Reports.borrowedBooks()"""),("""GET""","""/report/ajax/borrowedbook""","""controllers.Reports.listBorrowedBooks()"""),("""GET""","""/report/returnedbooks""","""controllers.Reports.returnedBooks()"""),("""GET""","""/report/ajax/returnedbook""","""controllers.Reports.listReturnedBooks()"""),("""GET""","""/report/overduebooks""","""controllers.Reports.overdueBooks()"""),("""GET""","""/report/ajax/overduebook""","""controllers.Reports.listOverdueBooks()"""),("""GET""","""/javascriptRoutes""","""controllers.Application.javascriptRoutes()"""),("""GET""","""/files/$file<[^/]+>""","""controllers.BarcodeImages.getFile(file:String)"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Library_search0(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("f", Some("")), params.fromQuery[String]("fb", Some("")), params.fromQuery[String]("s", Some("")), params.fromQuery[String]("o", Some(""))) { (p, f, fb, s, o) =>
        invokeHandler(_root_.controllers.Library.search(p, f, fb, s, o), HandlerDef(this, "controllers.Library", "search", Seq(classOf[Int], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:7
case controllers_Library_search1(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("f", Some("")), params.fromQuery[String]("fb", Some("")), params.fromQuery[String]("s", Some("title")), params.fromQuery[String]("o", Some("asc"))) { (p, f, fb, s, o) =>
        invokeHandler(_root_.controllers.Library.search(p, f, fb, s, o), HandlerDef(this, "controllers.Library", "search", Seq(classOf[Int], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:8
case controllers_Library_details2(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Library.details(id), HandlerDef(this, "controllers.Library", "details", Seq(classOf[Long])))
   }
}
                    

// @LINE:11
case controllers_Application_login3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil))
   }
}
                    

// @LINE:12
case controllers_Application_authenticate4(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil))
   }
}
                    

// @LINE:13
case controllers_Application_logout5(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil))
   }
}
                    

// @LINE:16
case controllers_Publishers_list6(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("s", Some("name")), params.fromQuery[String]("o", Some("asc")), params.fromQuery[String]("f", Some(""))) { (p, s, o, f) =>
        invokeHandler(_root_.controllers.Publishers.list(p, s, o, f), HandlerDef(this, "controllers.Publishers", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:18
case controllers_Publishers_create7(params) => {
   call { 
        invokeHandler(_root_.controllers.Publishers.create(), HandlerDef(this, "controllers.Publishers", "create", Nil))
   }
}
                    

// @LINE:19
case controllers_Publishers_save8(params) => {
   call { 
        invokeHandler(_root_.controllers.Publishers.save(), HandlerDef(this, "controllers.Publishers", "save", Nil))
   }
}
                    

// @LINE:21
case controllers_Publishers_edit9(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Publishers.edit(id), HandlerDef(this, "controllers.Publishers", "edit", Seq(classOf[Long])))
   }
}
                    

// @LINE:22
case controllers_Publishers_update10(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Publishers.update(id), HandlerDef(this, "controllers.Publishers", "update", Seq(classOf[Long])))
   }
}
                    

// @LINE:24
case controllers_Publishers_delete11(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Publishers.delete(id), HandlerDef(this, "controllers.Publishers", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:27
case controllers_Books_list12(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("s", Some("title")), params.fromQuery[String]("o", Some("asc")), params.fromQuery[String]("f", Some(""))) { (p, s, o, f) =>
        invokeHandler(_root_.controllers.Books.list(p, s, o, f), HandlerDef(this, "controllers.Books", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:29
case controllers_Books_create13(params) => {
   call { 
        invokeHandler(_root_.controllers.Books.create(), HandlerDef(this, "controllers.Books", "create", Nil))
   }
}
                    

// @LINE:30
case controllers_Books_save14(params) => {
   call { 
        invokeHandler(_root_.controllers.Books.save(), HandlerDef(this, "controllers.Books", "save", Nil))
   }
}
                    

// @LINE:32
case controllers_Books_edit15(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Books.edit(id), HandlerDef(this, "controllers.Books", "edit", Seq(classOf[Long])))
   }
}
                    

// @LINE:33
case controllers_Books_update16(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Books.update(id), HandlerDef(this, "controllers.Books", "update", Seq(classOf[Long])))
   }
}
                    

// @LINE:35
case controllers_Books_delete17(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Books.delete(id), HandlerDef(this, "controllers.Books", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:38
case controllers_Catalogues_list18(params) => {
   call(params.fromPath[Long]("bookid", None), params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("s", Some("barcode")), params.fromQuery[String]("o", Some("asc")), params.fromQuery[String]("f", Some(""))) { (bookid, p, s, o, f) =>
        invokeHandler(_root_.controllers.Catalogues.list(bookid, p, s, o, f), HandlerDef(this, "controllers.Catalogues", "list", Seq(classOf[Long], classOf[Int], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:39
case controllers_Catalogues_create19(params) => {
   call(params.fromPath[Long]("bookid", None)) { (bookid) =>
        invokeHandler(_root_.controllers.Catalogues.create(bookid), HandlerDef(this, "controllers.Catalogues", "create", Seq(classOf[Long])))
   }
}
                    

// @LINE:40
case controllers_Catalogues_save20(params) => {
   call(params.fromPath[Long]("bookid", None)) { (bookid) =>
        invokeHandler(_root_.controllers.Catalogues.save(bookid), HandlerDef(this, "controllers.Catalogues", "save", Seq(classOf[Long])))
   }
}
                    

// @LINE:42
case controllers_Catalogues_edit21(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Catalogues.edit(id), HandlerDef(this, "controllers.Catalogues", "edit", Seq(classOf[Long])))
   }
}
                    

// @LINE:43
case controllers_Catalogues_update22(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[Long]("bookid", None)) { (id, bookid) =>
        invokeHandler(_root_.controllers.Catalogues.update(id, bookid), HandlerDef(this, "controllers.Catalogues", "update", Seq(classOf[Long], classOf[Long])))
   }
}
                    

// @LINE:45
case controllers_Catalogues_delete23(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Catalogues.delete(id), HandlerDef(this, "controllers.Catalogues", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:46
case controllers_Catalogues_printBarcodes24(params) => {
   call(params.fromPath[String]("barcodestext", None)) { (barcodestext) =>
        invokeHandler(_root_.controllers.Catalogues.printBarcodes(barcodestext), HandlerDef(this, "controllers.Catalogues", "printBarcodes", Seq(classOf[String])))
   }
}
                    

// @LINE:49
case controllers_Authors_list25(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("s", Some("name")), params.fromQuery[String]("o", Some("asc")), params.fromQuery[String]("f", Some(""))) { (p, s, o, f) =>
        invokeHandler(_root_.controllers.Authors.list(p, s, o, f), HandlerDef(this, "controllers.Authors", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:50
case controllers_Authors_listajax26(params) => {
   call { 
        invokeHandler(_root_.controllers.Authors.listajax(), HandlerDef(this, "controllers.Authors", "listajax", Nil))
   }
}
                    

// @LINE:51
case controllers_Authors_create27(params) => {
   call { 
        invokeHandler(_root_.controllers.Authors.create(), HandlerDef(this, "controllers.Authors", "create", Nil))
   }
}
                    

// @LINE:52
case controllers_Authors_save28(params) => {
   call { 
        invokeHandler(_root_.controllers.Authors.save(), HandlerDef(this, "controllers.Authors", "save", Nil))
   }
}
                    

// @LINE:54
case controllers_Authors_edit29(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Authors.edit(id), HandlerDef(this, "controllers.Authors", "edit", Seq(classOf[Long])))
   }
}
                    

// @LINE:55
case controllers_Authors_update30(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Authors.update(id), HandlerDef(this, "controllers.Authors", "update", Seq(classOf[Long])))
   }
}
                    

// @LINE:57
case controllers_Authors_delete31(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Authors.delete(id), HandlerDef(this, "controllers.Authors", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:59
case controllers_Students_list32(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("s", Some("name")), params.fromQuery[String]("o", Some("asc")), params.fromQuery[String]("f", Some(""))) { (p, s, o, f) =>
        invokeHandler(_root_.controllers.Students.list(p, s, o, f), HandlerDef(this, "controllers.Students", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:61
case controllers_Students_create33(params) => {
   call { 
        invokeHandler(_root_.controllers.Students.create(), HandlerDef(this, "controllers.Students", "create", Nil))
   }
}
                    

// @LINE:62
case controllers_Students_save34(params) => {
   call { 
        invokeHandler(_root_.controllers.Students.save(), HandlerDef(this, "controllers.Students", "save", Nil))
   }
}
                    

// @LINE:64
case controllers_Students_edit35(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Students.edit(id), HandlerDef(this, "controllers.Students", "edit", Seq(classOf[Long])))
   }
}
                    

// @LINE:65
case controllers_Students_update36(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Students.update(id), HandlerDef(this, "controllers.Students", "update", Seq(classOf[Long])))
   }
}
                    

// @LINE:67
case controllers_Students_delete37(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Students.delete(id), HandlerDef(this, "controllers.Students", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:70
case controllers_TransBorrowing_index38(params) => {
   call { 
        invokeHandler(_root_.controllers.TransBorrowing.index(), HandlerDef(this, "controllers.TransBorrowing", "index", Nil))
   }
}
                    

// @LINE:71
case controllers_TransBorrowing_getStudentInfo39(params) => {
   call(params.fromPath[String]("nim", None)) { (nim) =>
        invokeHandler(_root_.controllers.TransBorrowing.getStudentInfo(nim), HandlerDef(this, "controllers.TransBorrowing", "getStudentInfo", Seq(classOf[String])))
   }
}
                    

// @LINE:72
case controllers_TransBorrowing_getCatalogeInfo40(params) => {
   call(params.fromPath[String]("barcode", None), params.fromPath[Long]("studentid", None)) { (barcode, studentid) =>
        invokeHandler(_root_.controllers.TransBorrowing.getCatalogeInfo(barcode, studentid), HandlerDef(this, "controllers.TransBorrowing", "getCatalogeInfo", Seq(classOf[String], classOf[Long])))
   }
}
                    

// @LINE:73
case controllers_TransBorrowing_save41(params) => {
   call(params.fromPath[Long]("studentId", None)) { (studentId) =>
        invokeHandler(_root_.controllers.TransBorrowing.save(studentId), HandlerDef(this, "controllers.TransBorrowing", "save", Seq(classOf[Long])))
   }
}
                    

// @LINE:74
case controllers_TransBorrowing_getResumeInfo42(params) => {
   call(params.fromPath[Long]("catId", None)) { (catId) =>
        invokeHandler(_root_.controllers.TransBorrowing.getResumeInfo(catId), HandlerDef(this, "controllers.TransBorrowing", "getResumeInfo", Seq(classOf[Long])))
   }
}
                    

// @LINE:75
case controllers_TransBorrowing_getBorrowedCatalogue43(params) => {
   call(params.fromPath[Long]("studentId", None)) { (studentId) =>
        invokeHandler(_root_.controllers.TransBorrowing.getBorrowedCatalogue(studentId), HandlerDef(this, "controllers.TransBorrowing", "getBorrowedCatalogue", Seq(classOf[Long])))
   }
}
                    

// @LINE:76
case controllers_TransBorrowing_getMaxBorrowedBook44(params) => {
   call { 
        invokeHandler(_root_.controllers.TransBorrowing.getMaxBorrowedBook(), HandlerDef(this, "controllers.TransBorrowing", "getMaxBorrowedBook", Nil))
   }
}
                    

// @LINE:79
case controllers_Settings_index45(params) => {
   call { 
        invokeHandler(_root_.controllers.Settings.index(), HandlerDef(this, "controllers.Settings", "index", Nil))
   }
}
                    

// @LINE:80
case controllers_Settings_save46(params) => {
   call { 
        invokeHandler(_root_.controllers.Settings.save(), HandlerDef(this, "controllers.Settings", "save", Nil))
   }
}
                    

// @LINE:81
case controllers_Settings_generateCataloguesCode47(params) => {
   call { 
        invokeHandler(_root_.controllers.Settings.generateCataloguesCode(), HandlerDef(this, "controllers.Settings", "generateCataloguesCode", Nil))
   }
}
                    

// @LINE:84
case controllers_Reports_borrowedBooks48(params) => {
   call { 
        invokeHandler(_root_.controllers.Reports.borrowedBooks(), HandlerDef(this, "controllers.Reports", "borrowedBooks", Nil))
   }
}
                    

// @LINE:85
case controllers_Reports_listBorrowedBooks49(params) => {
   call { 
        invokeHandler(_root_.controllers.Reports.listBorrowedBooks(), HandlerDef(this, "controllers.Reports", "listBorrowedBooks", Nil))
   }
}
                    

// @LINE:86
case controllers_Reports_returnedBooks50(params) => {
   call { 
        invokeHandler(_root_.controllers.Reports.returnedBooks(), HandlerDef(this, "controllers.Reports", "returnedBooks", Nil))
   }
}
                    

// @LINE:87
case controllers_Reports_listReturnedBooks51(params) => {
   call { 
        invokeHandler(_root_.controllers.Reports.listReturnedBooks(), HandlerDef(this, "controllers.Reports", "listReturnedBooks", Nil))
   }
}
                    

// @LINE:88
case controllers_Reports_overdueBooks52(params) => {
   call { 
        invokeHandler(_root_.controllers.Reports.overdueBooks(), HandlerDef(this, "controllers.Reports", "overdueBooks", Nil))
   }
}
                    

// @LINE:89
case controllers_Reports_listOverdueBooks53(params) => {
   call { 
        invokeHandler(_root_.controllers.Reports.listOverdueBooks(), HandlerDef(this, "controllers.Reports", "listOverdueBooks", Nil))
   }
}
                    

// @LINE:92
case controllers_Application_javascriptRoutes54(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil))
   }
}
                    

// @LINE:94
case controllers_BarcodeImages_getFile55(params) => {
   call(params.fromPath[String]("file", None)) { (file) =>
        invokeHandler(_root_.controllers.BarcodeImages.getFile(file), HandlerDef(this, "controllers.BarcodeImages", "getFile", Seq(classOf[String])))
   }
}
                    

// @LINE:96
case controllers_Assets_at56(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                