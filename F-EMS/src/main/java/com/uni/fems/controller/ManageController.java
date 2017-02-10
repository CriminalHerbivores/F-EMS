package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ManageController {

/*	@RequestMapping("/")
	public String in(){
		String url = "redirect:index";
		return url;
	}
	
	@RequestMapping("/index")
	public String index(){
		String url = "index";
		return url;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String url = "redirect:/index";
		session.invalidate();
		return url;
	}*/
	
	//직원 조회
	@RequestMapping("/sklstf_list")
	public String sklstfList(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/sklstf_list";	
		return url;
	}
	
	// 직원 등록
	@RequestMapping("/main")
	public String sklstfInsert(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/sklstf_insert";	
		return url;
	}
	
	
	// 관리자페이지 메인
	@RequestMapping("/main")
	public String adminMain(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/sklstf_atrty";	
		return url;
	}
	
	
	
	// 레이아웃 등록1
	@RequestMapping("/step1_add")
	public String step1Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step1_add";	
		return url;
	}
	
	// 레이아웃 등록2
	@RequestMapping("/step2_add")
	public String step2Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step2_add";	
		return url;
	}
	
	// 레이아웃 등록3
	@RequestMapping("/step3_add")
	public String step3Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step3_add";	
		return url;
	}
	
	// 레이아웃 등록4
	@RequestMapping("/step4_add")
	public String step4Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step4_add";	
		return url;
	}
	
	// 레이아웃 미리보기
	@RequestMapping("/layout_preview")
	public String layoutPreview(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/layout_preview";	
		return url;
	}
	
	// 레이아웃 변경1
		@RequestMapping("/step1_modify")
		public String step1Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step1_modify";	
			return url;
		}
		
		// 레이아웃 설정2
		@RequestMapping("/step2_modify")
		public String step2Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step2_modify";	
			return url;
		}
		
		// 레이아웃 설정3
		@RequestMapping("/step3_modify")
		public String step3Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step3_modify";	
			return url;
		}
		
		// 레이아웃 설정4
		@RequestMapping("/step4_modify")
		public String step4Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step4_modify";	
			return url;
		}
	
	
	
	
}
