package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Sklstf_AtrtyDAO;
import com.uni.fems.dto.Sklstf_AtrtyVO;
import com.uni.fems.service.Sklstf_AtrtyService;

/**
 * <pre>
 * 직원 권한을 관리하기 위한 Service
 * </pre>
 * @author KJH
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    KJH       최초작성
 * 2017.02.23.    KJH       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Sklstf_AtrtyServiceImpl implements Sklstf_AtrtyService {
 
 private Sklstf_AtrtyDAO sklstf_AtrtyDAO;
 public void setSklstf_AtrtyDAO(Sklstf_AtrtyDAO sklstf_AtrtyDAO){
  this.sklstf_AtrtyDAO=sklstf_AtrtyDAO;
 }
 
 // 직원 권한 수정
@Override
public void updateSklstf_Atrty(Sklstf_AtrtyVO sklstf_AtrtyVO)
		throws SQLException {
	sklstf_AtrtyDAO.updateSklstf_Atrty(sklstf_AtrtyVO);
}
 
 
}


