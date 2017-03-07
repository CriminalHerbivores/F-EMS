package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.Bbs_List_AtrtyVO;
import com.uni.fems.service.Bbs_ListService;
import com.uni.fems.service.Lctre_ActplnService;
import com.uni.fems.service.ManageService;

/**
 * <pre>
 * 제너레이터
 * </pre>
 * @author JAR
 * @since 2017. 3. 6.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 3. 6.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin")
public class Bbs_ListController{
	private WebApplicationContext context = null;

	@Autowired
	private Bbs_ListService bbs_ListSvc;
	@Autowired
	private Lctre_ActplnService lctre_ActplnSvc;
	@Autowired
	private ManageService manageService;
	
	/**
	 * <pre>
	 * 제너레이터로 만든 게시판 리스트
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("generatorList")
	public String generatorList(Model model){
		String url = "/school_management/generator";
		Bbs_List_AtrtyVO vo = new Bbs_List_AtrtyVO();
		List<Bbs_List_AtrtyVO> bbsListGen = new ArrayList<Bbs_List_AtrtyVO>();
		List<Bbs_List_AtrtyVO> noticeListGen = new ArrayList<Bbs_List_AtrtyVO>();
		try {
			vo.setBl_Table_Nm("b"); //학사 게시판
			noticeListGen=bbs_ListSvc.getBbs_List(vo);
			vo.setBl_Table_Nm("t"); //자유 게시판
			bbsListGen=bbs_ListSvc.getBbs_List(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("bbsListGen",bbsListGen);
		model.addAttribute("noticeListGen",noticeListGen);
		return url;
	}
	
	/**
	 * <pre>
	 * 게시판 테이블 생성을 위한 폼 이동
	 * </pre>
	 * <pre>
	 * @return url
	 * </pre>
	 * 
	 */
	@RequestMapping("generator")
	public String generatorForm() {
		String url = "/school_management/createGenerator";
		return url;
	}
	
	/**
	 * <pre>
	 * 각각에 맞게 게시판 생성
	 * </pre>
	 * <pre>
	 * @param model
	 * @param bbs_List_AtrtyVO
	 * @return url
	 * </pre>
	 * 
	 */
	@RequestMapping("insertTable")
	public String insertTable(HttpSession session, Bbs_List_AtrtyVO bbs_List_AtrtyVO) {
		String url = "redirect:generatorList";
		bbs_List_AtrtyVO.setBl_Table_Nm(bbs_List_AtrtyVO.getBa_Alpha()+System.currentTimeMillis());
		List<Bbs_ListVO> bbsList=null;
		List<Bbs_ListVO> noticeList=null;
		try {
			bbs_ListSvc.insertBbs_List_Atrty(bbs_List_AtrtyVO);
			bbsList=manageService.getBbsList("t");
			noticeList=manageService.getBbsList("b");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("bbsList", bbsList);
		session.setAttribute("noticeBBS", noticeList);
		return url;

	}
	
	/**
	 * <pre>
	 * 게시판 정보 수정 폼
	 * </pre>
	 * <pre>
	 * @param model
	 * @param bbs_List_AtrtyVO
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="updateTable", method = RequestMethod.GET)
	public String updateTable(Model model, Bbs_List_AtrtyVO bbs_List_AtrtyVO) {
		String url = "/school_management/updateGenerator";
		Bbs_List_AtrtyVO vo = new Bbs_List_AtrtyVO();
		try {
			vo = bbs_ListSvc.getBbs_List_Atrty(bbs_List_AtrtyVO.getBl_Bbs_No());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		vo.setBa_Alpha(bbs_List_AtrtyVO.getBa_Alpha());
		System.out.println(bbs_List_AtrtyVO.toString());
		
		model.addAttribute("bbs_List_AtrtyVO",vo);
		return url;
	}
	
	/**
	 * <pre>
	 * 게시판 정보 수정
	 * </pre>
	 * <pre>
	 * @param model
	 * @param bbs_List_AtrtyVO
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="updateTable", method = RequestMethod.POST)
	public String updateBbsTable(HttpSession session, Bbs_List_AtrtyVO bbs_List_AtrtyVO) {
		String url = "redirect:generatorList";
		List<Bbs_ListVO> bbsList=null;
		try {
			bbs_ListSvc.updateBbs_List(bbs_List_AtrtyVO);
			bbsList=manageService.getBbsList("t");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("bbsList", bbsList);

		return url;
	}
	
	/**
	 * <pre>
	 * 강의에 대한 제너레이터 생성(임시)
	 * </pre>
	 * <pre>
	 * @param model
	 * @param bbs_List_AtrtyVO
	 * @return url
	 * </pre>
	 * 
	 */
//	@RequestMapping("insertLctre_Table")
//	public String insertLctre_Table(Model model ) {
//		String url = "/school_management/generator";
//
//		try {
//			lctre_ActplnSvc.insertLctre_Table("test");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return url;
//
//	}

	
}
