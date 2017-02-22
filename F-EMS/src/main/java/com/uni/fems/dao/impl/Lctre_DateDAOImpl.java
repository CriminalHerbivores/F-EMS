package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_DateDAO;
import com.uni.fems.dto.Lctre_DateVO;
import com.uni.fems.dto.Lctre_Date_GntVO;

/**
 * <pre>
 * 강의 자료 테이블의 CRUD를 위한 DAOImple
 * </pre>
 * @author KJS
 * @since 2017.02.22
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                   수정내용
 * --------     --------    ----------------------
 * 2017.02.23     KJS                   최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Lctre_DateDAOImpl implements Lctre_DateDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<Lctre_DateVO> listAllLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt, int tpage, int totalRecord) throws SQLException {
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<Lctre_DateVO> listAllLctre_Date = client.queryForList("listAllLctre_Date",lctre_Date_Gnt, rows[1], rows[0]);
		return listAllLctre_Date;
	}

	@Override
	public int totalLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException{
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalLctre_Date",lctre_Date_Gnt);
		return total_pages;
	}

	@Override
	public Lctre_DateVO getLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		Lctre_DateVO result = (Lctre_DateVO)client.queryForObject("getLctre_Date", lctre_Date_Gnt);
		return result;
	}

	@Override
	public int insertLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt)
			throws SQLException {
		int result = client.update("insertLctre_Date", lctre_Date_Gnt);
		return result;
	}

	@Override
	public int updateLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		int result = client.update("updateLctre_Date", lctre_Date_Gnt);
		return result;
	}

	@Override
	public int countLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		client.update("countLctre_Date",lctre_Date_Gnt);
		return 0;
	}

	@Override
	public int deleteLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		int result = client.update("deleteLctre_Date", lctre_Date_Gnt);
		return result;
	}

	
}
