package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Schafs_SchdulDAO;
import com.uni.fems.dto.Schafs_SchdulVO;

/**
 * <pre>
 * Schafs_SchdulDAO 인터페이스를 상속받아 활용하는 클래스
 * </pre>
 * @author 송선호
 * @since 2017.02.19
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.19     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Schafs_SchdulDAOImpl implements Schafs_SchdulDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public int insertSchdul(Schafs_SchdulVO schdulVO) throws SQLException {
		int result = client.update("insertSchdul", schdulVO);
		return result;
	}
	
}
