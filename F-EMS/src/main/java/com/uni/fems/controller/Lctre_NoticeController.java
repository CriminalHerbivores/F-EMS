package com.uni.fems.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.uni.fems.common.FileDownload;
import com.uni.fems.dao.Bbs_ListDAO;
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Bbs_GntVO;
import com.uni.fems.dto.Bbs_List_AtrtyVO;
import com.uni.fems.dto.Bbs_List_GntVO;
import com.uni.fems.dto.FilesVO;
import com.uni.fems.dto.Lctre_NoticeVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Bbs_Comment_GntService;
import com.uni.fems.service.Bbs_GntService;
import com.uni.fems.service.Lctre_NoticeService;
import com.uni.fems.service.Lctre_NoticeService;
import com.uni.fems.service.Notice_BbsService;

/**
 * <pre>
 * 강의 공지 게시판의 컨트롤러.
 * 글 작성, 상세보기, 수정, 삭제 기능 구현
 * </pre>
 * @author KJS
 * @since 2017.02.23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.23     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */


@Controller
@RequestMapping("/lctre")
public class Lctre_NoticeController implements ApplicationContextAware{
	
	private WebApplicationContext context = null;
	
	@Autowired
	private Lctre_NoticeService lctre_NoticeSvc;
	
//	/**
//	 * <pre>
//	 * 제너레이터 게시판의 리스트를 출력해준다
//	 * </pre>
//	 * <pre>
//	 * @param model
//	 * @param request
//	 * @param searchVO
//	 * @return url
//	 * @throws ServletException
//	 * @throws IOException
//	 * </pre>
//	 */
//	@RequestMapping("/noticeList")
//	public String Lctre_NoticeList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
//		String url="lecture/Notice/dateList";
//		String tpage = request.getParameter("tpage");
//		String table_Nm = request.getParameter("table_Nm");
//		
//		if (tpage ==null){
//			tpage= "1";
//		} else if(tpage.equals("")){
//			tpage="1";
//		}
//		model.addAttribute("tpage",tpage);
//
//		Lctre_Notice_GntVO lctre_Notice_Gnt = new Lctre_Notice_GntVO();
//		lctre_Notice_Gnt.setTable_Nm(table_Nm);
//		if(searchVO != null ||searchVO.getKey().equals("ln_Sj")){
//			lctre_Notice_Gnt.setLn_Sj(searchVO.getValue());
//			lctre_Notice_Gnt.setLn_Cn("%");
//		}else if(searchVO != null || searchVO.getKey().equals("ln_Cn")){
//			lctre_Notice_Gnt.setLn_Sj("%");
//			lctre_Notice_Gnt.setLn_Cn(searchVO.getValue());
//		}else{
//			lctre_Notice_Gnt.setLn_Sj("%");
//			lctre_Notice_Gnt.setLn_Cn("%");
//		}
//		model.addAttribute("lctre_Notice_Gnt", lctre_Notice_Gnt);
//		
//		List<Lctre_NoticeVO> lctre_NoticeList = null;
//		String paging = null;
//		try {
//			lctre_NoticeList = lctre_NoticeSvc.listAllLctre_Notice(Integer.parseInt(tpage), lctre_Notice_Gnt);
//			paging = lctre_NoticeSvc.pageNumber(Integer.parseInt(tpage), lctre_Notice_Gnt);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		model.addAttribute("lctre_NoticeList", lctre_NoticeList);
//		int n = lctre_NoticeList.size();
//		model.addAttribute("lctre_NoticeListSize", n);
//		model.addAttribute("paging", paging);
//		return url;
//		
//	}
//	
//	/**
//	 * <pre>
//	 * 게시판 작성 폼을 띄우기 위한 메서드
//	 * </pre>
//	 * <pre>
//	 * @param model
//	 * @param bbs_List_Gnt
//	 * @return url
//	 * @throws ServletException
//	 * @throws IOException
//	 * </pre>
//	 */
//	@RequestMapping(value="/writeLctre_Notice", method=RequestMethod.GET)
//	public String writeLctre_NoticeForm(Model model, String table_Nm) throws ServletException, IOException {
//		String url="lecture/date/writeLctre_Notice";
//		model.addAttribute("table_Nm", table_Nm);
//		return url;
//	}
//	
//	/**
//	 * <pre>
//	 *  작성한 게시판을 업로드 한다.
//	 * </pre>
//	 * <pre>
//	 * @param bbs_List_Gnt
//	 * @param bbs_FlpthVO
//	 * @param request
//	 * @param uploadfile
//	 * @param session
//	 * @param model
//	 * @return url
//	 * @throws ServletException
//	 * @throws IOException
//	 * </pre>
//	 */
//	@RequestMapping(value="/writeLctre_Notice", method=RequestMethod.POST)
//	public String writeLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt, Lctre_FlpthVO lctre_FlpthVO, HttpServletRequest request,
//								@RequestParam("uploadfile")MultipartFile uploadfile, HttpSession session, Model model)
//								throws ServletException, IOException{
//		String url = "redirect:dateList";
//		
//		if(!uploadfile.isEmpty()){
//			FilesVO vo = new FileDownload().uploadFile(uploadfile);
//			
//			lctre_FlpthVO.setLf_File_Type(vo.getFl_File_Type_Code());
//			lctre_FlpthVO.setLf_Flpth(vo.getFl_File_Nm());
//		}
//		try {
//			lctre_NoticeSvc.insertLctre_Notice(lctre_Notice_Gnt, lctre_FlpthVO);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		model.addAttribute("table_Nm", lctre_Notice_Gnt.getTable_Nm());
//		
//		return url;
//	}
//	
//	/**
//	 * <pre>
//	 * 게시판 리스트중 하나를 상세히 본다.
//	 * </pre>
//	 * <pre>
//	 * @param bbs_List_Gnt
//	 * @param tpage
//	 * @param model
//	 * @param request
//	 * @return url
//	 * </pre>
//	 */
//	@RequestMapping(value="/detailLctre_Notice")
//	public String detailLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt, @RequestParam int tpage, Model model, HttpServletRequest request){
//		String url="lecture/date/detailLctre_Notice";
//		
//		Lctre_NoticeVO lctre_Notice = null;
//		Lctre_FlpthVO lctre_Flpth = null;
//		try {
//			lctre_Notice = lctre_NoticeSvc.getLctre_Notice(lctre_Notice_Gnt);
//			lctre_Flpth = lctre_NoticeSvc.getLctre_Flpth(lctre_Notice.getLd_Flpth_No());
//			lctre_Notice_Gnt.setLd_Cn(lctre_Notice.getLd_Cn());
//			lctre_Notice_Gnt.setLd_Sj(lctre_Notice.getLd_Sj());
//			lctre_Notice_Gnt.setLd_Writng_Dt(lctre_Notice.getLd_Writng_Dt());
//			lctre_Notice_Gnt.setLd_Rdcnt(lctre_Notice.getLd_Rdcnt()+1);
//			lctre_Notice_Gnt.setLd_Flpth_No(lctre_Notice.getLd_Flpth_No());
//			lctre_NoticeSvc.countLctre_Notice(lctre_Notice_Gnt);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		model.addAttribute("lctre_Notice_Gnt",lctre_Notice_Gnt);
//		model.addAttribute("tpage",tpage);
//		model.addAttribute("lctre_Flpth",lctre_Flpth);
//		return url;
//	}
//	
//	/**
//	 * <pre>
//	 * 게시판의 내용을 수정하기 위한 폼으로 이동
//	 * </pre>
//	 * <pre>
//	 * @param bbs_List_Gnt
//	 * @param tpage
//	 * @param model
//	 * @param request
//	 * @return url
//	 * </pre>
//	 */
//	@RequestMapping(value="/updateLctre_Notice", method=RequestMethod.GET)
//	public String updateBbs_GntForm(Lctre_Notice_GntVO lctre_Notice_Gnt,@RequestParam int tpage, Model model, HttpServletRequest request){
//		String url="lecture/date/updateLctre_Notice";
//		Lctre_NoticeVO lctre_Notice = null;
//		Lctre_FlpthVO lctre_Flpth = null;
//		try {
//			
//			lctre_Notice = lctre_NoticeSvc.getLctre_Notice(lctre_Notice_Gnt);
//			lctre_Flpth = lctre_NoticeSvc.getLctre_Flpth(lctre_Notice.getLd_Flpth_No());
//			lctre_Notice_Gnt.setLd_Cn(lctre_Notice.getLd_Cn());
//			lctre_Notice_Gnt.setLd_Sj(lctre_Notice.getLd_Sj());
//			lctre_Notice_Gnt.setLd_Writng_Dt(lctre_Notice.getLd_Writng_Dt());
//			lctre_Notice_Gnt.setLd_Rdcnt(lctre_Notice.getLd_Rdcnt()+1);
//			lctre_Notice_Gnt.setLd_Flpth_No(lctre_Notice.getLd_Flpth_No());
//			lctre_NoticeSvc.countLctre_Notice(lctre_Notice_Gnt);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		model.addAttribute("lctre_Notice_Gnt",lctre_Notice_Gnt);
//		model.addAttribute("tpage",tpage);
//		model.addAttribute("lctre_Flpth",lctre_Flpth);
//		return url;
//	}
//	
//	/**
//	 * <pre>
//	 * 수정한 게시판의 내용을 업로드 한다.
//	 * </pre>
//	 * <pre>
//	 * @param tpage
//	 * @param uploadfile
//	 * @param bbs_List_Gnt
//	 * @param bbs_FlpthVO
//	 * @param session
//	 * @param request
//	 * @return url
//	 * </pre>
//	 */
//	@RequestMapping(value="/updateLctre_Notice", method=RequestMethod.POST)
//	public String updateBbs_Gnt(@RequestParam int tpage, @RequestParam("uploadfile")MultipartFile uploadfile,
//			Lctre_Notice_GntVO lctre_Notice_Gnt, Lctre_FlpthVO lctre_FlpthVO, HttpSession session, HttpServletRequest request, Model model){
//		String url = "redirect:detailLctre_Notice?"
//				+ "table_Nm="+lctre_Notice_Gnt.getTable_Nm()
//				+ "&bl_Bbs_No="+lctre_Notice_Gnt.getLd_Bbs_No()
//				+ "&tpage="+tpage;
//		
//		if(!uploadfile.isEmpty()){
//			FilesVO vo = new FileDownload().uploadFile(uploadfile);
//			lctre_FlpthVO.setLf_File_Type(vo.getFl_File_Type_Code());
//			lctre_FlpthVO.setLf_Flpth(vo.getFl_File_Nm());
//		}
//		try {
//			lctre_NoticeSvc.updateLctre_Notice(lctre_Notice_Gnt, lctre_FlpthVO);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return url;
//	}
//	
//	/**
//	 * <pre>
//	 * 해당하는 게시판을 삭제처리하는 메서드
//	 * </pre>
//	 * <pre>
//	 * @param bbs_List_Gnt
//	 * @param tpage
//	 * @param request
//	 * @return url
//	 * </pre>
//	 */
//	@RequestMapping(value="/deleteLctre_Notice")
//	public String deleteNotice(Lctre_Notice_GntVO lctre_Notice_Gnt,@RequestParam int tpage,HttpServletRequest request, Model model){
//		String url = "redirect:dateList?"
//				+ "table_Nm="+lctre_Notice_Gnt.getTable_Nm()
//				+ "&tpage="+tpage;
//		String bbs_code = request.getServletPath();
//		String[] values = bbs_code.split("/");
//		
//		Bbs_FlpthVO bbs_flpthVO = new Bbs_FlpthVO();
//		 
//		
//		try {
//			lctre_NoticeSvc.deleteLctre_Notice(lctre_Notice_Gnt);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return url;
//	}
//	
//	
//	/**
//	 * <pre>
//	 * 첨부파일 다운로드를 처리하는 메서드
//	 * </pre>
//	 * <pre>
//	 * @param fileId
//	 * @param response
//	 * @param filename
//	 * @return
//	 * @throws IOException
//	 * </pre>
//	 */
//	@RequestMapping("/file/{fileId}")
//	   public ModelAndView download(@PathVariable String fileId,
//	         HttpServletResponse response, @RequestParam String filename) throws IOException {
//		   
//		   String downloadFilePath ="D:/F-EMS/F-EMS/F-EMS/src/main/webapp/resources/files";
//		   File downloadFile =  new File(downloadFilePath, filename);
//		  
//		   response.setCharacterEncoding("utf-8");
//	      
//	      if(downloadFile == null) {
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
//	         return null;
//	      }
//	      return new ModelAndView("download", "downloadFile", downloadFile);
//	   }
	   
	   @Override
	   public void setApplicationContext(ApplicationContext applicationContext)
	         throws BeansException {
	      this.context = (WebApplicationContext) applicationContext;
	   }
	
	   
	   
	   
	


}
