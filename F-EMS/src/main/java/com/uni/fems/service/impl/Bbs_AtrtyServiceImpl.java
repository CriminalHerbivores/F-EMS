package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Bbs_AtrtyDAO;
import com.uni.fems.dto.Bbs_AtrtyVO;
import com.uni.fems.service.Bbs_AtrtyService;

public class Bbs_AtrtyServiceImpl implements Bbs_AtrtyService {
 
 private Bbs_AtrtyDAO bbs_AtrtyDAO;
 public void setBbs_AtrtyDAO(Bbs_AtrtyDAO bbs_AtrtyDAO){
  this.bbs_AtrtyDAO=bbs_AtrtyDAO;
 }
 
 
}


