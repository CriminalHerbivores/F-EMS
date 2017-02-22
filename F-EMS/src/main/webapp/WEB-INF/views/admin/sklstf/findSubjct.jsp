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


/* 관리자- 직원등록에서 학과명으로 검색하여 학과 선택시 값 입력 */
function resultSubjct(coleg_Nm,fc_Faculty_Nm,sit_Subjct,sit_Subjct_Code) {
   opener.document.formm.coleg_Nm.value=coleg_Nm;
   opener.document.formm.fc_Faculty_Nm.value=fc_Faculty_Nm;
   opener.document.formm.sit_Subjct.value=sit_Subjct;
   opener.document.formm.sit_Subjct_Code.value=sit_Subjct_Code;
   self.close();
};
</script>
</head>
<body>
<div id="popup">
  <h1>학과 검색</h1>
  <form method=post name=formm action="findSubjct">
    학과명 : <input name="sit_Subjct" type="text">
            <input type="submit" value="찾기"  class="submit">
  </form>
  <table id="zipcode">
    <tr>
    	<th>개설학과전공</th>
      <th>강의코드</th>
      <th>강의명</th>
    </tr>
    <c:forEach items="${userSubjctVO}" var="subjct">
    <tr>
   		<td>${subjct.coleg_Nm}</td>
      <td>${subjct.fc_Faculty_Nm}</td>
        <td><a href="#" onclick="return resultSubjct('${subjct.coleg_Nm}','${subjct.fc_Faculty_Nm}', '${subjct.sit_Subjct}','${subjct.sit_Subjct_Code}')">
			${subjct.sit_Subjct}
          </a>
        </td>
    </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>