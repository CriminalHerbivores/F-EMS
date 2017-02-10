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
<form id="add_classroom" action="/fems/admin/main" method="post" name="formm">
<h1>강의실 등록</h1>

<table class="def-table tb-border">
		<tr><td>강의실 번호</td><td><input type="text" class=".def-input-text-lg"></td><td>여기 아작스</td></tr>
		<tr><td>건물 번호</td><td colspan="2">
				<select name="선택" class="combobox-lg">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
				</select>
			</td></tr>
		<tr><td>건물 이름</td><td colspan="2">
				<select name="선택" class="combobox-lg">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
				</select>
			</td></tr>
		<tr><td>층수</td><td colspan="2">
				<select name="선택" class="combobox-lg">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
				</select>
			</td></tr>	
		<tr><td>호실</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td></tr>
		<tr><td>수용 인원</td><td colspan="2"><input type="text" class=".def-input-text-lg"></td></tr>
	</table>



<br/>
<input type="button" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="등록" onclick="go_admin_page()">


</form>
</article>
</body>
</html>