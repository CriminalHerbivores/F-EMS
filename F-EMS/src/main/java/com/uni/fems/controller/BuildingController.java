package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BuildingController {

	// 건물 등록
	@RequestMapping("/add_building")
	public String admin_mainForm(HttpServletRequest request, HttpSession session) {
		String url = "admin/admin_page/add_building";
		return url;
	}

	// 건물 수정
	@RequestMapping("/modify_building")
	public String admin_joinForm(HttpServletRequest request, HttpSession session) {
		String url = "admin/admin_page/modify_building";
		return url;
	}

}
