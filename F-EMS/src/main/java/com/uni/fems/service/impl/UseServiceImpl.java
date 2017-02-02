package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.UseDAO;
import com.uni.fems.dto.UseVO;
import com.uni.fems.service.UseService;

public class UseServiceImpl implements UseService {
 
 private UseDAO useDAO;
 public void setUseDAO(UseDAO useDAO){
  this.useDAO=useDAO;
 }
 
 
}

