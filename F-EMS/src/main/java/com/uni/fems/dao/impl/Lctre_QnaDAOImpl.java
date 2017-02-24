package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_QnaDAO;
import com.uni.fems.dto.Lctre_QnaVO;
import com.uni.fems.dto.Lctre_Qna_GntVO;

/**
 * <pre>
 * 강의 질의응답 테이블의 CRUD를 위한 DAOImple
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
public class Lctre_QnaDAOImpl implements Lctre_QnaDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<Lctre_QnaVO> listAllLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt, int tpage, int totalRecord) throws SQLException {
		System.out.println("list lctre_Qna_Gnt : "+lctre_Qna_Gnt);
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<Lctre_QnaVO> listAllLctre_Qna = client.queryForList("listAllLctre_Qna",lctre_Qna_Gnt, rows[1], rows[0]);
		return listAllLctre_Qna;
	}

	@Override
	public int totalLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException{
		System.out.println("total lctre_Qna_Gnt : "+lctre_Qna_Gnt);
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalLctre_Qna",lctre_Qna_Gnt);
		return total_pages;
	}

	@Override
	public Lctre_QnaVO getLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		Lctre_QnaVO result = (Lctre_QnaVO)client.queryForObject("getLctre_Qna", lctre_Qna_Gnt);
		return result;
	}

	@Override
	public int insertLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt)
			throws SQLException {
		int result = client.update("insertLctre_Qna", lctre_Qna_Gnt);
		return result;
	}

	@Override
	public int updateLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		int result = client.update("updateLctre_Qna", lctre_Qna_Gnt);
		return result;
	}
	
	@Override
	public int updateLctre_Qna_Reply(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		int result = client.update("updateLctre_Qna_Reply", lctre_Qna_Gnt);
		return result;
	}

	@Override
	public int countLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		client.update("countLctre_Qna",lctre_Qna_Gnt);
		return 0;
	}

	@Override
	public int deleteLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		int result = client.update("deleteLctre_Qna", lctre_Qna_Gnt);
		return result;
	}

	
}
