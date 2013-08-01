
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[Long,String,Page[Catalogue],String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(bookid:Long,booktitle:String, currentPage: Page[Catalogue], currentSortBy: String, currentOrder: String, currentFilter: String):play.api.templates.Html = {
        _display_ {
def /*32.2*/header/*32.8*/(key:String, title:String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*32.38*/("""
    <th class=""""),_display_(Seq[Any](/*33.17*/key/*33.20*/.replace(".","_"))),format.raw/*33.37*/(""" header """),_display_(Seq[Any](/*33.46*/if(currentSortBy == key){/*33.72*/{if(currentOrder == "asc") "headerSortDown" else "headerSortUp"}})),format.raw/*33.136*/("""">
        <a href=""""),_display_(Seq[Any](/*34.19*/link(0, key))),format.raw/*34.31*/("""">"""),_display_(Seq[Any](/*34.34*/title)),format.raw/*34.39*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage:Int, newSortBy:String) = {{
    
    var sortBy = currentSortBy
    var order = currentOrder
    
    if(newSortBy != null) {
        sortBy = newSortBy
        if(currentSortBy == newSortBy) {
            if(currentOrder == "asc") {
                order = "desc"
            } else {
                order = "asc"
            }
        } else {
            order = "asc"
        }
    }
    
    // Generate the link
    routes.Catalogues.list(bookid,newPage, sortBy, order, currentFilter)
    
}};
Seq[Any](format.raw/*1.130*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(Seq[Any](/*38.2*/main()/*38.8*/ {_display_(Seq[Any](format.raw/*38.10*/(""" 
    
    <h1 class="heading" id="homeTitle"><a href=""""),_display_(Seq[Any](/*40.50*/routes/*40.56*/.Books.edit(bookid))),format.raw/*40.75*/("""">"""),_display_(Seq[Any](/*40.78*/booktitle)),format.raw/*40.87*/("""</a> : """),_display_(Seq[Any](/*40.95*/Messages("catalogues.list.title", currentPage.getTotalRowCount))),format.raw/*40.158*/("""</h1>

    """),_display_(Seq[Any](/*42.6*/if(flash.containsKey("success"))/*42.38*/ {_display_(Seq[Any](format.raw/*42.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*44.37*/flash/*44.42*/.get("success"))),format.raw/*44.57*/("""
        </div>
    """)))})),format.raw/*46.6*/(""" 

    <div id="actions">
        
        <form action=""""),_display_(Seq[Any](/*50.24*/link(0, "barcode"))),format.raw/*50.42*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*51.66*/currentFilter)),format.raw/*51.79*/("""" placeholder="Filter by barcode...">
            <input type="submit" id="searchsubmit" value="Search" class="btn primary">
        </form>
        
        <a class="btn success" id="add" href=""""),_display_(Seq[Any](/*55.48*/routes/*55.54*/.Catalogues.create(bookid))),format.raw/*55.80*/("""">Add a new catalogue</a>
        
    </div>
    
    """),_display_(Seq[Any](/*59.6*/if(currentPage.getTotalRowCount == 0)/*59.43*/ {_display_(Seq[Any](format.raw/*59.45*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))}/*65.7*/else/*65.12*/{_display_(Seq[Any](format.raw/*65.13*/("""
        
        <table class="computers zebra-striped">
            <thead>
                <tr>
                	<th>Print</th>
                	"""),_display_(Seq[Any](/*71.19*/header("id", "Catalogue Id"))),format.raw/*71.47*/("""   
                    """),_display_(Seq[Any](/*72.22*/header("barcode", "Barcode"))),format.raw/*72.50*/("""                    
                    """),_display_(Seq[Any](/*73.22*/header("status", "Status"))),format.raw/*73.48*/("""                    
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*78.18*/for(catalogue <- currentPage.getList) yield /*78.55*/ {_display_(Seq[Any](format.raw/*78.57*/("""
                    <tr>
                    	<td><input type="checkbox" class="barcodeid" value=""""),_display_(Seq[Any](/*80.75*/catalogue/*80.84*/.barcode)),format.raw/*80.92*/("""" /></td>
                     	<td>"""),_display_(Seq[Any](/*81.28*/catalogue/*81.37*/.id)),format.raw/*81.40*/("""</td>
                        <td><a href=""""),_display_(Seq[Any](/*82.39*/routes/*82.45*/.Catalogues.edit(catalogue.id))),format.raw/*82.75*/("""">"""),_display_(Seq[Any](/*82.78*/catalogue/*82.87*/.barcode)),format.raw/*82.95*/("""</a></td>
                        <td>"""),_display_(Seq[Any](/*83.30*/catalogue/*83.39*/.status.status)),format.raw/*83.53*/("""</td>                                               
                    </tr>
                """)))})),format.raw/*85.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq[Any](/*92.18*/if(currentPage.hasPrev)/*92.41*/ {_display_(Seq[Any](format.raw/*92.43*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq[Any](/*94.35*/link(currentPage.getPageIndex - 1, null))),format.raw/*94.75*/("""">&larr; Previous</a>
                    </li>
                """)))}/*96.19*/else/*96.24*/{_display_(Seq[Any](format.raw/*96.25*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*100.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq[Any](/*102.36*/currentPage/*102.47*/.getDisplayXtoYofZ(" to "," of "))),format.raw/*102.80*/("""</a>
                </li>
                """),_display_(Seq[Any](/*104.18*/if(currentPage.hasNext)/*104.41*/ {_display_(Seq[Any](format.raw/*104.43*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq[Any](/*106.35*/link(currentPage.getPageIndex + 1, null))),format.raw/*106.75*/("""">Next &rarr;</a>
                    </li>
                """)))}/*108.19*/else/*108.24*/{_display_(Seq[Any](format.raw/*108.25*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*112.18*/("""
            </ul>
        </div>
        <a class="btn success" onclick="openWindow();return false;" >Print Barcodes</a>
        <script type="text/javascript">
        	function openWindow()"""),format.raw("""{"""),format.raw/*117.32*/("""
        		var ids = $('.barcodeid:checked').map(function() """),format.raw("""{"""),format.raw/*118.61*/("""return this.value;"""),format.raw("""}"""),format.raw/*118.80*/(""").get().join(',');
        		var url = "/catalogues/printbarcodes/"+ids;
        		var popupWindow = window.open(
        				url,'popUpWindow','resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes');
        	"""),format.raw("""}"""),format.raw/*122.11*/("""
        </script>
    """)))})),format.raw/*124.6*/("""
        
""")))})),format.raw/*126.2*/("""

            
"""))}
    }
    
    def render(bookid:Long,booktitle:String,currentPage:Page[Catalogue],currentSortBy:String,currentOrder:String,currentFilter:String) = apply(bookid,booktitle,currentPage,currentSortBy,currentOrder,currentFilter)
    
    def f:((Long,String,Page[Catalogue],String,String,String) => play.api.templates.Html) = (bookid,booktitle,currentPage,currentSortBy,currentOrder,currentFilter) => apply(bookid,booktitle,currentPage,currentSortBy,currentOrder,currentFilter)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:10 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/catalogues/list.scala.html
                    HASH: 7d626775349e3a5c4851744fc1b94fed40bc8e36
                    MATRIX: 807->1|996->881|1010->887|1104->917|1157->934|1169->937|1208->954|1253->963|1287->989|1375->1053|1432->1074|1466->1086|1505->1089|1532->1094|1570->258|1581->262|2119->129|2148->256|2176->769|2206->879|2234->1110|2272->1113|2286->1119|2326->1121|2418->1177|2433->1183|2474->1202|2513->1205|2544->1214|2588->1222|2674->1285|2721->1297|2762->1329|2802->1331|2919->1412|2933->1417|2970->1432|3022->1453|3116->1511|3156->1529|3273->1610|3308->1623|3541->1820|3556->1826|3604->1852|3695->1908|3741->1945|3781->1947|3905->2054|3918->2059|3957->2060|4142->2209|4192->2237|4253->2262|4303->2290|4381->2332|4429->2358|4567->2460|4620->2497|4660->2499|4796->2599|4814->2608|4844->2616|4917->2653|4935->2662|4960->2665|5040->2709|5055->2715|5107->2745|5146->2748|5164->2757|5194->2765|5269->2804|5287->2813|5323->2827|5451->2923|5611->3047|5643->3070|5683->3072|5792->3145|5854->3185|5938->3251|5951->3256|5990->3257|6161->3395|6271->3468|6292->3479|6348->3512|6429->3556|6462->3579|6503->3581|6613->3654|6676->3694|6757->3756|6771->3761|6811->3762|6978->3896|7219->4089|7328->4150|7395->4169|7691->4417|7747->4441|7790->4452
                    LINES: 27->1|29->32|29->32|31->32|32->33|32->33|32->33|32->33|32->33|32->33|33->34|33->34|33->34|33->34|35->6|35->6|57->1|59->5|60->27|62->31|63->36|65->38|65->38|65->38|67->40|67->40|67->40|67->40|67->40|67->40|67->40|69->42|69->42|69->42|71->44|71->44|71->44|73->46|77->50|77->50|78->51|78->51|82->55|82->55|82->55|86->59|86->59|86->59|92->65|92->65|92->65|98->71|98->71|99->72|99->72|100->73|100->73|105->78|105->78|105->78|107->80|107->80|107->80|108->81|108->81|108->81|109->82|109->82|109->82|109->82|109->82|109->82|110->83|110->83|110->83|112->85|119->92|119->92|119->92|121->94|121->94|123->96|123->96|123->96|127->100|129->102|129->102|129->102|131->104|131->104|131->104|133->106|133->106|135->108|135->108|135->108|139->112|144->117|145->118|145->118|149->122|151->124|153->126
                    -- GENERATED --
                */
            