package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.service.Intrst_ListService;
import com.uni.fems.service.ReqstService;
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
 * 2017. 2. 24.    KJH       최초작성
 * 2017. 2. 25.    KJH       추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/course")
public class Intrst_ListController {
	
	@Autowired
	private Intrst_ListService intrst_ListService;
	@Autowired
	private ReqstService reqstService;
	@Autowired
	private StdntService stdntService;
	
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
	@RequestMapping(value="/courseInterest",method=RequestMethod.GET)
	public String courseInterestForm(Model model, HttpSession session,Intrst_ListVO intrst_ListVO) throws ServletException, IOException{
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
	 * 관심 강의 목록에서 선택한 관심강의를 삭제하는 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseInterest",method=RequestMethod.POST)
	public String deleteCourseInterest(HttpServletRequest request,
			HttpSession session, Intrst_ListVO intrst_ListVO, ReqstVO reqstVO) throws ServletException, IOException{
		String url = "redirect:courseInterest";

		String stdnt_No = (String) session.getAttribute("loginUser");
		String[] resultArr = request.getParameterValues("result");
		String ck_result = request.getParameter("btn_result");
		System.out.println("==============1111111111  ck_result  "+ck_result);
		System.out.println("=========================11111111 in_Lctre_No "+intrst_ListVO.getIn_Lctre_No());
		// 값은 받아오는데 왜 if문 안으로 들어오지 못할까? if문 내부는 잘 돌아가는거 확인함(신청하는대로 잘 들어감)
		
//		if(ck_result=="addReqst"){
//			for (int i = 0; i < resultArr.length; i++) {
//				System.out.println("==============222222222222  ck_result  "+ck_result);
//				reqstVO.setRe_Stdnt_No(stdnt_No);
//				reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr[i]));
//				try {
//					reqstService.insertReqst(reqstVO);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}else if(ck_result=="delIntrst"){
			for (int i = 0; i < resultArr.length; i++) {
				System.out.println("==============333333333333  ck_result  "+ck_result);
				System.out.println("=========================2222222222 in_Lctre_No "+intrst_ListVO.getIn_Lctre_No());
				intrst_ListVO.setIn_Stdnt_No(stdnt_No);
				intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr[i]));
				System.out.println("=========================333333333 in_Lctre_No " +intrst_ListVO.getIn_Lctre_No());
				try {
					intrst_ListService.deleteIntrst_List(intrst_ListVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
//			}
		}

		// lctreController.courseListForm();//호출 되려나
		return url;	
		}
	
	
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
