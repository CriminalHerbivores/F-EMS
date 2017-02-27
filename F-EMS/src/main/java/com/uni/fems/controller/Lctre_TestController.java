package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dto.AnswerVO;
import com.uni.fems.dto.TestVO;
import com.uni.fems.dto.Test_PaperVO;
import com.uni.fems.service.AnswerService;
import com.uni.fems.service.TestService;
import com.uni.fems.service.Test_PaperService;

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
	
	@Autowired
	private AnswerService answerSvc;
	public void setAnswerSvc(AnswerService answerSvc) {
		this.answerSvc = answerSvc;
	}

	@RequestMapping("/testList")
	public String testList(Model model){
		String url = "lecture/test/testList";
		
		List<Test_PaperVO> testlist = null;
		try {
			testlist = test_paperSvc.listAllTestPapaer(50);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("testlist", testlist);
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
	@RequestMapping(value="/detailTest")
	public String detailTest(Model model,String tpNo,String tpNm, HttpServletRequest request){
		String url = "lecture/test/detailTest";
		
		List<TestVO> Qlist = null;
		try {
			Qlist = testSvc.listAllTest(Integer.parseInt(tpNo));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("tpNm", tpNm);
		model.addAttribute("tpNo", tpNo);
		model.addAttribute("Qlist", Qlist);
		
		return url;
	}
	
	@RequestMapping(value="/detailTest", method=RequestMethod.POST)
	public String writeTest(HttpServletRequest request, AnswerVO answerVO, String[] answer, String[] queNo){
		String url="redirect:testList";
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
		for(int i=0;i<answer.length;i++){
			/*AnswerVO answerVO = new AnswerVO();*/
			answerVO.setAn_Stdnt_No(loginUser);
			answerVO.setAn_Ans(answer[i]);
			answerVO.setAn_Ques_No(queNo[i]);
			
			
			try {
				answerSvc.insertAnswer(answerVO);
			} catch (SQLException e) {
				// TODO Auto-gener	ated catch block
				e.printStackTrace();
			}
		}
			
		return url;
		
	}
	
	@RequestMapping(value="/deleteTest")
	public String deleteTest(String tpNo){
		String url="redirect:testList";
		
		try {
			test_paperSvc.deleteTestPaper(Integer.parseInt(tpNo));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping(value="/updateTest", method=RequestMethod.GET)
	public String updateTestForm(Model model,String tpNo, String tpNm){
		String url="lecture/test/updateTest";
		
		List<TestVO> Qlist = null;
		try {
			Qlist = testSvc.listAllTest(Integer.parseInt(tpNo));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("Qlist", Qlist);
		model.addAttribute("tpNm", tpNm);
		model.addAttribute("tpNo", tpNo);
		return url;
	}
	
	@RequestMapping(value="/updateTest", method=RequestMethod.POST)
	public String updateTest(HttpServletRequest request, TestVO testVO, Test_PaperVO test_paperVO,
							String[] que, String[] ca, String tpNm,String queNo[],
							String[] addQue, String[] addCa, String tp_No){
		
		String url = "redirect:testList";
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
	
		
		try {
			test_paperSvc.updateTestPaper(test_paperVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<que.length;i++){
		testVO.setTe_Ques_No(queNo[i]);
		testVO.setTe_Ques(que[i]);
		testVO.setTe_Ca(ca[i]);
			
		try {
			testSvc.updateTest(testVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		if(addQue!=null){
		TestVO insertVO = new TestVO();
		for(int i=0; i<addQue.length;i++){
			insertVO.setTe_Ques(addQue[i]);
			insertVO.setTe_Ca(addCa[i]);
			insertVO.setTe_Tp_No(tp_No);
			
			try {
				testSvc.insertTest(insertVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		return url;
		
		
	}
	
	
	
	
	@RequestMapping(value="/deleteQues")
	public String deleteQues(String queNo){
		String url="";
			
			try {
				testSvc.deleteTest(Integer.parseInt(queNo));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return url;
	}
		
	

}
