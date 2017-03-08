<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
${manageVO.ksdulksud }
<!-- 해당 페이지의 제목을 입력한다. -->
<h2>제목 입력</h2><br/>

<!-- 검색하기 위한 조건을 입력 -->
<table class="def-table-full"><tr><td style="text-align: left;">
	<!-- 
	콤보박스는 선택사항으로, 검색 조건이 하나일 땐 콤보박스를 지우고
	검색에 필요한 사항을 input[type="text"]의 placeholder에 적는다.
	검색어 하나일 때 관리자>장학금관리 참고
	검색어가 여럿일 때 관리자>학과/등록금 조회 참고
	 -->
	<select name="key" class="combobox-md custom-form-control">
		<option value="1">검색조건1</option>
		<option value="2">검색조건2</option>
	</select>
	<input type="text" name="value" placeholder="검색 조건" class="def-input-text-lg custom-form-control">
	<input type="button" value="검색" class="def-btn btn-sm btn-color">
</td></tr></table>

<!-- 게시판 형식 : 참고는 공지사항 게시판 -->
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>작성날짜</th>
		<th>조회수</th>
	</tr>
	<!-- 
	리스트 변수를 넘겨받는 경우에는 items="리스트 변수"
	status.count는 1부터 시작
	status.index는 0부터 시작
	 -->
	<c:forEach begin="0" end="4" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>제목입니다.</td>
		<td>2017-02-10</td>
		<td>0</td>
	</tr>
	</c:forEach>
</table>

<!-- 검색 조회 외에 버튼이 더 필요할 시 여기 적는다 -->
<table class="def-table-full"><tr><td style="text-align: right;">
	<input type="button" value="버튼1" class="def-btn btn-sm btn-color">
	<input type="button" value="버튼2" class="def-btn btn-sm btn-color">
	<input type="button" value="버튼3" class="def-btn btn-sm btn-color">
</td></tr></table>

<!-- 
내용이 둘 이상 있을시엔 hr태그 또는 테이블 등으로 나눈다.
hr태그 학생>성적조회 참고
테이블로 나눈 경우는 학생>학적조회 참고 
 -->
<hr>

<h2>제목2</h2><br/>
<!-- 
소분류는 선택사항
학생>장학금 참고
 -->
<h4>소분류</h4>
<!-- 일반 양식 : 참고는 회원정보조회 -->
<table class="def-table-full tb-border table-hover">
	<tr>
		<th>
			제목
		</th>
		<td>
			게시판이 먼저 뜨고<br/>
			검색 및 버튼이 하단에 뜨드록
		</td>
		<th>
			제목은
		</th>
		<td>
			&lt;h2&gt;제목&lt;/h2&gt;&lt;br/&gt; <br/>
			을 써서 한줄 띄워준다.
		</td>
	</tr>
	<tr>
		<th>
			게시판 / 리스트 / 내용을 넣는 table
		</th>
		<td>
			&lt;table class="def-table-full tb-border table-hover"&gt;
		</td>
		<th>
			버튼 / 검색 등 input을 넣는 table
		</th>
		<td>
			&lt;table class="def-table-full"&gt;&lt;tr&gt;&lt;td style="text-align: right;"&gt;<br/><br/>
			&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;
		</td>
	</tr>
	<tr>
		<th>
			input[type="text"]
		</th>
		<td>
			class="def-table-full tb-border table-hover"
		</td>
		<th>
			input[type="button"]
		</th>
		<td>
			class="def-btn btn-sm btn-color"
		</td>
	</tr>
	<tr>
		<th>
			select
		</th>
		<td>
			class="combobox-lg custom-form-control"
		</td>
		<th>
			크기
		</th>
		<td>
			full > lg > md > sm
		</td>
	</tr>
</table>

<!-- 왼쪽과 오른쪽에 버튼을 한꺼번에 쓰고 싶을때 -->
<input type="button" class="def-btn btn-md btn-color"  value="교수이력조회">&nbsp;&nbsp; 
<div class="float-right">
<input type="button" class="def-btn btn-md btn-color"  value="수정">&nbsp;&nbsp; 
<input type="button" class="def-btn btn-md btn-gray"  value="취소"><br />
</div>

<br/><br/><br/>
</body>
</html>
