<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
<style type="text/css">
body{   
   background-color:#ffffff;
   font-family: Verdana;
}
#popup{   
   padding: 0 10px;
}
#popup h1 {
   font-size: 45px;
   color: #CCC;
   font-weight: normal;
}

table#zipcode {
    border-collapse:collapse;    /* border 사이의 간격 없앰 */   
    border-top: 3px solid  #fff;  
    border-bottom: 3px solid  #fff;
    width: 100%;  
    margin-top: 15px; 
}
table#zipcode th, table#zipcode td{   
   text-align: center;
   border-bottom: 1px dotted  #fff;  
   color:#474747;   
}
table th, td{
  padding: 10px;
}
table#zipcode  a{
   display:block; 
    height:20px;
    text-decoration:none;
    color:#474747;
    padding: 10px;
}
table#zipcode a:hover{
    color: #F90;
    font-weight: bold;
}
</style>
<script type="text/javascript">


/* function searchLctre() {
	var url = "findLctre";
	window
			.open(
					url,
					"_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
} */


/* 교수-강의등록요청 에서 강의명으로 검색하여 강의 선택시 값 입력 */
function resultLctre(lu_Lctre_Nm,sit_Subjct,lu_Lctre_Code,lu_Compl_Se,lu_Pnt,lu_Grade,lu_Presubjct) {
   opener.document.formm.lu_Lctre_Nm.value=lu_Lctre_Nm;
   opener.document.formm.sit_Subjct.value=sit_Subjct;
   opener.document.formm.lu_Lctre_Code.value=lu_Lctre_Code;
   opener.document.formm.lu_Compl_Se.value=lu_Compl_Se;
   opener.document.formm.lu_Pnt.value=lu_Pnt;
   opener.document.formm.lu_Grade.value=lu_Grade;
   opener.document.formm.lu_Presubjct.value=lu_Presubjct;
   self.close();
};
</script>
</head>
<body>
<div id="popup">
  <h1>강의 검색</h1>
  <form method=post name=formm action="findLctre">
    강의명 : <input name="lu_Lctre_Nm" type="text">
            <input type="submit" value="찾기"  class="submit">
  </form>
  <table id="zipcode">
    <tr>
    	<th>개설학과전공</th>
      <th>강의코드</th>
      <th>강의명</th>
    </tr>
    <c:forEach items="${lctre_SearchVO}" var="lctre">
    <tr>
   		<td>${lctre.sit_Subjct}</td>
      <td>${lctre.lu_Lctre_Code}</td>
        <td>
          <a href="#" onclick="return resultLctre('${lctre.lu_Lctre_Nm}','${lctre.sit_Subjct}', '${lctre.lu_Lctre_Code}','${lctre.lu_Compl_Se}','${lctre.lu_Pnt}','${lctre.lu_Grade}','${lctre.lu_Presubjct}')">
			${lctre.lu_Lctre_Nm}
          </a>
        </td>
    </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>