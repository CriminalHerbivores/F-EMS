package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_CommentVO;

public interface Bbs_CommentService {
	
	public List<Bbs_CommentVO> listAllBbs_Comment(int tpage) throws SQLException;
	
	public List<Bbs_CommentVO> getBbs_Comment(int bc_Bbs_No) throws SQLException;
	
	public int insertBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException;
	
	public int updateBbs_Comment(Bbs_CommentVO bbs_Comment) throws SQLException;
	
	public int deleteBbs_Comment(int bc_Comnt_No) throws SQLException;
	
	public int totalBbs_Comment() throws SQLException;
	
	public String pageNumber(int tpage,String key) throws SQLException;
	
		

}
