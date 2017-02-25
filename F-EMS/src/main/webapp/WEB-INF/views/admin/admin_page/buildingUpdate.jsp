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

		<table class="def-table-auto tb-border table-hover">
		<tr><td>건물 이름</td><td>
				<select name="선택" class="combobox-lg">
				<c:forEach items="${buildingVO}" var="building">
									
					<option value="${building.bd_Nm}">${building.bd_Nm}</option>
				</c:forEach><!-- 건물명 쭉 가져오고 싶음 -->
				</select>
			</td><td colspan="2"><input type="button" class="def-btn" value="선택"></td>
		</tr>
		<tr><td>건물 번호</td><td><input type="text" class=".def-input-text-lg" name="bd_No" value="${bd_No}"></td><td><input type="button" class="def-btn btn-sm btn-color" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</td></tr>
		<tr><td>건물 이름</td><td><input type="text" class=".def-input-text-lg" name="bd_Nm" value="${bd_Nm }"></td><td><input type="button" class="def-btn btn-sm btn-color" value="중복 확인"></td><td>여기에 아작스로 사용가능여부</td></tr>
		<tr><td>사용 여부</td><td>
		<c:choose>
		<c:when test="${bd_Useyn=='y'|| bd_Useyn=='Y'}">
		<label><input type="radio" name="bd_Useyn" value="y" checked="checked" >사용</label>&nbsp;&nbsp;<label><input type="radio" name="bd_Useyn" value="n">사용 안함</label>
		</c:when>
	<c:otherwise>
	<label><input type="radio" name="bd_Useyn" value="y" >사용</label>&nbsp;&nbsp;<label><input type="radio" name="bd_Useyn" value="n" checked="checked" >사용 안함</label>
	</c:otherwise>		
		</c:choose>
		</td><td></td><td></td></tr>
	</table>

<input type="button" class="def-btn btn-md btn-color" value="수정" onclick="submitForm(this.form);">&nbsp;&nbsp;
<input type="button" class="def-btn btn-md btn-gray" value="목록" onclick="go.history(-1);">


</form>
</article>
</body>
</html>