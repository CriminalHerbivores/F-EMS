package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.UserSubjctVO;

public interface TuitionService {
	ArrayList<UserSubjctVO> selectSubjctByName(int tpage, int totalRecord, String sit_Subjct) throws SQLException;
	int countSubjctByName(String sit_Subjct) throws SQLException;
	void toStdTuition() throws SQLException;
}
