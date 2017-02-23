package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_NoticeVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;

/**
 * <pre>
 * 강의 공지 게시판의 service
 * </pre>
 * @author KJS
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Lctre_NoticeService {

	/**
	 * <pre>
	 *  게시판 리스트 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Date_Gnt
	 * @return List<Lctre_DateVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_NoticeVO> listAllLctre_Notice(int tpage,
			Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException;

	/**
	 * <pre>
	 *  게시판 리스트의 페이지 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Date_Gnt
	 * @param searchVO
	 * @return String
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int tpage, Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  하나의 게시판 출력
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @return Lctre_DateVO
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_NoticeVO getLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  게시판 등록
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @param lctre_FlpthVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  게시판 수정
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @param lctre_FlpthVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  데시판 조회수 증가	
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int countLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  게시판 삭제
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int deleteLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

}
