package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.ColegeVO;
import com.uni.fems.dto.FacultyVO;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.UserSubjctVO;

/**
 * <pre>
 * 학과 관련 사항을 처리하는 DAO
 * </pre>
 * @author KJH
 * @since 2017. 02. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017.02.22.    KJH           최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Subjct_Info_TableDAO {
	
	/**
	 * <pre>
	 * 사용자가 학과명으로 검색하여 학과 찾기
	 * </pre>
	 * <pre>
	 * @param sit_Subjct
	 * @return
	 * @throws SQLException
	 */
	ArrayList<UserSubjctVO> selectSubjctByName(String sit_Subjct) throws SQLException;
	/**
	 * <pre>
	 * 사용자가 학과명으로 검색하여 학과 찾기 + 페이지
	 * </pre>
	 * <pre>
	 * @param sit_Subjct
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<UserSubjctVO> selectSubjctByNamePaging(int tpage, int totalRecord, String sit_Subjct) throws SQLException;
	/**
	 * <pre>
	 * 사용자가 학과명으로 검색하여 학과 찾기 총 개수
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
	 * 단과 대학 조회
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<ColegeVO> selectColege() throws SQLException;
	/**
	 * <pre>
	 * 단과 대학명으로 학부 조회
	 * </pre>
	 * <pre>
	 * @param fc_Coleg_Code
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<FacultyVO> selectFaculty(String fc_Coleg_Code) throws SQLException;
	/**
	 * <pre>
	 * 학부명으로 학과 조회
	 * </pre>
	 * <pre>
	 * @param sit_Faculty
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ArrayList<Subjct_Info_TableVO> selectSubjct(String sit_Faculty) throws SQLException;
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
	ArrayList<UserSubjctVO> selectSubjctByCode(String sit_Subjct_Code) throws SQLException;
	/**
	 * <pre>
	 * 등록금 수정
	 * </pre>
	 * <pre>
	 * @param sub
	 * @throws SQLException
	 * </pre>
	 */
	void updateTut(Subjct_Info_TableVO sub) throws SQLException;
}
