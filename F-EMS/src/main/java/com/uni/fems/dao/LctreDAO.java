package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.SearchVO;
 
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
 * 2017.02.19      KJH            강의등록
 * 2017.02.20      KJH            강의수정
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface LctreDAO {

//	Lctre_SearchVO getLctre(String lc_Lctre_No) throws SQLException;	// 강의 하나 가져오기
//	ArrayList<Lctre_SearchVO> listComboLctre(int lc_Lctre_No) throws SQLException; // 강의 콤보박스별 강의 리스트 가져오기
//	ArrayList<Lctre_SearchVO> listDetailLctre(int lc_Lctre_No) throws SQLException; // 강의 상세 검색
	
	/**
	 * <pre>
	 * 현재 개설된 강의 목록 조회
	 * 수강신청 첫 페이지에서 검색어 없이 모든 강의목록 가져온다
	 * </pre>
	 * <pre>
	 * @param lu_Lctre_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_SearchVO> openLctreList(SearchVO searchVO, int tpage, int totalRecord) throws SQLException; // 전체 강의 목록  int tpage, 
	
	/**
	 * <pre>
	 * 개설강의 목록의 강이 갯수를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param userSubjctVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int totalOpenLctre(SearchVO searchVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 교수가 개설할 강의를 등록
	 * </pre>
	 * <pre>
	 * @param lctreVO
	 * @return
	 * @throws SQLException
	 */
	void insertLctre(LctreVO lctreVO) throws SQLException;	//강의 등록
	
	/**
	 * <pre>
	 * 강의번호(lc_Lctre_No)중 가장 큰 값을 가져옴
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int selectMaxLc_Lctre_No() throws SQLException;	//무조건 최대값을 가져오기 때문에 매개변수x
	
	/**
	 * <pre>
	 * 개설된 강의 혹은 개설 요청중인 강의를 수정
	 * </pre>
	 * <pre>
	 * @param lctreVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateLctre(LctreVO lctreVO) throws SQLException;	//강의 수정
	
	
	int deleteLctre(int lc_Lctre_No) throws SQLException;	//강의 삭제
	
	/**
	 * <pre>
	 * 개설된 강의를 조건에 따라 조회
	 * </pre>
	 * <pre>
	 * @param lctre_SearchVO
	 * @param start
	 * @param count
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_SearchVO> selectLctre(Lctre_SearchVO lctre_SearchVO, int start, int count) throws SQLException;
	/**
	 * <pre>
	 * 개설된 강의를 조건에 따라 조회한 개수
	 * </pre>
	 * <pre>
	 * @param lctre_SearchVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int countLctre(Lctre_SearchVO lctre_SearchVO) throws SQLException;
	
	 /*
	    * 관리자페이지에서 사용되는 메서드
	    */
	   int totalRecord(String lu_Lctre_Nm) throws SQLException;

	   // 페이지 이동을 위한 메소드
	   String pageNumber(int tpage, String name) throws SQLException;
	   String pageNum(Lctre_SearchVO lctre_SearchVO) throws SQLException;
	
//	int selectCount(LctreVO lctreVO) throws SQLException;	//[수강신청] 현재 학기의 전체 강의 갯수
//	
//	
	
}

