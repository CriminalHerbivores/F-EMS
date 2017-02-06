

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

function go_step1_add() {
	document.formm.action = "/fems/admin/step1_add";
	document.formm.submit();
}

function go_step2_add() {
	document.formm.action = "/fems/admin/step2_add";
	document.formm.submit();
}

function go_step3_add() {
	document.formm.action = "/fems/admin/step3_add";
	document.formm.submit();
}

function go_step4_add() {
	document.formm.action = "/fems/admin/step4_add";
	document.formm.submit();
}

function go_layout_preview() {
	document.formm.action = "/fems/admin/layout_preview";
	document.formm.submit();
}

function go_index() {
	document.formm.action = "/fems";
	document.formm.submit();
}

/* 레이아웃 변경 js */
function go_step1_modify() {
	document.formm.action = "/fems/admin/step1_modify";
	document.formm.submit();
}

function go_step2_modify() {
	document.formm.action = "/fems/admin/step2_modify";
	document.formm.submit();
}

function go_step3_modify() {
	document.formm.action = "/fems/admin/step3_modify";
	document.formm.submit();
}

function go_step4_modify() {
	document.formm.action = "/fems/admin/step4_modify";
	document.formm.submit();
}

/* 관리자 페이지 */
function go_admin_page() {
	document.formm.action = "/fems/admin/main";
	document.formm.submit();
}


