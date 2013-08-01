
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
object searchResultForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Page[Book],String,String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[Book], currentFilter: String, filterby:String, currentSortBy: String, currentOrder: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.112*/("""

"""),_display_(Seq[Any](/*3.2*/home/*3.6*/ {_display_(Seq[Any](format.raw/*3.8*/("""        

    """),_display_(Seq[Any](/*5.6*/if(flash.containsKey("success"))/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*7.37*/flash/*7.42*/.get("success"))),format.raw/*7.57*/("""
        </div>
    """)))})),format.raw/*9.6*/(""" 

    <div id="actions">
        
        <form action=""""),_display_(Seq[Any](/*13.24*/routes/*13.30*/.Library.search(0, currentFilter, filterby, currentSortBy, currentOrder))),format.raw/*13.102*/("""" method="GET">
            <span class="st1">Search</span>
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*15.66*/currentFilter)),format.raw/*15.79*/("""" placeholder="keywords...">
            <span class="st2">in</span>
            <select name="fb" id="fb">            	
            	<option """),_display_(Seq[Any](/*18.23*/if(filterby == "title")/*18.46*/{_display_(Seq[Any](format.raw/*18.47*/(""" selected="selected" """)))})),format.raw/*18.69*/(""" value="title">Title</option>
            	<option """),_display_(Seq[Any](/*19.23*/if(filterby == "authors_text")/*19.53*/{_display_(Seq[Any](format.raw/*19.54*/(""" selected="selected" """)))})),format.raw/*19.76*/(""" value="authors_text">Author</option>            	
            </select>
           <div style="clear:both"></div>
            <span class="st1">Sort by</span>
       		<select name="s" id="s">
       			<option """),_display_(Seq[Any](/*24.20*/if(currentSortBy == "title")/*24.48*/{_display_(Seq[Any](format.raw/*24.49*/(""" selected="selected" """)))})),format.raw/*24.71*/(""" value="title">Title</option>
            	<!-- <option """),_display_(Seq[Any](/*25.28*/if(currentSortBy == "year")/*25.55*/{_display_(Seq[Any](format.raw/*25.56*/(""" selected="selected" """)))})),format.raw/*25.78*/(""" value="year">Year</option> -->            		            	            
            </select>
            <span class="st2">in</span>
            <select name="o" id="o">
            	<option value="asc" """),_display_(Seq[Any](/*29.35*/if(currentOrder == "asc")/*29.60*/{_display_(Seq[Any](format.raw/*29.61*/(""" selected="selected" """)))})),format.raw/*29.83*/(""">Ascending</option>
            	<option value="desc" """),_display_(Seq[Any](/*30.36*/if(currentOrder == "desc")/*30.62*/{_display_(Seq[Any](format.raw/*30.63*/(""" selected="selected" """)))})),format.raw/*30.85*/(""">Descending</option>	            	            	
            </select>
            <input type="submit" id="searchsubmit" value="Search" class="btn primary">
        </form>
        
    </div>
   
	    <h1 id="searchResCount">"""),_display_(Seq[Any](/*37.31*/Messages("books.list.title", currentPage.getTotalRowCount))),format.raw/*37.89*/("""</h1>
	    """),_display_(Seq[Any](/*38.7*/if(currentPage.getTotalRowCount == 0)/*38.44*/ {_display_(Seq[Any](format.raw/*38.46*/("""
	        
	        <div class="well">
	            <em>Nothing to display</em>
	        </div>
	        
	    """)))}/*44.8*/else/*44.13*/{_display_(Seq[Any](format.raw/*44.14*/("""
	       
	        <table class="computers zebra-striped">
	            <tbody>
	                """),_display_(Seq[Any](/*48.19*/for(book <- currentPage.getList) yield /*48.51*/ {_display_(Seq[Any](format.raw/*48.53*/("""
	                    <tr>                     	
	                        <td>
	                        	<div class="title">
	                        		<a href=""""),_display_(Seq[Any](/*52.38*/routes/*52.44*/.Library.details(book.id))),format.raw/*52.69*/("""">"""),_display_(Seq[Any](/*52.72*/book/*52.76*/.title)),format.raw/*52.82*/("""</a>
	                        	</div>	
	                        	<span class="authort">Author</span><span class="symbol">:</span><span class="authorv">"""),_display_(Seq[Any](/*54.114*/book/*54.118*/.authors_text)),format.raw/*54.131*/("""</span><br />
	                        	<span class="pubt">Publisher</span><span class="symbol">:</span><span class="pubv">"""),_display_(Seq[Any](/*55.111*/book/*55.115*/.publisher_text)),format.raw/*55.130*/("""</span><br />
	                        </td>
	                    </tr>
	                """)))})),format.raw/*58.19*/("""
	
	            </tbody>
	        </table>
	
	        <div id="pagination" class="pagination">
	            <ul>
	                """),_display_(Seq[Any](/*65.19*/if(currentPage.hasPrev)/*65.42*/ {_display_(Seq[Any](format.raw/*65.44*/("""
	                    <li class="prev">
	                        <a href=""""),_display_(Seq[Any](/*67.36*/routes/*67.42*/.Library.search(currentPage.getPageIndex - 1, currentFilter, filterby, currentSortBy, currentOrder))),format.raw/*67.141*/("""">&larr; Previous</a>
	                    </li>
	                """)))}/*69.20*/else/*69.25*/{_display_(Seq[Any](format.raw/*69.26*/("""
	                    <li class="prev disabled">
	                        <a>&larr; Previous</a>
	                    </li>
	                """)))})),format.raw/*73.19*/("""
	                <li class="current">
	                    <a>Displaying """),_display_(Seq[Any](/*75.37*/currentPage/*75.48*/.getDisplayXtoYofZ(" to "," of "))),format.raw/*75.81*/("""</a>
	                </li>
	                """),_display_(Seq[Any](/*77.19*/if(currentPage.hasNext)/*77.42*/ {_display_(Seq[Any](format.raw/*77.44*/("""
	                    <li class="next">
	                        <a href=""""),_display_(Seq[Any](/*79.36*/routes/*79.42*/.Library.search(currentPage.getPageIndex + 1, currentFilter, filterby, currentSortBy, currentOrder))),format.raw/*79.141*/("""">Next &rarr;</a>
	                    </li>
	                """)))}/*81.20*/else/*81.25*/{_display_(Seq[Any](format.raw/*81.26*/("""
	                    <li class="next disabled">
	                        <a>Next &rarr;</a>
	                    </li>
	                """)))})),format.raw/*85.19*/("""
	            </ul>
	        </div>	        	    
    """)))})),format.raw/*88.6*/("""
        
""")))})),format.raw/*90.2*/("""

            
"""))}
    }
    
    def render(currentPage:Page[Book],currentFilter:String,filterby:String,currentSortBy:String,currentOrder:String) = apply(currentPage,currentFilter,filterby,currentSortBy,currentOrder)
    
    def f:((Page[Book],String,String,String,String) => play.api.templates.Html) = (currentPage,currentFilter,filterby,currentSortBy,currentOrder) => apply(currentPage,currentFilter,filterby,currentSortBy,currentOrder)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:10 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/libraries/searchResultForm.scala.html
                    HASH: 938ebb9894bb6334772ebc47f035ce08093f42b0
                    MATRIX: 808->1|996->111|1033->114|1044->118|1082->120|1131->135|1171->167|1210->169|1326->250|1339->255|1375->270|1426->291|1520->349|1535->355|1630->427|1791->552|1826->565|2005->708|2037->731|2076->732|2130->754|2218->806|2257->836|2296->837|2350->859|2599->1072|2636->1100|2675->1101|2729->1123|2822->1180|2858->1207|2897->1208|2951->1230|3191->1434|3225->1459|3264->1460|3318->1482|3409->1537|3444->1563|3483->1564|3537->1586|3800->1813|3880->1871|3927->1883|3973->1920|4013->1922|4143->2035|4156->2040|4195->2041|4329->2139|4377->2171|4417->2173|4615->2335|4630->2341|4677->2366|4716->2369|4729->2373|4757->2379|4946->2531|4960->2535|4996->2548|5157->2672|5171->2676|5209->2691|5331->2781|5498->2912|5530->2935|5570->2937|5681->3012|5696->3018|5818->3117|5904->3185|5917->3190|5956->3191|6130->3333|6241->3408|6261->3419|6316->3452|6398->3498|6430->3521|6470->3523|6581->3598|6596->3604|6718->3703|6800->3767|6813->3772|6852->3773|7022->3911|7108->3966|7150->3977
                    LINES: 27->1|30->1|32->3|32->3|32->3|34->5|34->5|34->5|36->7|36->7|36->7|38->9|42->13|42->13|42->13|44->15|44->15|47->18|47->18|47->18|47->18|48->19|48->19|48->19|48->19|53->24|53->24|53->24|53->24|54->25|54->25|54->25|54->25|58->29|58->29|58->29|58->29|59->30|59->30|59->30|59->30|66->37|66->37|67->38|67->38|67->38|73->44|73->44|73->44|77->48|77->48|77->48|81->52|81->52|81->52|81->52|81->52|81->52|83->54|83->54|83->54|84->55|84->55|84->55|87->58|94->65|94->65|94->65|96->67|96->67|96->67|98->69|98->69|98->69|102->73|104->75|104->75|104->75|106->77|106->77|106->77|108->79|108->79|108->79|110->81|110->81|110->81|114->85|117->88|119->90
                    -- GENERATED --
                */
            