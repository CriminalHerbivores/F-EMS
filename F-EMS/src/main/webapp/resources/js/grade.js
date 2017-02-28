function manageLctre(r){
	var i = "#"+r+" input"; 
	var att = $(i+'[name="gd_Stdnt_No"]').val();
	$.ajax({
		url:'msgLctre',
		dataType:'text',
		data:$(i).serialize(),
		type:'get',
		success : function(result){
			swal("",att+"의 성적이 등록되었습니다.");
		},
		error:function(request,status,error){
		  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
	});
}

