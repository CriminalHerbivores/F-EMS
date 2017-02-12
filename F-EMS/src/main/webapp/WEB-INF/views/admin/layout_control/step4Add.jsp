<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<article>
<form id="step4Add" action="/fems/admin/layoutPreview" method="post" name="formm">
	
	<div class="set-layout">
	<div class="set-layout-top">
	<img src="<%=request.getContextPath()%>/resources/images/step4.png"><br/>
	<h1>STEP4. 컬러 테마 설정</h1>
	</div>
	
	<div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">	</div>
	</div>
	
	
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
			
			<table class="tb-layout out-border">
				<tr><td>메인 컬러</td><td>R:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td>G:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td>B:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td><input type="color" name="favcolor" value="#ff0000">&nbsp;&nbsp;<input type="submit" class="def-ckbtn btn-sm ckbtn-gray" value="적용"></td></tr>
				<tr><td>보조 컬러1</td><td>R:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td>G:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td>B:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td><input type="color" name="favcolor" value="#00ff00">&nbsp;&nbsp;<input type="submit" class="def-ckbtn btn-sm ckbtn-gray" value="적용"></td></tr>
				<tr><td>보조 컬러2</td><td>R:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td>G:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td>B:&nbsp;<input type="text" class="def-input-text-sm custom-form-control" value=""></td>
									<td><input type="color" name="favcolor" value="#0000ff">&nbsp;&nbsp;<input type="submit" class="def-ckbtn btn-sm ckbtn-gray" value="적용"></td></tr>					
				<tr><td colspan="5"><div class="preview-layout margin-auto">여기에 미리보기</div></td></tr>
			</table>			
			

		</div>
		</div>
		
		
<div class="col-sm-2 sidenav">			
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="layoutPreview()">
	</div>
	</div>

</div>

</form>
</article>
</body>
</html>