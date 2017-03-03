<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<table class="non-border margin-auto">
	<tr><td>
<h2>개설강의 상세검색</h2>
<form name="formm" method="get"><!--  action="requestLctre" > -->
<table class="def-table-auto tb-border table-hover">
<tr><th colspan="4">개설 강의 정보</th></tr>
	<tr>
		<th>개설년도/학기</th>
		<td><fmt:formatDate value="${now}" pattern="yyyy"/>년도&nbsp;${hack}학기
		</td>
		<th>개설학과전공</th>
		<td><input type="text" class="def-input-text-md custom-form-control" name="sit_Subjct" readonly>
		<!-- <input type="hidden" name="lc_Lctre_Code"> -->
		</td> <!-- 여기서 강의고유코드 정보로 lc_Lctre_Code 가져오고 싶음 -->
	 </tr>
	 
	 <tr>
	 	<th>교과목명</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control" name="lu_Lctre_Nm" readonly>&nbsp;<input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchLctre()"><i class="glyphicon glyphicon-search"></i>&nbsp;검색</button></td>
	 	<th>강의번호</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control" name="lc_Lctre_Code" readonly></td>
	 </tr>
	 
	 <tr>
	 	<th>구분</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control" name="lu_Compl_Se" readonly>&nbsp;&nbsp;
	 		<label><input type="radio" class="" name="knd_Lctre_Knd" value="일반" checked="checked">일반</label>&nbsp;&nbsp;
	 		<label><input type="radio" class="" name="knd_Lctre_Knd" value="사이버">사이버</label>
	 		</td>
	 	<th>이수학점</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control" name="lu_Pnt" readonly></td>
	 </tr>
	 <tr>
	 	<th>학년</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control" name="lu_Grade" readonly> 학년</td>
	 	
	 	<th>선행과목</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control" name="lu_Presubjct" readonly></td>
	 </tr>
	 
	 <tr><th colspan="4">담당 교수 정보</th></tr>
	 <tr>
	<%-- <c:forEach items="${profsrVO}" var="profsr"> --%>
	 	<th>교수이름</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control" value="${profsrVO.pr_Nm}" readonly>
	 	<input type="hidden" name="lc_Profsr_No" value="${profsrVO.pr_Profsr_No}"></td>   
	 	
	 	<th>담당교수전화</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control" value="${profsrVO.pr_Profsr_Tlphon_No}" readonly>
	 	</td>
	 	
	 	
	 </tr>
	 
	  <tr>
	 	<th>교수 이메일 주소</th>
	 	<td><input type="text" class="def-input-text-lg custom-form-control" value="${profsrVO.pr_Email}" readonly></td>
	 	
	 	<th></th>
	 	<td></td>
	 	<%-- </c:forEach> --%>
	 </tr>
	 

	<tr><th colspan="4">강의 상세 정보</th></tr>
	
	 <tr>
	 	<th>주간 강의 요일</th>
	 	<td><input type="text" class="def-input-text-sm custom-form-control" name="lc_Wik_Lctre_Dayweek"></td>
	 	<th>강의시간</th>
	 	<td><input type="text" class="def-input-text-md custom-form-control" name="lc_Lctre_Time"></td>
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
	     	<td><input type="text" class="def-input-text-sm custom-form-control"  name="la_Midex"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"  name="la_Fnex"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"  name="la_Indvdl_Task"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"  name="la_Team_Task"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"  name="la_Presnatn"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"  name="la_Atend"></td>
	     	<td><input type="text" class="def-input-text-sm custom-form-control"  name="la_Attd"></td>
	     </tr>
	      </table>
	      
	      
	      </td>
	      </tr>
	     
	     <tr>
	     	<th>강의 진행 형태</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control"  name="la_Lctre_Progrs_Form"> </td>
	     </tr>
	     
	     <tr>
	     	<th>강의 목표</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control"  name="la_Lctre_Goal"> </td>
	     </tr>
	     
	     <tr>
	     	<th>주교재</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control"  name="la_Main_Txtbook"> </td>
	     </tr>
	     
	     <tr>
	     	<th>부교재</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control"  name="la_Sub_Txtbook"> </td>
	     </tr>
	     
	     <tr>
	     	<th colspan="8">강의 내용 및 학습 내용</th>
	     </tr>
	     
	     <tr>
	     	<th>1주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control"  name="la_Week1"></td>
	     </tr>
	     
	     <tr>
	     	<th>2주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week2"></td>
	     </tr>
	     
	     <tr>
	     	<th>3주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week3"></td>
	     </tr>
	     
	     <tr>
	     	<th>4주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week4"></td>
	     </tr>
	     
	     <tr>
	     	<th>5주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week5"></td>
	     </tr>
	     
	     <tr>
	     	<th>6주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week6"></td>
	     </tr>
	     
	     <tr>
	     	<th>7주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week7"></td>
	     </tr>
	     
	     <tr>
	     	<th>8주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week8"></td>
	     </tr>
	     
	     <tr>
	     	<th>9주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week9"></td>
	     </tr>
	     
	     <tr>
	     	<th>10주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week10"></td>
	     </tr>
	     
	     <tr>
	     	<th>11주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week11"></td>
	     </tr>
	     
	     <tr>
	     	<th>12주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week12"></td>
	     </tr>
	     
	     <tr>
	     	<th>13주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week13"></td>
	     </tr>
	     
	     <tr>
	     	<th>14주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week14"></td>
	     </tr>
	     
	     <tr>
	     	<th>15주차</th>
	     	<td colspan="3"><input type="text" class="def-input-text-full custom-form-control" name="la_Week15"></td>
	     </tr>

	 </table>
	 <input type="button" class="def-btn btn-md btn-color" value="상세검색" onClick="go_search_detail(this.form)"/>
<input type="button" class="def-btn btn-md btn-color" id="courseDetailBtn" value="닫기" onClick="disp()"/><br />
	 
	 </form>
</td></tr></table>
