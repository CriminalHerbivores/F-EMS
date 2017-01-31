package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.KindDAO;
import com.uni.fems.dto.KindVO;
import com.uni.fems.service.KindService;

public class KindServiceImpl implements KindService {
 
 private KindDAO kindDAO;
 public void setKindDAO(KindDAO kindDAO){
  this.kindDAO=kindDAO;
 }
 
 
}


