package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Bbs_FlpthDAO;
import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.service.Notice_BbsService;

public class Notice_BbsServiceImpl implements Notice_BbsService{
	
	private Notice_BbsDAO notice_bbsDAO;
	private Bbs_FlpthDAO bbs_FlpthDAO;
	
	public void setBbs_FlpthDAO(Bbs_FlpthDAO bbs_FlpthDAO) {
		this.bbs_FlpthDAO = bbs_FlpthDAO;
	}
	public void setNotice_BbsDAO(Notice_BbsDAO notice_bbsDAO) {
		this.notice_bbsDAO = notice_bbsDAO;
	}
	/*@Override
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No)
			throws SQLException {
		return notice_bbsDAO.listNotice_Bbs(nb_Sklstf_No);
	}*/
	@Override
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException {
		return notice_bbsDAO.getNotice_Bbs(nb_Bbs_No);
	}
	@Override
	public int insertNotice_Bbs(Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		notice_bbsDAO.insertNotice_Bbs(notice_BbsVO);
		bbs_FlpthDAO.insertBbs_Flpth(bbs_FlpthVO);
		return 0;   
	}
	@Override
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage) throws SQLException {
		int totalRecord = notice_bbsDAO.totalNotice_Bbs();
		return notice_bbsDAO.listAllNotice_Bbs(tpage, totalRecord,"");
	}
	@Override
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		 notice_bbsDAO.updateNotice_Bbs(notice_BbsVO);
		 bbs_FlpthDAO.updateBbs_Flpth(bbs_FlpthVO);
		return 0;
	}
	@Override
	public int deleteNotice_Bbs(int nb_Bbs_No, int bf_No) throws SQLException {
		 notice_bbsDAO.deleteNotice_Bbs(nb_Bbs_No);
		 bbs_FlpthDAO.deleteBbs_Flpth(bf_No);
		return 0;
	}
	@Override
	public String pageNumber(int tpage,String key) throws SQLException {
		int totalRecord = notice_bbsDAO.totalNotice_Bbs();
		String page = new Paging().pageNumber(tpage,totalRecord,"noticeList", "&key="+key);
		return page;
	}
	@Override
	public List<Notice_BbsVO> listAllNotice_Bbs1() throws SQLException {
		return notice_bbsDAO.listAllNotice_Bbs1();
	}
	@Override
	public int countNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException {
		return notice_bbsDAO.countNotice_Bbs(notice_BbsVO);
	}
	@Override
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

	


	


}

