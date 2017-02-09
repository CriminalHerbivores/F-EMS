<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

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

<form id="" action="/fems/menutype"  method="post" name="formm">
			
			
			<table class="tb-border">
	<tr><td colspan="3"><img src="<%=request.getContextPath()%>/resources/images/uni_logo.png"></td>
	<td colspan="2" rowspan="2"><img src="<%=request.getContextPath()%>/resources/images/fems_logo.png"></td></tr>
	<tr><td colspan="3">	
			<table class="def-table tb-border">
				<tr><td><input type="text" class="def-input-text-md" name="id" placeholder="아이디"></td>
					<td rowspan="2">
					<input type="submit" class="def-btn" id="admin_join_btn" value="로그인" onclick="go_index()"></td></tr>
				<tr><td><input type="password" class="def-input-text-md" name="password" placeholder="패스워드"></td></tr>
				<tr><td colspan="2"><span id='change'>여기 아작스</span></td></tr></table>
		<tr><td><div class="w3-container">
  <button onclick="document.getElementById('id01').style.display='block'" class="">ID/PW 찾기</button>
  
 <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-animate-opacity modal-md">
      <div class="w3-container">
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-closebtn">&times;</span>
        <jsp:include page="find_id_pw.jsp"></jsp:include>       
        
        
        
        
       </div>
    </div>
  </div>
  </div>
		
		</td><td><input type="button" value="PW찾기" onclick="modal_find_pw()"></td></tr>
		<tr><td><div>메뉴1</div></td><td><div>메뉴2</div></td><td><div>메뉴3</div></td><td><div>메뉴4</div></td><td><div>메뉴5</div></td></tr>	
		<tr><td><div>메뉴6</div></td><td><div>메뉴7</div></td><td><div>메뉴8</div></td><td><div>메뉴9</div></td><td><div>메뉴10</div></td></tr>	
		<tr><td><div>메뉴11</div></td><td><div>메뉴12</div></td><td><div>메뉴13</div></td><td><div>메뉴14</div></td><td><div>메뉴15</div></td></tr>	
	</table>
		
</form>	



<!-- Footer 시작 -->
	<footer class="footer container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<!-- Footer 끝 -->

</body>
</html>