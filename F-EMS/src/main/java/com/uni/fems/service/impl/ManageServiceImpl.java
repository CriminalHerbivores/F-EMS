package com.uni.fems.service.impl;

import java.sql.SQLException;

import com.uni.fems.dao.ManageDAO;
import com.uni.fems.dto.ManageVO;
import com.uni.fems.service.ManageService;

public class ManageServiceImpl implements ManageService {
 
 private ManageDAO manageDAO;
 public void setManageDAO(ManageDAO manageDAO){
  this.manageDAO=manageDAO;
 }
@Override
public ManageVO getManage() throws SQLException {
	ManageVO manageVO = manageDAO.getManage();
	return manageVO;
}
 
 
}


