package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_AtrtyVO;
import com.uni.fems.dto.Bbs_CommentVO;
import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.Bbs_List_AtrtyVO;

/**
 * <pre>
 * 게시판 리스트와 관계 CRUD를 위한 DAO
 * </pre>
 * @author 김진수
 * @since 2017.02.18
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                   수정내용
 * --------     --------    ----------------------
 * 2017.02.18     김진수                   최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Bbs_ListDAO {

	/**
	 * <pre>
	 * 게시판 리스트와 관계 입력
	 * </pre>
	 * <pre>
	 * @param bbs_List_AtrtyVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	int insertBbs_List_Atrty(Bbs_List_AtrtyVO bbs_List_AtrtyVO)
			throws SQLException;

	/**
	 * <pre>
	 * 게시판 리스트와 관계 페이지 출력
	 * </pre>
	 * <pre>
	 * @param bc_Bbs_Nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int totalBbs_List_Atrty(String bc_Bbs_Nm) throws SQLException;

	/**
	 * <pre>
	 * 게시판 리스트와 관계 리스트 출력
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param totalRecord
	 * @param key
	 * @return List<Bbs_List_AtrtyVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_List_AtrtyVO> listAllBbs_List_Atrty(int tpage, int totalRecord,
			String key) throws SQLException;

	/**
	 * <pre>
	 * 하나의 게시판 리스트와 관계 출력 
	 * </pre>
	 * <pre>
	 * @param bl_Bbs_No
	 * @return Bbs_List_AtrtyVO
	 * @throws SQLException
	 * </pre>
	 */
	Bbs_List_AtrtyVO getBbs_List_Atrty(int bl_Bbs_No) throws SQLException;

	/**
	 * <pre>
	 * 게시판 관계 수정
	 * </pre>
	 * <pre>
	 * @param bbs_AtrtyVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateBbs_Atrty(Bbs_AtrtyVO bbs_AtrtyVO) throws SQLException;

	/**
	 * <pre>
	 * 게시판 리스트 수정
	 * </pre>
	 * <pre>
	 * @param bbs_ListVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateBbs_List(Bbs_ListVO bbs_ListVO) throws SQLException;

	/**
	 * <pre>
	 * 게시판 테이블 생성
	 * </pre>
	 * <pre>
	 * @param name
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int insertBbs_Table(String name) throws SQLException;

	/**
	 * <pre>
	 * 게시판 탯글 테이블 생성
	 * </pre>
	 * <pre>
	 * @param name
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int insertComment_Table(String name) throws SQLException;

}
