package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.fems.common.Supporter;
import com.uni.fems.dao.Sklstf_AtrtyDAO;
import com.uni.fems.dto.AddressVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ManageVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.Sklstf_AtrtyVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.dto.UsersVO;
import com.uni.fems.dto.request.MessageRequest;
import com.uni.fems.service.Lctre_Unq_NoService;
import com.uni.fems.service.ManageService;
import com.uni.fems.service.SklstfService;
import com.uni.fems.service.Subjct_Info_TableService;
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
	@Autowired
	private Subjct_Info_TableService subjct_Info_TableService;
	@Autowired
	private Lctre_Unq_NoService lctre_Unq_NoService;
	@Autowired
	private MailSender mailSender;
	@Autowired
	private Sklstf_AtrtyDAO sklstf_AtrtyDAO;
	@Autowired
	private SklstfService sklstfService;

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
		String url = "redirect:temp";
		return url;
	}
	
	@RequestMapping("/temp")
	public String aa() {
		String url = "/index";
		return url;
	}
	
	@RequestMapping("/sample")
	public String sample() {
		String url = "/sample";
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
		
		ManageVO manageVO = (ManageVO) session.getAttribute("manageVO");

		switch (Integer.parseInt(manageVO.getMng_Layout_Knd())) {// DB의 숫자값에 따라 index 페이지가 달라진다(보험처리)
		case 1: url = "layout_type/loginLoginType";
			break;
		case 2: url = "layout_type/loginBoardType";
			break;
		case 3:url = "layout_type/loginMenuType";
			break;
		case 4: url = "layout_type/loginMultiType";
			break;
		default: url = "/index";
		}
		
//		if(session.getAttribute("loginUser")!=null){
//			url="layout_type/loginBoardType";
//
//			switch (Integer.parseInt(manageVO.getMng_Layout_Knd())) {// DB의 숫자값에 따라 index 페이지가 달라진다(보험처리)
//			case 1: url = "layout_type/indexLoginType";
//				break;
//			case 2: url = "layout_type/indexBoardType";
//				break;
//			case 3:url = "layout_type/indexMenuType";
//				break;
//			case 4: url = "layout_type/indexMultiType";
//				break;
//			default: url = "/index";
//			}
//		}
		
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
	 * 로그인
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginMenuForm")
	public String loginMenuTypeForm(HttpServletRequest request, HttpSession session) {
		String url = "member/loginMenuType";
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
	public String findPw(UsersVO usersVO, HttpSession session){
		String pw="";
		
		try {
			pw = usersService.findPw(usersVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(pw!="" && pw!=null){
			MessageRequest msg = new MessageRequest();
			ManageVO vo = (ManageVO) session.getAttribute("manageVO");
			msg.setMng_Univ_Nm(vo.getMng_Univ_Nm());
			msg.setMng_Email(vo.getMng_Email());
			msg.setEmail(usersVO.getEmail());
			msg.setTitle("["+vo.getMng_Univ_Nm()+"] 임시 비밀번호 발급 안내");
			msg.setContent("비밀번호가 "+pw+"로 재설정되었습니다<br/>로그인 후 반드시 비밀번호 변경을 해주시기 바랍니다.");
			new Supporter().sendMail(mailSender, msg);
			pw="초기화완료";
		}
		return pw;
	}
	
	// 관리자
	// /////////////////////////////////////////////////////////////////////////

	/**
	 * <pre>
	 * 관리자 가입이 가능한 폼으로 가입한 직원이 없을 경우에만 접근 가능
	 * </pre>
	 * 
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/adminJoin",method=RequestMethod.GET)
	public String adminJoinForm(Model model,Sklstf_AtrtyVO sklstf_AtrtyVO) {
		
		
		//가입한 직원이 0명이면 가입페이지 갈 수 있게 하고싶음
		String url=null;
		try {
			//SearchVO searchVO;
			int num_sklstf;
			num_sklstf = sklstf_AtrtyDAO.numOfSklstf(sklstf_AtrtyVO);
			
			// 관리자 가입 인원 조절해서 일단 작업할 것
			if(num_sklstf==9){
				url = "admin/admin_management/adminJoin";
				
			}else{
				url="redirect:index";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("sklstf_AtrtyVO",sklstf_AtrtyVO);
		return url;
	}
	
	
	/**
	 * <pre>
	 * 관리자 가입이 가능한 로직
	 * </pre>
	 * 
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/adminJoin",method=RequestMethod.POST)
	public String adminJoin(Model model,SklstfVO sklstfVO,Sklstf_AtrtyVO sklstf_AtrtyVO) {
		//String url = "admin/admin_management/adminJoin";
		String url = "redirect:admin/step1Add";
		
		// 현재 가입이 안되며 가입직후 바로 가입한 정보로 로그인할 수 있도록 해야함
		
		
		try {
			sklstf_AtrtyVO.setSa_Atrty("ROLE_ADMIN");
			sklstf_AtrtyVO.setSa_Sklstf_No(sklstfVO.getStf_Sklstf_No());
			sklstfVO.setStf_Useyn("1");
			sklstfService.joinAdmin(sklstfVO, sklstf_AtrtyVO);
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("sklstfVO",sklstfVO);
		model.addAttribute("sklstf_AtrtyVO",sklstf_AtrtyVO);
		return url;
	}
	
	
	//==========================================================================
	
	/**
	 * <pre>
	 * 동이름으로 우편번호 검색할 때 사용
	 * </pre>
	 * <pre>
	 * @param model
	 * @param dong
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/findZipNum", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String findZipNum(Model model, @RequestParam(value="dong",defaultValue="대흥동")String dong)
			throws ServletException, IOException {

		String url = "common/findZipNum"; 
		ArrayList<AddressVO> addressVO=null;
		try {
			if (dong != null && dong.trim().equals("") == false) {
				addressVO=usersService.selectAddressByDong(dong.trim());
			} else {
				addressVO=usersService.selectAddressByDong("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("addressVO",addressVO);
		return url;
	}	



/**
	 * <pre>
	 * 학과명 혹은 학부명으로 학과 검색할 때 사용
	 * </pre>
	 * 
	 * <pre>
	 * @param model
	 * @param sit_Subjct
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/findSubjct", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String findSubjct(Model model, String sit_Subjct)
			throws ServletException, IOException {

		String url = "common/findSubjct"; 
		ArrayList<UserSubjctVO> userSubjctVO = null;
		
		try {
			if (sit_Subjct != null && sit_Subjct.trim().equals("") == false) {
				userSubjctVO = subjct_Info_TableService.selectSubjctByName(sit_Subjct.trim());
			} else {
				userSubjctVO = subjct_Info_TableService.selectSubjctByName("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("userSubjctVO", userSubjctVO);
		return url;
	}
	
	
/**
	 * <pre>
	 * 강의명으로 강의를 검색할 때 사용
	 * </pre>
	 * 
	 * <pre>
	 * @param model
	 * @param lu_Lctre_Nm
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/findLctre", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String findLctre(Model model, String lu_Lctre_Nm)
			throws ServletException, IOException {

		String url = "common/findLctre";
		ArrayList<Lctre_SearchVO> lctre_SearchVO = null;

		try {
			if (lu_Lctre_Nm != null && lu_Lctre_Nm.trim().equals("") == false) {
				lctre_SearchVO = lctre_Unq_NoService
						.selectLctreByName(lu_Lctre_Nm.trim());
			} else {
				lctre_SearchVO = lctre_Unq_NoService.selectLctreByName("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("lctre_SearchVO", lctre_SearchVO);
		return url;
	}	
	
	// 에러페이지 //////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("event")
	public String event(){
		String url="error/notEvent";
		return url;
	}
	
	@RequestMapping("auth")
	public String notPage(){
		String url = "error/notAuth";
		return url;
	}
	
}
