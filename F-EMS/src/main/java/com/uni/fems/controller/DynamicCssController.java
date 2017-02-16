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


@Controller
@Setter
public class DynamicCssController {
	
	@Autowired
	private ManageService manageService;
	
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
