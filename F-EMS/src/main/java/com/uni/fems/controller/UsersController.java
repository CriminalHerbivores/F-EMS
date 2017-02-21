package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UsersController {

	// 로그인 - 로그인형
	@RequestMapping("lgLogin")
	public String loginLoginTypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/loginLoginType";
		return url;
	}

	// 로그인 - 복합형
	@RequestMapping("lgMulti")
	public String loginMultiTypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/loginMultiType";
		return url;
	}

	// 로그인 - 게시판형
	@RequestMapping("lgBoard")
	public String lg_boardtypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/loginBoardType";
		return url;
	}

	// 로그인 - 메뉴형
	@RequestMapping("lgMenu")
	public String lg_menutypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/loginMenuType";
		return url;
	}

	// 아이디 비번 찾기
//	@RequestMapping("findIdPw")
//	public String findIdPwForm(HttpServletRequest request, HttpSession session) {
//		String url = "layout_type/findIdPw";
//		return url;
//	}
	
	
	// 메인 - 로그인형
	@RequestMapping("accLogin")
	public String ac_logintypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/accessLoginType";
		return url;
	}

	// 메인 - 복합형
	@RequestMapping("accMulti")
	public String ac_multitypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/accessMultiType";
		return url;
	}

	// 메인 - 게시판형
	@RequestMapping("accBoard")
	public String ac_boardtypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/accessBoardType";
		return url;
	}

	// 메인 - 메뉴형
	@RequestMapping("accMenu")
	public String ac_menutypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/accessMenutype";
		return url;
	}

	
	

}
