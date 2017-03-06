package com.uni.fems.service;

import java.sql.SQLException;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_ActplnVO;

public interface Lctre_ActplnService {

	/**<pre>
	 * 강의 제너레이터 생성
	 * </pre>
	 * <pre>
	 * @param lctre_Table_Nm
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctre_Table(String lctre_Table_Nm) throws SQLException;
	/**<pre>
	 * 강의 제너레이터 삭제
	 * </pre>
	 * <pre>
	 * @param lctre_Table_Nm
	 * @throws SQLException
	 * </pre>
	 */
	void dropLctre_Table(String table_nm) throws SQLException;
	
	//void insertLctre_Actpln(Lctre_ActplnVO lctre_ActplnVO) throws SQLException;
}
