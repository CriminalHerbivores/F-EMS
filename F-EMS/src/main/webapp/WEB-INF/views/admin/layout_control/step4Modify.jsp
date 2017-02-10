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
<jsp:include page="/decorators/top_decorator.jsp"></jsp:include>

<article>
<form id="step4Modify" action="/fems/admin/layoutPreview" method="post" name="formm">
	
	<div class="set-layout">
	<div class="set-layout-top">
	<img src="<%=request.getContextPath()%>/resources/images/step4.png">
	<h1>STEP4. 컬러 테마 설정</h1>
	</div>
	
	<div class="col-sm-2 sidenav">
	<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="history.go(-1);">	</div>
	</div>
	
	
	<div class="col-sm-8 margin-auto"> 
		<div class="set-layout-center">
			
			<table class="tb-layout def-table tb-border">
				<tr><td>메인 컬러</td><td>R:<input type="text" class="def-input-text-sm" value=""></td>
									<td>G:<input type="text" class="def-input-text-sm" value=""></td>
									<td>B:<input type="text" class="def-input-text-sm" value=""></td>
									<td>색상코드</td></tr>
				<tr><td>보조 컬러1</td><td>R:<input type="text" class="def-input-text-sm" value=""></td>
									<td>G:<input type="text" class="def-input-text-sm" value=""></td>
									<td>B:<input type="text" class="def-input-text-sm" value=""></td>
									<td>색상코드</td></tr>
				<tr><td>보조 컬러2</td><td>R:<input type="text" class="def-input-text-sm" value=""></td>
									<td>G:<input type="text" class="def-input-text-sm" value=""></td>
									<td>B:<input type="text" class="def-input-text-sm" value=""></td>
									<td>색상코드</td></tr>					
				<tr><td colspan="5"><div class="preview-layout">여기에 미리보기</div></td></tr>
			</table>			
			

		</div>
		</div>
		
		
<div class="col-sm-2 sidenav">			
<div class="set-layout-side">
	<!-- 여기 화살표 넣을거임 -->
	<input type="image" src="<%=request.getContextPath()%>/resources/images/right-arrow.png" alt="Submit" onclick="layoutPreview()"><br>
	<input type="image" src="<%=request.getContextPath()%>/resources/images/left-arrow.png" alt="Submit" onclick="layoutPreview()">
	</div>
	</div>

</div>

</form>
</article>

<jsp:include page="/decorators/footer_decorator.jsp"></jsp:include>
</body>
</html>