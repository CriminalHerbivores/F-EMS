package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.ProfsrVO;

public interface ProfsrService {

	void insertProfsr(ProfsrVO profsrVO) throws SQLException;

	List<ProfsrVO> selectNameAllPage(int tpage, String pr_Nm)
			throws SQLException;

	String pageNumber(int tpage, String st_Nm) throws SQLException;

	ProfsrVO selectProfsr(String st_Profsr_No) throws SQLException;

	void updateProfsr(ProfsrVO profsrVO) throws SQLException;

}
