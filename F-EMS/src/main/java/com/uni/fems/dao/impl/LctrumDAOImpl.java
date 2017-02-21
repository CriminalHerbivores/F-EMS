package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.LctrumDAO;
import com.uni.fems.dto.LctrumVO;

public class LctrumDAOImpl implements LctrumDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	// 강의실 등록
	@Override
	public void insertLctrum(LctrumVO lctrumVO) throws SQLException {
			client.update("insertLctrum",lctrumVO);
	}
	
	// 강의실 수정
	@Override
	public void updateLctrum(LctrumVO lctrumVO) throws SQLException {
		client.update("insertLctrum",lctrumVO);		
	}
	
	// 강의실 사용 안함 설정
	@Override
	public void deleteLctrum(String lr_Lctrum_No) throws SQLException {
		client.update("insertLctrum");		
	}
	
}
