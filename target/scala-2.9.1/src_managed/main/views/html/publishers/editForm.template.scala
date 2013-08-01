
package views.html.publishers

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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[Publisher],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,publisherForm: Form[Publisher]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.43*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
    <h1 class="heading">Edit a publisher</h1>
    
    """),_display_(Seq[Any](/*10.6*/form(routes.Publishers.update(id))/*10.40*/ {_display_(Seq[Any](format.raw/*10.42*/("""
        
        <fieldset>        
            """),_display_(Seq[Any](/*13.14*/inputText(publisherForm("name"), '_label -> "Publisher name"))),format.raw/*13.75*/("""            
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save" class="btn primary">  
            <a href=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Publishers.list())),format.raw/*18.47*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*21.6*/("""
    """),_display_(Seq[Any](/*22.6*/form(routes.Publishers.delete(id), 'class -> "topRight")/*22.62*/ {_display_(Seq[Any](format.raw/*22.64*/("""
        <input type="submit" value="Delete" class="btn danger">
    """)))})),format.raw/*24.6*/("""
""")))})))}
    }
    
    def render(id:Long,publisherForm:Form[Publisher]) = apply(id,publisherForm)
    
    def f:((Long,Form[Publisher]) => play.api.templates.Html) = (id,publisherForm) => apply(id,publisherForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:10 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/publishers/editForm.scala.html
                    HASH: 62664bb2c9c3deb2a70b754d963c88c4a9065fa6
                    MATRIX: 783->1|909->63|941->87|1025->42|1053->61|1081->141|1119->145|1132->151|1171->153|1267->214|1310->248|1350->250|1436->300|1519->361|1718->524|1733->530|1773->548|1859->603|1900->609|1965->665|2005->667|2106->737
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|39->10|39->10|39->10|42->13|42->13|47->18|47->18|47->18|50->21|51->22|51->22|51->22|53->24
                    -- GENERATED --
                */
            