<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<script>
function window_close(){
	self.close();
}
</script>

<body>

	<img src="<%=request.getContextPath()%>/resources/images/uni_logo.png"
		id="logo">
		<table class="tb-border">
			<tr><td>이름/생년월일로 아이디 찾기</td><td>
			<table class="tb-border">
				<tr><td>이름</td><td><input type="text" class="der-input-text-md"></td><td rowspan="3"><input type="submit" class="def-btn" value="확인"></td></tr>
				<tr><td>생년월일</td><td>
					<select name="년도" class="combobox-md">
					<option value="1"></option>
					<%-- <c:forEach var="year" begin="2017" end="1930" step="-1">
					<option value="year">year</option>
					</c:forEach> --%>
				</select> 
				
				</td></tr>
				<tr><td>성별</td><td>
				
				</td></tr>			
			</table>
			</td><td>이름/이메일로 아이디 찾기</td><td>
			
			</td><td><button
						class="def-btn" value="닫기" onclick="window_close()">닫기</button></td></tr>
		
		</table>


</body>
</html>