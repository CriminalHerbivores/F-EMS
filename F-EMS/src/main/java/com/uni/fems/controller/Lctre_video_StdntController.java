package com.uni.fems.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_Watch_Video_GntVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.GradeService;
import com.uni.fems.service.Lctre_Video_StdntService;

/**
 * <pre>
 * 강의 과제 게시판의 컨트롤러.
 * 글 작성(파일 업로드 포함) , 상세보기(파일 다운로드), 수정, 삭제 기능 구현
 * </pre>
 * @author KJS
 * @since 2017.02.27
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.27     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */


@Controller
@RequestMapping("/lctre")
public class Lctre_video_StdntController implements ApplicationContextAware{
	
	private WebApplicationContext context = null;
	
	@Autowired
	private Lctre_Video_StdntService lctre_Video_StdntSvc;
	@Autowired
	private GradeService gradeService;
	

	@RequestMapping("/video_StdntList")
	public String Lctre_Video_StdntList(Model model,HttpServletRequest request, HttpSession session, SearchVO searchVO) throws ServletException, IOException{
		String url= "lecture/video/video_StdntList";
		String tpage = request.getParameter("tpage");
		String table_Nm = request.getParameter("table_Nm");
		String loginUser = (String)session.getAttribute("loginUser");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt = new Lctre_Watch_Video_GntVO();
		lctre_Watch_Video_Gnt.setTable_Nm(table_Nm);
		lctre_Watch_Video_Gnt.setLw_Stdnt_No(loginUser);
//		lctre_Watch_Video_Gnt.setLw_Stdnt_No("bbb");
		
		if(searchVO.getKey()==null) searchVO.setKey("lv_Sj");
		if(searchVO.getValue()==null) searchVO.setValue("");
		if(searchVO.getKey().equals("lv_Sj")){
			lctre_Watch_Video_Gnt.setLv_Sj(searchVO.getValue());
			lctre_Watch_Video_Gnt.setLv_Cn("%");
		}else if(searchVO.getKey().equals("lv_Cn")){
			lctre_Watch_Video_Gnt.setLv_Sj("%");
			lctre_Watch_Video_Gnt.setLv_Cn(searchVO.getValue());
		}
		model.addAttribute("lctre_Video_Gnt", lctre_Watch_Video_Gnt);
		
		List<Lctre_Watch_Video_GntVO> lctre_VideoList = null;
		String paging = null;
		try {
			lctre_VideoList = lctre_Video_StdntSvc.listAllLctre_Video(Integer.parseInt(tpage), lctre_Watch_Video_Gnt);
			paging = lctre_Video_StdntSvc.pageNumber(Integer.parseInt(tpage), lctre_Watch_Video_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_VideoList", lctre_VideoList);
		model.addAttribute("paging", paging);
		model.addAttribute("Date", new Date(System.currentTimeMillis()));
		return url;
		
	}

	/**
	 * <pre>
	 * 게시판 리스트중 하나를 상세히 본다.
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/detailLctre_Video_Stdnt")
	public String detailLctre_Video_Stdnt(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt, @RequestParam String table_Nm, Model model, HttpServletRequest request){
		String url="lecture/video/detailLctre_Video_Stdnt";
		//lctre_Watch_Video_Gnt.setLw_Stdnt_No("bbb");
		Lctre_FlpthVO lctre_Flpth = null;
		try {
			lctre_Watch_Video_Gnt = lctre_Video_StdntSvc.getLctre_Video(lctre_Watch_Video_Gnt);
			lctre_Flpth = lctre_Video_StdntSvc.getLctre_Flpth(lctre_Watch_Video_Gnt.getLv_Flpth_No());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lctre_Watch_Video_Gnt.setTable_Nm(table_Nm);
		model.addAttribute("lctre_Video_Gnt",lctre_Watch_Video_Gnt);
		model.addAttribute("lctre_Flpth",lctre_Flpth);
		return url;
	}
	

	
	   @Override
	   public void setApplicationContext(ApplicationContext applicationContext)
	         throws BeansException {
	      this.context = (WebApplicationContext) applicationContext;
	   }
	
	   
	   /**
		 * <pre>
		 * 페이징 처리가 포함된 댓글 리스트를 가져오는 메서드
		 * </pre>
		 * <pre>
		 * @param jsonMap
		 * @param request
		 * @return 댓글 리스트 출력 메서드
		 * </pre>
		 * 
		 */
		@RequestMapping(value="/insertLctre_Video_stdnt",  produces = "application/text; charset=utf8")
		@ResponseBody
		public String insertLctre_Video_stdnt(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request){
			
			HttpSession session = request.getSession();
			String loginUser = (String) session.getAttribute("loginUser");
			String lw_Stdnt_No = loginUser;
//			String lw_Stdnt_No = "bbb";
			String table_Nm = (String)jsonMap.get("table_Nm");
			String lv_Bbs_No = (String)jsonMap.get("lv_Bbs_No");
			int lw_Watch_Time = (int)((double)jsonMap.get("lw_Watch_Time"));
			
			Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt = new Lctre_Watch_Video_GntVO();
			
			lctre_Watch_Video_Gnt.setTable_Nm(table_Nm);
			lctre_Watch_Video_Gnt.setLv_Bbs_No(Integer.parseInt(lv_Bbs_No));
			lctre_Watch_Video_Gnt.setLw_Stdnt_No(lw_Stdnt_No);
			
			try {
				lctre_Watch_Video_Gnt = lctre_Video_StdntSvc.getLctre_Video(lctre_Watch_Video_Gnt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			lctre_Watch_Video_Gnt.setLw_Watch_Time(lw_Watch_Time+"");
			
			lctre_Watch_Video_Gnt.setTable_Nm(table_Nm);
			
			Date date = new Date(System.currentTimeMillis());
			
			long times = date.getTime()	- lctre_Watch_Video_Gnt.getLv_End_Dt().getTime();
			
			if(lctre_Watch_Video_Gnt.getLw_Attendance()==null || lctre_Watch_Video_Gnt.getLw_Attendance().isEmpty())
				lctre_Watch_Video_Gnt.setLw_Attendance("0");
			if(times < 0){
				if(lctre_Watch_Video_Gnt.getLv_Time() - lw_Watch_Time<0){
					lctre_Watch_Video_Gnt.setLw_Attendance("출석");
				}else{
					lctre_Watch_Video_Gnt.setLw_Attendance("");
				}
			}else{
				if(lctre_Watch_Video_Gnt.getLv_Time() - lw_Watch_Time<0){
					lctre_Watch_Video_Gnt.setLw_Attendance("지각");
				}else{
					lctre_Watch_Video_Gnt.setLw_Attendance("결석");
				}
			}
			
			try {
				if(lctre_Watch_Video_Gnt.getLw_Bbs_No() == null || lctre_Watch_Video_Gnt.getLw_Bbs_No().equals("")){
					lctre_Watch_Video_Gnt.setLw_Video_Bbs_No(lv_Bbs_No);
					lctre_Watch_Video_Gnt.setLw_Stdnt_No(lw_Stdnt_No);
					lctre_Video_StdntSvc.insertLctre_Video(lctre_Watch_Video_Gnt);
				}else{
					lctre_Video_StdntSvc.updateLctre_Video(lctre_Watch_Video_Gnt);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//출석률 가져옴
			Lctre_Watch_Video_GntVO att = new Lctre_Watch_Video_GntVO();
			att.setRe_Stdnt_No(loginUser);
			att.setLc_Lctre_No(lctre_Watch_Video_Gnt.getTable_Nm());
			att.setTable_Nm(table_Nm);
			try {
				att = lctre_Video_StdntSvc.attendance(att);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//성적입력
			GradeVO grade = new GradeVO();
			grade.setKey("gd_Task_Score");
			grade.setValue(att.getLw_Attendance());
			grade.setGd_Stdnt_No(loginUser);
			grade.setGd_Lctre_No(Integer.parseInt(lctre_Watch_Video_Gnt.getTable_Nm()));
			
			try {
				gradeService.updateOneGrade(grade);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "null";
			
		} 
	   
	


}
