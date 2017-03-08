package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.LctreVO;
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
 * 2017. 3. 08.    KJS       추가작성
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
	 * @param sumReqst
	 * @throws SQLException
	 * </pre>
	 */
	int getSumReqst(ReqstVO reqstVO) throws SQLException;
	
	//----------------------------------------------------------------------
	
	/**
	 * <pre>
	 * 한 개설강의의 강의실 수용가능 인원수
	 * </pre>
	 * <pre>
	 * @param lc_Lctre_No
	 * @return
	 * @throws SQLException
	 */
	int acceptNumOfStdnt(String lc_Lctre_No) throws SQLException;
	
	/**
	 * <pre>
	 * 한 과목을 수강중인 학생의 인원수
	 * </pre>
	 * <pre>
	 * @param re_Lctre_No
	 * @return
	 * @throws SQLException
	 */
	int stdntNumOfLctre(String re_Lctre_No) throws SQLException;
	
	/**
	 * <pre>
	 * 수강신청 결과에 따라 한 과목의 수강중인 인원수 변경
	 * </pre>
	 * <pre>
	 * @param lctreVO
	 * @throws SQLException
	 */
	void setNumOfStdnt(Lctre_SearchVO lctre_SearchVO) throws SQLException;

	/**
	 * 신청 목록 리스트 출력
	 * @param lctre_Search
	 * @param tpage
	 * @param totalRecord
	 * @return
	 * @throws SQLException
	 */
	List<Lctre_SearchVO> selectEvl_Scope(Lctre_SearchVO lctre_Search,
			int tpage, int totalRecord) throws SQLException;

	/**
	 * 신청 목록의 개수 출력
	 * @param lctre_Search
	 * @return
	 * @throws SQLException
	 */
	int totalEvl_Scope(Lctre_SearchVO lctre_Search) throws SQLException;

	/**
	 * 하나의 리스트 출력
	 * @param lctre_Search
	 * @return
	 * @throws SQLException
	 */
	Lctre_SearchVO getEvl_Scope(Lctre_SearchVO lctre_Search)
			throws SQLException;
	
}
