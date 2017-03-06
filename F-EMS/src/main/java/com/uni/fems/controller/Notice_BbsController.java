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
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Notice_BbsService;

/**
 * <pre>
 * 공지게시판 Controller.
 * 글 작성(파일 업로드 포함) , 상세보기(파일 다운로드), 수정, 삭제 기능 구현
 * </pre>
 * @author 송선호
 * @since 2017.02.01
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.01     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/notice_bbs")
public class Notice_BbsController implements ApplicationContextAware{
	
	
	
	private WebApplicationContext context = null;
	
	@Autowired
	private Notice_BbsService notice_BbsSvc;
	public void setNotice_BbsSvc(Notice_BbsService notice_BbsSvc) {
		this.notice_BbsSvc = notice_BbsSvc;
	}
	
	/*@RequestMapping("/noticeList")
	public String noticeList(Model model) throws ServletException, IOException{
		String url="board_management/noticeList";
		List<Notice_BbsVO> noticeList = null;
		try {
			noticeList = notice_BbsSvc.listAllNotice_Bbs1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("noticeList", noticeList);
		return url;
		
	}*/
	

	/**
	 * <pre>
	 * 공지게시판 리스트를 출력하기 위해 값을 model에 저장하여 보내주는 메서드
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
	@RequestMapping("/noticeList")
	public String noticeList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		String url="board_management/noticeList";
		String tpage = request.getParameter("tpage");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		if(searchVO.getValue()==null)
			searchVO.setValue("");
		if(searchVO.getKey()==null)
			searchVO.setKey("nb_Sj");
		
		List<Notice_BbsVO> noticeList = null;
		String paging = null;
		try {
			noticeList = notice_BbsSvc.listAllNotice_Bbs(Integer.parseInt(tpage), searchVO);
			paging = notice_BbsSvc.pageNumber(Integer.parseInt(tpage),searchVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	/**
	 * <pre>
	 * 공지게시판 작성 폼을 띄우기 위한 메서드
	 * </pre>
	 * <pre>
	 * @param model
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/writeNotice", method=RequestMethod.GET)
	public String writeNoticeForm(Model model) throws ServletException, IOException {
		String url="board_management/writeNotice";
		return url;
	}
	
	/**
	 * <pre>
	 *  작성한 게시판 내용을 바탕으로 값을 DB에 저장 또는 처리하는 메서드(업로드)
	 * </pre>
	 * <pre>
	 * @param notice_BbsVO
	 * @param bbs_FlpthVO
	 * @param request
	 * @param uploadfile
	 * @param session
	 * @param model
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/writeNotice", method=RequestMethod.POST)
	public String writeNotice(Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO, HttpServletRequest request,
								@RequestParam("uploadfile")MultipartFile uploadfile, HttpSession session, Model model)
								throws ServletException, IOException{
		String url = "redirect:noticeList";
		
		String loginUser = (String)session.getAttribute("loginUser");
		notice_BbsVO.setNb_Sklstf_No(loginUser);
		
		/*String savePath="resources/files";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);*/ //업로드파일 저장경로가 이상 ㅠㅠ;
		
		/*
		String uploadFilePath ="D:/F-EMS/F-EMS/F-EMS/src/main/webapp/resources/files";
	
		if(!uploadfile.isEmpty()){
			File file = new File(uploadFilePath, "$$"+System.currentTimeMillis()+uploadfile.getOriginalFilename());
			String fileName = file.getName();
			int pos = fileName.lastIndexOf(".");
			try{
			uploadfile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String bbs_code = request.getServletPath();
			String[] values = bbs_code.split("/");
			String extension = fileName.substring(pos+1).toLowerCase();
			
			bbs_FlpthVO.setBf_Bbs_Code(values[1]);
			bbs_FlpthVO.setBf_File_Type_Code(extension);
			bbs_FlpthVO.setBf_File_Nm(fileName);
			
		}
		*/
		
		if(!uploadfile.isEmpty()){
			FilesVO vo = new FileDownload().uploadFile(uploadfile);
			String bbs_code = request.getServletPath();
			String[] values = bbs_code.split("/");
			
			bbs_FlpthVO.setBf_Bbs_Code(values[1]);
			bbs_FlpthVO.setBf_File_Type_Code(vo.getFl_File_Type_Code());
			bbs_FlpthVO.setBf_File_Nm(vo.getFl_File_Nm());
		}
		try {
			notice_BbsSvc.insertNotice_Bbs(notice_BbsVO,bbs_FlpthVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	/**
	 * <pre>
	 * 공지게시판 상세페이지를 출력하는 메서드
	 * </pre>
	 * <pre>
	 * @param no
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/detailNotice")
	public String detailNotice(@RequestParam int no,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="board_management/detailNotice";
		Notice_BbsVO notice = null;
		Bbs_FlpthVO flpth = new Bbs_FlpthVO();
		List<Bbs_FlpthVO> flpthList = null;
		String bbs_code = request.getServletPath();
		String[] values = bbs_code.split("/");
		flpth.setBf_Bbs_No_No(no);
		flpth.setBf_Bbs_Code(values[1]);
		try {
			notice = (Notice_BbsVO)notice_BbsSvc.getNotice_Bbs(no);
			notice_BbsSvc.countNotice_Bbs(notice);
			notice.setNb_Rdcnt(notice.getNb_Rdcnt()+1);
			
			
			flpthList = notice_BbsSvc.getBbs_Flpth(flpth);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		model.addAttribute("notice",notice);
		model.addAttribute("tpage",tpage);
		model.addAttribute("flpthList",flpthList);
		return url;
		
		
	}
	
	/**
	 * <pre>
	 * 공지게시판 수정 폼을 띄워주는 메서드
	 * </pre>
	 * <pre>
	 * @param no
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateNotice", method=RequestMethod.GET)
	public String updateNoticeForm(@RequestParam int no,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="board_management/updateNotice";
		Notice_BbsVO notice = null;
		Bbs_FlpthVO flpth = new Bbs_FlpthVO();
		List<Bbs_FlpthVO> flpthList = null;
		String bbs_code = request.getServletPath();
		String[] values = bbs_code.split("/");
		flpth.setBf_Bbs_No_No(no);
		flpth.setBf_Bbs_Code(values[1]);
		try {
			notice = notice_BbsSvc.getNotice_Bbs(no);
			flpthList = notice_BbsSvc.getBbs_Flpth(flpth);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("tpage",tpage);
		model.addAttribute("notice",notice);
		model.addAttribute("flpthList",flpthList);
		return url;
	}
	
	/**
	 * <pre>
	 * 수정한 게시판 내용을 바탕으로 데이터를 수정 또는 처리하는 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param uploadfile
	 * @param notice_BbsVO
	 * @param bbs_FlpthVO
	 * @param session
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateNotice", method=RequestMethod.POST)
	public String updateNotice(@RequestParam int tpage, @RequestParam("uploadfile")MultipartFile uploadfile,Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO, HttpSession session, HttpServletRequest request){
		String url = "redirect:detailNotice?no="+notice_BbsVO.getNb_Bbs_No()+"&tpage="+tpage;
		
		String loginUser = (String) session.getAttribute("loginUser");
		notice_BbsVO.setNb_Sklstf_No(loginUser);
		
		String uploadFilePath ="D:/F-EMS/F-EMS/F-EMS/src/main/webapp/resources/files";

		Bbs_FlpthVO updateFlpthVO = new Bbs_FlpthVO();
		
		if(!uploadfile.isEmpty()){
			File file = new File(uploadFilePath, "$$"+System.currentTimeMillis()+uploadfile.getOriginalFilename());
			String fileName = file.getName();
			int pos = fileName.lastIndexOf(".");
			try{
			uploadfile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String bbs_code = request.getServletPath();
			String[] values = bbs_code.split("/");
			String extension = fileName.substring(pos+1).toLowerCase();
			updateFlpthVO.setBf_Bbs_No_No(notice_BbsVO.getNb_Bbs_No());
			updateFlpthVO.setBf_Bbs_Code(values[1]);
			updateFlpthVO.setBf_File_Type_Code(extension);
			updateFlpthVO.setBf_File_Nm(fileName);
			
		}
		try {
			notice_BbsSvc.updateNotice_Bbs(notice_BbsVO, bbs_FlpthVO.getBf_No(), updateFlpthVO);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	/**
	 * <pre>
	 * 해당하는 게시판을 삭제처리하는 메서드
	 * </pre>
	 * <pre>
	 * @param no
	 * @param tpage
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/deleteNotice")
	public String deleteNotice(@RequestParam int no,@RequestParam int tpage,HttpServletRequest request){
		String url = "redirect:noticeList?tpage="+tpage;
		
		String bbs_code = request.getServletPath();
		String[] values = bbs_code.split("/");
		
		Bbs_FlpthVO bbs_flpthVO = new Bbs_FlpthVO();
		 
		 bbs_flpthVO.setBf_Bbs_No_No(no);
		 bbs_flpthVO.setBf_Bbs_Code(values[1]);
		 
		
		
		try {
			notice_BbsSvc.deleteNotice_Bbs(no, bbs_flpthVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	
	/**
	 * <pre>
	 * 첨부파일 다운로드를 처리하는 메서드
	 * </pre>
	 * <pre>
	 * @param fileId
	 * @param response
	 * @param filename
	 * @return
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/file/{fileId}")
	   public ModelAndView download(@PathVariable String fileId,
	         HttpServletResponse response, @RequestParam String filename) throws IOException {
		   
		   String downloadFilePath ="D:/F-EMS/F-EMS/F-EMS/src/main/webapp/resources/files";
		   File downloadFile =  new File(downloadFilePath, filename);
		  
		   response.setCharacterEncoding("utf-8");
	      
	      if(downloadFile == null) {
	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         return null;
	      }
	      return new ModelAndView("download", "downloadFile", downloadFile);
	   }
	   
	   @Override
	   public void setApplicationContext(ApplicationContext applicationContext)
	         throws BeansException {
	      this.context = (WebApplicationContext) applicationContext;
	   }
	
/*	   @RequestMapping("/commentInsert")*/
	   
	   
	   
	


}















