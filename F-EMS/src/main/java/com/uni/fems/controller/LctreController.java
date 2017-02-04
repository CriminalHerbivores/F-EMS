package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class LctreController {
	
	// 수강신청 메인
	@RequestMapping("/course_list")
	public String courseListForm(HttpServletRequest request,HttpSession session) {
		String url = "course_registration/course_list";	
		return url;
	}
	
	// 수강신청 가능 목록
	@RequestMapping("/course_able")
	public String courseAbleForm(HttpServletRequest request,HttpSession session) {
		String url = "course_registration/course_able";	
		return url;
	}
	
	//수강신청 완료 목록
	@RequestMapping("/course_complete")
	public String courseCompleteForm(HttpServletRequest request,HttpSession session) {
		String url = "course_registration/course_complete";	
		return url;
	}
	
	// 관심과목 및 수강 가능 학점
	@RequestMapping("/course_interest")
	public String courseInterestForm(HttpServletRequest request,HttpSession session) {
		String url = "course_registration/course_interest";	
		return url;
	}
	
	
	
	
	
}
