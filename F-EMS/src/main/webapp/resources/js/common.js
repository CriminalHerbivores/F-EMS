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
		if(content==""|| content ==null){
			sweetAlert("Oops...", "내용을 입력해 주세요", "error");
			/*alert("내용을 입력해 주세요");*/
			$('#content').focus();
			return;
		}
	document.formm.submit();
}

/* 인덱스로 돌아가기 */
function go_home(){
	location.href="http://"+location.host + "/fems/";
}

/* femsModal 아이디의 모달을 여닫음  */
function modalToggle(){
	$('#femsModal').modal('toggle');
}

/* 안보이게 감춰 둔 클래스를 클릭 시마다 보이게/안 보이게 만듦 */
function disp(){
	$('.non-disp').toggle();
}

