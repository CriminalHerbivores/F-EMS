package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.SknrgsVO;

public interface SknrgsDAO {
	SknrgsVO getStudentSknrgs(String skn_Stdnt_No) throws SQLException;
}
