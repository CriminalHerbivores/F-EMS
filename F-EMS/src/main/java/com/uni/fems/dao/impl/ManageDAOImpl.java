package com.uni.fems.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.ManageDAO;
import com.uni.fems.dto.ManageVO;

/**
 * <pre>
 * 대학관리 테이블에 조회, 등록, 수정이 가능한 DAO인터페이스 구현
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * 2017.02.15      KJH            추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class ManageDAOImpl implements ManageDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	// 대학정보 하나 가져오기
	@Override
	public ManageVO getManage() throws SQLException {
		ManageVO manageVO = (ManageVO) client.queryForObject("getManage","");
		
		return manageVO;
	}
}
