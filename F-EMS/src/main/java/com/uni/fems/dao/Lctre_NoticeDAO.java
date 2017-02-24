package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_NoticeVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;

/**
 * <pre>
 * 제너레이터로 생성된 강의 공지 게시판 CRUD를 위한 DAO
 * </pre>
 * @author KJS
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Lctre_NoticeDAO {

	/**
	 * <pre>
	 * 전체 리스트를 받아온다.
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @param tpage
	 * @param totalRecord
	 * @return List<Lctre_DateVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_NoticeVO> listAllLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt,
			int tpage, int totalRecord) throws SQLException;

	/**
	 * <pre>
	 * 전체 리스트의 개수
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int totalLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 하나의 리스트를 가디고 온다.
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
	 * 리스트의 값을 입력한다.
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int insertLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 리스트의 값을 수정한다.
	 * </pre>
	 * <pre>
	 * @param lctre_Date_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 조회수를 증가시킨다.
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
	 * 게시판을 삭제한다.
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
