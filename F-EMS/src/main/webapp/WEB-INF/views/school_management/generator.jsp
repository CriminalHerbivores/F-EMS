<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spting" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function delet() {
     document.frm.action = "<%=request.getContextPath()%>/bbs_list/insertTable";
     document.frm.submit();
 }
 function insert() {
     document.frm.action = "<%=request.getContextPath()%>/bbs_list/insertTable";
     document.frm.submit();
 }

</script>
</head>
<body>
<form name="frm" method="get" action="<%=request.getContextPath()%>/bbs_list/insertTable">
	게시판 번호 : <input type="text" name="bl_Bbs_No">
	제시판명 : <input type="text" name="bl_Bbs_Nm">
	테이블명 : <input type="text" name="bl_Table_Nm">
	사용유무 : <input type="text" name="bl_Use_Ennc">
	관리자 : <input type="text" name="ba_Manage">
	직원 : <input type="text" name="ba_Sklstf">
	교수 : <input type="text" name="ba_Profsr">
	학생 : <input type="text" name="ba_Stdnt">
	<input type="submit" value="입력">
</form>
</body>
</html>