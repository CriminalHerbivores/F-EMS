package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
	@RequestMapping(value="/courseAble",method=RequestMethod.GET)
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
	public String insertCourse(Model model, SearchVO searchVO,HttpServletRequest request,
		HttpSession session, ReqstVO reqstVO, Intrst_ListVO intrst_ListVO, Lctre_SearchVO lctre_SearchVO) throws ServletException, IOException, SQLIntegrityConstraintViolationException{
		String url = "redirect:courseAble";
		
		String stdnt_No = (String) session.getAttribute("loginUser");
		String[] resultArr_1= request.getParameterValues("result_1");	// 관심
		String[] resultArr_2= request.getParameterValues("result_2");	// 수강
		
		if(resultArr_1 !=null){
			for (int i = 0; i < resultArr_1.length; i++) { 
				if(resultArr_1[i] !=null){	// 관심만 추가한 경우
					intrst_ListVO.setIn_Stdnt_No(stdnt_No);
					intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
					
					System.out.println("============1111111  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()
							+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());

					try {
						intrst_ListService.insertIntrst_List(intrst_ListVO);	
						System.out.println("===================222222  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		}
			
		if(resultArr_2 !=null){
		for (int i = 0; i < resultArr_2.length; i++) { 
			if(resultArr_2[i] !=null){	// 강의 추가한 경우
				System.out.println("===================33333333  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
			reqstVO.setRe_Stdnt_No(stdnt_No);
			reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
			lctre_SearchVO.setLc_Lctre_No(reqstVO.getRe_Lctre_No());
			lctre_SearchVO.setRe_Lctre_No(reqstVO.getRe_Lctre_No());
			System.out.println("===================4444444  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());

			try {
				reqstService.insertReqst(reqstVO,lctre_SearchVO);	// 수강신청 하면 관심강의에도 등록되도록 하기
				System.out.println("===================555555555 reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
				System.out.println("===================66666666  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
				
				intrst_ListService.insertIntrst_List(intrst_ListVO);
				System.out.println("===================77777777  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
			} catch (SQLException e) {
				e.printStackTrace();

			}
			
			}

			}
		}
			}
		
		return url;

	
		
		
	}

}
