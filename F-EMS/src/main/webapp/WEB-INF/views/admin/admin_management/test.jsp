<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
<style>
/* .text-non-border
{
border: 0px solid #fff !important

} */
</style>

</head>
<body>
이것저것 테스트!<input type="text" class="text-non-border"/>!


http://localhost:8181/fems/admin/test
</body>
</html> -->









<%
List list = new ArrayList();

Map map1 = new HashMap();
map1.put("id", "a");

Map map2 = new HashMap();
map2.put("id", "b");

Map map3 = new HashMap();
map3.put("id", "c");

Map map4 = new HashMap();
map4.put("id", "d");

list.add(map1);
list.add(map2);
list.add(map3);
list.add(map4);

request.setAttribute("openLctreList", list);
%>

<!DOCTYPE html>
<html>

<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(init);

function init() {
	$(':checkbox').on('click', checkboxClick);
}

function checkboxClick() {
	var $this = $(this);
	var $thisParent = $this.parent();
	
	if($this.prop('checked')) {
		//alert($thisParent.attr('id'));
	}
}
</script>
</head>

<body>
	<table class="tb-border">
		<thead>
			<tr>
				<th><label><input type="checkbox" id="check_all_1" class="input_check_1" />AA 전체</label></th>
					<th><label><input type="checkbox" id="check_all_3" class="input_check_2" />BB 전체</label></th>
					<th>    ----------2    </th>
			</tr>
		</thead>
		<tbody>
<c:forEach var="row" items="${openLctreList}" varStatus="status">
			<tr class="slt_ckbox_${status.index}">
				<td class="select_ckbox_1"><label><input type="checkbox"                                name="chk" value="체크값${status.count}" />AA_${status.index} </label></td>
				<td class="select_ckbox_2"><label><input type="checkbox" id="ck_all_${status.index}" name="chk" value="체크값${status.count}" />BB_${status.index} </label></td>
				
				<td>${row.id} <button type="button" id="btn${status.index}">버튼${status.count}</button> 인덱스 : ${status.index}, 카운트 : ${status.count}</td>
			</tr>
</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>

</html>