package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.EventDAO;
import com.uni.fems.dto.EventVO;
import com.uni.fems.service.EventService;

public class EventServiceImpl implements EventService {
	
	private EventDAO eventDAO;
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
	
	@Override
	public List<EventVO> selectEventList() throws SQLException {
		List<EventVO> list = eventDAO.selectEventList();
		return list;
	}

	@Override
	public EventVO selectEvent(String evt_Nm) throws SQLException {
		EventVO vo = eventDAO.selectEvent(evt_Nm);
		return vo;
	}

	@Override
	public void updateEvent(EventVO eventVO) throws SQLException {
		eventDAO.updateEvent(eventVO);
	}
}
