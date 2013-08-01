
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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Login],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[Application.Login]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""

<html>
    <head>
        <title>Lmj Library</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png"))),format.raw/*6.97*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/login.css"))),format.raw/*7.111*/("""">
    </head>
    <body>
        
        <header>
            <a href="" id="logo"><span>Lmj</span>Library</a>
        </header>
        
        """),_display_(Seq[Any](/*15.10*/helper/*15.16*/.form(routes.Application.authenticate)/*15.54*/ {_display_(Seq[Any](format.raw/*15.56*/("""
            
            <h1>Sign in</h1>
            
            """),_display_(Seq[Any](/*19.14*/if(form.hasGlobalErrors)/*19.38*/ {_display_(Seq[Any](format.raw/*19.40*/(""" 
                <p class="error">
                    """),_display_(Seq[Any](/*21.22*/form/*21.26*/.globalError.message)),format.raw/*21.46*/("""
                </p>
            """)))})),format.raw/*23.14*/("""
            
            """),_display_(Seq[Any](/*25.14*/if(flash.contains("success"))/*25.43*/ {_display_(Seq[Any](format.raw/*25.45*/("""
                <p class="success">
                    """),_display_(Seq[Any](/*27.22*/flash/*27.27*/.get("success"))),format.raw/*27.42*/("""
                </p>
            """)))})),format.raw/*29.14*/("""
            
            <p>
                <input type="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*32.87*/form("username")/*32.103*/.value)),format.raw/*32.109*/("""">
            </p>
            <p>
                <input type="password" name="password" placeholder="Password">
            </p>
            <p>
                <button type="submit">Login</button>
            </p>
            
        """)))})),format.raw/*41.10*/("""
        
        <p class="note">
            Try <em>bejo</em> with <em>password</em> as password.
        </p>
            
    </body>
</html>
    


"""))}
    }
    
    def render(form:Form[Application.Login]) = apply(form)
    
    def f:((Form[Application.Login]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:08 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/login.scala.html
                    HASH: ae837dd7e3936d1da2ca1aa1d6426a1a77ca1de3
                    MATRIX: 772->1|880->32|1028->145|1042->151|1095->183|1202->255|1216->261|1273->296|1458->445|1473->451|1520->489|1560->491|1665->560|1698->584|1738->586|1831->643|1844->647|1886->667|1953->702|2016->729|2054->758|2094->760|2188->818|2202->823|2239->838|2306->873|2458->989|2484->1005|2513->1011|2785->1251
                    LINES: 27->1|30->1|35->6|35->6|35->6|36->7|36->7|36->7|44->15|44->15|44->15|44->15|48->19|48->19|48->19|50->21|50->21|50->21|52->23|54->25|54->25|54->25|56->27|56->27|56->27|58->29|61->32|61->32|61->32|70->41
                    -- GENERATED --
                */
            