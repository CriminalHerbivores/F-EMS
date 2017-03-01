package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_Video_ProfsrDAO;
import com.uni.fems.dao.Lctre_Video_StdntDAO;
import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;
import com.uni.fems.dto.Lctre_Watch_Video_GntVO;

/**
 * <pre>
 * 강의 과제 테이블의 CRUD를 위한 DAOImple
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
public class Lctre_Video_StdntDAOImpl implements Lctre_Video_StdntDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}

	@Override
	public List<Lctre_Watch_Video_GntVO> listAllLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt, int tpage, int totalRecord) throws SQLException {
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<Lctre_Watch_Video_GntVO> listAllLctre_Video = client.queryForList("listAllLctre_Video_Stdnt",lctre_Watch_Video_Gnt, rows[1], rows[0]);
		return listAllLctre_Video;
	}

	@Override
	public int totalLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException{
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalLctre_Video_Stdntss",lctre_Watch_Video_Gnt);
		return total_pages;
	}

	@Override
	public Lctre_Watch_Video_GntVO getLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException {
		Lctre_Watch_Video_GntVO result = (Lctre_Watch_Video_GntVO)client.queryForObject("getLctre_Video_Stdnt", lctre_Watch_Video_Gnt);
		return result;
	}
	
	@Override
	public int insertLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException {
		int result = client.update("insertLctre_Video_Stdnt", lctre_Watch_Video_Gnt);
		return result;
	}

	@Override
	public int updateLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException {
		int result = client.update("updateLctre_Video_Stdnt", lctre_Watch_Video_Gnt);
		return result;
	}
}
