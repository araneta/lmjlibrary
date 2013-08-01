
package views.html.settings

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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[viewmodels.SettingsForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(settingsForm: Form[viewmodels.SettingsForm]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*4.80*/(""" 

"""),_display_(Seq[Any](/*6.2*/main()/*6.8*/ {_display_(Seq[Any](format.raw/*6.10*/("""
<style>
	form .input """),format.raw("""{"""),format.raw/*8.15*/("""
    	margin-left: 220px;
	"""),format.raw("""}"""),format.raw/*10.3*/("""
	form label"""),format.raw("""{"""),format.raw/*11.13*/("""
		width:200px;
	"""),format.raw("""}"""),format.raw/*13.3*/("""
</style>    
    <h1 class="heading">Edit Settings</h1>
    """),_display_(Seq[Any](/*16.6*/if(flash.containsKey("success"))/*16.38*/ {_display_(Seq[Any](format.raw/*16.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*18.37*/flash/*18.42*/.get("success"))),format.raw/*18.57*/("""
        </div>
    """)))})),format.raw/*20.6*/(""" 
    """),_display_(Seq[Any](/*21.6*/form(routes.Settings.save())/*21.34*/ {_display_(Seq[Any](format.raw/*21.36*/("""
        
        <fieldset>
        	
			"""),_display_(Seq[Any](/*25.5*/inputText(settingsForm("maxBorrowingDay"), '_label -> "Maximum Borrowing Day"))),format.raw/*25.83*/("""
			"""),_display_(Seq[Any](/*26.5*/inputText(settingsForm("finePerDay"), '_label -> "Fine PerDay"))),format.raw/*26.68*/("""
			"""),_display_(Seq[Any](/*27.5*/inputText(settingsForm("maxRenewalCount"), '_label -> "Maximum Renewal Count"))),format.raw/*27.83*/("""
			"""),_display_(Seq[Any](/*28.5*/inputText(settingsForm("dateFormat"), '_label -> "Date Format"))),format.raw/*28.68*/("""
			"""),_display_(Seq[Any](/*29.5*/inputText(settingsForm("maxBorrowedBook"), '_label -> "Maximum Borrowed Book"))),format.raw/*29.83*/("""
			<a class="btn success" id="add" href=""""),_display_(Seq[Any](/*30.43*/routes/*30.49*/.Settings.generateCataloguesCode())),format.raw/*30.83*/("""">Generate barcodes</a>
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save" class="btn primary">              
        </div>
        
    """)))})),format.raw/*37.6*/("""    
""")))})))}
    }
    
    def render(settingsForm:Form[viewmodels.SettingsForm]) = apply(settingsForm)
    
    def f:((Form[viewmodels.SettingsForm]) => play.api.templates.Html) = (settingsForm) => apply(settingsForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/settings/editForm.scala.html
                    HASH: 5a5833fa9b41321a129afffe95bc491090765dd2
                    MATRIX: 790->1|920->66|952->90|1036->46|1063->64|1091->144|1129->148|1142->154|1181->156|1250->179|1324->207|1384->220|1448->238|1545->300|1586->332|1626->334|1743->415|1757->420|1794->435|1846->456|1888->463|1925->491|1965->493|2043->536|2143->614|2183->619|2268->682|2308->687|2408->765|2448->770|2533->833|2573->838|2673->916|2752->959|2767->965|2823->999|3047->1192
                    LINES: 27->1|30->4|30->4|31->1|32->3|33->4|35->6|35->6|35->6|37->8|39->10|40->11|42->13|45->16|45->16|45->16|47->18|47->18|47->18|49->20|50->21|50->21|50->21|54->25|54->25|55->26|55->26|56->27|56->27|57->28|57->28|58->29|58->29|59->30|59->30|59->30|66->37
                    -- GENERATED --
                */
            