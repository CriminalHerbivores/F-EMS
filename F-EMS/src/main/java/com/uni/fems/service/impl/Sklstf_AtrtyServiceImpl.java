package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Sklstf_AtrtyDAO;
import com.uni.fems.dto.Sklstf_AtrtyVO;
import com.uni.fems.service.Sklstf_AtrtyService;

public class Sklstf_AtrtyServiceImpl implements Sklstf_AtrtyService {
 
 private Sklstf_AtrtyDAO sklstf_atrtyDAO;
 public void setSklstf_AtrtyDAO(Sklstf_AtrtyDAO sklstf_atrtyDAO){
  this.sklstf_atrtyDAO=sklstf_atrtyDAO;
 }
 
 
}


