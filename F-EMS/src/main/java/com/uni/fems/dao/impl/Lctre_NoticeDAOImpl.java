package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_NoticeDAO;
import com.uni.fems.dto.Lctre_NoticeVO;
import com.uni.fems.dto.Lctre_Notice_GntVO;

/**
 * <pre>
 * 강의 공지 테이블의 CRUD를 위한 DAOImple
 * </pre>
 * @author KJS
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                   수정내용
 * --------     --------    ----------------------
 * 2017.02.24     KJS                   최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Lctre_NoticeDAOImpl implements Lctre_NoticeDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<Lctre_NoticeVO> listAllLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt, int tpage, int totalRecord) throws SQLException {
		System.out.println("list lctre_Notice_Gnt : "+lctre_Notice_Gnt);
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<Lctre_NoticeVO> listAllLctre_Notice = client.queryForList("listAllLctre_Notice",lctre_Notice_Gnt, rows[1], rows[0]);
		return listAllLctre_Notice;
	}

	@Override
	public int totalLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException{
		System.out.println("total lctre_Notice_Gnt : "+lctre_Notice_Gnt);
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalLctre_Notice",lctre_Notice_Gnt);
		return total_pages;
	}

	@Override
	public Lctre_NoticeVO getLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		Lctre_NoticeVO result = (Lctre_NoticeVO)client.queryForObject("getLctre_Notice", lctre_Notice_Gnt);
		return result;
	}

	@Override
	public int insertLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt)
			throws SQLException {
		int result = client.update("insertLctre_Notice", lctre_Notice_Gnt);
		return result;
	}

	@Override
	public int updateLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		int result = client.update("updateLctre_Notice", lctre_Notice_Gnt);
		return result;
	}

	@Override
	public int countLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		client.update("countLctre_Notice",lctre_Notice_Gnt);
		return 0;
	}

	@Override
	public int deleteLctre_Notice(Lctre_Notice_GntVO lctre_Notice_Gnt) throws SQLException {
		int result = client.update("deleteLctre_Notice", lctre_Notice_Gnt);
		return result;
	}

	
}
