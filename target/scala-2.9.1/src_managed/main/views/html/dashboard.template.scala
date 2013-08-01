
package views.html

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
object dashboard extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main()/*1.8*/ {_display_(Seq[Any](format.raw/*1.10*/("""   
    <header>
        <hgroup>
            <h1></h1>
            <h2></h2>
        </hgroup>
    </header>
    <article  class="tasks">
        
    </article>
    
""")))})),format.raw/*12.2*/("""   


"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:07 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/dashboard.scala.html
                    HASH: 368e6c72d37f2c98b4a0a37d7db1d5370bdba743
                    MATRIX: 832->1|845->7|884->9|1084->178
                    LINES: 30->1|30->1|30->1|41->12
                    -- GENERATED --
                */
            