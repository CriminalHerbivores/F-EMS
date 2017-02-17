package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.Lctre_Unq_NoVO;

public interface Lctre_Unq_NoService {

	
	/**
	 * <pre>
	 * 교수가 강의개설할 때 강의이름으로 강의 찾기
	 * </pre>
	 * <pre>
	 * @param lu_Lctre_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public ArrayList<Lctre_SearchVO> selectLctreByName(String lu_Lctre_Nm) throws SQLException;
}
