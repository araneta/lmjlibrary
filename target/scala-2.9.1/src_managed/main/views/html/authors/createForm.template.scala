
package views.html.authors

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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Author],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(authorForm: Form[Author]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.28*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
    <h1 class="heading">Add a author</h1>
    
    """),_display_(Seq[Any](/*10.6*/form(routes.Authors.save())/*10.33*/ {_display_(Seq[Any](format.raw/*10.35*/("""
        
        <fieldset>        
            """),_display_(Seq[Any](/*13.14*/inputText(authorForm("name"), '_label -> "Author name"))),format.raw/*13.69*/("""            
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Add" class="btn primary">  
            <a href=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Authors.list())),format.raw/*18.44*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*21.6*/("""
    
""")))})))}
    }
    
    def render(authorForm:Form[Author]) = apply(authorForm)
    
    def f:((Form[Author]) => play.api.templates.Html) = (authorForm) => apply(authorForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/authors/createForm.scala.html
                    HASH: a2af642b1cee24202449712c335fefff85b2c24b
                    MATRIX: 774->1|885->48|917->72|1001->27|1029->46|1057->126|1095->130|1108->136|1147->138|1239->195|1275->222|1315->224|1401->274|1478->329|1676->491|1691->497|1728->512|1814->567
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|39->10|39->10|39->10|42->13|42->13|47->18|47->18|47->18|50->21
                    -- GENERATED --
                */
            