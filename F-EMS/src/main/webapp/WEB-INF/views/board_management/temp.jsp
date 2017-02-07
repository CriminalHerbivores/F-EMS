<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->


<script>
   function goUpdate(fre_num) {
      document.free.action = "update?fre_num=" + fre_num;
      document.free.submit();
   }

   /*삭제  */
   function goDelete(fre_num) {
      document.free.action = "delete?fre_num=" + fre_num;
      document.free.submit();
   }
</script>

<script>
$(document).ready(function() {
    var fre_num = $('#fre_num').val();
    var data ={'fre_num' : fre_num};
    
    $.ajax({
       url:'<%=request.getContextPath()%>/cmt/cmtList',
       contentType:'application/json',
       dataType:'json',
       data:JSON.stringify(data),
       type:'post',
       success : function(data){
          $.each(data, function(i) {
             var date = new Date(
                   data[i].cmt_date);
             var year = date.getFullYear();
             var month = (1 + date.getMonth());
             month = month >= 10 ? month : '0'
                   + month;
             var day = date.getDate();
             day = day >= 10 ? day : '0' + day;
             var fullD = year + '년' + month
                   + '월' + day + '일';
             var cmtList = '<div id="'
                  + data[i].cmt_num   
                  + '">아이디 : '
                  + data[i].mbr_id
                  + '  /  ' + '작성 날짜 : '
               + fullD
               +'<a href="" id="'
                  +data[i].cmt_num
                  +'" ' 
                  +'class="asd" name="asd">삭제</a>'
               + '<div>  ->'
                  + data[i].cmt_content
                  +'</div></div><br><br>';
             $('div#comment').append(cmtList);
          });          
       },
       error:function(error){
       alert(error);   
       }
    });
});

function commm_go() {
   var fre_num = $('#fre_num').val();
    var cmt_content = $('#cmt_content').val();
    var dataWrite = {
       'fre_num' : fre_num,
       'cmt_content' : cmt_content
    };
    $.ajax({
       url : '<%=request.getContextPath()%>/cmt/cmtWrite',
      data : JSON.stringify(dataWrite),
      type : 'post',
      contentType : 'application/json',
      success : function(data) {
         $('#cmt_content').val('');
         $('div #comment').empty();
         $.each(data, function(i) {
            var date = new Date(data[i].cmt_date);
            var year = date.getFullYear();
            var month = (1 + date.getMonth());
            month = month >= 10 ? month : '0' + month;
            var day = date.getDate();
            day = day >= 10 ? day : '0' + day;
            var fullD = year + '년' + month + '월' + day + '일';
            var cmtList = '<div id="'
                  + data[i].cmt_num   
                  + '">아이디 : '
                  + data[i].mbr_id
                  + '  /  ' + '작성 날짜 : '
               + fullD
               +'<a href="" id="'
                  +data[i].cmt_num
                  +'" ' 
                  +'class="asd" name="asd">삭제</a>'
               + '<div>  ->'
                  + data[i].cmt_content
                  +'</div></div><br><br>';
            $('div #comment').append(cmtList);
         });
      },
      error : function() {
         alert('댓글 등록 실패');
      }
   });
}

$(document).on('click','.asd',function(e){
    e.preventDefault();
    var result = $(this).attr('id');
    $.ajax({
       url:"<%=request.getContextPath()%>/cmt/cmtDelete",
       data: {"result" : result},
       dataType:'json',
       type:'post',
       
       success:function(map1){
          freeMap = jQuery.map(map1 , function(a){
             return a;
          })
          $('#'+freeMap).remove();
       }
    });
 });
</script>


<style>
#freeView {
   margin: auto;
   width: 70%;
}

#mod, del, list {
   margin-left: 28.9999%;
}
</style>
</head>
<body>
   <!-- PRELOADER -->
   <img id="preloader"
      src="<%=request.getContextPath()%>/resources/images/preloader.gif"
      alt="" />
   <!-- 로딩 이미지 -->

   <!-- //PRELOADER -->
   <div class="preloader_hide">
      <div class="qnaHeader">

         <!-- BREADCRUMBS -->
         <section class="breadcrumbs_block clearfix parallax">
            <div class="container center">
               <h2>
                  <b>FREE</b> BOARD
               </h2>
               <br> <br>
               <p>'자유게시판' 페이지 입니다.</p>
            </div>
         </section>
         <!-- //BREADCRUMBS -->
         <br>
         <form name="free" method="post" action="freeView">
            <div class="container">
               <table class="table table-hover" id="freeView">
                  <tr>
                     <th>제목</th>
                     <td>${freeVO.fre_title }</td>
                  </tr>

                  <tr>
                     <th>내용</th>
                     <td>${freeVO.fre_content }</td>
                  </tr>

                  <tr>
                     <th>작성자</th>
                     <td>${freeVO.mbr_id }</td>
                  </tr>

                  <tr>
                     <th>게시날짜</th>
                     <td>${freeVO.fre_date }</td>
                  </tr>
               </table>
            </div>
            <br>
            <c:choose>
               <c:when test="${freeVO.mbr_id==sessionScope.loginUser }">
                  <!-- 수정  -->
                  <button type="button" id="mod" class="btn"
                     onclick="goUpdate('${freeVO.fre_num}')"
                     style="background-color: black;">수정</button>
                  <!-- 삭제  -->
                  <button type="button" id="del" class="btn"
                     onclick="goDelete('${freeVO.fre_num}')"
                     style="background-color: black;">삭제</button>
                  <!-- 목록 -->
                  <button type="button" id="list" class="btn"
                     onclick="location.href='freeList'"
                     style="background-color: black;">목록</button>
               </c:when>

               <c:otherwise>
                  <button type="button" id="list2" class="btn"
                     onclick="location.href='freeList'"
                     style="background-color: black;">목록</button>
               </c:otherwise>
            </c:choose>

            <div id="comment"></div>
            <input type="hidden" value="${freeVO.fre_num }" id="fre_num" name="fre_num"> 
            댓글 : <input type="text" id="cmt_content" name="cmt_content"> 
            <input type="button" id="insertCmt" name="insertCmt" value="등록" onclick="commm_go();">
         
         </form>
      </div>
   </div>


</body>
</html>