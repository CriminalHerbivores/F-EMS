<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.21    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/bbs_gnt.js"></script>
</head>
<body>
  <h2>${bbs_List_Gnt.bl_Bbs_Nm}</h2><br/>
<form name="formm">
<table class="def-table-full"><tr><td style="text-align: left;">
  <select name="key" class="combobox-md custom-form-control">
  	<option value="bb_Sj">제목</option>
  	<option value="bb_Cn">내용</option>
  </select>
  <input type="hidden" name="bl_Bbs_No" value=${bbs_List_Gnt.bl_Bbs_No }>
  <input type="text" class="def-input-text-lg custom-form-control" name="value">
  <input type="button" class="def-btn btn-search btn-color" value="조회" onclick="submitForm(this.form);">
</td></tr></table>
 </form>
  <table class="def-table-full tb-border table-hover">
      <tr>
        <th>No</th>
        <th style="width:500px;">제목</th>
        <th>작성날짜</th>
        <th>조회수</th>
      </tr>
      
      <c:forEach var="bbs_Gnt" items="${bbs_GntList }">
      	<tr>
      		<td> ${bbs_Gnt.bb_Bbs_No}</td>
      		
      		
      		  <c:choose>
				  	<c:when test="${returnSec>='1' }">
						<td><a href="detailBbs_Gnt?bb_Bbs_No=${bbs_Gnt.bb_Bbs_No}&bl_Bbs_No=${bbs_List_Gnt.bl_Bbs_No}&bl_Bbs_Nm=${bbs_List_Gnt.bl_Bbs_Nm}&bl_Table_Nm=${bbs_List_Gnt.bl_Table_Nm}&tpage=${tpage}">
      		 					${bbs_Gnt.bb_Sj} </a>
      					</td>
					 </c:when>
					 <c:otherwise>
					 <td>${bbs_Gnt.bb_Sj}</td>
					 </c:otherwise> 
			</c:choose>
      		
      		
      		
      		<td><fmt:formatDate value="${bbs_Gnt.bb_Writng_dt}" /> </td>
      		<td> ${bbs_Gnt.bb_Rdcnt}</td> <!-- 조회수 -->
      		
      	</tr>
      </c:forEach>
      	<tr>
      		<td colspan="4" style="text-align: center;">${paging }</td>
      	</tr>
      	
     
  </table>
  	
  <c:choose>
  	<c:when test="${returnSec>='3' }">
<table class="def-table-full"><tr><td style="text-align: right;">
	  	<a href="writeBbs_Gnt?bl_Bbs_No=${bbs_List_Gnt.bl_Bbs_No}&bl_Bbs_Nm=${bbs_List_Gnt.bl_Bbs_Nm}&bl_Table_Nm=${bbs_List_Gnt.bl_Table_Nm}">
	  	<input type="button" class="def-btn btn-md btn-color" value="등록"></a>
</td></tr></table>
	 </c:when>
	 <c:otherwise>
	 </c:otherwise> 
	</c:choose>
</td></tr>  
</table>	  
</div>
</body>
</html>
