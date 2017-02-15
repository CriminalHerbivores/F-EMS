/**
 * <pre>
 * 관리자 페이지에서 사용되는 JavaScript
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.03      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */ 

/*$(function(){
	   $('#admin_join_btn').click(function(){
	      id = $('#id').val().trim();
	      if(id.length ==0) {
	    	  $('#change').text("아이디 입력");
	      		return;
	      }
	      password = $('#password').val().trim();
	      if(password.length ==0) {
	    	  $('#change').text("패스워드 입력");
	      		return;
	      }
	      email = $('#email').val().trim();
	      if(email.length ==0) {
	    	  $('#change').text("이메일 입력");
	      		return;
	      }
	   })
})*/

function go_step1Add() {
	document.formm.action = "/fems/admin/step1Add";
	document.formm.submit();
}

function go_step2Add() {
	document.formm.action = "/fems/admin/step2Add";
	document.formm.submit();
}

function go_step3Add() {
	document.formm.action = "/fems/admin/step3Add";
	document.formm.submit();
}

function go_step4Add() {
	document.formm.action = "/fems/admin/step4Add";
	document.formm.submit();
}

function go_layoutPreview() {
	document.formm.action = "/fems/admin/layoutPreview";
	document.formm.submit();
}

function go_index() {
	document.formm.action = "/fems";
	document.formm.submit();
}

/* 레이아웃 변경 js */
function go_step1Modify() {
	document.formm.action = "/fems/admin/step1Modify";
	document.formm.submit();
}

function go_step2Modify() {
	document.formm.action = "/fems/admin/step2Modify";
	document.formm.submit();
}

function go_step3Modify() {
	document.formm.action = "/fems/admin/step3Modify";
	document.formm.submit();
}

function go_step4Modify() {
	document.formm.action = "/fems/admin/step4Modify";
	document.formm.submit();
}

/* 관리자 페이지 */
function go_admin_page() {
	document.formm.action = "/fems/admin/main";
	document.formm.submit();
}


