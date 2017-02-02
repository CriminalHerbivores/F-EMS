function go_stdntInsert(url) {
	var st_Pw = document.frm.st_Pw.value;
	var st_Pw_on = document.frm.st_Pw_on.value;
	alert(st_Pw+","+st_Pw_on);
	if(st_Pw == st_Pw_on){
		document.frm.action = url+"/stdnt/stdntInsert";
		document.frm.submit();
	}
}