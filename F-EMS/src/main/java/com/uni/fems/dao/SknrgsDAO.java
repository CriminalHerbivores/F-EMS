package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SknrgsVO;

public interface SknrgsDAO {
	List<SknrgsVO> getStudentSknrgs(String skn_Stdnt_No) throws SQLException;
}
