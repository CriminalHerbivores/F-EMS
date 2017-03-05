package com.uni.fems.dao.impl;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapSession;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.request.PageRequest;

/**
 * <pre>
 * 강의DAO의 메서드를 구현하는 클래스
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * 2017.02.19      KJH            강의등록
 * 2017.02.20      KJH            강의수정
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class LctreDAOImpl implements LctreDAO {

	private SqlMapClient client;
	private static LctreDAOImpl instance = new LctreDAOImpl();
	
	private LctreDAOImpl() {}
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	public static LctreDAO getInstance() {
		return instance;
	}
	
	ArrayList<Lctre_SearchVO> listForComboLctre=null;
	
	// 한개의 강의로 강의상세(강의계획서) 조회
	@Override
	public Lctre_SearchVO getDetailLctre(int lc_Lctre_No) throws SQLException {
		Lctre_SearchVO lctre_SearchVO=(Lctre_SearchVO) client.queryForObject("getDetailLctre",lc_Lctre_No);
		return lctre_SearchVO;
	}
	
	
	// 현재 개설된 전체 강의 목록
	@Override
	public List<Lctre_SearchVO> openLctreList(SearchVO searchVO,int start,int counts) throws SQLException { //int tpage, 

		List<Lctre_SearchVO> openLctreList;
		openLctreList = client.queryForList("openLctreList", searchVO,start,counts);
		return openLctreList;
	}
	
	// 개설 강의 총 갯수
	@Override
	public int totalOpenLctre(SearchVO searchVO) throws SQLException{
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalOpenLctre",searchVO);
		return total_pages;
	}
	
	
	// 교수가 강의 등록 요청
	@Override
	public void insertLctre(LctreVO lctreVO) throws SQLException {
		client.update("insertLctre", lctreVO);
	}

	//강의번호 최대값 가져옴
	@Override
	public int selectMaxLc_Lctre_No() throws SQLException{

		int maxLtr_seq=0;
		maxLtr_seq=(Integer)client.queryForObject("selectMaxLc_Lctre_No",null);	
		return maxLtr_seq;
	}
	
	// 교수가 강의 수정
	@Override
	public void updateLctre(Lctre_SearchVO lctreVO) throws SQLException {
		client.update("updateLctre",lctreVO);
	}
	
	
	// 강의 삭제
	@Override
	public int deleteLctre(int lc_Lctre_No) throws SQLException {
		int result = (Integer)client.update("deleteLctre",lc_Lctre_No);
		return result;
	}
	
	// 개설 강의 검색 
	@Override
	public List<Lctre_SearchVO> selectLctre(Lctre_SearchVO lctre_SearchVO,
			int start, int count) throws SQLException {
		List<Lctre_SearchVO> list = client.queryForList("selectLctre",lctre_SearchVO, start,count);
		return list;
	}
	// 개설 강의 검색 개수
	@Override
	public int countLctre(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		int totalRecord = (int) client.queryForObject("countLctre",lctre_SearchVO);
		return totalRecord;
	}
	@Override
	public void allowLctre(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		client.update("allowLctre",lctre_SearchVO);
	}
	
	
}
