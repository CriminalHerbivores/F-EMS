package com.uni.fems.deco;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uni.fems.dto.Bbs_ListVO;
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
	 * decorator에 적용할 정보들을 가져와서 설정함
	 * </pre>
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("manageVO")==null){
			ManageVO manageVO=null;
			manageVO=manageService.getManage();
			session.setAttribute("manageVO", manageVO);
		}
		if(session.getAttribute("bbsList")==null){
			List<Bbs_ListVO> bbsList=null;
			bbsList=manageService.getBbsList("t");
			session.setAttribute("bbsList", bbsList);
		}
		if(session.getAttribute("noticeBBS")==null){
			List<Bbs_ListVO> noticeList=null;
			noticeList=manageService.getBbsList("b");
			session.setAttribute("noticeBBS", noticeList);
		}
		return super.preHandle(request, response, handler);
	}
	
}
