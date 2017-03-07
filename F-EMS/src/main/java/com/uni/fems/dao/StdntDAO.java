package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dto.StdntVO;

/**
 * <pre>
 * 학생 관련 사항을 처리하는 DAO
 * </pre>
 * 
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface StdntDAO {
	/**
	 * <pre>
	 * 학생 정보 등록
	 * </pre>
	 * 
	 * <pre>
	 * @param stdntVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertStdnt(StdntVO stdntVO) throws SQLException;

	/**
	 * <pre>
	 * 학생 정보 수정
	 * </pre>
	 * 
	 * <pre>
	 * @param stdntVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateStdnt(StdntVO stdntVO) throws SQLException;

	/**
	 * <pre>
	 * 학생 이름으로 검색한 자료의 총 개수를 구함
	 * </pre>
	 * 
	 * <pre>
	 * @param st_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int totalRecord(String st_Nm) throws SQLException;

	/**
	 * <pre>
	 * 학생 이름으로 검색한 학생 정보 리스트
	 * </pre>
	 * 
	 * <pre>
	 * @param tpage
	 * @param totalRecord
	 * @param st_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<StdntVO> selectNameAllPage(int tpage, int totalRecord, String st_Nm)
			throws SQLException;

	/**
	 * <pre>
	 * 학생번호로 학생 정보를 가져옴
	 * </pre>
	 * 
	 * <pre>
	 * @param st_Stdnt_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	StdntVO selectStdnt(String st_Stdnt_No) throws SQLException;

	/**
	 * <pre>
	 * 기숙사 신청
	 * </pre>
	 * 
	 * <pre>
	 * @param stdntVO
	 * @throws SQLException
	 * </pre>
	 */
	void registBrhs(StdntVO stdntVO) throws SQLException;

	/**
	 * <pre>
	 * 비밀번호 변경
	 * </pre>
	 * 
	 * <pre>
	 * @param stdntVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	void updatePw(StdntVO stdntVO) throws SQLException;

	/**
	 * <pre>
	 * 학과 코드로 학과 내 학생 조회
	 * </pre>
	 * 
	 * <pre>
	 * @param st_Subjct_Code
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<StdntVO> subjctStdnt(String st_Subjct_Code) throws SQLException;

	/**
	 * 학생 리스트 조회
	 * 
	 * @param stdntVO
	 * @param start
	 * @param count
	 * @return
	 * @throws SQLException
	 */
	ArrayList<StdntVO> selectStdntList(StdntVO stdntVO, int start, int count)
			throws SQLException;

	/**
	 * 학생 리스트 조회 개수
	 * 
	 * @param stdntVO
	 * @return
	 * @throws SQLException
	 */
	int countStdntList(StdntVO stdntVO) throws SQLException;
	
	/**
	 * 학생의 조건에 따른 조회기능
	 * @param stdntVO
	 * @param tpage
	 * @param totalRecord
	 * @return
	 * @throws SQLException
	 */
	List<StdntVO> selectAllStdntList2(StdntVO stdntVO, int tpage,
			int totalRecord) throws SQLException;
	/**
	 * 학생의 조건에 따른 조회의 개수
	 * @param stdntVO
	 * @return
	 * @throws SQLException
	 */
	int countStdntList2(StdntVO stdntVO) throws SQLException;
	/**
	 * 교수 배정
	 * @param stdntVO
	 * @throws SQLException
	 */
	void updateSt_Profsr_No(StdntVO stdntVO) throws SQLException;

	/**
	 * <pre>
	 * 학생 번호 만드는 메서드
	 * </pre>
	 * <pre>
	 * @param stdntVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String createStdntNo(StdntVO stdntVO) throws SQLException;
}
