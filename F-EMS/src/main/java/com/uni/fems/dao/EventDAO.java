package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.EventVO;

public interface EventDAO {
	EventVO selectEvent(String evt_Nm) throws SQLException;
	void updateEvent(EventVO eventVO) throws SQLException;
}
