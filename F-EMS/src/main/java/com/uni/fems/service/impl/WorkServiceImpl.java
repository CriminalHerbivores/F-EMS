package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.WorkDAO;
import com.uni.fems.dto.WorkVO;
import com.uni.fems.service.WorkService;

public class WorkServiceImpl implements WorkService {
 
 private WorkDAO workDAO;
 public void setWorkDAO(WorkDAO workDAO){
  this.workDAO=workDAO;
 }
 
 
}


