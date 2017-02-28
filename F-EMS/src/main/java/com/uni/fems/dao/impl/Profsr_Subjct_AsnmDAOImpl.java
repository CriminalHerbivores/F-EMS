package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Profsr_Subjct_AsnmDAO;
import com.uni.fems.dto.Profsr_Subjct_AsnmVO;

public class Profsr_Subjct_AsnmDAOImpl implements Profsr_Subjct_AsnmDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public void insertProfsr_Subjct_Asnm(Profsr_Subjct_AsnmVO asnmVO)
			throws SQLException {
		client.update("insertProfsr_Subjct_Asnm",asnmVO);
	}
	@Override
	public void updateProfsr_Subjct_Asnm(Profsr_Subjct_AsnmVO asnmVO)
			throws SQLException {
		client.update("updateProfsr_Subjct_Asnm",asnmVO);
	}
	@Override
	public List<Profsr_Subjct_AsnmVO> selectProfsr_Subjct_Asnm(
			Profsr_Subjct_AsnmVO asnmVO) throws SQLException {
		List<Profsr_Subjct_AsnmVO> list = client.queryForList("selectProfsr_Subjct_Asnm");
		return list;
	}
}
