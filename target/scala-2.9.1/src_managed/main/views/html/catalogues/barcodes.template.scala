
package views.html.catalogues

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
object barcodes extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Array[String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(barcodes:Array[String]):play.api.templates.Html = {
        _display_ {
def /*2.2*/imgpath/*2.9*/(barcode:String) = {{	
	"/assets/images/barcode/"+barcode+".png"	
	//routes.BarcodeImages.getFile(barcode+".png")
}};
Seq[Any](format.raw/*1.26*/("""
"""),format.raw/*5.2*/("""
<html>
<head>
	<style>
		.barcodelist li"""),format.raw("""{"""),format.raw/*9.19*/(""" float:left; padding:20px;list-style:none outside none;border:thin solid #000;"""),format.raw("""}"""),format.raw/*9.98*/("""
	</style>
</head>
<body>
	<ul class="barcodelist">
	"""),_display_(Seq[Any](/*14.3*/for(barcode <- barcodes) yield /*14.27*/ {_display_(Seq[Any](format.raw/*14.29*/("""
	    <li><img src=""""),_display_(Seq[Any](/*15.21*/imgpath(barcode))),format.raw/*15.37*/("""" /></li>
	""")))})),format.raw/*16.3*/("""
	</ul>
</body>
</html>
"""))}
    }
    
    def render(barcodes:Array[String]) = apply(barcodes)
    
    def f:((Array[String]) => play.api.templates.Html) = (barcodes) => apply(barcodes)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 20:14:21 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/catalogues/barcodes.scala.html
                    HASH: e0eba5ba1f357371352daf56a8624f22952fd67d
                    MATRIX: 776->1|860->27|874->34|1019->25|1046->149|1134->191|1259->270|1348->324|1388->348|1428->350|1485->371|1523->387|1566->399
                    LINES: 27->1|29->2|29->2|33->1|34->5|38->9|38->9|43->14|43->14|43->14|44->15|44->15|45->16
                    -- GENERATED --
                */
            