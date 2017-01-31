package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Compl_PntDAO;
import com.uni.fems.dto.Compl_PntVO;
import com.uni.fems.service.Compl_PntService;

public class Compl_PntServiceImpl implements Compl_PntService {
 
 private Compl_PntDAO compl_pntDAO;
 public void setCompl_PntDAO(Compl_PntDAO compl_pntDAO){
  this.compl_pntDAO=compl_pntDAO;
 }
 
 
}


