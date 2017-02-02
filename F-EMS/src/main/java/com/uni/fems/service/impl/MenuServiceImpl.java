package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.MenuDAO;
import com.uni.fems.dto.MenuVO;
import com.uni.fems.service.MenuService;

public class MenuServiceImpl implements MenuService {
 
 private MenuDAO menuDAO;
 public void setMenuDAO(MenuDAO menuDAO){
  this.menuDAO=menuDAO;
 }
 
 
}


