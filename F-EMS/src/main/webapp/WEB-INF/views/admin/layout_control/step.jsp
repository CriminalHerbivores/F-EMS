<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%--
 * <pre>
 * F-EMS로 대학 웹페이지를 개설할 때 대학정보를 입력하는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>

.navbar-inverse{
background-color:#fff;
border-color:#fff;
border:0;
}

</style>

</head>
<body>
<article>

<form id="step1Add" method="post" name="formm" enctype="multipart/form-data">
	<input type="hidden" name="mng_Univ_Logo_Ori" value="${manageVO.mng_Univ_Logo}">
	<input type="hidden" name="mng_Univ_Img_Ori" value="${manageVO.mng_Univ_Img}">
	<table class="def-table-full"><tr><td>
	
<h1>대학 정보 설정</h1><br/>
	<table class="def-table-full tb-border table-hover tr-child-color">
		<tr><th>대학 이름</th><td><input type="text" name="mng_Univ_Nm" class="def-input-text-lg custom-form-control" value="${manageVO.mng_Univ_Nm }"></td></tr>
		<tr><th>대학 영문 이름</th><td><input type="text" name="mng_Univ_Eng_Nm" class="def-input-text-lg custom-form-control" value="${manageVO.mng_Univ_Eng_Nm }"></td></tr>
		<tr><th>대학 로고 등록</th><td> ※ 첨부 파일 이미지 크기는 170*15px 권장 <input type="file" name="uploadlogo" value="${manageVO.mng_Univ_Logo}" ></td></tr> 
		<tr><th>우편번호</th><td><input type="text" name="mng_Post_No" id="zipNum" class="def-input-text-md custom-form-control" value="${manageVO.mng_Post_No}" ><input type="button" class="def-btn btn-search btn-color" value="검색" onclick="searchZipNum()"></td></tr>
		<tr><th>주소</th><td><input type="text" name="mng_Adres1" class="def-input-text-full custom-form-control" id="addres1" value="${manageVO.mng_Adres1}" readonly> <input type="text" name="mng_Adres2" class="def-input-text-full custom-form-control" value="${manageVO.mng_Adres2}" ></td></tr>
		<tr><th>전화번호</th><td><select name="mng_Tlphon_No" class="combobox-sm custom-form-control" value="${fn:split(manageVO.mng_Tlphon_No, '-')[0]}">
					
					<option value="${fn:split(manageVO.mng_Tlphon_No, '-')[0]}">${fn:split(manageVO.mng_Tlphon_No, '-')[0]}</option>
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="033">033</option>
					<option value="041">041</option>
					<option value="042">042</option>
					<option value="043">043</option>
					<option value="051">051</option>
					<option value="052">052</option>
					<option value="053">053</option>
					<option value="054">054</option>
					<option value="055">055</option>
					<option value="061">061</option>
					<option value="062">062</option>
					<option value="063">063</option>
					<option value="064">064</option>
					<option value="010">010</option>
					<option value="012">012</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>&nbsp; 
				- &nbsp;<input type="text" name="phoneNo1" class="def-input-text-sm custom-form-control"  value="${fn:split(manageVO.mng_Tlphon_No, '-')[1]}">&nbsp;-&nbsp;
				<input type="text" name="phoneNo2" class="def-input-text-sm custom-form-control" value="${fn:split(manageVO.mng_Tlphon_No, '-')[2]}"></td></tr>
				<tr><th>팩스번호</th>
				<td>
				<input type="text" name="faxNo1" class="def-input-text-sm custom-form-control" value="${fn:split(manageVO.mng_Fax_No, '-')[0]}">-
				<input type="text" name="faxNo2" class="def-input-text-sm custom-form-control" value="${fn:split(manageVO.mng_Fax_No, '-')[1]}">-
				<input type="text" name="faxNo3" class="def-input-text-sm custom-form-control" value="${fn:split(manageVO.mng_Fax_No, '-')[2]}">
				</td>
				</tr>	 
				<tr><th>저작권</th><td><input type="text" name="mng_Cpyr" placeholder="홈페이지 하단에 적히는 내용입니다." class="def-input-text-full custom-form-control" value="${manageVO.mng_Cpyr}"></td></tr>
			</table>
			<hr>
			<table class="def-table-full tb-border table-hover tr-child-color">
				<tr><th><label>1. Login형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="1" /></label>
				</th><th><label>2.복합형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="2" checked="checked"/></label></th></tr>
				<tr>
				<td>
						<img src="<%=request.getContextPath()%>/resources/images/layout_login.png" title="blr" id="blr" class="" />
						</td><td>
						<img src="<%=request.getContextPath()%>/resources/images/layout_multi.png" title="blr" id="blr" class="" />
						</td></tr>
				<tr><th><label>3. 게시판형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="3" /></label>
				</th><th><label>4. 메뉴 강조형 <input type="radio" id="imgCheck" name="mng_Layout_Knd" value="4" /></label></th></tr>
				<tr><td>
					<img src="<%=request.getContextPath()%>/resources/images/layout_board.png" title="blr" id="blr" class="" />
				</td><td>
					<img src="<%=request.getContextPath()%>/resources/images/layout_menu.png" title="blr" id="blr" class="" />
				</td></tr>
				<tr>
					<th>좌측메뉴 사용유무</th>
						<td>예<input type="radio" name="mng_Left_Menu_Use_Ennc" value="y" checked> &nbsp;&nbsp;
							아니오 <input type="radio" name="mng_Left_Menu_Use_Ennc" value="n">
					</td>
				</tr>
					<tr>
						<th>대학 이미지</th>
						<td><input type="file" name="uploadUnivImg" value="${manageVO.mng_Univ_Logo}" ></td>
					</tr>
					
			</table>
			<hr>
			<table class="def-table-full tb-border table-hover tr-child-color">
				<tr><th>메인 컬러</th>
									<td><input type="color" name="mng_Main_Color" value="${manageVO.mng_Main_Color}">&nbsp;&nbsp;</td>
					<th>텍스트 컬러</th>
									<td><input type="color" name="mng_Main_Txtclr" value="${manageVO.mng_Main_Txtclr}">&nbsp;&nbsp;</td></tr>
				<tr><th>보조 컬러1</th>
									<td><input type="color" name="mng_Sub_Color1" value="${manageVO.mng_Sub_Color1}">&nbsp;&nbsp;</td>
					<th>텍스트 보조1 </th>
									<td><input type="color" name="mng_Sub_Txtclr1" value="${manageVO.mng_Sub_Txtclr1}">&nbsp;&nbsp;</td></tr>
				<tr><th>보조 컬러2</th>
									<td><input type="color" name="mng_Sub_Color2" value="${manageVO.mng_Sub_Color2}">&nbsp;&nbsp;</td>
					<th>텍스트 보조2</th>
									<td><input type="color" name="mng_Sub_Txtclr2" value="${manageVO.mng_Sub_Txtclr2}">&nbsp;&nbsp;</td></tr>					
			</table>
<table class="def-table-full"><tr><td style="text-align: right;">
	<input type="submit" value="등록" class="def-btn btn-md btn-color">
</td></tr></table>	
			</td></tr></table>	
<br/><br/><br/>
</form>
</article>
</body>
</html>