
package views.html.reports

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
object overduebooks extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {
def /*1.2*/scripts/*1.9*/:play.api.templates.Html = {_display_(

Seq[Any](format.raw/*1.13*/("""
    <script src=""""),_display_(Seq[Any](/*2.19*/routes/*2.25*/.Assets.at("javascripts/jquery-ui.js"))),format.raw/*2.63*/("""" type="text/javascript" charset="utf-8"></script>
    <script src=""""),_display_(Seq[Any](/*3.19*/routes/*3.25*/.Assets.at("javascripts/jquery.dataTables.min.js"))),format.raw/*3.75*/("""" type="text/javascript" charset="utf-8"></script>
""")))};def /*5.2*/styles/*5.8*/:play.api.templates.Html = {_display_(

Seq[Any](format.raw/*5.12*/("""
	<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.47*/routes/*6.53*/.Assets.at("stylesheets/demo_table_jui.css"))),format.raw/*6.97*/("""">
 	<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.48*/routes/*7.54*/.Assets.at("stylesheets/jquery-ui.css"))),format.raw/*7.93*/("""">
""")))};
Seq[Any](format.raw/*4.2*/("""
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/main(styles,scripts)/*10.22*/ {_display_(Seq[Any](format.raw/*10.24*/("""     
    <h1 class="heading" id="homeTitle">List of Overdue Books</h1>
	<script type="text/javascript">
	  /* Table initialisation */
	  $(document).ready(function() """),format.raw("""{"""),format.raw/*14.34*/("""
	    $('#overduebooks').dataTable( """),format.raw("""{"""),format.raw/*15.37*/("""
	      "bProcessing": true,
	      "aaSorting": [[ 0, "asc" ]],
	      "bServerSide": true,
	      "bJQueryUI": true,
	      "sPaginationType": "full_numbers",
	      "sAjaxSource": """"),_display_(Seq[Any](/*21.25*/routes/*21.31*/.Reports.listOverdueBooks())),format.raw/*21.58*/("""",
	      "sDom": '<"toolbar">frtip',
	      "fnServerParams": function ( aoData ) """),format.raw("""{"""),format.raw/*23.47*/("""	    	  	
	            aoData.push(  """),format.raw("""{"""),format.raw/*24.29*/(""""name": "seldate", "value": $("#tgl").val() """),format.raw("""}"""),format.raw/*24.74*/(""" );
        	"""),format.raw("""}"""),format.raw/*25.11*/("""
	    """),format.raw("""}"""),format.raw/*26.7*/(""");
	    $("div.toolbar").html('<span>Due Date :</span><input type="text" name="tgl" id="tgl" value="" />');
	    $("#tgl").datepicker("""),format.raw("""{"""),format.raw/*28.28*/("""
	    	onClose: function( selectedDate ) """),format.raw("""{"""),format.raw/*29.42*/("""                
                var oTable = $('#overduebooks').dataTable();
                oTable.fnDraw();
            """),format.raw("""}"""),format.raw/*32.14*/("""
	    """),format.raw("""}"""),format.raw/*33.7*/(""");
	    $("#tgl").datepicker("option", "dateFormat", "dd-mm-yy");
	  """),format.raw("""}"""),format.raw/*35.5*/(""");
	</script>
	 
	<table id="overduebooks" class='display'>
	  <thead>
	    <tr>
	      <th>Due Date</th>
	      <th>Barcode</th>
	      <th>Title</th>
	      <th>Author</th>
	      <th>NIM</th>
	      <th>Name</th>
	    </tr>
	  </thead>
	  <tbody>
	    
	  </tbody>
	</table>
""")))})),format.raw/*53.2*/("""

            
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:09 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/reports/overduebooks.scala.html
                    HASH: 18c0efd03b44f22cd885adc620a461163caf62b1
                    MATRIX: 818->1|832->8|899->12|953->31|967->37|1026->75|1130->144|1144->150|1215->200|1289->254|1302->260|1369->264|1451->311|1465->317|1530->361|1615->411|1629->417|1689->456|1731->252|1758->460|1796->463|1825->483|1865->485|2080->653|2164->690|2385->875|2400->881|2449->908|2580->992|2665->1030|2757->1075|2818->1089|2871->1096|3053->1231|3142->1273|3313->1397|3366->1404|3482->1474|3792->1753
                    LINES: 29->1|29->1|31->1|32->2|32->2|32->2|33->3|33->3|33->3|34->5|34->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|40->4|41->8|43->10|43->10|43->10|47->14|48->15|54->21|54->21|54->21|56->23|57->24|57->24|58->25|59->26|61->28|62->29|65->32|66->33|68->35|86->53
                    -- GENERATED --
                */
            