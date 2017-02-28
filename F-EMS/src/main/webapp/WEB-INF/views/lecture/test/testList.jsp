<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.24    송선호            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html lang="en">
<head>
  <title>온라인 시험</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script>
$(document).ready(function(){
	
	$.ajax({
		url:'<%=request.getContextPath()%>/lctre/nameAnswerSTD',
		contentType: 'application/json; charset=utf-8',
		dataType: 'text',
		data:$('#tpNo').serialize(),
		type:'post',
		success : function(data){
			
		},
		error:function(request,status,error){
			  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			  }
	});
});
</script>
</head>
<body>


<div class="container">
<table class="non-border margin-auto">
<tr><td>
<div class="text-center">
  <h2>온라인 시험 게시판</h2>
 <hr />
 </div>
  <table class="def-table-auto tb-border table-hover">
      <tr>
      	<th>No</th>
        <th style="width:600px;">시험명</th>
        <th>출제자</th>
        <th>출제날짜</th>
    <sec:authorize access="hasRole('ROLE_STD')">       
        <th>응시여부</th>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_PRO')">
    	<th>응시자수</th>
    	<th>상세정보</th>
    </sec:authorize>
      </tr>
      
      <c:forEach var="testlist" items="${testlist }">
      	<tr>
      	<sec:authorize access="hasRole('ROLE_PRO')">
      		<td id="tpNo">${testlist.tp_No }</td>
      		<td>
      			<a href="detailTest?tpNo=${testlist.tp_No }&tpNm=${testlist.tp_Nm}">${testlist.tp_Nm}</a>
      		</td>
      		<td>${testlist.tp_Profsr_No} </td>
      		<td>${testlist.tp_Dt} </td>
      		<td>${testlist.countAnswerSTD} / </td>
      		<td>
      			<select name="answerSTD" id="answerSTD">
      				<option value="${testlist.nameAnswerSTD }"></option>
      			</select>
      		</td>
      	</sec:authorize>
      	<sec:authorize access="hasRole('ROLE_STD')">
      		<td>${testlist.tp_No }</td>
      	 	<td>${testlist.tp_Nm}</td>
      		<td>${testlist.tp_Profsr_No} </td>
      		<td>${testlist.tp_Dt} </td>
      	</sec:authorize>
	   		
      		<%-- <td><a href="detailNotice?no=${testlist.nb_Bbs_No}&tpage=${tpage}">
      		 ${notice.nb_Sj} </a>
      		</td> --%>
      <!--학생 응시 / 완료 가리기  -->
		      	<sec:authorize access="hasRole('ROLE_STD')">
			<td>
		      		<c:set var="testtpNo" value="${testlist.tp_No}" />
		      	    <c:set var="doneLoop" value="false"/>
		      			<c:forEach var="answerList" items="${answerList }">
		      			<c:if test="${not doneLoop}"> 
		      			    <c:set var="answertpNo" value="${answerList.an_Tp_No }" />
		      			<c:choose>
		      				<c:when test= "${testtpNo == answertpNo }">
		      					<c:set var="result" value="already" />
		      					<c:set var="doneLoop" value="true"/>
		      				</c:when>
		      				<c:otherwise>
		      					<c:set var="result" value="notyet" />
		      				</c:otherwise>
		      			</c:choose>
		      			</c:if>
		      			</c:forEach>	
		      			
		      			<c:choose>
		      				<c:when test="${result =='already'}">
		      				<input type="button" class="def-btn btn-sm btn-gray" value="완료">
		      				</c:when>
		      				<c:otherwise>
		      				<a href="detailTest?tpNo=${testlist.tp_No }&tpNm=${testlist.tp_Nm}">
		      				<input type="button" class="def-btn btn-sm btn-color" value="응시"> </a>
		      				</c:otherwise>
		      			</c:choose>
		  	</td>
		   <!--학생 응시 / 완료 가리기  -->
	
		      	</sec:authorize>
      	</tr>
      </c:forEach>
      
      
     
  </table>
  <sec:authorize access="hasRole('ROLE_PRO')">
	  <div id="buttons" style="float:right">
	  	<input type="button" class="def-btn btn-md btn-color" value="등록" onclick="writeTestForm();">
	  </div>
</sec:authorize>
</td></tr>  
</table>	  
</div>
 
</body>
</html>
