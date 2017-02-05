<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="${encoding}">
<title>${cursor}</title>
</head>
<body>

	<div class="container">
		<h3>학적 변동 내역</h3>
		<table class="table table-bordered">
			<tr>
				<th>No</th>
				<th>학적변동</th>
				<th>사유</th>
				<th>신청날짜</th>
				<th>승인여부</th>
			</tr>
			<c:forEach var="sknrgs" items="${sknrgsList}">
				<tr>
					<td>${sknrgs.skn_No}</td>
					<td>${sknrgs.skn_Type}</td>
					<td>${sknrgs.skn_Content}</td>
					<td><fmt:formatDate value="${sknrgs.skn_Reqst_Dt}" /></td>
					<td>${sknrgs.skn_Useyn}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align: center;">${paging }</td>
			</tr>
		</table>
		
		<%-- <c:forEach var="sknrgs" items="${sknrgsList}" begin="2" end="2" step="1">
		<c:if test="${not empty sknrgs.skn_Useyn}"> --%>
		
		<h3>학적 변동 신청 상세</h3>
		<form name="formm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="skn_Stdnt_No" value="${loginUser}">
		<table>
			<tr>
				<th>
					학적상태
				</th>
				<td>
					<c:choose>
						<c:when test="${type=='졸업'}">
						졸업
						</c:when>
						<c:otherwise>
						재학
						</c:otherwise>
					</c:choose>
				</td>
				<th>
					학적상세
				</th>
				<td>
					${type}
				</td>
			</tr>
			<tr>
				<th>
					학적변동 구분
				</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${type=='휴학'}">
							<input type="radio" name="skn_Type" value="복학" id="b">
							<label for="b">복학</label>
						</c:when>
						<c:when test="${type=='복학'}">
							<input type="radio" name="skn_Type" value="일반휴학" id="r">
							<label for="r">일반휴학</label>
							<input type="radio" name="skn_Type" value="군입대휴학" id="m">
							<label for="m">군입대휴학</label>
						</c:when>
						<c:otherwise>
						변동 불가
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>
					휴학사유
				</th>
				<td id="sknContent" colspan="2">
					
				</td>
				<td>
					<input type="file" name="sknFile" value="첨부파일">
				</td>
				<th>
				</th>
			</tr>
		</table>
		<input type="button" id="selAll" value="신청하기" onclick="writeSknrgs()">
		</form>
		
		<%-- </c:if>
		</c:forEach> --%>
		
		<%-- 휴학기간 (시작/끝) 복학예정일자 (2015년도 1학기~2015년도1학기까지 2015-03-01~2015-08-31) : 학기 단위라서 생략 --%>
		<h3>안내</h3>
		<ul>
		<li>휴학은 한 학기(1학기) 단위로 휴학 가능하며, 학기 단위로 신청 가능</li>
		<li>휴학기간이 만료되면 반드시 복학 또는 휴학기간 연장 신청을 해야 함</li>
		<li>1. 일반휴학 : 일반휴학은 재학 연한 중 통상 4학기를 초과할 수 없습니다.</li>
		<li>2. 입대휴학 : 입영통지서 파일을 첨부하시면 휴학원서를 제출하지 않고 휴학처리 됩니다.</li>
		</ul>
	</div>

</body>
</html>
