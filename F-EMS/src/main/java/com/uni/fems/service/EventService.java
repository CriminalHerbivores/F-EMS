package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.EventVO;

public interface EventService {
	List<EventVO> selectEvent() throws SQLException;
	void updateEvent(EventVO eventVO) throws SQLException;
}
