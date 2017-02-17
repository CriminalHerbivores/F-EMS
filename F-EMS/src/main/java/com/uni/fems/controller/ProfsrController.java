package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dao.impl.Lctre_Unq_NoDAOImpl;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.Lctre_Unq_NoVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.Lctre_Unq_NoService;
import com.uni.fems.service.ProfsrService;

/**
 * <pre>
 * 교수와 연관된 로직들을 처리하는 컨트롤러
 * </pre>
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * 2017.02.17.    KJH       추가작성(강의 개설 요청)
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/profsr")
public class ProfsrController {

	@Autowired
	private ProfsrService profsrService;
	public void setProfsrService(ProfsrService profsrService) {
		this.profsrService = profsrService;
	}
	
	@Autowired
	private Lctre_Unq_NoService lctre_Unq_NoService;
	public void setLctre_Unq_NoService(Lctre_Unq_NoService lctre_Unq_NoService) {
		this.lctre_Unq_NoService = lctre_Unq_NoService;
	}
	
	

	/**
	 * <pre>
	 * 교수 한 명의 정보를 상세히 조회한다
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session 로그인한 사용자의 아이디를 가져오기 위한 세션
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/profsrDetail")
	public String profsrDetail(Model model, HttpSession session) throws ServletException, IOException{
		String url="manager/profsr/profsrDetail";
		String pr_Profsr_No = (String) session.getAttribute("loginUser");
		
		ProfsrVO profsrVO = null;
		try {
			profsrVO = profsrService.selectProfsr(pr_Profsr_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("profsrVO", profsrVO);
		return url;
		
	}

	/**
	 * <pre>
	 * 교수의 정보를 업데이트하기 위해 정보를 조회하는 로직
	 * </pre>
	 * <pre>
	 * @param session
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/profsrUpdate", method = RequestMethod.GET)
	public String profsrUpdateForm(HttpSession session,Model model) throws ServletException, IOException{
		String url="manager/profsr/profsrUpdate";
		String pr_Profsr_No = (String) session.getAttribute("loginUser");
		ProfsrVO profsrVO = null;
		try {
			profsrVO = profsrService.selectProfsr(pr_Profsr_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("profsrVO", profsrVO);
		return url;
		
	}

	/**
	 * <pre>
	 * 교수의 정보를 업데이트 하는 로직
	 * </pre>
	 * <pre>
	 * @param profsrVO
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/profsrUpdate", method = RequestMethod.POST)
	public String profsrUpdate(ProfsrVO profsrVO,Model model) throws ServletException, IOException{
		String url="redirect:profsrDetail";
		try {
			profsrService.updateProfsr(profsrVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("pr_Profsr_No", profsrVO.getPr_Profsr_No());
		return url;
		
	}

	/**
	 * <pre>
	 * 교수의 강의 정보 입력 후 등록하여 개설 요청
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/requestLctre") //(value="/requestLctre", method = RequestMethod.POST)
	public String requestLctre(HttpServletRequest request,HttpSession session) throws ServletException, IOException{
		String url="professor/requestLctre";
		return url;
		
	}
	
	
	
	
	
	/**
	 * <pre>
	 * 교수가 강의 개설시 강의명으로 강의를 검색할 때 사용
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/findLctre", method={RequestMethod.GET, RequestMethod.POST})
	public String findLctre(Model model, String lu_Lctre_Nm) 
			throws ServletException, IOException {
		
		String url = "professor/findLctre";
		System.out.println("여기일까444===================================================================");
		ArrayList<Lctre_SearchVO> lctre_SearchVO=null;
		
		try {
			if (lu_Lctre_Nm != null && lu_Lctre_Nm.trim().equals("") == false) {
			lctre_SearchVO = lctre_Unq_NoService.selectLctreByName(lu_Lctre_Nm);
			}else{
				System.out.println("공백좀===================================================================");
				//lu_Lctre_Nm="%";
				lctre_SearchVO = lctre_Unq_NoService.selectLctreByName("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("lctre_SearchVO", lctre_SearchVO);
		return url;
	}
	
	
	
	
	
	
	
	
	
	
	
/*
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
*/
}
