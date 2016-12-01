package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;

/**
 * <pre>
 * 학적 관련 사항을 처리하는 DAO
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
public interface SknrgsDAO {
	/**
	 * <pre>
	 * 학생의 현재 학적 상태를 가져옴
	 * </pre>
	 * <pre>
	 * @param skn_Stdnt_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String getSknrgs(String skn_Stdnt_No) throws SQLException;
	/**
	 * <pre>
	 * 학적 변동을 가져온 리스트
	 * </pre>
	 * <pre>
	 * @param p
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SknrgsVO> getStudentSknrgs(PageRequest p) throws SQLException;
	/**
	 * <pre>
	 * 학적 변동을 조회한 리스트의 데이터 총 개수
	 * </pre>
	 * <pre>
	 * @param p
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int totalRecord(PageRequest p) throws SQLException;
	/**
	 * <pre>
	 * 학적 변동 등록
	 * </pre>
	 * <pre>
	 * @param sknrgs
	 * @throws SQLException
	 * </pre>
	 */
	void writeSknrgs(SknrgsVO sknrgs) throws SQLException;
	/**
	 * <pre>
	 * 학적과 학생 정보를 가져온 리스트
	 * </pre>
	 * <pre>
	 * @param skn_Typen
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SknrgsViewVO> getSknrgsType(String skn_Typen) throws SQLException;
	/**
	 * <pre>
	 * 학적 변동 승인/거부
	 * </pre>
	 * <pre>
	 * @param sknrgs
	 * @throws SQLException
	 * </pre>
	 */
	void updateUseynSknrgs(SknrgsVO sknrgs) throws SQLException;
	
	
	int totalSknrgs(SknrgsViewVO sknrgsView) throws SQLException;
	List<SknrgsViewVO> listAllSknrgs(SknrgsViewVO sknrgsView, int tpage,
			int totalRecord) throws SQLException;
}