package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.SklstfVO;

public interface ManageService {
	
	void getListSklstf(SklstfVO vo) throws SQLException;
	
	void setSklstfAtrty(SklstfVO vo) throws SQLException;
	
}
