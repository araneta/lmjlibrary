
package views.html.books

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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[Book],String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[Book], currentSortBy: String, currentOrder: String, currentFilter: String):play.api.templates.Html = {
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
    routes.Books.list(newPage, sortBy, order, currentFilter)
    
}};
Seq[Any](format.raw/*1.95*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(Seq[Any](/*38.2*/main()/*38.8*/ {_display_(Seq[Any](format.raw/*38.10*/(""" 
    
    <h1 class="heading" id="homeTitle">"""),_display_(Seq[Any](/*40.41*/Messages("books.list.title", currentPage.getTotalRowCount))),format.raw/*40.99*/("""</h1>

    """),_display_(Seq[Any](/*42.6*/if(flash.containsKey("success"))/*42.38*/ {_display_(Seq[Any](format.raw/*42.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*44.37*/flash/*44.42*/.get("success"))),format.raw/*44.57*/("""
        </div>
    """)))})),format.raw/*46.6*/(""" 

    <div id="actions">
        
        <form action=""""),_display_(Seq[Any](/*50.24*/link(0, "title"))),format.raw/*50.40*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*51.66*/currentFilter)),format.raw/*51.79*/("""" placeholder="Filter by book title...">
            <input type="submit" id="searchsubmit" value="Search" class="btn primary">
        </form>
        
        <a class="btn success" id="add" href=""""),_display_(Seq[Any](/*55.48*/routes/*55.54*/.Books.create())),format.raw/*55.69*/("""">Add a new book</a>
        
    </div>
    
    """),_display_(Seq[Any](/*59.6*/if(currentPage.getTotalRowCount == 0)/*59.43*/ {_display_(Seq[Any](format.raw/*59.45*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))}/*65.7*/else/*65.12*/{_display_(Seq[Any](format.raw/*65.13*/("""
        
        <table class="computers zebra-striped">
            <thead>
                <tr>
                	"""),_display_(Seq[Any](/*70.19*/header("id", "Book Id"))),format.raw/*70.42*/("""   
                    """),_display_(Seq[Any](/*71.22*/header("title", "Book Title"))),format.raw/*71.51*/("""                    
                    """),_display_(Seq[Any](/*72.22*/header("authors_text", "Author(s)"))),format.raw/*72.57*/("""
                    """),_display_(Seq[Any](/*73.22*/header("publisher_text", "Publisher"))),format.raw/*73.59*/("""
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*78.18*/for(book <- currentPage.getList) yield /*78.50*/ {_display_(Seq[Any](format.raw/*78.52*/("""
                    <tr>
                     	<td>"""),_display_(Seq[Any](/*80.28*/book/*80.32*/.id)),format.raw/*80.35*/("""</td>
                        <td><a href=""""),_display_(Seq[Any](/*81.39*/routes/*81.45*/.Books.edit(book.id))),format.raw/*81.65*/("""">"""),_display_(Seq[Any](/*81.68*/book/*81.72*/.title)),format.raw/*81.78*/("""</a></td>
                        <td>"""),_display_(Seq[Any](/*82.30*/book/*82.34*/.authors_text)),format.raw/*82.47*/("""</td>
                        <td>"""),_display_(Seq[Any](/*83.30*/book/*83.34*/.publisher_text)),format.raw/*83.49*/("""</td>                        
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
        
    """)))})),format.raw/*116.6*/("""
        
""")))})),format.raw/*118.2*/("""

            
"""))}
    }
    
    def render(currentPage:Page[Book],currentSortBy:String,currentOrder:String,currentFilter:String) = apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def f:((Page[Book],String,String,String) => play.api.templates.Html) = (currentPage,currentSortBy,currentOrder,currentFilter) => apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/books/list.scala.html
                    HASH: 34ff3ad1fafc6956d65a5dbc436e3416c82f8b44
                    MATRIX: 785->1|939->834|953->840|1047->870|1100->887|1112->890|1151->907|1196->916|1230->942|1318->1006|1375->1027|1409->1039|1448->1042|1475->1047|1513->223|1524->227|2049->94|2078->221|2106->722|2136->832|2164->1063|2202->1066|2216->1072|2256->1074|2339->1121|2419->1179|2466->1191|2507->1223|2547->1225|2664->1306|2678->1311|2715->1326|2767->1347|2861->1405|2899->1421|3016->1502|3051->1515|3287->1715|3302->1721|3339->1736|3425->1787|3471->1824|3511->1826|3635->1933|3648->1938|3687->1939|3840->2056|3885->2079|3946->2104|3997->2133|4075->2175|4132->2210|4190->2232|4249->2269|4367->2351|4415->2383|4455->2385|4544->2438|4557->2442|4582->2445|4662->2489|4677->2495|4719->2515|4758->2518|4771->2522|4799->2528|4874->2567|4887->2571|4922->2584|4993->2619|5006->2623|5043->2638|5148->2711|5308->2835|5340->2858|5380->2860|5489->2933|5551->2973|5635->3039|5648->3044|5687->3045|5858->3183|5968->3256|5989->3267|6045->3300|6126->3344|6159->3367|6200->3369|6310->3442|6373->3482|6454->3544|6468->3549|6508->3550|6675->3684|6755->3732|6798->3743
                    LINES: 27->1|29->32|29->32|31->32|32->33|32->33|32->33|32->33|32->33|32->33|33->34|33->34|33->34|33->34|35->6|35->6|57->1|59->5|60->27|62->31|63->36|65->38|65->38|65->38|67->40|67->40|69->42|69->42|69->42|71->44|71->44|71->44|73->46|77->50|77->50|78->51|78->51|82->55|82->55|82->55|86->59|86->59|86->59|92->65|92->65|92->65|97->70|97->70|98->71|98->71|99->72|99->72|100->73|100->73|105->78|105->78|105->78|107->80|107->80|107->80|108->81|108->81|108->81|108->81|108->81|108->81|109->82|109->82|109->82|110->83|110->83|110->83|112->85|119->92|119->92|119->92|121->94|121->94|123->96|123->96|123->96|127->100|129->102|129->102|129->102|131->104|131->104|131->104|133->106|133->106|135->108|135->108|135->108|139->112|143->116|145->118
                    -- GENERATED --
                */
            