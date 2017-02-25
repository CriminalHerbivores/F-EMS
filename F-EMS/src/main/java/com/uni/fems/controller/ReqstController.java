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
			HttpSession session, ReqstVO reqstVO, Intrst_ListVO intrst_ListVO) throws ServletException, IOException{
		String url = "redirect:courseComplete";
		
		String stdnt_No = (String) session.getAttribute("loginUser");
		
		String[] resultArr_1= request.getParameterValues("result_1");
		String[] resultArr_2= request.getParameterValues("result_2");
		
		// 둘 동시에 지우면 괜찮은데 둘 중 하나만 지울경우 널포인트 에러
		//혹시 지금 쿼리가 연결되어서 그런가? -- 조회라 상관없을듯
		
		for (int i = 0; i < resultArr_2.length; i++) { //관심 목록만 삭제시 여기서 에러+위에 있으면 값 삭제안되고 아래에 있으면 삭제됨...혹은 반대거나
			reqstVO.setRe_Stdnt_No(stdnt_No);
			reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
			
			try {
				reqstService.deleteReqst(reqstVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < resultArr_1.length; i++) { // 수강완료만 삭제시 여기서 에러+위에 있으면 값 삭제안되고 아래에 있으면 삭제됨
			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
			try {
				intrst_ListService.deleteIntrst_List(intrst_ListVO);	// 관심강의를 삭제하려면 수강신청도 삭제해야 하도록 하기
				//Intrst_ListController intrst_ListController= new Intrst_ListController();
				//intrst_ListController.courseInterestForm(model, session, intrst_ListVO);
			} catch (SQLException e) {
				e.printStackTrace();
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
	public String courseCredit(HttpServletRequest request,
			HttpSession session) {
		String url = "course_registration/courseCredit";
		//학생이 수강신청한 과목의 학점(맨 앞에것)값을 숫자로 읽어오고 합해준 다음에
		//한 학기에 수강할 수 있는 학점(학과마다 다름)을 빼준다
		//그 값을 조회해오면 되지 않을까...힘내라 나!!
		
		return url;
	}	
	

	
	

	
}
