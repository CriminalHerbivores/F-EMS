package com.uni.fems.controller;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
import com.uni.fems.service.ProfsrService;
import com.uni.fems.service.SchlshipService;
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

	@Autowired
	private SchlshipService schlshipService;
	public void setSchlshipService(SchlshipService schlshipService) {
		this.schlshipService = schlshipService;
	}
	private WebApplicationContext context = null;
	
	//==============================================================================
	// 직원
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

	//==============================================================================
	// 관리자
	@RequestMapping("/adminJoin")
	public String adminJoinForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/adminJoin";	
		return url;
	}
	
	//==============================================================================
	// 학생
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
	// 기숙사
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

	//==============================================================================
	// 장학금
	@RequestMapping(value = "/schlshipInsert", method = RequestMethod.POST)
	String schlshipInsert(SchlshipVO schlshipVO,
			@RequestParam("f") MultipartFile multipartFile, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "redirect:schlshipList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");

		if (!multipartFile.isEmpty()) {

			String upload = request.getSession().getServletContext()
					.getRealPath("resources/upload");

			File file = new File(upload, System.currentTimeMillis() + "$$"
					+ multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				schlshipVO.setSs_Papers_Content(file.toString());
				schlshipService.insertSchlship(schlshipVO);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("key", key);
			model.addAttribute("tpage", tpage);
			
		}
		return url;
	}

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

	@RequestMapping(value = "/schlshipUpdate", method = RequestMethod.GET)
	public String schlshipUpdateForm(@RequestParam String st_Schlship_No,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "manager/schlship/schlshipUpdate";

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

	@RequestMapping(value = "/schlshipUpdate", method = RequestMethod.POST)
	public String schlshipUpdate(SchlshipVO schlshipVO,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "redirect:schlshipList";

		try {
			schlshipService.updateSchlship(schlshipVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	//==============================================================================
	// 교수
	@RequestMapping(value = "/profsrInsert", method = RequestMethod.GET)
	String profsrInsertForm() {
		String url = "manager/profsr/profsrInsertForm";
		return url;
	}

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