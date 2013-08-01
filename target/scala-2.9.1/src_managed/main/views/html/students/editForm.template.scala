
package views.html.students

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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[Student],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,studentForm: Form[Student]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.39*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
    <h1 class="heading">Edit a student</h1>
    
    """),_display_(Seq[Any](/*10.6*/form(routes.Students.update(id))/*10.38*/ {_display_(Seq[Any](format.raw/*10.40*/("""
        
        <fieldset>
        	"""),_display_(Seq[Any](/*13.11*/inputText(studentForm("nim"), '_label -> "NIM"))),format.raw/*13.58*/("""        
            """),_display_(Seq[Any](/*14.14*/inputText(studentForm("name"), '_label -> "Name"))),format.raw/*14.63*/("""                        
            """),_display_(Seq[Any](/*15.14*/select(
                studentForm("faculty.id"), 
                options(Faculty.options), 
                '_label -> "Faculty",
                '_showConstraints -> false
            ))),format.raw/*20.14*/("""   
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save" class="btn primary">  
            <a href=""""),_display_(Seq[Any](/*25.23*/routes/*25.29*/.Students.list())),format.raw/*25.45*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*28.6*/("""
    """),_display_(Seq[Any](/*29.6*/form(routes.Students.delete(id), 'class -> "topRight")/*29.60*/ {_display_(Seq[Any](format.raw/*29.62*/("""
        <input type="submit" value="Delete" class="btn danger">
    """)))})),format.raw/*31.6*/("""
""")))})))}
    }
    
    def render(id:Long,studentForm:Form[Student]) = apply(id,studentForm)
    
    def f:((Long,Form[Student]) => play.api.templates.Html) = (id,studentForm) => apply(id,studentForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:08 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/students/editForm.scala.html
                    HASH: 90a48549a5b9e0b30e1d7f7abea43349264bfb0a
                    MATRIX: 779->1|901->59|933->83|1017->38|1045->57|1073->137|1111->141|1124->147|1163->149|1257->208|1298->240|1338->242|1413->281|1482->328|1540->350|1611->399|1685->437|1896->626|2086->780|2101->786|2139->802|2225->857|2266->863|2329->917|2369->919|2470->989
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|39->10|39->10|39->10|42->13|42->13|43->14|43->14|44->15|49->20|54->25|54->25|54->25|57->28|58->29|58->29|58->29|60->31
                    -- GENERATED --
                */
            