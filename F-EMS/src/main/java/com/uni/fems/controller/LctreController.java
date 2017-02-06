package com.uni.fems.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.service.LctreService;

@Controller
@RequestMapping("/course")
public class LctreController {

	
//	@Autowired
//	LctreService lctreService;
	
	
	// 수강신청 메인
	@RequestMapping("/course_list")
	public String courseListForm(HttpServletRequest request, HttpSession session) {
		String url = "course_registration/course_list";
		return url;
	}

	// 수강신청 가능 목록
//	@RequestMapping("/course_able")
//	public String courseAbleForm(@RequestParam(value = "key", defaultValue = "") int key, Model model)
//			throws ServletException, IOException {
//		String url = "course_registration/course_able";
//		
//		ArrayList<LctreVO> lctreList = lctreService.getLctreList(key);				
//
//		model.addAttribute("lctreList", lctreList);
//		
//		
//		return url;
//	}
	
	@RequestMapping("/course_able")
	public String courseAbleForm(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/course_able";
		return url;
	}
	
	
	

	// 수강신청 완료 목록
	@RequestMapping("/course_complete")
	public String courseCompleteForm(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/course_complete";
		return url;
	}

	// 관심과목
	@RequestMapping("/course_interest")
	public String courseInterestForm(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/course_interest";
		return url;
	}

	// 수강가능학점
	@RequestMapping("/course_credit")
	public String courseCreditForm(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/course_credit";
		return url;
	}

	// 시간표
	@RequestMapping("/course_timetable")
	public String courseTimetableForm(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/course_timetable";
		return url;
	}

}
