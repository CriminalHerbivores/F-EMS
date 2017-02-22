package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Bbs_Comment_GntDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Bbs_Comment_GntVO;
import com.uni.fems.dto.Bbs_List_Comment_GntVO;
import com.uni.fems.dto.Bbs_List_GntVO;

/**
 * <pre>
 * 공지게시판 댓글 CRUD를 위한 DAOImpl
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

public class Bbs_Comment_GntDAOImpl implements Bbs_Comment_GntDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public List<Bbs_Comment_GntVO> listAllBbs_Comment_Gnt(int tpage, int totalRecord, Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<Bbs_Comment_GntVO> listAllBbs_Comment_Gnt = client.queryForList("listAllBbs_Gnt",bbs_List_Comment_Gnt,rows[1],rows[0]);
		return listAllBbs_Comment_Gnt;
	}

	@Override
	public List<Bbs_Comment_GntVO> getBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt, int tpage, int totalRecord)throws SQLException {
		System.out.println("bbs_List_Comment_Gnt : "+bbs_List_Comment_Gnt);
		Paging p = new Paging();
		int[] rows = p.row(tpage,totalRecord);
		List<Bbs_Comment_GntVO> getBbs_Comment_Gnt = client.queryForList("getBbs_Comment_Gnt",bbs_List_Comment_Gnt,rows[1],rows[0]); 
		return getBbs_Comment_Gnt;
	}


	@Override
	public int insertBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		return client.update("insertBbs_Comment_Gnt", bbs_List_Comment_Gnt);
	}

	@Override
	public int updateBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		return client.update("updateBbs_Comment_Gnt", bbs_List_Comment_Gnt);
	}

	@Override
	public int deleteBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		return client.update("deleteBbs_Comment_Gnt", bbs_List_Comment_Gnt);
	}

	@Override
	public int deleteAllBbs_Comment_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		return client.update("deleteAllBbs_Comment_Gnt", bbs_list_gnt);
	}

	@Override
	public int totalBbs_Comment_Gnt(Bbs_List_Comment_GntVO bbs_List_Comment_Gnt) throws SQLException {
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalBbs_Comment_Gnt",bbs_List_Comment_Gnt);
		return total_pages;
	}



}
