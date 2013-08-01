
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,Html,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(styles: Html = Html(""),scripts: Html = Html(""))(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.67*/("""
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="utf-8" />
        <title>LMJ Library</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*7.59*/routes/*7.65*/.Assets.at("images/favicon.png"))),format.raw/*7.97*/("""" >    
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*8.119*/("""" >         
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*9.70*/routes/*9.76*/.Assets.at("stylesheets/main.css"))),format.raw/*9.110*/("""" >
        """),_display_(Seq[Any](/*10.10*/styles)),format.raw/*10.16*/("""
            
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Assets.at("javascripts/jquery-1.7.1.js"))),format.raw/*12.93*/("""" ></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*13.46*/routes/*13.52*/.Assets.at("javascripts/jquery-play-1.7.1.js"))),format.raw/*13.98*/("""" ></script>
        <script type="text/javascript" src='"""),_display_(Seq[Any](/*14.46*/routes/*14.52*/.Application.javascriptRoutes())),format.raw/*14.83*/("""'></script>   
       	"""),_display_(Seq[Any](/*15.10*/scripts)),format.raw/*15.17*/(""" 
    </head>
    <body>
        <header>
            <a href="" id="logo"><span>Lmj</span>Library</a>
            <dl id="user">
                <dt>"""),_display_(Seq[Any](/*21.22*/(session.get("username")))),format.raw/*21.47*/(""" <span>"""),_display_(Seq[Any](/*21.55*/(session.get("fullname")))),format.raw/*21.80*/("""</span></dt>
                <dd>
                    <a href=""""),_display_(Seq[Any](/*23.31*/routes/*23.37*/.Application.logout())),format.raw/*23.58*/("""">Logout</a>
                </dd>
            </dl>
        </header>
        <nav>
            <h4 class="dashboard"><a href="#/">Dashboard</a></h4>            
            <ul id="menu">
            	<li class="main">
            		<div>Master Data</div>
            		<ul>
            			<li><a href=""""),_display_(Seq[Any](/*33.30*/routes/*33.36*/.Publishers.list())),format.raw/*33.54*/("""">Publisher</a></li>
            			<li><a href=""""),_display_(Seq[Any](/*34.30*/routes/*34.36*/.Authors.list())),format.raw/*34.51*/("""">Author</a></li>
            			<li><a href=""""),_display_(Seq[Any](/*35.30*/routes/*35.36*/.Students.list())),format.raw/*35.52*/("""">Student</a></li>
            			<li><a href=""""),_display_(Seq[Any](/*36.30*/routes/*36.36*/.Books.list())),format.raw/*36.49*/("""">Book</a></li>
            			<li><a href=""""),_display_(Seq[Any](/*37.30*/routes/*37.36*/.Settings.index())),format.raw/*37.53*/("""">Settings</a></li>
            		</ul>
            	</li>
            	<li class="main">
            		<div>Transactions</div>
            		<ul>
            			<li><a href=""""),_display_(Seq[Any](/*43.30*/routes/*43.36*/.TransBorrowing.index())),format.raw/*43.59*/("""">Borrowing</a></li>
            		</ul>
            	</li>
            	<li class="main">
            		<div>Reports</div>
            		<ul>
            			<li><a href=""""),_display_(Seq[Any](/*49.30*/routes/*49.36*/.Reports.borrowedBooks())),format.raw/*49.60*/("""">Borrowed Books</a></li>
            			<li><a href=""""),_display_(Seq[Any](/*50.30*/routes/*50.36*/.Reports.returnedBooks())),format.raw/*50.60*/("""">Returned Books</a></li>
            			<li><a href=""""),_display_(Seq[Any](/*51.30*/routes/*51.36*/.Reports.overdueBooks())),format.raw/*51.59*/("""">Overdue Books</a></li>
            		</ul>
            	</li>
            </ul>
        </nav>
        <section id="main">
            """),_display_(Seq[Any](/*57.14*/content)),format.raw/*57.21*/("""
        </section>
    </body>
</html>

"""))}
    }
    
    def render(styles:Html,scripts:Html,content:Html) = apply(styles,scripts)(content)
    
    def f:((Html,Html) => (Html) => play.api.templates.Html) = (styles,scripts) => (content) => apply(styles,scripts)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:07 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/main.scala.html
                    HASH: 2c6a76e1a7b73b2a826905f16bc37a2af60aaa30
                    MATRIX: 762->1|904->66|1097->224|1111->230|1164->262|1276->339|1290->345|1355->388|1472->470|1486->476|1542->510|1591->523|1619->529|1714->588|1729->594|1792->635|1886->693|1901->699|1969->745|2063->803|2078->809|2131->840|2191->864|2220->871|2407->1022|2454->1047|2498->1055|2545->1080|2645->1144|2660->1150|2703->1171|3045->1477|3060->1483|3100->1501|3186->1551|3201->1557|3238->1572|3321->1619|3336->1625|3374->1641|3458->1689|3473->1695|3508->1708|3589->1753|3604->1759|3643->1776|3855->1952|3870->1958|3915->1981|4123->2153|4138->2159|4184->2183|4275->2238|4290->2244|4336->2268|4427->2323|4442->2329|4487->2352|4661->2490|4690->2497
                    LINES: 27->1|30->1|36->7|36->7|36->7|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|41->12|41->12|41->12|42->13|42->13|42->13|43->14|43->14|43->14|44->15|44->15|50->21|50->21|50->21|50->21|52->23|52->23|52->23|62->33|62->33|62->33|63->34|63->34|63->34|64->35|64->35|64->35|65->36|65->36|65->36|66->37|66->37|66->37|72->43|72->43|72->43|78->49|78->49|78->49|79->50|79->50|79->50|80->51|80->51|80->51|86->57|86->57
                    -- GENERATED --
                */
            