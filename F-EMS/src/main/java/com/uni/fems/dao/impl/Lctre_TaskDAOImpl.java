package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_TaskDAO;
import com.uni.fems.dto.Lctre_TaskVO;
import com.uni.fems.dto.Lctre_Task_GntVO;

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
public class Lctre_TaskDAOImpl implements Lctre_TaskDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<Lctre_TaskVO> listAllLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt, int tpage, int totalRecord) throws SQLException {
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<Lctre_TaskVO> listAllLctre_Task = client.queryForList("listAllLctre_Task",lctre_Task_Gnt, rows[1], rows[0]);
		return listAllLctre_Task;
	}

	@Override
	public int totalLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException{
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalLctre_Task",lctre_Task_Gnt);
		return total_pages;
	}

	@Override
	public Lctre_TaskVO getLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException {
		Lctre_TaskVO result = (Lctre_TaskVO)client.queryForObject("getLctre_Task", lctre_Task_Gnt);
		return result;
	}

	@Override
	public int insertLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt)
			throws SQLException {
		int result = client.update("insertLctre_Task", lctre_Task_Gnt);
		return result;
	}

	@Override
	public int updateLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException {
		int result = client.update("updateLctre_Task", lctre_Task_Gnt);
		return result;
	}

	@Override
	public int deleteLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException {
		int result = client.update("deleteLctre_Task", lctre_Task_Gnt);
		return result;
	}

	
}
