package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.TuitionVO;
import com.uni.fems.dto.UserSubjctVO;

/**
 * <pre>
 * 등록금에 관련된 로직들의 서비스
 * </pre>
 * @author JAR
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface TuitionService {
	/**
	 * <pre>
	 * 학과 / 등록금 정보 조회
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param totalRecord
	 * @param sit_Subjct
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<UserSubjctVO> selectSubjctByName(int tpage, int totalRecord, String sit_Subjct) throws SQLException;
	/**
	 * <pre>
	 * 학과 / 등록금 개수 조회
	 * </pre>
	 * <pre>
	 * @param sit_Subjct
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int countSubjctByName(String sit_Subjct) throws SQLException;
	/**
	 * <pre>
	 * 등록금 고지
	 * </pre>
	 * <pre>
	 * @throws SQLException
	 * </pre>
	 */
	void toStdTuition() throws SQLException;
	/**
	 * <pre>
	 * 등록금 수정
	 * </pre>
	 * <pre>
	 * @param subVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateTuition(Subjct_Info_TableVO subVO) throws SQLException;
	/**
	 * <pre>
	 * 학과 코드로 학과 정보 조회
	 * </pre>
	 * <pre>
	 * @param sit_Subjct_Code
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	UserSubjctVO selectSubjctByCode(String sit_Subjct_Code) throws SQLException;
	/**
	 * <pre>
	 * 학생의 등록금 내역 조회
	 * </pre>
	 * <pre>
	 * @param tuitionVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<TuitionVO> tuitionStdnt(TuitionVO tuitionVO,int start, int count) throws SQLException;
	/**
	 * <pre>
	 * 학생의 등록금 내역 조회 개수
	 * </pre>
	 * <pre>
	 * @param tuitionVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int countTuitionStdnt(TuitionVO tuitionVO) throws SQLException;
}
