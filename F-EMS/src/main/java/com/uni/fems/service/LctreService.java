package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.dto.Lctre_SearchVO;

/**
 * <pre>
 * 수강신청, 강의목록조회, 강의등록, 강의수정과 같은 하나의 작업을
 * 묶어서 복합적으로 처리하는 service
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
 * 2017.02.19      KJH            강의등록
 * 2017.02.20      KJH            강의수정
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface LctreService {

	/**
	 * <pre>
	 * 전체 강의 목록을 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param lu_Lctre_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_SearchVO> openLctreList(String lu_Lctre_Nm) throws SQLException; // 전체 강의 목록 int tpage, 
	
	
	/**
	 * <pre>
	 * 교수가 작성한 강의계획서의 Lctre테이블과 Lctre_Actpln에 데이터를 넣어서
	 * 강의 개설 요청 등록
	 * </pre>
	 * <pre>
	 * @param lctreVO
	 * @throws SQLException
	 */
	int openLctre(LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO) throws SQLException;

	
	
	/**
	 * <pre>
	 * 교수가 강의계획서 및 개설 강의 내용을 수정
	 * </pre>
	 * <pre>
	 * @param lctreVO
	 * @param lctre_ActplnVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateLctre(LctreVO lctreVO, Lctre_ActplnVO lctre_ActplnVO) throws SQLException;
	
	
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

		
	
	
}
