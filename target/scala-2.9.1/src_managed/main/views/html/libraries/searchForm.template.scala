
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
object searchForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/home/*1.6*/ {_display_(Seq[Any](format.raw/*1.8*/("""        
    <div id="actions">        
        <form action=""""),_display_(Seq[Any](/*3.24*/routes/*3.30*/.Library.search(0, "", "", "", "asc"))),format.raw/*3.67*/("""" method="GET">
        	<span class="st1">Search</span>
            <input type="search" id="searchbox" name="f" value="" placeholder="keywords...">
            <span class="st2">in</span>
            <select name="fb" id="fb">            	
            	<option value="title">Title</option>
            	<option value="authors_text">Author</option>            	
            </select>
            <div style="clear:both"></div>
            <span class="st1">Sort by</span>
       		<select name="s" id="s">            	
            	<option value="title">Title</option>
            	<!-- <option value="year">Year</option> -->	            	            	
            </select>
            <span class="st2">in</span>
            <select name="o" id="o">
            	<option value="asc">Ascending</option>
            	<option value="desc">Descending</option>	            	            	
            </select>
            <input type="submit" id="searchsubmit" value="Search" class="btn primary">
        </form>        
    </div>           
""")))})),format.raw/*25.2*/("""

            
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:09 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/libraries/searchForm.scala.html
                    HASH: 58fd7b18d6f95177133011b5695e2200fb59061c
                    MATRIX: 843->1|854->5|892->7|990->70|1004->76|1062->113|2135->1155
                    LINES: 30->1|30->1|30->1|32->3|32->3|32->3|54->25
                    -- GENERATED --
                */
            