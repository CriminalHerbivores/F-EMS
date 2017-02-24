package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_TaskVO;
import com.uni.fems.dto.Lctre_Task_GntVO;

/**
 * <pre>
 * 강의 과제 테이블의 CRUD를 위한 DAO
 * </pre>
 * @author KJS
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                   수정내용
 * --------     --------    ----------------------
 * 2017.02.24     KJS                   최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Lctre_TaskDAO {

	/**
	 * <pre>
	 * 	리스트 출력
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @param tpage
	 * @param totalRecord
	 * @return
	 * @throws SQLException
	 * <pre>
	 */
	List<Lctre_TaskVO> listAllLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt,
			int tpage, int totalRecord) throws SQLException;

	/**
	 * <pre>
	 * 리스트의 개수 출력
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @return
	 * @throws SQLException
	 * <pre>
	 */
	int totalLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	/**
	 * <pre>
	 * 하나의 게시판을 받아온다
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @return
	 * @throws SQLException
	 * <pre>
	 */
	Lctre_TaskVO getLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 게시판 등록
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @return
	 * @throws SQLException
	 * <pre>
	 */
	int insertLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	/**
	 * <pre>
	 * 게시판 수정
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @return
	 * @throws SQLException
	 * <pre>
	 */
	int updateLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	/**
	 * <pre>
	 * 게시판 삭제
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @return
	 * @throws SQLException
	 * <pre>
	 */
	int deleteLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

}
