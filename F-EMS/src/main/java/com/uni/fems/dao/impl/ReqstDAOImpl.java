package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.ReqstDAO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;


/**
 * <pre>
 * 수강 신청 완료 목록 조회, 추가,삭제하는 DAOImpl
 * </pre>
 * @author KJH
 * @since 2017. 2. 20.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017. 2. 20.    KJH       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */


public class ReqstDAOImpl implements ReqstDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	// 수강신청 완료 목록
	@Override
	public List<Lctre_SearchVO> selectReqst(String re_Stdnt_No)
			throws SQLException {
		List<Lctre_SearchVO> selectReqst= (List<Lctre_SearchVO>) client.queryForList("selectReqst", re_Stdnt_No);
		return selectReqst;
	}
	
	// 수강신청
	@Override
	public void insertReqst(ReqstVO reqstVO) throws SQLException {
		client.update("insertReqst",reqstVO);
		
	}
	
	// 수강신청 취소
	@Override
	public void deleteReqst(ReqstVO reqstVO) throws SQLException {
		client.delete("deleteReqst",reqstVO);
	}
	
}
