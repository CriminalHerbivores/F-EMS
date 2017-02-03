package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class LctreController {

	@RequestMapping("/course_list")
	public String loginForm(HttpServletRequest request,HttpSession session) {
		String url = "course_registration/course_list";	
		return url;
	}
}
