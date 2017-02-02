package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.service.LctreService;

public class LctreServiceImpl implements LctreService {
 
 private LctreDAO lctreDAO;
 public void setLctreDAO(LctreDAO lctreDAO){
  this.lctreDAO=lctreDAO;
 }
 
 
}


