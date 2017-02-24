package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_TaskVO;
import com.uni.fems.dto.Lctre_Task_GntVO;

/**
 * <pre>
 * 강의 과제 게시판의 service
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
public interface Lctre_TaskService {

	/**
	 * <pre>
	 *  게시판 리스트 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Task_Gnt
	 * @return List<Lctre_TaskVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_TaskVO> listAllLctre_Task(int tpage,
			Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;
	/**
	 * <pre>
	 *  게시판 리스트의 페이지 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Task_Gnt
	 * @param searchVO
	 * @return String
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int tpage, Lctre_Task_GntVO lctre_Task_Gnt)
			throws SQLException;
	/**
	 * <pre>
	 *  하나의 게시판 출력
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @return Lctre_TaskVO
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_TaskVO getLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt)
			throws SQLException;
	/**
	 * <pre>
	 * 파일 경로 출력
	 * </pre>
	 * <pre>
	 * @param lf_No
	 * @return Lctre_FlpthVO
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_FlpthVO getLctre_Flpth(String lf_No) throws SQLException;
	/**
	 * <pre>
	 *  게시판 등록
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @param lctre_FlpthVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;
	/**
	 * <pre>
	 *  게시판 수정
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @param lctre_FlpthVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;
	/**
	 * <pre>
	 *  게시판 삭제
	 * </pre>
	 * <pre>
	 * @param lctre_Task_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int deleteLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

}
