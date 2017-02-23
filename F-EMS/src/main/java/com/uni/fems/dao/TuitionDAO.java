package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.TuitionVO;

public interface TuitionDAO {
	ArrayList<TuitionVO> tuitionStdnt(TuitionVO tuitionVO,int start, int count) throws SQLException;
	int countTuitionStdnt(TuitionVO tuitionVO) throws SQLException;
	void insertTuition(TuitionVO tuitionVO) throws SQLException;
	void updateTuition(TuitionVO tuitionVO) throws SQLException;
	ArrayList<TuitionVO> selectTuition(TuitionVO tuitionVO) throws SQLException;
	ArrayList<TuitionVO> selectNotTuition(TuitionVO tuitionVO) throws SQLException;
}
