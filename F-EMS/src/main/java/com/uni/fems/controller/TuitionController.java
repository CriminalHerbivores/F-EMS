package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.common.Paging;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.TuitionVO;
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
	@Autowired
	private Paging callPaging;
	
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
	public String tuitionList(@Value("")String sit_Subjct, @Value("1")String tpage, Model model){
		String url="manager/tuition/tuitionList";
		
		model.addAttribute("tpage",tpage);
		
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
	public String toStdTuition(@Value("")String sit_Subjct, String tpage){
		String url="redirect:tuitionList?sit_Subjct="+sit_Subjct+"&tpage="+tpage;
		try {
			tuitionService.toStdTuition();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	/**
	 * <pre>
	 * 학과번호로 등록금을 업데이트 함
	 * </pre>
	 * <pre>
	 * @param subVO
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="updateSubTuition", method = RequestMethod.POST)
	public String updateTuition(Subjct_Info_TableVO subVO){
		String url="redirect:tuitionList";
		
		try {
			tuitionService.updateTuition(subVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
	public String fromStdTuition(@Value("1")String tpage, TuitionVO tuitionVO, HttpSession session, HttpServletRequest request, Model model){
		String url="student/fromStdTuition";
		tuitionVO.setTu_Stdnt_No((String) session.getAttribute("loginUser"));
		tuitionVO.setTu_Dt("");
		tuitionVO.setTu_Dt_L("");
		tuitionVO.setTu_Pay_Dt("");
		tuitionVO.setKey("tu_No");
		tuitionVO.setValue("");
		
		ArrayList<TuitionVO> list=new ArrayList<TuitionVO>();
		String paging ="";
		try {
			// 데이터의 총 개수 구해오기
			int totalRecord = tuitionService.countTuitionStdnt(tuitionVO); 
			// request 필요. 
			// 가장 끝의 "&key="+search.getKey()+"&value="+search.getValue()는 파라미터 전달값.
			// 검색 등을 통해 GET 방식으로 전달할 값이 있을 경우에만 사용. 사용하지 않을 시엔 "" 를 적어주면 됨
			paging = callPaging.pageNumber(Integer.parseInt(tpage), totalRecord, callPaging.lastPath(request), "&key="+tuitionVO.getKey()+"&value="+tuitionVO.getValue());
			// (현재페이지, 데이터의 총 개수)
			int[] rows = callPaging.row(Integer.parseInt(tpage), totalRecord);
			// (전달값, int start, int count) 이후 쿼리문에서도 같은 순서로 넣어주면 됨
			list = tuitionService.tuitionStdnt(tuitionVO, rows[1], rows[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("paging",paging);
		model.addAttribute("tuitionList",list);
		return url;
	}
}
