package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dto.BaskinVO;
import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.BaskinService;
@Controller
@RequestMapping("baskin")
public class BaskinController {
	@Autowired
	private BaskinService baskinService;
	
	@RequestMapping(value="/robbins", method = RequestMethod.GET)
	public String getBaskin(Model model,HttpServletRequest request,HttpSession session){
		String url = "dynamicCss/baskin";
		/*
		if(session.getAttribute("baskin")!=null){
			BaskinVO baskin = (BaskinVO) session.getAttribute("baskin");
			ManageVO vo = (ManageVO) request.getAttribute("manageVO");
			vo.setMng_Main_Color(baskin.getBskn_Main());
			vo.setMng_Sub_Color1(baskin.getBskn_Sub1());
			vo.setMng_Sub_Color2(baskin.getBskn_Sub2());
		}
		*/
		List<BaskinVO> list = null;
		try {
			list = baskinService.getBaskin();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("baskin",list);
		return url;
	}
	@RequestMapping(value="/robbins", method = RequestMethod.POST)
	public String getThemeBaskin(BaskinVO baskin,HttpServletRequest request,HttpSession session){
		String url = "redirect:robbins";
		/*
		ManageVO vo = new ManageVO();
		vo.setMng_Main_Color(baskin.getBskn_Main());
		vo.setMng_Sub_Color1(baskin.getBskn_Sub1());
		vo.setMng_Sub_Color2(baskin.getBskn_Sub2());
		request.setAttribute("baskin", vo);
		*/
		
		try {
			baskinService.setBaskin(baskin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
}
