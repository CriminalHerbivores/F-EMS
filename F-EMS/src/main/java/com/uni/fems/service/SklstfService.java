package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.Sklstf_AtrtyVO;
import com.uni.fems.dto.UserSubjctVO;

/**
 * <pre>
 * 직원 정보를 관리하기 위한 Service
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
public interface SklstfService {

	
	/**
	 * <pre>
	 * 직원 정보를 조회
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
	 * 관리자가 전체 직원 목록 조회
	 * </pre>
	 * <pre>
	 * @param stf_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	//List<UserSubjctVO> listSklstf(String stf_Nm) throws SQLException; 
	
	
	/**
	 * <pre>
	 * 관리자가 직원과 직원의 권한을 등록
	 * </pre>
	 * <pre>
	 * @param sklstfVo
	 * @throws SQLException
	 * </pre>
	 */
	void insertSklstf(SklstfVO sklstfVo, Sklstf_AtrtyVO sklstf_AtrtyVO)throws SQLException;
	
	/**
	 * <pre>
	 * 직원 정보를 수정
	 * </pre>
	 * <pre>
	 * @param sklstfVo
	 * @throws SQLException
	 * </pre>
	 */
	void updateSklstf(SklstfVO sklstfVo)throws SQLException;
	
	
	/**
	 * <pre>
	 * 직원 정보와 권한을 수정
	 * </pre>
	 * <pre>
	 * @param sklstf_AtrtyVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateSklstf_Atrty(SklstfVO sklstfVo, Sklstf_AtrtyVO sklstf_AtrtyVO) throws SQLException;
	
	//==========================================
	
	/**
	 * <pre>
	 * 직원 목록 페이지를 설정하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param searchVO
	 * @return String
	 * @throws SQLException
	 * </pre>
	 */
	public String pageNumber(int tpage,SearchVO searchVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 전체 직원의 목록
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param searchVO
	 * @return
	 * @throws SQLException
	 */
	List<UserSubjctVO> listAllSklstf(int tpage, SearchVO searchVO) throws SQLException;
}
