package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.ReqstDAO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.UserSubjctVO;


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
 * 2017. 3. 08.    KJS       추가작성
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
		client.insert("insertReqst",reqstVO);
	}
	
	// 수강신청 취소
	@Override
	public void deleteReqst(ReqstVO reqstVO) throws SQLException {
		client.delete("deleteReqst",reqstVO);
	}

	// 한 학생의 개설강의중 수강신청한 학점의 합계
	@Override
	public int getSumReqst(ReqstVO reqstVO) throws SQLException {
		int sum= (int) client.queryForObject("getSumReqst",reqstVO);
		return sum;
	}
	
	//----------------------------------------------------------------------------------
	
	// 한 개설강의의 강의실 수용가능 인원수
	@Override
	public int acceptNumOfStdnt(String lc_Lctre_No) throws SQLException {
		int acceptNumOfStdnt=(Integer) client.queryForObject(lc_Lctre_No);
		return acceptNumOfStdnt;
	}
	
	// 한 과목을 수강중인 학생의 인원수
	@Override
	public int stdntNumOfLctre(String re_Lctre_No) throws SQLException {
		int stdntNumOfLctre=(Integer) client.queryForObject(re_Lctre_No);
		return stdntNumOfLctre;
	}
	
	// 한 과목의 수강중인 인원수 한명 변동
	@Override
	public void setNumOfStdnt(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		client.update("setNumOfStdnt",lctre_SearchVO);
	}	
	
	//----------------------------------------------------------------------------------
	
	@Override
	public List<Lctre_SearchVO> selectEvl_Scope(Lctre_SearchVO lctre_Search, int tpage, int totalRecord) throws SQLException {
		Paging p = new Paging();
		
		int[] rows = p.row(tpage, totalRecord);
		
		List<Lctre_SearchVO> lctre_SearchList = null;
		lctre_SearchList = client.queryForList("selectEvl_Scope",lctre_Search,rows[1], rows[0]);	
		return lctre_SearchList;
	}
	
	@Override	
	public int totalEvl_Scope(Lctre_SearchVO lctre_Search) throws SQLException{
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalEvl_Scope",lctre_Search);
		return total_pages;
	}
	
	@Override  
	public Lctre_SearchVO getEvl_Scope(Lctre_SearchVO lctre_Search) throws SQLException {
		System.out.println("Re_Stdnt_No : "+lctre_Search.getRe_Stdnt_No());
		System.out.println("Re_Lctre_No : "+lctre_Search.getRe_Lctre_No());
		Lctre_SearchVO lctre_SearchVO = null;
		lctre_SearchVO = (Lctre_SearchVO) client.queryForObject("getEvl_Scope", lctre_Search);
		return lctre_SearchVO;
	}
	
}
