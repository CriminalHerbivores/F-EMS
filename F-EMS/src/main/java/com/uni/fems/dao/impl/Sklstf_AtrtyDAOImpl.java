package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Sklstf_AtrtyDAO;
import com.uni.fems.dto.Sklstf_AtrtyVO;

/**
 * <pre>
 * 직원에게 관리자 권한을 설정하는 DAOImpl
 * </pre>
 * @author pc12
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.      pc12       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Sklstf_AtrtyDAOImpl implements Sklstf_AtrtyDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	// 직원의 관리자 권한 설정 등록
	@Override
	public void insertSklstf_Atrty(Sklstf_AtrtyVO sklstf_AtrtyVO)
			throws SQLException {
		client.insert("insertSklstf_Atrty",sklstf_AtrtyVO);
	}
	
	//직원의 관리자 권한 설정 수정
	@Override
	public void updateSklstf_Atrty(Sklstf_AtrtyVO sklstf_AtrtyVO)
			throws SQLException {
		client.update("updateSklstf_Atrty",sklstf_AtrtyVO);
	}
	
}
