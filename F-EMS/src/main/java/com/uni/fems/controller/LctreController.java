package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dao.impl.LctreDAOImpl;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.service.LctreService;

@Controller
@RequestMapping("/course")
public class LctreController {

	
	@Autowired
	LctreService lctreService;
	
	
	// 수강신청 메인
	@RequestMapping("/courseList")
	public String courseList(HttpServletRequest request, HttpSession session) {
		String url = "course_registration/courseList";
		
//		Lctre_SearchVO lctre_SearchVO = lctreService.insertLctre_Search();
//		lctre_SearchVO=  lctreService.updateLctre_Search(lctre_SearchVO, request);
//		
//		LctreDAO lctreDAO = LctreDAOImpl.getInstance();
//		
//		ArrayList<LctreVO> lctreList = null;
//		
//
//		try {
//			lctreList = lctreDAO.listLctre(lctre_SearchVO);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		request.setAttribute("lctreList", lctreList);
		//request.setAttribute("order", lctre_SearchVO.getColumn());
		
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
	
	@RequestMapping("/courseAble")
	public String courseAble(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseAble";
		return url;
	}
	
	
	

	// 수강신청 완료 목록
	@RequestMapping("/courseComplete")
	public String courseComplete(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseComplete";
		return url;
	}

	// 관심과목
	@RequestMapping("/courseInterest")
	public String courseInterest(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseInterest";
		return url;
	}

	// 수강가능학점
	@RequestMapping("/courseCredit")
	public String courseCredit(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseCredit";
		return url;
	}

	// 시간표
	@RequestMapping("/courseTimetable")
	public String courseTimetable(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseTimetable";
		return url;
	}

}
