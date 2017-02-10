package com.uni.fems.dao;


import java.sql.SQLException;

import com.uni.fems.dto.SklstfVO;

public interface SklstfDAO {

	SklstfVO getSklstf(String stf_Sklstf_No)throws SQLException;
	void updateSklstf(SklstfVO sklstfVo)throws SQLException;
	
	void insertSklstf(SklstfVO sklstfVo)throws SQLException;	//직원 가입
	
}
