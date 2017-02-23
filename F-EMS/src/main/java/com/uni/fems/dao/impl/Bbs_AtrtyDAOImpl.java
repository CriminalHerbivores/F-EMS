package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Bbs_AtrtyDAO;
import com.uni.fems.dto.Bbs_AtrtyVO;

public class Bbs_AtrtyDAOImpl implements Bbs_AtrtyDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public Bbs_AtrtyVO getBBS_Atrty(int bbs_no) throws SQLException {
		Bbs_AtrtyVO result = (Bbs_AtrtyVO) client.queryForObject("getBBS_Atrty", bbs_no);
		return result;
	}
	
}
