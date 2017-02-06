package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.Lctre_Unq_NoVO;

public interface Lctre_Unq_NoDAO {
	
	public int insertLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO) throws SQLException;	//강의고유번호 등록
	public int updateLctre_Unq_No(Lctre_Unq_NoVO lctre_Unq_NoVO) throws SQLException;	//강의고유번호 수정

}
