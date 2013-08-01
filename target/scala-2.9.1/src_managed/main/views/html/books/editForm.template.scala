
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,Form[Book],Set[Author],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,bookForm: Form[Book],authors:Set[Author]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.53*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
	<h1 class="heading">Edit a book</h1>
	
	"""),_display_(Seq[Any](/*10.3*/form(routes.Books.update(id))/*10.32*/ {_display_(Seq[Any](format.raw/*10.34*/("""
	    
	    <fieldset>        
	        """),_display_(Seq[Any](/*13.11*/inputText(bookForm("title"), '_label -> "book title"))),format.raw/*13.64*/("""
	        <div class="clearfix ">
			    <label for="author">Publisher Text: </label>
			    <div class="input">			        
			    	<span>"""),_display_(Seq[Any](/*17.16*/bookForm("publisher_text")/*17.42*/.value())),format.raw/*17.50*/("""</span>						        
			    </div>
			</div>	                         
	       """),_display_(Seq[Any](/*20.10*/select(
                bookForm("publisher.id"), 
                options(Publisher.options), 
                '_label -> "Publisher", '_default -> "-- Choose a publisher --",
                '_showConstraints -> false
            ))),format.raw/*25.14*/("""   
            <div class="clearfix ">
			    <label for="author">Author(s) Text: </label>
			    <div class="input">			        
			    	<span>"""),_display_(Seq[Any](/*29.16*/bookForm("authors_text")/*29.40*/.value())),format.raw/*29.48*/("""</span>						        
			    </div>
			</div>
	         <div class="clearfix ">
			    <label for="author">Select Author</label>
			    <div class="input">			        
			    	<input type="text" value="" name="author" id="author" />			
			        <span class="help-inline"></span>
			        <input type="hidden" name="author_ids" id="author_ids" value=""""),_display_(Seq[Any](/*37.75*/for(author <- authors) yield /*37.97*/{_display_(Seq[Any](format.raw/*37.98*/(""" """),_display_(Seq[Any](/*37.100*/author/*37.106*/.id)),format.raw/*37.109*/(""",""")))})),format.raw/*37.111*/(""""/>
		            <div id="authorsbox">
		            	<span>Selected Author(s):</span>
		            	<ul id="authors">
		            	"""),_display_(Seq[Any](/*41.17*/for(author <- authors) yield /*41.39*/ {_display_(Seq[Any](format.raw/*41.41*/("""
		            		<li id="a"""),_display_(Seq[Any](/*42.27*/author/*42.33*/.id)),format.raw/*42.36*/("""" authorid=""""),_display_(Seq[Any](/*42.49*/author/*42.55*/.id)),format.raw/*42.58*/(""""><span class="authortext">"""),_display_(Seq[Any](/*42.86*/author/*42.92*/.name)),format.raw/*42.97*/("""</span>
		            			<a href="#" onclick="removeAuthor("""),_display_(Seq[Any](/*43.53*/author/*43.59*/.id)),format.raw/*43.62*/(""");return false;">Remove</a>
		           			</li>
		            	""")))})),format.raw/*45.17*/("""
		            	</ul>
		            </div>
			    </div>
			</div>				
			"""),_display_(Seq[Any](/*50.5*/inputText(bookForm("publish_year"), '_label -> "Publish Year"))),format.raw/*50.67*/("""    
            """),_display_(Seq[Any](/*51.14*/inputText(bookForm("isbn"), '_label -> "ISBN"))),format.raw/*51.60*/("""
	        """),_display_(Seq[Any](/*52.11*/inputText(bookForm("catalogue_count"), '_label -> "Cataloge Count"))),format.raw/*52.78*/("""
	    </fieldset>
	    
	    <div class="actions">
	        <input type="submit" value="Save" class="btn primary">  
	        <a href=""""),_display_(Seq[Any](/*57.20*/routes/*57.26*/.Catalogues.list(id))),format.raw/*57.46*/("""" class="btn">Catalogue</a> 
	        <a href=""""),_display_(Seq[Any](/*58.20*/routes/*58.26*/.Books.list())),format.raw/*58.39*/("""" class="btn">Cancel</a>	        
	    </div>
	    
	""")))})),format.raw/*61.3*/("""
	"""),_display_(Seq[Any](/*62.3*/form(routes.Books.delete(id), 'class -> "topRight")/*62.54*/ {_display_(Seq[Any](format.raw/*62.56*/("""
	    <input type="submit" value="Delete" class="btn danger">
	""")))})),format.raw/*64.3*/("""
	<link rel="stylesheet" href="/assets/stylesheets/jquery-ui.css" />		
		<script src="/assets/javascripts/jquery-ui.js"></script>
		<script src="/assets/javascripts/book.js"></script>
		<style>
	    	.ui-autocomplete-loading """),format.raw("""{"""),format.raw/*69.33*/("""
	        	background: white url('/assets/images/ui-anim_basic_16x16.gif') right center no-repeat;
	    	"""),format.raw("""}"""),format.raw/*71.8*/("""
	    	.authortext"""),format.raw("""{"""),format.raw/*72.19*/("""
	    		width:200px;
	    		display:block;
	    		float:left;
	    	"""),format.raw("""}"""),format.raw/*76.8*/("""
	    	#authorsbox"""),format.raw("""{"""),format.raw/*77.19*/("""
	    		padding:10px 0;
	    	"""),format.raw("""}"""),format.raw/*79.8*/("""
	    </style>	    
	
""")))})))}
    }
    
    def render(id:Long,bookForm:Form[Book],authors:Set[Author]) = apply(id,bookForm,authors)
    
    def f:((Long,Form[Book],Set[Author]) => play.api.templates.Html) = (id,bookForm,authors) => apply(id,bookForm,authors)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/books/editForm.scala.html
                    HASH: a35e18b3d228b6410eb859efdc93b6e263cce910
                    MATRIX: 785->1|921->73|953->97|1037->52|1065->71|1093->151|1131->155|1144->161|1183->163|1265->210|1303->239|1343->241|1420->282|1495->335|1670->474|1705->500|1735->508|1852->589|2107->822|2288->967|2321->991|2351->999|2741->1353|2779->1375|2818->1376|2857->1378|2873->1384|2899->1387|2934->1389|3107->1526|3145->1548|3185->1550|3248->1577|3263->1583|3288->1586|3337->1599|3352->1605|3377->1608|3441->1636|3456->1642|3483->1647|3579->1707|3594->1713|3619->1716|3717->1782|3827->1857|3911->1919|3965->1937|4033->1983|4080->1994|4169->2061|4341->2197|4356->2203|4398->2223|4482->2271|4497->2277|4532->2290|4617->2344|4655->2347|4715->2398|4755->2400|4850->2464|5123->2690|5275->2796|5341->2815|5456->2884|5522->2903|5599->2934
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|39->10|39->10|39->10|42->13|42->13|46->17|46->17|46->17|49->20|54->25|58->29|58->29|58->29|66->37|66->37|66->37|66->37|66->37|66->37|66->37|70->41|70->41|70->41|71->42|71->42|71->42|71->42|71->42|71->42|71->42|71->42|71->42|72->43|72->43|72->43|74->45|79->50|79->50|80->51|80->51|81->52|81->52|86->57|86->57|86->57|87->58|87->58|87->58|90->61|91->62|91->62|91->62|93->64|98->69|100->71|101->72|105->76|106->77|108->79
                    -- GENERATED --
                */
            