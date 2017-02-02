function go_sklstfUpdate(url) {
	/*document.frm.action = "<%=request.getContextPath() %>/sklstf/sklstfUpdate";*/
	var stf_Pw = document.frm.stf_Pw.value;
	var stf_Pw_on = document.frm.stf_Pw_on.value;
	alert(stf_Pw_on);
	if(stf_Pw == stf_Pw_on){
		/*document.frm.action = url+"/sklstf/sklstfUpdate";*/
		document.frm.submit();
	}
}