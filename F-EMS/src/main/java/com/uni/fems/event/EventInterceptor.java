package com.uni.fems.event;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uni.fems.common.Paging;
import com.uni.fems.dto.EventVO;
import com.uni.fems.service.EventService;

/**
 * <pre>
 * 학사 일정의 스케쥴을 관리하는 인터셉터
 * </pre>
 * @author JAR
 * @since 2017. 3. 1.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 3. 1.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class EventInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private EventService eventService;
	@Autowired
	private Paging callPaging;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String[] comm = callPaging.callPath(request);
		EventVO vo = new EventVO();
		vo = eventService.selectEvent(comm[comm.length-1]);
		
		Timestamp today = new Timestamp(System.currentTimeMillis());
		boolean flag = true ; 
		
		if(today.compareTo(vo.getEvt_Start())<0 || today.compareTo(vo.getEvt_End())>0){
			flag = false;
			response.sendRedirect(request.getContextPath()+"/event");
		}
		
		return flag;
	}
}
