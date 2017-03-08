<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
* <pre>
* 
* </pre>
* [[개정이력(Modification Information)]]
* 수정일                 수정자      수정내용
* ----------  ---------  -----------------
* 2017.03.08    KJS            최초작성               -->
* Copyright (c) 2017 by DDIT All right reserved
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>${lctre_Search.lu_Lctre_Nm } 평가서</h2><br/>
	<form name="formm" method="post">
		<input type="hidden" name="tpage" value=${tpage }>
		<input type="hidden" name="re_Stdnt_No" value=${lctre_Search.re_Stdnt_No }>
		<input type="hidden" name="re_Lctre_No" value=${lctre_Search.re_Lctre_No }>
		<input type="hidden" name="lc_Lctre_Evl_Score" value=${lctre_Search.lc_Lctre_Evl_Score }>
		<table class="def-table-full tb-border table-hover">
		<tr>
		<th style="width:600px;">설문항목</th>
		<th>A</th>
		<th>B</th>
		<th>C</th>
		<th>D</th>
		<th>E</th>
		</tr>
		<tr>
		<td class="text-left">1번 강의 진행은 체계적이었다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope1" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope1" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope1" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope1" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope1" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">2번 강의 내용이 강의 계획서대로 진행되었다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope2" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope2" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope2" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope2" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope2" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">3번 교제선택(또는 보조자료 제시)이 적절하였다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope3" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope3" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope3" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope3" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope3" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">4번 주어진 강의 시간이 충분히 활용되었다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope4" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope4" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope4" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope4" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope4" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">5번 교과목에 알맞은 교육메체가 적절히 활용되었다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope5" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope5" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope5" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope5" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope5" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">6번 수업을 위한 적절한 교육메체가 준비되었다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope6" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope6" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope6" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope6" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope6" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">7번 교육 시설과 환경이 적절하였다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope7" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope7" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope7" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope7" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope7" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">8번 강의를 위한 자료와 정보 수집이 수월하였다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope8" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope8" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope8" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope8" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope8" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">9번 나는 이 수업에 적극적으로 참여하였다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope9" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope9" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope9" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope9" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope9" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">10번 강의를 듣는 학생수가 적절하였다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope10" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope10" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope10" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope10" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope10" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">11번 나는 이 수업을 통하여 많은 지식을 얻었다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope11" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope11" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope11" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope11" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope11" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">12번 나는 이 수업을 다른 학생에게 추천하고 싶다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope12" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope12" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope12" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope12" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope12" value="1"></td>
		</tr>
		<tr>
		<td class="text-left">13번 나는 이 수업을 전체적으로 우수하다고 평가한다.</td>
		<td><input type="radio" name="re_Lctre_Evl_Scope13" value="5"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope13" value="4"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope13" value="3"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope13" value="2"></td>
		<td><input type="radio" name="re_Lctre_Evl_Scope13" value="1"></td>
		</tr>
		</table>
		<table class="def-table-full"><tr><td style="text-align: right;">
		<input type="button"  value="등록" class="def-btn btn-sm btn-color" onclick="go_submit(this.form)"/>
		</td></tr></table>
	</form>
</body>
</html>