package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_Comment_GntVO;
import com.uni.fems.dto.Bbs_List_Comment_GntVO;

/**
 * <pre>
 * 제너레이터 댓글 CRUD를 위한 Service
 * </pre>
 * @author KJS
 * @since 2017.02.21
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.21     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Bbs_Comment_GntService {

	/**
	 * <pre>
	 * 모든 댓글을 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param bbs_List_Comment_Gnt
	 * @return List<Bbs_Comment_GntVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_Comment_GntVO> listAllBbs_Comment_Gnt(int tpage,
			Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException;

	/**
	 * <pre>
	 * 해당하는 게시물의 모든 댓글을 리스트로 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_List_Comment_Gnt
	 * @param tpage
	 * @return List<Bbs_Comment_GntVO>
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_Comment_GntVO> getBbs_Comment_Gnt(
			Bbs_List_Comment_GntVO bbs_List_Comment_Gnt, int tpage)
			throws SQLException;
	/**
	 * <pre>
	 *  댓글을 추가하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_List_Comment_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int insertBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt)
			throws SQLException;
	/**
	 * <pre>
	 * 댓글을 수정하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_List_Comment_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int updateBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt)
			throws SQLException;
	/**
	 * <pre>
	 * 댓글을 삭제하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_List_Comment_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int deleteBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt)
			throws SQLException;
	/**
	 * <pre>
	 * 해당 게시물의 댓글 개수를 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_List_Comment_Gnt
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int totalBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt)
			throws SQLException;
	/**
	 * <pre>
	 * 해당 게시물의 댓글 페이지를 설정하는 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param bbs_List_Comment_Gnt
	 * @return pageNumber
	 * @throws SQLException
	 * </pre>
	 */
	String pageNumber(int cpage, Bbs_List_Comment_GntVO bbs_List_Comment_Gnt)
			throws SQLException;

}
