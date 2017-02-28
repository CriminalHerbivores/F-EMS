package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.PymntVO;
import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.dto.SchlshipVO;

/**
 * <pre>
 * 장학금 관련 사항을 처리하는 DAO
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
public interface SchlshipDAO {
	/**
	 * <pre>
	 * 장학금을 모두 가져옴
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Schafs_SchdulVO> listAllSchafs_Schdul() throws SQLException;
	/**
	 * <pre>
	 * 장학금 등록
	 * </pre>
	 * <pre>
	 * @param schlshipVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertSchlship(SchlshipVO schlshipVO) throws SQLException;
	/**
	 * <pre>
	 * 장학금 이름으로 조회한 장학금 리스트 총 개수
	 * </pre>
	 * <pre>
	 * @param ss_Schlship_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int totalRecord(String ss_Schlship_Nm) throws SQLException;
	/**
	 * <pre>
	 * 장학금 이름으로 조회한 장학금 리스트
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param totalRecord
	 * @param ss_Schlship_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SchlshipVO> selectNameAllPage(int tpage, int totalRecord, String ss_Schlship_Nm) throws SQLException;
	/**
	 * <pre>
	 * 사용 가능한 장학금 리스트
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SchlshipVO> selectAllSchlship() throws SQLException;
	/**
	 * <pre>
	 * 장학금 조회
	 * </pre>
	 * <pre>
	 * @param ss_Schlship_Code
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	SchlshipVO selectSchlship(String ss_Schlship_Code) throws SQLException;
	/**
	 * <pre>
	 * 장학금 수정
	 * </pre>
	 * <pre>
	 * @param schlshipVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateSchlship(SchlshipVO schlshipVO) throws SQLException;
	/**
	 * <pre>
	 * 장학금 사용유무를 바꿈
	 * </pre>
	 * <pre>
	 * @param ss_Schlship_Code
	 * </pre>
	 */
	void deleteSchlship(SchlshipVO schlshipVO) throws SQLException;
	/**
	 * <pre>
	 * 장학금을 신청함
	 * </pre>
	 * <pre>
	 * @param pymntVO
	 * @throws SQLException
	 * </pre>
	 */
	void requestschlship(PymntVO pymntVO) throws SQLException;
	/**
	 * <pre>
	 * 학생의 장학금 신청 내역을 조회
	 * </pre>
	 * <pre>
	 * @param loginUser
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SchlshipVO> selectSchlshipByStdnt(SchlshipVO schlshipVO,int start,int count) throws SQLException;
	/**
	 * <pre>
	 * 학생의 장학금 신청 내역을 조회 개수
	 * </pre>
	 * <pre>
	 * @param schlshipVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int countSchlshipByStdnt(SchlshipVO schlshipVO) throws SQLException;
	/**
	 * <pre>
	 * 장학금 신청 내역 수정
	 * </pre>
	 * <pre>
	 * @param pymntVO
	 * @throws SQLException
	 * </pre>
	 */
	void updatePymnt(PymntVO pymntVO) throws SQLException;
}
