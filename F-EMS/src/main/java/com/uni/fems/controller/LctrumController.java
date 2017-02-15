package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 강의실 등록, 강의실 수정, 강의실 사용여부 설정이 가능한 Controller
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin")
public class LctrumController {

	/**
	 * <pre>
	 * 건물번호, 층수, 호실, 수용인원을 입력받아서 강의실 등록
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/lctrumInsert")
	public String add_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/lctrumInsert";
		return url;
	}

	/**
	 * <pre>
	 * 강의실 정보 수정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/lctrumUpdate")
	public String modify_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/lctrumUpdate";
		return url;
	}

	/**
	 * <pre>
	 * 강의실 사용여부 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/lctrumUseUpdate")
	public String set_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/lctrumUseUpdate";
		return url;
	}

}
