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

// RestController : ajax 처리 전용 컨트롤러

@Controller
@RequestMapping("/notice_bbs")
public class CommentController {
	
	@Autowired
	Bbs_CommentService bbs_CommentSvc;
	

	public void setBbs_CommentSvc(Bbs_CommentService bbs_CommentSvc) {
		this.bbs_CommentSvc = bbs_CommentSvc;
	}

	
	public String getList(List<Bbs_CommentVO> commentList, String paging, String loginUser){
		String comment="";
		
		
		for(Bbs_CommentVO data : commentList){
    	   	if(loginUser == data.getBc_User_Id()){
              comment += "<div id=\""
                     + data.getBc_Comnt_No()   
                     + "\">아이디 : "
                     + data.getBc_User_Id()
                     + "  /  " + "작성 날짜 : "
                  + data.getBc_Writng_Dt().toString()
                  +"<a href=\"\" id=\""
                     +data.getBc_Comnt_No()
                     +"\" " 
                     +"class=\"updateComment\" name=\"updateComment\"><input type=\"button\" class=\"def-btn\" value=\"수정\"></a>"
                  +"<a href=\"\" id=\""
                     +data.getBc_Comnt_No()
                     +"\" " 
                     +"class=\"deleteComment\" name=\"deleteComment\"><input type=\"button\" class=\"def-btn\" value=\"삭제\"></a>"
                  + "<div>  ->"
                     + data.getBc_Comnt_Content()
                     +"</div></div><br><br>";
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
	
	
	
	@RequestMapping(value="/commentList",  produces = "application/text; charset=utf8")
	@ResponseBody
	public String commentList(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request, HttpSession session,
				Model model, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String loginUser = (String) session.getAttribute("loginUser");
		Map<String,Object> map = new HashMap<String,Object>();
		List<Bbs_CommentVO> commentList = null;
		String bc_bbs_no = (String) jsonMap.get("bbs_no");
		String cpage = request.getParameter("cpage");
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
		//////////////////////////////////////////////////////////////////////
		return getList(commentList, paging, loginUser);
		//////////////////////////////////////////////////////////////////////
		
	}
	
	
	@RequestMapping(value="/insertComment", method = RequestMethod.POST)
	@ResponseBody
	public List<Bbs_CommentVO> insertComment(@RequestBody Map<String, Object> jsonMap,
	HttpSession session){
		Bbs_CommentVO bbs_commentVO=new Bbs_CommentVO();
		String user_id = (String) session.getAttribute("loginUser");
		bbs_commentVO.setBc_User_Id(user_id);
		int bc_bbs_no = Integer.parseInt((String) jsonMap.get("bbs_no"));
		
		bbs_commentVO.setBc_Bbs_Code("notice_bbs");
		bbs_commentVO.setBc_Bbs_No(bc_bbs_no);
		bbs_commentVO.setBc_Comnt_Content((String) jsonMap.get("comment_content"));
		
		List<Bbs_CommentVO> commentList = null;
		try {
			bbs_CommentSvc.insertBbs_Comment(bbs_commentVO);
			commentList = bbs_CommentSvc.getBbs_Comment(bc_bbs_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return commentList;
		
	}
		
		@RequestMapping(value="/deleteComment", method=RequestMethod.POST)
		@ResponseBody
		public List<Bbs_CommentVO> deleteComment(@RequestParam int bc_bbs_no, HttpServletRequest request){
			int bc_comcnt_no = Integer.parseInt(request.getParameter("result"));
			
			List<Bbs_CommentVO> listlist = null;
			
			try {
				bbs_CommentSvc.deleteBbs_Comment(bc_comcnt_no);
				listlist = bbs_CommentSvc.getBbs_Comment(bc_bbs_no);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listlist;
		}
		
		@RequestMapping(value="/updateComment", method=RequestMethod.POST)
		@ResponseBody
		public List<Bbs_CommentVO> updateComment(String content,int bbs_no, int cmntNo, HttpServletRequest request){
			
			List<Bbs_CommentVO> listlist = null;
			Bbs_CommentVO bbs_commentVO = new Bbs_CommentVO();
			
			bbs_commentVO.setBc_Comnt_Content(content);
			bbs_commentVO.setBc_Bbs_No(cmntNo);
			
			try {
				bbs_CommentSvc.updateBbs_Comment(bbs_commentVO);
				listlist = bbs_CommentSvc.getBbs_Comment(bbs_no);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listlist;
			
			// 게시판 내용 set, where
			
		}
		
		@RequestMapping(value="/realupdateComment", method=RequestMethod.POST)
		@ResponseBody
		public List<Bbs_CommentVO> realupdateComment(String content,int bbs_no, int cmntNo, HttpServletRequest request){
			
			List<Bbs_CommentVO> listlist = null;
			Bbs_CommentVO bbs_commentVO = new Bbs_CommentVO();
			
			bbs_commentVO.setBc_Comnt_Content(content);
			bbs_commentVO.setBc_Comnt_No(cmntNo);
			
			System.out.println("============"+content);
			System.out.println("============"+bbs_no);
			System.out.println("============"+cmntNo);
			
			
			try {
				bbs_CommentSvc.updateBbs_Comment(bbs_commentVO);
				listlist = bbs_CommentSvc.getBbs_Comment(bbs_no);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listlist;
			
			// 게시판 내용 set, where
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

