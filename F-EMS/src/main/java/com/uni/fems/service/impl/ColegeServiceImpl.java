package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.ColegeDAO;
import com.uni.fems.dto.ColegeVO;
import com.uni.fems.service.ColegeService;

public class ColegeServiceImpl implements ColegeService {
 
 private ColegeDAO colegeDAO;
 public void setColegeDAO(ColegeDAO colegeDAO){
  this.colegeDAO=colegeDAO;
 }
 
 
}


