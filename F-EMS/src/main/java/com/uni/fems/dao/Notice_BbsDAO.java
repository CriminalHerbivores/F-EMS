package com.uni.fems.dao;


import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;

/**
 * <pre>
 * 공지게시판 CRUD를 위한 DAO
 * </pre>
 * @author 송선호
 * @since 2017.02.01
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.01     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface Notice_BbsDAO {
	
	/**
	 * <pre>
	 * 공지게시판 리스트를 출력하는 메서드
	 * </pre>
	 * <pre>
	 * @param nb_Sklstf_No
	 * @return List<Notice_BbsVO>
	 * @throws SQLException
	 * </pre>
	 */
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No) throws SQLException; // 공지 게시판 리스트
	
	/**
	 * <pre>
	 * 게시판 하나의 vo클래스를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param nb_Bbs_No
	 * @return Notice_BbsVO
	 * @throws SQLException
	 * </pre>
	 */
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException; //게시판 vo클래스 하나 가져오기
	
	/**
	 * <pre>
	 * 공지게시판을 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param notice_BbsVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException; // 공지게시판 insert
	
	/**
	 * <pre>
	 * 공지게시판 가장 큰 No 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int maxNotice_No() throws SQLException; //공지게시판 Max NO값 가져오기
	
	
	
	//////////////////////////////////// 관리자 ///////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 공지게시판 리스트를 출력하는 메서드
	 * </pre>
	 * <pre>
	 * @param searchVO
	 * @param tpage
	 * @param totalRecord
	 * @return List<Notice_BbsVO>
	 * @throws SQLException
	 * </pre>
	 */
	public List<Notice_BbsVO> listAllNotice_Bbs(SearchVO searchVO, int tpage, int totalRecord) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판을 수정하는 메서드
	 * </pre>
	 * <pre>
	 * @param notice_BbsVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판을 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param nb_Bbs_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteNotice_Bbs(int nb_Bbs_No) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판 게시물 번호를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param notice_BbsVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	public int countNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판 게시물 개수를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	public int totalNotice_Bbs() throws SQLException;
	


}
