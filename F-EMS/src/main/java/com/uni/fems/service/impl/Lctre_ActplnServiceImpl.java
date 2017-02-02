package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Lctre_ActplnDAO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.service.Lctre_ActplnService;

public class Lctre_ActplnServiceImpl implements Lctre_ActplnService {
 
 private Lctre_ActplnDAO lctre_ActplnDAO;
 public void setLctre_ActplnDAO(Lctre_ActplnDAO lctre_ActplnDAO){
  this.lctre_ActplnDAO=lctre_ActplnDAO;
 }
 
 
}


