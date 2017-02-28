package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;

/**
 * <pre>
 * 강의 동영상 테이블의 CRUD를 위한 DAO
 * </pre>
 * @author KJS
 * @since 2017.02.27
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                   수정내용
 * --------     --------    ----------------------
 * 2017.02.27     KJS                   최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Lctre_Video_ProfsrDAO {

	/**
	 * <pre>
	 * 동영상 게시판 리스트 출력
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @param tpage
	 * @param totalRecord
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_VideoVO> listAllLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt,
			int tpage, int totalRecord) throws SQLException;

	/**
	 * <pre>
	 * 동영상 게시판 리스트 개수 출력
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int totalLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException;

	/**
	 * <pre>
	 * 하나의 동영상 게시판 출력 
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_VideoVO getLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 동영상 게시판 등록
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int insertLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 동영상 게시판 수정
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int updateLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 동영상 게시판 삭제
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int deleteLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

}
