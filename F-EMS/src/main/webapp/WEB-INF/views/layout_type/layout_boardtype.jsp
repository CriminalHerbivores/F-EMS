<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>

<article>
<form id="admin_join" action="/fems/admin/step1_add"  method="post" name="formm">


<jsp:include page="/decorators/top_menu_decorator.jsp"></jsp:include>






	<div class="container-fluid">
		<div class="row content">
			
			<div class="custom-col-sm-2 sidenav">
			
			<table class="tb-border">
				<tr><td><input type="text" class="def-input-text-md" name="id" placeholder="아이디"></td>
					<td rowspan="2">
					<input type="submit" class="def-btn" id="admin_join_btn" value="로그인" onclick="go_index()"></td></tr>
				<tr><td><input type="password" class="def-input-text-md" name="password" placeholder="패스워드"></td></tr>
				<tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr>
		<tr><td><input type="button" class="def-btn" value="ID찾기" onclick="modal_find_id()"></td><td><input type="button" value="PW찾기" onclick="modal_find_pw()"></td></tr>
			</table>
			<div>

			<table><tr><td>여기 스케쥴러</td></tr></table>
			</div>
			</div>
			<div class="custom-col-sm-10 sidenav text-left">
			<table class="def-table tb-border">
				<tr><td>게시판1</td><td>게시판2</td></tr>
				<tr><td>게시판3</td><td>게시판4</td></tr>
			</table>
			
	</div></div>
	</div>

<jsp:include page="/decorators/menu_decorator.jsp"></jsp:include>
</form>
</article>

</body>
</html>