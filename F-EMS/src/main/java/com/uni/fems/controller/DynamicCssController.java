package com.uni.fems.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.ManageService;


/**
 * <pre>
 * CSS를 .css가 아닌 .jsp로 활용할 때
 * 사용되는 핸들러 Controller
 * </pre>
 * @author KJH
 * @since 2017. 02. 16
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자          수정내용
 * --------     --------    ----------------------
 * 2017.02.16     KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@Setter
public class DynamicCssController {
	
	@Autowired
	private ManageService manageService;
	
	
	/**
	 * <pre>
	 * Manager테이블에 있는 데이터를 dbCSS에서 활용할 수 있도록
	 * 연결해주는 메서드 
	 * </pre>
	 * <pre>
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/dynamicCss/menu.do")
	public String cssGenerator(/*Model model,*/HttpSession session){
		/*
		ManageVO manageVO=null;
		
		try {
			manageVO=manageService.getManage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("manageVO", manageVO);
		model.addAttribute("manageVO", manageVO);*/
		return "dynamicCss/dbCSS";
	}
}
