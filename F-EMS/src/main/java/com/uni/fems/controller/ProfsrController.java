package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.ProfsrService;

@Controller
@RequestMapping("/profsr")
public class ProfsrController {

	@Autowired
	private ProfsrService profsrService;

	@RequestMapping(value = "/profsrInsert", method = RequestMethod.GET)
	String profsrInsertForm() {
		String url = "manager/profsr/profsrInsertForm";
		return url;
	}

	@RequestMapping(value = "/profsrInsert", method = RequestMethod.POST)
	String profsrInsert(ProfsrVO profsrVO, @RequestParam String file,
			Model model) {
		String url = "redirect:profsrInsert";
		System.out.println("profsrVO : " + profsrVO);
		try {
			profsrService.insertProfsr(profsrVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping("/profsrList")
	public String profsrList(Model model,HttpServletRequest request) throws ServletException, IOException{
		String url="manager/profsr/profsrListForm";
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
		
		List<ProfsrVO> profsrList = null;
		String paging = null;
		try {
			profsrList = profsrService.selectNameAllPage(Integer.parseInt(tpage), key);
			paging = profsrService.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("profsrList", profsrList);
		int n = profsrList.size();
		model.addAttribute("profsrListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	
	@RequestMapping("/profsrDetail")
	public String profsrDitail(@RequestParam String pr_Profsr_No,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="manager/profsr/profsrDetail";
		
		model.addAttribute("tpage",tpage);
		
		ProfsrVO profsrVO = null;
		try {
			profsrVO = profsrService.selectProfsr(pr_Profsr_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("profsrVO", profsrVO);
		return url;
		
	}
	
	@RequestMapping(value="/profsrUpdate", method = RequestMethod.GET)
	public String profsrUpdateForm(@RequestParam String pr_Profsr_No,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="manager/profsr/profsrUpdate";
		
		model.addAttribute("tpage",tpage);
		
		ProfsrVO profsrVO = null;
		try {
			profsrVO = profsrService.selectProfsr(pr_Profsr_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("profsrVO", profsrVO);
		return url;
		
	}
	@RequestMapping(value="/profsrUpdate", method = RequestMethod.POST)
	public String profsrUpdate(ProfsrVO profsrVO,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="redirect:profsrDetail";
		System.out.println(" profsrVO : "+profsrVO);
		try {
			profsrService.updateProfsr(profsrVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("pr_Profsr_No", profsrVO.getPr_Profsr_No());
		model.addAttribute("tpage", tpage);
		return url;
		
	}
}
