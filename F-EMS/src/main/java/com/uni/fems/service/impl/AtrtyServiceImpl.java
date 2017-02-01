package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.AtrtyDAO;
import com.uni.fems.dto.AtrtyVO;
import com.uni.fems.service.AtrtyService;

public class AtrtyServiceImpl implements AtrtyService {
 
 private AtrtyDAO atrtyDAO;
 public void setAtrtyDAO(AtrtyDAO atrtyDAO){
  this.atrtyDAO=atrtyDAO;
 }
 
 
}


