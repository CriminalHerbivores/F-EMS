package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.dto.request.PageRequest;

public class SknrgsDAOImpl implements SknrgsDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
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
}
