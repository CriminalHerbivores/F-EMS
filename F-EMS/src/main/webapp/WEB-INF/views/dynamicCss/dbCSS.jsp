<%@ page language="java" contentType="text/css"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--/////////////////// menu.css ///////////////////--%>

.custom-navbar-inverse{
	background-color: ${manageVO.mng_Main_Color};
	border-color: ${manageVO.mng_Main_Color};
	
}


.menu-dropbtn {
    background-color: ${manageVO.mng_Main_Color};	<%-- 색상:상단 드롭다운 버튼 --%>
    padding: 16px;
    width:120px;
    height:50px;
    font-size: 16px;
    border: none;
    cursor: pointer;
    text-decoration: none;
}

.menu-dropdown:hover .menu-dropbtn {
   background-color: ${manageVO.mng_Sub_Color1};	<%-- 색상:상단 드롭다운 hover --%>
}

.menu-dropdown-content a:hover {
	background-color : ${manageVO.mng_Sub_Color2};;
}

<%--  --%>
<%--  --%>




<%--/////////////////// main.css ///////////////////--%>

.btn-color{
	-moz-box-shadow: 0px 0px 0px 0px #ffffff;
	-webkit-box-shadow: 0px 0px 0px 0px #ffffff;
	box-shadow: 0px 0px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, ${manageVO.mng_Sub_Color1}), color-stop(1, ${manageVO.mng_Sub_Color1}) ); <%-- 버튼 바탕색 --%>
	background:-moz-linear-gradient( center top, ${manageVO.mng_Sub_Color1} 5%, ${manageVO.mng_Sub_Color1} 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='${manageVO.mng_Sub_Color1}', endColorstr='${manageVO.mng_Sub_Color1}');
	border:1px solid ${manageVO.mng_Main_Color};
	background-color:${manageVO.mng_Sub_Color1};
	color:#fff;
}

.btn-color:hover {
	<%-- background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #79BFAD), color-stop(1, #79BFAD) );
	background:-moz-linear-gradient( center top, #79BFAD 5%, #ccc 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#79BFAD', endColorstr='#79BFAD'); --%>
	<%-- opacity:0.7; --%>
	background-color:${manageVO.mng_Main_Color};
}

.ckbtn-color{
	-moz-box-shadow: 0px 0px 0px 0px #ffffff;
	-webkit-box-shadow: 0px 0px 0px 0px #ffffff;
	box-shadow: 0px 0px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, ${manageVO.mng_Sub_Color1}), color-stop(1, ${manageVO.mng_Sub_Color1}) ); <%-- 버튼 바탕색 --%>
	background:-moz-linear-gradient( center top, ${manageVO.mng_Sub_Color1} 5%, ${manageVO.mng_Sub_Color1} 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='${manageVO.mng_Sub_Color1}', endColorstr='${manageVO.mng_Sub_Color1}');
	background-color:${manageVO.mng_Sub_Color1};
	border:1px solid ${manageVO.mng_Main_Color};
	color:#fff;	
}


<%--/////////////////// accodion.css ///////////////////--%>

<%-- 서브영역 텍스트 --%>
.inherit-size:hover{
	width:inherit;
	height:inherit;	
	background: ${manageVO.mng_Sub_Color2};
	color:${manageVO.mng_Main_Color};	<%-- 색상:좌측메뉴 서브영역 텍스트 hover --%>
	font-weight: 900;
}


.accordion-menu li ul.sub li.select {
    background-color:${manageVO.mng_Sub_Color2};	<%-- 좌측메뉴 서브영역 마우스 선택상태 --%>
    color:${manageVO.mng_Main_Color};
}

.accordion-menu li .main-title {
    background-color:${manageVO.mng_Sub_Color1};	<%-- 색상:좌측 메뉴 상위 영역 --%>
    padding:10px;	
    vertical-align:middle;
    position:relative;
    z-index:100;	
}



<%--/////////////////// layout.css ///////////////////--%>
.login-menu-gray:hover, .login-menu:hover{
	background: ${manageVO.mng_Sub_Color1};
}

