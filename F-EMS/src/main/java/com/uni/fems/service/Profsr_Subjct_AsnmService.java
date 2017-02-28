package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Profsr_Subjct_AsnmVO;

public interface Profsr_Subjct_AsnmService {
	/**
	 * <pre>
	 * 교수 학과 배정 등록
	 * </pre>
	 * <pre>
	 * @param asnmVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertProfsr_Subjct_Asnm(Profsr_Subjct_AsnmVO asnmVO) throws SQLException;
	/**
	 * <pre>
	 * 교수 학과 배정 수정
	 * </pre>
	 * <pre>
	 * @param asnmVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateProfsr_Subjct_Asnm(Profsr_Subjct_AsnmVO asnmVO) throws SQLException;
	/**
	 * <pre>
	 * 교수 학과 배정 조회
	 * </pre>
	 * <pre>
	 * @param asnmVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Profsr_Subjct_AsnmVO> selectProfsr_Subjct_Asnm(Profsr_Subjct_AsnmVO asnmVO) throws SQLException;
}
