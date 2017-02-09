<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
$(document).ready(function() {
	var bbs_no = $('#bbs_no').val();
    var data ={'bbs_no' : bbs_no};
    
    
    $.ajax({
       url:'<%=request.getContextPath()%>/notice_bbs/commentList',
       contentType:'application/json; charset=utf-8',
       dataType:'text',
       data:JSON.stringify(data),
       type:'post',
       success : function(data){
    	   $('#comment_content').val('');
	       $('div #comment').empty();
        $('div #comment').append(data);
     },
       error:function(error){
       alert("오류났음");   
       }
    });
});

function commm_go(){
	var bbs_no = $('#bbs_no').val();
	var comment_content = $('#comment_content').val();
	var dataWrite={
			'bbs_no' : bbs_no,
			'comment_content' : comment_content
	};
	$.ajax({
		url : '<%=request.getContextPath()%>/notice_bbs/insertComment',
		contentType:'application/json; charset=utf-8',
		data : JSON.stringify(dataWrite),
		dataType:'text',
		type : 'post',
		contentType : 'application/json',
	     success : function(data){
	    	   $('#comment_content').val('');
		       $('div #comment').empty();
	        $('div #comment').append(data);
	     },
	      error : function() {
	         alert('댓글 등록 실패');
	      }
	   });
	}
	
$(document).on('click','.deleteComment',function(e){
    e.preventDefault();
    var result = $(this).attr('id');
    var bc_bbs_no = $('#bbs_no').val();
    var data = {
			"result" : result,
			"bc_bbs_no" : bc_bbs_no
		};
    $.ajax({
       url:"<%=request.getContextPath()%>/notice_bbs/deleteComment",
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data),
			dataType : 'text',
			type : 'post',
			success : function(data) {
				$('#comment_content').val('');
				$('div #comment').empty();
				$('div #comment').append(data);
			},
			error : function() {
				alert('댓글 삭제 실패');
			}
		});
	});


$(document).on('click','.cancelComment',function(e){
	e.preventDefault();
	var bbs_no = $('#bbs_no').val();
	var data ={'bbs_no' : bbs_no};
	$.ajax({
	       url:'<%=request.getContextPath()%>/notice_bbs/commentList',
	       contentType:'application/json; charset=utf-8',
	       dataType:'text',
	       data:JSON.stringify(data),
	       type:'post',
	       success : function(data){
	    	   $('#comment_content').val('');
		       $('div #comment').empty();
	        $('div #comment').append(data);
	     },
	       error:function(error){
	       alert("오류났음");   
	       }
	    });
});


$(document).on('click', '.updateComment', function(e){
	e.preventDefault();
	var bbs_no = $('#bbs_no').val();
    var cmntNo = $(this).attr('id');
    var data ={'bbs_no' : bbs_no,
    		   'cmntNo' : cmntNo
    		};
    $.ajax({
	       url:'<%=request.getContextPath()%>/notice_bbs/updateComment',
	       contentType:'application/json; charset=utf-8',
	       dataType:'text',
	       data:JSON.stringify(data),
	       type:'post',
	       success : function(data){
	    	   $('#comment_content').val('');
		       $('div #comment').empty();
	        $('div #comment').append(data);
	     },
	       error:function(error){
	       alert("오류났음");   
	       }
	    });
});

$(document).on('click','.realupdateComment',function(e){
	e.preventDefault();
	var bbs_no = $('#bbs_no').val();
	var cmntNo = $(this).attr('id');
	var content = $('#comment_update').val();
	var	data={'content' : content,
			  'cmntNo' : cmntNo,
			  'bbs_no' : bbs_no
			};
	$.ajax({
		url:"<%=request.getContextPath()%>/notice_bbs/realupdateComment",
		contentType:'application/json; charset=utf-8',
		dataType:'text',
		data:JSON.stringify(data),
		type:'post',
		  success : function(data){
	    	   $('#comment_content').val('');
		       $('div #comment').empty();
	        $('div #comment').append(data);
	     },
	       error:function(error){
	       alert("오류났음");   
	       }
	    });
});

</script>






</head>
<body>
	<form name="formm" method="post" action="notice_bbs">
		<h2>공지 게시판</h2>

		<table>
			<tr>
				<th>제목</th>
				<td>${notice.nb_Sj}</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td>${notice.nb_Writng_Dt}</td>
				<th>조회수</th>
				<td>${notice.nb_Rdcnt}</td>
			</tr>
			<c:forEach var="flpth" items="${flpthList }">
				<tr>
					<th>파일첨부</th>
					<td><a href="file/notice?filename=${flpth.bf_File_Nm }">${flpth.bf_File_Nm}</a></td>
				</tr>
			</c:forEach>
			<tr>
				<th>내용</th>
				<td>${notice.nb_Cn}</td>
			</tr>

		</table>

		<div id="comment"></div>
		<!-- 댓글부분 -->


		<input type="hidden" value="${notice.nb_Bbs_No }" id="bbs_no"
			name="bbs_no">
		<textarea rows="3" cols="60" id="comment_content" id="comment_content"
			name="comment_content"></textarea>
		</td> <input type="button" value="확인" id="btnSave" onclick="commm_go();">
		</td> <input type="hidden" value="${loginUser}" id="loginUser">

	</form>

	<!--버튼들  -->
	<div id="buttons" style="float: right">
		<%-- <a href="deleteNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input type="button" class="def-btn" value="삭제"> </a> --%>
		<a href="updateNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input
			type="button" value="수정" class="def-btn">
		</a> <input type="button" class="def-btn" data-target="#layerpop"
			data-toggle="modal" value="삭제"> <a
			href="noticeList?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <input
			type="button" class="def-btn" value="목록">
		</a>
	</div>

	<!--모달부분  -->
	<div class="modal fade" id="layerpop">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<!-- 닫기(x) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">×</button>
					<!-- header title -->
					<h4 class="modal-title" style="text-align: center">삭제확인</h4>
				</div>
				<!-- body -->
				<div class="modal-body" style="text-align: center">삭제하시겠습니까?</div>
				<!-- Footer -->
				<div class="modal-footer" style="text-align: center;">
					<a href="deleteNotice?no=${notice.nb_Bbs_No}&tpage=${tpage}"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>




</body>
</html>