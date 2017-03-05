<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>

/* <1구역> 개설강의 목록에서 추가 */
function add_Intrst_reqst(){
// 	var userId = $("#userId").val();
	
// 	// name이 같은 체크박스의 값들을 배열에 담는다.
//     var resultVal_1 = [];
//     $("input[name='result_1']:checked").each(function(i) {
//     	resultVal_1.push($(this).val());
//     });
//     var resultVal_2 = [];
//     $("input[name='result_2']:checked").each(function(i) {
//     	resultVal_2.push($(this).val());
//     });
	
    /* var opLctre = { 
    		"ckArray_1": resultVal_1, 
    		"ckArray_2": resultVal_2, 
    		"lc_Lctre_No" : lc_Lctre_No,
    		"sit_Subjct" : sit_Subjct,
    		"lu_Lctre_Code" : lu_Lctre_Code,
    		"lc_Split" : lc_Split,
    		"lu_Lctre_Nm" : lu_Lctre_Nm,
    		"lu_Grade" : lu_Grade,
    		"lu_Compl_Se" : lu_Compl_Se,
    		"knd_Lctre_Knd" : knd_Lctre_Knd,
    		"pr_Nm" : pr_Nm,
    		"lu_Pnt" : lu_Pnt,
    		"lc_Lctre_Time" : lc_Lctre_Time,
    		"lc_Lctre_Nmpr" : lc_Lctre_Nmpr,
    		"lr_Accept_Nmpr" : lr_Accept_Nmpr
    		}; */
	
    
    $.ajax({
        url:'<%=request.getContextPath()%>/course/courseList',
        type:'post',
        data: {
        	resultVal_1: $('#result_1').val(), 
    		resultVal_2: $('result_2').val(), 
    		lc_Lctre_No: $('#lc_Lctre_No').val(),
    		sit_Subjct: $('#sit_Subjct').val(),
    		lu_Lctre_Code: $('#lu_Lctre_Code').val(),
    		lc_Split: $('#lc_Split').val(),
    		lu_Lctre_Nm: $('#lu_Lctre_Nm').val(),
    		lu_Grade: $('#lu_Grade').val(),
    		lu_Compl_Se: $('#lu_Compl_Se').val(),
    		knd_Lctre_Knd: $('#knd_Lctre_Knd').val(),
    		pr_Nm: $('#pr_Nm').val(),
    		lu_Pnt: $('#lu_Pnt').val(),
    		lc_Lctre_Time: $('#lc_Lctre_Time').val(),
    		lc_Lctre_Nmpr: $('#lc_Lctre_Nmpr').val(),
    		lr_Accept_Nmpr: $('#lr_Accept_Nmpr').val()
        },
        success:function(res){
            $('#openList_tr').remove();	/* 모든 <tr>요로 삭제 후 새로 리스트 불러오는걸로... */
            /* 개설강의목록 */
            
            $('#openList table > tbody:first').append(data);
            $.each(res, function(index){
            	
            	var row="";
            	row+= '<tr class="slt_ckbox_${status.index}">'
            		+'<td class="select_ckbox_1 select_ckbox_5" id="lc_${status.index}"><label><input type="checkbox" class="input_check_1 input_check_5 " name="result_1" value="'+res.lc_Lctre_No+'" />관심</label></td>'
					+'<td class="select_ckbox_2 select_ckbox_5" id="re_${status.index}"><label><input type="checkbox" class="input_check_2 input_check_5 " id="ck_all_${status.index}" name="result_2" value="'+res.lc_Lctre_No+'" />수강</label></td>'
            		+'<td>'+res.lc_Lctre_No+'</td>'	
            		+'<td>'+res.sit_Subjct+'</td>'
		            +'<td>'+res.lu_Lctre_Code+'-'+res.lc_Split+'</td>'
            		+'<td>'
            		+'<a href="'+<%=request.getContextPath() %>+'/course/lectrePlan?lc_Lctre_No='+res.lc_Lctre_No+'&tpage=${tpage}">'
            		+res.lu_Lctre_Nm+'</a></td>' 	
            		+'<td>'+res.lu_Grade+'</td>'
		            +'<td>'+res.lu_Compl_Se+'/'+res.knd_Lctre_Knd+'</td>'
            		+'<td>'+res.pr_Nm+'</td>'
            		+'<td>'+res.lu_Pnt+'</td>'
            		+'<td>'+res.lc_Lctre_Time+'</td>'
            		+'<td>'+res.lc_Lctre_Nmpr+'</td>'
            		+'<td>'+res.lr_Accept_Nmpr+'</td></tr>';
            });
        },
        
        error:function(jqXHR, textStatus, errorThrown){
            alert("실패 \n" + textStatus + " : " + errorThrown);
            self.close();
        }
    });

    

	
	alert("수강신청");
}



/* <2-1구역> 관심목록에서 수강신청 */
function add_reqst(){
	
	
	//courseInterest
	
	
	
	
	
	
	alert(document.intrstLctreForm.value);
	document.getElementById("click_rst").innerHTML = "수강신청 좀 제발<br>";
	document.intrstLctreForm.submit();
}

/* <2-1구역> 관심목록에서 관심 삭제 */
function del_intrst(){
	
	
	
/*     var a="이것도 테스트!<br>";
    var b="선택 항목 없음!<br>"
    
	//alert("테스트");
	if(document.getElementById("ck_null").ckeched){
		var c=document.getElementById("click_rst").innerHTML = "선택 항목 없음<br>";
	}else{
	
	document.formm.submit();
		var c=document.getElementById("click_rst").innerHTML = "if값 왜 못가져오나<br>";
	}
    document.getElementById("click_rst").innerHTML = a+b+c; */
    alert(document.formm.value);
    document.getElementById("click_rst").innerHTML = "관심삭제 좀 제발<br>";
    document.intrstLctreForm.submit();
    
   
}


/* <3구역> 수강완료 목록 */
function del_intrst_reqst(){
	//courseComplete
	
	
	alert("수강취소");
	document.completeForm.submit();
}



</script>


</head>
<body>

</body>
</html>