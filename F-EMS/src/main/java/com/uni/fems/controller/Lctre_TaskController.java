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
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.FilesVO;
import com.uni.fems.dto.Lctre_TaskVO;
import com.uni.fems.dto.Lctre_Task_GntVO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Lctre_TaskService;

/**
 * <pre>
 * 강의 과제 게시판의 컨트롤러.
 * 글 작성(파일 업로드 포함) , 상세보기(파일 다운로드), 수정, 삭제 기능 구현
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
public class Lctre_TaskController implements ApplicationContextAware{
	
	private WebApplicationContext context = null;
	
	@Autowired
	private Lctre_TaskService lctre_TaskSvc;
	
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
	@RequestMapping("/taskList")
	public String Lctre_TaskList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		String url="lecture/task/taskList";
		String tpage = request.getParameter("tpage");
		String table_Nm = request.getParameter("table_Nm");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);

		Lctre_Task_GntVO lctre_Task_Gnt = new Lctre_Task_GntVO();
		lctre_Task_Gnt.setTable_Nm(table_Nm);
		if(searchVO != null ||searchVO.getKey().equals("lt_Sj")){
			lctre_Task_Gnt.setLt_Sj(searchVO.getValue());
			lctre_Task_Gnt.setLt_Cn("%");
		}else if(searchVO != null || searchVO.getKey().equals("lt_Cn")){
			lctre_Task_Gnt.setLt_Sj("%");
			lctre_Task_Gnt.setLt_Cn(searchVO.getValue());
		}else{
			lctre_Task_Gnt.setLt_Sj("%");
			lctre_Task_Gnt.setLt_Cn("%");
		}
		model.addAttribute("lctre_Task_Gnt", lctre_Task_Gnt);
		
		List<Lctre_TaskVO> lctre_TaskList = null;
		String paging = null;
		try {
			lctre_TaskList = lctre_TaskSvc.listAllLctre_Task(Integer.parseInt(tpage), lctre_Task_Gnt);
			paging = lctre_TaskSvc.pageNumber(Integer.parseInt(tpage), lctre_Task_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_TaskList", lctre_TaskList);
		int n = lctre_TaskList.size();
		model.addAttribute("lctre_TaskListSize", n);
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
	@RequestMapping(value="/writeLctre_Task", method=RequestMethod.GET)
	public String writeLctre_TaskForm(Model model, String table_Nm) throws ServletException, IOException {
		String url="lecture/task/writeLctre_Task";
		model.addAttribute("table_Nm", table_Nm);
		return url;
	}
	
	/**
	 * <pre>
	 *  작성한 게시판을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
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
	@RequestMapping(value="/writeLctre_Task", method=RequestMethod.POST)
	public String writeLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt, Lctre_FlpthVO lctre_FlpthVO, HttpServletRequest request,
								@RequestParam("uploadfile")MultipartFile uploadfile, HttpSession session, Model model)
								throws ServletException, IOException{
		String url = "redirect:taskList";
		
//		String loginUser = (String)session.getAttribute("loginUser");
		String loginUser = "bbb";
		lctre_Task_Gnt.setLt_Stdnt_No(loginUser);
		if(!uploadfile.isEmpty()){
			FilesVO vo = new FileDownload().uploadFile(uploadfile);
			
			lctre_FlpthVO.setLf_File_Type(vo.getFl_File_Type_Code());
			lctre_FlpthVO.setLf_Flpth(vo.getFl_File_Nm());
		}
		try {
			lctre_TaskSvc.insertLctre_Task(lctre_Task_Gnt, lctre_FlpthVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("table_Nm", lctre_Task_Gnt.getTable_Nm());
		
		return url;
	}
	
	/**
	 * <pre>
	 * 게시판 리스트중 하나를 상세히 본다.
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/detailLctre_Task")
	public String detailLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt, @RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/task/detailLctre_Task";
		
		Lctre_TaskVO lctre_Task = null;
		Lctre_FlpthVO lctre_Flpth = null;
		try {
			lctre_Task = lctre_TaskSvc.getLctre_Task(lctre_Task_Gnt);
			lctre_Flpth = lctre_TaskSvc.getLctre_Flpth(lctre_Task.getLt_Flpth_No());
			lctre_Task_Gnt.setLt_Cn(lctre_Task.getLt_Cn());
			lctre_Task_Gnt.setLt_Sj(lctre_Task.getLt_Sj());
			lctre_Task_Gnt.setLt_Writng_Dt(lctre_Task.getLt_Writng_Dt());
			lctre_Task_Gnt.setLt_Flpth_No(lctre_Task.getLt_Flpth_No());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("lctre_Task_Gnt",lctre_Task_Gnt);
		model.addAttribute("tpage",tpage);
		model.addAttribute("lctre_Flpth",lctre_Flpth);
		return url;
	}
	
	/**
	 * <pre>
	 * 게시판의 내용을 수정하기 위한 폼으로 이동
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Task", method=RequestMethod.GET)
	public String updateBbs_GntForm(Lctre_Task_GntVO lctre_Task_Gnt,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/task/updateLctre_Task";
		Lctre_TaskVO lctre_Task = null;
		Lctre_FlpthVO lctre_Flpth = null;
		try {
			
			lctre_Task = lctre_TaskSvc.getLctre_Task(lctre_Task_Gnt);
			lctre_Flpth = lctre_TaskSvc.getLctre_Flpth(lctre_Task.getLt_Flpth_No());
			lctre_Task_Gnt.setLt_Cn(lctre_Task.getLt_Cn());
			lctre_Task_Gnt.setLt_Sj(lctre_Task.getLt_Sj());
			lctre_Task_Gnt.setLt_Writng_Dt(lctre_Task.getLt_Writng_Dt());
			lctre_Task_Gnt.setLt_Flpth_No(lctre_Task.getLt_Flpth_No());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("lctre_Task_Gnt",lctre_Task_Gnt);
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
	 * @param lctre_Task_Gnt
	 * @param lctre_FlpthVO
	 * @param session
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Task", method=RequestMethod.POST)
	public String updateBbs_Gnt(@RequestParam int tpage, @RequestParam("uploadfile")MultipartFile uploadfile,
			Lctre_Task_GntVO lctre_Task_Gnt, Lctre_FlpthVO lctre_FlpthVO, HttpSession session, HttpServletRequest request, Model model){
		String url = "redirect:detailLctre_Task?"
				+ "table_Nm="+lctre_Task_Gnt.getTable_Nm()
				+ "&lt_Bbs_No="+lctre_Task_Gnt.getLt_Bbs_No()
				+ "&tpage="+tpage;
		
//		String loginUser = (String)session.getAttribute("loginUser");
		String loginUser = "bbb";
		lctre_Task_Gnt.setLt_Stdnt_No(loginUser);
		if(!uploadfile.isEmpty()){
			FilesVO vo = new FileDownload().uploadFile(uploadfile);
			lctre_FlpthVO.setLf_File_Type(vo.getFl_File_Type_Code());
			lctre_FlpthVO.setLf_Flpth(vo.getFl_File_Nm());
		}
		try {
			lctre_TaskSvc.updateLctre_Task(lctre_Task_Gnt, lctre_FlpthVO);
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
	 * @param lctre_Task_Gnt
	 * @param tpage
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/deleteLctre_Task")
	public String deleteNotice(Lctre_Task_GntVO lctre_Task_Gnt,@RequestParam int tpage,HttpServletRequest request, Model model){
		String url = "redirect:taskList?"
				+ "table_Nm="+lctre_Task_Gnt.getTable_Nm()
				+ "&tpage="+tpage;
		
		try {
			lctre_TaskSvc.deleteLctre_Task(lctre_Task_Gnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
	
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
