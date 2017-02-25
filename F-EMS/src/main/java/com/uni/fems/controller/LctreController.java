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

import com.uni.fems.common.Paging;
import com.uni.fems.dto.Intrst_ListVO;
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
	@Autowired
	private Paging callPaging;
	
	
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
	public String courseAbleForm(Model model, HttpSession session, HttpServletRequest request, SearchVO searchVO, Intrst_ListVO intrst_ListVO, ReqstVO reqstVO) {
		String url = "course_registration/courseAble";
		
		String stdnt_No = (String) session.getAttribute("loginUser");
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
		
		int view_rows = 10; //페이지의 개수
		int counts = 10; //한 페이지에 나타낼 개수
		
		try {
			int totalRecord = lctreService.countLctreList(Integer.parseInt(tpage), searchVO);
			paging = callPaging.pageNumber(Integer.parseInt(tpage)
					,totalRecord,"courseAble", "&key="+searchVO.getKey()+"&value="+searchVO.getValue()
					,view_rows,counts);
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord,view_rows,counts);
			openLctreList = lctreService.openLctreList(searchVO,rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("openLctreList", openLctreList);
		int n = openLctreList.size();
		model.addAttribute("openLctreListSize", n);
		model.addAttribute("paging", paging);
		//--------------------------------------------------------------------
		
		String[] resultArr_1= request.getParameterValues("result_1");
		
		String[] resultArr_2= request.getParameterValues("result_2");
		
		System.out.println("1111111111111111111111111 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
		// 이제 왜 강의번호가 0만 들어가는지 해결해야 하겠지...
		// if문이나 for문 안에는 매우 잘 들어오고 있음
		
		System.out.println("22222222222222222222222");
		if((resultArr_1 == null && resultArr_2 != null) || (resultArr_1 != null && resultArr_2 != null)){	// 수강만 체크하거나 관심과 수강 둘 다 체크
			System.out.println("33333333333333333 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
		for (int i = 0; i < resultArr_2.length; i++) { 
			System.out.println("44444444444 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No()); // 사실상 여기서는 값이 들어가야 하는데...!!!!!!!!!!
			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_2[i]));
			reqstVO.setRe_Stdnt_No(stdnt_No);
			reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
			System.out.println("5555555555555555 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
			try {
				reqstService.insertReqst(reqstVO);	// 수강신청 하면 관심강의에도 등록되도록 하기
				intrst_ListService.insertIntrst_List(intrst_ListVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("6666666666666 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
		}
		}
		
		if(resultArr_1!=null && resultArr_2 == null){	//관심만 체크
			System.out.println("777777777777 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
		for (int i = 0; i < resultArr_1.length; i++) { 
			System.out.println("88888888888888888888 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
			System.out.println("9999999999999 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
			try {
				intrst_ListService.insertIntrst_List(intrst_ListVO);	
				//Intrst_ListController intrst_ListController= new Intrst_ListController();
				//intrst_ListController.courseInterestForm(model, session, intrst_ListVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		System.out.println("101010101010101010 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
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
//	@RequestMapping(value="/courseAble", method=RequestMethod.POST)
//	public String insertCourse(Model model, SearchVO searchVO,HttpServletRequest request,
//		HttpSession session, ReqstVO reqstVO, Intrst_ListVO intrst_ListVO) throws ServletException, IOException{
//		
//		String url = "redirect:courseAble";
		
		//courseAbleForm(model, request, searchVO);
		
		/*
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
		*/
		//------------------------------------------------------------------------------
		
//		String stdnt_No = (String) session.getAttribute("loginUser");
//		
//		String[] resultArr_1= request.getParameterValues("result_1");
//		String[] resultArr_2= request.getParameterValues("result_2");
//		System.out.println("1111111111111111111111111 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//		// 이제 왜 강의번호가 0만 들어가는지 해결해야 하겠지...
//		
//		System.out.println("22222222222222222222222");
//		if(resultArr_2 != null || (resultArr_1 != null&&resultArr_2 != null)){	// 수강만 체크하거나 관심과 수강 둘 다 체크
//			System.out.println("33333333333333333 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//		for (int i = 0; i < resultArr_2.length; i++) { 
//			System.out.println("44444444444 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
//			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_2[i]));
//			reqstVO.setRe_Stdnt_No(stdnt_No);
//			reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
//			System.out.println("5555555555555555 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//			try {
//				reqstService.insertReqst(reqstVO);	// 수강신청 하면 관심강의에도 등록되도록 하기
//				intrst_ListService.insertIntrst_List(intrst_ListVO);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			System.out.println("6666666666666 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//		}
//		}
//		
//		if(resultArr_1!=null && resultArr_2 == null){	//관심만 체크
//			System.out.println("777777777777 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//		for (int i = 0; i < resultArr_1.length; i++) { 
//			System.out.println("88888888888888888888 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//			intrst_ListVO.setIn_Stdnt_No(stdnt_No);
//			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
//			System.out.println("9999999999999 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//			try {
//				intrst_ListService.insertIntrst_List(intrst_ListVO);	
//				//Intrst_ListController intrst_ListController= new Intrst_ListController();
//				//intrst_ListController.courseInterestForm(model, session, intrst_ListVO);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		}
//		System.out.println("101010101010101010 수강신청" +reqstVO.getRe_Lctre_No()+"//// 관심 "+intrst_ListVO.getIn_Lctre_No());
//		return url;
//
//	}

}
