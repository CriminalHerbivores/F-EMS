package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.BaskinVO;

public interface BaskinDAO {
	List<BaskinVO> getBaskin() throws SQLException;
	void setBaskin(BaskinVO baskin) throws SQLException;
	String getName() throws SQLException;
}
