package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;

public interface SknrgsDAO {
	String getSknrgs(String skn_Stdnt_No) throws SQLException;
	List<SknrgsVO> getStudentSknrgs(PageRequest p) throws SQLException;
	int totalRecord(PageRequest p) throws SQLException;
	void writeSknrgs(SknrgsVO sknrgs) throws SQLException;
}
