package com.uni.fems.dao;


import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;

public interface Notice_BbsDAO {
	
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No) throws SQLException; // 공지 게시판 리스트
	
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException; //게시판 vo클래스 하나 가져오기
	
	public int insertNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException; // 공지게시판 insert
	
	public int maxNotice_No() throws SQLException; //공지게시판 Max NO값 가져오기
	
	
	
	//////////////////////////////////// 관리자 ///////////////////////////////////////////////
	
	public List<Notice_BbsVO> listAllNotice_Bbs(SearchVO searchVO, int tpage, int totalRecord) throws SQLException;
	
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException;
	
	public int deleteNotice_Bbs(int nb_Bbs_No) throws SQLException;
	
	public int countNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException;
	
	public int totalNotice_Bbs() throws SQLException;
	


}
