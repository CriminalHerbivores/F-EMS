package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.StdntVO;

public interface StdntDAO {

	void insertStdnt(StdntVO stdntVO)throws SQLException;
	void updateStdnt(StdntVO stdntVO)throws SQLException;
	int totalRecord(String st_Nm) throws SQLException;
	List<StdntVO> selectNameAllPage(int tpage,int totalRecord, String st_Nm) throws SQLException;
	StdntVO selectStdnt(String st_Stdnt_No)throws SQLException;
	void registBrhs(StdntVO stdntVO) throws SQLException;
}
