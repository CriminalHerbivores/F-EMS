package com.uni.fems.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dto.TestVO;
import com.uni.fems.dto.Test_PaperVO;
import com.uni.fems.service.Notice_BbsService;
import com.uni.fems.service.TestService;
import com.uni.fems.service.Test_PaperService;
import com.uni.fems.service.impl.TestServiceImpl;

/**
 * <pre>
 * 강의 -> 온라인 게시판 Controller.
 * </pre>
 * @author 송선호
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/lctre")
public class Lctre_TestController {
	
	@Autowired
	private TestService testSvc;
	public void setTestSvc(TestService testSvc) {
		this.testSvc = testSvc;
	}
	@Autowired
	private Test_PaperService test_paperSvc;
	public void setTest_paperSvc(Test_PaperService test_paperSvc) {
		this.test_paperSvc = test_paperSvc;
	}

	@RequestMapping("/testList")
	public String testList(){
		String url = "lecture/test/testList";
		
		return url;
	}
	
	@RequestMapping(value="/writeTest", method=RequestMethod.GET)
	public String writeTestForm(){
		String url = "lecture/test/writeTest";
		return url;
	}
	
	@RequestMapping(value="/writeTest", method=RequestMethod.POST)
	public String writeTest(TestVO testVO, Test_PaperVO test_paperVO, HttpServletRequest request,String[] ques, String[] ca){
		String url ="redirect:testList";
		
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
		test_paperVO.setTp_Lctre_No(50);
		test_paperVO.setTp_Profsr_No(loginUser);
		
		try {
			test_paperSvc.insertTestPaper(test_paperVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<ques.length;i++){
			testVO.setTe_Ques(ques[i]);
			testVO.setTe_Ca(ca[i]);
			
			try {
				testSvc.insertTest(testVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		
		}
		return url;
	}
	

}
