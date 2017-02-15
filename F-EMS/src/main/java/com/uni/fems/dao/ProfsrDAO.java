package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.StdntVO;

/**
 * <pre>
 * 교수 관련 사항을 처리하는 DAO
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
public interface ProfsrDAO {
	/**
	 * <pre>
	 * 교수 정보 등록
	 * </pre>
	 * <pre>
	 * @param profsrVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertProfsr(ProfsrVO profsrVO) throws SQLException;
	/**
	 * <pre>
	 * 교수 이름으로 조회한 데이터의 총 개수
	 * </pre>
	 * <pre>
	 * @param pt_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int totalRecord(String pt_Nm) throws SQLException;
	/**
	 * <pre>
	 * 교수 이름으로 교수 정보를 조회한 리스트
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param totalRecord
	 * @param pt_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<ProfsrVO> selectNameAllPage(int tpage, int totalRecord, String pt_Nm) throws SQLException;
	/**
	 * <pre>
	 * 교수 정보 조회
	 * </pre>
	 * <pre>
	 * @param pr_Profsr_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ProfsrVO selectProfsr(String pr_Profsr_No) throws SQLException;
	/**
	 * <pre>
	 * 교수 정보 수정
	 * </pre>
	 * <pre>
	 * @param profsrVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateProfsr(ProfsrVO profsrVO) throws SQLException;
}
