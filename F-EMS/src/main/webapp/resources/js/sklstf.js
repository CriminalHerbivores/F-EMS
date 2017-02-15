function go_sklstfUpdate() {
	var st_Pw = document.frm.st_Pw.value;
	var st_Pw_on = document.frm.st_Pw_on.value;
	if(st_Pw == st_Pw_on){
		document.frm.submit();
	}
}