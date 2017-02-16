package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
 
/**
 * <pre>
 * 강의 DAO
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * 2017.02.16      KJH            강의목록
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface LctreDAO {

//	Lctre_SearchVO getLctre(String lc_Lctre_No) throws SQLException;	// 강의 하나 가져오기
//	ArrayList<Lctre_SearchVO> listComboLctre(int lc_Lctre_No) throws SQLException; // 강의 콤보박스별 강의 리스트 가져오기
//	ArrayList<Lctre_SearchVO> listDetailLctre(int lc_Lctre_No) throws SQLException; // 강의 상세 검색
	
	/**
	 * <pre>
	 * 강의 목록 조회
	 * 수강신청 첫 페이지에서 검색어 없이 모든 강의목록 가져온다
	 * </pre>
	 * <pre>
	 * @param lctre_SearchVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<Lctre_SearchVO> listLctre(int tpage, String Lu_Lctre_Nm) throws SQLException; // 전체 강의 목록 
	
	
	
	 /*
	    * 관리자페이지에서 사용되는 메서드
	    */
	   public int totalRecord(String Lu_Lctre_Nm) throws SQLException;

	   // 페이지 이동을 위한 메소드
	   public String pageNumber(int tpage, String name) throws SQLException;
	   public String pageNum(Lctre_SearchVO lctre_SearchVO) throws SQLException;
	
//	int selectCount(LctreVO lctreVO) throws SQLException;	//[수강신청] 현재 학기의 전체 강의 갯수
//	
//	
//	int insertLctre(LctreVO lctreVO) throws SQLException;	//강의 등록
//	int updateLctre(LctreVO lctreVO) throws SQLException;	//강의 수정
//	int deleteLctre(int lc_Lctre_No) throws SQLException;	//강의 삭제
	
}

