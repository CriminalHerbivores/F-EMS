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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.common.FileDownload;
import com.uni.fems.common.Paging;
import com.uni.fems.common.Supporter;
import com.uni.fems.dto.FilesVO;
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
public class SklstfController {
	
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
		String userid = (String)session.getAttribute("loginUser");
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
	String stdntInsert(StdntVO stdntVO, @RequestParam("f")MultipartFile uploadfile, Model model){
		String url = "redirect:stdntInsert";
		if(!uploadfile.isEmpty()){
			FilesVO vo = fileDownload.uploadFile(uploadfile);
			
			ReadOption ro = new ReadOption();
			ro.setFilePath(fileDownload.filePath+"/"+vo.getFl_File_Nm());		//경로 입력
			ro.setOutputColumns("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N");	//배열 명 입력
			ro.setStartRow(2);
			
			List<Map<String, String>> result = ExcelRead.read(ro);
			
			for(Map<String, String> map : result) {
				stdntVO.setSt_Stdnt_No(map.get("A")); // 학생번호
				stdntVO.setSt_Subjct_Code(map.get("B")); //학과코드
				stdntVO.setSt_Pw(map.get("C")); //비밀번호
				stdntVO.setSt_Nm(map.get("D")); //이름
				stdntVO.setSt_Eng_Nm(map.get("E")); //영문이름
				stdntVO.setSt_Ihidnum(map.get("F")); //주민번호
				stdntVO.setSt_Moblphon_No(map.get("G")); //핸드폰번호
				stdntVO.setSt_House_Tlphon_No(map.get("H")); //집 전화번호
				stdntVO.setSt_Prtctor_Nm(map.get("I")); //보호자 이름
				stdntVO.setSt_Family_Relate(map.get("J")); //가족관계
				stdntVO.setSt_Post_No(map.get("K")); //우편번호
				stdntVO.setSt_Adres1(map.get("L")); //주소
				stdntVO.setSt_Adres2(map.get("M")); //상세주소
				stdntVO.setSt_Email(map.get("N")); //이메일
				
				stdntVO.setSt_Entsch_Dt(supporter.getDay()[0]+"0302"); //입학일자
				
				//stdntVO.setSt_Entsch_Dt(map.get("I")); //입학일자
				//stdntVO.setSt_Cnslt_At(map.get("O")); //상담여부
				//stdntVO.setSt_Brhs_At(map.get("Q")); //기숙사 여부
				//stdntVO.setSt_Profsr_No(map.get("R")); //교수번호
				//stdntVO.setSt_Grdtn_Dt(map.get("S")); //졸업일자
				
				try {
					stdntService.insertStdnt(stdntVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}else{
			try {
				stdntVO.setSt_Entsch_Dt(supporter.getDay()[0]+"0302"); //입학일자
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
	
	// 기숙사 ////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 학생의 기숙사 신청 정보를 승인하기 위해 조회 
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="stdntBrhs", method = RequestMethod.GET) 
	public String stdntBrhs(@RequestParam(defaultValue="1")String tpage,StdntVO stdntVO,Model model, HttpServletRequest request){
		String url ="manager/student/stdntBrhsYn";
		
		stdntVO.setSt_Brhs_At("신청");
		
		ArrayList<StdntVO> list = new ArrayList<StdntVO>();
		String paging ="";
		int totalRecord=0;
		try {
			totalRecord = stdntService.countStdntList(stdntVO);
			paging = callPaging.pageNumber(
					Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request), "");
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			list = stdntService.selectStdntList(stdntVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("tpage",tpage);
		model.addAttribute("paging",paging);
		model.addAttribute("stdntList",list);
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
	public String updatestdntBrhs(String[] st_Brhs_At,String[] st_Stdnt_No){
		String url ="redirect:stdntBrhs";
		
		if(st_Brhs_At!=null){
			for(int i=0;i<st_Brhs_At.length;i++){
				StdntVO stdntVO = new StdntVO();
				stdntVO.setSt_Stdnt_No(st_Stdnt_No[i]);
				stdntVO.setSt_Brhs_At(st_Brhs_At[i]);
				try {
					stdntService.registBrhs(stdntVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return url;
	}
	
	// 등록금 ///////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 등록금 목록을 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="tuitionList")
	public String tuitionList(@Value("")String sit_Subjct, String tpage, Model model){
		String url="manager/tuition/tuitionList";
		if(tpage==null) tpage="1";
		model.addAttribute("tpage",tpage);
		
		ArrayList<UserSubjctVO> list = new ArrayList<UserSubjctVO>();
		String paging = "";
		int count = 0;
		try {
			count = tuitionService.countSubjctByName(sit_Subjct);
			paging = new Paging().pageNumber(Integer.parseInt(tpage), count, "tuitionList", "&sit_Subjct="+sit_Subjct);
			list = tuitionService.selectSubjctByName(Integer.parseInt(tpage), count, sit_Subjct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("tuitionList",list);
		model.addAttribute("paging",paging);
		return url;
	}
	/**
	 * <pre>
	 * 학생에게 등록금을 고지 
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="toStdTuition")
	public String toStdTuition(@Value("")String sit_Subjct, String tpage){
		String url="redirect:stdTuitionList?tpage="+tpage;
		try {
			tuitionService.toStdTuition();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	/**
	 * <pre>
	 * 학과번호로 등록금을 업데이트 함
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="updateSubTuition", method = RequestMethod.GET)
	public String upTuition(String sit_Subjct_Code, Model model){
		String url="manager/tuition/updateSubTuition";
		
		UserSubjctVO sub = new UserSubjctVO();
		try {
			sub = tuitionService.selectSubjctByCode(sit_Subjct_Code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("tut",sub);
		return url;
	}
	/**
	 * <pre>
	 * 학과번호로 등록금을 업데이트 함
	 * </pre>
	 * <pre>
	 * @param subVO
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="updateSubTuition", method = RequestMethod.POST)
	public String updateTuition(Subjct_Info_TableVO subVO){
		String url="redirect:tuitionList";
		
		try {
			tuitionService.updateTuition(subVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	/**
	 * <pre>
	 * 직원이 학생의 등록금 납부 내역을 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("stdTuitionList")
	public String stdTuitionList(@RequestParam(defaultValue="1")String tpage, TuitionVO tuitionVO, HttpSession session, HttpServletRequest request, Model model){
		String url="manager/tuition/stdTuitionList";
		tuitionVO.setTu_Stdnt_No("");
		if(tuitionVO.getKey()==null)
			tuitionVO.setKey("tu_No");
		if(tuitionVO.getValue()==null)
			tuitionVO.setValue("");
		if(tpage==null) tpage="1";
		
		ArrayList<TuitionVO> list=new ArrayList<TuitionVO>();
		String paging ="";
		try {
			int totalRecord = tuitionService.countTuitionStdnt(tuitionVO); 
			paging = callPaging.pageNumber(Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request), "");
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			list = tuitionService.tuitionStdnt(tuitionVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("tpage",tpage);
		model.addAttribute("paging",paging);
		model.addAttribute("tuitionList",list);
		return url;
	}
	/**
	 * <pre>
	 * 학생의 등록금 납부 내역을 등록
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("updateStdTuition")
	public String updateStdTuition(TuitionVO tuitionVO){
		String url="redirect:stdTuitionList";
		try {
			tuitionService.updateTuitionStdnt(tuitionVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	/**
	 * 장학금 사용/사용안함
	 * @param ss_Schlship_Code
	 * @param tpage
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
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
	
	
	/**
	 * <pre>
	 * 장학금 신청 내역을 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="requestschlship", method = RequestMethod.GET)
	public String requestschlship(SchlshipVO schlshipVO,Model model, HttpServletRequest request, HttpSession session, @RequestParam(defaultValue="1")String tpage){
		String url="manager/schlship/requestschlship";
		if(schlshipVO.getPy_Stdnt_No()==null)
			schlshipVO.setPy_Stdnt_No("");
		List<SchlshipVO> schlshipList = new ArrayList<SchlshipVO>();
		List<SchlshipVO> stdntSchlshipList = new ArrayList<SchlshipVO>();
		String paging = "";
		try {
			int totalRecord = schlshipService.countSchlshipByStdnt(schlshipVO); 
			paging = callPaging.pageNumber(Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request), "");
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			stdntSchlshipList = schlshipService.selectSchlshipByStdnt(schlshipVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("tpage",tpage); //페이지
		model.addAttribute("paging",paging);
		model.addAttribute("schlshipList", schlshipList);
		model.addAttribute("stdntSchlshipList", stdntSchlshipList);
		return url;
	}
	
	/**
	 * <pre>
	 * 장학금을 신청 내역 변경
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="requestschlship", method = RequestMethod.POST)
	public String requestschlship(int[] py_Schlship_Brkdn_No, String[] py_Useyn, HttpSession session,@RequestParam(defaultValue="1")String tpage){
		String url="redirect:requestschlship?tpage="+tpage;
		
		if(py_Useyn!=null){
			for(int i=0;i<py_Useyn.length;i++){
				PymntVO pymntVO = new PymntVO();
				pymntVO.setPy_Schlship_Brkdn_No(py_Schlship_Brkdn_No[i]);
				pymntVO.setPy_Useyn(py_Useyn[i]);
				
				try {
					schlshipService.updatePymnt(pymntVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	
	@RequestMapping("stdntNprofsr")
	public String stdntNprofsr(Model model){
		String url = "manager/stdntNprofsr";
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
	String profsrInsert(ProfsrVO profsrVO, @RequestParam("f")MultipartFile uploadfile, Model model) {
		String url = "redirect:profsrInsert";
		if(!uploadfile.isEmpty()){
			FilesVO vo = fileDownload.uploadFile(uploadfile);
			
			ReadOption ro = new ReadOption();
			ro.setFilePath(fileDownload.filePath+"/"+vo.getFl_File_Nm());		//경로 입력
			
			ro.setOutputColumns("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L");	//배열 명 입력
			ro.setStartRow(2);
			
			List<Map<String, String>> result = ExcelRead.read(ro);
			
			for(Map<String, String> map : result) {
				profsrVO.setPr_Profsr_No(map.get("A")); // 교수번호
				profsrVO.setPr_Pw(map.get("B")); //비밀번호
				profsrVO.setPr_Nm(map.get("C")); //이름
				profsrVO.setPr_Eng_Nm(map.get("D")); //영문이름
				profsrVO.setPr_Ihidnum(map.get("E")); //주민번호
				profsrVO.setPr_Moblphon_No(map.get("F")); //핸드폰 번호
				profsrVO.setPr_House_Tlphon_No(map.get("G")); //집 전화번호
				profsrVO.setPr_Profsr_Tlphon_No(map.get("H")); //교수 전화번호
				profsrVO.setPr_Post_No(map.get("I")); //우편번호
				profsrVO.setPr_Adres1(map.get("J")); //주소1
				profsrVO.setPr_Adres2(map.get("K")); //주소2
				profsrVO.setPr_Email(map.get("L")); //이메일
				
				try {
					profsrService.insertProfsr(profsrVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}else{
			try {
				profsrService.insertProfsr(profsrVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	@RequestMapping("/profsrLctreList")
	public String profsrHistory(String tpage, Lctre_SearchVO lctre_SearchVO, HttpServletRequest request, Model model){
		//String url="manager/profsr/profsrHistory";
		String url="professor/requestLctreList";
		List<Lctre_SearchVO> list = new ArrayList<Lctre_SearchVO>();
		if(lctre_SearchVO.getPr_Profsr_No()==null) lctre_SearchVO.setPr_Profsr_No("");
		lctre_SearchVO.setLc_Open_At("y");
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
	 * 교수의 재직 상태 조회 (미완성)
	 * </pre>
	 * <pre>
	 * @param workVO
	 * @param tpage
	 * @param model
	 * @param request
	 * @return
	 * </pre>
	 */
	@RequestMapping("profsrWork")
	public String profsrWork(WorkVO workVO,@RequestParam(defaultValue="1")String tpage,Model model, HttpServletRequest request){
		String url="manager/profsr/profsrWork";
		List<WorkVO> list = new ArrayList<WorkVO>();
		String paging="";
		try {
			int totalRecord = workService.countWork(workVO); 
			paging = callPaging.pageNumber(
					Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request)
					, "&wk_Profsr_No="+workVO.getWk_Profsr_No());
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			list = workService.selectWork(workVO,rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("tpage",tpage);
		model.addAttribute("workList",list);
		model.addAttribute("paging",paging);
		return url;
	}
}
