package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.common.FileDownload;
import com.uni.fems.common.Paging;
import com.uni.fems.dto.FilesVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.ProfsrService;
import com.uni.fems.service.SchlshipService;
import com.uni.fems.service.SklstfService;
import com.uni.fems.service.SknrgsService;
import com.uni.fems.service.StdntService;

/**
 * <pre>
 * 직원과 연관된 로직들을 처리하는 컨트롤러
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
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/sklstf")
@Data
public class SklstfController {
	
	@Autowired
	private SklstfService sklstfService;
	@Autowired
	private StdntService stdntService;
	@Autowired
	private ProfsrService profsrService;
	@Autowired
	private SchlshipService schlshipService;
	@Autowired
	private SknrgsService sknrgs_Svc;
	@Autowired
	private LctreService lctreService;
	@Autowired
	private Paging callPaging;
	
	private WebApplicationContext context = null;
	
	// 직원 ///////////////////////////////////////////////////////////////
	/**
	 * <pre>
	 * 직원 한명의 정보를 업데이트 하기 위해 정보를 조회하는 메소드
	 * </pre>
	 * <pre>
	 * @param session
	 * @param model
	 * @return
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * 직원 한명의 정보를 업데이트
	 * </pre>
	 * <pre>
	 * @param sklstfVO
	 * @return
	 * </pre>
	 */
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

	// 학생 ///////////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 학생 정보를 등록하기 위한 폼을 띄우는 단계
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/stdntInsert", method = RequestMethod.GET)
	String stdntInsertForm(){
		String url = "manager/student/stdntInsertForm";
		return url;
	}
	
/*	@RequestMapping(value="/stdntInsert", method = RequestMethod.POST)
	String stdntInsert(StdntVO stdntVO){
		String url = "redirect:/index";
		try {
			stdntService.insertStdnt(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}*/
	
	/**
	 * <pre>
	 * 학생 정보를 등록
	 * </pre>
	 * <pre>
	 * @param stdntVO
	 * @param file
	 * @param model
	 * @return
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * 학생 정보를 리스트 형식으로 보여줌
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * 학생 한명의 정보를 조회
	 * </pre>
	 * <pre>
	 * @param st_Stdnt_No
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * 학생 한명의 정보를 업데이트 하기 위해 조회
	 * </pre>
	 * <pre>
	 * @param st_Stdnt_No
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
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
	/**
	 * <pre>
	 * 학생 한명의 정보를 업데이트
	 * </pre>
	 * <pre>
	 * @param stdntVO
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/stdntUpdate", method = RequestMethod.POST)
	public String stdntUpdate(StdntVO stdntVO,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="redirect:stdntDetail";
		
		try {
			stdntService.updateStdnt(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("st_Stdnt_No",stdntVO.getSt_Stdnt_No());
		model.addAttribute("tpage",tpage);
		return url;
		
	}
	
	// 기숙사 (미완성) ////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 학생의 기숙사 신청 정보를 승인하기 위해 조회 
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="stdntBrhs", method = RequestMethod.GET) 
	public String stdntBrhs(){
		String url ="manager/student/stdntBrhsYn";
		return url;
	}
	/**
	 * <pre>
	 * 학생의 기숙사 신청 정보를 승인
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="stdntBrhs", method = RequestMethod.POST)
	public String updatestdntBrhs(){
		String url ="";
		return url;
	}

	// 장학금 ///////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 장학금을 등록하기 위한 폼을 띄움
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/schlshipInsert", method = RequestMethod.GET)
	String schlshipInsertForm(Model model, HttpServletRequest request) {
		String url = "manager/schlship/schlshipInsert";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);
		return url;
	}
	/**
	 * <pre>
	 * 장학금을 등록
	 * </pre>
	 * <pre>
	 * @param schlshipVO
	 * @param multipartFile
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/schlshipInsert", method = RequestMethod.POST)
	String schlshipInsert(SchlshipVO schlshipVO,
			@RequestParam("uploadfile") MultipartFile multipartFile) {
		String url = "redirect:schlshipList";

		if(!multipartFile.isEmpty()){
			FilesVO vo = new FileDownload().uploadFile(multipartFile);
			schlshipVO.setSs_File(vo.getFl_File_Nm());
		}
		
		System.out.println(schlshipVO.toString());
		
		try {
			schlshipService.insertSchlship(schlshipVO);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

	/**
	 * <pre>
	 * 장학금을 리스트 형태로 조회
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/schlshipList")
	public String schlshipList(Model model, HttpServletRequest request)
			throws ServletException, IOException {
		String url = "manager/schlship/schlshipListForm";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);

		List<SchlshipVO> schlshipList = null;
		String paging = null;
		try {
			schlshipList = schlshipService.selectNameAllPage(
					Integer.parseInt(tpage), key);
			paging = schlshipService.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("schlshipList", schlshipList);
		int n = schlshipList.size();
		model.addAttribute("schlshipListSize", n);
		model.addAttribute("paging", paging);
		return url;

	}
	
//	@RequestMapping("/fileDownload1")
//	public ModelAndView fileDownload1(HttpServletRequest request) throws Exception{
//	    		
//		String of = request.getParameter("name");
//		of = new String(of.getBytes("ISO8859_1"),"UTF-8"); 
//		of = "1486450785194$$excelFile.xlsx";
//		
//		String path = request.getServletContext().getRealPath("upload");
//		path = "D:\\spring_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\F-EMS\\resources\\upload";
//		String fullPath = path+"/"+of;
//		fullPath = "D:\\spring_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\F-EMS\\resources\\upload\\1486450785194$$excelFile.xlsx";
////		File downloadFile = new File(fullPath);
//		File downloadFile = new File(path,of);
//			    
//	    return new ModelAndView("download", "downloadFile", downloadFile);
//	}
	
	/**
	 * <pre>
	 * 장학금 하나의 정보를 상세하게 조회
	 * </pre>
	 * <pre>
	 * @param st_Schlship_No
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/schlshipDetail")
	public String schlshipDitail(@RequestParam String st_Schlship_No,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "manager/schlship/schlshipDetail";

		model.addAttribute("tpage", tpage);

		SchlshipVO schlshipVO = null;
		try {
			schlshipVO = schlshipService.selectSchlship(st_Schlship_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("schlshipVO", schlshipVO);
		return url;

	}

	/**
	 * <pre>
	 * 장학금 정보를 수정하기 위해 조회
	 * </pre>
	 * <pre>
	 * @param st_Schlship_No
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/updateSchlship", method = RequestMethod.GET)
	public String schlshipUpdateForm(@RequestParam String ss_Schlship_Code,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "manager/schlship/schlshipUpdate";
		model.addAttribute("tpage", tpage);

		SchlshipVO schlshipVO = null;
		try {
			schlshipVO = schlshipService.selectSchlship(ss_Schlship_Code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("schlshipVO", schlshipVO);
		return url;

	}

	/**
	 * <pre>
	 * 장학금 정보를 수정
	 * </pre>
	 * <pre>
	 * @param schlshipVO
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/updateSchlship", method = RequestMethod.POST)
	public String schlshipUpdate(SchlshipVO schlshipVO,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "redirect:schlshipList";
		model.addAttribute("tpage", tpage);
		try {
			schlshipService.updateSchlship(schlshipVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping(value = "/deleteSchlship")
	public String schlshipDelete(@RequestParam String ss_Schlship_Code,
			@RequestParam int tpage,Model model) throws ServletException,
			IOException {
		String url = "redirect:schlshipList";
		model.addAttribute("tpage", tpage);
		
		try {
			schlshipService.deleteSchlship(ss_Schlship_Code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	// 학적 ////////////////////////////////////////////////////////////////////////////

	/**
	 * <pre>
	 * 직원의 학생 학적 조회
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/sknrgListForm", method = RequestMethod.GET)
	public String sknrgListForm(Model model, HttpSession session) {
		String url = "manager/student/sknrgsListForm";
		String skn_Type = (String) session.getAttribute("skn_Type");
		List<SknrgsViewVO> sknrgsVOList = null;
		if (skn_Type != null) {
			skn_Type = "%";
		}
		try {
			sknrgsVOList = sknrgs_Svc.getSknrgsType(skn_Type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("sknrgsVOList", sknrgsVOList);
		return url;
	}

	/**
	 * <pre>
	 * 직원의 학생 학적 변동 내역 승인
	 * </pre>
	 * <pre>
	 * @param skn_Nos
	 * @param skn_Useyns
	 * @param model
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/sknrgListForm", method = RequestMethod.POST)
	public String sknrgList(@RequestParam(value = "skn_No") String[] skn_Nos,
			@RequestParam(value = "skn_Useyn") String[] skn_Useyns,
			Model model, HttpSession session) {
		String url = "redirect:sknrgListForm";

		SknrgsVO sknrgsVO = new SknrgsVO();
		try {
			for (int i = 0; i < skn_Nos.length; i++) {
				sknrgsVO.setSkn_No(Integer.parseInt(skn_Nos[i]));
				sknrgsVO.setSkn_Useyn(skn_Useyns[i]);
				try {
					sknrgs_Svc.updateUseynSknrgs(sknrgsVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
		}
		return url;
	}

	// 교수 //////////////////////////////////////////////////////////////////////////////
	/**
	 * <pre>
	 * 교수를 등록하기 위한 폼을 띄움
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/profsrInsert", method = RequestMethod.GET)
	String profsrInsertForm() {
		String url = "manager/profsr/profsrInsertForm";
		return url;
	}

	/**
	 * <pre>
	 * 교수를 등록
	 * </pre>
	 * <pre>
	 * @param profsrVO
	 * @param file
	 * @param model
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/profsrInsert", method = RequestMethod.POST)
	String profsrInsert(ProfsrVO profsrVO, @RequestParam String file,
			Model model) {
		String url = "redirect:profsrInsert";
		try {
			profsrService.insertProfsr(profsrVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}

	/**
	 * <pre>
	 * 교수 정보를 리스트 형식으로 조회
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * 교수 한명의 정보를 상세하게 조회
	 * </pre>
	 * <pre>
	 * @param pr_Profsr_No
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
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
	
	/**
	 * <pre>
	 * 교수 정보를 수정하기 위해 정보를 조회
	 * </pre>
	 * <pre>
	 * @param pr_Profsr_No
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
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
	/**
	 * <pre>
	 * 교수의 정보를 수정
	 * </pre>
	 * <pre>
	 * @param profsrVO
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/profsrUpdate", method = RequestMethod.POST)
	public String profsrUpdate(ProfsrVO profsrVO,@RequestParam int tpage, Model model) throws ServletException, IOException{
		String url="redirect:profsrDetail";
		try {
			profsrService.updateProfsr(profsrVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("pr_Profsr_No", profsrVO.getPr_Profsr_No());
		model.addAttribute("tpage", tpage);
		return url;
	}
	
	/**
	 * <pre>
	 * 직원의 교수 이력 조회
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_SearchVO
	 * @return
	 * </pre>
	 */
	public String profsrHistory(String tpage, Lctre_SearchVO lctre_SearchVO, HttpServletRequest request, Model model){
		String url="manager/profsr/profsrHistory";
		List<Lctre_SearchVO> list = new ArrayList<Lctre_SearchVO>();
		String paging = "";
		if(tpage==null) tpage="1";
		try {
			int totalRecord = lctreService.countLctre(lctre_SearchVO);
			System.out.println("======= 11111111 totalRecord"+totalRecord);
			paging = callPaging.pageNumber(Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request), "");
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			list = lctreService.selectLctre(lctre_SearchVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("history",list);
		model.addAttribute("paging",paging);
		return url;
	}
}
