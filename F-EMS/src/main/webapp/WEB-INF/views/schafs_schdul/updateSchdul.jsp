<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.13    송선호            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
    <title>Customizing templates</title>
    <meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
  
  $(function() {
    $("#sd_Bgndt, #sd_Enddt").datepicker();
  });

  
  
</script>
    

<script>
/* $(document).on('click','#monthbutton1',function(){
	var month1 = $("#content1").html();
	$('#contentplus1').append(month1);
});
 */
 
<%--  function insertSchdul(){
	 var sd_Bgndt = $('#sd_Bgndt').val();
	 var sd_Enddt = $('#sd_Enddt').val();
	 var sd_Schdul_Sumry = $('#sd_Schdul_Sumry').val();
	 var dataWrite ={ 'sd_Bgndt':sd_Bgndt, 'sd_Enddt':sd_Enddt,
			 'sd_Schdul_Sumry':sd_Schdul_Sumry
	 };
	 $.ajax({
		 url : '<%=request.getContextPath()%>/schafs_schdul/insertSchdul',
		 contentType:'application/json; charset=utf-8',
		 data:JSON.stringify(dataWrite),
		 dataType:'text',
		 type:'post',
		 success: function(data){
					/* alert(data); */
					
		for(var i=1;i<=12;i++){
			i+='';
			if($('#selectmonth').val()==i+"월"){
				$('div #append'+i).append(data);
				alert(i+'월 일정이 추가되었습니다.')
			}
		}
		 },
		 error: function(data){
				alert(data);
				alert('에러');
			}
	 });
 } --%>

</script>


    
</head>
<body>
	<div class="modal fade" id="layerpop">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">삭제확인</h4>
				</div>
				<!-- body -->
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					<a href="deleteSchdul?no=${list1.sd_No}"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
    
</body>

</html>
