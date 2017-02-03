package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.Bbs_FlpthVO;

public interface Bbs_FlpthDAO {

	public Bbs_FlpthVO getBbs_Flpth(int bbs_No) throws SQLException;
	
	public int insertBbs_Flpth(Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	public int updateBbs_Flpth(Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	public int deleteBbs_Flpth(int bf_No) throws SQLException;
	
	
}
