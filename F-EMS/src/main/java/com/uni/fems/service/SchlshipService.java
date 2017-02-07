package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.SchlshipVO;

public interface SchlshipService {

	void insertSchlship(SchlshipVO schlshipVO) throws SQLException;

	List<SchlshipVO> selectNameAllPage(int tpage, String ss_Schlship_Nm)
			throws SQLException;

	String pageNumber(int tpage, String ss_Schlship_Nm) throws SQLException;

	SchlshipVO selectSchlship(String ss_Schlship_Code) throws SQLException;

	void updateSchlship(SchlshipVO schlshipVO) throws SQLException;

}
