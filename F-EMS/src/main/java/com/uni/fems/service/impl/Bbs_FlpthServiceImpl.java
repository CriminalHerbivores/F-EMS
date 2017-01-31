package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Bbs_FlpthDAO;
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.service.Bbs_FlpthService;

public class Bbs_FlpthServiceImpl implements Bbs_FlpthService {
 
 private Bbs_FlpthDAO bbs_FlpthDAO;
 public void setBbs_FlpthDAO(Bbs_FlpthDAO bbs_FlpthDAO){
  this.bbs_FlpthDAO=bbs_FlpthDAO;
 }
 
 
}


