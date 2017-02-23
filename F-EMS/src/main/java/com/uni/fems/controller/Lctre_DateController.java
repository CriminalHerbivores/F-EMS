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
import com.uni.fems.dto.Lctre_DateVO;
import com.uni.fems.dto.Lctre_Date_GntVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Bbs_Comment_GntService;
import com.uni.fems.service.Bbs_GntService;
import com.uni.fems.service.Lctre_DateService;
import com.uni.fems.service.Notice_BbsService;

/**
 * <pre>
 * 강의 자료 게시판의 컨트롤러.
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
@RequestMapping("/lctre_date")
public class Lctre_DateController{
	
	
	@Autowired
	private Lctre_DateService lctre_DateSvc;
	
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
	@RequestMapping("/lctre_date_List")
	public String bbsList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		String url="generator/bbs/bbsList";
		String tpage = request.getParameter("tpage");
		String table_Nm = request.getParameter("table_Nm");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);

		Lctre_Date_GntVO lctre_Date_Gnt = new Lctre_Date_GntVO();
		lctre_Date_Gnt.setTable_Nm(table_Nm);
		if(searchVO != null ||searchVO.getKey().equals("ld_Sj")){
			lctre_Date_Gnt.setLd_Sj(searchVO.getValue());
			lctre_Date_Gnt.setLd_Cn("%");
		}else if(searchVO != null || searchVO.getKey().equals("ld_Cn")){
			lctre_Date_Gnt.setLd_Sj("%");
			lctre_Date_Gnt.setLd_Cn(searchVO.getValue());
		}else{
			lctre_Date_Gnt.setLd_Sj("%");
			lctre_Date_Gnt.setLd_Cn("%");
		}
		model.addAttribute("lctre_Date_Gnt", lctre_Date_Gnt);
		
		List<Lctre_DateVO> lctre_DateList = null;
		String paging = null;
		try {
			lctre_DateList = lctre_DateSvc.listAllLctre_Date(Integer.parseInt(tpage), lctre_Date_Gnt);
			paging = lctre_DateSvc.pageNumber(Integer.parseInt(tpage), lctre_Date_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_DateList", lctre_DateList);
		int n = lctre_DateList.size();
		model.addAttribute("lctre_DateListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
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
//	@RequestMapping(value="/writeBbs_Gnt", method=RequestMethod.GET)
//	public String writeBbs_GntForm(Model model, Bbs_List_GntVO bbs_List_Gnt) throws ServletException, IOException {
//		String url="generator/bbs/writeBbs_Gnt";
//		System.out.println("bbs_List_Gnt : "+bbs_List_Gnt);
//		model.addAttribute("bbs_List_Gnt", bbs_List_Gnt);
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
//	@RequestMapping(value="/writeBbs_Gnt", method=RequestMethod.POST)
//	public String writeBbs_Gnt(Bbs_List_GntVO bbs_List_Gnt, Bbs_FlpthVO bbs_FlpthVO, HttpServletRequest request,
//								@RequestParam("uploadfile")MultipartFile uploadfile, HttpSession session, Model model)
//								throws ServletException, IOException{
//		String url = "redirect:bbsList";
//		
//		String loginUser = (String)session.getAttribute("loginUser");
////		bbs_List_Gnt.setBb_Sklstf_No(loginUser);
//		bbs_List_Gnt.setBb_Sklstf_No("1111");
//		
//
//		
//		if(!uploadfile.isEmpty()){
//			FilesVO vo = new FileDownload().uploadFile(uploadfile);
//			String bbs_code = request.getServletPath();
//			String[] values = bbs_code.split("/");
//			
//			bbs_FlpthVO.setBf_Bbs_Code(values[1]);
//			bbs_FlpthVO.setBf_File_Type_Code(vo.getFl_File_Type_Code());
//			bbs_FlpthVO.setBf_File_Nm(vo.getFl_File_Nm());
//		}
//		try {
//			bbs_GntSvc.insertBbs_Gnt(bbs_List_Gnt, bbs_FlpthVO);;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		model.addAttribute("bl_Bbs_No", bbs_List_Gnt.getBl_Bbs_No());
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
//	@RequestMapping(value="/detailBbs_Gnt")
//	public String detailBbs_Gnt(Bbs_List_GntVO bbs_List_Gnt, @RequestParam int tpage, Model model, HttpServletRequest request){
//		String url="generator/bbs/detailBbs_Gnt";
//		Bbs_FlpthVO flpth = new Bbs_FlpthVO();
//		Bbs_GntVO bbs_Gnt = null;
//		List<Bbs_FlpthVO> flpthList = null;
//		String bbs_code = request.getServletPath();
//		String[] values = bbs_code.split("/");
//		flpth.setBf_Bbs_No_No(bbs_List_Gnt.getBb_Bbs_No());
//		flpth.setBf_Bbs_Code(values[1]);
//		try {
//			bbs_Gnt = bbs_GntSvc.getBbs_Gnt(bbs_List_Gnt);
//			bbs_GntSvc.countBbs_Gnt(bbs_List_Gnt);
//			flpthList = bbs_GntSvc.getBbs_Flpth(flpth);
//			bbs_List_Gnt.setBb_Cn(bbs_Gnt.getBb_Cn());
//			bbs_List_Gnt.setBb_Rdcnt(bbs_Gnt.getBb_Rdcnt()+1);
//			bbs_List_Gnt.setBb_Sj(bbs_Gnt.getBb_Sj());
//			bbs_List_Gnt.setBb_Sklstf_No(bbs_Gnt.getBb_Sklstf_No());
//			bbs_List_Gnt.setBb_Writng_dt(bbs_Gnt.getBb_Writng_dt());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		model.addAttribute("bbs_List_Gnt",bbs_List_Gnt);
//		model.addAttribute("tpage",tpage);
//		model.addAttribute("flpthList",flpthList);
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
//	@RequestMapping(value="/updateBbs_Gnt", method=RequestMethod.GET)
//	public String updateBbs_GntForm(Bbs_List_GntVO bbs_List_Gnt,@RequestParam int tpage, Model model, HttpServletRequest request){
//		String url="generator/bbs/updateBbs_Gnt";
//		Bbs_GntVO bbs_Gnt = null;
//		Bbs_FlpthVO flpth = new Bbs_FlpthVO();
//		List<Bbs_FlpthVO> flpthList = null;
//		String bbs_code = request.getServletPath();
//		String[] values = bbs_code.split("/");
//		flpth.setBf_Bbs_No_No(bbs_List_Gnt.getBb_Bbs_No());
//		flpth.setBf_Bbs_Code(values[1]);
//		try {
//			bbs_Gnt = bbs_GntSvc.getBbs_Gnt(bbs_List_Gnt);
//			flpthList = bbs_GntSvc.getBbs_Flpth(flpth);
//			bbs_List_Gnt.setBb_Cn(bbs_Gnt.getBb_Cn());
//			bbs_List_Gnt.setBb_Rdcnt(bbs_Gnt.getBb_Rdcnt());
//			bbs_List_Gnt.setBb_Sj(bbs_Gnt.getBb_Sj());
//			bbs_List_Gnt.setBb_Sklstf_No(bbs_Gnt.getBb_Sklstf_No());
//			bbs_List_Gnt.setBb_Writng_dt(bbs_Gnt.getBb_Writng_dt());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("bbs_List_Gnt",bbs_List_Gnt);
//		model.addAttribute("tpage",tpage);
//		model.addAttribute("flpthList",flpthList);
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
//	@RequestMapping(value="/updateBbs_Gnt", method=RequestMethod.POST)
//	public String updateBbs_Gnt(@RequestParam int tpage, @RequestParam("uploadfile")MultipartFile uploadfile,Bbs_List_GntVO bbs_List_Gnt, Bbs_FlpthVO bbs_FlpthVO, HttpSession session, HttpServletRequest request, Model model){
//		String url = "redirect:detailBbs_Gnt?"
//				+ "bb_Bbs_No="+bbs_List_Gnt.getBb_Bbs_No()
//				+ "&bl_Bbs_No="+bbs_List_Gnt.getBl_Bbs_No()
//				+ "&bl_Bbs_Nm="+bbs_List_Gnt.getBl_Bbs_Nm()
//				+ "&bl_Table_Nm="+bbs_List_Gnt.getBl_Table_Nm()
//				+ "&tpage="+tpage;
//		System.out.println("bbs_List_Gnt : "+bbs_List_Gnt);
//		String loginUser = (String) session.getAttribute("loginUser");
//		bbs_List_Gnt.setBb_Sklstf_No(loginUser);
//		
//		String uploadFilePath ="D:/F-EMS/F-EMS/F-EMS/src/main/webapp/resources/files";
//
//		Bbs_FlpthVO updateFlpthVO = new Bbs_FlpthVO();
//		
//		if(!uploadfile.isEmpty()){
//			File file = new File(uploadFilePath, "$$"+System.currentTimeMillis()+uploadfile.getOriginalFilename());
//			String fileName = file.getName();
//			int pos = fileName.lastIndexOf(".");
//			try{
//			uploadfile.transferTo(file);
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			String bbs_code = request.getServletPath();
//			String[] values = bbs_code.split("/");
//			String extension = fileName.substring(pos+1).toLowerCase();
//			updateFlpthVO.setBf_Bbs_No_No(bbs_List_Gnt.getBb_Bbs_No());
//			updateFlpthVO.setBf_Bbs_Code(values[1]);
//			updateFlpthVO.setBf_File_Type_Code(extension);
//			updateFlpthVO.setBf_File_Nm(fileName);
//			
//		}
//		try {
//			bbs_GntSvc.updateBbs_Gnt(bbs_List_Gnt, bbs_FlpthVO.getBf_No(), updateFlpthVO);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
//	@RequestMapping(value="/deleteBbs_Gnt")
//	public String deleteNotice(Bbs_List_GntVO bbs_List_Gnt,@RequestParam int tpage,HttpServletRequest request, Model model){
//		String url = "redirect:bbsList?"
//				+ "bl_Bbs_No="+bbs_List_Gnt.getBl_Bbs_No()
//				+ "&tpage="+tpage;
//		
//		String bbs_code = request.getServletPath();
//		String[] values = bbs_code.split("/");
//		
//		Bbs_FlpthVO bbs_flpthVO = new Bbs_FlpthVO();
//		 
//		 bbs_flpthVO.setBf_Bbs_No_No(bbs_List_Gnt.getBb_Bbs_No());
//		 bbs_flpthVO.setBf_Bbs_Code(values[1]);
//		 
//		
//		
//		try {
//			bbs_GntSvc.deleteBbs_Gnt(bbs_List_Gnt, bbs_flpthVO);
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
//	   
//	   @Override
//	   public void setApplicationContext(ApplicationContext applicationContext)
//	         throws BeansException {
//	      this.context = (WebApplicationContext) applicationContext;
//	   }
//	
	   
	   
	   
	


}
