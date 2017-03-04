package com.uni.fems.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.service.ManageService;

public class LctreInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private ManageService manageService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("lctreList")==null){
			String loginUser = "";
			if(session.getAttribute("loginUser")==null){
				response.sendRedirect(request.getContextPath()+"/notPage");
			}else{
				loginUser = (String) session.getAttribute("loginUser");
			}
			
			Object[] principal = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray();
			String auth = principal[0].toString();
			
			List<LctreVO> list = new ArrayList<LctreVO>();
			
			switch(auth){
			case "ROLE_PRO" : 
				list = manageService.getProfsrList(loginUser);
				break;
			case "ROLE_STD" : 
				list = manageService.getStdntList(loginUser);
				break;
			default : 
				response.sendRedirect(request.getContextPath()+"/auth");
				break;
			}
			if(list==null) response.sendRedirect(request.getContextPath()+"/auth");
			session.setAttribute("lctreList", list);
		}
		if(request.getParameter("table_Nm")==null || request.getParameter("table_Nm").isEmpty()){
			List<LctreVO> lctreList = (List<LctreVO>) session.getAttribute("lctreList");
			String url = request.getContextPath()+request.getServletPath()+"?table_Nm="+lctreList.get(0).getLc_Lctre_No();
			response.sendRedirect(url);
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
}
