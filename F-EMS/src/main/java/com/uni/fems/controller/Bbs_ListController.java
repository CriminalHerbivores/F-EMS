package com.uni.fems.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.uni.fems.dto.Bbs_List_AtrtyVO;
import com.uni.fems.service.Bbs_ListService;
import com.uni.fems.service.Lctre_ActplnService;

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
	 * 게시판 테이블 생성읠 위한 폰 이동(임시)
	 * </pre>
	 * <pre>
	 * @return url
	 * </pre>
	 * 
	 */
	@RequestMapping("generator")
	public String generatorForm() {
		String url = "/school_management/generator";
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
		String url = "/school_management/generator";

		try {
			bbs_ListSvc.insertBbs_List_Atrty(bbs_List_AtrtyVO);	//諛쏆븘??name濡??뚯씠釉??앹꽦
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
	@RequestMapping("insertLctre_Table")
	public String insertLctre_Table(Model model ) {
		String url = "/school_management/generator";

		try {
			lctre_ActplnSvc.insertLctre_Table("test");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;

	}

	
}
