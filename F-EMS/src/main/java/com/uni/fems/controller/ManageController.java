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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.fems.dto.SklstfVO;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
import com.uni.fems.service.Bbs_ListService;
import com.uni.fems.service.SklstfService;

/**
 * <pre>
 * 관리자 페이지의 모든 기능들이 포함된 Controller
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/admin")
public class ManageController {
	@Autowired
	private Bbs_ListService bbs_ListSvc;
	
	@Autowired
	private SklstfService sklstfService;

	// @RequestMapping("/")
	// public String in(){
	// String url = "redirect:index";
	// return url;
	// }
	//
	// @RequestMapping("/index")
	// public String index(){
	// String url = "index";
	// return url;
	// }
	//
	// @RequestMapping("/logout")
	// public String logout(HttpSession session) {
	// String url = "redirect:/index";
	// session.invalidate();
	// return url;
	// }
	
	
	/**
	 * <pre>
	 * 직원 목록 조회
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/sklstfList")
	public String sklstfList(HttpServletRequest request,HttpSession session) {
		String url = "admin/sklstf/sklstfList";	
		return url;
	}
	
	/**
	 * <pre>
	 * 관리자의 직원 등록 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/sklstfInsert", method=RequestMethod.GET)
	public String sklstfInsertForm(HttpSession session) {
		String url = "admin/sklstf/sklstfInsert";	
		return url;
	}
	
	/**
	 * <pre>
	 * 관리자의 직원 등록하는 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/sklstfInsert", method=RequestMethod.POST)
	public String sklstfInsert(Model model, @RequestParam String file,HttpSession session, SklstfVO sklstfVo) 
			throws ServletException, IOException{
		String url = "redirect:sklstfAtrtyList";	
		System.out.println("111111111111111111111111111111111111111111111111111111");
		if(file != null && !file.equals("")){
			ReadOption ro = new ReadOption();
			ro.setFilePath(file);		//경로 입력
			ro.setOutputColumns("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M","N");	//배열 명 입력
			ro.setStartRow(2);
			
			List<Map<String, String>> result = ExcelRead.read(ro);
			
			for(Map<String, String> map : result) {
				sklstfVo.setStf_Sklstf_No(map.get("A"));
				sklstfVo.setStf_Pw(map.get("B"));
				sklstfVo.setStf_Subject_Code(map.get("C"));
				sklstfVo.setStf_Nm(map.get("D"));
				sklstfVo.setStf_Eng_Nm(map.get("E"));
				sklstfVo.setStf_Ihidnum(map.get("F"));
				sklstfVo.setStf_Sklstf_Tlphon_No(map.get("G"));
				sklstfVo.setStf_Moblphon_No(map.get("H"));
				sklstfVo.setStf_House_Tlphon_No(map.get("I"));
				sklstfVo.setStf_Post_No(map.get("J"));
				sklstfVo.setStf_Adres1(map.get("K"));
				sklstfVo.setStf_Adres2(map.get("L"));
				sklstfVo.setStf_Email(map.get("M"));
				sklstfVo.setStf_Useyn(map.get("N"));
				try {
					sklstfService.insertSklstf(sklstfVo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("여기는 if문 내부임=================================");
			
		}else{
			try {
				sklstfService.insertSklstf(sklstfVo);
				System.out.println("sklstfVo================="+sklstfVo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("sklstfVo",sklstfVo);
		
		return url;
	}
	
	
	
	/**
	 * <pre>
	 * 직원에게 관리자 권한 여부 목록
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/sklstfAtrtyList", method=RequestMethod.GET)
	public String sklstfAtrtyListForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/sklstf/sklstfAtrtyList";	
		
		
		return url;
	}
	
	
	/**
	 * <pre>
	 * 직원에게 관리자 권한 부여 및 취소 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/sklstfAtrtyList", method=RequestMethod.POST)
	public String sklstfAtrtyUpdate(HttpServletRequest request,HttpSession session) {
		String url = "admin/sklstf/sklstfAtrtyUpdate";	
		return url;
	}
	
	//===================================================
	
	/**
	 * <pre>
	 * 관리자 메뉴들을 한눈에 볼 수 있는 관리자 메인
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/main")
	public String adminMain(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/main";	
		return url;
	}
	
	/**
	 * <pre>
	 * 상대평가 여부 및 상대평가 비율 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/evalRateUpdate")
	public String evalRateUpdate(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_page/evalRateUpdate";	
		return url;
	}
	
	
	
	/**
	 * <pre>
	 * 대학 정보 입력 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step1Add")
	public String step1Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step1Add";	
		return url;
	}
	
	/**
	 * <pre>
	 * 메뉴 게시판 추가, 설정, 사용안함, 권한부여 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step2Add")
	public String step2Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step2Add";	
		return url;
	}
	
	/**
	 * <pre>
	 * 레이아웃 선택 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step3Add")
	public String step3Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step3Add";	
		return url;
	}
	
	/**
	 * <pre>
	 * 메인컬러, 보조컬러1, 보조컬러2, 텍스트컬러 입력으로 컬러테마 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step4Add")
	public String step4Add(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step4Add";	
		return url;
	}
	

	/**
	 * <pre>
	 * 1~4단계에서 설정한 레이아웃을 미리보기로 확인하면서 메뉴 위치를 설정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/layoutPreview")
	public String layoutPreview(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/layoutPreview";	
		return url;
	}
	
	/**
	 * <pre>
	 * 대학 정보 수정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step1Modify")
	public String step1Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step1Modify";	
		return url;
	}
		
	/**
	 * <pre>
	 * 메뉴 게시판 사용여부, 권한 등 수정
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step2Modify")
	public String step2Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step2Modify";	
		return url;
	}
	
	
	
		
	/**
	 * <pre>
	 * 레이아웃 변경 단계
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step3Modify")
	public String step3Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step3Modify";	
		return url;
	}
		
	/**
	 * <pre>
	 * 컬러 테마 변경
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/step4Modify")
	public String step4Modify(HttpServletRequest request,HttpSession session) {
		String url = "admin/layout_control/step4Modify";	
		return url;
	}
	
	
	
	
	
}
