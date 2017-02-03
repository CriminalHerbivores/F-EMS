package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Bbs_FlpthDAO;
import com.uni.fems.dto.Bbs_FlpthVO;

public class Bbs_FlpthDAOImpl implements Bbs_FlpthDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public Bbs_FlpthVO getBbs_Flpth(int bf_No) throws SQLException {
			Bbs_FlpthVO result = (Bbs_FlpthVO)client.queryForObject("getBbs_Flpth", bf_No);
		return result;
	}
	@Override
	public int insertBbs_Flpth(Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		int result = client.update("insertBbs_Flpth", bbs_FlpthVO);
		return result;
	}
	@Override
	public int updateBbs_Flpth(Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		int result = client.update("updateBbs_Flpth", bbs_FlpthVO);
		return result;
	}
	@Override
	public int deleteBbs_Flpth(int bf_No) throws SQLException {
		int result = client.update("deleteBbs_Flpth",bf_No);
		return result;
	}
	
}
