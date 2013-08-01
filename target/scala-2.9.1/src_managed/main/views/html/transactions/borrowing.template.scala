
package views.html.transactions

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
object borrowing extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.80*/(""" 
	
"""),_display_(Seq[Any](/*5.2*/main()/*5.8*/ {_display_(Seq[Any](format.raw/*5.10*/("""
<h1 class="heading">Books Transactions</h1>  
<form>
<fieldset> 
	<div id="bookliststatus"></div>
	<div id="studentinfo">
		<div class="left">	
		  	<div class="clearfix ">
			    <label for="nim">NIM</label>
			    <div class="input">	        
			    	<input type="text" value="" name="nim" id="nim" />
			    	<span id="nimstatus"></span>				        
			    </div>
			</div>
		    <div class="clearfix ">
			    <label for="name">Name</label>
			    <div class="input">	        
			    	<input type="text" readonly="readonly" value="" name="name" id="name" />		        
			    </div>
			</div>
			<div class="clearfix ">
			    <label for="faculty">Faculty</label>
			    <div class="input">	        
			    	<input type="text" readonly="readonly" value="" name="faculty" id="faculty" />		        
			    </div>
			</div>
		</div>
		<div class="right">
			<div id="photo"></div>
		</div>
	</div>
	<div id="books">		
		<div id="barcodeinput">
	    	<label for="barcode">Barcode</label>		    	       
    		<input type="text" value="" name="barcode" id="barcode" />		
    		<span id="barcodestatus"></span>	        
		 </div>   
	 	
		<div id="booktbl">			
			<table id="booklist">
			 	<thead>
			 		<tr>			 		
						<td width="300">Title</td>
						<td width="80">Borrow Date</td>
						<td width="80">Renewal <br />Date</td>
						<td width="50">Renewal <br />Count</td>
						<td width="80">Return Date</td>
						<td width="50">Fine</td>
						<td width="100">Status</td>
						<td width="50">Action</td>
			 		</tr>
			 	</thead>
				
				<tbody>
				
				</tbody>
			</table>
		</div>	
		<div class="actions">
            <input type="button" value="Save" id="btnSave" class="btn primary">  
            <a id="btnCancel" class="btn">Clear</a> 
        </div>
	</div>
	<input type="hidden" id="student_id" value="" />	
</fieldset>
</form>
<script type="text/javascript" src="/assets/javascripts/borrowing.js"></script>
""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 21:58:11 WIT 2012
                    SOURCE: /media/05beb903-1c3b-4a06-86d8-300b323446db/home/aldo/projects/play/lmjlibrary/app/views/transactions/borrowing.scala.html
                    HASH: 72d357873e32f80a045f34f56b11741422d68fad
                    MATRIX: 845->19|877->43|960->17|988->97|1027->102|1040->108|1079->110
                    LINES: 30->3|30->3|31->2|32->3|34->5|34->5|34->5
                    -- GENERATED --
                */
            