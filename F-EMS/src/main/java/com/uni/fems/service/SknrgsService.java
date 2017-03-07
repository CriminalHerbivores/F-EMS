package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;

/**
 * <pre>
 * 학적을 관리하기 위한 Service
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
 * 2017.03.02.    KJS       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface SknrgsService {
	/**
	 * <pre>
	 * 로그인 한 학생의 현재 학적 정보를 조회
	 * </pre>
	 * <pre>
	 * @param skn_Stdnt_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String getSknrgs(String skn_Stdnt_No) throws SQLException;
	/**
	 * <pre>
	 * 학적의 총 개수
	 * </pre>
	 * <pre>
	 * @param p
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int totalRecord(PageRequest p) throws SQLException;
	/**
	 * <pre>
	 * 학적을 리스트 형태로 가져옴
	 * </pre>
	 * <pre>
	 * @param p
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SknrgsVO> getStudentSknrgs(PageRequest p) throws SQLException;
	/**
	 * <pre>
	 * 학적의 페이지를 구함
	 * </pre>
	 * <pre>
	 * @param p
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(PageRequest p) throws SQLException;
	/**
	 * <pre>
	 * 학적 변동 사항을 등록
	 * </pre>
	 * <pre>
	 * @param sknrgs
	 * @throws SQLException
	 * </pre>
	 */
	void writeSknrgs(SknrgsVO sknrgs) throws SQLException;
	/**
	 * <pre>
	 * sknrgs_view에서 학생과 학적 정보를 가져옴
	 * </pre>
	 * <pre>
	 * @param skn_Typen
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<SknrgsViewVO> getSknrgsType(String skn_Typen) throws SQLException;
	/**
	 * <pre>
	 * 학적 변동 내역을 승인함
	 * </pre>
	 * <pre>
	 * @param sknrgs
	 * @throws SQLException
	 * </pre>
	 */
	void updateUseynSknrgs(SknrgsVO sknrgs) throws SQLException;
	
	List<SknrgsViewVO> listAllSknrgs(int tpage, SknrgsViewVO sknrgsView)
			throws SQLException;
	String pageNumberSknrgs(int tpage, SknrgsViewVO sknrgsView)
			throws SQLException;
}