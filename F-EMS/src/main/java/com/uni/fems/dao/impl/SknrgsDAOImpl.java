package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dto.SknrgsVO;

public class SknrgsDAOImpl implements SknrgsDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<SknrgsVO> getStudentSknrgs(String skn_Stdnt_No) throws SQLException {
		List<SknrgsVO> sknrgs = new ArrayList<SknrgsVO>();
		sknrgs = (List<SknrgsVO>) client.queryForObject("getStudentSknrgs",skn_Stdnt_No);
		return sknrgs;
	}
	
}
