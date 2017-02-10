<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<input type="text" class="def-input-text-sm" value=""><br/>
<input type="text" class="def-input-text-md" value=""><br/>
<input type="text" class="def-input-text-lg" value=""><br/>
<br/>
<input type="button" class="def-button" value="기본"><br/>
<br/>

<!-- <input type="" class="" value=""><br/> -->

<select name="선택" class="combobox-sm">
					<option value="">작음</option>
					<option value="">이건작은거임</option>
					</select><br/>
<select name="선택" class="combobox-md">
					<option value="">중간</option>
					<option value="">이건중간거임</option>
					</select><br/>
<select name="선택" class="combobox-lg">
					<option value="">큰거</option>
					<option value="">이건큰거임</option>
					</select><br/>					
<br/>

<table class="def-table tb-border">
	<tr><td>이것</td><td>저것</td><td>요것</td></tr>
	<tr><td>이것</td><td>저것</td><td>요것</td></tr>
	<tr><td>이것</td><td>저것</td><td>요것</td></tr>
	<tr><td>이것</td><td>저것</td><td>요것</td></tr>
</table><br/>

</body>
</html>