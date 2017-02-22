package com.uni.fems.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.common.Paging;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.service.TuitionService;

/**
 * <pre>
 * 등록금에 관련된 로직들을 테스트 삼아 짜는 부분
 * </pre>
 * @author JAR
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("tt")
public class TuitionController {
	@Autowired
	private TuitionService tuitionService;
	
	//직원//////////////////////////////////////////////////////
	/**
	 * <pre>
	 * 등록금 목록을 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="tuitionList")
	public String tuitionList(String sit_Subjct, String tpage, Model model){
		String url="manager/tuition/tuitionList";
		
		if (tpage==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		if(sit_Subjct==null) sit_Subjct="";
		
		ArrayList<UserSubjctVO> list = new ArrayList<UserSubjctVO>();
		String paging = "";
		int count = 0;
		try {
			count = tuitionService.countSubjctByName(sit_Subjct);
			paging = new Paging().pageNumber(Integer.parseInt(tpage), count, "tuitionList", "&sit_Subjct="+sit_Subjct);
			list = tuitionService.selectSubjctByName(Integer.parseInt(tpage), count, sit_Subjct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("tuitionList",list);
		model.addAttribute("paging",paging);
		return url;
	}
	/**
	 * <pre>
	 * 학생에게 등록금을 고지 
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="toStdTuition")
	public String toStdTuition(String sit_Subjct, String tpage){
		String url="redirect:tuitionList?sit_Subjct="+sit_Subjct+"&tpage="+tpage;
		
		return url;
	}
	/**
	 * <pre>
	 * 학과번호로 등록금을 업데이트 함
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="updateSubTuition", method = RequestMethod.GET)
	public String upTuition(String sit_Subjct_Code, Model model){
		String url="manager/tuition/updateSubTuition";
		
		UserSubjctVO sub = new UserSubjctVO();
		try {
			sub = tuitionService.selectSubjctByCode(sit_Subjct_Code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("tut",sub);
		return url;
	}
	@RequestMapping(value="updateSubTuition", method = RequestMethod.POST)
	public String updateTuition(Subjct_Info_TableVO subVO){
		String url="redirect:tuitionList";
		
		
		
		return url;
	}
	/**
	 * <pre>
	 * 학생의 등록금 납부 내역을 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("stdTuitionList")
	public String stdTuitionList(){
		String url="";
		return url;
	}
	/**
	 * <pre>
	 * 등록금 미납 내역을 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("notTuitionList")
	public String notTuitionList(){
		String url="";
		return url;
	}
	/**
	 * <pre>
	 * 학생의 등록금 납부 내역을 등록
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("updateStdTuition")
	public String updateStdTuition(){
		String url="";
		return url;
	}
	//학생/////////////////////////////////////////////////////////////
	/**
	 * <pre>
	 * 학생의 등록금 내역 조회
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	@RequestMapping("fromStdTuition")
	public String fromStdTuition(){
		String url="";
		return url;
	}
}
