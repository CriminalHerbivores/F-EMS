package com.uni.fems.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.common.FileDownload;
import com.uni.fems.dto.FilesVO;
import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_Watch_Video_GntVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Lctre_Video_ProfsrService;
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
public class Lctre_video_ProfsrController implements ApplicationContextAware{
	
	private WebApplicationContext context = null;
	
	@Autowired
	private Lctre_Video_ProfsrService lctre_VideoSvc;
	
	@Autowired
	private Lctre_Video_StdntService lctre_Video_StdntSvc;
	
	/**
	 * <pre>
	 * 제너레이터 게시판의 리스트를 출력해준다
	 * </pre>
	 * <pre>
	 * @param model
	 * @param request
	 * @param searchVO
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/videoList")
	public String Lctre_VideoList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		String url= "lecture/video/video_ProfsrList";
		String tpage = request.getParameter("tpage");
		String table_Nm = request.getParameter("table_Nm");
		Object[] principal = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray();
		String loginRole = principal[0].toString();
		
		if (loginRole=="ROLE_PRO" || loginRole.equals("ROLE_PRO")){
			url = "lecture/video/video_ProfsrList";
		}else if (loginRole=="ROLE_STD" || loginRole.equals("ROLE_STD")){
			return "redirect:video_StdntList?table_Nm="+table_Nm;
		}
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		Lctre_Video_GntVO lctre_Video_Gnt = new Lctre_Video_GntVO();
		lctre_Video_Gnt.setTable_Nm(table_Nm);
		if(searchVO != null ||searchVO.getKey().equals("lv_Sj")){
			lctre_Video_Gnt.setLv_Sj(searchVO.getValue());
			lctre_Video_Gnt.setLv_Cn("%");
		}else if(searchVO != null || searchVO.getKey().equals("lv_Cn")){
			lctre_Video_Gnt.setLv_Sj("%");
			lctre_Video_Gnt.setLv_Cn(searchVO.getValue());
		}else{
			lctre_Video_Gnt.setLv_Sj("%");
			lctre_Video_Gnt.setLv_Cn("%");
		}
		model.addAttribute("lctre_Video_Gnt", lctre_Video_Gnt);
		
		List<Lctre_VideoVO> lctre_VideoList = null;
		String paging = null;
		try {
			lctre_VideoList = lctre_VideoSvc.listAllLctre_Video(Integer.parseInt(tpage), lctre_Video_Gnt);
			paging = lctre_VideoSvc.pageNumber(Integer.parseInt(tpage), lctre_Video_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_VideoList", lctre_VideoList);
		int n = lctre_VideoList.size();
		model.addAttribute("lctre_VideoListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	
	/**
	 * <pre>
	 * 게시판 작성 폼을 띄우기 위한 메서드
	 * </pre>
	 * <pre>
	 * @param model
	 * @param table_Nm
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/writeLctre_Video", method=RequestMethod.GET)
	public String writeLctre_VideoForm(Model model, String table_Nm) throws ServletException, IOException {
		String url="lecture/video/writeLctre_Video";
		model.addAttribute("table_Nm", table_Nm);
		return url;
	}
	
	/**
	 * <pre>
	 *  작성한 게시판을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @param lctre_FlpthVO
	 * @param request
	 * @param uploadfile
	 * @param session
	 * @param model
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/writeLctre_Video", method=RequestMethod.POST)
	public String writeLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt, Lctre_FlpthVO lctre_FlpthVO, HttpServletRequest request,
								@RequestParam("uploadfile")MultipartFile uploadfile, HttpSession session, Model model)
								throws ServletException, IOException{
		String url = "redirect:videoList";
		
//		String loginUser = (String)session.getAttribute("loginUser");
		String loginUser = "bbb";
		if(!uploadfile.isEmpty()){
			FilesVO vo = new FileDownload().uploadFile(uploadfile);
			
			lctre_FlpthVO.setLf_File_Type(vo.getFl_File_Type_Code());
			lctre_FlpthVO.setLf_Flpth(vo.getFl_File_Nm());
			lctre_FlpthVO.setLf_Lctre_No(38);
		}
		lctre_Video_Gnt.setLv_Time(lctre_Video_Gnt.getLv_Time()*60);
		try {
			lctre_VideoSvc.insertLctre_Video(lctre_Video_Gnt, lctre_FlpthVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("table_Nm", lctre_Video_Gnt.getTable_Nm());
		
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
	@RequestMapping(value="/detailLctre_Video")
	public String detailLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt, @RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/video/detailLctre_Video_Profsr";
		
		Lctre_VideoVO lctre_Video = null;
		Lctre_FlpthVO lctre_Flpth = null;
		try {
			lctre_Video = lctre_VideoSvc.getLctre_Video(lctre_Video_Gnt);
			lctre_Flpth = lctre_VideoSvc.getLctre_Flpth(lctre_Video.getLv_Flpth_No());
			lctre_Video_Gnt.setLv_Cn(lctre_Video.getLv_Cn());
			lctre_Video_Gnt.setLv_Sj(lctre_Video.getLv_Sj());
			lctre_Video_Gnt.setLv_Start_Dt(lctre_Video.getLv_Start_Dt());
			lctre_Video_Gnt.setLv_End_Dt(lctre_Video.getLv_End_Dt());
			lctre_Video_Gnt.setLv_Time(lctre_Video.getLv_Time());
			lctre_Video_Gnt.setLv_Flpth_No(lctre_Video.getLv_Flpth_No());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("lctre_Video_Gnt",lctre_Video_Gnt);
		model.addAttribute("tpage",tpage);
		model.addAttribute("lctre_Flpth",lctre_Flpth);
		return url;
	}
	
	/**
	 * <pre>
	 * 게시판의 내용을 수정하기 위한 폼으로 이동
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Video", method=RequestMethod.GET)
	public String updateBbs_GntForm(Lctre_Video_GntVO lctre_Video_Gnt,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/video/updateLctre_Video";
		Lctre_VideoVO lctre_Video = null;
		Lctre_FlpthVO lctre_Flpth = null;
		try {
			
			lctre_Video = lctre_VideoSvc.getLctre_Video(lctre_Video_Gnt);
			lctre_Flpth = lctre_VideoSvc.getLctre_Flpth(lctre_Video.getLv_Flpth_No());
			lctre_Video_Gnt.setLv_Cn(lctre_Video.getLv_Cn());
			lctre_Video_Gnt.setLv_Sj(lctre_Video.getLv_Sj());
			lctre_Video_Gnt.setLv_Start_Dt(lctre_Video.getLv_Start_Dt());
			lctre_Video_Gnt.setLv_End_Dt(lctre_Video.getLv_End_Dt());
			lctre_Video_Gnt.setLv_Time(lctre_Video.getLv_Time());
			lctre_Video_Gnt.setLv_Flpth_No(lctre_Video.getLv_Flpth_No());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("lctre_Video_Gnt",lctre_Video_Gnt);
		model.addAttribute("tpage",tpage);
		model.addAttribute("lctre_Flpth",lctre_Flpth);
		return url;
	}
	
	/**
	 * <pre>
	 * 수정한 게시판의 내용을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param uploadfile
	 * @param lctre_Video_Gnt
	 * @param lctre_FlpthVO
	 * @param session
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Video", method=RequestMethod.POST)
	public String updateBbs_Gnt(@RequestParam int tpage, @RequestParam("uploadfile")MultipartFile uploadfile,
			Lctre_Video_GntVO lctre_Video_Gnt, Lctre_FlpthVO lctre_FlpthVO, HttpSession session, HttpServletRequest request, Model model){
		String url = "redirect:detailLctre_Video?"
				+ "table_Nm="+lctre_Video_Gnt.getTable_Nm()
				+ "&lv_Bbs_No="+lctre_Video_Gnt.getLv_Bbs_No()
				+ "&tpage="+tpage;
		
		if(!uploadfile.isEmpty()){
			FilesVO vo = new FileDownload().uploadFile(uploadfile);
			lctre_FlpthVO.setLf_File_Type(vo.getFl_File_Type_Code());
			lctre_FlpthVO.setLf_Flpth(vo.getFl_File_Nm());
		}
		lctre_Video_Gnt.setLv_Time(lctre_Video_Gnt.getLv_Time()*60);
		try {
			lctre_VideoSvc.updateLctre_Video(lctre_Video_Gnt, lctre_FlpthVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	/**
	 * <pre>
	 * 해당하는 게시판을 삭제처리하는 메서드
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @param tpage
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/deleteLctre_Video")
	public String deleteNotice(Lctre_Video_GntVO lctre_Video_Gnt,@RequestParam int tpage,HttpServletRequest request, Model model){
		String url = "redirect:videoList?"
				+ "table_Nm="+lctre_Video_Gnt.getTable_Nm()
				+ "&tpage="+tpage;
		
		try {
			System.out.println("lctre_Video_Gnt : "+lctre_Video_Gnt);
			lctre_VideoSvc.deleteLctre_Video(lctre_Video_Gnt);
//			lctre_Video_StdntSvc
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
	
	   @Override
	   public void setApplicationContext(ApplicationContext applicationContext)
	         throws BeansException {
	      this.context = (WebApplicationContext) applicationContext;
	   }
	
	   
	   
	   
	


}
