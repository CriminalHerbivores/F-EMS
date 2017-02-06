package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.Lctre_ActplnVO;

public interface Lctre_ActplnDAO {
	
	public int insertLctre_Actpl(Lctre_ActplnVO lctre_ActplnVO) throws SQLException;	//강의계획서 등록
	public int updateLctre_Actpl(Lctre_ActplnVO lctre_ActplnVO) throws SQLException;	//강의계획서 수정

}
