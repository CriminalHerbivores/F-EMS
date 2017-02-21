package com.uni.fems.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.fems.dto.ManageVO;
import com.uni.fems.dto.UsersVO;
import com.uni.fems.service.ManageService;
import com.uni.fems.service.UsersService;

/**
 * <pre>
 * 통합 또는 메인과 연관된 로직들을 처리하는 컨트롤러
 * </pre>
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
public class IndexController {

	@Autowired
	private ManageService manageService;
	@Autowired
	private UsersService usersService;

	// css 예시
	@RequestMapping("/cssExample")
	public String cssExample() {
		String url = "/cssExample";
		return url;
	}

	// /////////////////////////////////////////////////////////////////////

	/**
	 * 인덱스로 간다.
	 * @return
	 */
	@RequestMapping("/")
	public String in() {
		String url = "redirect:index";
		return url;
	}

	/**
	 * <pre>
	 * 첫 화면으로 이동
	 * DB에 저장된 MANAGE 테이블의 내용을 가져온다
	 * </pre>
	 * 
	 * <pre>
	 * @param model
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/index")
	public String index(Model model, HttpSession session) {
		String url=null;
		
		ManageVO manageVO = null;

		try {
			manageVO = manageService.getManage();

			switch (Integer.parseInt(manageVO.getMng_Layout_Knd())) {// DB의 숫자값에 따라 index 페이지가 달라진다(보험처리)
			case 1: //url= "redirect:lgLogin";
					url = "layout_type/loginLoginType";
				break;
			case 2: //url= "redirect:lgBoard"; 
					url = "layout_type/loginBoardType";
				break;
			case 3: //url= "redirect:lgMenu"; 
					url = "layout_type/loginMenuType";
				break;
			case 4: //url= "redirect:lgMulti";
					url = "layout_type/loginMultiType";
				break;
			default: url = "/index";
			
			}

		} catch (SQLException e) {
			e.printStackTrace(); 
		}

		// session.setAttribute("manageVO", manageVO);

		return url;
	}

	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String url = "redirect:/index";
		session.invalidate();
		return url;
	}

	/**
	 * 로그인
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginForm")
	public String loginForm(HttpServletRequest request, HttpSession session) {
		String url = "member/loginForm";
		return url;
	}
	
	/**
	 * 아이디 또는 비밀번호 찾기
	 * @return
	 */
	@RequestMapping("findIdPw")
	public String findIdPw(){
		String url = "member/findIdPw";
		return url;
	}
	
	/**
	 * 아이디 찾기
	 * @return
	 */
	@RequestMapping(value="findId", produces = "application/json; charset=utf8")
	@ResponseBody
	public String findId(UsersVO usersVO){
		String id="";
		try {
			id = usersService.findId(usersVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * 비밀번호 초기화
	 * @return
	 */
	@RequestMapping(value="findPw", produces = "application/json; charset=utf8")
	@ResponseBody
	public String findPw(UsersVO usersVO){
		String pw="";
		try {
			pw = usersService.findPw(usersVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pw;
	}
	
	// 관리자
	// /////////////////////////////////////////////////////////////////////////

	/**
	 * <pre>
	 * 관리자 가입
	 * </pre>
	 * 
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping("/adminJoin")
	public String adminJoinForm(HttpServletRequest request, HttpSession session) {
		String url = "admin/admin_management/adminJoin";
		return url;
	}

}
