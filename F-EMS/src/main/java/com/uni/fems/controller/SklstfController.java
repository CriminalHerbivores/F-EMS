package com.uni.fems.controller;


import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dto.SklstfVO;
import com.uni.fems.service.ProfsrService;
import com.uni.fems.service.SklstfService;
import com.uni.fems.service.StdntService;


@Controller
@RequestMapping("/sklstf")
public class SklstfController {

	@Autowired
	private SklstfService sklstfService;
	public void setSklstfService(SklstfService sklstfService) {
		this.sklstfService = sklstfService;
	}
	@Autowired
	private StdntService stdntService;
	public void setStdntService(StdntService stdntService) {
		this.stdntService = stdntService;
	}
	@Autowired
	private ProfsrService profsrService;
	public void setProfsrService(ProfsrService profsrService) {
		this.profsrService = profsrService;
	}
	
	@RequestMapping(value="/sklstfUpdate", method = RequestMethod.GET)
	public String sklstfUpdateForm(HttpSession session, Model model){
		String url = "manager/sklstfUpdateForm";
		String userid = (String)session.getAttribute("userid");
		SklstfVO sklstfVO = null;
		try {
			sklstfVO = sklstfService.getSklstf(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("sklstfVO", sklstfVO);
		return url;
	}
	
	@RequestMapping(value="/sklstfUpdate", method = RequestMethod.POST)
	public String sklstfUpdate(SklstfVO sklstfVO){
		String url = "/manager/index";
		
		try {
			sklstfService.updateSklstf(sklstfVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value="stdntBrhs", method = RequestMethod.GET)
	public String stdntBrhs(){
		String url ="manager/student/";
		return url;
	}
	@RequestMapping(value="stdntBrhs", method = RequestMethod.POST)
	public String updatestdntBrhs(){
		String url ="";
		return url;
	}
}
