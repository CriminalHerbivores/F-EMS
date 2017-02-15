<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 강의실 사용유무를 설정할 수 있는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>


<body>
<article>
<form id="set_classroom" action="/fems/admin/main" method="post" name="formm">
<h1>강의실 설정</h1>

<table class="def-table tb-border">
		<tr><td>
<select name="선택" class="combobox-md">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
				</select></td>
			<td><input type="text" class=".def-input-text-md"></td>
			<td><input type="button" class="def-btn" value="조회"></td></tr>
			</table>
			
<table class="def-table tb-border">			
			<tr><td colspan="6"></td><td><input type="checkbox" name="cc" value="100"></td><td>전체선택</td></tr>
	<tr><td>강의실 번호</td><td>건물 번호</td><td>건물 이름</td><td>층수</td><td>호실</td><td>수용인원</td><td>사용</td><td></td></tr>
	<tr><td>E01202</td><td>E01</td><td>공학관</td><td>5</td><td>15</td><td>50</td><td><input type="checkbox" name="cc" value="100"></td><td><input type="button" class="def-btn" value="적용"></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
</table>


<br/>
<input type="button" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="완료" onclick="go_admin_page()">


</form>
</article>
</body>
</html>