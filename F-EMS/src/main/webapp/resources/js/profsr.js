function go_profsrInsert(url) {
	var pr_Pw = document.frm.pr_Pw.value;
	var pr_Pw_on = document.frm.pr_Pw_on.value;
	if(pr_Pw == pr_Pw_on){
		document.frm.action = url+"/profsr/profsrInsert";
		document.frm.submit();
	}
}

function go_profsrUpdate(url) {
	var pr_Pw = document.frm.pr_Pw.value;
	var pr_Pw_on = document.frm.pr_Pw_on.value;
	if(pr_Pw == pr_Pw_on){
		document.frm.action = url+"/profsr/profsrUpdate";
		document.frm.submit();
	}
}