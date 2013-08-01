
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[Author],String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[Author], currentSortBy: String, currentOrder: String, currentFilter: String):play.api.templates.Html = {
        _display_ {
def /*32.2*/header/*32.8*/(key:String, name:String, w:Integer):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*32.48*/("""
    <th width=""""),_display_(Seq[Any](/*33.17*/w)),format.raw/*33.18*/("""" class=""""),_display_(Seq[Any](/*33.28*/key/*33.31*/.replace(".","_"))),format.raw/*33.48*/(""" header """),_display_(Seq[Any](/*33.57*/if(currentSortBy == key){/*33.83*/{if(currentOrder == "asc") "headerSortDown" else "headerSortUp"}})),format.raw/*33.147*/("""">
        <a href=""""),_display_(Seq[Any](/*34.19*/link(0, key))),format.raw/*34.31*/("""">"""),_display_(Seq[Any](/*34.34*/name)),format.raw/*34.38*/("""</a>
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
    routes.Authors.list(newPage, sortBy, order, currentFilter)
    
}};
Seq[Any](format.raw/*1.97*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(Seq[Any](/*38.2*/main()/*38.8*/ {_display_(Seq[Any](format.raw/*38.10*/("""    
    <h1 class="heading" id="homename">"""),_display_(Seq[Any](/*39.40*/Messages("authors.list.title", currentPage.getTotalRowCount))),format.raw/*39.100*/("""</h1>

    """),_display_(Seq[Any](/*41.6*/if(flash.containsKey("success"))/*41.38*/ {_display_(Seq[Any](format.raw/*41.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*43.37*/flash/*43.42*/.get("success"))),format.raw/*43.57*/("""
        </div>
    """)))})),format.raw/*45.6*/(""" 

    <div id="actions">
        
        <form action=""""),_display_(Seq[Any](/*49.24*/link(0, "name"))),format.raw/*49.39*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*50.66*/currentFilter)),format.raw/*50.79*/("""" placeholder="Filter by author name..." />
            <input type="submit" id="searchsubmit" value="Search" class="btn primary" />
        </form>
        <br />
        <a class="btn success" id="add" href=""""),_display_(Seq[Any](/*54.48*/routes/*54.54*/.Authors.create())),format.raw/*54.71*/("""">Add a new author</a>
        <br /><br />
    </div>
    
    """),_display_(Seq[Any](/*58.6*/if(currentPage.getTotalRowCount == 0)/*58.43*/ {_display_(Seq[Any](format.raw/*58.45*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))}/*64.7*/else/*64.12*/{_display_(Seq[Any](format.raw/*64.13*/("""
        
        <table class="computers zebra-striped">
            <thead>
                <tr>
                	"""),_display_(Seq[Any](/*69.19*/header("id", "Author id",100))),format.raw/*69.48*/("""
                    """),_display_(Seq[Any](/*70.22*/header("name", "Author name",250))),format.raw/*70.55*/("""                    
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*75.18*/for(author <- currentPage.getList) yield /*75.52*/ {_display_(Seq[Any](format.raw/*75.54*/("""
                    <tr>
                    	<td>"""),_display_(Seq[Any](/*77.27*/author/*77.33*/.id)),format.raw/*77.36*/("""</td>
                        <td><a href=""""),_display_(Seq[Any](/*78.39*/routes/*78.45*/.Authors.edit(author.id))),format.raw/*78.69*/("""">"""),_display_(Seq[Any](/*78.72*/author/*78.78*/.name)),format.raw/*78.83*/("""</a></td>                        
                    </tr>
                """)))})),format.raw/*80.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq[Any](/*87.18*/if(currentPage.hasPrev)/*87.41*/ {_display_(Seq[Any](format.raw/*87.43*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq[Any](/*89.35*/link(currentPage.getPageIndex - 1, null))),format.raw/*89.75*/("""">&larr; Previous</a>
                    </li>
                """)))}/*91.19*/else/*91.24*/{_display_(Seq[Any](format.raw/*91.25*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*95.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq[Any](/*97.36*/currentPage/*97.47*/.getDisplayXtoYofZ(" to "," of "))),format.raw/*97.80*/("""</a>
                </li>
                """),_display_(Seq[Any](/*99.18*/if(currentPage.hasNext)/*99.41*/ {_display_(Seq[Any](format.raw/*99.43*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq[Any](/*101.35*/link(currentPage.getPageIndex + 1, null))),format.raw/*101.75*/("""">Next &rarr;</a>
                    </li>
                """)))}/*103.19*/else/*103.24*/{_display_(Seq[Any](format.raw/*103.25*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*107.18*/("""
            </ul>
        </div>
        
    """)))})),format.raw/*111.6*/("""
""")))})),format.raw/*112.2*/("""        


            
"""))}
    }
    
    def render(currentPage:Page[Author],currentSortBy:String,currentOrder:String,currentFilter:String) = apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def f:((Page[Author],String,String,String) => play.api.templates.Html) = (currentPage,currentSortBy,currentOrder,currentFilter) => apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/authors/list.scala.html
                    HASH: d4a03cace6496b8ed9ae4066a1ba3128aa7e9c62
                    MATRIX: 789->1|945->838|959->844|1063->884|1116->901|1139->902|1185->912|1197->915|1236->932|1281->941|1315->967|1403->1031|1460->1052|1494->1064|1533->1067|1559->1071|1597->225|1608->229|2135->96|2164->223|2192->726|2222->836|2250->1087|2288->1090|2302->1096|2342->1098|2422->1142|2505->1202|2552->1214|2593->1246|2633->1248|2750->1329|2764->1334|2801->1349|2853->1370|2947->1428|2984->1443|3101->1524|3136->1537|3383->1748|3398->1754|3437->1771|3537->1836|3583->1873|3623->1875|3747->1982|3760->1987|3799->1988|3952->2105|4003->2134|4061->2156|4116->2189|4254->2291|4304->2325|4344->2327|4432->2379|4447->2385|4472->2388|4552->2432|4567->2438|4613->2462|4652->2465|4667->2471|4694->2476|4803->2553|4963->2677|4995->2700|5035->2702|5144->2775|5206->2815|5290->2881|5303->2886|5342->2887|5512->3025|5621->3098|5641->3109|5696->3142|5776->3186|5808->3209|5848->3211|5958->3284|6021->3324|6102->3386|6116->3391|6156->3392|6323->3526|6403->3574|6437->3576
                    LINES: 27->1|29->32|29->32|31->32|32->33|32->33|32->33|32->33|32->33|32->33|32->33|32->33|33->34|33->34|33->34|33->34|35->6|35->6|57->1|59->5|60->27|62->31|63->36|65->38|65->38|65->38|66->39|66->39|68->41|68->41|68->41|70->43|70->43|70->43|72->45|76->49|76->49|77->50|77->50|81->54|81->54|81->54|85->58|85->58|85->58|91->64|91->64|91->64|96->69|96->69|97->70|97->70|102->75|102->75|102->75|104->77|104->77|104->77|105->78|105->78|105->78|105->78|105->78|105->78|107->80|114->87|114->87|114->87|116->89|116->89|118->91|118->91|118->91|122->95|124->97|124->97|124->97|126->99|126->99|126->99|128->101|128->101|130->103|130->103|130->103|134->107|138->111|139->112
                    -- GENERATED --
                */
            