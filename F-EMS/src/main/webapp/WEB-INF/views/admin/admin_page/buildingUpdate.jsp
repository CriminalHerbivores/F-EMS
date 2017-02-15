<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 등록된 건물의 정보를 수정하는 JSP
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
<form id="add_building" action="/fems/admin/main" method="post" name="formm">
<h1>건물 정보 수정</h1>
<br/>

<table class="def-table tb-border">
		<tr><td>건물 이름</td><td>
				<select name="선택" class="combobox-lg">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
				</select>
			</td><td colspan="2"><input type="button" class="def-btn" value="선택"></td>
		</tr>
		<tr><td>새 건물 번호</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</tr>
		<tr><td>새 건물 이름</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</tr>
	</table>

<input type="button" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="수정" onclick="go_admin_page()">


</form>
</article>
</body>
</html>