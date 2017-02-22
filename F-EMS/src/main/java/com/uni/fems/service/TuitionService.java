package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.UserSubjctVO;

public interface TuitionService {
	ArrayList<UserSubjctVO> selectSubjctByName(int tpage, int totalRecord, String sit_Subjct) throws SQLException;
	int countSubjctByName(String sit_Subjct) throws SQLException;
	void toStdTuition() throws SQLException;
	void updateTuition(Subjct_Info_TableVO subVO) throws SQLException;
	UserSubjctVO selectSubjctByCode(String sit_Subjct_Code) throws SQLException;
}
