<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 학부와 학과 등록이 가능한 JSP
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
<form id="add_subject" action="/fems/admin/main" method="post" name="formm">
<h1>학부·학과 등록</h1>

<table class="def-table tb-border">
		<tr><td>단과대학 선택</td><td colspan="3">
				<select name="선택" class="combobox-lg">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
				</select>
		</td></tr>
		<tr><td>단과대학 추가</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기 아작스</td></tr>	
		<tr><td>학부 선택</td><td colspan="3">
				<select name="선택" class="combobox-lg">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
				</select>
		</td></tr>
		<tr><td>학부 추가</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기 아작스</td></tr>	
		<tr><td>학과 추가</td><td><input type="text" class=".def-input-text-lg"></td><td><input type="button" class="def-btn" value="중복 확인"></td><td>여기 아작스</td></tr>	
		<tr><td>학과 전화번호</td><td>
					<select name="선택" class="combobox-sm">
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
					<option value="043">043</option>
					<option value="051">051</option>
					<option value="052">052</option>
					<option value="053">053</option>
					<option value="054">054</option>
					<option value="055">055</option>
					<option value="061">061</option>
					<option value="062">062</option>
					<option value="063">063</option>
					<option value="064">064</option>
					<option value="010">010</option>
					<option value="012">012</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select> 
						-<input type="text" class=".def-input-text-sm">-<input type="text" class=".def-input-text-sm"></td>
						<td><input type="button" class="def-btn" value="중복 확인"></td><td>여기 아작스</td></tr>
			
		<tr><td>등록금 책정</td><td colspan="3"><input type="text" class=".def-input-text-lg"></td></tr>
	</table>


<br/>
<input type="button" class="def-btn" value="이전" onclick="history.go(-1);">&nbsp;&nbsp;<input type="submit" class="def-btn" value="완료" onclick="go_admin_page()">


</form>
</article>
</body>
</html>