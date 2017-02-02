package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.StdntVO;

public interface StdntService {
	void insertStdnt(StdntVO stdntVO)throws SQLException;
}
