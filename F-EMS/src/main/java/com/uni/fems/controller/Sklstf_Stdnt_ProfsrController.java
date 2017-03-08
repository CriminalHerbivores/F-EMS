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
 * 학생의 교수 배정을 위한 턴트롤러
 * </pre>
 * @author KJS
 * @since 2017. 03. 06.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.03.07.    KJS       최초작성
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
	
	
	
	/**
	 * 학생 테이블형태로 출력
	 * @param commentList
	 * @param paging
	 * @return
	 */
	public String getStdntList(List<StdntVO> commentList, String paging){
		String comment="";
		
		
		for(StdntVO data : commentList){
              comment += "<tr><td>"
              		+ data.getSt_Stdnt_No()
              		+ "</td><td>"
              		+ "<a href='#' onclick='stdnt_No(\""
                    + data.getSt_Stdnt_No()
                    + "\")'>"
              		+ data.getSt_Nm()
              		+ "</a>"
              		+ "</td><td>"
              		+ data.getSit_Subjct()
              		+ "</td><td>";
              if(data.getSt_Profsr_No()!=null)
              comment += data.getSt_Profsr_No();
              comment += "</td></tr>";
		}
		comment += "<tr><td colspan='4' style='text-align: center;'>"+paging+"</td></tr>";
		return comment;
		
	}
	
	/**
	 * 교수 테이블 형태로 출력
	 * @param commentList
	 * @param paging
	 * @return
	 */
	public String getProfsrList(List<ProfsrVO> commentList, String paging){
		String comment="";
		
		
		for(ProfsrVO data : commentList){
              comment += "<tr><td>"
              		+ data.getPr_Profsr_No()
              		+ "</td><td>"
              		+ data.getPr_Nm()
              		+ "</td><td>"
              		+ data.getSit_Subjct()
              		+ "</td><td>"
              		+ "<input type='button' value='배정' class='def-btn btn-sm btn-color' onclick='stdnt_Profsr_no(\""
              		+ data.getPr_Profsr_No()
              		+ "\")'>"
              		+ "</td></tr>";
		}
		comment += "<tr><td colspan='4' style='text-align: center;'>"+paging+"</td></tr>";
		return comment;
		
	}
	
	/**
	 * <pre>
	 * 학생 리스트 폼출력	 
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

		String st_Stdnt_No = (String)jsonMap.get("st_Stdnt_No");
		String st_Nm = (String)jsonMap.get("st_Nm");
		String sit_Subjct = (String)jsonMap.get("sit_Subjct");
		String tpage = (String)jsonMap.get("tpage");
		
		StdntVO stdnt = new StdntVO();
		stdnt.setSt_Stdnt_No("%");
		stdnt.setSt_Nm("%");
		stdnt.setSit_Subjct("%");

		if( st_Stdnt_No != null && !st_Stdnt_No.equals(""))
			stdnt.setSt_Stdnt_No(st_Stdnt_No);
		if( st_Nm != null && !st_Nm.equals(""))
			stdnt.setSt_Nm(st_Nm);
		if( sit_Subjct != null && !sit_Subjct.equals(""))
			stdnt.setSit_Subjct(sit_Subjct);
		
		List<StdntVO> stdntList = null;
		String paging = null;
		try {
			stdntList = stdntService.selectAllStdntList2(Integer.parseInt(tpage), stdnt);
			paging = stdntService.pageNumber2(Integer.parseInt(tpage), stdnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getStdntList(stdntList,paging);
	}
	
	/**
	 * <pre>
	 * 교수 리스트 출력
	 * </pre>
	 * <pre>
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/stdnt_Profsr_ProfsrList",  produces = "application/text; charset=utf8")
	@ResponseBody
	public String stdnt_Profsr_ProfsrList(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request) throws ServletException, IOException{
		HttpSession session = request.getSession();

		String pr_Profsr_No = (String)jsonMap.get("pr_Profsr_No");
		String pr_Nm = (String)jsonMap.get("pr_Nm");
		String sit_Subjct = (String)jsonMap.get("sit_Subjct");
		String tpage = (String)jsonMap.get("tpage");

		ProfsrVO profsr = new ProfsrVO();
		profsr.setPr_Profsr_No("%");
		profsr.setPr_Nm("%");
		profsr.setSit_Subjct("%");

		if( pr_Profsr_No != null && !pr_Profsr_No.equals(""))
			profsr.setPr_Profsr_No(pr_Profsr_No);
		if( pr_Nm != null && !pr_Nm.equals(""))
			profsr.setPr_Nm(pr_Nm);
		if( sit_Subjct != null && !sit_Subjct.equals(""))
			profsr.setSit_Subjct(sit_Subjct);
		
		List<ProfsrVO> profsrList = null;
		String paging = null;
		try {
			profsrList = profsrService.selectAllStdntList2(Integer.parseInt(tpage), profsr);
			paging = profsrService.pageNumber2(Integer.parseInt(tpage), profsr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getProfsrList(profsrList,paging);
	}
	
	@RequestMapping(value="/insetSt_Profsr_No",  produces = "application/text; charset=utf8")
	@ResponseBody
	public String insetSt_Profsr_No(@RequestBody Map<String, Object> jsonMap) throws ServletException, IOException{

		String st_Profsr_No = (String)jsonMap.get("st_Profsr_No");
		String st_Stdnt_No = (String)jsonMap.get("st_Stdnt_No");
		
		StdntVO stdnt = new StdntVO();
		stdnt.setSt_Profsr_No(st_Profsr_No);
		stdnt.setSt_Stdnt_No(st_Stdnt_No);

		try {
			stdntService.updateSt_Profsr_No(stdnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	
}
