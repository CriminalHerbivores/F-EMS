package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;


public interface LctreDAO {

//	Lctre_SearchVO getLctre(String lc_Lctre_No) throws SQLException;	// 강의 하나 가져오기
//	ArrayList<Lctre_SearchVO> listComboLctre(int lc_Lctre_No) throws SQLException; // 강의 콤보박스별 강의 리스트 가져오기
//	ArrayList<Lctre_SearchVO> listDetailLctre(int lc_Lctre_No) throws SQLException; // 강의 상세 검색
	
	ArrayList<LctreVO> listLctre(Lctre_SearchVO lctre_SearchVO) throws SQLException; // 전체 강의 목록 

//	int selectCount(LctreVO lctreVO) throws SQLException;	//[수강신청] 현재 학기의 전체 강의 갯수
//	
//	
//	int insertLctre(LctreVO lctreVO) throws SQLException;	//강의 등록
//	int updateLctre(LctreVO lctreVO) throws SQLException;	//강의 수정
//	int deleteLctre(int lc_Lctre_No) throws SQLException;	//강의 삭제
	
}

