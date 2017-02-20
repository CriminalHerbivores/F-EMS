package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.service.Schafs_SchdulService;

@Controller
@RequestMapping("/schafs_schdul")
public class Schafs_SchdulController {
	
	@Autowired
	Schafs_SchdulService schdulSvc;
	
	public void setSchdulSvc(Schafs_SchdulService schdulSvc) {
		this.schdulSvc = schdulSvc;
	}

	@RequestMapping(value="/schdulList")
	public String schdulList(Model model) throws ServletException, IOException{
	String url="schafs_schdul/schdulList";
	Map m = new HashMap<String, List<Schafs_SchdulVO>>();
	try {
		for(int i=1; i<=12; i++){
			List<Schafs_SchdulVO> list = schdulSvc.listSchdul(i);
			m.put(i, list);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for(int i=1;i<=12;i++){
		model.addAttribute("list"+i, m.get(i));
	}
	
	
	return url;
	}
	
	@RequestMapping(value="/insertSchdul", method=RequestMethod.POST)
	public String insertSchdul(Schafs_SchdulVO schdulVO, HttpServletRequest request) throws ServletException, IOException, ParseException{
		String url="redirect:schdulList";

		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
		schdulVO.setSd_Sklstf_No(loginUser);
	
		try {
			schdulSvc.insertSchdul(schdulVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
		
		
	}
	
	@RequestMapping(value="/updateSchdul",method=RequestMethod.POST)
	public String updateSchdul(HttpServletRequest request, Schafs_SchdulVO schdulVO) throws ServletException, IOException{
		String url = "redirect:schdulList";
		
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		schdulVO.setSd_Sklstf_No(loginUser);
		
		try {
			schdulSvc.updateSchdul(schdulVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
		
	}
	
	@RequestMapping(value="/deleteSchdul",method=RequestMethod.POST)
	public String deleteSchdul(HttpServletRequest request, @RequestParam int sd_No)throws ServletException, IOException{
		String url = "redirect:schdulList";
		
		
		try {
			schdulSvc.deleteSchdul(sd_No);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	
	
	
	
}
