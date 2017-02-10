package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BuildingController {

	// 건물 등록
	@RequestMapping("/buildingInsert")
	public String buildingInsert(HttpServletRequest request, HttpSession session) {
		String url = "admin/admin_page/buildingInsert";
		return url;
	}

	// 건물 수정
	@RequestMapping("/buildingUpdate")
	public String buildingUpdate(HttpServletRequest request, HttpSession session) {
		String url = "admin/admin_page/buildingUpdate";
		return url;
	}

}
