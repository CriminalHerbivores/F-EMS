package com.uni.fems.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dao.ReqstDAO;
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
<<<<<<< HEAD
//@RequestMapping("/stdnt")
//@Data
public class ReqstController {
	
//	@Autowired
//	private ReqstService reqstService;
//	
//	@Autowired
//	private ReqstDAO reqstDAO; 
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
=======
@RequestMapping("/stdnt")
@Data
public class ReqstController {
	
	@Autowired
	private ReqstService reqstService;
	
	@Autowired
	private ReqstDAO reqstDAO; 
	
	
	/**
	 * <pre>
	 * 관심 강의로 추가하는 폼
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value="/intrstList", method=RequestMethod.GET)
	public String courseCreditForm(Model model, HttpSession session) throws SQLException{
		String url="course_registration/courseCredit";
		
		return url;
	}
	
	
	/**
	 * <pre>
	 * 관심강의 취소, 추가하는 로직
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value="/intrstList", method=RequestMethod.POST)
	public String courseCredit(Model model, HttpSession session) throws SQLException{
		String url="course_registration/courseCredit";
		
		return url;
	}
>>>>>>> branch 'kjh' of https://github.com/CriminalHerbivores/F-EMS.git
	
}
