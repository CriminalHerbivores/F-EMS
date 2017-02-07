function go_sklstfUpdate(url) {
	var st_Pw = document.frm.st_Pw.value;
	var st_Pw_on = document.frm.st_Pw_on.value;
	if(st_Pw == st_Pw_on){
		document.frm.action = url+"/sklstf/sklstfUpdate";
		document.frm.submit();
	}
}