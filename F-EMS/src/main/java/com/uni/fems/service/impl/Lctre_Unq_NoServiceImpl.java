package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Lctre_Unq_NoDAO;
import com.uni.fems.dto.Lctre_Unq_NoVO;
import com.uni.fems.service.Lctre_Unq_NoService;

public class Lctre_Unq_NoServiceImpl implements Lctre_Unq_NoService {
 
 private Lctre_Unq_NoDAO lctre_unq_noDAO;
 public void setLctre_Unq_NoDAO(Lctre_Unq_NoDAO lctre_unq_noDAO){
  this.lctre_unq_noDAO=lctre_unq_noDAO;
 }
 
 
}


