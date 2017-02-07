package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uni.fems.dto.Bbs_CommentVO;
import com.uni.fems.service.Bbs_CommentService;

// RestController : ajax 처리 전용 컨트롤러

@RestController
// 스프링 4.0 이상부터 가능
public class CommentController {
	
	@Autowired
	Bbs_CommentService bbs_CommentSvc;
	

	public void setBbs_CommentSvc(Bbs_CommentService bbs_CommentSvc) {
		this.bbs_CommentSvc = bbs_CommentSvc;
	}

	@RequestMapping("notice_bbs/commentList")
	public List comment_list(@RequestParam int bc_bbs_no, Model model, HttpServletRequest request) {
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		
		if (key ==null){
			key = "";
		}
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("key", key);
		model.addAttribute("tpage",tpage);
		
		List<Bbs_CommentVO> list = null;
		String paging = null;
		try {
			list = bbs_CommentSvc.getBbs_Comment(Integer.parseInt(tpage), bc_bbs_no);
			paging = bbs_CommentSvc.pageNumber(Integer.parseInt(tpage), key);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;

	}

	@RequestMapping("notice_bbs/commentInsert")
	public void comment_insert() {

	}

}
