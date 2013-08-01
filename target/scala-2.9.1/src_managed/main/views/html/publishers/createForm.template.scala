
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Publisher],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(publisherForm: Form[Publisher]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
    <h1 class="heading">Add a publisher</h1>
    
    """),_display_(Seq[Any](/*10.6*/form(routes.Publishers.save())/*10.36*/ {_display_(Seq[Any](format.raw/*10.38*/("""
        
        <fieldset>        
            """),_display_(Seq[Any](/*13.14*/inputText(publisherForm("name"), '_label -> "Publisher name"))),format.raw/*13.75*/("""            
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Add" class="btn primary">  
            <a href=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Publishers.list())),format.raw/*18.47*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*21.6*/("""
    
""")))})))}
    }
    
    def render(publisherForm:Form[Publisher]) = apply(publisherForm)
    
    def f:((Form[Publisher]) => play.api.templates.Html) = (publisherForm) => apply(publisherForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:10 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/publishers/createForm.scala.html
                    HASH: 4450df7d2ee6159d517120946e1aac7cc0956ad6
                    MATRIX: 780->1|897->54|929->78|1013->33|1041->52|1069->132|1107->136|1120->142|1159->144|1254->204|1293->234|1333->236|1419->286|1502->347|1700->509|1715->515|1755->533|1841->588
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|39->10|39->10|39->10|42->13|42->13|47->18|47->18|47->18|50->21
                    -- GENERATED --
                */
            