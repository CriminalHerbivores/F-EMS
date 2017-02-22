package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Bbs_GntDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Bbs_GntVO;
import com.uni.fems.dto.Bbs_List_GntVO;

/**
 * <pre>
 * Bbs_GntDAO 인터페이스를 상속받아 활용하는 클래스
 * </pre>
 * @author KJS
 * @since 2017.02.21
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.21     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Bbs_GntDAOImpl implements Bbs_GntDAO{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<Bbs_GntVO> listBbs_Gnt(Bbs_List_GntVO bbs_list_gnt)
			throws SQLException {
		List<Bbs_GntVO> listBbs_Gnt = client.queryForList("listAllBbs_Gnt",bbs_list_gnt);
		return listBbs_Gnt;
	}
	@Override
	public Bbs_GntVO getBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		Bbs_GntVO result = (Bbs_GntVO)client.queryForObject("getBbs_Gnt", bbs_list_gnt);
		return result;
	}
	@Override
	public int insertBbs_Gnt(Bbs_List_GntVO bbs_list_gnt)
			throws SQLException {
		int result = client.update("insertBbs_Gnt", bbs_list_gnt);
		return result;
		
	}
	@Override
	public List<Bbs_GntVO> listAllBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, int tpage, int totalRecord) throws SQLException {
		 
		Paging p = new Paging();
	

		int[] rows = p.row(tpage, totalRecord);
		System.out.println(" rows[1], rows[0] : "+ rows[1]+rows[0]);
		List<Bbs_GntVO> listAllBbs_Gnt = client.queryForList("listAllBbs_Gnt",bbs_list_gnt, rows[1], rows[0]);
		return listAllBbs_Gnt;
	}

	@Override
	public int totalBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException{
		int total_pages = 0;
		
		total_pages = (Integer) client.queryForObject("totalBbs_Gnt",bbs_list_gnt);
		return total_pages;
	}

	@Override
	public int updateBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		int result = client.update("updateBbs_Gnt", bbs_list_gnt);
		return result;
	}
	@Override
	public int deleteBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		int result = client.update("deleteBbs_Gnt", bbs_list_gnt);
		return result;
	}

	@Override
	public int countBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		client.update("countBbs_Gnt",bbs_list_gnt);
		return 0;
	}

	@Override
	public int maxNotice_No(String table_nm) throws SQLException {
		int result = (Integer) client.queryForObject("maxBbs_Gnt", table_nm);
		return result;
	}
	
	


	
}
