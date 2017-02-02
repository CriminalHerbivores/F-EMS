package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.SklstfVO;

public interface SklstfService {
	SklstfVO getSklstf(String stf_Sklstf_No)throws SQLException;
	void updateSklstf(SklstfVO sklstfVo)throws SQLException;
}
