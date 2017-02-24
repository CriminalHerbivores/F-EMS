package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_QnaDAO;
import com.uni.fems.dto.Lctre_QnaVO;
import com.uni.fems.dto.Lctre_Qna_GntVO;
import com.uni.fems.service.Lctre_QnaService;

/**
 * <pre>
 * 강의 질의응답 게시판을 사용하기 위한 서비스
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

public class Lctre_QnaServiceImpl implements Lctre_QnaService{
	
	private Lctre_QnaDAO lctre_QnaDAO;
	public void setLctre_QnaDAO(Lctre_QnaDAO lctre_QnaDAO) {
		this.lctre_QnaDAO = lctre_QnaDAO;
	}
	
	@Override
	public List<Lctre_QnaVO> listAllLctre_Qna(int tpage, Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		int totalRecord = lctre_QnaDAO.totalLctre_Qna(lctre_Qna_Gnt);
		return lctre_QnaDAO.listAllLctre_Qna(lctre_Qna_Gnt, tpage, totalRecord);
		
	}

	@Override
	public String pageNumber(int tpage,Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		int totalRecord = lctre_QnaDAO.totalLctre_Qna(lctre_Qna_Gnt);
		String page = new Paging().pageNumber(tpage,totalRecord,"qnaList", "&table_Nm="+lctre_Qna_Gnt.getTable_Nm());
		return page;
	}

	@Override
	public Lctre_QnaVO getLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		return lctre_QnaDAO.getLctre_Qna(lctre_Qna_Gnt);
	}

	@Override
	public void insertLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		lctre_QnaDAO.insertLctre_Qna(lctre_Qna_Gnt);
	}

	@Override
	public int updateLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		return lctre_QnaDAO.updateLctre_Qna(lctre_Qna_Gnt);
	}
	
	@Override
	public int updateLctre_Qna_Reply(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		return lctre_QnaDAO.updateLctre_Qna_Reply(lctre_Qna_Gnt);
	}

	@Override
	public int countLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		return lctre_QnaDAO.countLctre_Qna(lctre_Qna_Gnt);
	}

	@Override
	public int deleteLctre_Qna(Lctre_Qna_GntVO lctre_Qna_Gnt) throws SQLException {
		return lctre_QnaDAO.deleteLctre_Qna(lctre_Qna_Gnt);
	}


}

