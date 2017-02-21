package com.uni.fems.controller;


import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.fems.dto.Bbs_CommentVO;
import com.uni.fems.service.Bbs_CommentService;


/**
 * <pre>
 * 공지게시판 댓글 Controller
 * 댓글 작성, 수정, 삭제 기능 구현
 * </pre>
 * @author SSH
 * @since 2017.02.07
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.07     SSH               최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/notice_bbs")
public class CommentController {
	
	@Autowired
	Bbs_CommentService bbs_CommentSvc;
	

	public void setBbs_CommentSvc(Bbs_CommentService bbs_CommentSvc) {
		this.bbs_CommentSvc = bbs_CommentSvc;
	}

	
	/**
	 * <pre>
	 * 게시물의 댓글 리스트를 가져와 출력해주는 메서드
	 * </pre>
	 * <pre>
	 * @param commentList
	 * @param paging
	 * @param loginUser
	 * @return 댓글 리스트 출력 html코드
	 * </pre>
	 * 
	 */
	public String getList(List<Bbs_CommentVO> commentList, String paging, String loginUser){
		String comment="";
		
		if(loginUser ==null)
			loginUser="Guest";
		
		for(Bbs_CommentVO data : commentList){
			String replyTime = data.getBc_Writng_Dt().toString();
    	   	if(loginUser.equals(data.getBc_User_Id()) ){
              comment += "<hr><div id=\""
                     + data.getBc_Comnt_No()   
                     + "\">아이디 : "
                     + data.getBc_User_Id()
                     + "  /  " + "작성 날짜 : "
                  + replyTime.substring(0, replyTime.length()-2)
                  +"<a href=\"\" id=\""
                     +data.getBc_Comnt_No()
                     +"\" " 
                     +"class=\"updateComment\" name=\"updateComment\"><input type=\"button\" class=\"def-btn btn-sm btn-color\" value=\"수정\"></a>"
                  +"<a href=\"\" id=\""
                     +data.getBc_Comnt_No()
                     +"\" " 
                     +"class=\"deleteComment\" name=\"deleteComment\"><input type=\"button\" class=\"def-btn btn-sm btn-color\" value=\"삭제\"></a>"
                  + "<div>  ->"
                     + data.getBc_Comnt_Content()
                     +"</div></div>";
        	   	}else{
        	   		comment += "<hr><div id=\""
    	                 + data.getBc_Comnt_No()   
    	                 + "\">아이디 : "
    	                 + data.getBc_User_Id()
    	                 + "  /  " + "작성 날짜 : "
    	              + data.getBc_Writng_Dt().toString()
    	              + "<div>  ->"
    	                 + data.getBc_Comnt_Content()
    	                 +"</div></div><br>";
    	   	}    
		}
		
		comment += paging;
		
		return comment;
		
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
	@RequestMapping(value="/commentList",  produces = "application/text; charset=utf8")
	@ResponseBody
	public String commentList(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request){
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		List<Bbs_CommentVO> commentList = null;
		String bc_bbs_no = (String) jsonMap.get("bbs_no");
		String cpage = (String) jsonMap.get("cpage");
		String paging = "";
		if(cpage==null)
			cpage="1";
		try {
			commentList = bbs_CommentSvc.getBbs_Comment(Integer.parseInt(bc_bbs_no), Integer.parseInt(cpage));
			paging = bbs_CommentSvc.pageNumber(Integer.parseInt(cpage),Integer.parseInt(bc_bbs_no));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return getList(commentList, paging, loginUser);
		
	}
	
	
	/**
	 * <pre>
	 * 댓글 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param jsonMap
	 * @param request
	 * @return 댓글 리스트 출력 메서드
	 * </pre>
	 * 
	 */
	@RequestMapping(value="/insertComment", produces = "application/text; charset=utf8")
	@ResponseBody
	public String insertComment(@RequestBody Map<String, Object> jsonMap,HttpServletRequest request){
		HttpSession session = request.getSession();
		String loginUser = "Guest";
		
		if(((String) session.getAttribute("loginUser"))!=null){
			loginUser = ((String) session.getAttribute("loginUser"));
		}
		
		Bbs_CommentVO bbs_commentVO=new Bbs_CommentVO();
		bbs_commentVO.setBc_User_Id(loginUser);
		int bc_bbs_no = Integer.parseInt((String) jsonMap.get("bbs_no"));
		bbs_commentVO.setBc_Bbs_Code("notice_bbs");
		bbs_commentVO.setBc_Bbs_No(bc_bbs_no);
		bbs_commentVO.setBc_Comnt_Content((String) jsonMap.get("comment_content"));
		
		
		String cpage = request.getParameter("cpage");
		String paging = "";
		if(cpage==null)
			cpage="1";
		
		List<Bbs_CommentVO> commentList = null;
		try {
			bbs_CommentSvc.insertBbs_Comment(bbs_commentVO);
			commentList = bbs_CommentSvc.getBbs_Comment(bc_bbs_no, Integer.parseInt(cpage));
			paging = bbs_CommentSvc.pageNumber(Integer.parseInt(cpage),bc_bbs_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getList(commentList, paging, loginUser);
		
	}
		
		/**
		 * <pre>
		 * 댓글 삭제하는 메서드
		 * </pre>
		 * <pre>
		 * @param jsonMap
		 * @param request
		 * @return 댓글 리스트 출력 메서드
		 * </pre>
		 * 
		 */
		@RequestMapping(value="/deleteComment", produces = "application/text; charset=utf8")
		@ResponseBody
		public String deleteComment(@RequestBody Map<String, Object> jsonMap,HttpServletRequest request){
			
			HttpSession session = request.getSession();
			String loginUser = "Guest";
			
			if(((String) session.getAttribute("loginUser"))!=null){
				loginUser = ((String) session.getAttribute("loginUser"));
			}
			
			int bc_comcnt_no = Integer.parseInt((String) jsonMap.get("result"));
			int bc_bbs_no = Integer.parseInt((String) jsonMap.get("bc_bbs_no"));
			String cpage = request.getParameter("cpage");
			String paging = "";
			if(cpage==null)
				cpage="1";
						
			List<Bbs_CommentVO> commentList = null;
			
			try {
				bbs_CommentSvc.deleteBbs_Comment(bc_comcnt_no);
				commentList = bbs_CommentSvc.getBbs_Comment(bc_bbs_no, Integer.parseInt(cpage));
				paging = bbs_CommentSvc.pageNumber(Integer.parseInt(cpage), bc_bbs_no);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getList(commentList, paging, loginUser);
		}
		
		/**
		 * <pre>
		 * 댓글 수정하는 Form 출력하는 메서드
		 * </pre>
		 * <pre>
		 * @param jsonMap
		 * @param request
		 * @return 댓글 수정하는 Form 출력
		 * </pre>
		 * 
		 */
		@RequestMapping(value="/updateComment", produces = "application/text; charset=utf8")
		@ResponseBody
		public String updateComment(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request){
			
			HttpSession session = request.getSession();
			String loginUser = "Guest";
			if(((String) session.getAttribute("loginUser"))!=null){
				loginUser = ((String) session.getAttribute("loginUser"));
			}
			
			int bc_comcnt_no = Integer.parseInt((String) jsonMap.get("cmntNo"));
			int bc_bbs_no = Integer.parseInt((String) jsonMap.get("bbs_no"));
			List<Bbs_CommentVO> commentList = null;
			String cpage = request.getParameter("cpage");
			String paging = "";
			if(cpage==null)
				cpage="1";
			
			try {
				commentList = bbs_CommentSvc.getBbs_Comment(bc_bbs_no, Integer.parseInt(cpage));
				paging = bbs_CommentSvc.pageNumber(Integer.parseInt(cpage), bc_bbs_no);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String comment="";
			
			for(Bbs_CommentVO data : commentList){
				String replyTime = data.getBc_Writng_Dt().toString();
	    	   	if(loginUser.equals(data.getBc_User_Id()) && bc_comcnt_no==data.getBc_Comnt_No()){
	              comment += "<div id=\""
	                     + data.getBc_Comnt_No()   
	                     + "\">아이디 : "
	                     + data.getBc_User_Id()
	                     + "  /  " + "작성 날짜 : "
	                  + replyTime.substring(0,replyTime.length()-2)
	                  + "<div>"
		               + "<textarea rows=\"3\" cols=\"60\" id=\"comment_update\" name=\"comment_update\">"+data.getBc_Comnt_Content()+"</textarea>"
		                 +"</div></div>"
		                 
		                 +"<a href=\"\" id=\""
		                 +data.getBc_Comnt_No()
		                 +"\" " 
		                 +"class=\"realupdateComment\" name=\"realupdateComment\"> <input type=\"button\" class=\"def-btn btn-sm btn-color\" value=\"수정완료\"></a>"
		              +"<a href=\"\" id=\""
		              +data.getBc_Comnt_No()
		                 +"\" " 
		                 +"class=\"cancelComment\" name=\"cancelComment\"><input type=\"button\" class=\"def-btn btn-sm btn-color\" value=\"취소\"></a><br>";
	        	   	}else{
	        	   		comment += "<div id=\""
	    	                 + data.getBc_Comnt_No()   
	    	                 + "\">아이디 : "
	    	                 + data.getBc_User_Id()
	    	                 + "  /  " + "작성 날짜 : "
	    	              + data.getBc_Writng_Dt().toString()
	    	              + "<div>  ->"
	    	                 + data.getBc_Comnt_Content()
	    	                 +"</div></div><br><br>";
	    	   	}    
			}
			
			comment += paging;
			
			return comment;
			
		
			
		}
		
		/**
		 * <pre>
		 * 댓글 수정하는 메서드
		 * </pre>
		 * <pre>
		 * @param jsonMap
		 * @param request
		 * @return 댓글 리스트 출력
		 * </pre>
		 * 
		 */
		@RequestMapping(value="/realupdateComment", produces = "application/text; charset=utf8")
		@ResponseBody
		public String realupdateComment(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request){
			
			HttpSession session = request.getSession();
			String loginUser = "Guest";
			if(((String) session.getAttribute("loginUser"))!=null){
				loginUser = ((String) session.getAttribute("loginUser"));
			}
			
			String content = (String) jsonMap.get("content");
			int bbs_no = Integer.parseInt((String) jsonMap.get("bbs_no"));
			int cmntNo = Integer.parseInt((String) jsonMap.get("cmntNo"));

			String cpage = request.getParameter("cpage");
			String paging = "";
			if(cpage==null)
				cpage="1";
			
			List<Bbs_CommentVO> commentList = null;
			Bbs_CommentVO bbs_commentVO = new Bbs_CommentVO();
			bbs_commentVO.setBc_Comnt_Content(content);
			bbs_commentVO.setBc_Comnt_No(cmntNo);
	
			
			try {
				bbs_CommentSvc.updateBbs_Comment(bbs_commentVO);
				commentList = bbs_CommentSvc.getBbs_Comment(bbs_no, Integer.parseInt(cpage));
				paging = bbs_CommentSvc.pageNumber(Integer.parseInt(cpage), bbs_no);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getList(commentList, paging, loginUser);
			
			// 게시판 내용 set, where
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

