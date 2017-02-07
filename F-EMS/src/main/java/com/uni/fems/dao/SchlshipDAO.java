package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.dto.SchlshipVO;

public interface SchlshipDAO {
	public List<Schafs_SchdulVO> listAllSchafs_Schdul() throws SQLException;

	void insertSchlship(SchlshipVO schlshipVO) throws SQLException;

	int totalRecord(String ss_Schlship_Nm) throws SQLException;

	List<SchlshipVO> selectNameAllPage(int tpage, int totalRecord,
			String ss_Schlship_Nm) throws SQLException;

	SchlshipVO selectSchlship(String ss_Schlship_Code) throws SQLException;

	void updateSchlship(SchlshipVO schlshipVO) throws SQLException;
	
	
	//////////////관리자
	
	
	
	
}
