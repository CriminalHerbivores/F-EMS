package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.Bbs_CommentDAO;
import com.uni.fems.dto.Bbs_CommentVO;

/**
 * <pre>
 * 공지게시판 댓글 CRUD를 위한 DAOImpl
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

public class Bbs_CommentDAOImpl implements Bbs_CommentDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<Bbs_CommentVO> listAllBbs_Comment(int tpage, int totalRecord, String key) throws SQLException {
		Paging p = new Paging();
		key = p.key(key);
		int[] rows = p.row(tpage, totalRecord);
		List<Bbs_CommentVO> listAllBbs_Comment = client.queryForList("listAllNotice_Bbs",key,rows[1],rows[0]);
		return listAllBbs_Comment;
	}

	@Override
	public List<Bbs_CommentVO> getBbs_Comment(int bc_Bbs_No, int tpage, int totalRecord)throws SQLException {
		
		Paging p = new Paging();
		int[] rows = p.row(tpage,totalRecord);
		List<Bbs_CommentVO> getBbs_Comment = client.queryForList("getBbs_Comment",bc_Bbs_No,rows[1],rows[0]); 
		return getBbs_Comment;
	}


	@Override
	public int insertBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException {
		return client.update("insertBbs_Comment", bbs_Comment);
	}

	@Override
	public int updateBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("updateBbs_Comment", bbs_Comment);
	}

	@Override
	public int deleteBbs_Comment(int bc_Comnt_No) throws SQLException {
		return client.update("deleteBbs_Comment", bc_Comnt_No);
	}

	@Override
	public int deleteAllBbs_Comment(int bc_Bbs_No) throws SQLException {
		return client.update("deleteAllBbs_Comment", bc_Bbs_No);
	}
	
	@Override
	public int totalBbs_Comment(int bc_Bbs_No) throws SQLException {
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalBbs_Comment",bc_Bbs_No);
		return total_pages;
	}



}
