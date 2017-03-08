<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * F-EMS로 대학 웹페이지를 개설할 때 사용할 컬러 테마를 설정하는 JSP
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
<script src="https://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
    $(window).scroll(function() {
        if ($(this).scrollTop() > 500) {
            $('#MOVE_TOP_BTN').fadeIn();
        } else {
            $('#MOVE_TOP_BTN').fadeOut();
        }
    });
    
    $("#MOVE_TOP_BTN").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });
});
function colorMainFunc(main,sub1,sub2){
	$('input[name="mng_Main_Color"]').val(main);
	$('input[name="mng_Sub_Color1"]').val(sub1);
	$('input[name="mng_Sub_Color2"]').val(sub2);
	$('html, body').animate({
        scrollTop : 0
    }, 400);
    return false;
}
function colorTxtFunc(main,sub1,sub2){
	$('input[name="mng_Main_Txtclr"]').val(main);
	$('input[name="mng_Sub_Txtclr1"]').val(sub1);
	$('input[name="mng_Sub_Txtclr2"]').val(sub2);
	$('html, body').animate({
        scrollTop : 0
    }, 400);
    return false;
}
function insertMainColor(name){
	var bskn_Nm = $('input[name="mainName"]').val();
	if(bskn_Nm==""){
		swal("이름을 입력해주세요.");
		return;
	}
	var bskn_Main = $('input[name="mng_Main_Color"]').val();
	var bskn_Sub1 = $('input[name="mng_Sub_Color1"]').val();
	var bskn_Sub2 = $('input[name="mng_Sub_Color2"]').val();
	var data ={
    		'bskn_Nm' : bskn_Nm,
    		'bskn_Main' : bskn_Main,
    		'bskn_Sub1' : bskn_Sub1,
    		'bskn_Sub2' : bskn_Sub2
    		};
	$.ajax({
		url:'insertColor',
		contentType:'application/json; charset=utf-8',
		dataType:'text',
		data:JSON.stringify(data),
		type:'post',
		success : function(data){
			$('input[name="mainName"]').val("");
			swal("저장되었습니다.");
		},
		error:function(error){
	    	swal("저장에 실패했습니다.");
		}
	});
}
function insertTxtColor(main,sub1,sub2){
	var bskn_Nm = $('input[name="txtName"]').val();
	if(bskn_Nm==""){
		swal("이름을 입력해주세요.");
		return;
	}
	var bskn_Main = $('input[name="mng_Main_Txtclr"]').val();
	var bskn_Sub1 = $('input[name="mng_Sub_Txtclr1"]').val();
	var bskn_Sub2 = $('input[name="mng_Sub_Txtclr2"]').val();
	var data ={
    		'bskn_Nm' : bskn_Nm,
    		'bskn_Main' : bskn_Main,
    		'bskn_Sub1' : bskn_Sub1,
    		'bskn_Sub2' : bskn_Sub2
    		};
	$.ajax({
		url:'insertColor',
		contentType:'application/json; charset=utf-8',
		dataType:'text',
		data:JSON.stringify(data),
		type:'post',
		success : function(data){
			$('input[name="txtName"]').val("");
			swal("저장되었습니다.");
		},
		error:function(error){
	    	swal("저장에 실패했습니다.");
		}
	});
}
</script>
<style>
a#MOVE_TOP_BTN {
    position: fixed;
    right: 2%;
    bottom: 50px;
    display: none;
    z-index: 999;
}
</style>
</head>
<body>
<a id="MOVE_TOP_BTN" href="#"><input type="button" value="TOP" class="def-ckbtn btn-md ckbtn-color"></a>
	<table class="def-table-full"><tr><td>
	<table class="def-table-full tb-border table-hover tr-child-color">
		<tr>
			<td><a href="step1Add">STEP 1</a></td>
			<td><a href="step2Add">STEP 2</a></td>
			<td><a href="step3Add">STEP 3</a></td>
			<td><a href="step4Add">STEP 4</a></td>
			<td><a href="<%=request.getContextPath()%>/">INDEX</a></td>
		</tr>
	</table>
	<br/>
	<h2>컬러 테마 설정</h2>
	<br />
	<table class="def-table-full tb-border table-hover tr-child-color">
	<tr>
		<th width="200px"><input type="text" name="mainName" placeholder="이름" class="def-input-text-md custom-form-control"></th>
		<td><input type="button" value="저장" onclick="insertMainColor()" class="def-ckbtn btn-sm ckbtn-color"></td>
		<th width="200px"><input type="text" name="txtName" placeholder="이름" class="def-input-text-md custom-form-control"></th>
		<td><input type="button" value="저장" onclick="insertTxtColor()" class="def-ckbtn btn-sm ckbtn-color"></td>
	</tr>
	</table>
				<form id="step4Add" method="post" name="formm">
	<table class="def-table-full tb-border table-hover tr-child-color">
		<tr id="mainColor">
			<th width="200px">메인 컬러</th>
			<td><input type="color" name="mng_Main_Color"
				value="${manageVO.mng_Main_Color}">&nbsp;&nbsp;</td>
			<th width="200px">텍스트 컬러</th>
			<td><input type="color" name="mng_Main_Txtclr"
				value="${manageVO.mng_Main_Txtclr}">&nbsp;&nbsp;</td>
		</tr>
		<tr id="txtColor">
			<th>보조 컬러1</th>
			<td><input type="color" name="mng_Sub_Color1"
				value="${manageVO.mng_Sub_Color1}">&nbsp;&nbsp;</td>
			<th>텍스트 보조1</th>
			<td><input type="color" name="mng_Sub_Txtclr1"
				value="${manageVO.mng_Sub_Txtclr1}">&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<th>보조 컬러2</th>
			<td><input type="color" name="mng_Sub_Color2"
				value="${manageVO.mng_Sub_Color2}">&nbsp;&nbsp;</td>
			<th>텍스트 보조2</th>
			<td><input type="color" name="mng_Sub_Txtclr2"
				value="${manageVO.mng_Sub_Txtclr2}">&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="4" class="text-right">
			<input type="submit" value="수정" class="def-btn btn-sm ckbtn-color">
			</td>
		</tr>
	</table>
				</form>
	<hr>
	<table class="def-table-full tb-border">
	<tr>
		<th>테마명</th>
		<th>컬러</th>
		<th>템플릿 | 텍스트</th>
	</tr>
	<tr>
		<td>기본 컬러</td>
		<td>
		<span style="color:#063F78;background-color:#063F78;">#####</span>
		<span style="color:#326EA6;background-color:#326EA6;">#####</span>
		<span style="color:#D8E7F6;background-color:#D8E7F6;">#####</span>
		</td>
		<td>
		<input type="button" value="선택" 
		onclick="colorMainFunc('#063F78','#326EA6','#D8E7F6');" class="def-ckbtn btn-sm ckbtn-color">
		<input type="button" value="선택" 
		onclick="colorTxtFunc('#063F78','#326EA6','#D8E7F6');" class="def-ckbtn btn-sm ckbtn-color">
		</td>
	</tr>
	<tr>
		<td>기본 폰트 컬러</td>
		<td>
		<span style="color:#fafafa;background-color:#fafafa;">#####</span>
		<span style="color:#f9f9f9;background-color:#f9f9f9;">#####</span>
		<span style="color:#8a8a8a;background-color:#8a8a8a;">#####</span>
		<td>
		<input type="button" value="선택" 
		onclick="colorMainFunc('#fafafa','#f9f9f9','#8a8a8a');" class="def-ckbtn btn-sm ckbtn-color">
		<input type="button" value="선택" 
		onclick="colorTxtFunc('#fafafa','#f9f9f9','#8a8a8a');" class="def-ckbtn btn-sm ckbtn-color">
		</td>
	</tr>
	<c:forEach items="${colorList}" var="cL">
	<tr>
		<td>${cL.bskn_Nm}</td>
		<td>
		<span style="color:${cL.bskn_Main};background-color:${cL.bskn_Main};">#####</span>
		<span style="color:${cL.bskn_Sub1};background-color:${cL.bskn_Sub1};">#####</span>
		<span style="color:${cL.bskn_Sub2};background-color:${cL.bskn_Sub2};">#####</span>
		</td>
		<td>
		<input type="button" value="선택" 
		onclick="colorMainFunc('${cL.bskn_Main}','${cL.bskn_Sub1}','${cL.bskn_Sub2}');" class="def-ckbtn btn-sm ckbtn-color">
		<input type="button" value="선택" 
		onclick="colorTxtFunc('${cL.bskn_Main}','${cL.bskn_Sub1}','${cL.bskn_Sub2}');" class="def-ckbtn btn-sm ckbtn-color">
		</td>
	</tr>
	</c:forEach>
	</table>
	
	</td></tr></table>
	<br />
	<br />
	<br />
</body>
</html>