package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Bbs_CommentDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Bbs_CommentVO;
import com.uni.fems.service.Bbs_CommentService;

public class Bbs_CommentServiceImpl implements Bbs_CommentService{

	private Bbs_CommentDAO bbs_CommentDAO;
	
	
	public void setBbs_CommentDAO(Bbs_CommentDAO bbs_CommentDAO) {
		this.bbs_CommentDAO = bbs_CommentDAO;
	}

	@Override
	public List<Bbs_CommentVO> listAllBbs_Comment(int tpage, int bc_Bbs_No) throws SQLException {
		
		int totalRecord = bbs_CommentDAO.totalBbs_Comment(bc_Bbs_No);
		return bbs_CommentDAO.listAllBbs_Comment(tpage, totalRecord, "");
		
	}

	@Override
	public List<Bbs_CommentVO> getBbs_Comment(int bc_Bbs_No, int tpage) throws SQLException{
		int totalRecord = bbs_CommentDAO.totalBbs_Comment(bc_Bbs_No);
		return bbs_CommentDAO.getBbs_Comment(bc_Bbs_No, tpage, totalRecord);
	}
	

	@Override
	public int insertBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException {
		return bbs_CommentDAO.insertBbs_Comment(bbs_Comment);
		
		
		
	}

	@Override
	public int updateBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException {
		// TODO Auto-generated method stub
		return bbs_CommentDAO.updateBbs_Comment(bbs_Comment);
	}

	@Override
	public int deleteBbs_Comment(int bc_Comnt_No) throws SQLException {
		// TODO Auto-generated method stub
		return bbs_CommentDAO.deleteBbs_Comment(bc_Comnt_No);
	}

	@Override
	public int totalBbs_Comment(int bc_Bbs_No) throws SQLException {
		return bbs_CommentDAO.totalBbs_Comment(bc_Bbs_No);
	}

	@Override
	public String pageNumber(int tpage, int bc_Bbs_No) throws SQLException {
		int totalRecord = bbs_CommentDAO.totalBbs_Comment(bc_Bbs_No);
		String page = new Paging().commentPageNumber(tpage,totalRecord,"commentList", "");
		return page;
	}


}
