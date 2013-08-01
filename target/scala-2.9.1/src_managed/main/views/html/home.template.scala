
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
object home extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""
<html>
    <head>       
    	<meta charset="utf-8" />
        <title>LMJ Library</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png"))),format.raw/*6.97*/("""" >    
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/("""" >         
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/home.css"))),format.raw/*8.110*/("""" >    
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*9.46*/routes/*9.52*/.Assets.at("javascripts/jquery-1.7.1.js"))),format.raw/*9.93*/("""" ></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Assets.at("javascripts/jquery-play-1.7.1.js"))),format.raw/*10.98*/("""" ></script>                  
    </head>
    <body>
        
        <header>
            <a href="" id="logo"><span>Lmj</span>Library</a>
        </header>       
        <section id="main">
            """),_display_(Seq[Any](/*18.14*/content)),format.raw/*18.21*/("""
        </section>
            
    </body>
</html>
    


"""))}
    }
    
    def render(content:Html) = apply(content)
    
    def f:((Html) => play.api.templates.Html) = (content) => apply(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:08 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/home.scala.html
                    HASH: ea5908ed6c9ef6320bfe139b696aba689fb0ad76
                    MATRIX: 752->1|844->16|1028->165|1042->171|1095->203|1207->280|1221->286|1286->329|1403->411|1417->417|1473->451|1561->504|1575->510|1637->551|1731->609|1746->615|1814->661|2057->868|2086->875
                    LINES: 27->1|30->1|35->6|35->6|35->6|36->7|36->7|36->7|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|47->18|47->18
                    -- GENERATED --
                */
            