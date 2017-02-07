package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.StdntVO;

public interface ProfsrDAO {

	void insertProfsr(ProfsrVO profsrVO) throws SQLException;

	int totalRecord(String pt_Nm) throws SQLException;

	List<ProfsrVO> selectNameAllPage(int tpage, int totalRecord, String pt_Nm)
			throws SQLException;



	ProfsrVO selectProfsr(String pr_Profsr_No) throws SQLException;

	void updateProfsr(ProfsrVO profsrVO) throws SQLException;

}
