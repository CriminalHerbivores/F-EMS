package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Notice_BbsService;
/**
 * <pre>
 * 강의part 게시판 리스트 Controller
 * </pre>
 * @author 송선호
 * @since 2017.02.11
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.11     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/lctre")
public class LctreDetailController {
	@Autowired
	private Notice_BbsService notice_BbsSvc;
	public void setNotice_BbsSvc(Notice_BbsService notice_BbsSvc) {
		this.notice_BbsSvc = notice_BbsSvc;
	}
	
	@RequestMapping("/lctreList")
	public String lctreList(HttpServletRequest request, HttpSession session) {
		String url = "lecture/lectureList";
			
		return url;
		
	}
	
	@RequestMapping("/noticeList")
	public String noticeList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		
		
		String url="lecture/noticeList";
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
		int n = noticeList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	@RequestMapping("/fileList")
	public String fileList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		
		
		String url="lecture/fileList";
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
		int n = noticeList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	@RequestMapping("/qnaList")
	public String qnaList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		
		
		String url="lecture/qnaList";
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
		int n = noticeList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	@RequestMapping("/hwList")
	public String hwList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		
		
		String url="lecture/hwList";
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
		int n = noticeList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	@RequestMapping("/mediaList")
	public String mediaList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		
		
		String url="lecture/mediaList";
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
		int n = noticeList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	@RequestMapping("/attendList")
	public String attendList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		
		
		String url="lecture/attendList";
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
		int n = noticeList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	@RequestMapping("/actPln")
	public String actPln(Model model, HttpServletRequest request, Lctre_ActplnVO actplnVO){
		
		String url="lecture/actPln";
		
		return url;
		
	}

}
