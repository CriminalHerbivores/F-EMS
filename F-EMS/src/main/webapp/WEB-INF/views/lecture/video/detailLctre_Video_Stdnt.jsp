<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.24    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/lctre_video.js"></script>
<script type="text/javascript">
$(function(){
var date1 = new Date();

var deadline = new Date(Date.parse(new Date()) - '${lctre_Video_Gnt.lw_Watch_Time}'*1000 );
	initializeClock('clockdiv', deadline);

$(document).on('click','#test',function(e){
    e.preventDefault();
  	var minutesSpan = document.getElementById('minutes').value;
  	var secondsSpan = document.getElementById('seconds').value;
  	var date2 = new Date();
  	var date = (date2 - date1 + '${lctre_Video_Gnt.lw_Watch_Time}'*1000) / 1000;
	alert(date);
});
$(document).on('click','#end',function(e){
    e.preventDefault();
    var date2 = new Date();
  	var date = (date2 - date1 + '${lctre_Video_Gnt.lw_Watch_Time}'*1000) / 1000;
    var data ={
    		'table_Nm' : '${lctre_Video_Gnt.table_Nm}',
    		'lv_Bbs_No' : '${lctre_Video_Gnt.lv_Bbs_No}',
    		'lw_Bbs_No' : '${lctre_Video_Gnt.lw_Bbs_No}',
    		'lw_Stdnt_No' : '${lctre_Video_Gnt.lw_Stdnt_No}',
    		'lw_Video_Bbs_No' : '${lctre_Video_Gnt.lv_Bbs_No}',
    		'lw_Watch_Time' : date,
    		'lw_Attendance' : '${lctre_Video_Gnt.lw_Attendance}'
    		};
    
    $.ajax({
       url:'<%=request.getContextPath()%>/lctre/insertLctre_Video_stdnt',
       contentType:'application/json; charset=utf-8',
       dataType:'text',
       data:JSON.stringify(data),
       type:'post',
       success : function(data){
    	   var go = $('input[name="table_Nm"]').val();
           location.href="video_StdntList?table_Nm="+go;
     },
       error:function(error){
    	   swal({
    		   title: "동영상 시청이 제대로 이루어지지 않았습니다.",
    		});
       }
    });
});
})

</script>
</head>
<body>
<h2>강의 동영상 게시판</h2><br/>
<form name="formm" method="post" action="detailBbs_Gnt">
<input type="hidden" name="table_Nm" value="${lctre_Video_Gnt.table_Nm}">
<table class="def-table-full tb-border table-hover">
			<tr>
				<th>제목</th>
				<td colspan="3" style="text-align: left;">${lctre_Video_Gnt.lv_Sj}</td>
			</tr>
			<tr>
				<th>기간</th>
				<td style="text-align: left;">
					<fmt:formatDate value="${lctre_Video_Gnt.lv_Start_Dt}"/>
		      		~
		      		<fmt:formatDate value="${lctre_Video_Gnt.lv_End_Dt}"/> </td>
				<th>시간</th>
				<td id="clockdiv" style="text-align: left;">
    				<span id="minutes" class="minutes"></span>:<span id="seconds" class="seconds"></span>
   					/
					<fmt:parseNumber var="i" integerOnly="true" 
                       type="number" value="${lctre_Video_Gnt.lv_Time/60}" />
					<c:out value="${i}" />:${lctre_Video_Gnt.lv_Time%60}</td>
			</tr>
			<tr>
				<th>동영상</th>
				<td colspan="3" style="text-align: left;">
					<video id="myVideo" src="<%=request.getContextPath() %>/resources/files/${lctre_Flpth.lf_Flpth}" controls width="600pt" height="500pt" ></video>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: left;">
					${lctre_Video_Gnt.lv_Cn}
				</td>
			</tr>
			<tr>
				<td colspan="4">
				 <span class="days"></span>
				 <span class="hours"></span>
				 <span class="minutes"></span>
				 <span class="seconds"></span>
				</td>
			</tr>
		</table>
		<br>
		<!-- 댓글부분 -->
	</form>

	<!--버튼들  -->
	  <table class="def-table-full"><tr><td style="text-align: right;">
		<!-- <input id="test" type="button" value="test" class="def-btn btn-md btn-color"> -->
		<input id="end" type="button" value="종료" class="def-btn btn-md btn-color">
	  </td></tr></table>
<br/><br/><br/>




</body>
</html>
