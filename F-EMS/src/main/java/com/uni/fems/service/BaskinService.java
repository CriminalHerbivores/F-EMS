package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.BaskinVO;

public interface BaskinService {
	List<BaskinVO> getBaskin() throws SQLException;
	BaskinVO getThemeBaskin(String bskn_Nm) throws SQLException;
}
