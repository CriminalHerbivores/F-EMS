$(function(){
	$("#r").click(typeSelected);
	$("#b").click(typeSelected);
	$("#m").click(typeSelected);
	function typeSelected(){
		var a = $(this).val();
		var sel = '';
		if(a=='군입대휴학'){
			sel='<input type="hidden" name="skn_Content" value="군입대휴학">군입대휴학';
			$("#selAll").attr("disabled",false);
		}else if(a=='복학'){
			sel='<input type="hidden" name="skn_Content" value="복학">복학';
			$("#selAll").attr("disabled",false);
		}else if(a=='일반휴학'){
			sel='<select id="skn_Content" name="skn_Content" size="1">';
			sel+='<option value="선택">선택</option>';
			sel+='<option value="경제사정">경제사정</option>';
			sel+='<option value="업무부담">업무부담</option>';
			sel+='<option value="애경사">애경사</option>';
			sel+='<option value="자녀양육">자녀양육</option>';
			sel+='<option value="건강문제">건강문제</option>';
			sel+='<option value="간병">간병</option>';
			sel+='<option value="수험">수험</option>';
			sel+='<option value="해외거주">해외거주</option>';
			sel+='<option value="기타">기타</option>"';
			sel+='</select>';
		}
		$("#sknContent").html(sel);
	}
	$('#skn_Content').change(function(){
		if($(this).val()=='선택'){
			$("#selAll").attr("disabled",false);
		}
	});
})
function writeSknrgs(){
	document.formm.submit();
}