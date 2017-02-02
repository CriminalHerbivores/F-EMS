package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.LctrumDAO;
import com.uni.fems.dto.LctrumVO;
import com.uni.fems.service.LctrumService;

public class LctrumServiceImpl implements LctrumService {
 
 private LctrumDAO lctrumDAO;
 public void setLctrumDAO(LctrumDAO lctrumDAO){
  this.lctrumDAO=lctrumDAO;
 }
 
 
}


