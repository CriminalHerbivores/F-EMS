package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Schafs_SchdulDAO;
import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.service.Schafs_SchdulService;
/**
 * <pre>
 * 학사일정 CRUD를 위한 ServiceImpl
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
public class Schafs_SchdulServiceImpl implements Schafs_SchdulService {
 
 private Schafs_SchdulDAO schafs_SchdulDAO;
 public void setSchafs_SchdulDAO(Schafs_SchdulDAO schafs_SchdulDAO){
  this.schafs_SchdulDAO=schafs_SchdulDAO;
 }
@Override
public int insertSchdul(Schafs_SchdulVO schdulVO) throws SQLException {
	int result = schafs_SchdulDAO.insertSchdul(schdulVO);
	return result;
	
	
}
 
 
}


