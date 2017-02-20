package com.uni.fems.deco;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.ManageService;

/**
 * <pre>
 * 데코레이터에 적용할 수 있는 설정 값들을 불러오기 위한 인터셉터
 * </pre>
 * @author JAR
 * @since 2017. 2. 16.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 16.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class DecoInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private ManageService manageService;
	
	/**
	 * <pre>
	 * manage 테이블의 값을 가져와서 설정함
	 * </pre>
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("manageVO")==null){
			ManageVO manageVO=null;
			try {
				manageVO=manageService.getManage();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("manageVO", manageVO);
		}
		return super.preHandle(request, response, handler);
	}
	
}
