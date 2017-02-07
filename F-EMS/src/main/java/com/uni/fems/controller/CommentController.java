package com.uni.fems.controller;

import java.sql.SQLException;
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

	@RequestMapping(value="/commentList", method = RequestMethod.POST)
	@ResponseBody
	public List<Bbs_CommentVO> commentList(@RequestBody Map<String, Object> jsonMap,
				Model model, HttpServletResponse response){
		List<Bbs_CommentVO> commentList = null;
		String bc_bbs_no = (String) jsonMap.get("bbs_no");
		try {
			commentList = bbs_CommentSvc.getBbs_Comment(Integer.parseInt(bc_bbs_no));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return commentList;
	}
	
	@RequestMapping(value="/insertComment", method = RequestMethod.POST)
	@ResponseBody
	public List<Bbs_CommentVO> insertComment(@RequestBody Bbs_CommentVO bbs_commentVO, HttpSession session){
		/*String user_id = session.getAttribute("loginUser);*/
		bbs_commentVO.setBc_User_Id("1111");
		
		List<Bbs_CommentVO> commentList = null;
		
		try {
			bbs_CommentSvc.insertBbs_Comment(bbs_commentVO);
			commentList = bbs_CommentSvc.getBbs_Comment(bbs_commentVO.getBc_Bbs_No());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commentList;
		
	}
		
//		@RequestMapping(value="/deleteComment", method=RequestMethod.POST)
//		@ResponseBody
//		public Map<String, Object> deleteComment(Model model, HttpServletRequest request){
//			int bc_comcnt_no = Integer.parseInt(request.getParameter("result"));
//			System.out.println(commentNo);
//			Map<String,Object> map1 = null;
//			
//			List<Bbs_CommentVO> listlist = null;
//			
//			bbs_CommentSvc.deleteBbs_Comment(bc_Comnt_No)
//			
//			
//			
//		}
			
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

