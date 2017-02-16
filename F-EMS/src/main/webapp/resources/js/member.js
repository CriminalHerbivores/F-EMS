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
			'userid' : '2017010101',
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


