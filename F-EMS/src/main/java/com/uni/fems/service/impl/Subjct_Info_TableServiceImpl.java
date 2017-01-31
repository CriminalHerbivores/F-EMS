package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Subjct_Info_TableDAO;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.service.Subjct_Info_TableService;

public class Subjct_Info_TableServiceImpl implements Subjct_Info_TableService {
 
 private Subjct_Info_TableDAO subjct_info_tableDAO;
 public void setSubjct_Info_TableDAO(Subjct_Info_TableDAO subjct_info_tableDAO){
  this.subjct_info_tableDAO=subjct_info_tableDAO;
 }
 
 
}


