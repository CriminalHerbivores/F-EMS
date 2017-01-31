package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Profsr_Subjct_AsnmDAO;
import com.uni.fems.dto.Profsr_Subjct_AsnmVO;
import com.uni.fems.service.Profsr_Subjct_AsnmService;

public class Profsr_Subjct_AsnmServiceImpl implements Profsr_Subjct_AsnmService {
 
 private Profsr_Subjct_AsnmDAO profsr_subjct_asnmDAO;
 public void setProfsr_Subjct_AsnmDAO(Profsr_Subjct_AsnmDAO profsr_subjct_asnmDAO){
  this.profsr_subjct_asnmDAO=profsr_subjct_asnmDAO;
 }
 
 
}


