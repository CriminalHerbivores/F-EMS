package com.uni.fems.dao.impl;


import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SklstfDAO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.UserSubjctVO;

/**
 * <pre>
 * 직원 관련 사항을 처리하는 DAOImpl
 * </pre>
 * @author KJH
 * @since 2017. 02. 22
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.02.22      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class SklstfDAOImpl implements SklstfDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public SklstfVO getSklstf(String stf_Sklstf_No) throws SQLException {
		System.out.println("1:stf_Sklstf_No : "+stf_Sklstf_No);
		SklstfVO sklstfVo = (SklstfVO) client.queryForObject("getSklstf", stf_Sklstf_No);
		System.out.println("2-stf_Sklstf_No : "+stf_Sklstf_No);
		return sklstfVo;
	}
	@Override
	public void updateSklstf(SklstfVO sklstfVo) throws SQLException {
		client.update("updateSklstf", sklstfVo);
	}
	
	// 관리자의 직원 등록
	@Override
	public void insertSklstf(SklstfVO sklstfVo) throws SQLException {
		client.update("insertSklstf",sklstfVo);
	}
	
	// 전체 직원의 목록
	@Override
	public List<UserSubjctVO> sklstfList(String stf_Nm) throws SQLException {
		
		List<UserSubjctVO> sklstfList;
		if(stf_Nm==null){
			stf_Nm="";
		}
		sklstfList = client.queryForList("sklstfList",stf_Nm);	
		return sklstfList;
	}
	
}
