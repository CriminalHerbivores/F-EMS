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
