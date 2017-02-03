package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.SknrgsVO;

public interface SknrgsService {
	SknrgsVO getStudentSknrgs(String skn_Stdnt_No) throws SQLException;
}
