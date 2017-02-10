<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
<article>
<form id="set_subject" action="/fems/admin/main" method="post" name="formm">
<h1>학부·학과 설정</h1>

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
			<td><input type="text" class=".def-input-text-sm"></td>
			<td><input type="button" class="def-btn" value="조회"></td></tr>
			</table>
			
<table class="def-table tb-border">			
			<tr><td colspan="4"></td><td><input type="checkbox" name="cc" value="100"></td><td>전체선택</td></tr>
	<tr><td>학과 코드</td><td>단과대학 이름</td><td>학부 이름</td><td>학과 이름</td><td>사용</td><td></td></tr>
	<tr><td>00000</td><td>공학대학</td><td>공학부</td><td>컴퓨터 공학과</td><td><input type="checkbox" name="cc" value="100"></td><td><input type="button" class="def-btn" value="적용"></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
</table>


<br/>
<input type="button" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="완료" onclick="go_admin_page()">


</form>
</article>
</body>
</html>