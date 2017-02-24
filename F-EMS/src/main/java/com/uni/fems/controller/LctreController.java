package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dao.impl.LctreDAOImpl;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.StdntService;

/**
 * <pre>
 * 강의와 관련된 Controller
 * 수강신청 관련 기능, 강의등록, 강의수정 등
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자          수정내용
 * --------     --------    ----------------------
 * 2017.01.24     KJH            최초작성
 * 2017.01.30     KJH            추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/course")
public class LctreController {

	
	
	@Autowired
	private LctreService lctreService;
	
	@Autowired
	private StdntService stdntService;
	
	
	
	/**
	 * <pre>
	 * 개설강의목록, 수강신청완료목록, 관심강의목록, 신청가능학점을 한번에 확인가능한 메인 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseList", method=RequestMethod.GET)
	public String courseListForm(HttpServletRequest request, HttpSession session) {
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
//			lctreList = lctreDAO.openLctreList(lctre_SearchVO);
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
	
	/**
	 * <pre>
	 * 수강신청이 가능한 개설강의목록 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseAble", method=RequestMethod.GET)
	public String courseAbleForm(Model model, HttpSession session, String lu_Lctre_Nm) {
		String url = "course_registration/courseAble";
		
		List<Lctre_SearchVO> lctre_SearchVO=null;
		
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		System.out.println("=======================================st_Stdnt_No : "+st_Stdnt_No);
		
		
		try {
			lctre_SearchVO = lctreService.openLctreList(lu_Lctre_Nm);
			stdntService.selectStdnt(st_Stdnt_No);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//lctre_SearchVO=lctreService.openLctreList(lu_Lctre_Nm);
		
		model.addAttribute("lctre_SearchVO", lctre_SearchVO);
		return url;
	}
	
	
	
	
	/**
	 * <pre>
	 * 개설강의 목록에서 수강신청 및 관심강의 등록이 가능한 로직
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session
	 * @param lu_Lctre_Nm
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseAble", method=RequestMethod.POST)
	public String courseAble(Model model, HttpSession session,String lu_Lctre_Nm) {
		String url = "course_registration/courseAble";
		
		List<Lctre_SearchVO> lctre_SearchVO=null;
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		System.out.println("=======================================st_Stdnt_No : "+st_Stdnt_No);
		
		try {
			lctre_SearchVO = lctreService.openLctreList(lu_Lctre_Nm);
			stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//lctre_SearchVO=lctreService.openLctreList(lu_Lctre_Nm);
		
		model.addAttribute("lctre_SearchVO", lctre_SearchVO);
		return url;
	}
	
	
	



	/**
	 * <pre>
	 * 학기내 이수 가능 학점 및 수강신청완료학점 확인 가능
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
//	@RequestMapping("/courseCredit")
//	public String courseCredit(HttpServletRequest request,
//			HttpSession session) {
//		String url = "course_registration/courseCredit";
//		return url;
//	}

	/**
	 * <pre>
	 * 관심강의 목록을 바탕으로 작성되는 임시 시간표
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
//	@RequestMapping("/courseTimetable")
//	public String courseTimetable(HttpServletRequest request,
//			HttpSession session) {
//		String url = "course_registration/courseTimetable";
//		return url;
//	}

}
