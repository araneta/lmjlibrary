var catlist = new Array();
var maxborrowedbook = 0;
$(document).ready(function() {
	clearTbl();
	catlist = new Array();
	
	$.fn.enterKey = function (fnc) {
		return this.each(function () {
			$(this).keypress(function (ev) {
				var keycode = (ev.keyCode ? ev.keyCode : ev.which);
				if (keycode == '13') {
					fnc.call(this, ev);
				}
			})
		})
	}
	jsRoutes.controllers.TransBorrowing.getMaxBorrowedBook().ajax({
		success : function(data) {
			maxborrowedbook = parseInt(data,10);
		},error:function(data){
			alert(data.responseText);	
		},complete:function(jqXHR,status){			
		}
	});
	$('#nim').enterKey(function () {
		var nim = $('#nim').val();
		if(nim==''){
			alert('please enter nim');
			return;
		}
		$('#nimstatus').html('searching...');
		jsRoutes.controllers.TransBorrowing.getStudentInfo(nim).ajax({
			success : function(data) {
				catlist = new Array();				
				$('#nim').val(nim);
				$('#name').val(data.name);
				$('#faculty').val(data.faculty.name);
				$('#student_id').val(data.id);
				
				loadCatalog(data.id);
			},error:function(data){
				alert(data.responseText);	
			},complete:function(jqXHR,status){
				$('#nimstatus').html('');
			}
		});
		
	});
	$('#barcode').enterKey(function () {
		var barcode = $('#barcode').val();
		var studentid = $('#student_id').val();		
		if(studentid==''){
			alert('please enter nim');
			return;
		}
		if(barcode==''){
			alert('please enter barcode');
			return;
		}
		$('#barcodestatus').html('searching...');
		jsRoutes.controllers.TransBorrowing.getCatalogeInfo(barcode,studentid).ajax({
			success : function(data) {
				if(exists(data.catalogId)){
					alert('This item already in the list');
					return;
				}								
				if(data.status=='newbook'){	
					if(hasReachedLimit())
					{
						alert('This student already borrowed: '+maxborrowedbook+' books');
						return;
					}					
					addRow(data,'new',true);
					addCat(data.catalogId,'new');					
				}else if(data.status=='booked'){
					if(data.fine>0)
					{
						alert('Late return charges: '+data.fine);
					}
					if(data.action=='renew'){							
						if (confirm('Do you want to extend the borrowing period?')) {
							jsRoutes.controllers.TransBorrowing.getResumeInfo(data.catalogId).ajax({									
								success : function(newdata) {											
									data.mustReturnDate = newdata.mustReturnDate;
									data.renewalDate = newdata.renewalDate;
									data.renewalCount = newdata.renewalCount;
									
									changeRow(data,'resume',true);
									addCat(data.catalogId,'resume');										
								},error:function(data){										
									alert(data.responseText);	
								},complete:function(jqXHR,status){
									
								}
							});								
						} else {								
							changeRow(data,'return',true);
							addCat(data.catalogId,'return');							
						}
					}else if(data.action=='return')
					{
						changeRow(data,'return',true);
						addCat(data.catalogId,'return');						
					}
				}					
			},error:function(data){
				alert(data.responseText);				
			},complete:function(jqXHR,status){
				$('#barcodestatus').html('');
				$('#barcode').val('');
			}
		});
	});	
	function exists(id){
		for(var i = 0; i< catlist.length; i++){
			if (catlist[i].catalogId == id) {				
				return true;
			}
		}
		return false;
	}
	function addRow(data,status,withaction){
		var row = '<td>'+data.title+'</td>';
		row += '<td>'+data.borrowDate+'</td>';
		row += '<td>'+data.renewalDate+'</td>';
		row += '<td>'+data.renewalCount+'</td>';
		row += '<td>'+data.mustReturnDate+'</td>';		
		row += '<td>'+data.fine+'</td>';		
		row += '<td>'+status+'</td>';
		if(!withaction)
			row += '<td></td>';	
		else
			row += '<td><a class="action" onclick="remove('+data.catalogId+');return false;">Delete</a></td>';
		$('#booklist > tbody:last').append('<tr id="r'+data.catalogId+'" class="'+data.status+'">'+row+'</tr>');
	}
	function changeRow(data,status,withaction){
		var row = '<td>'+data.title+'</td>';
		row += '<td>'+data.borrowDate+'</td>';
		row += '<td>'+data.renewalDate+'</td>';
		row += '<td>'+data.renewalCount+'</td>';
		row += '<td>'+data.mustReturnDate+'</td>';	
		row += '<td>'+data.fine+'</td>';			
		row += '<td>'+status+'</td>';
		if(!withaction)
			row += '<td></td>';	
		else
			row += '<td><a class="action" onclick="remove('+data.catalogId+');return false;">Delete</a></td>';
		if($('#booklist > tbody #r'+data.catalogId).length>0){			
			$('#booklist > tbody #r'+data.catalogId+' td').remove();		
			$('#booklist > tbody #r'+data.catalogId).append(row);
		}else{			
			$('#booklist > tbody:last').append('<tr id="r'+data.catalogId+'" class="'+data.status+'">'+row+'</tr>');
		}
	}
	function addCat(id,status){		
		var item = new Object();
		item.catalogId = id;
		item.status = status;
		catlist.push(item);
	}
	function clearTbl(){
		$('#booklist > tbody tr').remove();		
	}
	function loadCatalog(studentid){
		jsRoutes.controllers.TransBorrowing.getBorrowedCatalogue(studentid).ajax({
			success : function(listdata) {				
				clearTbl();
				catlist = new Array();
				for(var i=0;i<listdata.length;i++){
					var data = listdata[i];
					
					addRow(data,data.status,false);
					
				}						
			},error:function(data){
				alert(data.responseText);	
			},complete:function(jqXHR,status){
				
			}
		});
	}
	$('#btnCancel').click(function(){
		clearTbl();
		catlist = new Array();
		$('#nim').val('');
		$('#name').val('');
		$('#faculty').val('');
		$('#student_id').val('');
		$('#bookliststatus').html('');
	});
	$('#btnSave').click(function(){
		var studentid = $('#student_id').val();
		
		if(studentid=='')
		{
			alert('please enter nim');
			return;
		}
		if(catlist.length==0)
		{
			alert('please enter a book');
			return;
		}
		setBookListStatus('saving data...');
		jsRoutes.controllers.TransBorrowing.save(studentid).ajax({
			data : {books:JSON.stringify(catlist)},			
			success : function(data) {				
				setBookListStatus('Done! Data has been updated ');
				loadCatalog(studentid)
			},error:function(data){
				alert(data.responseText);	
				$('#bookliststatus').html(html);
			},complete:function(jqXHR,status){				
			}
		});
	});
	function setBookListStatus(status){
		var html ='<div class="alert-message warning">'+status+'</div>';
		$('#bookliststatus').html(html);
	}
});

function remove(catid){	
	$('#r'+catid).remove();
	var index = -1;
	for(var i = 0; i< catlist.length; i++){		
		if (catlist[i].catalogId == catid) {
			index = i;
			break;
		}
	}	
	if(index!=-1)
		catlist.splice(index, 1);
}
function hasReachedLimit(){
	var count = 0;
	for(var i = 0; i< catlist.length; i++){		
		if (catlist[i].status == 'new') {
			count++;			
		}
	}	
	if(count>=maxborrowedbook)
		return true;
	return false;
}
