package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_QnaVO;
import com.uni.fems.dto.Lctre_Qna_GntVO;

/**
 * <pre>
 * 강의 질의응답 게시판의 service
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
public interface Lctre_QnaService {

	/**
	 * <pre>
	 *  게시판 리스트 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Qna_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_QnaVO> listAllLctre_Qna(int tpage, Lctre_Qna_GntVO lctre_Qna_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  게시판 리스트의 페이지 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Qna_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int tpage, Lctre_Qna_GntVO lctre_Qna_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  하나의 게시판 출력
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_QnaVO getLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException;

	/**
	 * <pre>
	 *  게시판 등록
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException;

	/**
	 * <pre>
	 *  게시판 수정
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int updateLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException;

	/**
	 * <pre>
	 *  답글 입력
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int updateLctre_Qna_Reply(Lctre_Qna_GntVO lctre_Qna_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 *  데시판 조회수 증가	
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int countLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException;

	/**
	 * <pre>
	 *  게시판 삭제
	 * </pre>
	 * <pre>
	 * @param lctre_Qna_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int deleteLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException;

}
