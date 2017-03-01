package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.ManageService;

@Controller
public class AaaController {
	@Autowired
	private ManageService manageService;
	
	@RequestMapping("/a")
	String indexForm(HttpSession session){
		String url = "index";
		
			ManageVO manageVO=null;
			try {
				manageVO=manageService.getManage();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("manageVO", manageVO);
			
			
			List<Bbs_ListVO> bbsList=null;
			try {
				bbsList=manageService.getBbsList("t");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("bbsList", bbsList);
			
			
			List<Bbs_ListVO> noticeList=null;
			try {
				noticeList=manageService.getBbsList("b");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("noticeList", noticeList);
		
		return url;
		
	}
	
}
