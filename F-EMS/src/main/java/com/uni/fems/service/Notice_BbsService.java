package com.uni.fems.service;


import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Notice_BbsVO;

public interface Notice_BbsService {
	
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No) throws SQLException; // 공지 게시판 리스트
	
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException; //게시판 vo클래스 하나 가져오기
	
	public void insertNotice_Bbs(Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO) throws SQLException; // 공지게시판 insert
	
	
	
	//////////////////////////////////// 관리자 ///////////////////////////////////////////////
	public List<Notice_BbsVO> listAllNotice_Bbs1() throws SQLException;
	
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage) throws SQLException;
	
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO, int bf_No) throws SQLException;
	
	public int deleteNotice_Bbs(int nb_Bbs_No, Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	public String pageNumber(int tpage,String key) throws SQLException;
	
	public int countNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException;
	
	
	/*public Bbs_FlpthVO getBbs_Flpth(int bf_No) throws SQLException;*/
	
	

}
