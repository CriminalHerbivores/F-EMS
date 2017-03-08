package com.uni.fems.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import com.uni.fems.common.Paging;
import com.uni.fems.common.Supporter;
import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.PymntVO;
import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.dto.TuitionVO;
import com.uni.fems.dto.request.PageRequest;
import com.uni.fems.service.GradeService;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.ReqstService;
import com.uni.fems.service.SchlshipService;
import com.uni.fems.service.SknrgsService;
import com.uni.fems.service.StdntService;
import com.uni.fems.service.TuitionService;

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
 * 2017.03.08.    KJS       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("stdnt")
public class StdntController {
	@Autowired
	private Supporter supporter;
	@Autowired
	private Paging callPaging;
	@Autowired
	private StdntService stdntService;
	@Autowired
	private SknrgsService sknrgs_Svc;
	@Autowired
	private SchlshipService schlshipService;
	@Autowired
	private TuitionService tuitionService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private ReqstService reqstService;
	@Autowired
	private LctreService lctreService;
	
	/**
	 * <pre>
	 * 학생 한 명의 정보를 상세히 조회한다
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session 로그인한 사용자의 아이디를 가져오기 위한 세션
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/stdntDetail")
	public String stdntDetail(Model model, HttpSession session) throws ServletException, IOException{
		String url="manager/student/stdntDetail";
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
	public String stdntUpdateForm(Model model, HttpSession session) throws ServletException, IOException{
		String url="manager/student/stdntUpdate";
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
		
		boolean flag = (sknrgsList.get(0).getSkn_Type().equals(type))?true:false;
		
		model.addAttribute("flag",flag);
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
		
		if(sknrgs.getSkn_Content().indexOf(",")!=-1)
		sknrgs.setSkn_Content(sknrgs.getSkn_Content().substring(0, sknrgs.getSkn_Content().indexOf(",")));
		
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
		sknrgs.setSkn_Useyn("o");
		try {
			sknrgs_Svc.writeSknrgs(sknrgs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	// 등록금 /////////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 학생의 등록금 내역 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("fromStdTuition")
	public String fromStdTuition(String tpage, TuitionVO tuitionVO, HttpSession session, HttpServletRequest request, Model model){
		String url="student/fromStdTuition";
		tuitionVO.setTu_Stdnt_No((String) session.getAttribute("loginUser"));
		if(tuitionVO.getKey()==null)
		tuitionVO.setKey("tu_No");
		if(tuitionVO.getValue()==null)
		tuitionVO.setValue("");
		if(tpage==null) tpage="1";
		
		ArrayList<TuitionVO> list=new ArrayList<TuitionVO>();
		String paging ="";
		try {
			// 데이터의 총 개수 구해오기
			int totalRecord = tuitionService.countTuitionStdnt(tuitionVO); 
			// request 필요. 
			// 가장 끝의 파라미터는 전달값 검색 등을 통해 GET 방식으로 전달할 값이 있을 경우에만 사용
			// 사용하지 않을 시엔 "" 를 적어주면 됨. 보통은 "&key="+search.getKey()+"&value="+search.getValue()
			paging = callPaging.pageNumber(Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request), "");
			// (현재페이지, 데이터의 총 개수)
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			// (전달값, int start, int count) 이후 쿼리문에서도 같은 순서로 넣어주면 됨
			list = tuitionService.tuitionStdnt(tuitionVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("paging",paging);
		model.addAttribute("tuitionList",list);
		return url;
	}
	
	// 장학금 //////////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 장학금을 조회한다.
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/schlshipList")
	public String schlshipList(Model model, HttpServletRequest request, HttpSession session, @RequestParam(defaultValue="1")String tpage){
		String url="student/schlship";
		
		String loginUser = (String) session.getAttribute("loginUser");
		SchlshipVO schlshipVO = new SchlshipVO();
		schlshipVO.setPy_Stdnt_No(loginUser);
		
		List<SchlshipVO> schlshipList = new ArrayList<SchlshipVO>();
		List<SchlshipVO> stdntSchlshipList = new ArrayList<SchlshipVO>();
		String paging = "";
		try {
			schlshipList = schlshipService.selectAllSchlship();
			
			int totalRecord = schlshipService.countSchlshipByStdnt(schlshipVO); 
			paging = callPaging.pageNumber(Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request), "");
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			stdntSchlshipList = schlshipService.selectSchlshipByStdnt(schlshipVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<Integer> code = new ArrayList<Integer>();
		for(SchlshipVO vo : stdntSchlshipList){
			code.add(vo.getPy_Schlship_Code());
		}
		
		for(int i=0;i<schlshipList.size();i++){
			if(code.contains(schlshipList.get(i).getSs_Schlship_Code())){
				schlshipList.get(i).setSs_Schlship_Code(0);
			}
		}
		
		int[] i = supporter.getDay();
		model.addAttribute("tpage",tpage); //페이지
		model.addAttribute("hack",i[3]); //학기
		model.addAttribute("paging",paging);
		model.addAttribute("schlshipList", schlshipList);
		model.addAttribute("stdntSchlshipList", stdntSchlshipList);
		return url;
	}
	/**
	 * <pre>
	 * 장학금을 신청한다.
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @return
	 * </pre>
	 */
	@RequestMapping(value = "/requestschlship")
	public String requestschlship(HttpSession session,String tpage,int ss_Schlship_Code){
		String url="redirect:schlshipList?tpage="+tpage;
		
		int[] i = supporter.getDay();
		String loginUser = (String) session.getAttribute("loginUser");
		
		PymntVO pymntVO = new PymntVO();
		pymntVO.setPy_Schlship_Code(ss_Schlship_Code);
		pymntVO.setPy_Crrspnd_Year(i[0]+"");
		pymntVO.setPy_Semstr(i[3]+"");
		pymntVO.setPy_Stdnt_No(loginUser);
		
		try {
			schlshipService.requestschlship(pymntVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping("/evlScopeList")
	public String evlScopeListForm(Model model, HttpServletRequest request,
			HttpSession session) {
		String url = "student/evlScopeList";
		String tpage = request.getParameter("tpage");
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		Lctre_SearchVO lctre_Search = new Lctre_SearchVO();
		List<Lctre_SearchVO> lctre_SearchList=null;
		lctre_Search.setRe_Stdnt_No(st_Stdnt_No);
		
		String paging ="";
		try {
			lctre_SearchList=reqstService.selectEvl_Scope(Integer.parseInt(tpage), lctre_Search);
			paging = reqstService.pageNumberEvl_Scope(Integer.parseInt(tpage), lctre_Search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO",lctre_SearchList);
		model.addAttribute("paging", paging);
		return url;
	}
	
	@RequestMapping(value="/evlScope", method = RequestMethod.GET)
	public String evlScopeForm(Model model, HttpServletRequest request,String re_Stdnt_No,String re_Lctre_No,
			HttpSession session) {
		String url = "student/evlScope";
		String tpage = request.getParameter("tpage");
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		Lctre_SearchVO lctre_Search = new Lctre_SearchVO();
		lctre_Search.setRe_Stdnt_No(re_Stdnt_No);
		lctre_Search.setRe_Lctre_No(Integer.parseInt(re_Lctre_No));
		
		try {
			lctre_Search=reqstService.getEvl_Scope(lctre_Search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_Search",lctre_Search);
		return url;
	}
	
	@RequestMapping(value="/evlScope", method = RequestMethod.POST)
	public String evlScope(Model model, HttpServletRequest request,
			HttpSession session) {
		String url = "redirect:evlScopeList?tpage="+request.getParameter("tpage");
		String re_Stdnt_No = request.getParameter("re_Stdnt_No");
		String re_Lctre_No = request.getParameter("re_Lctre_No");
		String lc_Lctre_Evl_Score = request.getParameter("lc_Lctre_Evl_Score");
		Lctre_SearchVO lctre_Search = new Lctre_SearchVO();
		int re_count=0;
		int re_sum=0;
		float re_avg=0.0f;
		int lc_count=0;
		float lc_sum=0;
		float lc_avg=0.0f;
		String[] re_Lctre_Evl_Scopes = {request.getParameter("re_Lctre_Evl_Scope1")
				,request.getParameter("re_Lctre_Evl_Scope2")
				,request.getParameter("re_Lctre_Evl_Scope3")
				,request.getParameter("re_Lctre_Evl_Scope4")
				,request.getParameter("re_Lctre_Evl_Scope5")
				,request.getParameter("re_Lctre_Evl_Scope6")
				,request.getParameter("re_Lctre_Evl_Scope7")
				,request.getParameter("re_Lctre_Evl_Scope8")
				,request.getParameter("re_Lctre_Evl_Scope9")
				,request.getParameter("re_Lctre_Evl_Scope10")
				,request.getParameter("re_Lctre_Evl_Scope11")
				,request.getParameter("re_Lctre_Evl_Scope12")
				,request.getParameter("re_Lctre_Evl_Scope13")};
		
		for(int i=0 ; i< re_Lctre_Evl_Scopes.length ; i++){
			re_sum += Integer.parseInt(re_Lctre_Evl_Scopes[i]);
		}
		re_avg = re_sum/13f;
		if(lc_Lctre_Evl_Score != null && !lc_Lctre_Evl_Score.equals("") && !lc_Lctre_Evl_Score.equals("0")){
			String[] lc_Lctre_Evl_Scores = lc_Lctre_Evl_Score.split(",");
			lc_count = Integer.parseInt(lc_Lctre_Evl_Scores[0]);
			System.out.println("lc_count : "+lc_count);
			lc_sum = (Float.parseFloat(lc_Lctre_Evl_Scores[1])*lc_count)+re_avg;
			System.out.println("lc_sum : "+lc_sum);
			lc_avg = lc_sum/(lc_count+1f);
			System.out.println("lc_avg : "+lc_avg);
			lc_count++;
		}else{
			lc_count = 1;
			lc_avg = re_avg;
		}
		lc_Lctre_Evl_Score = lc_count +  "," + Math.round(lc_avg*100)/100f;
		String re_Lctre_Evl_Scope = Math.round(re_avg*100)/100f+"";
		lctre_Search.setLc_Lctre_Evl_Score(lc_Lctre_Evl_Score);
		lctre_Search.setRe_Lctre_No(Integer.parseInt(re_Lctre_No));
		lctre_Search.setRe_Stdnt_No(re_Stdnt_No);
		lctre_Search.setRe_Lctre_Evl_Scope(re_Lctre_Evl_Scope);
		lctre_Search.setLc_Lctre_No(Integer.parseInt(re_Lctre_No));
		
		try {
			reqstService.updateEvl_Scope(lctre_Search);
			lctreService.updatelc_Evl_Score(lctre_Search);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping(value="viewGrade")
	public String viewGrade(HttpSession session, Model model){
		String url = "student/viewGrade";
		GradeVO grade = new GradeVO();
		String loginUser = (String) session.getAttribute("loginUser");
		grade.setGd_Stdnt_No(loginUser);
		
		List<GradeVO> list = null;
		GradeVO vo = null;
		try {
			list = gradeService.lctreGrade(grade);
			vo = gradeService.totalGrade(loginUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("gradeList",list);
		model.addAttribute("grade",vo);
		return url;
	}
}
