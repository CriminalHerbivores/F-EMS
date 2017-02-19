package com.uni.fems.controller;

import java.sql.SQLException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.uni.fems.dto.Bbs_List_AtrtyVO;
import com.uni.fems.service.Bbs_ListService;

@Controller
@RequestMapping("/bbs_list")
public class Bbs_ListController{

	private WebApplicationContext context = null;

	@Autowired
	private Bbs_ListService bbs_ListSvc;
	public void setNotice_BbsSvc(Bbs_ListService bbs_ListSvc) {
		this.bbs_ListSvc = bbs_ListSvc;
	}
	
	
	@RequestMapping("generator")
	public String generatorForm() {
		String url = "/school_management/generator";
		return url;
	}
	@RequestMapping("insertTable")
	public String insertTable(Model model, Bbs_List_AtrtyVO bbs_List_AtrtyVO) {
		System.out.println("bbs_List_AtrtyVO : "+bbs_List_AtrtyVO);
		String url = "/school_management/generator";

		try {
			bbs_ListSvc.insertBbs_List_Atrty(bbs_List_AtrtyVO);	//諛쏆븘??name濡??뚯씠釉??앹꽦
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;

	}

}
