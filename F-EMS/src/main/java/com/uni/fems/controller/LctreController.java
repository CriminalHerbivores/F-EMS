package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.fems.common.Paging;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Intrst_ListService;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.ReqstService;
import com.uni.fems.service.StdntService;

/**
 * <pre>
 * 강의와 관련된 Controller
 * 수강신청 관련 기능, 강의등록, 강의수정 등
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자          수정내용
 * --------     --------    ----------------------
 * 2017.01.24     KJH            최초작성
 * 2017.01.30     KJH            추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/course")
public class LctreController {
	
	@Autowired
	private StdntService stdntService;
	@Autowired
	private LctreService lctreService;
	@Autowired
	private Intrst_ListService intrst_ListService;
	@Autowired
	private ReqstService reqstService;
	@Autowired
	private Paging callPaging;
	
	
	
	/**
	 * <pre>
	 * 강의계획서를 조회하는 폼
	 * </pre>
	 * <pre>
	 * @param model
	 * @param lc_Lctre_No
	 * @return
	 * </pre>
	 */
	@RequestMapping("/lectrePlan")
	public String detailLctreForm(Model model, @RequestParam int lc_Lctre_No) {
		String url = "lecture/lectrePlan";
		
		Lctre_SearchVO lctre_SearchVO =null;
		
		try {
			lctre_SearchVO=lctreService.getDetailLctre(lc_Lctre_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("lectreDetail",lctre_SearchVO);
		
		return url;
	}
	
	
//	/**
//	 * <pre>
//	 * 개설강의목록, 수강신청완료목록, 관심강의목록, 신청가능학점을 한번에 확인가능한 메인 폼
//	 * </pre>
//	 * <pre>
//	 * @param request
//	 * @param session
//	 * @return
//	 * </pre>
//	 */
//	@RequestMapping(value="/courseList", method=RequestMethod.GET)
//	public String courseListForm(HttpServletRequest request, HttpSession session) {
//		String url = "course_registration/courseList";
//		return url;
//	}		

	
	/**
	 * <pre>
	 * 관심강의 목록을 바탕으로 작성되는 임시 시간표
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/courseTimetable")
	public String courseTimetableForm(Model model, HttpServletRequest request,
			HttpSession session, Intrst_ListVO intrst_ListVO) {
		String url = "course_registration/courseTimetable";
		List<Lctre_SearchVO> lctre_SearchVO=null;
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		try {
			intrst_ListVO.setIn_Stdnt_No(st_Stdnt_No);
			lctre_SearchVO=intrst_ListService.selectIntrst_List(intrst_ListVO.getIn_Stdnt_No());
			stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO",lctre_SearchVO);
		
		return url;
	}
	
	
	
	/**
	 * <pre>
	 * 수강신청이 가능한 개설강의목록 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseList",method=RequestMethod.GET)
	public String courseList(Model model, HttpServletRequest request, HttpSession session) throws ServletException, IOException{
		
		String url = "course_registration/courseList";
		String st_Stdnt_No = (String) session.getAttribute("loginUser");
		//=============================================================================================================================================
		// courseAbleForm
		
		SearchVO searchVO_1=new SearchVO();
		searchVO_1.setKey("lu_Lctre_Nm");
		searchVO_1.setValue("");
		
		String tpage = request.getParameter("tpage");

		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		List<Lctre_SearchVO> lctre_SearchVO_1=null; 
		String paging=null;
		
		int view_rows = 10; //페이지의 개수
		int counts = 10; //한 페이지에 나타낼 개수

		try {
			int totalRecord = lctreService.countLctreList(Integer.parseInt(tpage), searchVO_1);
			paging = callPaging.pageNumber(Integer.parseInt(tpage)
					,totalRecord,"courseAble", "&key="+searchVO_1.getKey()+"&value="+searchVO_1.getValue()
					,view_rows,counts);
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord,view_rows,counts);
			lctre_SearchVO_1 = lctreService.openLctreList(searchVO_1,rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("openLctreList", lctre_SearchVO_1);
		int n = lctre_SearchVO_1.size();
		model.addAttribute("openLctreListSize", n);
		model.addAttribute("paging", paging);
		//=============================================================================================================================================
		// courseInterestForm
		
		Intrst_ListVO intrst_ListVO_2=new Intrst_ListVO();
		List<Lctre_SearchVO> lctre_SearchVO_2=null;
		//String st_Stdnt_No = (String) session.getAttribute("loginUser");
		try {
			intrst_ListVO_2.setIn_Stdnt_No(st_Stdnt_No);
			lctre_SearchVO_2=intrst_ListService.selectIntrst_List(intrst_ListVO_2.getIn_Stdnt_No());
			stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("intrstLctreList",lctre_SearchVO_2);
		
		
		//=============================================================================================================================================
		// courseCompleteForm
		
		ReqstVO reqstVO_3=new ReqstVO();
		List<Lctre_SearchVO> lctre_SearchVO_3= null;
		//String st_Stdnt_No = (String) session.getAttribute("loginUser");
		
		try {
			reqstVO_3.setRe_Stdnt_No(st_Stdnt_No);
			lctre_SearchVO_3=reqstService.selectReqst(reqstVO_3.getRe_Stdnt_No());
			stdntService.selectStdnt(st_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO",lctre_SearchVO_3);
		//System.out.println("ReqstController====================   "+lctre_SearchVO_3);
		
		
		//=============================================================================================================================================
		//courseCredit
		ReqstVO reqstVO_4=new ReqstVO();
		int sumOfReqst =0;
		int ableOfReqst=18;
		
		//String stdnt_No = (String) session.getAttribute("loginUser");
		try {
			reqstVO_4.setRe_Stdnt_No(st_Stdnt_No);
			sumOfReqst=reqstService.getSumReqst(reqstVO_4);
			ableOfReqst=ableOfReqst-sumOfReqst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//학생이 수강신청한 과목의 학점(맨 앞에것)값을 숫자로 읽어오고 합해준 다음에
		//한 학기에 수강할 수 있는 학점(학과마다 다름)을 빼준다
		//그 값을 조회해오면 되지 않을까...힘내라 나!!
		
		model.addAttribute("sumOfReqst",sumOfReqst);
		model.addAttribute("ableOfReqst",ableOfReqst);
		
		//=============================================================================================================================================
		
		return url;
		
	}
	
	
	
	/**
	 * <pre>
	 * 개설강의 목록을 불러오는 메서드
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
//	public List<Lctre_SearchVO> getOpenLctre(){
//		
//		List<Lctre_SearchVO> openLctreList = new ArrayList<>();
//		for(int i=0; i<openLctreList.size(); i++){
//			Lctre_SearchVO vo=new Lctre_SearchVO();
//			vo.getLc_Lctrum_No();
//			vo.getSit_Subjct();
//			vo.getLu_Lctre_Code();
//			vo.getLc_Split();
//			vo.getLu_Lctre_Nm();
//			vo.getLu_Grade();
//			vo.getLu_Compl_Se();
//			vo.getKnd_Lctre_Knd();
//			vo.getPr_Nm();
//			vo.getLu_Pnt();
//			vo.getLc_Lctre_Time();
//			vo.getLc_Lctre_Nmpr();
//			vo.getLr_Accept_Nmpr();
//			
//			openLctreList.add(vo);
//		}
//		
//		return openLctreList;
//	}

	
	
	/**
	 * <pre>
	 * 접속한 학생이 관심 강의로 추가
	 * </pre>
	 * <pre>
	 * @param datas
	 * @param jsonMap
	 * @param request
	 * @return
	 * </pre>
	 */
	public String insertInterest(@RequestBody Lctre_SearchVO[] datas, Map<String, Object> jsonMap, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		//String tpage = request.getParameter("tpage");
		
		String loginUser = "";
		//List<Lctre_SearchVO> list=null;
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		Intrst_ListVO intrst_ListVO=new Intrst_ListVO();
		
		String[] resultArr_1= request.getParameterValues("result_1");	// 관심
		
		if(resultArr_1 !=null){
			for (int i = 0; i < resultArr_1.length; i++) { 
				if(resultArr_1[i] !=null){	// 관심만 추가한 경우
					intrst_ListVO.setIn_Stdnt_No(loginUser);
					intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
					

					try {
						intrst_ListService.insertIntrst_List(intrst_ListVO);	
						//System.out.println("===================222222  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		return null;
		
	}

	/**
	 * <pre>
	 * 접속한 학생이 수강 과목으로 추가
	 * </pre>
	 * <pre>
	 * @param datas
	 * @param jsonMap
	 * @param request
	 * @return
	 * </pre>
	 */
	public List<Lctre_SearchVO> insertLcture(@RequestBody Lctre_SearchVO[] datas, Map<String, Object> jsonMap, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String loginUser = "";
		//String tpage = request.getParameter("tpage");
		List<Lctre_SearchVO> list=null;
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		ReqstVO reqstVO= new ReqstVO();
		Lctre_SearchVO lctre_SearchVO= new Lctre_SearchVO();
		
		String[] resultArr_2= request.getParameterValues("result_2");	// 수강
		
		if(resultArr_2 !=null){
			for (int i = 0; i < resultArr_2.length; i++) { 
				if(resultArr_2[i] !=null){	// 강의 추가한 경우
					reqstVO.setRe_Stdnt_No(loginUser);
					reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
					lctre_SearchVO.setRe_Lctre_No(reqstVO.getRe_Lctre_No());
		
						try {
							reqstService.insertReqst(reqstVO,lctre_SearchVO);	// 수강신청 하면 관심강의에도 등록되도록 하기
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		
		return null;
		
	}
	
	/**
	 * <pre>
	 * 접속한 학생이 관심과목에서 삭제
	 * </pre>
	 * <pre>
	 * @param datas
	 * @param jsonMap
	 * @param request
	 * @return
	 * </pre>
	 */
	public List<Lctre_SearchVO> deleteInterest(@RequestBody Lctre_SearchVO[] datas, Map<String, Object> jsonMap, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String loginUser = "";
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		Intrst_ListVO intrst_ListVO=new Intrst_ListVO();
		Lctre_SearchVO lctre_SearchVO= new Lctre_SearchVO();
		
		//String st_Stdnt_No = (String) session.getAttribute("loginUser");
		String[] resultArr = request.getParameterValues("result");
		String ck_result = request.getParameter("btn_result");
		if(ck_result.equals("delIntrst")){
			for (int i = 0; i < resultArr.length; i++) {	// 관심강의에서 삭제하면 수강신청한 것도 삭제되도록
				intrst_ListVO.setIn_Stdnt_No(loginUser);
				intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr[i]));
				try {
					intrst_ListService.deleteIntrst_List(intrst_ListVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
		
	}

	/**
	 * <pre>
	 * 접속한 학생이 수강신청을 취소
	 * </pre>
	 * <pre>
	 * @param datas
	 * @param jsonMap
	 * @param request
	 * @return
	 * </pre>
	 */
	public List<Lctre_SearchVO> deleteLcture(@RequestBody Lctre_SearchVO[] datas, Map<String, Object> jsonMap, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String loginUser = "";
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		ReqstVO reqstVO= new ReqstVO();
		Lctre_SearchVO lctre_SearchVO= new Lctre_SearchVO();
		
		//String st_Stdnt_No = (String) session.getAttribute("loginUser");
		String[] resultArr = request.getParameterValues("result");
		String ck_result = request.getParameter("btn_result");
		if(ck_result.equals("delIntrst")){
			for (int i = 0; i < resultArr.length; i++) {	// 관심강의에서 삭제하면 수강신청한 것도 삭제되도록
				reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr[i]));
				try {
					reqstService.deleteReqst(reqstVO,lctre_SearchVO);	// if로 유효성 걸어주고 싶은데
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;	
		
	}
	
	
	
	
	
	/**
	 * <pre>
	 * 개설강의 목록에서 수강신청,관심강의 추가가 가능한 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @param intrst_ListVO
	 * @param reqstVO
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/insertCourse", produces = "application/text; charset=utf8")
	@ResponseBody
	public List<Lctre_SearchVO> insertCourse(@RequestBody Lctre_SearchVO[] datas, Map<String, Object> jsonMap, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String loginUser = "";
		String tpage = request.getParameter("tpage");
		
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		ReqstVO reqstVO= new ReqstVO();
		Intrst_ListVO intrst_ListVO=new Intrst_ListVO();
		Lctre_SearchVO lctre_SearchVO= new Lctre_SearchVO();
		
		//String st_Stdnt_No = (String) session.getAttribute("loginUser");
		String[] resultArr_1= request.getParameterValues("result_1");	// 관심
		String[] resultArr_2= request.getParameterValues("result_2");	// 수강
		
		if(resultArr_1 !=null){
			for (int i = 0; i < resultArr_1.length; i++) { 
				if(resultArr_1[i] !=null){	// 관심만 추가한 경우
					intrst_ListVO.setIn_Stdnt_No(loginUser);
					intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
					
					//System.out.println("============1111111  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());

					try {
						intrst_ListService.insertIntrst_List(intrst_ListVO);	
						//System.out.println("===================222222  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
			
		if(resultArr_2 !=null){
			for (int i = 0; i < resultArr_2.length; i++) { 
				if(resultArr_2[i] !=null){	// 강의 추가한 경우
						//System.out.println("===================33333333  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
					reqstVO.setRe_Stdnt_No(loginUser);
					reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
					lctre_SearchVO.setLc_Lctre_No(reqstVO.getRe_Lctre_No());
					lctre_SearchVO.setRe_Lctre_No(reqstVO.getRe_Lctre_No());
					System.out.println("===================4444444  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
		
						try {
							reqstService.insertReqst(reqstVO,lctre_SearchVO);	// 수강신청 하면 관심강의에도 등록되도록 하기
							//System.out.println("===================555555555 reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
							//System.out.println("===================66666666  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
							intrst_ListService.insertIntrst_List(intrst_ListVO);
							//System.out.println("===================77777777  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}
	
	
	/**
	 * <pre>
	 * 관심 강의 목록에서 선택한 관심강의를 수강신청 혹은 삭제하는 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseInterest", produces = "application/text; charset=utf8")
	@ResponseBody
	public List<Lctre_SearchVO> courseInterest(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String loginUser = "Guest";
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		Intrst_ListVO intrst_ListVO=new Intrst_ListVO();
		ReqstVO reqstVO= new ReqstVO();
		Lctre_SearchVO lctre_SearchVO= new Lctre_SearchVO();
		
		//String st_Stdnt_No = (String) session.getAttribute("loginUser");
		String[] resultArr = request.getParameterValues("result");
		String ck_result = request.getParameter("btn_result");
		if(ck_result.equals("addReqst")){
			for (int i = 0; i < resultArr.length; i++) {

				reqstVO.setRe_Stdnt_No(loginUser);
				reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr[i]));
				lctre_SearchVO.setRe_Lctre_No(reqstVO.getRe_Lctre_No());
				//System.out.println("============1111111  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No() +" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
				try {
					reqstService.insertReqst(reqstVO,lctre_SearchVO);

					//System.out.println("============222222222  reqstVO.getRe_Lctre_No()  "+reqstVO.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO.getIn_Lctre_No() +" 수강인원  "+lctre_SearchVO.getLc_Lctre_No()+" // "+lctre_SearchVO.getLc_Lctre_Nmpr());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if(ck_result.equals("delIntrst")){
			for (int i = 0; i < resultArr.length; i++) {	// 관심강의에서 삭제하면 수강신청한 것도 삭제되도록
				intrst_ListVO.setIn_Stdnt_No(loginUser);
				intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr[i]));
				reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr[i]));
				try {
					intrst_ListService.deleteIntrst_List(intrst_ListVO);
					reqstService.deleteReqst(reqstVO,lctre_SearchVO);	// if로 유효성 걸어주고 싶은데
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;	
		}	
	
	
	
	
	
	/**
	 * <pre>
	 * 수강 완료 목록에서 선택한 관심강의 및 수강신청을 삭제하는 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/courseComplete",produces = "application/text; charset=utf8")
	@ResponseBody
	public List<Lctre_SearchVO> courseComplete(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String loginUser = "Guest";
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		//String loginUser = (String) session.getAttribute("loginUser");
		
		ReqstVO reqstVO= new ReqstVO();;
		Intrst_ListVO intrst_ListVO= new Intrst_ListVO();
		Lctre_SearchVO lctre_SearchVO= new Lctre_SearchVO();
		
		String[] resultArr_1= request.getParameterValues("result_1");
		String[] resultArr_2= request.getParameterValues("result_2");

		// 수강신청하면 4개가 조회되어 나타남
		// 수강중인 학생수가 강의실 수용인원을 넘어가면 수강신청이 안 되어야 함
		
		
		if((resultArr_1==null&&resultArr_2!=null)||(resultArr_1!=null&&resultArr_2!=null)){
		for (int i = 0; i < resultArr_2.length; i++) { 
			reqstVO.setRe_Stdnt_No(loginUser);
			reqstVO.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
			intrst_ListVO.setIn_Stdnt_No(loginUser);
			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_2[i]));
			//reqstVO.setRe_Lctre_No(intrst_ListVO.getIn_Lctre_No());
			lctre_SearchVO.setRe_Lctre_No(reqstVO.getRe_Lctre_No());
			//System.out.println("============== 11111111111 reqstVO.getRe_Lctre_No() "+reqstVO.getRe_Lctre_No());
			try {
				reqstService.deleteReqst(reqstVO,lctre_SearchVO);
				intrst_ListService.deleteIntrst_List(intrst_ListVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		if(resultArr_1!=null&&resultArr_2 == null){
		for (int i = 0; i < resultArr_1.length; i++) {
			//if(resultArr_1[i] != null && resultArr_2[i] == null){
			intrst_ListVO.setIn_Stdnt_No(loginUser);
			intrst_ListVO.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
			try {
				intrst_ListService.deleteIntrst_List(intrst_ListVO);	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		//}	
		}
		return null;
	}	
	
	

//	/**
//	 * <pre>
//	 * 개설강의 목록에서 수강신청,관심강의 추가가 가능한 로직
//	 * </pre>
//	 * <pre>
//	 * @param request
//	 * @param session
//	 * @param intrst_ListVO
//	 * @param reqstVO
//	 * @return
//	 * @throws ServletException
//	 * @throws IOException
//	 * </pre>
//	 */
//	@RequestMapping(value="/courseList", method=RequestMethod.POST)
//	public String insertCourse(Model model, SearchVO searchVO,HttpServletRequest request,
//		HttpSession session) throws ServletException, IOException, SQLIntegrityConstraintViolationException{
//		String url = "redirect:courseList";
//		
//		String st_Stdnt_No = (String) session.getAttribute("loginUser");
//		
//		//=============================================================================================================================================
//		// insertCourse
//		ReqstVO reqstVO_1= new ReqstVO();
//		Intrst_ListVO intrst_ListVO_1=new Intrst_ListVO();
//		Lctre_SearchVO lctre_SearchVO_1= new Lctre_SearchVO();
//		
//		
//		String[] resultArr_1= request.getParameterValues("result_1");	// 관심
//		String[] resultArr_2= request.getParameterValues("result_2");	// 수강
//		
//		if(resultArr_1 !=null){
//			for (int i = 0; i < resultArr_1.length; i++) { 
//				if(resultArr_1[i] !=null){	// 관심만 추가한 경우
//					intrst_ListVO_1.setIn_Stdnt_No(st_Stdnt_No);
//					intrst_ListVO_1.setIn_Lctre_No(Integer.parseInt(resultArr_1[i]));
//					
//					System.out.println("============1111111  reqstVO.getRe_Lctre_No()  "+reqstVO_1.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_1.getIn_Lctre_No()
//							+" 수강인원  "+lctre_SearchVO_1.getLc_Lctre_No()+" // "+lctre_SearchVO_1.getLc_Lctre_Nmpr());
//
//					try {
//						intrst_ListService.insertIntrst_List(intrst_ListVO_1);	
//						System.out.println("===================222222  reqstVO.getRe_Lctre_No()  "+reqstVO_1.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_1.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO_1.getLc_Lctre_No()+" // "+lctre_SearchVO_1.getLc_Lctre_Nmpr());
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//		}
//			
//		if(resultArr_2 !=null){
//		for (int i = 0; i < resultArr_2.length; i++) { 
//			if(resultArr_2[i] !=null){	// 강의 추가한 경우
//				System.out.println("===================33333333  reqstVO.getRe_Lctre_No()  "+reqstVO_1.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_1.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO_1.getLc_Lctre_No()+" // "+lctre_SearchVO_1.getLc_Lctre_Nmpr());
//				reqstVO_1.setRe_Stdnt_No(st_Stdnt_No);
//				reqstVO_1.setRe_Lctre_No(Integer.parseInt(resultArr_2[i]));
//				lctre_SearchVO_1.setLc_Lctre_No(reqstVO_1.getRe_Lctre_No());
//				lctre_SearchVO_1.setRe_Lctre_No(reqstVO_1.getRe_Lctre_No());
//			System.out.println("===================4444444  reqstVO.getRe_Lctre_No()  "+reqstVO_1.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_1.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO_1.getLc_Lctre_No()+" // "+lctre_SearchVO_1.getLc_Lctre_Nmpr());
//
//			try {
//				reqstService.insertReqst(reqstVO_1,lctre_SearchVO_1);	// 수강신청 하면 관심강의에도 등록되도록 하기
//				System.out.println("===================555555555 reqstVO.getRe_Lctre_No()  "+reqstVO_1.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_1.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO_1.getLc_Lctre_No()+" // "+lctre_SearchVO_1.getLc_Lctre_Nmpr());
//				System.out.println("===================66666666  reqstVO.getRe_Lctre_No()  "+reqstVO_1.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_1.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO_1.getLc_Lctre_No()+" // "+lctre_SearchVO_1.getLc_Lctre_Nmpr());
//				
//				intrst_ListService.insertIntrst_List(intrst_ListVO_1);
//				System.out.println("===================77777777  reqstVO.getRe_Lctre_No()  "+reqstVO_1.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_1.getIn_Lctre_No()+" 수강인원  "+lctre_SearchVO_1.getLc_Lctre_No()+" // "+lctre_SearchVO_1.getLc_Lctre_Nmpr());
//			} catch (SQLException e) {
//				e.printStackTrace();
//
//			}
//			
//			}
//
//			}
//		}
//			}
//		
//		//=============================================================================================================================================
//		// deleteCourseInterest : 관심목록에서 처리하는 곳
//		Intrst_ListVO intrst_ListVO_2=new Intrst_ListVO();
//		ReqstVO reqstVO_2= new ReqstVO();
//		Lctre_SearchVO lctre_SearchVO_2= new Lctre_SearchVO();
//		
//		
//		//String stdnt_No = (String) session.getAttribute("loginUser");
//		String[] resultArr = request.getParameterValues("result");
//		String ck_result = request.getParameter("btn_result");	// 근데 이 버튼을 누른게 아니어서 널 일수 밖에 없는데...
//		
//		if(ck_result==null)
//			ck_result="";
//		
//		System.out.println("********************* =============================    ck_result : "+ck_result);
//		
//		if(ck_result.equals("addReqst")){	//여기가 널포인트
//			for (int i = 0; i < resultArr.length; i++) {
//
//				reqstVO_2.setRe_Stdnt_No(st_Stdnt_No);
//				reqstVO_2.setRe_Lctre_No(Integer.parseInt(resultArr[i]));
//				lctre_SearchVO_2.setRe_Lctre_No(reqstVO_2.getRe_Lctre_No());
//				System.out.println("============1111111  reqstVO.getRe_Lctre_No()  "+reqstVO_2.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_2.getIn_Lctre_No()
//						+" 수강인원  "+lctre_SearchVO_2.getLc_Lctre_No()+" // "+lctre_SearchVO_2.getLc_Lctre_Nmpr());
//				try {
//					reqstService.insertReqst(reqstVO_2,lctre_SearchVO_2);
//
//					System.out.println("============222222222  reqstVO.getRe_Lctre_No()  "+reqstVO_2.getRe_Lctre_No()+" // intrst_ListVO.getIn_Lctre_No  "+intrst_ListVO_2.getIn_Lctre_No()
//							+" 수강인원  "+lctre_SearchVO_2.getLc_Lctre_No()+" // "+lctre_SearchVO_2.getLc_Lctre_Nmpr());
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}else if(ck_result.equals("delIntrst")){
//			for (int i = 0; i < resultArr.length; i++) {	// 관심강의에서 삭제하면 수강신청한 것도 삭제되도록
//				intrst_ListVO_2.setIn_Stdnt_No(st_Stdnt_No);
//				intrst_ListVO_2.setIn_Lctre_No(Integer.parseInt(resultArr[i]));
//				reqstVO_2.setRe_Lctre_No(Integer.parseInt(resultArr[i]));
//				try {
//					intrst_ListService.deleteIntrst_List(intrst_ListVO_2);
//					reqstService.deleteReqst(reqstVO_2,lctre_SearchVO_2);	// if로 유효성 걸어주고 싶은데
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		
//		//=============================================================================================================================================
//		// deleteCourseComplete
//		
//		ReqstVO reqstVO_3= new ReqstVO();;
//		Intrst_ListVO intrst_ListVO_3= new Intrst_ListVO();
//		Lctre_SearchVO lctre_SearchVO_3= new Lctre_SearchVO();
//		
//		//String stdnt_No = (String) session.getAttribute("loginUser");
//		
//		//Intrst_ListVO intrst_ListVO=null;
//		//Lctre_SearchVO lctre_SearchVO=null;
//		
//		
//		String[] resultArr_3= request.getParameterValues("result_1");
//		String[] resultArr_4= request.getParameterValues("result_2");
//
//		// 수강신청하면 4개가 조회되어 나타남
//		// 수강중인 학생수가 강의실 수용인원을 넘어가면 수강신청이 안 되어야 함
//		
//		
//		if((resultArr_3==null&&resultArr_4!=null)||(resultArr_3!=null&&resultArr_4!=null)){
//		for (int i = 0; i < resultArr_4.length; i++) { 
//			reqstVO_3.setRe_Stdnt_No(st_Stdnt_No);
//			reqstVO_3.setRe_Lctre_No(Integer.parseInt(resultArr_4[i]));
//			intrst_ListVO_3.setIn_Stdnt_No(st_Stdnt_No);
//			intrst_ListVO_3.setIn_Lctre_No(Integer.parseInt(resultArr_4[i]));
//			//reqstVO.setRe_Lctre_No(intrst_ListVO.getIn_Lctre_No());
//			lctre_SearchVO_3.setRe_Lctre_No(reqstVO_3.getRe_Lctre_No());
//			System.out.println("============== 11111111111 reqstVO.getRe_Lctre_No() "+reqstVO_3.getRe_Lctre_No());
//			try {
//				reqstService.deleteReqst(reqstVO_3,lctre_SearchVO_3);
//				intrst_ListService.deleteIntrst_List(intrst_ListVO_3);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		}
//		if(resultArr_3!=null&&resultArr_4 == null){
//		for (int i = 0; i < resultArr_3.length; i++) {
//			//if(resultArr_1[i] != null && resultArr_2[i] == null){
//			intrst_ListVO_3.setIn_Stdnt_No(st_Stdnt_No);
//			intrst_ListVO_3.setIn_Lctre_No(Integer.parseInt(resultArr_3[i]));
//			try {
//				intrst_ListService.deleteIntrst_List(intrst_ListVO_3);	
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			}
//		//}	
//		}
//		
//		//=============================================================================================================================================
//		
//		return url;
//
//	}

}
