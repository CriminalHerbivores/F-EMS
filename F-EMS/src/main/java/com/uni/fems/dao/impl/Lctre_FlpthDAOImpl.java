package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Lctre_FlpthDAO;
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Lctre_FlpthVO;

/**
 * <pre>
 * 강의 파일 업로드 및 다운로드를 위한 DAOImpl
 * </pre>
 * @author KJS
 * @since 2017.02.23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.23     KJS                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Lctre_FlpthDAOImpl implements Lctre_FlpthDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public Lctre_FlpthVO getLctre_Flpth(int lf_No) throws SQLException {
		Lctre_FlpthVO result = (Lctre_FlpthVO) client.queryForObject("getLctre_Flpth", lf_No);
		return result;
	}
	
	@Override
	public int maxLctre_Flpth() throws SQLException {
		int maxNo = (int) client.queryForObject("maxLctre_Flpth");
		return maxNo;
	}
	
	@Override
	public int insertLctre_Flpth(Lctre_FlpthVO lctre_Flpth) throws SQLException {
		int result = client.update("insertLctre_Flpth", lctre_Flpth);
		return result;
	}
	@Override
	public int deleteLctre_Flpth_lctre(int lf_No)
			throws SQLException {
		int result = client.update("deleteLctre_Flpth_lctre",lf_No);
		return result;
	}
}
