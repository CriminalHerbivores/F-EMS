package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.uni.fems.dto.Bbs_List_AtrtyVO;
import com.uni.fems.service.Bbs_ListService;
import com.uni.fems.service.Lctre_ActplnService;

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
@RequestMapping("/bbs_list")
public class Bbs_ListController{
	private WebApplicationContext context = null;

	@Autowired
	private Bbs_ListService bbs_ListSvc;
	@Autowired
	private Lctre_ActplnService lctre_ActplnSvc;
	
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
	public String insertTable(Model model, Bbs_List_AtrtyVO bbs_List_AtrtyVO) {
		String url = "redirect:generatorList";

		try {
			bbs_ListSvc.insertBbs_List_Atrty(bbs_List_AtrtyVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
	@RequestMapping("updateTable")
	public String updateTable(Model model, Bbs_List_AtrtyVO bbs_List_AtrtyVO) {
		String url = "/school_management/updateGenerator";

		try {
			bbs_ListSvc.insertBbs_List_Atrty(bbs_List_AtrtyVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
