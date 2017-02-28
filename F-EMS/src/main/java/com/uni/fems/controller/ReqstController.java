package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
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
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.service.Intrst_ListService;
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
	private Intrst_ListService intrst_ListService;
	@Autowired
	private StdntService stdntService;

	
	/**
	 * <pre>
	 * 수강신청 완료 목록 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseComplete",method=RequestMethod.GET)
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
	 * 수강 완료 목록에서 선택한 관심강의 및 수강신청을 삭제하는 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseComplete",method=RequestMethod.POST)
	public String deleteCourseComplete(HttpServletRequest request,
			HttpSession session, ReqstVO reqstVO, Intrst_ListVO intrst_ListVO, Lctre_SearchVO lctre_SearchVO) throws ServletException, IOException{
		String url = "redirect:courseComplete";
		
		String stdnt_No = (String) session.getAttribute("loginUser");
		
		String[] resultArr_1= request.getParameterValues("result_1");
		String[] resultArr_2= request.getParameterValues("result_2");

		// 수강신청하면 4개가 조회되어 나타남
		// 수강중인 학생수가 강의실 수용인원을 넘어가면 수강신청이 안 되어야 함
		
		
		if((resultArr_1==null&&resultArr_2!=null)||(resultArr_1!=null&&resultArr_2!=null)){
		for (int i = 0; i < resultArr_2.length; i++) { 
			reqstVO.setRe_Stdnt_No(stdnt_No);
			reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_2[i]));
			//reqstVO.setRe_Lctre_No(intrst_ListVO.getIn_Lctre_No());
			lctre_SearchVO.setRe_Lctre_No(reqstVO.getRe_Lctre_No());
			System.out.println("============== 11111111111 reqstVO.getRe_Lctre_No() "+reqstVO.getRe_Lctre_No());
			try {
				reqstService.deleteReqst(reqstVO,lctre_SearchVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		if(resultArr_1!=null&&resultArr_2 == null){
		for (int i = 0; i < resultArr_1.length; i++) {
			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
			try {
				intrst_ListService.deleteIntrst_List(intrst_ListVO);	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		}
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
	public String courseCredit(Model model,HttpServletRequest request,
			HttpSession session, ReqstVO reqstVO) {
		String url = "course_registration/courseCredit";
		int sumOfReqst =0;
		int ableOfReqst=18;
		
		String stdnt_No = (String) session.getAttribute("loginUser");
		try {
			reqstVO.setRe_Stdnt_No(stdnt_No);
			sumOfReqst=reqstService.getSumReqst(reqstVO);
			ableOfReqst=ableOfReqst-sumOfReqst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//학생이 수강신청한 과목의 학점(맨 앞에것)값을 숫자로 읽어오고 합해준 다음에
		//한 학기에 수강할 수 있는 학점(학과마다 다름)을 빼준다
		//그 값을 조회해오면 되지 않을까...힘내라 나!!
		
		model.addAttribute("sumOfReqst",sumOfReqst);
		model.addAttribute("ableOfReqst",ableOfReqst);
		
		return url;
	}	
	

	
	

	
}
