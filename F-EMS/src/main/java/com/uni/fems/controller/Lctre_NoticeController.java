package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.uni.fems.dto.Lctre_NoticeVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Lctre_NoticeService;

/**
 * <pre>
 * 강의 공지 게시판의 컨트롤러.
 * 글 작성, 상세보기, 수정, 삭제 기능 구현
 * </pre>
 * @author KJS
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */


@Controller
@RequestMapping("/lctre")
public class Lctre_NoticeController implements ApplicationContextAware{
	
	private WebApplicationContext context = null;
	
	@Autowired
	private Lctre_NoticeService lctre_NoticeSvc;
	
	/**
	 * <pre>
	 * 공지 게시판의 리스트를 출력해준다
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
	public String Lctre_NoticeList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		String url="lecture/notice/NoticeList";
		String tpage = request.getParameter("tpage");
		String table_Nm = request.getParameter("table_Nm");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);

		Lctre_Notice_GntVO lctre_Notice_Gnt = new Lctre_Notice_GntVO();
		lctre_Notice_Gnt.setTable_Nm(table_Nm);
		if(searchVO != null ||searchVO.getKey().equals("ln_Sj")){
			lctre_Notice_Gnt.setLn_Sj(searchVO.getValue());
			lctre_Notice_Gnt.setLn_Cn("%");
		}else if(searchVO != null || searchVO.getKey().equals("ln_Cn")){
			lctre_Notice_Gnt.setLn_Sj("%");
			lctre_Notice_Gnt.setLn_Cn(searchVO.getValue());
		}else{
			lctre_Notice_Gnt.setLn_Sj("%");
			lctre_Notice_Gnt.setLn_Cn("%");
		}
		model.addAttribute("lctre_Notice_Gnt", lctre_Notice_Gnt);
		
		List<Lctre_NoticeVO> lctre_NoticeList = null;
		String paging = null;
		try {
			lctre_NoticeList = lctre_NoticeSvc.listAllLctre_Notice(Integer.parseInt(tpage), lctre_Notice_Gnt);
			paging = lctre_NoticeSvc.pageNumber(Integer.parseInt(tpage), lctre_Notice_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_NoticeList", lctre_NoticeList);
		int n = lctre_NoticeList.size();
		model.addAttribute("lctre_NoticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	/**
	 * <pre>
	 * 공지 게시판 작성 폼을 띄우기 위한 메서드
	 * </pre>
	 * <pre>
	 * @param model
	 * @param table_Nm
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/writeLctre_Notice", method=RequestMethod.GET)
	public String writeLctre_NoticeForm(Model model, String table_Nm) throws ServletException, IOException {
		String url="lecture/notice/writeLctre_Notice";
		model.addAttribute("table_Nm", table_Nm);
		return url;
	}
	
	/**
	 * <pre>
	 *  작성한 게시판을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param lctre_Notice_Gnt
	 * @param request
	 * @param session
	 * @param model
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/writeLctre_Notice", method=RequestMethod.POST)
	public String writeLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt, HttpServletRequest request,HttpSession session, Model model)
								throws ServletException, IOException{
		String url = "redirect:noticeList";
		
		try {
			lctre_NoticeSvc.insertLctre_Notice(lctre_Notice_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("table_Nm", lctre_Notice_Gnt.getTable_Nm());
		
		return url;
	}
	
	/**
	 * <pre>
	 * 공지 게시판 리스트중 하나를 상세히 본다.
	 * </pre>
	 * <pre>
	 * @param lctre_Notice_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/detailLctre_Notice")
	public String detailLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt, @RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/notice/detailLctre_Notice";
		System.out.println("lctre_Notice_Gnt : "+lctre_Notice_Gnt);
		Lctre_NoticeVO lctre_Notice = null;
		try {
			lctre_Notice = lctre_NoticeSvc.getLctre_Notice(lctre_Notice_Gnt);
			lctre_Notice_Gnt.setLn_Cn(lctre_Notice.getLn_Cn());
			lctre_Notice_Gnt.setLn_Sj(lctre_Notice.getLn_Sj());
			lctre_Notice_Gnt.setLn_Writng_Dt(lctre_Notice.getLn_Writng_Dt());
			lctre_Notice_Gnt.setLn_Rdcnt(lctre_Notice.getLn_Rdcnt()+1);
			lctre_NoticeSvc.countLctre_Notice(lctre_Notice_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_Notice_Gnt",lctre_Notice_Gnt);
		model.addAttribute("tpage",tpage);
		return url;
	}
	
	/**
	 * <pre>
	 * 공지 게시판의 내용을 수정하기 위한 폼으로 이동
	 * </pre>
	 * <pre>
	 * @param lctre_Notice_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Notice", method=RequestMethod.GET)
	public String updateBbs_GntForm(Lctre_Notice_GntVO lctre_Notice_Gnt,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/notice/updateLctre_Notice";
		Lctre_NoticeVO lctre_Notice = null;
		try {
			
			lctre_Notice = lctre_NoticeSvc.getLctre_Notice(lctre_Notice_Gnt);
			lctre_Notice_Gnt.setLn_Cn(lctre_Notice.getLn_Cn());
			lctre_Notice_Gnt.setLn_Sj(lctre_Notice.getLn_Sj());
			lctre_Notice_Gnt.setLn_Writng_Dt(lctre_Notice.getLn_Writng_Dt());
			lctre_Notice_Gnt.setLn_Rdcnt(lctre_Notice.getLn_Rdcnt());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_Notice_Gnt",lctre_Notice_Gnt);
		model.addAttribute("tpage",tpage);
		return url;
	}
	
	/**
	 * <pre>
	 * 수정한 게시판의 내용을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Notice_Gnt
	 * @param session
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Notice", method=RequestMethod.POST)
	public String updateBbs_Gnt(@RequestParam int tpage,Lctre_Notice_GntVO lctre_Notice_Gnt, HttpSession session, HttpServletRequest request, Model model){
		String url = "redirect:detailLctre_Notice?"
				+ "table_Nm="+lctre_Notice_Gnt.getTable_Nm()
				+ "&ln_Bbs_No="+lctre_Notice_Gnt.getLn_Bbs_No()
				+ "&tpage="+tpage;
		
		try {
			lctre_NoticeSvc.updateLctre_Notice(lctre_Notice_Gnt);
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
	 * @param lctre_Notice_Gnt
	 * @param tpage
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/deleteLctre_Notice")
	public String deleteNotice(Lctre_Notice_GntVO lctre_Notice_Gnt,@RequestParam int tpage,HttpServletRequest request, Model model){
		String url = "redirect:noticeList?"
				+ "table_Nm="+lctre_Notice_Gnt.getTable_Nm()
				+ "&tpage="+tpage;
		
		try {
			lctre_NoticeSvc.deleteLctre_Notice(lctre_Notice_Gnt);
		} catch (SQLException e) {
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
