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