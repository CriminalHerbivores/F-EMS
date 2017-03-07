package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dto.StdntVO;

/**
 * <pre>
 * 학생 정보를 관리하기 위한 Service
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
public interface StdntService {
	/**
	 * <pre>
	 * 학생 정보를 등록
	 * </pre>
	 * <pre>
	 * @param stdntVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertStdnt(StdntVO stdntVO)throws SQLException;
	/**
	 * <pre>
	 * 학생 정보를 수정
	 * </pre>
	 * <pre>
	 * @param stdntVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateStdnt(StdntVO stdntVO)throws SQLException;
	/**
	 * <pre>
	 * 학생 이름으로 학생 정보를 조회
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param st_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<StdntVO> selectNameAllPage(int tpage,String st_Nm) throws SQLException;
	/**
	 * <pre>
	 * 학생 이름으로 검색한 페이지를 만듦
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
	 * 학생 하나의 정보를 조회
	 * </pre>
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
	 * <pre>
	 * @param stdntVO
	 * @throws SQLException
	 * </pre>
	 */
	void registBrhs(StdntVO stdntVO) throws SQLException;
	/**
	 * 학생 리스트 조회
	 * @param stdntVO
	 * @param start
	 * @param count
	 * @return
	 * @throws SQLException
	 */
	ArrayList<StdntVO> selectStdntList(StdntVO stdntVO, int start, int count) throws SQLException;
	/**
	 * 학생 리스트 조회 개수
	 * @param stdntVO
	 * @return
	 * @throws SQLException
	 */
	int countStdntList(StdntVO stdntVO) throws SQLException;
	
	/**
	 * 학생 리스트 출력
	 * @param tpage
	 * @param stdntVO
	 * @return
	 * @throws SQLException
	 */
	List<StdntVO> selectAllStdntList2(int tpage, StdntVO stdntVO)
			throws SQLException;
	
	/**
	 * 학생 리스트 페이지 출력
	 * @param tpage
	 * @param stdntVO
	 * @return
	 * @throws SQLException
	 */
	String pageNumber2(int tpage, StdntVO stdntVO) throws SQLException;
	/**
	 * 교수 배정
	 * @param stdntVO
	 * @throws SQLException
	 */
	void updateSt_Profsr_No(StdntVO stdntVO) throws SQLException;
}
