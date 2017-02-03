package com.uni.fems.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
	
	
	@RequestMapping(value="/stdntInsert", method = RequestMethod.GET)
	String stdntInsertForm(){
		String url = "manager/student/stdntInsertForm";
		return url;
	}
	
/*	@RequestMapping(value="/stdntInsert", method = RequestMethod.POST)
	String stdntInsert(StdntVO stdntVO){
		String url = "redirect:/index";
		System.out.println("stdntVO : "+stdntVO);
		try {
			stdntService.insertStdnt(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}*/
	
	@RequestMapping(value="/stdntInsert", method = RequestMethod.POST)
	String stdntInsert(StdntVO stdntVO, @RequestParam String file, Model model){
		String url = "/manager/index";
		if(file != null && !file.equals("")){
			ReadOption ro = new ReadOption();
			ro.setFilePath(file);		//경로 입력
			ro.setOutputColumns("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S");	//배열 명 입력
			ro.setStartRow(2);
			
			List<Map<String, String>> result = ExcelRead.read(ro);
			
			for(Map<String, String> map : result) {
				stdntVO.setSt_Stdnt_No(map.get("A"));
				stdntVO.setSt_Subjct_Code(map.get("B"));
				stdntVO.setSt_Pw(map.get("C"));
				stdntVO.setSt_Nm(map.get("D"));
				stdntVO.setSt_Eng_Nm(map.get("E"));
				stdntVO.setSt_Ihidnum(map.get("F"));
				stdntVO.setSt_Moblphon_No(map.get("G"));
				stdntVO.setSt_House_Tlphon_No(map.get("H"));
				stdntVO.setSt_Entsch_Dt(map.get("I"));
				stdntVO.setSt_Prtctor_Nm(map.get("J"));
				stdntVO.setSt_Family_Relate(map.get("K"));
				stdntVO.setSt_Post_No(map.get("L"));
				stdntVO.setSt_Adres1(map.get("M"));
				stdntVO.setSt_Adres2(map.get("N"));
				stdntVO.setSt_Cnslt_At(map.get("O"));
				stdntVO.setSt_Email(map.get("P"));
				stdntVO.setSt_Brhs_At(map.get("Q"));
				stdntVO.setSt_Profsr_No(map.get("R"));
				stdntVO.setSt_Grdtn_Dt(map.get("S"));
				System.out.println(stdntVO);
				try {
					stdntService.insertStdnt(stdntVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}else{
			try {
				stdntService.insertStdnt(stdntVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return url;
	}
	
	@RequestMapping("/stdntList")
	public String stdntList(Model model,HttpServletRequest request) throws ServletException, IOException{
		String url="manager/student/stdntListForm";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		
		if (key ==null){
			key = "";
		}
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("key", key);
		model.addAttribute("tpage",tpage);
		
		List<StdntVO> stdntList = null;
		String paging = null;
		try {
			stdntList = stdntService.selectNameAllPage(Integer.parseInt(tpage), key);
			paging = stdntService.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("stdntList", stdntList);
		int n = stdntList.size();
		model.addAttribute("stdntListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
}
