package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Bbs_CommentDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Bbs_CommentVO;

public class Bbs_CommentDAOImpl implements Bbs_CommentDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<Bbs_CommentVO> listAllBbs_Comment(int tpage, int totalRecord,
			String key) throws SQLException {
		Paging p = new Paging();
		key = p.key(key);
		int[] rows = p.row(tpage, totalRecord);
		List<Bbs_CommentVO> listAllBbs_Comment = client.queryForList("listAllNotice_Bbs",key,rows[1],rows[0]);
		return listAllBbs_Comment;
	}

	@Override
	public Bbs_CommentVO getBbs_Comment(int bc_Comnt_No) throws SQLException {
		return (Bbs_CommentVO) client.queryForObject("getBbs_Comment", bc_Comnt_No);
	}

	@Override
	public int insertBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException {
		return client.update("insertNotice_Bbs", bbs_Comment);
	}

	@Override
	public int updateBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException {
		// TODO Auto-generated method stub
		return client.update("updateNotice_Bbs", bbs_Comment);
	}

	@Override
	public int deleteBbs_Comment(int bc_Comnt_No) throws SQLException {
		return client.update("deleteNotice_Bbs", bc_Comnt_No);
	}

	@Override
	public int totalBbs_Comment() throws SQLException {
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalNotice_Bbs",null);
		return total_pages;
	}

}
