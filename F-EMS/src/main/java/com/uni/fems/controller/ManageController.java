package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//직원 조회
	@RequestMapping("/sklstfList")
	public String sklstfList(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/sklstfList";	
		return url;
	}
	
	// 직원 등록
	@RequestMapping("/sklstfInsert")
	public String sklstfInsert(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/sklstfInsert";	
		return url;
	}
	
	
	// 관리자 권한 설정
	@RequestMapping("/sklstfAtrtyList")
	public String sklstfAtrtyList(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/sklstfAtrtyList";	
		return url;
	}
	
	// 관리자 메인
		@RequestMapping("/main")
		public String adminMain(HttpServletRequest request,HttpSession session) {
			String url = "admin/admin_page/main";	
			return url;
		}
	
	
	
	// 레이아웃 등록1
	@RequestMapping("/step1Add")
	public String step1Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step1Add";	
		return url;
	}
	
	// 레이아웃 등록2
	@RequestMapping("/step2Add")
	public String step2Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step2Add";	
		return url;
	}
	
	// 레이아웃 등록3
	@RequestMapping("/step3Add")
	public String step3Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step3Add";	
		return url;
	}
	
	// 레이아웃 등록4
	@RequestMapping("/step4Add")
	public String step4Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step4Add";	
		return url;
	}
	
	// 레이아웃 미리보기
	@RequestMapping("/layoutPreview")
	public String layoutPreview(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/layoutPreview";	
		return url;
	}
	
	// 레이아웃 변경1
		@RequestMapping("/step1Modify")
		public String step1Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step1Modify";	
			return url;
		}
		
		// 레이아웃 설정2
		@RequestMapping("/step2Modify")
		public String step2Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step2Modify";	
			return url;
		}
		
		// 레이아웃 설정3
		@RequestMapping("/step3Modify")
		public String step3Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step3Modify";	
			return url;
		}
		
		// 레이아웃 설정4
		@RequestMapping("/step4Modify")
		public String step4Modify(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step4Modify";	
			return url;
		}
	
	
	
	
}
