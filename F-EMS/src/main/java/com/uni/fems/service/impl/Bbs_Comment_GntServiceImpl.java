package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Bbs_Comment_GntDAO;
import com.uni.fems.dto.Bbs_Comment_GntVO;
import com.uni.fems.dto.Bbs_List_Comment_GntVO;
import com.uni.fems.service.Bbs_Comment_GntService;

/**
 * <pre>
 * 공지게시판 댓글 CRUD를 위한 ServiceImpl
 * </pre>
 * @author KJS
 * @since 2017.02.21
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.21     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Bbs_Comment_GntServiceImpl implements Bbs_Comment_GntService{

	private Bbs_Comment_GntDAO bbs_Comment_GntDAO;
	
	
	public void setBbs_Comment_GntDAO(Bbs_Comment_GntDAO bbs_Comment_GntDAO) {
		this.bbs_Comment_GntDAO = bbs_Comment_GntDAO;
	}

	@Override
	public List<Bbs_Comment_GntVO> listAllBbs_Comment_Gnt(int tpage, Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		
		int totalRecord = bbs_Comment_GntDAO.totalBbs_Comment_Gnt(bbs_List_Comment_Gnt);
		return bbs_Comment_GntDAO.listAllBbs_Comment_Gnt(tpage, totalRecord, bbs_List_Comment_Gnt);
		
	}

	@Override
	public List<Bbs_Comment_GntVO> getBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt, int tpage) throws SQLException{
		System.out.println("service bbs_List_Comment_Gnt : "+bbs_List_Comment_Gnt);
		int totalRecord = bbs_Comment_GntDAO.totalBbs_Comment_Gnt(bbs_List_Comment_Gnt);
		return bbs_Comment_GntDAO.getBbs_Comment_Gnt(bbs_List_Comment_Gnt, tpage, totalRecord);
	}
	
	@Override
	public int insertBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		return bbs_Comment_GntDAO.insertBbs_Comment_Gnt(bbs_List_Comment_Gnt);
	}

	@Override
	public int updateBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		return bbs_Comment_GntDAO.updateBbs_Comment_Gnt(bbs_List_Comment_Gnt);
	}

	@Override
	public int deleteBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		return bbs_Comment_GntDAO.deleteBbs_Comment_Gnt(bbs_List_Comment_Gnt);
	}

	@Override
	public int totalBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		return bbs_Comment_GntDAO.totalBbs_Comment_Gnt(bbs_List_Comment_Gnt);
	}

	@Override
	public String pageNumber(int cpage, Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		int totalRecord = bbs_Comment_GntDAO.totalBbs_Comment_Gnt(bbs_List_Comment_Gnt);
		String page = new Paging().commentPageNumber(cpage,totalRecord,"detailNotice", "");
		return page;
	}


}
