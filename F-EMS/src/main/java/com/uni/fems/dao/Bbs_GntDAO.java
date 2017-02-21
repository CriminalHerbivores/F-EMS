package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_GntVO;
import com.uni.fems.dto.Bbs_List_GntVO;

/**
 * <pre>
 * 제너레이터로 생성된 게시판의 CRUD를 위한 DAO
 * </pre>
 * @author kjs
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
public interface Bbs_GntDAO {

	/**
	 * <pre>
	 * 제너레이터로 생성된 게시판의 리스트를 출력하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @return List<Bbs_GntVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_GntVO> listBbs_Gnt(Bbs_List_GntVO bbs_list_gnt)
			throws SQLException;

	/**
	 * <pre>
	 * 제너레이터로 생성된 게시판의 하나의 vo클래스를 가져오는 메서드
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
	 * 제너레이터로 생성된 게시판의 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int insertBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException;

	/**
	 * <pre>
	 * 제너레이터로 생성된 게시판의 리스트를 출력하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @param tpage
	 * @param totalRecord
	 * @return List<Bbs_GntVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_GntVO> listAllBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, int tpage,
			int totalRecord) throws SQLException;

	/**
	 * <pre>
	 * 제너레이터로 생성된 게시판의 리스트를 출력하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int totalBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException;

	/**
	 * <pre>
	 * 제너레이터로 생성된 게시판의 수정하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException;

	/**
	 * <pre>
	 * 제너레이터로 생성된 게시판의 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_list_gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int deleteBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException;
	/**
	 * <pre>
	 * 제너레이터로 생성된 게시판의 조회수를 증가시킨다. 
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
	 * 제너레이터로 생성된 게시판의 게시물 개수를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param table_nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int maxNotice_No(String table_nm) throws SQLException;

}
