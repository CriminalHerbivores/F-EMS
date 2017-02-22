package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.UserSubjctVO;

/**
 * <pre>
 * 직원 관련 사항을 처리하는 DAO
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
 * 2017.02.22.    KJH       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface SklstfDAO {
	/**
	 * <pre>
	 * 직원 정보를 가져옴
	 * </pre>
	 * <pre>
	 * @param stf_Sklstf_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	SklstfVO getSklstf(String stf_Sklstf_No)throws SQLException;
	/**
	 * <pre>
	 * 직원 정보 수정
	 * </pre>
	 * <pre>
	 * @param sklstfVo
	 * @throws SQLException
	 * </pre>
	 */
	void updateSklstf(SklstfVO sklstfVo)throws SQLException;	
	
	/**
	 * <pre>
	 * 관리자가 직원 등록
	 * </pre>
	 * <pre>
	 * @param sklstfVo
	 * @throws SQLException
	 * </pre>
	 */
	void insertSklstf(SklstfVO sklstfVo)throws SQLException;
	
	
	/**
	 * <pre>
	 * 전체 직원의 목록
	 * </pre>
	 * <pre>
	 * @param stf_Nm
	 * @return
	 * @throws SQLException
	 */
	List<UserSubjctVO> listAllSklstf(SearchVO searchVO, int tpage, int totalRecord) throws SQLException;
	
	
	/**
	 * <pre>
	 * 직원목록의 직원수를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param userSubjctVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int totalSklstf(SearchVO searchVO) throws SQLException;
}
