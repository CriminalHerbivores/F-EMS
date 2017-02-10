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
	@RequestMapping("lg_login")
	public String lg_logintypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/login_logintype";
		return url;
	}

	// 로그인 - 복합형
	@RequestMapping("lg_multi")
	public String lg_multitypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/login_multitype";
		return url;
	}

	// 로그인 - 게시판형
	@RequestMapping("lg_board")
	public String lg_boardtypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/login_boardtype";
		return url;
	}

	// 로그인 - 메뉴형
	@RequestMapping("lg_menu")
	public String lg_menutypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/login_menutype";
		return url;
	}

	// 아이디 비번 찾기
	@RequestMapping("find_id_pw")
	public String findIdPwForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/find_id_pw";
		return url;
	}
	
	
	// 메인 - 로그인형
	@RequestMapping("acc_login")
	public String ac_logintypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/access_logintype";
		return url;
	}

	// 메인 - 복합형
	@RequestMapping("acc_multi")
	public String ac_multitypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/access_multitype";
		return url;
	}

	// 메인 - 게시판형
	@RequestMapping("acc_board")
	public String ac_boardtypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/access_boardtype";
		return url;
	}

	// 메인 - 메뉴형
	@RequestMapping("acc_menu")
	public String ac_menutypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/access_menutype";
		return url;
	}

	
	

}
