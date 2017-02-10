

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


