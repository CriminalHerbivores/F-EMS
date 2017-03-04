package com.uni.fems.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String testList(Model model,HttpServletRequest request,int table_Nm){
		String url = "lecture/test/testList";
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
		List<Test_PaperVO> testlist = null;
		List<AnswerVO> answerList = null;
		List<String> answeredSTD = null;
		try {
			testlist = test_paperSvc.listAllTestPapaer(table_Nm);
			answerList = answerSvc.listAllAnswer(loginUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		List<String> flaglist = new ArrayList<String>();
		String flag="";
		for(Test_PaperVO test : testlist){
			Timestamp today = new Timestamp(System.currentTimeMillis());
			Timestamp start = test.getTp_Start_Dt();
			Timestamp end = test.getTp_End_Dt();
				if(today.compareTo(start)<0 ){
					 flag = "wait";
					 flaglist.add(flag);
				}else if(today.compareTo(end)>0){
					flag="end";
					flaglist.add(flag);
				}else{
					flag = "possible";
					flaglist.add(flag);
				}
		}
		model.addAttribute("flaglist", flaglist);
		model.addAttribute("testlist", testlist);
		model.addAttribute("answerList", answerList);
		
		return url;
	}
	
	@RequestMapping(value="/writeTest", method=RequestMethod.GET)
	public String writeTestForm(){
		String url = "lecture/test/writeTest";
		return url;
	}
	
	@RequestMapping(value="/writeTest", method=RequestMethod.POST)
	public String writeTest(TestVO testVO, Test_PaperVO test_paperVO, HttpServletRequest request,String[] ques, String[] ca,
							String start_Dt, String end_Dt, String start_Dt2, String end_Dt2,
							String[] te_No1,String[] te_No2,String[] te_No3,String[] te_No4){
		String url ="redirect:testList";
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
		String st = start_Dt+" "+start_Dt2+":00.0";
		String en = end_Dt+" "+end_Dt2+":00.0";
		
		test_paperVO.setTp_Lctre_No(50);
		test_paperVO.setTp_Profsr_No(loginUser);
		test_paperVO.setTp_Start_Dt(java.sql.Timestamp.valueOf(st));
		test_paperVO.setTp_End_Dt(java.sql.Timestamp.valueOf(en));
		try {
			test_paperSvc.insertTestPaper(test_paperVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<ques.length;i++){
			testVO.setTe_Ques(ques[i]);
			testVO.setTe_Ca(ca[i]);
			
		if(te_No1!=null){
			if(te_No1[i]!=null)
			testVO.setTe_No1(te_No1[i]);
		}
		if(te_No2!=null){
			if(te_No2[i]!=null)
			testVO.setTe_No2(te_No2[i]);
		}
		if(te_No3!=null){
			if(te_No3[i]!=null)
			testVO.setTe_No3(te_No3[i]);
		}
		if(te_No4!=null){
			if(te_No4[i]!=null)
			testVO.setTe_No4(te_No4[i]);
		}

		try {
			testSvc.insertTest(testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return url;
	}
	@RequestMapping(value="/detailTest")
	public String detailTest(Model model,String tpNo,String tpNm, HttpServletRequest request){
		String url = "lecture/test/detailTest";
		
		List<TestVO> Qlist = null;
		Test_PaperVO tpVO = null;
		try {
			Qlist = testSvc.listAllTest(Integer.parseInt(tpNo));
			tpVO = test_paperSvc.getTestPaper(Integer.parseInt(tpNo));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("tpVO", tpVO);
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
		Test_PaperVO tpVO = null;
		try {
			tpVO = test_paperSvc.getTestPaper(Integer.parseInt(tpNo));
			Qlist = testSvc.listAllTest(Integer.parseInt(tpNo));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("tpVO", tpVO);
		model.addAttribute("Qlist", Qlist);
		model.addAttribute("tpNm", tpNm.trim());
		model.addAttribute("tpNo", tpNo);
		return url;
	}
	
	@RequestMapping(value="/updateTest", method=RequestMethod.POST)
	public String updateTest(HttpServletRequest request, TestVO testVO, Test_PaperVO test_paperVO,
							String[] ca, String tpNm,String[] queNo,
							String[] addCa, String tp_No,
							String[] ques,String[] no1,String[] no2,String[] no3, String[] no4,
							String[] te_No1,String[] te_No2,String[] te_No3,String[] te_No4,
							String[] addques, String[] addca
							){
		
		
		String url = "redirect:testList";
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
	
		
		try {
			test_paperSvc.updateTestPaper(test_paperVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ques!=null)
		for(int i=0;i<ques.length;i++){
		testVO.setTe_Ques_No(queNo[i]);
		testVO.setTe_Ques(ques[i]);
		testVO.setTe_Ca(ca[i]);
		
		if(no1!=null){
			if(no1[i]!=null)
				testVO.setTe_No1(no1[i]);
		}
		if(no2!=null){
			if(no2[i]!=null)
				testVO.setTe_No2(no2[i]);
		}
		if(no3!=null){
			if(no3[i]!=null)
				testVO.setTe_No3(no3[i]);
		}
		if(no4!=null){
			if(no4[i]!=null)
				testVO.setTe_No4(no4[i]);
		}
		
		try {
			testSvc.updateTest(testVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		TestVO insertVO = new TestVO();
		
		if(addques!=null)
		for(int i=0;i<addques.length;i++){
			insertVO.setTe_Ques(addques[i]);
			insertVO.setTe_Ca(addca[i]);
			
		if(te_No1!=null){
			if(te_No1[i]!=null)
				insertVO.setTe_No1(te_No1[i]);
		}
		if(te_No2!=null){
			if(te_No2[i]!=null)
				insertVO.setTe_No2(te_No2[i]);
		}
		if(te_No3!=null){
			if(te_No3[i]!=null)
				insertVO.setTe_No3(te_No3[i]);
		}
		if(te_No4!=null){
			if(te_No4[i]!=null)
				insertVO.setTe_No4(te_No4[i]);
		}

			try {
				testSvc.insertTest(insertVO);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return url;
		
		
	}
	
	@RequestMapping(value="/deleteQues", produces = "application/json; charset=utf8")
	@ResponseBody
	public String deleteQues(@RequestBody Map<String,Object> jsonMap){
		String queNo =  jsonMap.get("queNo")+"";
		
		
			try {
				testSvc.deleteTest(Integer.parseInt(queNo));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return queNo;
	}
	
	@RequestMapping(value="/nameAnswerSTD", produces = "application/json")
	@ResponseBody
	public Map<String,List> nameAnswerSTD(@RequestParam(value="no[]")List<String> tpNo){
		
		Map<String,List> map = new HashMap<String,List>();
		
		for(String tpno : tpNo){
			try {
				List<String> nameList = new ArrayList<String>();
				nameList = answerSvc.nameAnswerSTD(Integer.parseInt(tpno));
				map.put(tpno, nameList);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
	@RequestMapping(value="/completedTest")
	public String completedTest(Model model, String stdNm, String tpNo){
		String url="lecture/test/completedTest";
		AnswerVO answerVO = new AnswerVO();
		answerVO.setAn_Stdnt_No(stdNm);
		answerVO.setAn_Tp_No(tpNo);
		
		Test_PaperVO tpVO = null;
		List<TestVO> queList = null;
		List<AnswerVO> answerList = null;
		try {
			tpVO = test_paperSvc.getTestPaper(Integer.parseInt(tpNo));
			queList = testSvc.listAllTest(Integer.parseInt(tpNo));
			answerList = answerSvc.completeAnswer(answerVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//점수 구해서 심어야 함
		
		
		double totalScore = 0;
		double eachScore = 100/queList.size();
		for(int i=0;i<queList.size();i++){
			if(queList.get(i).getTe_Ca().equals(answerList.get(i).getAn_Ans()))
				totalScore +=eachScore;
		}
			
			

		
		model.addAttribute("totalScore", totalScore);
		model.addAttribute("stdNm",stdNm);
		model.addAttribute("tpVO", tpVO);
		model.addAttribute("queList", queList);
		model.addAttribute("answerList", answerList);
		
		
		return url;
	}
	
	

}
