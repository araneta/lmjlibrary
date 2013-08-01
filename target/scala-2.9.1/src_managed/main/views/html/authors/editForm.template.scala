
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[Author],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long,authorForm: Form[Author]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.37*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq[Any](/*7.2*/main()/*7.8*/ {_display_(Seq[Any](format.raw/*7.10*/("""    
    <h1 class="heading">Edit an author</h1>
    
    """),_display_(Seq[Any](/*10.6*/form(routes.Authors.update(id))/*10.37*/ {_display_(Seq[Any](format.raw/*10.39*/("""
        
        <fieldset>        
            """),_display_(Seq[Any](/*13.14*/inputText(authorForm("name"), '_label -> "Author name"))),format.raw/*13.69*/("""            
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save" class="btn primary">  
            <a href=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Authors.list())),format.raw/*18.44*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*21.6*/("""
    """),_display_(Seq[Any](/*22.6*/form(routes.Authors.delete(id), 'class -> "topRight")/*22.59*/ {_display_(Seq[Any](format.raw/*22.61*/("""
        <input type="submit" value="Delete" class="btn danger">
    """)))})),format.raw/*24.6*/("""
""")))})))}
    }
    
    def render(id:Long,authorForm:Form[Author]) = apply(id,authorForm)
    
    def f:((Long,Form[Author]) => play.api.templates.Html) = (id,authorForm) => apply(id,authorForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/authors/editForm.scala.html
                    HASH: 8c07c4b864df27cbffc2d55fdf5f16eb681fa821
                    MATRIX: 777->1|897->57|929->81|1013->36|1041->55|1069->135|1107->139|1120->145|1159->147|1253->206|1293->237|1333->239|1419->289|1496->344|1695->507|1710->513|1747->528|1833->583|1874->589|1936->642|1976->644|2077->714
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|39->10|39->10|39->10|42->13|42->13|47->18|47->18|47->18|50->21|51->22|51->22|51->22|53->24
                    -- GENERATED --
                */
            