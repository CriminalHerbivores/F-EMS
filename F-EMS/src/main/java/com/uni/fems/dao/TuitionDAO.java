package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.TuitionVO;

public interface TuitionDAO {
	ArrayList<TuitionVO> tuitionStdnt(String tu_Stdnt_No) throws SQLException;
	void insertTuition(TuitionVO tuitionVO) throws SQLException;
	void updateTuition(TuitionVO tuitionVO) throws SQLException;
	ArrayList<TuitionVO> selectTuition(SearchVO searchVO) throws SQLException;
	ArrayList<TuitionVO> selectNotTuition(SearchVO searchVO) throws SQLException;
}
