
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Student],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(studentForm: Form[Student]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
    <h1 class="heading">Add a student</h1>
    
    """),_display_(Seq[Any](/*10.6*/form(routes.Students.save())/*10.34*/ {_display_(Seq[Any](format.raw/*10.36*/("""
        
        <fieldset>
        	"""),_display_(Seq[Any](/*13.11*/inputText(studentForm("nim"), '_label -> "NIM"))),format.raw/*13.58*/("""        
            """),_display_(Seq[Any](/*14.14*/inputText(studentForm("name"), '_label -> "Name"))),format.raw/*14.63*/("""             
            """),_display_(Seq[Any](/*15.14*/select(
                studentForm("faculty.id"), 
                options(Faculty.options), 
                '_label -> "Faculty", '_default -> "-- Choose a faculty --",
                '_showConstraints -> false
            ))),format.raw/*20.14*/("""               
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Add" class="btn primary">  
            <a href=""""),_display_(Seq[Any](/*25.23*/routes/*25.29*/.Students.list())),format.raw/*25.45*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*28.6*/("""
    
""")))})))}
    }
    
    def render(studentForm:Form[Student]) = apply(studentForm)
    
    def f:((Form[Student]) => play.api.templates.Html) = (studentForm) => apply(studentForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:08 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/students/createForm.scala.html
                    HASH: 60ca115e8dd0a2e727258e5eee703b2dc017d773
                    MATRIX: 776->1|889->50|921->74|1005->29|1033->48|1061->128|1099->132|1112->138|1151->140|1244->198|1281->226|1321->228|1396->267|1465->314|1523->336|1594->385|1657->412|1907->640|2108->805|2123->811|2161->827|2247->882
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|39->10|39->10|39->10|42->13|42->13|43->14|43->14|44->15|49->20|54->25|54->25|54->25|57->28
                    -- GENERATED --
                */
            