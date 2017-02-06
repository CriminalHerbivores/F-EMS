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
	
	// 관리자페이지 메인
	@RequestMapping("/main")
	public String admin_mainForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/admin_main";	
		return url;
	}
	
	// 관리자 가입
	@RequestMapping("/admin_join")
	public String admin_joinForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/admin_join";	
		return url;
	}
	
	// 레이아웃 등록1
	@RequestMapping("/step1_add")
	public String step1_addForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step1_add";	
		return url;
	}
	
	// 레이아웃 등록2
	@RequestMapping("/step2_add")
	public String step2_addForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step2_add";	
		return url;
	}
	
	// 레이아웃 등록3
	@RequestMapping("/step3_add")
	public String step3_addForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step3_add";	
		return url;
	}
	
	// 레이아웃 등록4
	@RequestMapping("/step4_add")
	public String step4_addForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step4_add";	
		return url;
	}
	
	// 레이아웃 미리보기
	@RequestMapping("/layout_preview")
	public String layout_previewForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/layout_preview";	
		return url;
	}
	
	// 레이아웃 변경1
		@RequestMapping("/step1_modify")
		public String step1_modifyForm(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step1_modify";	
			return url;
		}
		
		// 레이아웃 설정2
		@RequestMapping("/step2_modify")
		public String step2_modifyForm(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step2_modify";	
			return url;
		}
		
		// 레이아웃 설정3
		@RequestMapping("/step3_modify")
		public String step3_modifyForm(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step3_modify";	
			return url;
		}
		
		// 레이아웃 설정4
		@RequestMapping("/step4_modify")
		public String step4_modifyForm(HttpServletRequest request,HttpSession session) {
			String url = "admin/layout_control/step4_modify";	
			return url;
		}
	
	
	
	
}
