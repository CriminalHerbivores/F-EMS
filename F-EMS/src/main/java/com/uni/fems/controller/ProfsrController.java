package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.security.ntlm.Client;
import com.uni.fems.controller.common.UnitDate;
import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dao.impl.Lctre_Unq_NoDAOImpl;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.Lctre_Unq_NoVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.Lctre_ActplnService;
import com.uni.fems.service.Lctre_Unq_NoService;
import com.uni.fems.service.ProfsrService;

/**
 * <pre>
 * 교수와 연관된 로직들을 처리하는 컨트롤러
 * </pre>
 * 
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * 2017.02.17.    KJH       추가작성
 * 2017.02.17.    KJH       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/profsr")
@Data
public class ProfsrController {

	@Autowired
	private ProfsrService profsrService;

	@Autowired
	private LctreService lctreService;
	
	//@Autowired
	//private Lctre_ActplnService lctre_ActplnService;

	@Autowired
	private Lctre_Unq_NoService lctre_Unq_NoService;



	/**
	 * <pre>
	 * 교수 한 명의 정보를 상세히 조회한다
	 * </pre>
	 * 
	 * <pre>
	 * @param model
	 * @param session 로그인한 사용자의 아이디를 가져오기 위한 세션
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/profsrDetail")
	public String profsrDetail(Model model, HttpSession session)
			throws ServletException, IOException {
		String url = "manager/profsr/profsrDetail";
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
	 * 
	 * <pre>
	 * @param session
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/profsrUpdate", method = RequestMethod.GET)
	public String profsrUpdateForm(HttpSession session, Model model)
			throws ServletException, IOException {
		String url = "manager/profsr/profsrUpdate";
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
	 * 
	 * <pre>
	 * @param profsrVO
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/profsrUpdate", method = RequestMethod.POST)
	public String profsrUpdate(ProfsrVO profsrVO, Model model)
			throws ServletException, IOException {
		String url = "redirect:profsrDetail";
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
	 * 교수가 강의 개설 등록 후 요청하는 폼
	 * </pre>
	 * 
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/requestLctre", method=RequestMethod.GET)
	public String requestLctreForm(Model model, HttpSession session,ProfsrVO profsrVO)
			throws ServletException, IOException {

		String url = "professor/requestLctre";
		String pr_Profsr_No = (String) session.getAttribute("loginUser");	//로그인한 교수정보 가져옴
		
		try {
			profsrVO = profsrService.selectProfsr(pr_Profsr_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int[] i = new UnitDate().getDay();
		model.addAttribute("hack",i[3]); //학기
		
		model.addAttribute("profsrVO", profsrVO);
		
		return url;
	}

	
	
	/**
	 * <pre>
	 * 교수가 강의 개설폼을 작성하여 등록 요청하는 로직
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="/requestLctre", method=RequestMethod.POST)
	// (value = "/requestLctre", method = RequestMethod.GET)
	public String requestLctre(Model model, HttpSession session,LctreVO lctreVO,Lctre_ActplnVO lctre_ActplnVO,Lctre_SearchVO lctre_SearchVO)
			throws ServletException, IOException {
		String url = "redirect:openLctreList";//교수가 강의개설 요청 끝난 후 어떻게 할지 해야할듯, 개설한 강의 목록을 보게할지 등등
		
		String pr_Profsr_No = (String) session.getAttribute("loginUser");
		
		try {
			profsrService.selectProfsr(pr_Profsr_No);
			lctreService.openLctre(lctreVO,lctre_ActplnVO);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return url;
	}

	
	// 봐서 삭제할거임
	@RequestMapping(value="/openLctreList", method=RequestMethod.GET)
	// (value = "/requestLctre", method = RequestMethod.GET)
	public String requestLctreListForm(Model model, HttpSession session)
			throws ServletException, IOException {
		String url = "professor/requestLctreList";
		
		return url;
	}
	
	
	
	
	
	/**
	 * <pre>
	 * 교수가 강의 개설시 강의명으로 강의를 검색할 때 사용
	 * </pre>
	 * 
	 * <pre>
	 * @param model
	 * @param lu_Lctre_Nm
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/findLctre", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String findLctre(Model model, String lu_Lctre_Nm)
			throws ServletException, IOException {

		String url = "professor/findLctre";
		ArrayList<Lctre_SearchVO> lctre_SearchVO = null;

		try {
			if (lu_Lctre_Nm != null && lu_Lctre_Nm.trim().equals("") == false) {
				lctre_SearchVO = lctre_Unq_NoService
						.selectLctreByName(lu_Lctre_Nm);
			} else {
				lctre_SearchVO = lctre_Unq_NoService.selectLctreByName("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("lctre_SearchVO", lctre_SearchVO);
		return url;
	}

		
	/**
	 * <pre>
	 * 교수가 개설 강의 및 강의계획서 수정하는 폼
	 * </pre>
	 * <pre>
	 * @param model
	 * @param lctreVO
	 * @param lctre_ActplnVO
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/updateLctre", method = RequestMethod.GET)
	String lctreUpdateForm(Model model, LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO) throws ServletException, IOException {
		String url = "professor/updateLctre";
		
		model.addAttribute("lctreVO", lctreVO);
		model.addAttribute("lctre_ActplnVO", lctre_ActplnVO);
		
		return url;
	}

	/**
	 * <pre>
	 * 교수가 개설 강의 및 강의계획서 수정하는 로직
	 * </pre>
	 * <pre>
	 * @param lctreVO
	 * @param lctre_ActplnVO
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/updateLctre", method = RequestMethod.POST)
	String lctreUpdate(LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO, Model model) throws ServletException, IOException {
		String url = "redirect:openLctreList";
		
		try {
			lctreService.updateLctre(lctreVO,lctre_ActplnVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctreVO", lctreVO);
		model.addAttribute("lctre_ActplnVO", lctre_ActplnVO);

		return url;
	}



}
