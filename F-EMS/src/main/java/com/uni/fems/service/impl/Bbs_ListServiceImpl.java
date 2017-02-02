package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Bbs_ListDAO;
import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.service.Bbs_ListService;

public class Bbs_ListServiceImpl implements Bbs_ListService {
 
 private Bbs_ListDAO bbs_ListDAO;
 public void setBbs_ListDAO(Bbs_ListDAO bbs_ListDAO){
  this.bbs_ListDAO=bbs_ListDAO;
 }
 
 
}


