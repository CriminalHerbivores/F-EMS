<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:useBean id="now" class="java.util.Date" />

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  <fmt:formatDate value="${now}" pattern="yyyy" />.02.13    송선호            최초작성               -->
<!--  Copyright (c) <fmt:formatDate value="${now}" pattern="yyyy" /> by DDIT All right reserved -->

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
		window.onload = function () {
			kCalendar('kCalendar');
		};
</script>
    


    
</head>
<body>
    <div>
    	<div style="float:left" id="kCalendar"></div>
    </div>
    	<div style="height:280px;" id="monthdata"></div>
    	
    	<br>
    	



<sec:authorize access="hasRole('ROLE_STF')">
<form name="formm" method="post" action="insertSchdul">
<table class="def-table-auto tb-border table-hover">
  <tr>
	<th>시작날짜</th>
	<th>종료날짜</th>
	<th style="width:500px;">일정요약</th>
	<td rowspan="2"><input type="button" class="def-btn btn-md btn-color" value="추가" onclick="submitForm(this.form);"></td>
  </tr>
  <tr>
	<td>
	<input type="text" id="sd_Bgndt" name="sd_Bgndt" class="def-input-text-md custom-form-control">
	</td>
	<td>
	<input type="text" id="sd_Enddt" name="sd_Enddt" class="def-input-text-md custom-form-control">
	</td>
	<td>
	<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" class="def-input-text-full custom-form-control">
	</td>
  </tr>
</table>
</form>
</sec:authorize>
<!-- <p>일정추가:
월 &nbsp;
  시작일
  <input type="text" id="datepicker1" class="def-input-text-md custom-form-control">&nbsp; ~ &nbsp;
    종료일<input type="text" id="datepicker2" class="def-input-text-md custom-form-control">
  :
</p>
 -->

<div class="scheBox2">
	<table class="t_all">
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>01</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 1월</p>
				
				<c:forEach var="list1" items="${list1 }" varStatus="status">
				<div id="content1">${list1.sd_Bgndt } &nbsp; ~ &nbsp;${list1.sd_Enddt}
				: &nbsp; ${list1.sd_Schdul_Sumry }
				
				<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list1.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
			<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+100000}" data-toggle="modal" value="삭제">
			</sec:authorize>			
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list1.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list1.sd_No }>
					<input type="text" id="${status.index+10000}" name="sd_Bgndt" value=${list1.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+1000}" name="sd_Enddt" value=${list1.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list1.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+10000}, #${status.count+1000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+100000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list1.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
		
				
				
				<div id="append1"></div>
				
			</td>
		</tr>
		
		
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>02</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 2월</p>
				<c:forEach var="list2" items="${list2 }" varStatus="status">
				<div id="content2">${list2.sd_Bgndt } &nbsp; ~ &nbsp;${list2.sd_Enddt}
				: &nbsp; ${list2.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list2.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+200000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list2.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list2.sd_No }>
					<input type="text" id="${status.index+20000}" name="sd_Bgndt" value=${list2.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+2000}" name="sd_Enddt" value=${list2.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list2.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+20000}, #${status.count+2000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+200000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list2.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append2"></div>
			</td>
		</tr>
		
		
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>03</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 3월</p>
				<c:forEach var="list3" items="${list3 }" varStatus="status">
				<div id="content1">${list3.sd_Bgndt } &nbsp; ~ &nbsp;${list3.sd_Enddt}
				: &nbsp; ${list3.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list3.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+300000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="	Schdul">
	<div class="modal fade" id="${list3.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list3.sd_No }>
					<input type="text" id="${status.index+30000}" name="sd_Bgndt" value=${list3.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+148700}" name="sd_Enddt" value=${list3.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list3.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+30000}, #${status.count+148700}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+300000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list3.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append3"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>04</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 4월</p>
			<c:forEach var="list4" items="${list4 }" varStatus="status">
				<div id="content1">${list4.sd_Bgndt } &nbsp; ~ &nbsp;${list4.sd_Enddt}
				: &nbsp; ${list4.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list4.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+400000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list4.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list4.sd_No }>
					<input type="text" id="${status.index+40000}" name="sd_Bgndt" value=${list4.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+4000}" name="sd_Enddt" value=${list4.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list4.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+40000}, #${status.count+4000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+400000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list4.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append4"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>05</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 5월</p>
				<c:forEach var="list5" items="${list5 }" varStatus="status">
				<div id="content1">${list5.sd_Bgndt } &nbsp; ~ &nbsp;${list5.sd_Enddt}
				: &nbsp; ${list5.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list5.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+500000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list5.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list5.sd_No }>
					<input type="text" id="${status.index+50000}" name="sd_Bgndt" value=${list5.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+5000}" name="sd_Enddt" value=${list5.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list5.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+50000}, #${status.count+5000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+500000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list5.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append5"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>06</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 6월</p>
				<c:forEach var="list6" items="${list6 }" varStatus="status">
				<div id="content1">${list6.sd_Bgndt } &nbsp; ~ &nbsp;${list6.sd_Enddt}
				: &nbsp; ${list6.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list6.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+600000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list6.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list6.sd_No }>
					<input type="text" id="${status.index+60000}" name="sd_Bgndt" value=${list6.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+6000}" name="sd_Enddt" value=${list6.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list6.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+60000}, #${status.count+6000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+600000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list6.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append6"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>07</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 7월</p>
				<c:forEach var="list7" items="${list7 }" varStatus="status">
				<div id="content1">${list7.sd_Bgndt } &nbsp; ~ &nbsp;${list7.sd_Enddt}
				: &nbsp; ${list7.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list7.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+700000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list7.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list7.sd_No }>
					<input type="text" id="${status.index+70000}" name="sd_Bgndt" value=${list7.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+7000}" name="sd_Enddt" value=${list7.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list7.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+70000}, #${status.count+7000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+700000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list7.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append7"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>08</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 8월</p>
			<c:forEach var="list8" items="${list8 }" varStatus="status">
				<div id="content1">${list8.sd_Bgndt } &nbsp; ~ &nbsp;${list8.sd_Enddt}
				: &nbsp; ${list8.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list8.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+800000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list8.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list8.sd_No }>
					<input type="text" id="${status.index+80000}" name="sd_Bgndt" value=${list8.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+8000}" name="sd_Enddt" value=${list8.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list8.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+80000}, #${status.count+8000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+800000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list8.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append8"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>09</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 9월</p>
				<c:forEach var="list9" items="${list9 }" varStatus="status">
				<div id="content1">${list9.sd_Bgndt } &nbsp; ~ &nbsp;${list9.sd_Enddt}
				: &nbsp; ${list9.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">	
				<input type="button" data-target="#${list9.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+900000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list9.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list9.sd_No }>
					<input type="text" id="${status.index+90000}" name="sd_Bgndt" value=${list9.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+9000}" name="sd_Enddt" value=${list9.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list9.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+90000}, #${status.count+9000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+900000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list9.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append9"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>10</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 10월</p>
				<c:forEach var="list10" items="${list10 }" varStatus="status">
				<div id="content1">${list10.sd_Bgndt } &nbsp; ~ &nbsp;${list10.sd_Enddt}
				: &nbsp; ${list10.sd_Schdul_Sumry }
				
			<sec:authorize access="hasRole('ROLE_STF')">
				<input type="button" data-target="#${list10.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+1000000}" data-toggle="modal" value="삭제">
			</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list10.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list10.sd_No }>
					<input type="text" id="${status.index+105000}" name="sd_Bgndt" value=${list10.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+10500}" name="sd_Enddt" value=${list10.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list10.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+105000}, #${status.count+10500}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+1000000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list10.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append10"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>11</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 11월</p>
				<c:forEach var="list11" items="${list11 }" varStatus="status">
				<div id="content1">${list11.sd_Bgndt } &nbsp; ~ &nbsp;${list11.sd_Enddt}
				: &nbsp; ${list11.sd_Schdul_Sumry }
				
		<sec:authorize access="hasRole('ROLE_STF')">		
				<input type="button" data-target="#${list11.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+1100000}" data-toggle="modal" value="삭제">
		</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list11.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list11.sd_No }>
					<input type="text" id="${status.index+115000}" name="sd_Bgndt" value=${list11.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+15000}" name="sd_Enddt" value=${list11.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list11.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+115000}, #${status.count+15000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+1100000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list11.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append11"></div>
			</td>
		</tr>
		<tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>12</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 12월</p>
				<c:forEach var="list12" items="${list12 }" varStatus="status">
				<div id="content1">${list12.sd_Bgndt } &nbsp; ~ &nbsp;${list12.sd_Enddt}
				: &nbsp; ${list12.sd_Schdul_Sumry }
				
		<sec:authorize access="hasRole('ROLE_STF')">		
				<input type="button" data-target="#${list12.sd_No}" data-toggle="modal" value="수정" class="def-btn btn-md btn-color">
				<input type="button" class="def-btn btn-md btn-color" data-target="#${status.index+1200000}" data-toggle="modal" value="삭제">
		</sec:authorize>
			<!--모달부분  -->
			
	<form method="post" action="updateSchdul">
	<div class="modal fade" id="${list12.sd_No}">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">수정 페이지</h4>
				</div>
				
				<!-- body -->
				<div class="modal-body" style="text-align: center">
					<input type="hidden" id="sd_No" name="sd_No" value=${list12.sd_No }>
					<input type="text" id="${status.index+125000}" name="sd_Bgndt" value=${list12.sd_Bgndt } class="def-input-text-md custom-form-control">
					<input type="text" id="${status.count+25000}" name="sd_Enddt" value=${list12.sd_Enddt } class="def-input-text-md custom-form-control">
					<input type="text" id="sd_Schdul_Sumry" name="sd_Schdul_Sumry" value=${list12.sd_Schdul_Sumry } class="def-input-text-xlg custom-form-control">
				</div>
				<script>
				  $(function(){
						 $("#${status.index+125000}, #${status.count+25000}").datepicker();
					  });
				</script>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					
						<input type="submit" class="btn btn-default" value="수정" >
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="취소">
				</div>
			</div>
		</div>
	</div>
		</form>
<form method="post" action="deleteSchdul">
	<div class="modal fade" id="${status.index+1200000}">
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
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?
				
				<input type="hidden" id="sd_No" name="sd_No" value=${list12.sd_No }>
				
				</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					 <!--삭제 모달  -->
						<input type="submit" class="btn btn-default" value="예">
					 <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>
	</form>
			</div>
			</c:forEach>
				<div id="append12"></div>
			</td>
		</tr>
		
		
	



<!-- <tr>
			<th class="all_month">
				<fmt:formatDate value="${now}" pattern="yyyy" />년<br>
				<strong>01</strong>월
			</th>
			<td class="all_zoom">
				<p><fmt:formatDate value="${now}" pattern="yyyy" />년 1월
				 <button id="monthbutton1" class="def-btn btn-search btn-color" value="조회">+추가</button>
				</p>
			<div id="content1" class="content">
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp; ∼
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option>
				</select>월
				<select name="선택" class="combobox-sm custom-form-control">
					<option value="">01</option><option value="">02</option><option value="">03</option><option value="">04</option><option value="">05</option><option value="">06</option><option value="">07</option><option value="">08</option><option value="">09</option><option value="">10</option><option value="">11</option><option value="">12</option><option value="">13</option><option value="">14</option><option value="">15</option><option value="">16</option><option value="">17</option><option value="">18</option><option value="">19</option><option value="">20</option><option value="">21</option><option value="">22</option><option value="">23</option><option value="">24</option><option value="">25</option><option value="">26</option><option value="">27</option><option value="">28</option><option value="">29</option><option value="">30</option><option value="">31</option>
				</select>&nbsp;:
			 <input type="text" class="def-input-text-lg custom-form-control" value="">
			 <button id="submit1" class="def-btn btn-search btn-color" value="등록">등록</button> <br>
			</div>
			<div id="contentplus1" class="content"></div>
			</td>
		</tr> -->

		
	</table>	
</div>


    
</body>

</html>
