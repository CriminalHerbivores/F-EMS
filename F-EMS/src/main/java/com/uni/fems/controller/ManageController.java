package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 관리자 페이지의 모든 기능들이 포함된 Controller
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
public class ManageController {

	// @RequestMapping("/")
	// public String in(){
	// String url = "redirect:index";
	// return url;
	// }
	//
	// @RequestMapping("/index")
	// public String index(){
	// String url = "index";
	// return url;
	// }
	//
	// @RequestMapping("/logout")
	// public String logout(HttpSession session) {
	// String url = "redirect:/index";
	// session.invalidate();
	// return url;
	// }
	
	
	/**
	 * <pre>
	 * 직원 목록 조회
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/sklstfList")
	public String sklstfList(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/sklstfList";	
		return url;
	}
	
	/**
	 * <pre>
	 * 직원 등록
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/sklstfInsert")
	public String sklstfInsert(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/sklstfInsert";	
		return url;
	}
	
	
	/**
	 * <pre>
	 * 직원에게 관리자 권한 여부 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/sklstfAtrtyList")
	public String sklstfAtrtyList(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/sklstfAtrtyList";	
		return url;
	}
	
	/**
	 * <pre>
	 * 관리자 메뉴들을 한눈에 볼 수 있는 관리자 메인
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/main")
	public String adminMain(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/main";	
		return url;
	}
	
	/**
	 * <pre>
	 * 상대평가 여부 및 상대평가 비율 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/evalRateUpdate")
	public String evalRateUpdate(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/evalRateUpdate";	
		return url;
	}
	
	
	
	/**
	 * <pre>
	 * 대학 정보 입력 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step1Add")
	public String step1Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step1Add";	
		return url;
	}
	
	/**
	 * <pre>
	 * 메뉴 게시판 추가, 설정, 사용안함, 권한부여 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step2Add")
	public String step2Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step2Add";	
		return url;
	}
	
	/**
	 * <pre>
	 * 레이아웃 선택 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step3Add")
	public String step3Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step3Add";	
		return url;
	}
	
	/**
	 * <pre>
	 * 메인컬러, 보조컬러1, 보조컬러2, 텍스트컬러 입력으로 컬러테마 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step4Add")
	public String step4Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step4Add";	
		return url;
	}
	

	/**
	 * <pre>
	 * 1~4단계에서 설정한 레이아웃을 미리보기로 확인하면서 메뉴 위치를 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/layoutPreview")
	public String layoutPreview(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/layoutPreview";	
		return url;
	}
	
	/**
	 * <pre>
	 * 대학 정보 수정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step1Modify")
	public String step1Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step1Modify";	
		return url;
	}
		
	/**
	 * <pre>
	 * 메뉴 게시판 사용여부, 권한 등 수정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step2Modify")
	public String step2Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step2Modify";	
		return url;
	}
		
	/**
	 * <pre>
	 * 레이아웃 변경 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step3Modify")
	public String step3Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step3Modify";	
		return url;
	}
		
	/**
	 * <pre>
	 * 컬러 테마 변경
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step4Modify")
	public String step4Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step4Modify";	
		return url;
	}
	
	
	
	
	
}
