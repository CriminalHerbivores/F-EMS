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

import com.uni.fems.dto.Lctre_QnaVO;
import com.uni.fems.dto.Lctre_Qna_GntVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Lctre_QnaService;

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
public class Lctre_QnaController implements ApplicationContextAware{
	
	private WebApplicationContext context = null;
	
	@Autowired
	private Lctre_QnaService lctre_QnaSvc;
	
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
	@RequestMapping("/qnaList")
	public String Lctre_QnaList(Model model,HttpServletRequest request, SearchVO searchVO) throws ServletException, IOException{
		String url="lecture/qna/qnaList";
		String tpage = request.getParameter("tpage");
		String table_Nm = request.getParameter("table_Nm");
		
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);

		Lctre_Qna_GntVO lctre_Qna_Gnt = new Lctre_Qna_GntVO();
		lctre_Qna_Gnt.setTable_Nm(table_Nm);
		
		if(searchVO.getKey()==null) searchVO.setKey("lq_Sj");
		if(searchVO.getValue()==null) searchVO.setValue("");
		if(searchVO.getKey().equals("lq_Sj")){
			lctre_Qna_Gnt.setLq_Sj(searchVO.getValue());
			lctre_Qna_Gnt.setLq_Cn("%");
		}else if(searchVO.getKey().equals("lq_Cn")){
			lctre_Qna_Gnt.setLq_Sj("%");
			lctre_Qna_Gnt.setLq_Cn(searchVO.getValue());
		}
		
		model.addAttribute("lctre_Qna_Gnt", lctre_Qna_Gnt);
		
		List<Lctre_QnaVO> lctre_QnaList = null;
		String paging = null;
		try {
			lctre_QnaList = lctre_QnaSvc.listAllLctre_Qna(Integer.parseInt(tpage), lctre_Qna_Gnt);
			paging = lctre_QnaSvc.pageNumber(Integer.parseInt(tpage), lctre_Qna_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_QnaList", lctre_QnaList);
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
	@RequestMapping(value="/writeLctre_Qna", method=RequestMethod.GET)
	public String writeLctre_QnaForm(Model model, String table_Nm) throws ServletException, IOException {
		String url="lecture/qna/writeLctre_Qna";
		model.addAttribute("table_Nm", table_Nm);
		return url;
	}
	
	/**
	 * <pre>
	 *  작성한 게시판을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @param request
	 * @param session
	 * @param model
	 * @return url
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value="/writeLctre_Qna", method=RequestMethod.POST)
	public String writeLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt, HttpServletRequest request,HttpSession session, Model model)
								throws ServletException, IOException{
		String url = "redirect:qnaList";

		String loginUser = (String)session.getAttribute("loginUser");
		lctre_Qna_Gnt.setLq_Stdnt_No(loginUser);
		
		try {
			lctre_QnaSvc.insertLctre_Qna(lctre_Qna_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("table_Nm", lctre_Qna_Gnt.getTable_Nm());
		
		return url;
	}
	
	/**
	 * <pre>
	 * 공지 게시판 리스트중 하나를 상세히 본다.
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/detailLctre_Qna", method=RequestMethod.GET)
	public String detailLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt, @RequestParam int tpage, Model model){
		String url="lecture/qna/detailLctre_Qna";
		Lctre_QnaVO lctre_Qna = null;
		try {
			lctre_Qna = lctre_QnaSvc.getLctre_Qna(lctre_Qna_Gnt);
			lctre_Qna_Gnt.setLq_Stdnt_No(lctre_Qna.getLq_Stdnt_No());
			lctre_Qna_Gnt.setLq_Cn(lctre_Qna.getLq_Cn());
			lctre_Qna_Gnt.setLq_Sj(lctre_Qna.getLq_Sj());
			lctre_Qna_Gnt.setLq_Reply(lctre_Qna.getLq_Reply());
			lctre_Qna_Gnt.setLq_Writng_Dt(lctre_Qna.getLq_Writng_Dt());
			lctre_Qna_Gnt.setLq_Rdcnt(lctre_Qna.getLq_Rdcnt()+1);
			lctre_QnaSvc.countLctre_Qna(lctre_Qna_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_Qna_Gnt",lctre_Qna_Gnt);
		model.addAttribute("tpage",tpage);
		return url;
	}
	
	/**
	 * <pre>
	 * 답변 작성
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/detailLctre_Qna", method=RequestMethod.POST)
	public String updateBbsReply(@RequestParam int tpage,Lctre_Qna_GntVO lctre_Qna_Gnt){
		String url = "redirect:qnaList?"
				+ "table_Nm="+lctre_Qna_Gnt.getTable_Nm()
				+ "&tpage="+tpage;
		
		try {
			lctre_QnaSvc.updateLctre_Qna_Reply(lctre_Qna_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	/**
	 * <pre>
	 * 공지 게시판의 내용을 수정하기 위한 폼으로 이동
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Qna", method=RequestMethod.GET)
	public String updateBbs_GntForm(Lctre_Qna_GntVO lctre_Qna_Gnt,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/qna/updateLctre_Qna";
		Lctre_QnaVO lctre_Qna = null;
		try {
			
			lctre_Qna = lctre_QnaSvc.getLctre_Qna(lctre_Qna_Gnt);
			lctre_Qna_Gnt.setLq_Cn(lctre_Qna.getLq_Cn());
			lctre_Qna_Gnt.setLq_Sj(lctre_Qna.getLq_Sj());
			lctre_Qna_Gnt.setLq_Writng_Dt(lctre_Qna.getLq_Writng_Dt());
			lctre_Qna_Gnt.setLq_Rdcnt(lctre_Qna.getLq_Rdcnt());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_Qna_Gnt",lctre_Qna_Gnt);
		model.addAttribute("tpage",tpage);
		return url;
	}
	
	/**
	 * <pre>
	 * 수정한 게시판의 내용을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Qna_Gnt
	 * @param session
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Qna", method=RequestMethod.POST)
	public String updateBbs_Gnt(@RequestParam int tpage,Lctre_Qna_GntVO lctre_Qna_Gnt, HttpSession session, HttpServletRequest request, Model model){
		String url = "redirect:detailLctre_Qna?"
				+ "table_Nm="+lctre_Qna_Gnt.getTable_Nm()
				+ "&lq_Bbs_No="+lctre_Qna_Gnt.getLq_Bbs_No()
				+ "&tpage="+tpage;
		
		try {
			lctre_QnaSvc.updateLctre_Qna(lctre_Qna_Gnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	/**
	 * <pre>
	 * 공지 게시판의 내용을 수정하기 위한 폼으로 이동
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @param tpage
	 * @param model
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Qna_Replys", method=RequestMethod.GET)
	public String updateBbs_Gnt_ReplyForm(Lctre_Qna_GntVO lctre_Qna_Gnt,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="lecture/qna/updateLctre_Qna_Reply";
		Lctre_QnaVO lctre_Qna = null;
		try {
			
			lctre_Qna = lctre_QnaSvc.getLctre_Qna(lctre_Qna_Gnt);
			lctre_Qna_Gnt.setLq_Cn(lctre_Qna.getLq_Cn());
			lctre_Qna_Gnt.setLq_Sj(lctre_Qna.getLq_Sj());
			lctre_Qna_Gnt.setLq_Writng_Dt(lctre_Qna.getLq_Writng_Dt());
			lctre_Qna_Gnt.setLq_Rdcnt(lctre_Qna.getLq_Rdcnt());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_Qna_Gnt",lctre_Qna_Gnt);
		model.addAttribute("tpage",tpage);
		return url;
	}
	
	/**
	 * <pre>
	 * 수정한 게시판의 내용을 업로드 한다.
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Qna_Gnt
	 * @param session
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/updateLctre_Qna_Replys", method=RequestMethod.POST)
	public String updateBbs_Gnt_Reply(@RequestParam int tpage,Lctre_Qna_GntVO lctre_Qna_Gnt, HttpSession session, HttpServletRequest request, Model model){
		String url = "redirect:detailLctre_Qna?"
				+ "table_Nm="+lctre_Qna_Gnt.getTable_Nm()
				+ "&lq_Bbs_No="+lctre_Qna_Gnt.getLq_Bbs_No()
				+ "&tpage="+tpage;
		
		try {
			lctre_QnaSvc.updateLctre_Qna_Reply(lctre_Qna_Gnt);
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
	 * @param lctre_Qna_Gnt
	 * @param tpage
	 * @param request
	 * @return url
	 * </pre>
	 */
	@RequestMapping(value="/deleteLctre_Qna")
	public String deleteQna(Lctre_Qna_GntVO lctre_Qna_Gnt,@RequestParam int tpage,HttpServletRequest request, Model model){
		String url = "redirect:qnaList?"
				+ "table_Nm="+lctre_Qna_Gnt.getTable_Nm()
				+ "&tpage="+tpage;
		
		try {
			lctre_QnaSvc.deleteLctre_Qna(lctre_Qna_Gnt);
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
