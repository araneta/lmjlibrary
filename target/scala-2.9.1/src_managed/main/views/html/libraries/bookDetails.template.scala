
package views.html.libraries

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
object bookDetails extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[viewmodels.BookCatalogueDetails,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(details: viewmodels.BookCatalogueDetails):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""
"""),_display_(Seq[Any](/*2.2*/home/*2.6*/ {_display_(Seq[Any](format.raw/*2.8*/("""
	<h1 class="heading">"""),_display_(Seq[Any](/*3.23*/details/*3.30*/.title)),format.raw/*3.36*/("""</h1>
	
	<div id="bookimg">
	</div>
	<div id="bookdetails">
		<b>Author(s):</b><br />
		"""),_display_(Seq[Any](/*9.4*/details/*9.11*/.author)),format.raw/*9.18*/("""<br />
		<br />
		<b>Publisher:</b><br />
		"""),_display_(Seq[Any](/*12.4*/details/*12.11*/.publisher)),format.raw/*12.21*/("""<br />
		<br />
		<b>Publish Year:</b><br />
		"""),_display_(Seq[Any](/*15.4*/details/*15.11*/.publish_year)),format.raw/*15.24*/("""<br />
		<br />
		<b>ISBN:</b><br />
		"""),_display_(Seq[Any](/*18.4*/details/*18.11*/.isbn)),format.raw/*18.16*/("""<br />
		<br />
		<b>Exemplar:</b><br />
		<div id="exemplar">
			<table>
				<thead>
	                <tr>
	                	<th width="80">Barcode</th>
	                	<th width="90">Status</th>                    
	                	<th>Description</th>
	                </tr>
	            </thead>
	            <tbody>
	
	                """),_display_(Seq[Any](/*32.19*/for(catalogue <- details.catalogues) yield /*32.55*/ {_display_(Seq[Any](format.raw/*32.57*/("""
	                    <tr>
	                     	<td>"""),_display_(Seq[Any](/*34.29*/catalogue/*34.38*/.barcode)),format.raw/*34.46*/("""</td>
	                        <td>"""),_display_(Seq[Any](/*35.31*/catalogue/*35.40*/.status)),format.raw/*35.47*/("""</td>
	                        <td>"""),_display_(Seq[Any](/*36.31*/if(catalogue.status=="Not Available" && catalogue.borrowed_by!=null)/*36.99*/{_display_(Seq[Any](format.raw/*36.100*/(""" borrowed by : """),_display_(Seq[Any](/*36.116*/catalogue/*36.125*/.borrowed_by)),format.raw/*36.137*/("""  on  """),_display_(Seq[Any](/*36.144*/catalogue/*36.153*/.borrowed_date))))})),format.raw/*36.168*/("""</td>                                               
	                    </tr>
	                """)))})),format.raw/*38.19*/("""
	
	            </tbody>
			</table>
		</div>
	</div>
""")))})))}
    }
    
    def render(details:viewmodels.BookCatalogueDetails) = apply(details)
    
    def f:((viewmodels.BookCatalogueDetails) => play.api.templates.Html) = (details) => apply(details)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:09 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/libraries/bookDetails.scala.html
                    HASH: b59ca037dae4a4a5916df149a17502378cf60109
                    MATRIX: 796->1|915->43|951->45|962->49|1000->51|1058->74|1073->81|1100->87|1223->176|1238->183|1266->190|1346->235|1362->242|1394->252|1477->300|1493->307|1528->320|1603->360|1619->367|1646->372|2026->716|2078->752|2118->754|2209->809|2227->818|2257->826|2329->862|2347->871|2376->878|2448->914|2525->982|2565->983|2618->999|2637->1008|2672->1020|2716->1027|2735->1036|2777->1051|2907->1149
                    LINES: 27->1|30->1|31->2|31->2|31->2|32->3|32->3|32->3|38->9|38->9|38->9|41->12|41->12|41->12|44->15|44->15|44->15|47->18|47->18|47->18|61->32|61->32|61->32|63->34|63->34|63->34|64->35|64->35|64->35|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|67->38
                    -- GENERATED --
                */
            