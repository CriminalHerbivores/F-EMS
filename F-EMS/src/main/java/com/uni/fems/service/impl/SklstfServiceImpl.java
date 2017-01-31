package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.SklstfDAO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.service.SklstfService;

public class SklstfServiceImpl implements SklstfService {
 
 private SklstfDAO sklstfDAO;
 public void setSklstfDAO(SklstfDAO sklstfDAO){
  this.sklstfDAO=sklstfDAO;
 }
 
 
}


