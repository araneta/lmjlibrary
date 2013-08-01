
package views.html.books

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Book],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(bookForm: Form[Book]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.24*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 
	
"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""
	<h1 class="heading">Add a book</h1>   
   """),_display_(Seq[Any](/*9.5*/form(routes.Books.save())/*9.30*/ {_display_(Seq[Any](format.raw/*9.32*/("""
       
       <fieldset>        
           """),_display_(Seq[Any](/*12.13*/inputText(bookForm("title"), '_label -> "Book title"))),format.raw/*12.66*/("""  
           """),_display_(Seq[Any](/*13.13*/select(
                bookForm("publisher.id"), 
                options(Publisher.options), 
                '_label -> "Publisher", '_default -> "-- Choose a publisher --",
                '_showConstraints -> false
            ))),format.raw/*18.14*/("""                 
            <div class="clearfix ">
			    <label for="author">Select Author</label>
			    <div class="input">			        
			    	<input type="text" value="" name="author" id="author" />			
			        <span class="help-inline"></span>
			        <input type="hidden" name="author_ids" id="author_ids"/>
		            <div id="authorsbox">
		            	<span>Selected Author(s):</span>
		            	<ul id="authors">
		            	
		            	</ul>
		            </div> 
			    </div>
			</div>				
			"""),_display_(Seq[Any](/*33.5*/inputText(bookForm("publish_year"), '_label -> "Publish Year"))),format.raw/*33.67*/("""    
            """),_display_(Seq[Any](/*34.14*/inputText(bookForm("isbn"), '_label -> "ISBN"))),format.raw/*34.60*/("""  
            """),_display_(Seq[Any](/*35.14*/inputText(bookForm("catalogue_count"), '_label -> "Cataloge Count"))),format.raw/*35.81*/("""
       </fieldset>
       
       <div class="actions">
           <input type="submit" value="Add" class="btn primary" >  
           <a href=""""),_display_(Seq[Any](/*40.22*/routes/*40.28*/.Books.list())),format.raw/*40.41*/("""" class="btn">Cancel</a> 
       </div>
		<link rel="stylesheet" href="/assets/stylesheets/jquery-ui.css" />		
		<script src="/assets/javascripts/jquery-ui.js"></script>
		<script src="/assets/javascripts/book.js"></script>
		<style>
	    	.ui-autocomplete-loading """),format.raw("""{"""),format.raw/*46.33*/("""
	        	background: white url('/assets/images/ui-anim_basic_16x16.gif') right center no-repeat;
	    	"""),format.raw("""}"""),format.raw/*48.8*/("""
	    	.authortext"""),format.raw("""{"""),format.raw/*49.19*/("""
	    		width:200px;
	    		display:block;
	    		float:left;
	    	"""),format.raw("""}"""),format.raw/*53.8*/("""
	    	#authorsbox"""),format.raw("""{"""),format.raw/*54.19*/("""
	    		padding:10px 0;
	    	"""),format.raw("""}"""),format.raw/*56.8*/("""
	    </style>	    
   """)))})),format.raw/*58.5*/("""
    
""")))})))}
    }
    
    def render(bookForm:Form[Book]) = apply(bookForm)
    
    def f:((Form[Book]) => play.api.templates.Html) = (bookForm) => apply(bookForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/books/createForm.scala.html
                    HASH: eddf27756fefacf159f5f81bf8853a29f80e5ed3
                    MATRIX: 770->1|877->44|909->68|993->23|1021->42|1049->122|1088->127|1101->133|1140->135|1219->180|1252->205|1291->207|1374->254|1449->307|1500->322|1755->555|2320->1085|2404->1147|2458->1165|2526->1211|2578->1227|2667->1294|2849->1440|2864->1446|2899->1459|3212->1725|3364->1831|3430->1850|3545->1919|3611->1938|3688->1969|3743->1993
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|38->9|38->9|38->9|41->12|41->12|42->13|47->18|62->33|62->33|63->34|63->34|64->35|64->35|69->40|69->40|69->40|75->46|77->48|78->49|82->53|83->54|85->56|87->58
                    -- GENERATED --
                */
            