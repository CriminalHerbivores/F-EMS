package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Lctre_FlpthDAO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.service.Lctre_FlpthService;

public class Lctre_FlpthServiceImpl implements Lctre_FlpthService {
 
 private Lctre_FlpthDAO lctre_FlpthDAO;
 public void setLctre_FlpthDAO(Lctre_FlpthDAO lctre_FlpthDAO){
  this.lctre_FlpthDAO=lctre_FlpthDAO;
 }
 
 
}


