package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.ReqstVO;

public interface GradeService {
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
	/**
	 * 학생의 총 학점 조회
	 * @param gd_Stdnt_No
	 * @return
	 * @throws SQLException
	 */
	GradeVO totalGrade(String gd_Stdnt_No) throws SQLException;
}
