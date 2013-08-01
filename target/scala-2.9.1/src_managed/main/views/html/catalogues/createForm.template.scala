
package views.html.catalogues

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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Long,String,Form[Catalogue],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(bookid:Long,booktitle:String,catalogueForm: Form[Catalogue]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.63*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 
	
"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""
	<h1 class="heading">"""),_display_(Seq[Any](/*8.23*/booktitle)),format.raw/*8.32*/(""" : Add a catalogue</h1>   
   """),_display_(Seq[Any](/*9.5*/form(routes.Catalogues.save(bookid))/*9.41*/ {_display_(Seq[Any](format.raw/*9.43*/("""
       
       <fieldset>        
           """),_display_(Seq[Any](/*12.13*/inputText(catalogueForm("barcode"), '_label -> "Barcode"))),format.raw/*12.70*/("""  
           """),_display_(Seq[Any](/*13.13*/select(
                catalogueForm("status.id"), 
               	options(CatalogueStatus.options), 
                '_label -> "Status", '_default -> "-- Choose a status --",
                '_showConstraints -> false
            ))),format.raw/*18.14*/("""                   
            <input type="hidden" name="book.id" value=""""),_display_(Seq[Any](/*19.57*/bookid)),format.raw/*19.63*/("""" />
       </fieldset>
       
       <div class="actions">
           <input type="submit" value="Add" class="btn primary">  
           <a href=""""),_display_(Seq[Any](/*24.22*/routes/*24.28*/.Catalogues.list(bookid))),format.raw/*24.52*/("""" class="btn">Cancel</a> 
       </div>
       
   """)))})),format.raw/*27.5*/("""
    
""")))})))}
    }
    
    def render(bookid:Long,booktitle:String,catalogueForm:Form[Catalogue]) = apply(bookid,booktitle,catalogueForm)
    
    def f:((Long,String,Form[Catalogue]) => play.api.templates.Html) = (bookid,booktitle,catalogueForm) => apply(bookid,booktitle,catalogueForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:10 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/catalogues/createForm.scala.html
                    HASH: 4b119041894c15f54b6d83af489852a192bf373b
                    MATRIX: 792->1|938->83|970->107|1054->62|1082->81|1110->161|1149->166|1162->172|1201->174|1259->197|1289->206|1354->237|1398->273|1437->275|1520->322|1599->379|1650->394|1907->629|2019->705|2047->711|2232->860|2247->866|2293->890|2376->942
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|37->8|37->8|38->9|38->9|38->9|41->12|41->12|42->13|47->18|48->19|48->19|53->24|53->24|53->24|56->27
                    -- GENERATED --
                */
            