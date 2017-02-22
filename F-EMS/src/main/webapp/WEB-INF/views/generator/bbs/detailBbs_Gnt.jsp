<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  [[개정이력(Modification Information)]]       -->
<!--  수정일               수정자            수정내용               -->
<!--  ==========   ======    ==============        -->
<!--  2017.02.22    KJS            최초작성               -->
<!--  Copyright (c) 2017 by DDIT All right reserved -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
$(document).ready(function() {
	var bbs_no = ${bbs_List_Gnt.bb_Bbs_No}
	
    var data ={'bb_Bbs_No' : '${bbs_List_Gnt.bb_Bbs_No}',
    			'bl_Table_Nm' : '${bbs_List_Gnt.bl_Table_Nm}'};
    
    $.ajax({
       url:'<%=request.getContextPath()%>/bbs_gnt/commentList',
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
$(document).on('click','.pageComment',function(e){
    e.preventDefault();
    var cpage = $(this).attr('id');
    
	var bbs_no = $('#bbs_no').val();
    var data ={
    		'bb_Bbs_No' : bbs_no,
    		'cpage' : cpage
    		};
    
    $.ajax({
       url:'<%=request.getContextPath()%>/bbs_gnt/commentList',
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
	
	var comment_content = $('#comment_content').val();
	if(comment_content == ""){
		alert('실패');
		return;
	}
	var bbs_no = $('#bbs_no').val();
	var dataWrite={
			'bb_Bbs_No' : '${bbs_List_Gnt.bb_Bbs_No}',
			'comment_content' : comment_content,
			'bl_Table_Nm' : '${bbs_List_Gnt.bl_Table_Nm}'
	};
	$.ajax({
		url : '<%=request.getContextPath()%>/bbs_gnt/insertComment',
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
    var data = {
			"result" : result,
			"bb_Bbs_No" : '${bbs_List_Gnt.bb_Bbs_No}',
			'bl_Table_Nm' : '${bbs_List_Gnt.bl_Table_Nm}'
		};
    $.ajax({
       url:"<%=request.getContextPath()%>/bbs_gnt/deleteComment",
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
	var data ={'bb_Bbs_No' : '${bbs_List_Gnt.bb_Bbs_No}',
			'bl_Table_Nm' : '${bbs_List_Gnt.bl_Table_Nm}'};
	$.ajax({
	       url:'<%=request.getContextPath()%>/bbs_gnt/commentList',
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
    var data ={'bb_Bbs_No' : '${bbs_List_Gnt.bb_Bbs_No}',
			'bl_Table_Nm' : '${bbs_List_Gnt.bl_Table_Nm}',
    		   'cmntNo' : cmntNo
    		};
    $.ajax({
	       url:'<%=request.getContextPath()%>/bbs_gnt/updateComment',
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
			  'bb_Bbs_No' : '${bbs_List_Gnt.bb_Bbs_No}',
	'bl_Table_Nm' : '${bbs_List_Gnt.bl_Table_Nm}'
			};
	$.ajax({
		url:"<%=request.getContextPath()%>/bbs_gnt/realupdateComment",
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
<div id="detailBbs_Gnt" style="float:left;">
	<form name="formm" method="post" action="detailBbs_Gnt">
		<h2>${bbs_List_Gnt.bl_Bbs_Nm }</h2>
		<hr>
		<table class="def-table-full tb-border table-hover" style="width:750px; text-align:left;">
			<tr>
				<th>제목</th>
				<td colspan="3" style="text-align: left;">${bbs_List_Gnt.bb_Sj}</td>
			</tr>
			<tr>
				<th>작성날짜</th>
				<td style="text-align: left;">${bbs_List_Gnt.bb_Writng_dt}</td>
				<th>조회수</th>
				<td style="text-align: left;">${bbs_List_Gnt.bb_Rdcnt}</td>
			</tr>
			<c:forEach var="flpth" items="${flpthList }">
				<tr>
					<th>파일첨부</th>
<%-- 					<td colspan="3" style="text-align: left;"><a href="file/notice?filename=${flpth.bf_File_Nm }">${flpth.bf_File_Nm}</a></td> --%>
					<td colspan="3" style="text-align: left;"><a href="<%=request.getContextPath() %>/download/file/list?filename=${flpth.bf_File_Nm}">${flpth.bf_File_Nm}</a></td>
				</tr>
			</c:forEach>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: left;"><textarea rows="8" cols="65" name="nb_Cn" readonly="readonly">${bbs_List_Gnt.bb_Cn }</textarea><br></td>
			</tr>

		</table>
		<br>
		<!-- 댓글부분 -->


		<textarea rows="3" cols="60" id="comment_content" id="comment_content"
			name="comment_content"></textarea>
		<input type="button" value="확인" class="def-btn btn-sm btn-color" id="btnSave" onclick="commm_go();">
		<div id="comment"></div>
		<input type="hidden" value="${loginUser}" id="loginUser">

	</form>

	<!--버튼들  -->
	<div id="buttons" style="float: right">
		<a href="updateBbs_Gnt?bb_Bbs_No=${bbs_List_Gnt.bb_Bbs_No}&bb_Bbs_No=${bbs_Gnt.bb_Bbs_No}&bl_Bbs_No=${bbs_List_Gnt.bl_Bbs_No}&bl_Bbs_Nm=${bbs_List_Gnt.bl_Bbs_Nm}&bl_Table_Nm=${bbs_List_Gnt.bl_Table_Nm}&tpage=${tpage}"> <input
			type="button" value="수정" class="def-btn btn-md btn-color">
		</a> <input type="button" class="def-btn btn-md btn-color" data-target="#layerpop"
			data-toggle="modal" value="삭제"> <a
			href="bbsList?bl_Bbs_No=${bbs_List_Gnt.bl_Bbs_No}&tpage=${tpage}"> <input
			type="button" class="def-btn btn-md btn-color" value="목록">
		</a>
	</div>
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
					<a href="deleteBbs_Gnt?bb_Bbs_No=${bbs_List_Gnt.bb_Bbs_No}&bb_Bbs_No=${bbs_Gnt.bb_Bbs_No}&bl_Bbs_No=${bbs_List_Gnt.bl_Bbs_No}&bl_Bbs_Nm=${bbs_List_Gnt.bl_Bbs_Nm}&bl_Table_Nm=${bbs_List_Gnt.bl_Table_Nm}&tpage=${tpage}"> <!--삭제 모달  -->
						<input type="button" class="btn btn-default" value="예">
					</a> <input type="button" class="btn btn-default" data-dismiss="modal"
						value="아니오">
				</div>
			</div>
		</div>
	</div>




</body>
</html>
