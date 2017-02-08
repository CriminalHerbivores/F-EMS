package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UsersController {

	// 메인 - 로그인형
	@RequestMapping("type_login")
	public String logintypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/layout_logintype";
		return url;
	}

	// 메인 - 복합형
	@RequestMapping("type_multi")
	public String multitypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/layout_multitype";
		return url;
	}

	// 메인 - 게시판형
	@RequestMapping("type_board")
	public String boardtypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/layout_boardtype";
		return url;
	}

	// 메인 - 메뉴형
	@RequestMapping("type_menu")
	public String menutypeForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/layout_menutype";
		return url;
	}

	// 아이디 비번 찾기
	@RequestMapping("find_id_pw")
	public String findIdPwForm(HttpServletRequest request, HttpSession session) {
		String url = "layout_type/find_id_pw";
		return url;
	}
	
	


	
	

}
