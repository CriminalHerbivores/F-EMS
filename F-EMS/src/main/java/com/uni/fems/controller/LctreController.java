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
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Intrst_ListService;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.ReqstService;
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
	@Autowired
	private Intrst_ListService intrst_ListService;
	@Autowired
	private ReqstService reqstService;
	
	
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
	
		return url;
	}
	
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
	public String courseAbleForm(Model model, HttpServletRequest request, SearchVO searchVO) {
		String url = "course_registration/courseAble";
		
		String tpage = request.getParameter("tpage");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		if(searchVO.getValue()==null)
			searchVO.setValue("");
		if(searchVO.getKey()==null)
			searchVO.setKey("lu_Lctre_Nm");
		
		List<Lctre_SearchVO> openLctreList=null;
		String paging=null;
		
		try {
			openLctreList = lctreService.openLctreList(Integer.parseInt(tpage), searchVO);
			paging = lctreService.pageNumber(Integer.parseInt(tpage), searchVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("openLctreList", openLctreList);
		int n = openLctreList.size();
		model.addAttribute("openLctreListSize", n);
		model.addAttribute("paging", paging);
		return url;
	}
	
	

	/**
	 * <pre>
	 * 개설강의 목록에서 수강신청,관심강의 추가가 가능한 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @param intrst_ListVO
	 * @param reqstVO
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/courseAble", method=RequestMethod.POST)
	public String insertCourse(HttpServletRequest request,
			HttpSession session, ReqstVO reqstVO, Intrst_ListVO intrst_ListVO) throws ServletException, IOException{
		
		String url = "redirect:courseAble";
		String stdnt_No = (String) session.getAttribute("loginUser");
		
		String[] resultArr_1= request.getParameterValues("result_1");
		String[] resultArr_2= request.getParameterValues("result_2");
		
		// 둘 동시에 지우면 괜찮은데 둘 중 하나만 지울경우 널포인트 에러
		// 지금 전혀 추가가 안되는데...
		
		for (int i = 0; i < resultArr_2.length; i++) { //관심 목록만 삭제시 여기서 에러+위에 있으면 값 삭제안되고 아래에 있으면 삭제됨...혹은 반대거나
			reqstVO.setRe_Stdnt_No(stdnt_No);
			reqstVO.setRe_Lctre_No(resultArr_2[i]);
			
			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
			intrst_ListVO.setIn_Lctre_No(resultArr_2[i]);
			
			try {
				reqstService.insertReqst(reqstVO);	// 수강신청 하면 관심강의에도 등록되도록 하기
				intrst_ListService.insertIntrst_List(intrst_ListVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < resultArr_1.length; i++) { // 수강완료만 삭제시 여기서 에러+위에 있으면 값 삭제안되고 아래에 있으면 삭제됨
			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
			intrst_ListVO.setIn_Lctre_No(resultArr_1[i]);
		
			try {
				intrst_ListService.insertIntrst_List(intrst_ListVO);	
				//Intrst_ListController intrst_ListController= new Intrst_ListController();
				//intrst_ListController.courseInterestForm(model, session, intrst_ListVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return url;

	}

}
