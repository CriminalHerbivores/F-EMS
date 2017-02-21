package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Bbs_GntVO;
import com.uni.fems.dto.Bbs_List_GntVO;
import com.uni.fems.dto.SearchVO;

/**
 * <pre>
 * 
 * </pre>
 * @author KJS
 * @since 2017.02.21
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.21     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Bbs_GntService {

	/**
	 * <pre>
	 * 제너레이터 게시판 하나의 vo클래스를 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @return Bbs_GntVO
	 * @throws SQLException
	 * </pre>
	 */
	Bbs_GntVO getBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException;

	/**
	 * <pre>
	 * 제너레이터 게시판을 추가하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @param bbs_FlpthVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, Bbs_FlpthVO bbs_FlpthVO)
			throws SQLException;

	/**
	 * <pre>
	 * 제너레이터 게시판의 리스트를 출력하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param bbs_list_gnt
	 * @return List<Bbs_GntVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_GntVO> listAllBbs_Gnt(int tpage, Bbs_List_GntVO bbs_list_gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 제너레이터 게시판을 수정하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @param bf_No
	 * @param bbs_FlpthVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, int bf_No,
			Bbs_FlpthVO bbs_FlpthVO) throws SQLException;

	/**
	 * <pre>
	 * 제너레이터 게시판을 삭제하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @param bbs_FlpthVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int deleteBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, Bbs_FlpthVO bbs_FlpthVO)
			throws SQLException;

	/**
	 * <pre>
	 * 제너레이터 게시판 리스트의 페이지를 설정하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param bbs_list_gnt
	 * @param searchVO
	 * @return String
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int tpage, Bbs_List_GntVO bbs_list_gnt, SearchVO searchVO)
			throws SQLException;

	/**
	 * <pre>
	 * 제너레이터 게시판의 개수를 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int countBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException;

	/**
	 * <pre>
	 * 해당하는 게시물의 업로드된 파일을 파일정보 테이블에서 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_flpthVO
	 * @return List<Bbs_FlpthVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_FlpthVO> getBbs_Flpth(Bbs_FlpthVO bbs_flpthVO) throws SQLException;

}
