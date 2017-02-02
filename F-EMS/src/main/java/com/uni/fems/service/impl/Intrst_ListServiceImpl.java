package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Intrst_ListDAO;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.service.Intrst_ListService;

public class Intrst_ListServiceImpl implements Intrst_ListService {
 
 private Intrst_ListDAO intrst_ListDAO;
 public void setIntrst_ListDAO(Intrst_ListDAO intrst_ListDAO){
  this.intrst_ListDAO=intrst_ListDAO;
 }
 
 
}


