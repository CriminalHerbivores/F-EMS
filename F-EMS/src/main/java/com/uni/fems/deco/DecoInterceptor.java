package com.uni.fems.deco;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.ManageService;

public class DecoInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private ManageService manageService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		ManageVO manageVO=null;
		
		try {
			manageVO=manageService.getManage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("manageVO", manageVO);
		return super.preHandle(request, response, handler);
	}
	
}
