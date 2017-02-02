package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dto.Notice_BbsVO;

public interface Notice_BbsDAO {
	
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No) throws SQLException; // 공지 게시판 리스트
	
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException; //게시판 vo클래스 하나 가져오기
	
	public int insertNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException; // 공지게시판 insert
	
	
	
	//////////////////////////////////// 관리자 ///////////////////////////////////////////////
	public List<Notice_BbsVO> listAllNotice_Bbs1() throws SQLException;
	
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage) throws SQLException;
	
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException;
	
	public int deleteNotice_Bbs(int nb_Bbs_No) throws SQLException;
	
	public String pageNumber(int tpage) throws SQLException;
	
	

}
