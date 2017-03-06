package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.ManageVO;

/**
 * <pre>
 * 대학관리 테이블에 조회, 등록, 수정이 가능한 DAO
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * 2017.02.15      KJH            추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface ManageDAO {
	
	/**
	 * <pre>
	 * 대학이름과 일치하는 하나의 대학정보 가져오기
	 * </pre>
	 * <pre>
	 * @param mng_Univ_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ManageVO getManage() throws SQLException;
	/**
	 * <pre>
	 * Manage테이블 가장 마지막 ROW 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ManageVO getlastUniv() throws SQLException;
	/**
	 * <pre>
	 * 학교정보를 수정하는 메서드
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int updateUniv(ManageVO manageVO) throws SQLException;
	/**
	 * <pre>
	 * 게시판 리스트를 가져옴
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_ListVO> getBbsList(String name) throws SQLException;
	/**
	 * <pre>
	 * 학생의 수강 목록을 가져옴
	 * </pre>
	 * <pre>
	 * @param loginUser
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<LctreVO> getStdntList(String loginUser) throws SQLException;
	/**
	 * <pre>
	 * 교수의 수강 목록을 가져옴
	 * </pre>
	 * <pre>
	 * @param loginUser
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<LctreVO> getProfsrList(String loginUser) throws SQLException;
	
	/**
	 * <pre>
	 * 대학을 등록하는 메서드
	 * </pre>
	 * <pre>
	 * @param manageVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int insertUniv(ManageVO manageVO ) throws SQLException;
	
	/**
	 * <pre>
	 * 대학 정보를 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param univNm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int deleteUniv(Object univNm) throws SQLException;
}
