package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.common.Paging;
import com.uni.fems.common.Supporter;
import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.KindVO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.GradeService;
import com.uni.fems.service.KindService;
import com.uni.fems.service.LctreService;
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
	private Supporter supporter;
	@Autowired
	private ProfsrService profsrService;
	@Autowired
	private LctreService lctreService;
	//@Autowired
	//private Lctre_ActplnService lctre_ActplnService;
	@Autowired
	private Lctre_Unq_NoService lctre_Unq_NoService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private KindService kindService;
	@Autowired
	private Paging callPaging;

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
		int[] i = supporter.getDay();
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
	public String requestLctre(Model model, HttpSession session,LctreVO lctreVO,Lctre_ActplnVO lctre_ActplnVO,KindVO kindVO)
			throws ServletException, IOException {
		String url = "redirect:openLctreList";//교수가 강의개설 요청 끝난 후 어떻게 할지 해야할듯, 개설한 강의 목록을 보게할지 등등
		String pr_Profsr_No = (String) session.getAttribute("loginUser");
		//int knd_Lctre_No=0;
		System.out.println("=========111111111111 kindVO "+kindVO);
		try {
			profsrService.selectProfsr(pr_Profsr_No);
			lctreService.openLctre(lctreVO,lctre_ActplnVO,kindVO);
			System.out.println("=========222222222222222222 kindVO "+kindVO);
			//kindService.insertKind(knd_Lctre_No);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println("=========33333333333 kindVO "+kindVO);
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
	String lctreUpdate(Model model, LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO, int knd_Lctre_No) throws ServletException, IOException {
		String url = "redirect:openLctreList";
		
		try {
			lctreService.updateLctre(lctreVO,lctre_ActplnVO,knd_Lctre_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctreVO", lctreVO);
		model.addAttribute("lctre_ActplnVO", lctre_ActplnVO);

		return url;
	}

	/**
	 * <pre>
	 * 교수의 강의이력 조회
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_SearchVO
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/openLctreList", method=RequestMethod.GET)
	// (value = "/requestLctre", method = RequestMethod.GET)
	public String requestLctreListForm(String tpage, Lctre_SearchVO lctre_SearchVO, HttpServletRequest request, Model model, HttpSession session)
			throws ServletException, IOException {
		String url = "professor/requestLctreList";
		String loginUser = (String) session.getAttribute("loginUser");
		lctre_SearchVO.setPr_Profsr_No(loginUser);
		List<Lctre_SearchVO> list = new ArrayList<Lctre_SearchVO>();
		String paging = "";
		if(tpage==null) tpage="1";
		int totalRecord = 0;
		try {
			totalRecord = lctreService.countLctre(lctre_SearchVO);
			paging = callPaging.pageNumber(
					Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request)
					, "&pr_Profsr_No="+lctre_SearchVO.getPr_Profsr_No());
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			list = lctreService.selectLctre(lctre_SearchVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO",list);
		model.addAttribute("paging",paging);
		
		return url;
	}

	/**
	 * <pre>
	 * 교수의 현재 강의 조회
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_SearchVO
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/ongoingLctreList")
	// (value = "/requestLctre", method = RequestMethod.GET)
	public String selectLctreList(@RequestParam(value="tpage",defaultValue="1")String tpage, Lctre_SearchVO lctre_SearchVO, HttpServletRequest request, Model model, HttpSession session)
			throws ServletException, IOException {
		String url = "professor/ongoingLctreList";
		String loginUser = (String) session.getAttribute("loginUser");
		
		lctre_SearchVO.setPr_Profsr_No(loginUser);
		lctre_SearchVO.setLc_Lctre_Evl_Score(-1);
		lctre_SearchVO.setLc_Open_At("y");
		lctre_SearchVO.setLc_Period(supporter.getDay()[0]+"");
		
		List<Lctre_SearchVO> list = new ArrayList<Lctre_SearchVO>();
		String paging = "";
		int totalRecord = 0;
		try {
			totalRecord = lctreService.countLctre(lctre_SearchVO);
			paging = callPaging.pageNumber(
					Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request)
					, "&pr_Profsr_No="+lctre_SearchVO.getPr_Profsr_No());
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			list = lctreService.selectLctre(lctre_SearchVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO",list);
		model.addAttribute("paging",paging);
		
		return url;
	}
	
	/**
	 * <pre>
	 * 진행 중인 강의의 성적 관리
	 * </pre>
	 * <pre>
	 * @param gradeVO
	 * @param model
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="manageLctre")
	public String manageLctre(GradeVO gradeVO, Model model){
		String url="professor/manageLctre";
		List<GradeVO> list = new ArrayList<GradeVO>();
		gradeVO.setGd_Stdnt_No("");
		try {
			list = gradeService.selectGrade(gradeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("lctreList",list);
		return url;
	}
}
