package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.TestDAO;
import com.uni.fems.dto.TestVO;
import com.uni.fems.service.TestService;

public class TestServiceImpl implements TestService {
 
 private TestDAO testDAO;
 public void setTestDAO(TestDAO testDAO){
  this.testDAO=testDAO;
 }
 
 
}


