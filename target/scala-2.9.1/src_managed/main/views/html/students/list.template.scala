
package views.html.students

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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[Student],String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[Student], currentSortBy: String, currentOrder: String, currentFilter: String):play.api.templates.Html = {
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
    routes.Students.list(newPage, sortBy, order, currentFilter)
    
}};
Seq[Any](format.raw/*1.98*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(Seq[Any](/*38.2*/main()/*38.8*/ {_display_(Seq[Any](format.raw/*38.10*/("""    
    <h1 class="heading" id="homename">"""),_display_(Seq[Any](/*39.40*/Messages("students.list.title", currentPage.getTotalRowCount))),format.raw/*39.101*/("""</h1>

    """),_display_(Seq[Any](/*41.6*/if(flash.containsKey("success"))/*41.38*/ {_display_(Seq[Any](format.raw/*41.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*43.37*/flash/*43.42*/.get("success"))),format.raw/*43.57*/("""
        </div>
    """)))})),format.raw/*45.6*/(""" 

    <div id="actions">
        
        <form action=""""),_display_(Seq[Any](/*49.24*/link(0, "name"))),format.raw/*49.39*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*50.66*/currentFilter)),format.raw/*50.79*/("""" placeholder="Filter by student name..." />
            <input type="submit" id="searchsubmit" value="Search" class="btn primary" />
        </form>
        <br />
        <a class="btn success" id="add" href=""""),_display_(Seq[Any](/*54.48*/routes/*54.54*/.Students.create())),format.raw/*54.72*/("""">Add a new student</a>
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
                	"""),_display_(Seq[Any](/*69.19*/header("nim", "NIM",100))),format.raw/*69.43*/("""                	
                    """),_display_(Seq[Any](/*70.22*/header("name", "Name",250))),format.raw/*70.48*/("""
                    """),_display_(Seq[Any](/*71.22*/header("faculty", "Faculty",230))),format.raw/*71.54*/("""                      
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*76.18*/for(student <- currentPage.getList) yield /*76.53*/ {_display_(Seq[Any](format.raw/*76.55*/("""
                    <tr>                    	
                        <td><a href=""""),_display_(Seq[Any](/*78.39*/routes/*78.45*/.Students.edit(student.id))),format.raw/*78.71*/("""">"""),_display_(Seq[Any](/*78.74*/student/*78.81*/.nim)),format.raw/*78.85*/("""</a></td>
                        <td>"""),_display_(Seq[Any](/*79.30*/student/*79.37*/.name)),format.raw/*79.42*/("""</td>
                        <td>"""),_display_(Seq[Any](/*80.30*/student/*80.37*/.faculty.name)),format.raw/*80.50*/("""</td>                          
                    </tr>
                """)))})),format.raw/*82.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq[Any](/*89.18*/if(currentPage.hasPrev)/*89.41*/ {_display_(Seq[Any](format.raw/*89.43*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq[Any](/*91.35*/link(currentPage.getPageIndex - 1, null))),format.raw/*91.75*/("""">&larr; Previous</a>
                    </li>
                """)))}/*93.19*/else/*93.24*/{_display_(Seq[Any](format.raw/*93.25*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*97.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq[Any](/*99.36*/currentPage/*99.47*/.getDisplayXtoYofZ(" to "," of "))),format.raw/*99.80*/("""</a>
                </li>
                """),_display_(Seq[Any](/*101.18*/if(currentPage.hasNext)/*101.41*/ {_display_(Seq[Any](format.raw/*101.43*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq[Any](/*103.35*/link(currentPage.getPageIndex + 1, null))),format.raw/*103.75*/("""">Next &rarr;</a>
                    </li>
                """)))}/*105.19*/else/*105.24*/{_display_(Seq[Any](format.raw/*105.25*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*109.18*/("""
            </ul>
        </div>
        
    """)))})),format.raw/*113.6*/("""
""")))})),format.raw/*114.2*/("""        


            
"""))}
    }
    
    def render(currentPage:Page[Student],currentSortBy:String,currentOrder:String,currentFilter:String) = apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def f:((Page[Student],String,String,String) => play.api.templates.Html) = (currentPage,currentSortBy,currentOrder,currentFilter) => apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:09 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/students/list.scala.html
                    HASH: 8740217eed7437652450d6d041a956dcce66ad4b
                    MATRIX: 791->1|948->840|962->846|1066->886|1119->903|1142->904|1188->914|1200->917|1239->934|1284->943|1318->969|1406->1033|1463->1054|1497->1066|1536->1069|1562->1073|1600->226|1611->230|2139->97|2168->224|2196->728|2226->838|2254->1089|2292->1092|2306->1098|2346->1100|2426->1144|2510->1205|2557->1217|2598->1249|2638->1251|2755->1332|2769->1337|2806->1352|2858->1373|2952->1431|2989->1446|3106->1527|3141->1540|3389->1752|3404->1758|3444->1776|3545->1842|3591->1879|3631->1881|3755->1988|3768->1993|3807->1994|3960->2111|4006->2135|4081->2174|4129->2200|4187->2222|4241->2254|4381->2358|4432->2393|4472->2395|4593->2480|4608->2486|4656->2512|4695->2515|4711->2522|4737->2526|4812->2565|4828->2572|4855->2577|4926->2612|4942->2619|4977->2632|5084->2707|5244->2831|5276->2854|5316->2856|5425->2929|5487->2969|5571->3035|5584->3040|5623->3041|5793->3179|5902->3252|5922->3263|5977->3296|6058->3340|6091->3363|6132->3365|6242->3438|6305->3478|6386->3540|6400->3545|6440->3546|6607->3680|6687->3728|6721->3730
                    LINES: 27->1|29->32|29->32|31->32|32->33|32->33|32->33|32->33|32->33|32->33|32->33|32->33|33->34|33->34|33->34|33->34|35->6|35->6|57->1|59->5|60->27|62->31|63->36|65->38|65->38|65->38|66->39|66->39|68->41|68->41|68->41|70->43|70->43|70->43|72->45|76->49|76->49|77->50|77->50|81->54|81->54|81->54|85->58|85->58|85->58|91->64|91->64|91->64|96->69|96->69|97->70|97->70|98->71|98->71|103->76|103->76|103->76|105->78|105->78|105->78|105->78|105->78|105->78|106->79|106->79|106->79|107->80|107->80|107->80|109->82|116->89|116->89|116->89|118->91|118->91|120->93|120->93|120->93|124->97|126->99|126->99|126->99|128->101|128->101|128->101|130->103|130->103|132->105|132->105|132->105|136->109|140->113|141->114
                    -- GENERATED --
                */
            