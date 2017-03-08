<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
body{
	text-align: center;
	background: #00ECB9;
  font-family: Malgun Gothic;	/* sans-serif; */
  font-weight: 100;
}

h1{
  color: #555;
  font-weight: 100;
  font-size: 40px;
  margin: 40px 0px 20px;
}

#clockdiv{
	font-family: Malgun Gothic;	/* sans-serif; */
	color: #555;
	display: inline-block;
	font-weight: 100;
	text-align: center;
	font-size: 30px;
}

#clockdiv > div{
	padding: 0;
	border-radius: 3px;
/* 	background: #00BF96; */
	display: inline-block;
}

#clockdiv div > span{
	border-radius: 3px;
 	background: white;
	display: inline-block;
}

.smalltext{
	padding-top: 5px;
	font-size: 16px;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
function getTimeRemaining(endtime) {
	  var t = Date.parse(endtime) - Date.parse(new Date());
	  var seconds = Math.floor((t / 1000) % 60);
	  var minutes = Math.floor((t / 1000 / 60) % 60);
	/*   var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
	  var days = Math.floor(t / (1000 * 60 * 60 * 24)); */
	  return {
	    'total': t,
	    /* 'days': days,
	    'hours': hours, */
	    'minutes': minutes,
	    'seconds': seconds
	  };
	}

	function initializeClock(id, endtime) {
	  var clock = document.getElementById(id);
	  /* var daysSpan = clock.querySelector('.days');
	  var hoursSpan = clock.querySelector('.hours'); */
	  var minutesSpan = clock.querySelector('.minutes');
	  var secondsSpan = clock.querySelector('.seconds');

	  function updateClock() {
	    var t = getTimeRemaining(endtime);

	    /* daysSpan.innerHTML = t.days;
	    hoursSpan.innerHTML = ('0' + t.hours).slice(-2); */
	    minutesSpan.innerHTML = ('0' + t.minutes).slice(-2);
	    secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);

	    if (t.total <= 0) {
	      clearInterval(timeinterval);
	      sweetAlert(" ", "시험이 종료되었습니다.", "success");
	      
	      setTimeout(function(){submitForm(this.form)},1700); 
	    }
	  }

	  updateClock();
	  var timeinterval = setInterval(updateClock, 1000);
	}

	var deadline = new Date(Date.parse(new Date()) + 1 * 10 * 1000);
	initializeClock('clockdiv', deadline);
		
	
});
</script>
<sec:authorize access="hasRole('ROLE_STD')">
<script>
history.pushState(null, null, location.href); 
window.onpopstate = function(event) { 
history.go(1); 
}
</script>
</sec:authorize>
	
</head>

<body>
<h2>시험</h2><br/>
  <form name="formm" method="post">
	<table class="def-table-full tb-border table-hover" id="testtable">
		<tr>
			<td colspan="3" style="padding-top: 0;padding-bottom: 0; width:500px; ">	
				<table class="def-table-auto tb-border table-hover"  style="width:100%;">
			<sec:authorize access="hasRole('ROLE_STD')">
					<tr>
						<th>남은 시간</th>
						<td colspan="2">
							<div id="clockdiv">
							  <!-- <div>
							    <span class="days"></span>
							    <div class="smalltext">Days</div>
							  </div>
							  <div>
							    <span class="hours"></span>
							    <div class="smalltext">Hours</div>
							  </div> -->
							  <div>
							    <span class="minutes"></span>
							  	<span class="minutes">:</span>
							    <span class="seconds"></span>
							  </div>
							</div>
						</td>
					</tr>
			</sec:authorize>
					<tr>
						<th>시험명</th>
							<td style="width:70%;"> ${tpNm} 
							<input type="hidden" name="an_Tp_No" value="${tpNo }">
							</td>
							<th>출제자</th>
					</tr>
					<tr>
						<th>응시가능기간</th>
						<td>${tpVO.tp_Start_Dt} &nbsp; ~ &nbsp; ${tpVO.tp_End_Dt}
						</td>
						<td>${tpVO.tp_Profsr_No} </td>
					</tr>
				</table>
			</td>
		</tr>
	
		<tr>
			<th>No</th>
			<th style="width:70%;">문제</th>
			<th>정답</th>
		</tr>
		
		<c:forEach var="Qlist" items="${Qlist }" varStatus="status" >
		<tr>
		<td>${status.count}</td>
			<td style="text-align: left;">
				${Qlist.te_Ques}
				<c:if test="${not empty Qlist.te_No1 }"><br>${Qlist.te_No1 }</c:if>
				<c:if test="${not empty Qlist.te_No2 }"><br>${Qlist.te_No2 }</c:if>
				<c:if test="${not empty Qlist.te_No3 }"><br>${Qlist.te_No3 }</c:if>
				<c:if test="${not empty Qlist.te_No4 }"><br>${Qlist.te_No4 }</c:if>
				<input type="hidden" name="queNo" value="${Qlist.te_Ques_No }">
			</td>
			<td>
			<sec:authorize access="hasRole('ROLE_PRO')">
				${Qlist.te_Ca }
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_STD')">
			<c:choose>
			<c:when test="${empty Qlist.te_No1 }">
				<input type="text" class="def-input-text-md custom-form-control" name="answer">
			</c:when>
			<c:otherwise>
				<select name="answer" class="combobox-sm custom-form-control">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
			</c:otherwise>
			</c:choose>
			</sec:authorize>
				<%-- ${Qlist.te_Ca} --%>			
			</td>
		</tr>
		</c:forEach>
			<tbody></tbody>
		
		
	</table>
		<table class="def-table-full"><tr><td style="text-align: right;">
		
		<sec:authorize access="hasRole('ROLE_STD')">
			<input style="float:right;" type="button" class="def-btn btn-md btn-color" value="제출" onclick="submitForm(this.form);">
		</sec:authorize>
		
		
		<sec:authorize access="hasRole('ROLE_PRO')">
		<div style="float:right;">
			<a href="updateTest?tpNo=${tpNo }&tpNm=${tpNm}&table_Nm=${table_Nm}"><input type="button" class="def-btn btn-md btn-color" value="수정"></a>
			<input type="button" class="def-btn btn-md btn-color" data-target="#layerpop" data-toggle="modal" value="삭제">
			<input type="button" class="def-btn btn-md btn-color" value="목록" onclick="history.back()">
		</div>
		</sec:authorize>
		</td></tr></table>
		
	</form>
	
	<!--모달부분  -->
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
					<a href="deleteTest?tpNo=${tpNo}&table_Nm=${table_Nm}"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>

</body>
</html>
