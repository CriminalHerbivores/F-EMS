package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.KindDAO;
import com.uni.fems.dto.KindVO;
import com.uni.fems.dto.Lctre_SearchVO;

/**
 * <pre>
 * 강의 등록, 수정, 삭제시 강의 유형을 반영하는 DAOImpl
 * </pre>
 * @author KJH
 * @since 2017. 2. 25.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017. 2. 25.   USER            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class KindDAOImpl implements KindDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public void insertKind(KindVO kindVO) throws SQLException {
		client.insert("insertKind",kindVO);
	}

	@Override
	public void updateKind(Lctre_SearchVO knd_Lctre_No) throws SQLException {
		client.update("updateKind",knd_Lctre_No);
	}
	
}
