<%--
 * <pre>
 * 상단메뉴에서 선택한 메뉴 정보를 좌측메뉴로 가져오는 JSP
 * </pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH        최초작성
 * 2017.01.30      KJH        사용보류
 * Copyright (c) 2017 by DDIT All right reserved
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[    
<%
	String thmenu = request.getParameter("menu").trim();
	String submenu = request.getParameter("submenu");
	
	String items[] = submenu.split(" ");
	for(int i=0; i<items.length; i++){
		if(i>0) out.print(",");

%>		
		{	"item" : "<%= items[i] %>"	}

<%		
	}
	
	
%>
]