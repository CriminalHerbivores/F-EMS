package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.SchlshipDAO;
import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.service.SchlshipService;

public class SchlshipServiceImpl implements SchlshipService {
 
 private SchlshipDAO schlshipDAO;
 public void setSchlshipDAO(SchlshipDAO schlshipDAO){
  this.schlshipDAO=schlshipDAO;
 }
 
 
}


