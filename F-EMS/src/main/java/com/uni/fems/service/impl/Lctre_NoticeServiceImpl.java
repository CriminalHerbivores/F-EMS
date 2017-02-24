package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_NoticeDAO;
import com.uni.fems.dto.Lctre_NoticeVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;
import com.uni.fems.service.Lctre_NoticeService;

/**
 * <pre>
 * 강의 공지 게시판을 사용하기 위한 서비스
 * </pre>
 * @author KJS
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     kjs                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Lctre_NoticeServiceImpl implements Lctre_NoticeService{
	
	private Lctre_NoticeDAO lctre_NoticeDAO;
	public void setLctre_NoticeDAO(Lctre_NoticeDAO lctre_NoticeDAO) {
		this.lctre_NoticeDAO = lctre_NoticeDAO;
	}
	
	@Override
	public List<Lctre_NoticeVO> listAllLctre_Notice(int tpage, Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		int totalRecord = lctre_NoticeDAO.totalLctre_Notice(lctre_Notice_Gnt);
		return lctre_NoticeDAO.listAllLctre_Notice(lctre_Notice_Gnt, tpage, totalRecord);
		
	}

	@Override
	public String pageNumber(int tpage,Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		int totalRecord = lctre_NoticeDAO.totalLctre_Notice(lctre_Notice_Gnt);
		String page = new Paging().pageNumber(tpage,totalRecord,"NoticeList", "&table_Nm="+lctre_Notice_Gnt.getTable_Nm());
		return page;
	}

	@Override
	public Lctre_NoticeVO getLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		return lctre_NoticeDAO.getLctre_Notice(lctre_Notice_Gnt);
	}

	@Override
	public void insertLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		lctre_NoticeDAO.insertLctre_Notice(lctre_Notice_Gnt);
	}

	@Override
	public int updateLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		return lctre_NoticeDAO.updateLctre_Notice(lctre_Notice_Gnt);
	}

	@Override
	public int countLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		return lctre_NoticeDAO.countLctre_Notice(lctre_Notice_Gnt);
	}

	@Override
	public int deleteLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		return lctre_NoticeDAO.deleteLctre_Notice(lctre_Notice_Gnt);
	}


}

