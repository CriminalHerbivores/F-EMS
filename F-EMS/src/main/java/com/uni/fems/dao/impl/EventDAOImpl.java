package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.EventDAO;
import com.uni.fems.dto.EventVO;

public class EventDAOImpl implements EventDAO{
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<EventVO> selectEventList() throws SQLException {
		List<EventVO> list = client.queryForList("selectEventList");
		return list;
	}
	
	@Override
	public EventVO selectEvent(String evt_Nm) throws SQLException {
		EventVO vo = (EventVO) client.queryForObject("selectEvent",evt_Nm);
		return vo;
	}

	@Override
	public void updateEvent(EventVO eventVO) throws SQLException {
		client.update("updateEvent",eventVO);
	}

}
