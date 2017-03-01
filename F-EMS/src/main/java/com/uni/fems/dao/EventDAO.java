package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.EventVO;

public interface EventDAO {
	List<EventVO> selectEvent() throws SQLException;
	void updateEvent(EventVO eventVO) throws SQLException;
}
