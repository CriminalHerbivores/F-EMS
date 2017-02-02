package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.PymntDAO;
import com.uni.fems.dto.PymntVO;
import com.uni.fems.service.PymntService;

public class PymntServiceImpl implements PymntService {
 
 private PymntDAO pymntDAO;
 public void setPymntDAO(PymntDAO pymntDAO){
  this.pymntDAO=pymntDAO;
 }
 
 
}


