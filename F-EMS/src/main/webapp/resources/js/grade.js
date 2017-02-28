function manageLctre(r){
	var i = "#"+r+" input"; 
	$.ajax({
		url:'msgLctre',
		dataType:'text',
		data:$(i).serialize(),
		type:'get',
		success : function(result){
			
		},
		error:function(request,status,error){
		  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
	});
}

