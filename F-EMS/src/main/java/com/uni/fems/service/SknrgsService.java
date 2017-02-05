package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SknrgsVO;

public interface SknrgsService {
	List<SknrgsVO> getStudentSknrgs(String skn_Stdnt_No) throws SQLException;
	String pageNumber(int tpage,String key,String path) throws SQLException;
}
