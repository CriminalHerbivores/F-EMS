package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.StdntVO;

public interface StdntService {
	void insertStdnt(StdntVO stdntVO)throws SQLException;
	List<StdntVO> selectNameAllPage(int tpage,String st_Nm) throws SQLException;
	String pageNumber(int tpage, String st_Nm) throws SQLException;
}
