<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%--
 * <pre>
 * 레이아웃 중 메뉴강조형 로그인화면 JSP
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
<meta name="viewport" content="width=device-width, initial-scale=1">

<script>
// Get the modal
$(document).ready(function(){
    $("#course_able").load("<%=request.getContextPath()%>/find_id_pw");
});



var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it -> 아무곳이나 눌러도 닫히도록 설정
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
		

</head>
<body>

<form id="" method="post" name="formm">
		<!-- <div class="custom-col-sm-10-top sidenav text-left">	 -->
<div class=" array-center ">			
			<table class="def-table-auto">
	<tr><td colspan="3"><img src="<%=request.getContextPath()%>/resources/images/uni_logo.png"></td>
	<td colspan="2" rowspan="2"><img src="<%=request.getContextPath()%>/resources/images/uni_img.png"></td></tr>
	<tr><td colspan="3">	
			<table class="def-table-auto out-border">
			<form action="login" id="loginForm" method="post">
				
				
				<tr><td>
<input type="hidden" name="returl" value="${param.returl }" />
<input type="text" class="def-input-text-md custom-form-control" name="userid" placeholder="아이디" value="${param.userid }"/>
				</td>
					<td rowspan="2">
<input type="submit" class="def-btn btn-lg btn-color" value="로그인">
				<tr><td>
<input type="password" class="def-input-text-md custom-form-control" name="password" placeholder="패스워드">
				</td></tr>
				<!-- <tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr> -->
		<tr><td><div class="w3-container">
  <button onclick="document.getElementById('id01').style.display='block'" class="def-btn btn-sm btn-color">ID찾기</button>
		</td><td><input type="button" value="PW찾기" class="def-btn btn-sm btn-color" onclick="modal_find_pw()"></td></tr>
				
				</table>
</form>
  
  <!-- ///////////////////// modal START ///////////////////// -->
<%--  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-animate-opacity modal-md">
      <div class="w3-container">
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-closebtn">&times;</span>
        <jsp:include page="find_id_pw.jsp"></jsp:include>       
       </div>
    </div>
  </div> --%>
  <!-- ///////////////////// modal END ///////////////////// -->
  
  </div>
  <tr><td colspan="5">
		<table class="def-table-full" style="width:100% !important;">
		<tr><td class="login-menu-gray"><div>메뉴1</div></td><td  class="login-menu"><div>메뉴2</div></td><td class="login-menu-gray"><div>메뉴3</div></td><td class="login-menu"><div>메뉴4</div></td><td class="login-menu-gray"><div>메뉴5</div></td></tr>	
		<tr><td class="login-menu"><div>메뉴6</div></td><td  class="login-menu-gray"><div>메뉴7</div></td><td class="login-menu"><div>메뉴8</div></td><td class="login-menu-gray"><div>메뉴9</div></td><td class="login-menu"><div>메뉴10</div></td></tr>	
		<tr><td class="login-menu-gray"><div>메뉴11</div></td><td  class="login-menu"><div>메뉴12</div></td><td class="login-menu-gray"><div>메뉴13</div></td><td class="login-menu"><div>메뉴14</div></td><td class="login-menu-gray"><div>메뉴15</div></td></tr>	
	</table></td></tr>
	</table>
	</div>
		<!-- </div> -->
</form>	



<!-- Footer 시작 -->
<!-- 	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer> -->
	<!-- Footer 끝 -->

</body>
</html>