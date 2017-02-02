<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>decorator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="<%=request.getContextPath()%>/js/notice_bbs.js"></script>

<script>
	$(function() {
		$('.dropdown').click(function(event) {
			event.preventDefault();
			menu = $('.dropdown-toggle', this).text();
			submenu = $('.dropdown-menu li a', this).text();

			$.ajax({
				url : 'decorators/menu.jsp',
				type : 'post',
				data : {
					'menu' : menu,
					'submenu' : submenu
				},
				success : function(res) {
					$('.sidenav .main_menu').html(menu);
					/* $('.sidenav p#main_menu').text(menu); */
					var code = "";
					$.each(res, function(i) {
						code += "<a href='#'>" + res[i].item + "</a><br>";

					})
					$('.sidenav .sub_meun').html(code);
				},
				dataType : 'json'
			})
		})
	})
</script>


<jsp:include page="menu_decorator.jsp"></jsp:include>
