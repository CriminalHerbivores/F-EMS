package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.ProfsrDAO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.ProfsrService;

public class ProfsrServiceImpl implements ProfsrService {
 
 private ProfsrDAO profsrDAO;
 public void setProfsrDAO(ProfsrDAO profsrDAO){
  this.profsrDAO=profsrDAO;
 }
 
 
}


