package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Menu_SeDAO;
import com.uni.fems.dto.Menu_SeVO;
import com.uni.fems.service.Menu_SeService;

public class Menu_SeServiceImpl implements Menu_SeService {
 
 private Menu_SeDAO menu_seDAO;
 public void setMenu_SeDAO(Menu_SeDAO menu_seDAO){
  this.menu_seDAO=menu_seDAO;
 }
 
 
}


