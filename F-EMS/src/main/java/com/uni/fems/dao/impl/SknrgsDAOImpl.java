package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;

public class SknrgsDAOImpl implements SknrgsDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	//직원 부분에서의 학적 관리
	@Override
	public List<SknrgsViewVO> listAllSknrgs(SknrgsViewVO sknrgsView, int tpage, int totalRecord) throws SQLException {
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<SknrgsViewVO> listAllLctre_Date = client.queryForList("listAllSknrgs",sknrgsView, rows[1], rows[0]);
		return listAllLctre_Date;
	}
	@Override
	public int totalSknrgs(SknrgsViewVO sknrgsView) throws SQLException{
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalSknrgs",sknrgsView);
		return total_pages;
	}
	
	
	
//	직원의 학적 관리
	@Override
	public List<SknrgsViewVO> getSknrgsType(String skn_Typen) throws SQLException {
		ArrayList<SknrgsViewVO> list = (ArrayList<SknrgsViewVO>) client.queryForList("getSknrgsType",skn_Typen);
		return list;
	}

	@Override
	public String getSknrgs(String skn_Stdnt_No) throws SQLException {
		String type = (String) client.queryForObject("getSknrgs",skn_Stdnt_No);
		return type;
	}
	
	@Override
	public List<SknrgsVO> getStudentSknrgs(PageRequest p) throws SQLException {
		Paging paging = new Paging();
		int[] rows = paging.row(p.getTpage(), p.getTotalRecord());
		List<SknrgsVO> sknrgs = new ArrayList<SknrgsVO>();
		sknrgs = (List<SknrgsVO>) client.queryForList("getStudentSknrgs",p.getKey(), rows[1], rows[0]);
		return sknrgs;
	}

	@Override
	public int totalRecord(PageRequest p) throws SQLException {
		int totalRecord = 0;
		totalRecord = (Integer) client.queryForObject("countStudentSknrgs", p.getKey());
		return totalRecord;
	}

	@Override
	public void writeSknrgs(SknrgsVO sknrgs) throws SQLException {
		client.update("insertStudentSknrgs",sknrgs);
	}
	
	@Override
	public void updateUseynSknrgs(SknrgsVO sknrgs) throws SQLException {
		System.out.println("sknrgs : "+sknrgs);
		client.update("updateUseynSknrgs", sknrgs);
	}
}