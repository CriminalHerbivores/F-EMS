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

import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
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
	
	@RequestMapping("/stdntDetail")
	public String stdntDitail(@RequestParam String st_Stdnt_No,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="manager/student/stdntDetail";
		
		model.addAttribute("tpage",tpage);
		
		StdntVO stdntVO = null;
		try {
			stdntVO = stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("stdntVO", stdntVO);
		return url;
		
	}
	
	@RequestMapping(value="/stdntUpdate", method = RequestMethod.GET)
	public String stdntUpdateForm(@RequestParam String st_Stdnt_No,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="manager/student/stdntUpdate";
		
		model.addAttribute("tpage",tpage);
		
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
	public String stdntUpdate(StdntVO stdntVO,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="redirect:stdntDetail";
		
		System.out.println(" stdntVO : "+stdntVO);
		try {
			stdntService.updateStdnt(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("st_Stdnt_No",stdntVO.getSt_Stdnt_No());
		model.addAttribute("tpage",tpage);
		return url;
		
	}
	
	//==============================================================================
	// 관리자 가입
		@RequestMapping("/adminJoin")
		public String admin_joinForm(HttpServletRequest request,HttpSession session) {
			String url = "admin/admin_management/admin_join";	
			return url;
		}
}
