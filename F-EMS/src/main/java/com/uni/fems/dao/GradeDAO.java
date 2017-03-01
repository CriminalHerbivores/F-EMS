package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.ReqstVO;

/**
 * <pre>
 * 성적 관리를 위한 DAO
 * </pre>
 * @author JAR
 * @since 2017. 2. 27.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 27.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface GradeDAO {
	/**
	 * <pre>
	 * 성적 등록을 위한 틀을 등록
	 * </pre>
	 * <pre>
	 * @param reqstVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertGrade(ReqstVO reqstVO) throws SQLException;
	/**
	 * <pre>
	 * 성적 등록을 위한 틀을 삭제
	 * </pre>
	 * <pre>
	 * @param reqstVO
	 * @throws SQLException
	 * </pre>
	 */
	void deleteGrade(ReqstVO reqstVO) throws SQLException;
	/**
	 * <pre>
	 * 성적 등록을 수정
	 * </pre>
	 * <pre>
	 * @param gradeVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateGrade(GradeVO gradeVO) throws SQLException;
	/**
	 * <pre>
	 * 성적을 조회
	 * </pre>
	 * <pre>
	 * @param gradeVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<GradeVO> selectGrade(GradeVO gradeVO) throws SQLException;
	/**
	 * <pre>
	 * 조회한 성적의 개수
	 * </pre>
	 * <pre>
	 * @param gradeVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int countGrade(GradeVO gradeVO) throws SQLException;
	/**
	 * <pre>
	 * 학생 성적 조회
	 * </pre>
	 * <pre>
	 * @param grade
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<GradeVO> lctreGrade(GradeVO grade) throws SQLException; 
}
