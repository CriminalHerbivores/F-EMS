package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.service.Notice_BbsService;

public class Notice_BbsServiceImpl implements Notice_BbsService{
	
	private Notice_BbsDAO notice_bbsDAO;
	public void setNotice_BbsDAO(Notice_BbsDAO notice_bbsDAO) {
		this.notice_bbsDAO = notice_bbsDAO;
	}
	@Override
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No)
			throws SQLException {
		return notice_bbsDAO.listNotice_Bbs(nb_Sklstf_No);
	}
	@Override
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException {
		return notice_bbsDAO.getNotice_Bbs(nb_Bbs_No);
	}
	@Override
	public int insertNotice_Bbs(Notice_BbsVO notice_BbsVO)
			throws SQLException {
		return notice_bbsDAO.insertNotice_Bbs(notice_BbsVO);
	}
	@Override
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage) throws SQLException {
		return notice_bbsDAO.listAllNotice_Bbs(tpage);
	}
	@Override
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException {
		return notice_bbsDAO.updateNotice_Bbs(notice_BbsVO);
	}
	@Override
	public int deleteNotice_Bbs(int nb_Bbs_No) throws SQLException {
		return notice_bbsDAO.deleteNotice_Bbs(nb_Bbs_No);
	}
	@Override
	public String pageNumber(int tpage) throws SQLException {
		return notice_bbsDAO.pageNumber(tpage);
	}
	@Override
	public List<Notice_BbsVO> listAllNotice_Bbs1() throws SQLException {
		return notice_bbsDAO.listAllNotice_Bbs1();
	}
	@Override
	public int countNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException {
		return notice_bbsDAO.countNotice_Bbs(notice_BbsVO);
	}
	

	
	

	


	


}

