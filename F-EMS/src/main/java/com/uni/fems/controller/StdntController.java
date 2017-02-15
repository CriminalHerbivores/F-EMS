package com.uni.fems.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.tracing.dtrace.Attributes;
import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.dto.request.PageRequest;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
import com.uni.fems.service.SknrgsService;
import com.uni.fems.service.StdntService;

/**
 * <pre>
 * 학생과 연관된 로직들을 처리하는 컨트롤러
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
@RequestMapping("stdnt")
public class StdntController {

	@Autowired
	private StdntService stdntService;
	public void setStdntService(StdntService stdntService) {
		this.stdntService = stdntService;
	}
	@Autowired
	private SknrgsService sknrgs_Svc;
	public void setSknrgs_Svc(SknrgsService sknrgs_Svc) {
		this.sknrgs_Svc = sknrgs_Svc;
	}
	
	/**
	 * <pre>
	 * 학생 정보를 업데이트하기 전 보여줄 폼을 불러온다.
	 * </pre>
	 * <pre>
	 * @param st_Stdnt_No 학생번호(PK)
	 * @param model
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/stdntUpdate", method = RequestMethod.GET)
	public String stdntUpdateForm(@RequestParam String st_Stdnt_No,Model model) throws ServletException, IOException{
		String url="manager/student/stdntUpdate";
		
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
	 * 학생 정보를 POST 방식으로 받아 업데이트 한다.
	 * </pre>
	 * <pre>
	 * @param stdntVO
	 * @param model
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/stdntUpdate", method = RequestMethod.POST)
	public String stdntUpdate(StdntVO stdntVO, Model model) throws ServletException, IOException{
		String url="redirect:stdntDetail";
		
		try {
			stdntService.updateStdnt(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("st_Stdnt_No",stdntVO.getSt_Stdnt_No());
		return url;
		
	}
	
	// 기숙사 ////////////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 기숙사 정보를 조회한다.
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session 로그인한 사용자의 아이디를 받아오기 위한 세션
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/atBrhs", method = RequestMethod.GET)
	public String atBrhs(Model model, HttpSession session){
		String url="student/registBrhs";
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		
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
	 * 기숙사를 신청한다.
	 * </pre>
	 * <pre>
	 * @param stdntVO
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/atBrhs", method = RequestMethod.POST)
	public String registBrhs(StdntVO stdntVO){
		String url="redirect:atBrhs";
		stdntVO.setSt_Brhs_At("신청");
		
		try {
			stdntService.registBrhs(stdntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	// 학적 //////////////////////////////////////////////////////////////////////////

	/**
	 * <pre>
	 * 학적을 리스트 형태로 조회
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/sknrgsList", method = RequestMethod.GET)
	public String sknrgsList(Model model, HttpServletRequest request) {
		String url = "student/sknrgsList";
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

		HttpSession session = request.getSession();
		String skn_Stdnt_No = (String) session.getAttribute("loginUser");

		String servletPath = request.getServletPath();
		String[] path = servletPath.split("/");

		List<SknrgsVO> sknrgsList = null;
		String paging = "";
		String type = "";
		PageRequest p = new PageRequest();
		p.setTpage(Integer.parseInt(tpage));
		p.setTotalRecord(0);
		p.setPath(path[2]);
		p.setKey(skn_Stdnt_No);

		try {
			p.setTotalRecord(sknrgs_Svc.totalRecord(p));
			sknrgsList = sknrgs_Svc.getStudentSknrgs(p);
			paging = sknrgs_Svc.pageNumber(p);
			type = sknrgs_Svc.getSknrgs(skn_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("sknrgsList", sknrgsList);
		model.addAttribute("paging", paging);
		model.addAttribute("type", type);
		return url;
	}

	/**
	 * <pre>
	 * 학적 변동 사항을 입력
	 * </pre>
	 * <pre>
	 * @param sknrgs
	 * @param uploadfile
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/sknrgsList", method = RequestMethod.POST)
	public String sknrgsWrite(SknrgsVO sknrgs,
			@RequestParam("sknFile") MultipartFile uploadfile,
			HttpSession session) {
		String url = "redirect:sknrgsList";

		sknrgs.setSkn_Useyn("n");

		if (!sknrgs.getSkn_Type().equals("복학"))
			sknrgs.setSkn_Type("휴학");

		String savePath = "resources/files";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		if (!uploadfile.isEmpty()) {
			File file = new File(uploadFilePath, "$$"
					+ System.currentTimeMillis()
					+ uploadfile.getOriginalFilename());
			try {
				uploadfile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sknrgs.setSkn_File(file.getName()); // 파일이름
		}
		try {
			sknrgs_Svc.writeSknrgs(sknrgs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

}
