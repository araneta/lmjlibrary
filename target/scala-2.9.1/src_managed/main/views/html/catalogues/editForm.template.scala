
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Long,Long,String,Form[Catalogue],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,bookid:Long,booktitle:String,catalogueForm: Form[Catalogue]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.72*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
	<h1>"""),_display_(Seq[Any](/*8.7*/booktitle)),format.raw/*8.16*/(""" : Edit a catalogue</h1>
	
	"""),_display_(Seq[Any](/*10.3*/form(routes.Catalogues.update(id,bookid))/*10.44*/ {_display_(Seq[Any](format.raw/*10.46*/("""
	    
	    <fieldset>        
	        """),_display_(Seq[Any](/*13.11*/inputText(catalogueForm("barcode"), '_label -> "Barcode"))),format.raw/*13.68*/("""
	        """),_display_(Seq[Any](/*14.11*/select(
                catalogueForm("status.id"), 
                options(CatalogueStatus.options),  
                '_label -> "Status",
                '_showConstraints -> false
            ))),format.raw/*19.14*/("""          
             <input type="hidden" name="book.id" value=""""),_display_(Seq[Any](/*20.58*/bookid)),format.raw/*20.64*/("""" />        	        
	    </fieldset>
	    
	    <div class="actions">
	        <input type="submit" value="Save" class="btn primary">  
	        <a href=""""),_display_(Seq[Any](/*25.20*/routes/*25.26*/.Catalogues.list(bookid))),format.raw/*25.50*/("""" class="btn">Cancel</a> 	               
	    </div>
	    
	""")))})),format.raw/*28.3*/("""
	"""),_display_(Seq[Any](/*29.3*/form(routes.Catalogues.delete(id), 'class -> "topRight")/*29.59*/ {_display_(Seq[Any](format.raw/*29.61*/("""
	    <input type="submit" value="Delete" class="btn danger">
	""")))})),format.raw/*31.3*/("""
	
	
""")))})))}
    }
    
    def render(id:Long,bookid:Long,booktitle:String,catalogueForm:Form[Catalogue]) = apply(id,bookid,booktitle,catalogueForm)
    
    def f:((Long,Long,String,Form[Catalogue]) => play.api.templates.Html) = (id,bookid,booktitle,catalogueForm) => apply(id,bookid,booktitle,catalogueForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:10 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/catalogues/editForm.scala.html
                    HASH: 27781c8a8ab586d706709b097d7c7723ab450feb
                    MATRIX: 795->1|950->92|982->116|1066->71|1094->90|1122->170|1160->174|1173->180|1212->182|1257->193|1287->202|1351->231|1401->272|1441->274|1518->315|1597->372|1644->383|1864->581|1968->649|1996->655|2189->812|2204->818|2250->842|2343->904|2381->907|2446->963|2486->965|2581->1029
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|37->8|37->8|39->10|39->10|39->10|42->13|42->13|43->14|48->19|49->20|49->20|54->25|54->25|54->25|57->28|58->29|58->29|58->29|60->31
                    -- GENERATED --
                */
            