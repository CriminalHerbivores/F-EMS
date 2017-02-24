<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
 * <pre>
 * 개설된 강의 중 관심목록에 추가한 강의들을 확인 가능한 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.02.15      KJH        추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function op_timeTable(){
	alert("시간표");
/* 
	swal({
		title : "Are you sure?",
		text : "You will not be able to recover this imaginary file!",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "닫기",
		closeOnConfirm : false
	}, function (){
		swal("Deleted!", "Your imaginary file has been deleted.", "success");
	}); */
}
</script>
<style>
body {
	/* background:#CEFBC9; */
	
}
</style>

</head>
<body class="course-list-r-bottom">
	<form>

		<div class="text-center">
			<%-- 
<a href="<%=request.getContextPath() %>/course/course_timetable" class="openMask"><input type="button" class="def-btn" value="시간표"></a><br/>
 --%>




			<!-- Trigger the modal with a button -->
			<!-- <button type="button" class="def-btn btn-md btn-color" id="openmodal" data-toggle="modal" data-target="#myModal">시간표</button> -->

			<!-- Modal -->
			<!--   <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          
          
          <p>Some text in the modal.</p>
          
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div> -->






			<table class="def-table-full tb-border table-hover">
				<h4>
					관심 강의 목록&nbsp;&nbsp;
					<button type="button" class="def-btn btn-md btn-color"
						id="openmodal" data-toggle="modal" data-target="#myModal" onclick="op_timeTable()">시간표</button>
				</h4>
				<tr>
					<th colspan="2">강의명</th>
				</tr>
				<c:forEach items="${lctre_SearchVO}" var="intrst">
					<tr>
						<td>${intrst.lu_Lctre_Nm }</td>
						<td><input type="button" class="def-ckbtn btn-sm ckbtn-color"
							value="해제"></td>
					</tr>
				</c:forEach>

				<!-- <tr><td>컴퓨터 입문</td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="해제"></td></tr>
	<tr><td>데이터 통신</td><td><input type="button" class="def-ckbtn btn-sm ckbtn-color" value="해제"></td></tr>
 -->
			</table>

		</div>


	</form>
</body>
</html>