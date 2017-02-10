package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LctrumController {

	// 강의실 등록
	@RequestMapping("/lctrumInsert")
	public String add_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/lctrumInsert";
		return url;
	}

	// 강의실 수정
	@RequestMapping("/lctrumUpdate")
	public String modify_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/lctrumUpdate";
		return url;
	}

	// 강의실 설정
	@RequestMapping("/lctrumUseUpdate")
	public String set_classroomForm(HttpServletRequest request,
			HttpSession session) {
		String url = "admin/admin_page/lctrumUseUpdate";
		return url;
	}

}
