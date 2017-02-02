package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.StdntVO;

public interface StdntDAO {

	void insertStdnt(StdntVO stdntVO)throws SQLException;
}
