package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.PymntVO;
import com.uni.fems.dto.SchlshipVO;

/**
 * <pre>
 * 장학금을 관리하기 위한 Service
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
public interface SchlshipService {
	/**
	 * <pre>
	 * 장학금 정보를 등록
	 * </pre>
	 * <pre>
	 * @param schlshipVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertSchlship(SchlshipVO schlshipVO) throws SQLException;
	/**
	 * <pre>
	 * 장학금 이름으로 검색한 정보
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param ss_Schlship_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SchlshipVO> selectNameAllPage(int tpage, String ss_Schlship_Nm) throws SQLException;
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
	 * 장학금 이름으로 검색한 정보의 페이지
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param ss_Schlship_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int tpage, String ss_Schlship_Nm) throws SQLException;
	/**
	 * <pre>
	 * 장학금 정보를 상세 조회
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
	 * 장학금 정보를 수정
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
	void deleteSchlship(String ss_Schlship_Code) throws SQLException;
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
