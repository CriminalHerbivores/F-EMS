package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Cnslt_BbsDAO;
import com.uni.fems.dto.Cnslt_BbsVO;
import com.uni.fems.service.Cnslt_BbsService;

public class Cnslt_BbsServiceImpl implements Cnslt_BbsService {
 
 private Cnslt_BbsDAO cnslt_bbsDAO;
 public void setCnslt_BbsDAO(Cnslt_BbsDAO cnslt_bbsDAO){
  this.cnslt_bbsDAO=cnslt_bbsDAO;
 }
 
 
}


