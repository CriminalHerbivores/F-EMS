package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Schafs_SchdulDAO;
import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.service.Schafs_SchdulService;

public class Schafs_SchdulServiceImpl implements Schafs_SchdulService {
 
 private Schafs_SchdulDAO schafs_SchdulDAO;
 public void setSchafs_SchdulDAO(Schafs_SchdulDAO schafs_SchdulDAO){
  this.schafs_SchdulDAO=schafs_SchdulDAO;
 }
 
 
}


