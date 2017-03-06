package com.uni.fems.controller;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.fems.dto.Bbs_Comment_GntVO;
import com.uni.fems.dto.Bbs_List_Comment_GntVO;
import com.uni.fems.service.Bbs_CommentService;
import com.uni.fems.service.Bbs_Comment_GntService;


/**
 * <pre>
 * 제너레이터 게시판 댓글 Controller
 * 댓글 작성, 수정, 삭제 기능 구현
 * </pre>
 * @author KJS
 * @since 2017.02.22
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.22     KJS               최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/bbs_gnt")
public class Bbs_CommentController {
	
	private static final String String = null;
	@Autowired
	Bbs_CommentService bbs_CommentSvc;
	@Autowired
	Bbs_Comment_GntService bbs_Comment_GntSvc;
	

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
	public String getList(List<Bbs_Comment_GntVO> commentList, String paging, String loginUser){
		String comment="";
		
		if(loginUser ==null)
			loginUser="Guest";
		
		for(Bbs_Comment_GntVO data : commentList){
			String replyTime = data.getBc_Writng_Dt().toString();
    	   	if(loginUser.equals(data.getBc_User_Id()) ){
              comment += "<hr>"
              		+ "<div id=\""+ data.getBc_Comnt_No() + "\">"
              		+ "아이디 : " + data.getBc_User_Id() + "  /  " + "작성 날짜 : " + replyTime.substring(0, replyTime.length()-2)
                  +"<a href=\"\" id=\""+data.getBc_Comnt_No()+"\"class=\"updateComment\" name=\"updateComment\">"
                     + "<input type=\"button\" class=\"def-btn btn-sm btn-color\" value=\"수정\">"
                     + "</a>"
                  +"<a href=\"\" id=\""
                     +data.getBc_Comnt_No()
                     +"\" " 
                     +"class=\"deleteComment\" name=\"deleteComment\">"
                     + "<input type=\"button\" class=\"def-btn btn-sm btn-color\" value=\"삭제\"></a>"
                  + "<div>"
                     + data.getBc_Comnt_Content()
                     +"</div></div>";
        	   	}else{
        	   		comment += "<hr><div id=\""
    	                 + data.getBc_Comnt_No()   
    	                 + "\">아이디 : "
    	                 + data.getBc_User_Id()
    	                 + "  /  " + "작성 날짜 : "
    	              + data.getBc_Writng_Dt().toString()
    	              + "<div>"
    	                 + data.getBc_Comnt_Content()
    	                 +"</div></div><br>";
    	   	}    
		}
		
		comment += "<hr><div class=\"text-center\">"+paging+"</div>";
		
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
		Bbs_List_Comment_GntVO bbs_List_Comment_GntVO = new Bbs_List_Comment_GntVO();
		List<Bbs_Comment_GntVO> commentList = null;
		String bb_Bbs_No = (String)jsonMap.get("bb_Bbs_No");
		
		bbs_List_Comment_GntVO.setBc_Bbs_No(Integer.parseInt(bb_Bbs_No));
		bbs_List_Comment_GntVO.setBl_Table_Nm((String)jsonMap.get("bl_Table_Nm"));

		String cpage = (String) jsonMap.get("cpage");
		String paging = "";
		if(cpage==null)
			cpage="1";
		try {
			commentList = bbs_Comment_GntSvc.getBbs_Comment_Gnt(bbs_List_Comment_GntVO, Integer.parseInt(cpage));
			paging = bbs_Comment_GntSvc.pageNumber(Integer.parseInt(cpage),bbs_List_Comment_GntVO);
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
		
		Bbs_List_Comment_GntVO bbs_List_Comment_GntVO = new Bbs_List_Comment_GntVO();
		bbs_List_Comment_GntVO.setBc_User_Id(loginUser);
		String bb_Bbs_No = (String)jsonMap.get("bb_Bbs_No");
		bbs_List_Comment_GntVO.setBc_Bbs_No(Integer.parseInt(bb_Bbs_No));
		bbs_List_Comment_GntVO.setBl_Table_Nm((String)jsonMap.get("bl_Table_Nm"));
		bbs_List_Comment_GntVO.setBc_Comnt_Content((String) jsonMap.get("comment_content"));
		
		
		int cpage = 1;
		String paging = "";
		
		List<Bbs_Comment_GntVO> commentList = null;
		try {
			bbs_Comment_GntSvc.insertBbs_Comment_Gnt(bbs_List_Comment_GntVO);
			commentList = bbs_Comment_GntSvc.getBbs_Comment_Gnt(bbs_List_Comment_GntVO, cpage);
			paging = bbs_Comment_GntSvc.pageNumber(cpage,bbs_List_Comment_GntVO);
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
			
			Bbs_List_Comment_GntVO bbs_List_Comment_GntVO = new Bbs_List_Comment_GntVO();
			String result = (String) jsonMap.get("result");
			String bb_Bbs_No =(String) jsonMap.get("bb_Bbs_No");
			bbs_List_Comment_GntVO.setBc_Comnt_No(Integer.parseInt(result));
			bbs_List_Comment_GntVO.setBc_Bbs_No(Integer.parseInt(bb_Bbs_No));
			bbs_List_Comment_GntVO.setBl_Table_Nm((String) jsonMap.get("bl_Table_Nm"));
			String cpage = request.getParameter("cpage");
			String paging = "";
			if(cpage==null)
				cpage="1";
						
			List<Bbs_Comment_GntVO> commentList = null;
			
			try {
				bbs_Comment_GntSvc.deleteBbs_Comment_Gnt(bbs_List_Comment_GntVO);
				commentList = bbs_Comment_GntSvc.getBbs_Comment_Gnt(bbs_List_Comment_GntVO, Integer.parseInt(cpage));
				paging = bbs_Comment_GntSvc.pageNumber(Integer.parseInt(cpage), bbs_List_Comment_GntVO);
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
			
			Bbs_List_Comment_GntVO bbs_List_Comment_GntVO = new Bbs_List_Comment_GntVO();
			String cmntNo = (String) jsonMap.get("cmntNo");
			String bb_Bbs_No =(String) jsonMap.get("bb_Bbs_No");
			bbs_List_Comment_GntVO.setBc_Comnt_No(Integer.parseInt(cmntNo));
			bbs_List_Comment_GntVO.setBc_Bbs_No(Integer.parseInt(bb_Bbs_No));
			bbs_List_Comment_GntVO.setBl_Table_Nm((String) jsonMap.get("bl_Table_Nm"));
			List<Bbs_Comment_GntVO> commentList = null;
			String cpage = request.getParameter("cpage");
			String paging = "";
			if(cpage==null)
				cpage="1";
			
			try {
				commentList = bbs_Comment_GntSvc.getBbs_Comment_Gnt(bbs_List_Comment_GntVO, Integer.parseInt(cpage));
				paging = bbs_Comment_GntSvc.pageNumber(Integer.parseInt(cpage), bbs_List_Comment_GntVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			String comment="";
			
			for(Bbs_Comment_GntVO data : commentList){
				String replyTime = data.getBc_Writng_Dt().toString();
	    	   	if(loginUser.equals(data.getBc_User_Id()) && bbs_List_Comment_GntVO.getBc_Comnt_No()==data.getBc_Comnt_No()){
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
	    	              + "<div>"
	    	                 + data.getBc_Comnt_Content()
	    	                 +"</div></div><br><br>";
	    	   	}    
			}
			
			comment += "<hr><div class=\"text-center\">"+paging+"</div>";
			
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
			
			Bbs_List_Comment_GntVO bbs_List_Comment_GntVO = new Bbs_List_Comment_GntVO();
			String cmntNo = (String) jsonMap.get("cmntNo");
			String bb_Bbs_No =(String) jsonMap.get("bb_Bbs_No");
			bbs_List_Comment_GntVO.setBc_Comnt_No(Integer.parseInt(cmntNo));
			bbs_List_Comment_GntVO.setBc_Bbs_No(Integer.parseInt(bb_Bbs_No));
			bbs_List_Comment_GntVO.setBl_Table_Nm((String) jsonMap.get("bl_Table_Nm"));
			bbs_List_Comment_GntVO.setBc_Comnt_Content((String) jsonMap.get("content"));

			String cpage = request.getParameter("cpage");
			String paging = "";
			if(cpage==null)
				cpage="1";
			
			List<Bbs_Comment_GntVO> commentList = null;
	
			
			try {
				bbs_Comment_GntSvc.updateBbs_Comment_Gnt(bbs_List_Comment_GntVO);
				commentList = bbs_Comment_GntSvc.getBbs_Comment_Gnt(bbs_List_Comment_GntVO, Integer.parseInt(cpage));
				paging = bbs_Comment_GntSvc.pageNumber(Integer.parseInt(cpage), bbs_List_Comment_GntVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return getList(commentList, paging, loginUser);
			
			// 게시판 내용 set, where
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

