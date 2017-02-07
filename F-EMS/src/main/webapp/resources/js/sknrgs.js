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
			$("#toSknrgsRest").addClass("non-disp");
		}else if(a=='복학'){
			sel='<input type="hidden" name="skn_Content" value="복학">복학';
			$("#selAll").attr("disabled",false);
			$("#toSknrgsRest").addClass("non-disp");
		}else if(a=='일반휴학'){
			$("#toSknrgsRest").removeClass("non-disp");
		}
		$("#sknContent").html(sel);
	}
	function sknSelected(){
		$('option:selected').each(function(i){
			result = $(this).val();
			if(result=='선택'){
				$("#selAll").attr("disabled",true);
			}else{
				$("#selAll").attr("disabled",false);
			}
		})
	}
	$('#sknSelect').change(sknSelected);
})
function writeSknrgs(form){
	document.formm.submit();
}

function go_writesknrgs(){
	document.frm.submit();
}