/* formm 아이디의 폼을 post 방식으로 전송 */
function submitForm(form){
	document.formm.submit();
}

function submitNotice(form){

	var title = $('#title').val().trim();
	var content = $('#content').val().trim();
		if(title=="" || title==null){
			sweetAlert("Oops...", "제목을 입력해 주세요", "error");
			/*alert("제목을 입력해 주세요");*/
			$('#title').focus();
			return;
		}
		
		$('#title').focus();
		if(content==""|| content ==null){
			sweetAlert("Oops...", "내용을 입력해 주세요", "error");
			/*alert("내용을 입력해 주세요");*/
			$('#content').focus();
			return;
		}
	document.formm.submit();
}

function submitGen(form){

	var title = $('#title').val().trim();
	var content = $('#content').val().trim();
		if(title=="" || title==null){
			sweetAlert("Oops...", "제목을 입력해 주세요", "error");
			/*alert("제목을 입력해 주세요");*/
			$('#title').focus();
			return;
		}
		
		$('#title').focus();
		if(content==""|| content ==null){
			sweetAlert("Oops...", "내용을 입력해 주세요", "error");
			/*alert("내용을 입력해 주세요");*/
			$('#content').focus();
			return;
		}
	document.formm.submit();
}

/* 메인페이지 주소 반환 */
function mainpage(){
	var main = location.pathname.split('/');
	var home = location.protocol+"//"+location.host + "/"+main[1]+"/";
	return home;
}

/* 인덱스로 돌아가기 */
function go_home(){
	location.href=mainpage();
}

/* femsModal 아이디의 모달을 여닫음  */
function modalToggle(){
	$('#femsModal').modal('toggle');
}

/* 안보이게 감춰 둔 클래스를 클릭 시마다 보이게/안 보이게 만듦 */
function disp(){
	$('.non-disp').toggle();
}

/*
1. 검색으로 입력받을 컬럼 값을 key란 이름의 input 태그에 넣어줌
2. 값을 입력 받는 곳에 value란 이름의 input 태그를 넣어줌
3. 폼 이름은 searchForm으로 맞추고, 버튼에 searchMe(form)을 넣어줌

<input type="hidden" name="key" value="검색할 컬럼값"/>
<input type="text" name="value"/> 검색어를 입력받을 폼
<input type="button" value="검색" onclick="searchMe(this.form)"/> 검색버튼

4. 컨트롤러에 넘어가는 값
	컬럼값=입력값
 */
function searchMe(form){
	var pro = location.protocol+"//"; // http:
	var host = location.host; // localhost:8181
	var path = location.pathname; // /fems/tt/tuitionList
	var param = location.search.substring(1); // ?key=123&value=test
	
	var list = param.split('&');
	
	var params = "?";
	
	list.forEach(function(v,i){
		if(v!="" && v.indexOf(document.searchForm.key.value+"=")==-1){
			params += v +"&";
		}
	});
	
	params += document.searchForm.key.value 
		+"="+ document.searchForm.value.value;
	var url = pro+host+path+params;
	
	location.href=url;
}

/*
1. 검색으로 입력받을 컬럼 값을 key란 이름의 input 태그에 넣어줌
2. 값을 입력 받는 곳에 value란 이름의 input 태그를 넣어줌
3. 폼 이름은 searchForm으로 맞추고, 버튼에 searchMe(form)을 넣어줌

<input type="hidden" name="key" value="검색할 컬럼값"/>
<input type="text" name="value"/> 검색어를 입력받을 폼
<input type="button" value="검색" onclick="searchMe(this.form)"/> 검색버튼

4. 컨트롤러에 넘어가는 값
	key=키값&value=입력값
 */
/*
function searchKey(form){
	var pro = location.protocol+"//"; // http:
	var host = location.host; // localhost:8181
	var path = location.pathname; // /fems/tt/tuitionList
	var param = location.search.substring(1); // ?key=123&value=test
	
	var list = param.split('&');
	
	var params = "?";
	
	list.forEach(function(v,i){
		if(v!="" && v.indexOf("key=")==-1 && v.indexOf("value=")==-1){
			params += v +"&";
		}
	});
	
	params += "key="+document.searchForm.key.value
		+"&value="+ document.searchForm.value.value;
	var url = pro+host+path+params;
	
	location.href=url;
}
*/

/* 
	<전체선택 체크박스사용법> - 자동실행 
	전체선택 부분 : <tr><th><input type="checkbox" id="check_all_1" class="input_check" />전체선택</th></tr>
	개별선택 부분 : <tr><td class="select_ckbox_1"><input type="checkbox" class="input_check" /></td></tr>
	
	값 넘기는 것 포함 참고 : deleteCourseInterest (<-선택값 삭제 컨트롤러...Intrst_ListController), course_registration/courseInterest.jsp 
 */

$(document).ready(function(){
	$("#check_all_1").click(function(){
		var chk = $(this).is(":checked");//.attr('checked');
		if(chk) $(".select_ckbox_1 input").prop('checked', true);
		else  $(".select_ckbox_1 input").prop('checked', false);
	});
	$("#check_all_2").click(function(){
		var chk = $(this).is(":checked");//.attr('checked');
		if(chk) $(".select_ckbox_2 input").prop('checked', true);
		else  $(".select_ckbox_2 input").prop('checked', false);
	});
	$("#check_all_3").click(function(){ // 하나 체크로 1,2 모두 체크하게 할 경우
		var chk = $(this).is(":checked");//.attr('checked');
		if(chk) {
		$(".select_ckbox_1 input").prop('checked', true);
		$(".select_ckbox_2 input").prop('checked', true);
		$("#check_all_1").prop('checked', true);
		$("#check_all_2").prop('checked', true);
		}
		else  {
			$(".select_ckbox_1 input").prop('checked', false);
			$(".select_ckbox_2 input").prop('checked', false);
			$("#check_all_1").prop('checked', false);
			$("#check_all_2").prop('checked', false);
		}
	});
	
	$("#check_all_5").click(function(){
		var chk = $(this).not(":disabled").is(":checked");//.attr('checked');
		if(chk) $(".select_ckbox_5 input").prop('checked', true);
		else  $(".select_ckbox_5 input").prop('checked', false);
	});
	
	$("#check_all_6").click(function(){
		var chk = $(this).is(":checked");//.attr('checked');
		if(chk) $(".select_ckbox_6 input").prop('checked', true);
		else  $(".select_ckbox_6 input").prop('checked', false);
	});
	//---------------------------------------------	
	
	/* 나중에 시간나는대로 이걸로 고치기->> script for in */
/*	   var array = ['0', '1', '2', '3','4','5','6','7','8','9','10'];
	
	 for(var i in array){
	     // alert(array[i]);
	
	
	$("#ck_all_[i]").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_[i] input").prop('checked', true);
		else  $(".slt_ckbox_[i] input").prop('checked', false);
	});

	 }*/
	
	
	$("#ck_all_0").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_0 input").prop('checked', true);
		else  $(".slt_ckbox_0 input").prop('checked', false);
	});
	
	$("#ck_all_1").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_1 input").prop('checked', true);
		else  $(".slt_ckbox_1 input").prop('checked', false);
	});
	
	$("#ck_all_2").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_2 input").prop('checked', true);
		else  $(".slt_ckbox_2 input").prop('checked', false);
	});
	
	$("#ck_all_3").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_3 input").prop('checked', true);
		else  $(".slt_ckbox_3 input").prop('checked', false);
	});
	
	$("#ck_all_4").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_4 input").prop('checked', true);
		else  $(".slt_ckbox_4 input").prop('checked', false);
	});
	
	$("#ck_all_5").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_5 input").prop('checked', true);
		else  $(".slt_ckbox_5 input").prop('checked', false);
	});

	$("#ck_all_6").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_6 input").prop('checked', true);
		else  $(".slt_ckbox_6 input").prop('checked', false);
	});
	
	$("#ck_all_7").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_7 input").prop('checked', true);
		else  $(".slt_ckbox_7 input").prop('checked', false);
	});
	
	$("#ck_all_8").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_8 input").prop('checked', true);
		else  $(".slt_ckbox_8 input").prop('checked', false);
	});
	
	$("#ck_all_9").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ckbox_9 input").prop('checked', true);
		else  $(".slt_ckbox_9 input").prop('checked', false);
	});

//---------------------------------------------
	$("#all_ckeck_1").click(function(){
		var chk = $(this).is(":checked");//.attr('checked');
		if(chk) $(".select_ck_1 input").prop('checked', true);
		else  $(".select_ck_1 input").prop('checked', false);
	});
	$("#all_ckeck_2").click(function(){
		var chk = $(this).is(":checked");//.attr('checked');
		if(chk) $(".select_ck_2 input").prop('checked', true);
		else  $(".select_ck_2 input").prop('checked', false);
	});
	$("#all_ckeck_3").click(function(){ // 하나 체크로 1,2 모두 체크하게 할 경우
		var chk = $(this).is(":checked");//.attr('checked');
		if(chk) {
		$(".select_ck_1 input").prop('checked', true);
		$(".select_ck_2 input").prop('checked', true);
		$("#all_ckeck_1").prop('checked', true);
		$("#all_ckeck_2").prop('checked', true);
		}
		else  {
			$(".select_ck_1 input").prop('checked', false);
			$(".select_ck_2 input").prop('checked', false);
			$("#all_ckeck_1").prop('checked', false);
			$("#all_ckeck_2").prop('checked', false);
		}
	});
//---------------------------------------------
	
	$("#all_ck_0").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_0 input").prop('checked', true);
		else  $(".slt_ck_0 input").prop('checked', false);
	});
	
	$("#all_ck_1").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_1 input").prop('checked', true);
		else  $(".slt_ck_1 input").prop('checked', false);
	});
	
	$("#all_ck_2").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_2 input").prop('checked', true);
		else  $(".slt_ck_2 input").prop('checked', false);
	});
	
	$("#all_ck_3").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_3 input").prop('checked', true);
		else  $(".slt_ck_3 input").prop('checked', false);
	});
	
	$("#all_ck_4").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_4 input").prop('checked', true);
		else  $(".slt_ck_4 input").prop('checked', false);
	});
	
	$("#all_ck_5").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_5 input").prop('checked', true);
		else  $(".slt_ck_5 input").prop('checked', false);
	});

	$("#all_ck_6").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_6 input").prop('checked', true);
		else  $(".slt_ck_6 input").prop('checked', false);
	});
	
	$("#all_ck_7").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_7 input").prop('checked', true);
		else  $(".slt_ck_7 input").prop('checked', false);
	});
	
	$("#all_ck_8").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_8 input").prop('checked', true);
		else  $(".slt_ck_8 input").prop('checked', false);
	});
	
	$("#all_ck_9").click(function(){
		var chk = $(this).is(":checked");
		if(chk) $(".slt_ck_9 input").prop('checked', true);
		else  $(".slt_ck_9 input").prop('checked', false);
	});
//---------------------------------------------	
	
});	// close ready




/*학과 검색*/
function searchSubjct() {
	var url = mainpage()+"/findSubjct/";
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
}
/*우편번호 검색*/
function searchZipNum() {
	var url = mainpage()+"/findZipNum/";
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
}
/*강의 검색*/
function searchLctre() {
	var url = mainpage()+"/findLctre/";
	window.open(url,"_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
}



//---------------------------------------------------------------------------------------------

// 관리자 -> 직원 or 관리자 등록 시 유효성
function submit_sklstf(form){
	var temp = true;
if(temp){
/* 	
// id검사 버튼 위에서 안 눌렀을 때를 위한 유효성 검사
	var stf_Sklstf_No = document.formm.stf_Sklstf_No.value;
	var stfNo_ck = /^[0-9]{9}$/;		//영소문자로 시작, 영소문, 영대문, 숫자로 8~20글자 사이
	
	if(stfNo_ck.test(stf_Sklstf_No)==false){
		alert("직원번호는 9글자 숫자로 가능");
} */
	
//주민등록번호 검증
var jm_no = document.formm.stf_Ihidnum.value.trim();		
var jm_no_ck = /^[0-9]{13}$/;
if(jm_no==null || jm_no==""){
	sweetAlert(" ","주민등록번호를 입력해 주세요.", "error");
	return;
}else if(jm_no_ck.test(jm_no)==false || jm_no.length!=13){	
	sweetAlert(" ","주민등록번호는 숫자(13자리)로만 입력해 주세요.", "error");
	return;
}
// 학과 선택
if(document.formm.sit_Subjct.value.trim()==""){
	sweetAlert(" ","학과를 등록해 주세요.", "error");
	return;
}
/* // 패스워드1 유효성 검증
var pwd1 = document.formm.stf_Pw.value;	
var pwdck = /^[a-zA-Z0-9!~@#$%^&*_+|\=.,;?:`-]{8,20}$/;		//영소문, 영대문, 숫자, 특수문자로 8~20글자 사이
if(pwdck.test(pwd1)==false){
	alert("비밀번호는  영소문자, 영대문자, 숫자, 특수문자 8~20글자로 이루어지도록 입력");
}
// 패스워드1, 2 일치 확인
var pwd2 = document.formm.stf_Pw_ck.value;		
if(pwd1 != pwd2){
	alert("패스워드가 일치하지 않습니다.");
} */
// 이름 유효성 검증
var irum = document.formm.stf_Nm.value.trim();		
var irumck = /^[가-힇]{2,5}$/;		// 한글 2~5자
if(irum==""){
	sweetAlert(" ","한글 이름을 입력해 주세요", "error");
	return;
}else if(irumck.test(irum)==false){	
	sweetAlert(" ","한글 이름을 한글 2~5자로 입력해 주세요.", "error");
	return;
}
//영문이름 유효성 검증
var en_irum = document.formm.stf_Eng_Nm.value.trim();		
var en_irumck = /^[a-zA-Z]{2,30}$/;		// 영어 2~30자
if(en_irum==""){
	sweetAlert(" ","영문 이름을 입력해 주세요", "error");
	return;
}else if(en_irumck.test(en_irum)==false){	
	sweetAlert(" ","영문 이름을 영문 2~30자로 입력해 주세요.", "error");
	return;
}
// 이메일 유효성 검증
var email = document.formm.stf_Email.value.trim();		
var emailck = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9--]+(\.[a-zA-Z0-9]+){1,2}$/;		// 이메일 형식에 맞게
if(email==""){
	sweetAlert(" ","이메일을 입력해 주세요.", "error");
	return;
}else if(emailck.test(email)==false){
	sweetAlert(" ","이메일 양식에 맞게 입력해 주세요.\n 예) example@gmail.com ", "error");
	return;
}
//우편번호
if(document.formm.stf_Post_No.value.trim()==""){
	sweetAlert(" ","우편번호를 입력해 주세요.", "error");
	return;
}
//나머지 주소 입력
if(document.formm.stf_Adres2.value==""){
	sweetAlert(" ","상세주소를 입력해 주세요.", "error");
	return;
}
//휴대폰 번호 유효성 검증
var mobile1 = document.formm.stf_Moblphon_No.value.trim();		
var mobileck1 = /^(01[16789][1-9][0-9]{6,7})|(010[1-9][0-9]{7})$/;		// 숫자만...010은 뒤에 숫자 8개 와야함
console.log(mobile1);
if(mobile1==""||mobile1==null){
	sweetAlert(" ","휴대폰 번호를 입력해 주세요.", "error");
	return;
}else if(mobileck1.test(mobile1)==false){
	sweetAlert(" ","휴대폰 번호를 숫자(11자리)로 입력해 주세요.", "error");
	return;
}
//집 번호 유효성 검증
var mobile3 = document.formm.stf_House_Tlphon_No.value.trim();		
var mobileck3 = /^(0[1-9][0-9]{6,9})$/;
if(mobile3==""){
	sweetAlert(" ","집 전화번호를 입력해 주세요", "error");
	return;
}else if(mobileck3.test(mobile3)==false){
	sweetAlert(" ","집 전화번호를 양식에 맞게 숫자(8~11자리)로 입력해 주세요", "error");
	return;
}
//직원 전화번호 유효성 검증
var mobile2 = document.formm.stf_Sklstf_Tlphon_No.value.trim();		
var mobileck2 = /^(0[1-9][0-9]{6,9})$/;
if(mobile2==""||mobile2==null){
	sweetAlert(" ","직원 번호를 입력해 주세요.", "error");
	return;
}else if(mobileck2.test(mobile2)==false){
	sweetAlert(" ","직원 번호를 양식에 맞게 숫자(8~11자리)로 입력해 주세요", "error");
	return;
}

document.formm.submit();

}

}
/*---------------------------------------------------------------------------------*/
//직원 -> 학생 등록시 유효성
function submit_stdnt(form){
	var temp = true;
if(temp){
/* 	
// id검사 버튼 위에서 안 눌렀을 때를 위한 유효성 검사
	var stf_Sklstf_No = document.formm.stf_Sklstf_No.value;
	var stfNo_ck = /^[0-9]{9}$/;		//영소문자로 시작, 영소문, 영대문, 숫자로 8~20글자 사이
	
	if(stfNo_ck.test(stf_Sklstf_No)==false){
		alert("직원번호는 9글자 숫자로 가능");
} */
	
//주민등록번호 검증
var jm_no = document.formm.st_Ihidnum.value.trim();		
var jm_no_ck = /^[0-9]{13}$/;
if(jm_no==null || jm_no==""){
	sweetAlert(" ","주민등록번호를 입력해 주세요.", "error");
	return;
}else if(jm_no_ck.test(jm_no)==false || jm_no.length!=13){	
	sweetAlert(" ","주민등록번호는 숫자(13자리)로만 입력해 주세요.", "error");
	return;
}
// 학과 선택
if(document.formm.sit_Subjct.value.trim()==""){
	sweetAlert(" ","학과를 등록해 주세요.", "error");
	return;
}
/* // 패스워드1 유효성 검증
var pwd1 = document.formm.stf_Pw.value;	
var pwdck = /^[a-zA-Z0-9!~@#$%^&*_+|\=.,;?:`-]{8,20}$/;		//영소문, 영대문, 숫자, 특수문자로 8~20글자 사이
if(pwdck.test(pwd1)==false){
	alert("비밀번호는  영소문자, 영대문자, 숫자, 특수문자 8~20글자로 이루어지도록 입력");
}
// 패스워드1, 2 일치 확인
var pwd2 = document.formm.stf_Pw_ck.value;		
if(pwd1 != pwd2){
	alert("패스워드가 일치하지 않습니다.");
} */
// 이름 유효성 검증
var irum = document.formm.st_Nm.value.trim();		
var irumck = /^[가-힇]{2,5}$/;		// 한글 2~5자
if(irum==""){
	sweetAlert(" ","한글 이름을 입력해 주세요", "error");
	return;
}else if(irumck.test(irum)==false){	
	sweetAlert(" ","한글 이름을 한글 2~5자로 입력해 주세요.", "error");
	return;
}
//영문이름 유효성 검증
var en_irum = document.formm.st_Eng_Nm.value.trim();		
var en_irumck = /^[a-zA-Z]{2,30}$/;		// 영어 2~30자
if(en_irum==""){
	sweetAlert(" ","영문 이름을 입력해 주세요", "error");
	return;
}else if(en_irumck.test(en_irum)==false){	
	sweetAlert(" ","영문 이름을 영문 2~30자로 입력해 주세요.", "error");
	return;
}
// 이메일 유효성 검증
var email = document.formm.st_Email.value.trim();		
var emailck = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9--]+(\.[a-zA-Z0-9]+){1,2}$/;		// 이메일 형식에 맞게
if(email==""){
	sweetAlert(" ","이메일을 입력해 주세요.", "error");
	return;
}else if(emailck.test(email)==false){
	sweetAlert(" ","이메일 양식에 맞게 입력해 주세요.\n 예) example@gmail.com ", "error");
	return;
}
//우편번호
if(document.formm.st_Post_No.value.trim()==""){
	sweetAlert(" ","우편번호를 입력해 주세요.", "error");
	return;
}
//나머지 주소 입력
if(document.formm.st_Adres2.value==""){
	sweetAlert(" ","상세주소를 입력해 주세요.", "error");
	return;
}
//휴대폰 번호 유효성 검증
var mobile1 = document.formm.st_Moblphon_No.value.trim();		
var mobileck1 = /^(01[16789][1-9][0-9]{6,7})|(010[1-9][0-9]{7})$/;		// 숫자만...010은 뒤에 숫자 8개 와야함
console.log(mobile1);
if(mobile1==""||mobile1==null){
	sweetAlert(" ","휴대폰 번호를 입력해 주세요.", "error");
	return;
}else if(mobileck1.test(mobile1)==false){
	sweetAlert(" ","휴대폰 번호를 숫자(11자리)로 입력해 주세요.", "error");
	return;
}
//집 번호 유효성 검증
var mobile3 = document.formm.st_House_Tlphon_No.value.trim();		
var mobileck3 = /^(0[1-9][0-9]{6,9})$/;
if(mobile3==""){
	sweetAlert(" ","집 전화번호를 입력해 주세요", "error");
	return;
}else if(mobileck3.test(mobile3)==false){
	sweetAlert(" ","집 전화번호를 양식에 맞게 숫자(8~11자리)로 입력해 주세요", "error");
	return;
}

//보호자 이름 유효성 검증
var protector = document.formm.st_Prtctor_Nm.value.trim();
var protectorck = /^[a-zA-Z가-힇]{2,15}$/;
if(protector==""||protector==null){
	sweetAlert(" ","보호자 이름을 입력해 주세요.", "error");
	return
}else if(protectorck.test(protector)==false){
	sweetAlert(" ","보호자 이름을 영어 또는 한글(2~15자리)로 입력해 주세요.", "error");
	return
}
//가족관계 유효성 검증
var family = document.formm.st_Family_Relate.value.trim();
if(family==""||family==null){
	sweetAlert(" ","가족관계를 입력해 주세요.", "error");
	return
}

document.formm.submit();

}
}

/*---------------------------------------------------------------------------------*/
//직원 -> 교수 등록시 유효성
function submit_profsr(form){
	var temp = true;
if(temp){
/* 	
//id검사 버튼 위에서 안 눌렀을 때를 위한 유효성 검사
	var stf_Sklstf_No = document.formm.stf_Sklstf_No.value;
	var stfNo_ck = /^[0-9]{9}$/;		//영소문자로 시작, 영소문, 영대문, 숫자로 8~20글자 사이
	
	if(stfNo_ck.test(stf_Sklstf_No)==false){
		alert("직원번호는 9글자 숫자로 가능");
} */
	
//주민등록번호 검증
var jm_no = document.formm.pr_Ihidnum.value.trim();		
var jm_no_ck = /^[0-9]{13}$/;
if(jm_no==null || jm_no==""){
	sweetAlert(" ","주민등록번호를 입력해 주세요.", "error");
	return;
}else if(jm_no_ck.test(jm_no)==false || jm_no.length!=13){	
	sweetAlert(" ","주민등록번호는 숫자(13자리)로만 입력해 주세요.", "error");
	return;
}
//학과 선택
if(document.formm.sit_Subjct.value.trim()==""){
	sweetAlert(" ","학과를 등록해 주세요.", "error");
	return;
}
/* // 패스워드1 유효성 검증
var pwd1 = document.formm.stf_Pw.value;	
var pwdck = /^[a-zA-Z0-9!~@#$%^&*_+|\=.,;?:`-]{8,20}$/;		//영소문, 영대문, 숫자, 특수문자로 8~20글자 사이
if(pwdck.test(pwd1)==false){
	alert("비밀번호는  영소문자, 영대문자, 숫자, 특수문자 8~20글자로 이루어지도록 입력");
}
//패스워드1, 2 일치 확인
var pwd2 = document.formm.stf_Pw_ck.value;		
if(pwd1 != pwd2){
	alert("패스워드가 일치하지 않습니다.");
} */
//이름 유효성 검증
var irum = document.formm.pr_Nm.value.trim();		
var irumck = /^[가-힇]{2,5}$/;		// 한글 2~5자
if(irum==""){
	sweetAlert(" ","한글 이름을 입력해 주세요", "error");
	return;
}else if(irumck.test(irum)==false){	
	sweetAlert(" ","한글 이름을 한글 2~5자로 입력해 주세요.", "error");
	return;
}
//영문이름 유효성 검증
var en_irum = document.formm.pr_Eng_Nm.value.trim();		
var en_irumck = /^[a-zA-Z]{2,30}$/;		// 영어 2~30자
if(en_irum==""){
	sweetAlert(" ","영문 이름을 입력해 주세요", "error");
	return;
}else if(en_irumck.test(en_irum)==false){	
	sweetAlert(" ","영문 이름을 영문 2~30자로 입력해 주세요.", "error");
	return;
}
//이메일 유효성 검증
var email = document.formm.pr_Email.value.trim();		
var emailck = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9--]+(\.[a-zA-Z0-9]+){1,2}$/;		// 이메일 형식에 맞게
if(email==""){
	sweetAlert(" ","이메일을 입력해 주세요.", "error");
	return;
}else if(emailck.test(email)==false){
	sweetAlert(" ","이메일 양식에 맞게 입력해 주세요.\n 예) example@gmail.com ", "error");
	return;
}
//우편번호
if(document.formm.pr_Post_No.value.trim()==""){
	sweetAlert(" ","우편번호를 입력해 주세요.", "error");
	return;
}
//나머지 주소 입력
if(document.formm.pr_Adres2.value==""){
	sweetAlert(" ","상세주소를 입력해 주세요.", "error");
	return;
}
//휴대폰 번호 유효성 검증
var mobile1 = document.formm.pr_Moblphon_No.value.trim();		
var mobileck1 = /^(01[16789][1-9][0-9]{6,7})|(010[1-9][0-9]{7})$/;		// 숫자만...010은 뒤에 숫자 8개 와야함
console.log(mobile1);
if(mobile1==""||mobile1==null){
	sweetAlert(" ","휴대폰 번호를 입력해 주세요.", "error");
	return;
}else if(mobileck1.test(mobile1)==false){
	sweetAlert(" ","휴대폰 번호를 숫자(11자리)로 입력해 주세요.", "error");
	return;
}
//집 번호 유효성 검증
var mobile3 = document.formm.pr_House_Tlphon_No.value.trim();		
var mobileck3 = /^(0[1-9][0-9]{6,9})$/;
if(mobile3==""){
	sweetAlert(" ","집 전화번호를 입력해 주세요", "error");
	return;
}else if(mobileck3.test(mobile3)==false){
	sweetAlert(" ","집 전화번호를 양식에 맞게 숫자(8~11자리)로 입력해 주세요", "error");
	return;
}
//교수 전화번호 유효성 검증
var mobile2 = document.formm.pr_Profsr_Tlphon_No.value.trim();		
var mobileck2 = /^(0[1-9][0-9]{6,9})$/;
if(mobile2==""||mobile2==null){
	sweetAlert(" ","교수 번호를 입력해 주세요.", "error");
	return;
}else if(mobileck2.test(mobile2)==false){
	sweetAlert(" ","교수 번호를 양식에 맞게 숫자(8~11자리)로 입력해 주세요", "error");
	return;
}


document.formm.submit();

}
}

function submit_test(form){
	
	function queExist(){
		var ques = document.getElementsByName("ques");
		if(ques.length==0||ques.length==null){
			return true;
		}else{
			return false;
		}
	}
	var tpNm = $('#tpNm').val().trim(); // 시험명
	var Start_Dt=$('#Start_Dt').val().trim();//시작날짜
	var Start_Dt2=$('#Start_Dt2').val().trim();//시작시간
	var End_Dt=$('#End_Dt').val().trim(); //마감날짜
	var End_Dt2=$('#End_Dt2').val().trim();//마감시간
	var cnt = 0;

	var Gque = $('#Gque').val();//객관식 문제
	var ca = $('#ca').val();
	
		if(tpNm=="" || tpNm==null){
			sweetAlert("Oops...", "시험 제목을 입력해 주세요.", "error");
			return;
		}else if(Start_Dt=="" || Start_Dt==null){
			sweetAlert("Oops...", "시험 시작 날짜를 입력해 주세요.", "error");
			return;
		}else if(Start_Dt2=="" || Start_Dt2==null){
			sweetAlert("Oops...", "시험 시작 시간을 입력해 주세요.", "error");
			return;
		}else if(End_Dt=="" || End_Dt==null){
			sweetAlert("Oops...", "시험 마감 날짜를 입력해 주세요.", "error");
			return;
		}else if(End_Dt2=="" || End_Dt2==null){
			sweetAlert("Oops...", "시험 마감 시간을 입력해 주세요.", "error");
			return;
		}else if(queExist()){
			sweetAlert("Oops...", "문제를 등록해 주세요.", "error");
			return;
		}
		
		var ques = document.getElementsByName("ques");
		for(var i=0;i<ques.length;i++){
		if(ques[i].value==null||ques[i].value==""){
			sweetAlert("Oops...", "문제를 입력해 주세요.", "error");
				return;
			}
		}
		
		var ca = document.getElementsByName("ca");
		for(var i=0;i<ca.length;i++){
			if(ca[i].value==null||ca[i].value==""){
				sweetAlert("Oops...", "정답을 입력해 주세요.", "error");
				return;
			}
		}
		
	document.formm.submit();
	
}


function update_test(form){
	
	function queExist(){
		var ques = document.getElementsByName("ques");
		if(ques.length==0||ques.length==null){
			return true;
		}else{
			return false;
		}
	}
	var tpNm = $('#tpNm').val().trim(); // 시험명
	var Start_Dt=$('#Start_Dt').val().trim();//시작날짜
	var Start_Dt2=$('#Start_Dt2').val().trim();//시작시간
	var End_Dt=$('#End_Dt').val().trim(); //마감날짜
	var End_Dt2=$('#End_Dt2').val().trim();//마감시간
	
		if(tpNm=="" || tpNm==null){
			sweetAlert("Oops...", "시험 제목을 입력해 주세요.", "error");
			return;
		}else if(Start_Dt=="" || Start_Dt==null){
			sweetAlert("Oops...", "시험 시작 날짜를 입력해 주세요.", "error");
			return;
		}else if(Start_Dt2=="" || Start_Dt2==null){
			sweetAlert("Oops...", "시험 시작 시간을 입력해 주세요.", "error");
			return;
		}else if(End_Dt=="" || End_Dt==null){
			sweetAlert("Oops...", "시험 마감 날짜를 입력해 주세요.", "error");
			return;
		}else if(End_Dt2=="" || End_Dt2==null){
			sweetAlert("Oops...", "시험 마감 시간을 입력해 주세요.", "error");
			return;
		}else if(queExist()){
			sweetAlert("Oops...", "문제를 등록해 주세요.", "error");
			return;
		}
		
		var ques = document.getElementsByName("ques");
		for(var i=0;i<ques.length;i++){
		if(ques[i].value==null||ques[i].value==""){
			sweetAlert("Oops...", "문제를 입력해 주세요.", "error");
				return;
			}
		}
		
		var ca = document.getElementsByName("ca");
		for(var i=0;i<ca.length;i++){
			if(ca[i].value==null||ca[i].value==""){
				sweetAlert("Oops...", "정답을 입력해 주세요.", "error");
				return;
			}
		}
		
		var addques = document.getElementsByName("addques");
		for(var i=0;i<addques.length;i++){
		if(addques[i].value==null||addques[i].value==""){
			sweetAlert("Oops...", "문제를 입력해 주세요.", "error");
				return;
			}
		}
		
		var addca = document.getElementsByName("addca");
		for(var i=0;i<addca.length;i++){
			if(addca[i].value==null||addca[i].value==""){
				sweetAlert("Oops...", "정답을 입력해 주세요.", "error");
				return;
			}
		}
		
	document.formm.submit();
	
}
