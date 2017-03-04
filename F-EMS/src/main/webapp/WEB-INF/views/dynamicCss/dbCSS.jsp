<%@ page language="java" contentType="text/css"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--/////////////////// menu.css ///////////////////--%>

.custom-navbar-inverse{
	background-color: ${manageVO.mng_Main_Color};
	border-color: ${manageVO.mng_Main_Color};
	border-radius:8px;
	width:97%;
	margin:auto;
}


.menu-dropbtn {
    background-color: ${manageVO.mng_Main_Color};	<%-- 색상:상단 드롭다운 버튼 --%>
    width:120px;
    height:50px;
    font-size: 16px;
    border: none;
    cursor: pointer;
    text-decoration: none;
}

.menu-dropbtn  a{
    color: ${manageVO.mng_Main_Txtclr} !important;	<%-- 메인 메뉴 글자 색상 --%>
    font-weight: 900;
}

.menu-dropdown a:hover{
	text-decoration:none;
	color:${manageVO.mng_Sub_Txtclr1};	<%--색상: 상단 hover 텍스트 --%>
		text-decoration: none;
}


.menu-dropdown:hover .menu-dropbtn {
   background-color: ${manageVO.mng_Sub_Color1};	<%-- 색상:상단 드롭다운 hover --%>
   color: ${manageVO.mng_Sub_Txtclr1};
}


.menu-dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    <%--font-weight:600;--%>
} 

.menu-dropdown-content a:hover {
	background-color : ${manageVO.mng_Sub_Color2};
	color: ${manageVO.mng_Sub_Txtclr2};
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
	color:${manageVO.mng_Sub_Txtclr1};
}

.btn-color:hover {
	<%-- background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #79BFAD), color-stop(1, #79BFAD) );
	background:-moz-linear-gradient( center top, #79BFAD 5%, #ccc 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#79BFAD', endColorstr='#79BFAD'); --%>
	<%-- opacity:0.7; --%>
	-moz-box-shadow: 0px 0px 0px 0px #ffffff;
	-webkit-box-shadow: 0px 0px 0px 0px #ffffff;
	box-shadow: 0px 0px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, ${manageVO.mng_Main_Color}), color-stop(1, ${manageVO.mng_Main_Color}) ); <%-- 버튼 바탕색 --%>
	background:-moz-linear-gradient( center top, ${manageVO.mng_Main_Color} 5%, ${manageVO.mng_Main_Color} 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='${manageVO.mng_Main_Color}', endColorstr='${manageVO.mng_Main_Color}');
	
	
	border:1px solid ${manageVO.mng_Sub_Color1};
	background-color:${manageVO.mng_Main_Color};
	color:${manageVO.mng_Main_Txtclr};
}

.ckbtn-color{
	-moz-box-shadow: 0px 0px 0px 0px #ffffff;
	-webkit-box-shadow: 0px 0px 0px 0px #ffffff;
	box-shadow: 0px 0px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, ${manageVO.mng_Sub_Color1}), color-stop(1, ${manageVO.mng_Sub_Color1}) ); <%-- 버튼 바탕색 --%>
	background:-moz-linear-gradient( center top, ${manageVO.mng_Sub_Color1} 5%, ${manageVO.mng_Sub_Color1} 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='${manageVO.mng_Sub_Color1}', endColorstr='${manageVO.mng_Sub_Color1}');
	border:1px solid ${manageVO.mng_Main_Color};
	background-color:${manageVO.mng_Sub_Color1};
	color:${manageVO.mng_Sub_Txtclr1};	
}




.def-table-auto th, .def-table-full th, .def-table-100 th{
	background-color: ${manageVO.mng_Sub_Color1};
	color:${manageVO.mng_Sub_Txtclr1};
	padding-left: 15px;
	padding-right:15px;
	padding-top:6px;
	padding-bottom:6px;
	font-size:15px !important;
	text-align:center;
	vertical-align: middle;
}

.tr-child-color tr:nth-child(even){background-color: #f2f2f2}

.table-hover>tbody>tr:hover{
background-color:${manageVO.mng_Sub_Color2} !important;
color:${manageVO.mng_Sub_Txtclr2} !important;
}

<%-- 테이블 border 
tb-border td {
	border: 1px solid ${manageVO.mng_Sub_Color2} !important;
}

.tb-border td,.tb-border th{
border:1px solid ${manageVO.mng_Sub_Color2} !important}

.tb-border{border:1px solid ${manageVO.mng_Sub_Color2}; }
.tb-border>tbody>tr>td,
.tb-border>tbody>tr>th,
.tb-border>tfoot>tr>td,
.tb-border>tfoot>tr>th,
.tb-border>thead>tr>td,
.tb-border>thead>tr>th{
border:1px solid ${manageVO.mng_Sub_Color2};
}--%>


<%--/////////////////// accodion.css ///////////////////--%>
.main-title a{
	color: ${manageVO.mng_Sub_Txtclr1} !important;	<%-- 좌측 메뉴 글자 색상 --%>
	font-weight: 900;
}

.accordion-menu>li {	<%-- 아코디언 메뉴 상위 --%>
    overflow:hidden;
    border:1px solid ${manageVO.mng_Main_Color};
    cursor:pointer;
   border-radius:8px;
   margin-bottom: 10px;
   <%--border-top-right-radius:8px;	--%>
}


<%-- 서브영역 텍스트 --%>
.inherit-size:hover{
	width:inherit;
	height:inherit;	
	background: ${manageVO.mng_Sub_Color2};
	color:${manageVO.mng_Sub_Txtclr2};	<%-- 색상:좌측메뉴 서브영역 텍스트 hover --%>
	font-weight: 900;
}


.accordion-menu li ul.sub li.select {
    background-color:${manageVO.mng_Sub_Color2};	<%-- 좌측메뉴 서브영역 마우스 선택상태 --%>
    color:${manageVO.mng_Sub_Txtclr2};
}

.accordion-menu li .main-title {
    background-color:${manageVO.mng_Sub_Color1};	<%-- 색상:좌측 메뉴 상위 영역 --%>
    color:${manageVO.mng_Sub_Txtclr1};
    padding:10px;	
    vertical-align:middle;
    position:relative;
    z-index:100;
    <%-- border-radius:6px; --%>	
}



<%--/////////////////// layout.css ///////////////////--%>
.login-menu-gray:hover, .login-menu:hover{
	background: ${manageVO.mng_Sub_Color1};
	color: ${manageVO.mng_Sub_Txtclr1};
	
}


<%-- ///////////////////////////////////////////////////////////////// --%>

.accordion-menu_1>li {	<%-- 아코디언 메뉴 상위 --%>
    overflow:hidden;
    border:1px solid ${manageVO.mng_Main_Color};
    cursor:pointer;
   border-radius:8px;
   margin-bottom: 10px;
   <%--border-top-right-radius:8px;	--%>
}

.accordion-menu_1 li ul.sub li.select {
    background-color:${manageVO.mng_Sub_Color2};	<%-- 좌측메뉴 서브영역 마우스 선택상태 --%>
    color:${manageVO.mng_Sub_Txtclr2};
}

.accordion-menu_1 li .main-title {
    background-color:${manageVO.mng_Sub_Color1};	<%-- 색상:좌측 메뉴 상위 영역 --%>
    color:${manageVO.mng_Sub_Txtclr1};
    padding:10px;	
    vertical-align:middle;
    position:relative;
    z-index:100;
    <%-- border-radius:6px; --%>	
}


