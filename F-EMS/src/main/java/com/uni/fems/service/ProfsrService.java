package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ProfsrVO;

/**
 * <pre>
 * 교수 정보를 관리하기 위한 Service
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
public interface ProfsrService {
	
	/**
	 * <pre>
	 * 교수 정보를 등록
	 * </pre>
	 * <pre>
	 * @param profsrVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertProfsr(ProfsrVO profsrVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 교수 이름으로 교수 정보를 조회
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param pr_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<ProfsrVO> selectNameAllPage(int tpage, String pr_Nm) throws SQLException;
	
	
	/**
	 * <pre>
	 * 교수 이름으로 정보를 조회한 페이지
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param st_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int tpage, String st_Nm) throws SQLException;
	
	
	/**
	 * <pre>
	 * 교수 한명의 정보를 조회
	 * </pre>
	 * <pre>
	 * @param st_Profsr_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ProfsrVO selectProfsr(String st_Profsr_No) throws SQLException;
	
	
	/**
	 * <pre>
	 * 교수 정보를 수정
	 * </pre>
	 * <pre>
	 * @param profsrVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateProfsr(ProfsrVO profsrVO) throws SQLException;


	/**
	 * 교수 리스트 출력
	 * @param tpage
	 * @param profarVO
	 * @return
	 * @throws SQLException
	 */
	List<ProfsrVO> selectAllStdntList2(int tpage, ProfsrVO profarVO)
			throws SQLException;


	/**
	 * 교수 리스트 페이지 출력
	 * @param tpage
	 * @param profarVO
	 * @return
	 * @throws SQLException
	 */
	String pageNumber2(int tpage, ProfsrVO profarVO) throws SQLException;
	
	/**
	 * <pre>
	 * 교수코드 만드는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param subjctNo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String createProfsrNo(ProfsrVO profsrVO) throws SQLException;
}
