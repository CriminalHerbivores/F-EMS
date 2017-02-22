package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.Subjct_Info_TableVO;
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
	 * 학과 / 등록금 정보 조회
	 * @param tpage
	 * @param totalRecord
	 * @param sit_Subjct
	 * @return
	 * @throws SQLException
	 */
	ArrayList<UserSubjctVO> selectSubjctByName(int tpage, int totalRecord, String sit_Subjct) throws SQLException;
	/**
	 * 학과 / 등록금 개수 조회
	 * @param sit_Subjct
	 * @return
	 * @throws SQLException
	 */
	int countSubjctByName(String sit_Subjct) throws SQLException;
	/**
	 * 등록금 고지
	 * @throws SQLException
	 */
	void toStdTuition() throws SQLException;
	/**
	 * 등록금 수정
	 * @param subVO
	 * @throws SQLException
	 */
	void updateTuition(Subjct_Info_TableVO subVO) throws SQLException;
	/**
	 * 학과 코드로 학과 정보 조회
	 * @param sit_Subjct_Code
	 * @return
	 * @throws SQLException
	 */
	UserSubjctVO selectSubjctByCode(String sit_Subjct_Code) throws SQLException;
}
