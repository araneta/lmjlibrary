
package views.html.publishers

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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[Publisher],String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[Publisher], currentSortBy: String, currentOrder: String, currentFilter: String):play.api.templates.Html = {
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
    routes.Publishers.list(newPage, sortBy, order, currentFilter)
    
}};
Seq[Any](format.raw/*1.100*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(Seq[Any](/*38.2*/main()/*38.8*/ {_display_(Seq[Any](format.raw/*38.10*/("""    
    <h1 class="heading" id="homename">"""),_display_(Seq[Any](/*39.40*/Messages("publishers.list.title", currentPage.getTotalRowCount))),format.raw/*39.103*/("""</h1>

    """),_display_(Seq[Any](/*41.6*/if(flash.containsKey("success"))/*41.38*/ {_display_(Seq[Any](format.raw/*41.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*43.37*/flash/*43.42*/.get("success"))),format.raw/*43.57*/("""
        </div>
    """)))})),format.raw/*45.6*/(""" 

    <div id="actions">
        
        <form action=""""),_display_(Seq[Any](/*49.24*/link(0, "name"))),format.raw/*49.39*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*50.66*/currentFilter)),format.raw/*50.79*/("""" placeholder="Filter by publisher name..." />
            <input type="submit" id="searchsubmit" value="Search" class="btn primary" />
        </form>
        <br />
        <a class="btn success" id="add" href=""""),_display_(Seq[Any](/*54.48*/routes/*54.54*/.Publishers.create())),format.raw/*54.74*/("""">Add a new publisher</a>
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
                	"""),_display_(Seq[Any](/*69.19*/header("id", "Publisher id",100))),format.raw/*69.51*/("""
                    """),_display_(Seq[Any](/*70.22*/header("name", "Publisher name",250))),format.raw/*70.58*/("""                    
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*75.18*/for(publisher <- currentPage.getList) yield /*75.55*/ {_display_(Seq[Any](format.raw/*75.57*/("""
                    <tr>
                    	<td>"""),_display_(Seq[Any](/*77.27*/publisher/*77.36*/.id)),format.raw/*77.39*/("""</td>
                        <td><a href=""""),_display_(Seq[Any](/*78.39*/routes/*78.45*/.Publishers.edit(publisher.id))),format.raw/*78.75*/("""">"""),_display_(Seq[Any](/*78.78*/publisher/*78.87*/.name)),format.raw/*78.92*/("""</a></td>                        
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
    
    def render(currentPage:Page[Publisher],currentSortBy:String,currentOrder:String,currentFilter:String) = apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def f:((Page[Publisher],String,String,String) => play.api.templates.Html) = (currentPage,currentSortBy,currentOrder,currentFilter) => apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:10 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/publishers/list.scala.html
                    HASH: 2a1596fa855926d170a447d2ba0e3001aa90c1de
                    MATRIX: 795->1|954->844|968->850|1072->890|1125->907|1148->908|1194->918|1206->921|1245->938|1290->947|1324->973|1412->1037|1469->1058|1503->1070|1542->1073|1568->1077|1606->228|1617->232|2148->99|2177->226|2205->732|2235->842|2263->1093|2301->1096|2315->1102|2355->1104|2435->1148|2521->1211|2568->1223|2609->1255|2649->1257|2766->1338|2780->1343|2817->1358|2869->1379|2963->1437|3000->1452|3117->1533|3152->1546|3402->1760|3417->1766|3459->1786|3562->1854|3608->1891|3648->1893|3772->2000|3785->2005|3824->2006|3977->2123|4031->2155|4089->2177|4147->2213|4285->2315|4338->2352|4378->2354|4466->2406|4484->2415|4509->2418|4589->2462|4604->2468|4656->2498|4695->2501|4713->2510|4740->2515|4849->2592|5009->2716|5041->2739|5081->2741|5190->2814|5252->2854|5336->2920|5349->2925|5388->2926|5558->3064|5667->3137|5687->3148|5742->3181|5822->3225|5854->3248|5894->3250|6004->3323|6067->3363|6148->3425|6162->3430|6202->3431|6369->3565|6449->3613|6483->3615
                    LINES: 27->1|29->32|29->32|31->32|32->33|32->33|32->33|32->33|32->33|32->33|32->33|32->33|33->34|33->34|33->34|33->34|35->6|35->6|57->1|59->5|60->27|62->31|63->36|65->38|65->38|65->38|66->39|66->39|68->41|68->41|68->41|70->43|70->43|70->43|72->45|76->49|76->49|77->50|77->50|81->54|81->54|81->54|85->58|85->58|85->58|91->64|91->64|91->64|96->69|96->69|97->70|97->70|102->75|102->75|102->75|104->77|104->77|104->77|105->78|105->78|105->78|105->78|105->78|105->78|107->80|114->87|114->87|114->87|116->89|116->89|118->91|118->91|118->91|122->95|124->97|124->97|124->97|126->99|126->99|126->99|128->101|128->101|130->103|130->103|130->103|134->107|138->111|139->112
                    -- GENERATED --
                */
            