function login_admin() {
	var data = {
			'returl' : 'index',
			'userid' : 'admin',
			'password' : 'admin'
	};
	$.ajax({
		url : 'login',
		data : data,
		type : 'POST',
		dataType : 'json',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(body) {
		location.href="index";
	});
}
function login_staff() {
	var data = {
			'returl' : 'index',
			'userid' : 'staff',
			'password' : 'staff'
	};
	$.ajax({
		url : 'login',
		data : data,
		type : 'POST',
		dataType : 'json',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(body) {
		location.href="index";
	});
}
function login_professor() {
	var data = {
			'returl' : 'index',
			'userid' : '2017010001',
			'password' : '0'
	};
	$.ajax({
		url : 'login',
		data : data,
		type : 'POST',
		dataType : 'json',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(body) {
		location.href="index";
	});
}
function login_student() {
	var data = {
			'returl' : 'index',
			'userid' : '201701234',
			'password' : '0'
	};
	$.ajax({
		url : 'login',
		data : data,
		type : 'POST',
		dataType : 'json',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(body) {
		location.href="index";
	});
}
function login_baskin() {
	var data = {
			'returl' : 'baskin/robbins',
			'userid' : 'baskin',
			'password' : 'robbins'
	};
	$.ajax({
		url : 'login',
		data : data,
		type : 'POST',
		dataType : 'json',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(body) {
		location.href="index";
	});
}


function findId() {
	var idName = $('#idName').val().trim();
	var idEmail = $('#idEmail').val().trim();
	if(idName=="" || idName==null){
		swal("이름을 입력해 주세요");
		return;
	}
	if(idEmail=="" || idEmail ==null){
		swal("이메일을 입력해 주세요");
		return;
	}
	$.ajax({
		url : 'findId',
		data : $('#idformm input').serialize(),
		type : 'POST',
		dataType : 'text',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(id) {
		if(id=="" || id==null){
			swal("아이디를 찾을 수 없습니다.");
		}else{
			swal("아이디는 "+id+"입니다.");
		}
	});
}
function findPw() {
	var pwId = $('#pwId').val().trim();
	var pwName = $('#pwName').val().trim();
	var pwEmail = $('#pwEmail').val().trim();
	if(pwId=="" || pwId==null){
		swal("아이디를 입력해 주세요");
		return;
	}
	if(pwName=="" || pwName ==null){
		swal("이름을 입력해 주세요");
		return;
	}
	if(pwEmail=="" || pwEmail ==null){
		swal("이메일을 입력해 주세요");
		return;
	}
	$.ajax({
		url : 'findPw',
		data : $('#pwformm input').serialize(),
		type : 'POST',
		dataType : 'text',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
		}
	}).done(function(pw) {
		if(pw=="" || pw==null){
			swal("비밀번호를 찾을 수 없습니다.");
		}else{
			swal("임시 비밀번호를 발급하였습니다. 메일을 확인해주세요.");
		}
	});
}

