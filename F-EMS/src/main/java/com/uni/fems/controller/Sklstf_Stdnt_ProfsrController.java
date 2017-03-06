package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.common.FileDownload;
import com.uni.fems.common.Paging;
import com.uni.fems.common.Supporter;
import com.uni.fems.dto.Bbs_Comment_GntVO;
import com.uni.fems.dto.FilesVO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.PymntVO;
import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.TuitionVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.dto.WorkVO;
import com.uni.fems.excel.ExcelRead;
import com.uni.fems.excel.ReadOption;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.Lctre_ActplnService;
import com.uni.fems.service.ProfsrService;
import com.uni.fems.service.SchlshipService;
import com.uni.fems.service.SklstfService;
import com.uni.fems.service.SknrgsService;
import com.uni.fems.service.StdntService;
import com.uni.fems.service.TuitionService;
import com.uni.fems.service.WorkService;

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
public class Sklstf_Stdnt_ProfsrController {
	
	@Autowired
	private Paging callPaging;
	@Autowired
	private Supporter supporter;
	@Autowired
	private FileDownload fileDownload;
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
	private TuitionService tuitionService;
	@Autowired
	private WorkService workService;
	@Autowired
	private Lctre_ActplnService lctre_ActplnSvc;
	
	private WebApplicationContext context = null;
	
	
	
	public String getList(List<StdntVO> commentList){
		String comment="";
		
		
		for(StdntVO data : commentList){
              comment += "<tr><td>"
              		+ data.getSt_Stdnt_No()
              		+ "</td><td>"
              		+ data.getSt_Nm()
              		+ "</td><td>"
              		+ data.getSit_Subjct()
              		+ "</td><td>"
              		+ data.getSt_Profsr_No()
              		+ "</td></tr>";
		}
		return comment;
		
	}
	
	/**
	 * <pre>
	 * 학생에게 담당 교수를 지정해주는 폼
	 * </pre>
	 * <pre>
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/stdnt_Profsr_stdntList",  produces = "application/text; charset=utf8")
	@ResponseBody
	public String stdnt_Profsr_stdntList(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request) throws ServletException, IOException{
		HttpSession session = request.getSession();

		String st_Stdnt_No = (String)jsonMap.get("key");
		String st_Nm = (String)jsonMap.get("st_Nm");
		String st_Subjct_Code = (String)jsonMap.get("st_Subjct_Code");
		String aaa = (String)jsonMap.get("aaa");
		String key = request.getParameter("st_Stdnt_No");
		String tpage = request.getParameter("tpage");
		System.out.println("st_Stdnt_No : "+st_Stdnt_No);
		System.out.println("st_Nm : "+st_Nm);
		System.out.println("st_Subjct_Code : "+st_Subjct_Code);
		System.out.println("aaa : "+aaa);
		if (key ==null){
			key = "";
		}
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		System.out.println("key : "+key);
		List<StdntVO> stdntList = null;
		String paging = null;
		try {
			stdntList = stdntService.selectNameAllPage(Integer.parseInt(tpage), key);
			paging = stdntService.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getList(stdntList);
	}
	
	
	
}
