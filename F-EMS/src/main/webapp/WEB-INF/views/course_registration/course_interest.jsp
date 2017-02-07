<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
body{
	 background:#CEFBC9;
}
</style>

</head>
<body>
<form>
<article>



<%-- 
<a href="<%=request.getContextPath() %>/course/course_timetable" class="openMask"><input type="button" class="def-btn" value="시간표"></a><br/>
 --%>




  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" id="openmodal" data-toggle="modal" data-target="#myModal">Open Modal</button>

 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
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
  </div>






<table  class="def-table tb-border">
	<tr><td>관심 강의 목록
	</td></tr>
	
	<tr><td>
	</td></tr>
	
</table>




</article>
</form>
</body>
</html>