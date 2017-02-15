package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Bbs_CommentDAO;
import com.uni.fems.dao.Bbs_FlpthDAO;
import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Notice_BbsService;

/**
 * <pre>
 * 
 * </pre>
 * @author 송선호
 * @since 2017.02.01
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.01     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Notice_BbsServiceImpl implements Notice_BbsService{
	
	private Notice_BbsDAO notice_bbsDAO;
	private Bbs_FlpthDAO bbs_FlpthDAO;
	private Bbs_CommentDAO bbs_CommentDAO;
	

	public void setBbs_CommentDAO(Bbs_CommentDAO bbs_CommentDAO) {
		this.bbs_CommentDAO = bbs_CommentDAO;
	}
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
	public void insertNotice_Bbs(Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		
		notice_bbsDAO.insertNotice_Bbs(notice_BbsVO);
		int maxNo = notice_bbsDAO.maxNotice_No();
		notice_BbsVO.setNb_Bbs_No(maxNo);
		bbs_FlpthVO.setBf_Bbs_No_No(notice_BbsVO.getNb_Bbs_No());
		
		if(!(bbs_FlpthVO.getBf_File_Nm()==null))
		bbs_FlpthDAO.insertBbs_Flpth(bbs_FlpthVO);
	}
	@Override
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage, SearchVO searchVO) throws SQLException {
		int totalRecord = notice_bbsDAO.totalNotice_Bbs();
		return notice_bbsDAO.listAllNotice_Bbs(searchVO,tpage, totalRecord);
		
	}
	@Override
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO, int bf_No,Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		 notice_bbsDAO.updateNotice_Bbs(notice_BbsVO);
		 bbs_FlpthDAO.deleteBbs_Flpth(bf_No); // 수정할 때 먼저 삭제하고
		 
		 if(!(bbs_FlpthVO.getBf_File_Nm()==null)) //파일이 있을 때(null)이 아니면
		 bbs_FlpthDAO.insertBbs_Flpth(bbs_FlpthVO); // 생성
		return 0;
	}
	@Override
	public int deleteNotice_Bbs(int nb_Bbs_No, Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		 notice_bbsDAO.deleteNotice_Bbs(nb_Bbs_No);
		 bbs_FlpthDAO.deleteBbs_Flpth_bbs(bbs_FlpthVO);
		 bbs_CommentDAO.deleteAllBbs_Comment(nb_Bbs_No);
		return 0;
	}
	@Override
	public String pageNumber(int tpage,SearchVO searchVO) throws SQLException {
		int totalRecord = notice_bbsDAO.totalNotice_Bbs();
		String page = new Paging().pageNumber(tpage,totalRecord,"noticeList", "&key="+searchVO.getKey()+"&value="+searchVO.getValue());
		return page;
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
	@Override
	public List<Bbs_FlpthVO> getBbs_Flpth(Bbs_FlpthVO bbs_flpthVO)
			throws SQLException {
		return bbs_FlpthDAO.getBbs_Flpth(bbs_flpthVO);
	}
	

	
	

	


	


}

