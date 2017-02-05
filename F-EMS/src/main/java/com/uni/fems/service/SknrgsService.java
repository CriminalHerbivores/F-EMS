package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;

public interface SknrgsService {
	String getSknrgs(String skn_Stdnt_No) throws SQLException;
	int totalRecord(PageRequest p) throws SQLException;
	List<SknrgsVO> getStudentSknrgs(PageRequest p) throws SQLException;
	String pageNumber(PageRequest p) throws SQLException;
	void writeSknrgs(SknrgsVO sknrgs) throws SQLException;
}
