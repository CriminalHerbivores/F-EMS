package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;

/**
 * <pre>
 * 강의 동영상 게시판을 사용하기 위한 서비스
 * </pre>
 * @author KJS
 * @since 2017.02.27
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.27     kjs                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Lctre_Video_ProfsrService {

	/**
	 * <pre>
	 * 동영상 게시판 리스트 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Video_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Lctre_VideoVO> listAllLctre_Video(int tpage,
			Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException;

	/**
	 * <pre>
	 * 게시판의 페이지 설정
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param lctre_Video_Gnt
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int tpage, Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 하나의 게시판 출력
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
	 * 파일 불러오기
	 * </pre>
	 * <pre>
	 * @param lf_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_FlpthVO getLctre_Flpth(String lf_No) throws SQLException;

	/**
	 * <pre>
	 * 게시판 등록
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @param lctre_FlpthVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;

	/**
	 * <pre>
	 * 게시판 수정
	 * </pre>
	 * <pre>
	 * @param lctre_Video_Gnt
	 * @param lctre_FlpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int updateLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;

	/**
	 * <pre>
	 * 게시판 삭제
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
