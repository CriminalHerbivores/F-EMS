<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<jsp:useBean id="now" class="java.util.Date" />

<%--
 * <pre>
 * 교수가 강의 정보를 입력하여 개설한 강의를 수정
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.02.20      KJH        최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script type="text/javascript">
/* function searchLctre() {
	var url = "findLctre";
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
} */
 
</script>

</head>
<body>

<h2>강의 계획서</h2><br/>

<form id="formm" name="formm" method="post"><!--  action="requestLctre" > -->
<table class="non-border margin-auto">
	<tr><td>
<table class="def-table-auto tb-border table-hover">
<tr><th colspan="4">개설 강의 정보</th></tr>
	<tr>
		<th>개설년도/학기</th>
		<td><fmt:formatDate value="${lctre_SearchVO.lc_Lctrbgn_Dt}" pattern="yyyy"/>년도&nbsp;${lctre_SearchVO.lc_Term}학기
		</td>
		<th>개설학과전공</th>
		<td>${lctre_SearchVO.sit_Subjct}
		</td> 
	 </tr>
	 
	 <tr>
	 	<th>교과목명</th>
	 	<td>${lctre_SearchVO.lu_Lctre_Nm}</td>
	 	<th>강의번호</th>
	 	<td>
	 	${lctre_SearchVO.lc_Lctre_Code}
	 	</td>
	 </tr>
	 
	 <tr>
	 	<th>이수구분</th>
	 	<td>${lctre_SearchVO.lu_Compl_Se}</td>
	 	<th>이수학점</th>
	 	<td>${lctre_SearchVO.lu_Pnt}</td>
	 </tr>
	 <tr>
	 	<th>학년</th>
	 	<td>${lctre_SearchVO.lu_Grade}</td>
	 	
	 	<th>선행과목</th>
	 	<td>${lctre_SearchVO.lu_Presubjct}</td>
	 </tr>
	 
	 <tr><th colspan="4">담당 교수 정보</th></tr>
	 <tr>
	<%-- <c:forEach items="${lctre_SearchVO}" var="profsr"> --%>
	 	<th>교수이름</th>
	 	<td>${lctre_SearchVO.pr_Nm}
	 	</td>   
	 	
	 	<th>담당교수전화</th>
	 	<td>${lctre_SearchVO.pr_Profsr_Tlphon_No}
	 	</td>
	 </tr>
	  <tr>
	 	<th>교수 이메일 주소</th>
	 	<td>${lctre_SearchVO.pr_Email}</td>
	 	
	 	<th></th>
	 	<td></td>
	 	<%-- </c:forEach> --%>
	 </tr>
	 

	<tr><th colspan="4">강의 상세 정보</th></tr>
	
	 <tr>
	 	<th>주간 강의 요일</th>
	 	<td>
	 	${lctre_SearchVO.lc_Wik_Lctre_Dayweek}
	 	${lctre_SearchVO.lc_Lctre_Time}
	 	</td> 
	 	<th>강의실</th>
	 	<td>
	 	${lctre_SearchVO.lc_Lctrum_No}
	 	</td>
	 	<!-- 강의 테이블의 강의실번호 lc_Lctrum_No 를 갖고와야 할텐데... -->
	 </tr>
	   <tr>
	      <th>학습평가방법(100%)</th>
	      <td colspan="3" class="padding-0">
	      
	      <table class="def-table-auto tb-border table-hover w-h-100 margin-0">
	      <tr>
	      <td>중간고사</td>
	      <td>기말고사</td>
	      <td>개인과제</td>
	      <td>팀별과제</td>
	      <td>발표</td>
	      <td>출석</td>
	      <td>태도</td>
	     </tr>
	     
	     <tr>
	     	<td>${lctre_SearchVO.la_Midex }</td>
	     	<td>${lctre_SearchVO.la_Fnex }</td>
	     	<td>${lctre_SearchVO.la_Indvdl_Task }</td>
	     	<td>${lctre_SearchVO.la_Team_Task }</td>
	     	<td>${lctre_SearchVO.la_Presnatn }</td>
	     	<td>${lctre_SearchVO.la_Atend }</td>
	     	<td>${lctre_SearchVO.la_Attd }</td>
	     </tr>
	      </table>
	      
	      
	      </td>
	      </tr>
	     
	     <tr>
	     	<th>강의 진행 형태</th>
	     	<td colspan="3">${lctre_SearchVO.la_Lctre_Progrs_Form}</td>
	     </tr>
	     
	     <tr>
	     	<th>강의 목표</th>
	     	<td colspan="3">${lctre_SearchVO.la_Lctre_Goal}</td>
	     </tr>
	     
	     <tr>
	     	<th>주교재</th>
	     	<td colspan="3">${lctre_SearchVO.la_Main_Txtbook}</td>
	     </tr>
	     
	     <tr>
	     	<th>부교재</th>
	     	<td colspan="3">${lctre_SearchVO.la_Sub_Txtbook}</td>
	     </tr>
	     
	     <tr>
	     	<th colspan="8">강의 내용 및 학습 내용</th>
	     </tr>
	     
	     <tr>
	     	<th>1주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week1}</td>
	     </tr>
	     
	     <tr>
	     	<th>2주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week2}</td>
	     </tr>
	     
	     <tr>
	     	<th>3주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week3}</td>
	     </tr>
	     
	     <tr>
	     	<th>4주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week4}</td>
	     </tr>
	     
	     <tr>
	     	<th>5주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week5}</td>
	     </tr>
	     
	     <tr>
	     	<th>6주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week6}</td>
	     </tr>
	     
	     <tr>
	     	<th>7주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week7}</td>
	     </tr>
	     
	     <tr>
	     	<th>8주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week8}</td>
	     </tr>
	     
	     <tr>
	     	<th>9주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week9}</td>
	     </tr>
	     
	     <tr>
	     	<th>10주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week10}</td>
	     </tr>
	     
	     <tr>
	     	<th>11주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week11}</td>
	     </tr>
	     
	     <tr>
	     	<th>12주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week12}</td>
	     </tr>
	     
	     <tr>
	     	<th>13주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week12}</td>
	     </tr>
	     
	     <tr>
	     	<th>14주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week14}</td>
	     </tr>
	     
	     <tr>
	     	<th>15주차</th>
	     	<td colspan="3">${lctre_SearchVO.la_Week15}</td>
	     </tr>

	     
	     
	 </table>
	 <input type="button" class="def-btn btn-md btn-color"  value="목록" onclick="history.go(-1)"><br />
	 
</td></tr></table>
	 </form>
<br/><br/><br/>
</body>
</html>
