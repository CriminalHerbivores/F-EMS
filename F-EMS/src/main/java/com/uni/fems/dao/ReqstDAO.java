package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;

/**
 * <pre>
 * 수강 신청 완료 목록 조회, 추가,삭제하는 DAO
 * </pre>
 * @author KJH
 * @since 2017. 2. 20.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017. 2. 20.    KJH       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface ReqstDAO {
	
	/**
	 * <pre>
	 * 로그인한 학생의 번호로 수강신청 완료된 목록을 조회하는 메서드
	 * </pre>
	 * <pre>
	 * @param re_Stdnt_No
	 * @return
	 * @throws SQLException
	 */
	List<Lctre_SearchVO> selectReqst(String re_Stdnt_No) throws SQLException;
	
	/**
	 * <pre>
	 * 수강 신청하는 메서드
	 * </pre>
	 * <pre>
	 * @param reqstVO
	 * @throws SQLException
	 */
	void insertReqst(ReqstVO reqstVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 수강신청 내역을 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param reqstVO
	 * @throws SQLException
	 */
	void deleteReqst(ReqstVO reqstVO) throws SQLException;

	/**
	 * <pre>
	 * 한 학생이 개설된 강의중 수강신청한 학점들의 총합계
	 * </pre>
	 * <pre>
	 * @param re_Stdnt_No
	 * @throws SQLException
	 * </pre>
	 */
	void getSumReqst(String re_Stdnt_No) throws SQLException;
}
