package com.uni.fems.controller;


import java.io.IOException;
import java.sql.SQLException;
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

import com.sun.tracing.dtrace.Attributes;
import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
import com.uni.fems.service.StdntService;

@Controller
@RequestMapping("stdnt")
public class StdntController {

	@Autowired
	private StdntService stdntService;
	public void setStdntService(StdntService stdntService) {
		this.stdntService = stdntService;
	}
	
	@RequestMapping(value="/stdntUpdate", method = RequestMethod.GET)
	public String stdntUpdateForm(@RequestParam String st_Stdnt_No,Model model) throws ServletException, IOException{
		String url="manager/student/stdntUpdate";
		
		StdntVO stdntVO = null;
		try {
			stdntVO = stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("stdntVO", stdntVO);
		return url;
		
	}
	@RequestMapping(value="/stdntUpdate", method = RequestMethod.POST)
	public String stdntUpdate(StdntVO stdntVO, Model model) throws ServletException, IOException{
		String url="redirect:stdntDetail";
		
		try {
			stdntService.updateStdnt(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("st_Stdnt_No",stdntVO.getSt_Stdnt_No());
		return url;
		
	}
	
	@RequestMapping(value="/atBrhs", method = RequestMethod.GET)
	public String atBrhs(Model model, HttpSession session){
		String url="student/registBrhs";
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		
		StdntVO stdntVO = null;
		try {
			stdntVO = stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("stdntVO", stdntVO);
		return url;
	}
	@RequestMapping(value="/atBrhs", method = RequestMethod.POST)
	public String registBrhs(StdntVO stdntVO){
		String url="redirect:atBrhs";
		stdntVO.setSt_Brhs_At("신청");
		
		System.out.println(stdntVO.getSt_Stdnt_No());
		
		try {
			stdntService.registBrhs(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
}
