function go_stdnt() {
	var st_Pw = document.formm.st_Pw.value;
	var st_Pw_on = document.formm.st_Pw_on.value;
	if(st_Pw == st_Pw_on){
		document.formm.submit();
	}else{
		sweetAlert(" ", "비밀번호가 맞지 않습니다.", "error");
	}
}
