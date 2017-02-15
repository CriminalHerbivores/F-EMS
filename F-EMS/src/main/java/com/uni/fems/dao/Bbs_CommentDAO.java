package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_CommentVO;

/**
 * <pre>
 * 공지게시판 댓글 CRUD를 위한 DAO
 * </pre>
 * @author 송선호
 * @since 2017.02.07
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.07     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface Bbs_CommentDAO {
	
	/**
	 * <pre>
	 * 모든 댓글을 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param totalRecord
	 * @param key
	 * @return List<Bbs_CommentVO>
	 * @throws SQLException
	 * </pre>
	 */
	public List<Bbs_CommentVO> listAllBbs_Comment(int tpage, int totalRecord, String key) throws SQLException;
	
	/**
	 * <pre>
	 * 해당하는 게시물의 모든 댓글을 리스트로 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param bc_Bbs_No
	 * @param tpage
	 * @param totalRecord
	 * @return List<Bbs_CommentVO>
	 * @throws SQLException
	 * </pre>
	 */
	public List<Bbs_CommentVO> getBbs_Comment(int bc_Bbs_No, int tpage, int totalRecord) throws SQLException;
	
	/**
	 * <pre>
	 *  댓글을 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_Comment
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException;
	
	/**
	 * <pre>
	 * 댓글을 수정하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_Comment
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int updateBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException;
	
	/**
	 * <pre>
	 * 댓글을 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param bc_Comnt_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteBbs_Comment(int bc_Comnt_No) throws SQLException;
	
	/**
	 * <pre>
	 * 해당 게시물의 모든 댓글을 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param bc_Bbs_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteAllBbs_Comment(int bc_Bbs_No) throws SQLException;
	
	/**
	 * <pre>
	 * 해당 게시물의 댓글 개수를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param bc_Bbs_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int totalBbs_Comment(int bc_Bbs_No) throws SQLException;
	
	
	
		
	

}
