var selectedAuthor = new Array();
$(function() {		
	$('#authors li').each(function(){
		selectedAuthor.push(parseInt($(this).attr('authorid'),10));
	});
	if(selectedAuthor.length!=0)
		$('#author_ids').val(JSON.stringify(selectedAuthor));
	$( "#author" ).autocomplete({
		source: "/ajax/authors",
		minLength: 2,
		select: function( event, ui ) {	
			var a = ui.item;			
			var index = selectedAuthor.indexOf(parseInt(a.id,10));
			if(index!=-1)
			{
				alert('This author already selected');
				return;
			}	
			addAuthor(ui.item);		
			$( "#author" ).val('');			
			return false;
		}
	});
	function addAuthor(a){
		var id = parseInt(a.id,10);
		selectedAuthor.push(id);
		$('#authors').append('<li id="a'+id+'"><span class="authortext">'+a.label+'</span><a href="#" onclick="removeAuthor('+id+');return false;">Remove</a></li>')
	}
});

function removeAuthor(id){	
	var index = -1;
	for(var i = 0; i< selectedAuthor.length; i++){		
		if (selectedAuthor[i] == id) {
			index = i;
			break;
		}
	}	
	
	if(index!=-1){
		selectedAuthor.splice(index, 1);
		$('#a'+id).remove();
	}
}
$("#main form").submit(function() {
	if($('#title').val()==''){
		//alert('Please enter title');
		//return false;
	}
	if($('#publisher_id').val()==''){
		//alert('Please select a publisher');
		//return false;
	}
	if(selectedAuthor.length==0)
	{
		//alert('Please select author');
		//return false;
	}	
	if($('#catalogue_count').val()==''){
		alert('Please enter catalogue count');
		return false;
	}
	$('#author_ids').val(JSON.stringify(selectedAuthor));            
});
