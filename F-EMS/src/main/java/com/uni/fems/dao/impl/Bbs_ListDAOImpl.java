package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.Bbs_ListDAO;
import com.uni.fems.dto.Bbs_AtrtyVO;
import com.uni.fems.dto.Bbs_CommentVO;
import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.Bbs_List_AtrtyVO;

/**
 * <pre>
 * 게시판 리스트와 관계 CRUD를 위한 DAOImple
 * </pre>
 * @author 김진수
 * @since 2017.02.18
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                   수정내용
 * --------     --------    ----------------------
 * 2017.02.18     김진수                   최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Bbs_ListDAOImpl implements Bbs_ListDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<Bbs_List_AtrtyVO> listAllBbs_List_Atrty(int tpage, int totalRecord, String key) throws SQLException {
		Paging p = new Paging();
		key = p.key(key);
		int[] rows = p.row(tpage, totalRecord);
		List<Bbs_List_AtrtyVO> listBbs_List_Atrty = (ArrayList<Bbs_List_AtrtyVO>)client.queryForList("listAllBbs_List_Atrty",key,rows[1],rows[0]);
		return listBbs_List_Atrty;
	}
	@Override
	public int totalBbs_List_Atrty(String bl_Bbs_Nm) throws SQLException {
		int total_pages = 0;
		if (bl_Bbs_Nm.equals("")) {
			bl_Bbs_Nm = "%";
		}
		total_pages = (Integer) client.queryForObject("totalBbs_List_Atrty",bl_Bbs_Nm);
		return total_pages;
	}
	@Override
	public Bbs_List_AtrtyVO getBbs_List_Atrty(int bl_Bbs_No)throws SQLException {
		
		Bbs_List_AtrtyVO bbs_List_AtrtyVO = (Bbs_List_AtrtyVO) client.queryForObject("getBbs_List_Atrty", bl_Bbs_No); 
		System.out.println("bbs_List_AtrtyVO : "+bbs_List_AtrtyVO);
		return bbs_List_AtrtyVO;
	}
	@Override
	public int updateBbs_Atrty(Bbs_AtrtyVO bbs_AtrtyVO) throws SQLException {
		return client.update("updateBbs_Atrty", bbs_AtrtyVO);
	}
	@Override
	public int updateBbs_List(Bbs_ListVO bbs_ListVO) throws SQLException {
		return client.update("updateBbs_List", bbs_ListVO);
	}

	@Override
	public int insertBbs_List_Atrty(Bbs_List_AtrtyVO bbs_List_AtrtyVO)
			throws SQLException {
		System.out.println("bbs_List_AtrtyVO : "+bbs_List_AtrtyVO);
		client.update("insertBbs_List_Atrty1", bbs_List_AtrtyVO);
		return client.update("insertBbs_List_Atrty2", bbs_List_AtrtyVO);
	}
	
	@Override
	public int insertBbs_Table(String name)
			throws SQLException {
		return client.update("insertBbs_Table", name);
	}
	@Override
	public int insertComment_Table(String name)
			throws SQLException {
		return client.update("insertComment_Table", name);
	}
	
	
}
