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
   
            /* 개설강의목록 */
    $.ajax({
        url:'<%=request.getContextPath()%>/course/insertCourse',
        contentType:'application/json; charset=utf-8',
        type:'post',
        dataType: 'json',
        data: {
        	result_1: $('#result_1').val(), 
        	result_2: $('result_2').val(), 
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
        	sweetAlert(" ", "실패.", "error");
            self.close();
        }
    });
	//================================================================================================
    		            /* 관심등록 목록 */
	$.ajax({
    		        url:'<%=request.getContextPath()%>/course/courseInterest',
    		        contentType:'application/json; charset=utf-8',
    		        type:'post',
    		        dataType: 'json',
    		        data: {
    		        	in_Lctre_No: $('#in_Lctre_No').val(),
    		    		lu_Lctre_Code: $('#lu_Lctre_Code').val(),
    		    		lc_Split: $('#lc_Split').val(),
    		    		lu_Lctre_Nm: $('#lu_Lctre_Nm').val(),
    	   		        },
    		        success:function(res){
    		            $('#intrstList_tr').remove();	/* 모든 <tr>요로 삭제 후 새로 리스트 불러오는걸로... */
    		            
    		            $('#intrstList table > tbody:first').append(data);
    		            $.each(res, function(index){
    		            	
    		            	var row="";
    		            	row+= '<tr id="intrstList_tr">'
    		            		+'<td class="select_ckbox_1"><label><input type="checkbox" class="input_check_1" id="ck_null" name="result" value="'+res.in_Lctre_No+'" />'
    		            		+res.lu_Lctre_Code+'-'+res.lc_Split+'</td>'
    		            		+'<td>'
    		            		+'<a href="'+<%=request.getContextPath() %>+'/course/lectrePlan?lc_Lctre_No='+res.lc_Lctre_No+'&tpage=${tpage}">'
    		            		+res.lu_Lctre_Nm+'</a></td></tr>';
    		            });
    		        },
    		        
    		        error:function(jqXHR, textStatus, errorThrown){
    		        	sweetAlert(" ", "실패.", "error");
    		            self.close();
    		        }
    		    });		    		
    		
    		
    
    		
   //==================================================================================================
	   /* 수강신청 완료 목록 */
    		 $.ajax({
    		        url:'<%=request.getContextPath()%>/course/courseComplete',
    		        contentType:'application/json; charset=utf-8',
    		        type:'post',
    		        dataType: 'json',
    		        data: {
    		        	resultVal_3: $('#result_3').val(), 
    		    		resultVal_4: $('result_4').val(), 
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
    		        	sweetAlert(" ", "실패.", "error");
    		            self.close();
    		        }
    		    });		
    		
	//==================================================================================================
    		   /* 수강신청 학점 목록 */    		
 		   
    		   
    		   
    	//==================================================================================================	   
    		   
    		   
    		   
    		   
    		   
    		   
    		   

	
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