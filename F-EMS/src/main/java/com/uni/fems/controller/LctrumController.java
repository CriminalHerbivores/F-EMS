package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LctrumController {

	// 강의실 등록
	@RequestMapping("/add_classroom")
	public String add_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/add_classroom";
		return url;
	}

	// 강의실 수정
	@RequestMapping("/modify_classroom")
	public String modify_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/modify_classroom";
		return url;
	}

	// 강의실 설정
	@RequestMapping("/set_classroom")
	public String set_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/set_classroom";
		return url;
	}

}
