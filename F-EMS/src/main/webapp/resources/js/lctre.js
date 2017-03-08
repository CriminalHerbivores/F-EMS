/**
 * <pre>
 * 강의와 관련된 함수를 모아둔 JavaScript
 * </pre>
 * @author KJH
 * @since 2017. 03. 01
 * @version 1.0
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.03.01      KJH        최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

/* 수강 신청 */
function add_reqst(form){
	document.formm.submit();
}

function submitForm(form){
	document.forrm.submit();
}

/*개설강의 상세검색 하기*/
function go_search_detail(form){
	//document.frm.action = "product";
	document.formm.submit();
}

function profsrExcel(form){
	var pr_Profsr_No = $("#Profsr_No").val()
	$("#Profsr_No").val();
	location.href="LctreExcel?pr_Profsr_No="
		+pr_Profsr_No;
}
