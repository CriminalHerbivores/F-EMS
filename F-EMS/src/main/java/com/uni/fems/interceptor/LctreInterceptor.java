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
		//메뉴에 강의 목록 띄우기
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
				return false;
			}
			if(list==null || list.isEmpty()){
				response.sendRedirect(request.getContextPath()+"/auth");
				return false;
			}
			session.setAttribute("lctreList", list);
		}
		List<LctreVO> lctreList = (List<LctreVO>) session.getAttribute("lctreList");
		if(request.getMethod().toString().equals("GET")){
			String param = request.getParameter("table_Nm").trim();
			//강의번호가 없을 시 가장 첫번째 강의로 이동
			if(param==null || param.isEmpty()){
				if(lctreList==null || lctreList.isEmpty()){
					response.sendRedirect(request.getContextPath()+"/auth");
					return false;
				}
				String url = "";
				if(request.getRequestURL().indexOf("?")<0){
					url=request.getContextPath()+request.getServletPath()+"?table_Nm="+lctreList.get(0).getLc_Lctre_No();
				}else{
					url=request.getContextPath()+request.getServletPath()+"&table_Nm="+lctreList.get(0).getLc_Lctre_No();
				}
				response.sendRedirect(url);
				return false;
			}else{
				//강의권한이 없을 시 권한 없음으로 이동
				boolean flag = false;
				for(LctreVO vo : lctreList){
					if((vo.getLc_Lctre_No()+"").equals(param)){
						flag = true;
					}
					if(!flag){
						response.sendRedirect(request.getContextPath()+"/auth");
						return false;
					}
				}
			}
		}
		return super.preHandle(request, response, handler);
	}
}
