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

import com.uni.fems.dto.EventVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.Sklstf_AtrtyVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
import com.uni.fems.service.Bbs_ListService;
import com.uni.fems.service.EventService;
import com.uni.fems.service.SklstfService;
import com.uni.fems.service.Sklstf_AtrtyService;
import com.uni.fems.service.Subjct_Info_TableService;
import com.uni.fems.service.UsersService;

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
 * 2017.02.22.     KJH       추가작성
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
	@Autowired
	private Sklstf_AtrtyService sklstf_AtrtyService;
	@Autowired
	private Subjct_Info_TableService subjct_Info_TableService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private EventService eventService;
	
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
	public String sklstfList(Model model,HttpServletRequest request, SearchVO searchVO) 
			throws ServletException, IOException {
		String url = "admin/sklstf/sklstfList";	
		String tpage = request.getParameter("tpage");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		if(searchVO.getValue()==null)
			searchVO.setValue("");
		if(searchVO.getKey()==null)
			searchVO.setKey("stf_Nm");
		
		List<UserSubjctVO> sklstfList=null;
		String paging = null;
		try {
			sklstfList = sklstfService.listAllSklstf(Integer.parseInt(tpage), searchVO);
			paging = sklstfService.pageNumber(Integer.parseInt(tpage),searchVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("sklstfList", sklstfList);
		int n = sklstfList.size();
		model.addAttribute("sklstfListSize", n);
		model.addAttribute("paging", paging);
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
	public String sklstfInsert(Model model, @RequestParam String file,HttpSession session, SklstfVO sklstfVo, Sklstf_AtrtyVO sklstf_AtrtyVO) 
			throws ServletException, IOException{
		String url = "redirect:sklstfList";	
		//ArrayList<UserSubjctVO> userSubjctVO = null;
		//String sit_Subjct=null;
		
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
					sklstf_AtrtyVO.setSa_Sklstf_No(sklstfVo.getStf_Sklstf_No());
					sklstfService.insertSklstf(sklstfVo, sklstf_AtrtyVO);
						//userSubjctVO=subjct_Info_TableService.selectSubjctByName(sit_Subjct);
						//System.out.println("if : sit_Subjct:================= "+sit_Subjct);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else{
			try {
				sklstf_AtrtyVO.setSa_Sklstf_No(sklstfVo.getStf_Sklstf_No());
				sklstfService.insertSklstf(sklstfVo, sklstf_AtrtyVO);
				//userSubjctVO=subjct_Info_TableService.selectSubjctByName(sit_Subjct);
				//System.out.println("else : sit_Subjct:================= "+sit_Subjct);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//model.addAttribute("userSubjctVO",userSubjctVO);
		//model.addAttribute("sklstfVo",sklstfVo);
		
		return url;
	}
	
	/**
	 * <pre>
	 * 관리자가 직원의 목록을 조회하는 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/sklstfAtrtyList",method=RequestMethod.GET)
	public String sklstfAtrtyList(Model model,HttpServletRequest request, SearchVO searchVO) 
			throws ServletException, IOException{
		
		String url = "admin/sklstf/sklstfAtrtyList";	
		String tpage = request.getParameter("tpage");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		if(searchVO.getValue()==null)
			searchVO.setValue("");
		if(searchVO.getKey()==null)
			searchVO.setKey("stf_Nm");
		
		List<UserSubjctVO> sklstfAtrtyList=null;
		String paging = null;
		try {
			sklstfAtrtyList = sklstfService.listAllSklstf(Integer.parseInt(tpage), searchVO);
			paging = sklstfService.pageNumberAtrty(Integer.parseInt(tpage),searchVO);
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("sklstfAtrtyList", sklstfAtrtyList);
		int n = sklstfAtrtyList.size();
		model.addAttribute("sklstfListSize", n);
		model.addAttribute("paging", paging);
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
	public String sklstfAtrtyUpdate(Model model,HttpSession session, Sklstf_AtrtyVO sklstf_AtrtyVO) 
			throws ServletException, IOException{
		String url = "redirect:sklstfAtrtyList";	
		
		//List<sklstf_AtrtyVO> sklstfAtrtyList=null;
		// 선택한 것의 번호 가져와야할듯
		//만약 여러개 선택시, 리스트로 가져오고 싶은데...
		
		try {
			System.out.println("1111111111sklstf_AtrtyVO : "+sklstf_AtrtyVO);
			
			sklstf_AtrtyService.updateSklstf_Atrty(sklstf_AtrtyVO);
			System.out.println("222222222sklstf_AtrtyVO : "+sklstf_AtrtyVO);
			if(sklstf_AtrtyVO.getSa_Atrty()=="ROLE_STF"){
				System.out.println("33333333333333 sklstf_AtrtyVO : "+sklstf_AtrtyVO);
				sklstf_AtrtyVO.setSa_Atrty("ROLE_ADMIN");
				System.out.println("4444444444444444 sklstf_AtrtyVO : "+sklstf_AtrtyVO);
			} else{
				System.out.println("555555555555555555 sklstf_AtrtyVO : "+sklstf_AtrtyVO);
				sklstf_AtrtyVO.setSa_Atrty("ROLE_STF");
				System.out.println("66666666666666666 sklstf_AtrtyVO : "+sklstf_AtrtyVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("777777777777777777777 sklstf_AtrtyVO : "+sklstf_AtrtyVO);
		model.addAttribute("sklstfAtrtyList",sklstf_AtrtyVO);
		System.out.println("8888888888888 sklstf_AtrtyVO : "+sklstf_AtrtyVO);
		
		return url;
	}
	
	
	/**
	 * <pre>
	 * 관리자가 직원의 관리자 권한 여부 목록 조회 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
/*	@RequestMapping(value="/sklstfList", method=RequestMethod.GET)
	public String sklstfListForm(Model model,HttpSession session, SearchVO searchVO) {
		String url = "admin/sklstf/sklstfList";	
		
		
		try {
			searchVO = (SearchVO) sklstfService.listAllSklstf(0, searchVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("searchVO", searchVO);
		return url;
	}*/
	
	
	
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

	
	//이것저것 테스트용 페이지
	@RequestMapping("/test")
	public String test(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/test";	
		return url;
	}
	
	@RequestMapping("eventHandler")
	public String eventHandle(Model model){
		String url = "admin/admin_page/eventHandler";
		List<EventVO> list = null;
		try {
			list = eventService.selectEventList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("eventList",list);
		return url;
	}
	
	@RequestMapping("updateEvent")
	public String eventHandler(EventVO vo,String start,String end){
		String url = "redirect:eventHandler";
		
		vo.setEvt_Start(java.sql.Timestamp.valueOf(start));
		vo.setEvt_End(java.sql.Timestamp.valueOf(end));
		try {
			eventService.updateEvent(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
}
