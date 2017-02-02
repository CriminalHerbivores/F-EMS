package com.uni.fems.dao.impl;


import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SklstfDAO;
import com.uni.fems.dto.SklstfVO;

public class SklstfDAOImpl implements SklstfDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public SklstfVO getSklstf(String stf_Sklstf_No) throws SQLException {
		System.out.println("1:stf_Sklstf_No : "+stf_Sklstf_No);
		SklstfVO sklstfVo = (SklstfVO) client.queryForObject("getSklstf", stf_Sklstf_No);
		System.out.println("2-stf_Sklstf_No : "+stf_Sklstf_No);
		return sklstfVo;
	}
	@Override
	public void updateSklstf(SklstfVO sklstfVo) throws SQLException {
		client.update("updateSklstf", sklstfVo);
	}
	
}
