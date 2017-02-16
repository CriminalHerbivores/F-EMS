package com.uni.fems.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.ManageService;

@Controller
public class IndexController {
	
	@Autowired
	private ManageService manageService;
	
	// css 예시
	@RequestMapping("/cssExample")
	public String cssExample(){
		String url = "/cssExample";
		return url;
	}
	
	///////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/")
	public String in(){
		String url = "redirect:index";
		return url;
	}
	
	
	/**
	 * <pre>
	 * 첫 화면으로 이동
	 * DB에 저장된 MANAGE 테이블의 내용을 가져온다
	 * </pre>
	 * <pre>
	 * @param model
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/index")
	public String index(Model model, HttpSession session){
		String url = "/index";	
		
		/*ManageVO manageVO=null;
		
		try {
			manageVO= manageService.getManage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("manageVO", manageVO);*/
		
		return url;
	}

	
	
	
	
	
	/*@RequestMapping("/a")
	public String a(){
		String url = "index";
		return url;
	}*/
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String url = "redirect:/index";
		session.invalidate();
		return url;
	}

	@RequestMapping("/loginForm")
	public String loginForm(HttpServletRequest request,HttpSession session) {
		String url = "member/loginForm";	
		return url;
	}

	// 관리자 /////////////////////////////////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 관리자 가입
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/adminJoin")
	public String adminJoinForm(HttpServletRequest request,HttpSession session) {
		String url = "admin/admin_management/adminJoin";	
		return url;
	}
	
}
