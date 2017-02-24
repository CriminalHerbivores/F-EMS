package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.service.Intrst_ListService;
import com.uni.fems.service.StdntService;

/**
 * <pre>
 * 관심 강의로 조회, 추가, 삭제가 가능한 ServiceImpl
 * </pre>
 * @author KJH
 * @since 2017. 2. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017. 2. 24.   KJH           최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/course")
public class Intrst_ListController {
	
	@Autowired
	Intrst_ListService intrst_ListService;
	@Autowired
	StdntService stdntService;
	
	/**
	 * <pre>
	 * 관심 강의 목록 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/courseInterest")
	public String courseInterestForm(Model model, HttpServletRequest request,
			HttpSession session,Intrst_ListVO intrst_ListVO) {
		String url = "course_registration/courseInterest";
		
		List<Lctre_SearchVO> lctre_SearchVO=null;
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		try {
			intrst_ListVO.setIn_Stdnt_No(st_Stdnt_No);
			lctre_SearchVO=intrst_ListService.selectIntrst_List(intrst_ListVO.getIn_Stdnt_No());
			stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO",lctre_SearchVO);

		return url;
	}
	
	
	/**
	 * <pre>
	 * 관심 강의 목록에서 관심강의를 삭제하는 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseInterest",method=RequestMethod.POST)
	public String courseInterest(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseInterest";
		
		return url;
	}
	
	
	
}
