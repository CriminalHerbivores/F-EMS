package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.LctreVO;


public interface LctreDAO {

	public LctreVO getLctre(int lc_lctre_No) throws SQLException;	// 강의 하나 가져오기
	public ArrayList<LctreVO> listCodeLctre(String lc_Lctre_Code) throws SQLException; // 강의 코드별 강의 리스트 가져오기
	
	public int insertLctre(LctreVO lctreVO) throws SQLException;	//강의 등록
	public int updateLctre(LctreVO lctreVO) throws SQLException;	//강의 수정
	public ArrayList<LctreVO> listLctre(int new_lctre_No) throws SQLException; // 전체 강의 목록
	int confirmNO(int new_lctre_No) throws SQLException;
	
}

