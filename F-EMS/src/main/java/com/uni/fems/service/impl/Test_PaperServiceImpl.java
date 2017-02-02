package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Test_PaperDAO;
import com.uni.fems.dto.Test_PaperVO;
import com.uni.fems.service.Test_PaperService;

public class Test_PaperServiceImpl implements Test_PaperService {
 
 private Test_PaperDAO test_PaperDAO;
 public void setTest_PaperDAO(Test_PaperDAO test_PaperDAO){
  this.test_PaperDAO=test_PaperDAO;
 }
 
 
}


