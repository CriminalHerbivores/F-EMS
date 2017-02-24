package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dao.ReqstDAO;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.service.ReqstService;
import com.uni.fems.service.StdntService;

/**
 * <pre>
 * 개설된 강의를 관심 강의로 추가,삭제,목록확인 및 수강 신청,취소,수강완료목록을 담당하는 Controller
 * </pre>
 * @author KJH
 * @since 2017. 2. 21.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자       수정내용
 * --------     --------    ----------------------
 * 2017. 2. 21.   KJH         최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/course")
public class ReqstController {
	
	@Autowired
	private ReqstService reqstService;
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
	@RequestMapping("/courseComplete")
	public String courseCompleteForm(Model model, HttpServletRequest request,
			HttpSession session,ReqstVO reqstVO) {
		String url = "course_registration/courseComplete";
		
		List<Lctre_SearchVO> lctre_SearchVO=null;
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		try {
			reqstVO.setRe_Stdnt_No(st_Stdnt_No);
			lctre_SearchVO=reqstService.selectReqst(reqstVO.getRe_Stdnt_No());
			stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO",lctre_SearchVO);

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
	@RequestMapping("/courseCredit")
	public String courseCredit(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseCredit";
		//학생이 수강신청한 과목의 학점(맨 앞에것)값을 숫자로 읽어오고 합해준 다음에
		//한 학기에 수강할 수 있는 학점(학과마다 다름)을 빼준다
		//그 값을 조회해오면 되지 않을까...힘내라 나!!
		
		return url;
	}	
	
	
	
	
//	
//	
//	/**
//	 * <pre>
//	 * 관심 강의로 추가하는 폼
//	 * </pre>
//	 * <pre>
//	 * @param model
//	 * @param session
//	 * @return
//	 * @throws SQLException
//	 */
//	@RequestMapping(value="/intrstList", method=RequestMethod.GET)
//	public String courseCreditForm(Model model, HttpSession session) throws SQLException{
//		String url="course_registration/courseCredit";
//		
//		return url;
//	}
//	
//	
//	/**
//	 * <pre>
//	 * 관심강의 취소, 추가하는 로직
//	 * </pre>
//	 * <pre>
//	 * @param model
//	 * @param session
//	 * @return
//	 * @throws SQLException
//	 */
//	@RequestMapping(value="/intrstList", method=RequestMethod.GET)
//	public String courseCredit(Model model, HttpSession session) throws SQLException{
//		String url="course_registration/courseCredit";
//		
//		return url;
//	}
	
}
