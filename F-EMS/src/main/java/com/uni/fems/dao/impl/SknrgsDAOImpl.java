package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SknrgsDAO;
import com.uni.fems.dto.SknrgsVO;

public class SknrgsDAOImpl implements SknrgsDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	static int view_rows = 5; 	// 페이지의 개수
	static int counts = 10;		// 한 페이지에 나타낼 상품의 개수
	
	@Override
	public SknrgsVO getStudentSknrgs(String skn_Stdnt_No) throws SQLException {
		SknrgsVO sknrgs = new SknrgsVO();
		sknrgs = (SknrgsVO) client.queryForObject("getStudentSknrgs",skn_Stdnt_No);
		return sknrgs;
	}
	
}
