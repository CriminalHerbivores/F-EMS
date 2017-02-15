package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 건물 등록, 수정, 사용여부 Controller
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
public class BuildingController {

	
	// 건물 등록
	
	/**
	 * <pre>
	 * 건물번호와 건물명을 중복하지 않는 값으로 입력받아서 건물을 새로 등록
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/buildingInsert")
	public String buildingInsert(HttpServletRequest request, HttpSession session) {
		String url = "admin/admin_page/buildingInsert";
		return url;
	}

	
	
	/**
	 * <pre>
	 * 등록한 건물의 건물번호, 건물명을 수정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/buildingUpdate")
	public String buildingUpdate(HttpServletRequest request, HttpSession session) {
		String url = "admin/admin_page/buildingUpdate";
		return url;
	}

}
