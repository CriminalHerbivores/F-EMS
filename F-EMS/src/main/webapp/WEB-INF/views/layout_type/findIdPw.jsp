<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
--%>

<%--
 * <pre>
 * 아이디/비밀번호 찾기가 가능한 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>

<%--	
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<html>
<style>
.city {display:none}
</style>

<body>
 
<div class="w3-container">

<div id="id01" class="w3-modal">
 <div class="w3-modal-content w3-card-4 w3-animate-opacity">
  <header class="w3-container w3-blue"> 
   <span onclick="document.getElementById('id01').style.display='none'" 
   class="w3-closebtn w3-padding-top">&times;</span>
   <h2>Header</h2>
  </header>

  <ul class="w3-pagination w3-white w3-border-bottom" style="width:100%;">
   <li><a href="#" class="tablink" onclick="openCity(event, 'find_id')">아이디 찾기</a></li>
   <li><a href="#" class="tablink" onclick="openCity(event, 'find_pw')">비밀번호 찾기</a></li>
  </ul>

  <div id="find_id" class="w3-container city">
	<img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}"
		id="logo">
		<table class="tb-border">
			<tr><td>이름/생년월일로 아이디 찾기</td></tr>
			<tr><td>
			<table class="tb-border">
				<tr><td>이름</td><td><input type="text" class="der-input-text-md"></td><td rowspan="3"><input type="submit" class="def-btn" value="확인"></td></tr>
				<tr><td>생년월일</td><td>
					<select name="년도" class="combobox-md">
					<option value="1"></option>
					<c:forEach var="year" begin="2017" end="1930" step="-1">
					<option value="year">year</option>
					</c:forEach>
				</select> 
				</td></tr>
				<tr><td>성별</td><td>
					<select name="선택" class="combobox-md">
					<option value="남">남</option>
					<option value="여">여</option>
					</select>
				</td></tr>			
			</table></td></tr>
			<tr><td>이름/이메일로 아이디 찾기</td><td>
			<tr><td>
			<table class="tb-border">
				<tr><td>이름</td><td><input type="text" class="der-input-text-md"></td><td rowspan="3"><input type="submit" class="def-btn" value="확인"></td></tr>
				<tr><td>이메일</td><td>
					<select name="이메일" class="combobox-md">
					<option value="@gmail.com">@gmail.com</option>
					<c:forEach var="year" begin="2017" end="1930" step="-1">
					<option value="year">year</option>
					</c:forEach>
				</select> 
				
				</td></tr>
				<tr><td>성별</td><td>
					<select name="선택" class="combobox-md">
					<option value="남">남</option>
					<option value="여">여</option>
					</select>
				</td></tr>			
			</table></td></tr>
			<tr><td><button
						class="def-btn" value="닫기" onclick="window_close()">닫기</button></td></tr>
		</table>
   </div>
  <div id="find_pw" class="w3-container city">
	<img src="<%=request.getContextPath()%>${manageVO.mng_Univ_Logo}"
		id="logo">
		<table class="tb-border">
			<tr><td>이름/생년월일로 비밀번호 찾기</td></tr>
			<tr><td>
			<table class="tb-border">
				<tr><td>아이디</td><td><input type="text" class="der-input-text-md"></td><td rowspan="3"><input type="submit" class="def-btn" value="확인"></td></tr>
				<tr><td>이름</td><td><input type="text" class="der-input-text-md"></td></tr>
				<tr><td>생년월일</td><td>
					<select name="년도" class="combobox-md">
					<option value="1"></option>
					<c:forEach var="year" begin="2017" end="1930" step="-1">
					<option value="year">year</option>
					</c:forEach>
				</select> 
				</td></tr>
				<tr><td>성별</td><td>
					<select name="선택" class="combobox-md">
					<option value="남">남</option>
					<option value="여">여</option>
					</select>
				</td></tr>			
			<tr><td>비밀번호 확인 <input type="radio" name="find_pw" value="이메일">이메일&nbsp;&nbsp;<input type="radio" name="find_pw" value="휴대폰">휴대폰</td></tr>
			</table></td></tr>
			<tr><td><button
						class="def-btn" value="닫기" onclick="window_close()">닫기</button></td></tr>
		</table>
  </div>


  <div class="w3-container w3-light-grey w3-padding">
   <button class="w3-btn w3-right w3-white w3-border" 
   onclick="document.getElementById('id01').style.display='none'">Close</button>
  </div>
 </div>
</div>

</div>

</body>
</html>  --%>




 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/lib/w3.css">
<body>

<div class="w3-container">
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-btn">Open Modal</button>

  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-8 w3-animate-opacity">
      <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id01').style.display='none'" 
        class="w3-closebtn">&times;</span>
        <h2>Modal Header</h2>
      </header>
      <div class="w3-container">
        <p>You have two options to close this modal:</p>
        <p>Click on the "x" or click anywhere outside of the modal!</p>
      </div>
      <footer class="w3-container w3-teal">
        <p>Modal Footer</p>
      </footer>
    </div>
  </div>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>
