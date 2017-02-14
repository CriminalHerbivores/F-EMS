<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
		<h3>학적 변동 내역</h3>
		<table class="def-table-full tb-border table-hover">
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

		<c:forEach var="sknrgs" items="${sknrgsList}" begin="0" end="0"
			step="1">
			<c:if test="${not empty sknrgs.skn_Useyn}">

				<h3>학적 변동 신청 상세</h3>
				<form name="formm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="skn_Stdnt_No" value="${loginUser}">
					<table class="def-table-full tb-border table-hover">
						<tr>
							<th>학적상태</th>
							<td><c:choose>
									<c:when test="${type=='졸업'}">
								      졸업
								      </c:when>
									<c:otherwise>
								      재학
								      </c:otherwise>
								</c:choose></td>
							<th>학적상세</th>
							<td>${type}</td>
						</tr>
						<tr>
							<th>학적변동 구분</th>
							<td colspan="3"><c:choose>
									<c:when test="${type=='졸업'}">
								   	졸업
								    </c:when>
									<c:when test="${type=='휴학'}">
										<input type="radio" name="skn_Type" value="복학" id="b">
										<label for="b">복학</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="skn_Type" value="일반휴학" id="r">
										<label for="r">일반휴학</label>
										<input type="radio" name="skn_Type" value="군입대휴학" id="m">
										<label for="m">군입대휴학</label>
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<th>사유</th>
							<td colspan="2">
								<div id="sknContent"></div>
								<div id="toSknrgsRest" class="non-disp">
									<select id="sknSelect" class="combobox-md custom-form-control"
										name="skn_Content" size="1">
										<option value="선택">선택</option>
										<option value="경제사정">경제사정</option>
										<option value="업무부담">업무부담</option>
										<option value="애경사">애경사</option>
										<option value="자녀양육">자녀양육</option>
										<option value="건강문제">건강문제</option>
										<option value="간병">간병</option>
										<option value="수험">수험</option>
										<option value="해외거주">해외거주</option>
										<option value="기타">기타</option>
									</select>
								</div>
							</td>
							<td><input type="file" name="sknFile" value="첨부파일">
							</td>
						</tr>
					</table>
					<input type="button" class="def-btn btn-sm btn-color" id="selAll"
						disabled value="신청하기" onclick="writeSknrgs(this.form)">
				</form>
			</c:if>
		</c:forEach>
		<%-- 휴학기간 (시작/끝) 복학예정일자 (2015년도 1학기~2015년도1학기까지 2015-03-01~2015-08-31) : 학기 단위라서 생략 --%>
		<h3>안내</h3>
		<ul>
			<li>휴학은 한 학기(1학기) 단위로 휴학 가능하며, 학기 단위로 신청 가능</li>
			<li>휴학기간이 만료되면 반드시 복학 또는 휴학기간 연장 신청을 해야 함</li>
			<li>1. 일반휴학 : 일반휴학은 재학 연한 중 통상 4학기를 초과할 수 없습니다.</li>
			<li>2. 입대휴학 : 입영통지서 파일을 첨부하시면 휴학원서를 제출하지 않고 휴학처리 됩니다.</li>
		</ul>
</body>
</html>