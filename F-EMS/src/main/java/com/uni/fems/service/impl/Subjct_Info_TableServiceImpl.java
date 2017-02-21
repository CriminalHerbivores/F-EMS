package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dao.Subjct_Info_TableDAO;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.service.Subjct_Info_TableService;
/**
 * <pre>
 * 학과 관련 사항을 처리하는 ServiceImpl
 * </pre>
 * @author KJH
 * @since 2017. 02. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017.02.22.    KJH           최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Subjct_Info_TableServiceImpl implements Subjct_Info_TableService {
 
 private Subjct_Info_TableDAO subjct_Info_TableDAO;
 
 public void setSubjct_Info_TableDAO(Subjct_Info_TableDAO subjct_Info_TableDAO){
  this.subjct_Info_TableDAO=subjct_Info_TableDAO;
 }
 
 // 학과명으로 학과 찾기
@Override
public ArrayList<UserSubjctVO> selectSubjctByName(String sit_Subjct)
		throws SQLException {
	
	List<UserSubjctVO> userSubjctVO = subjct_Info_TableDAO.selectSubjctByName(sit_Subjct);
	
	return (ArrayList<UserSubjctVO>) userSubjctVO;
}
 
 
}


