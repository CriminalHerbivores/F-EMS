package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.UsersDAO;
import com.uni.fems.dto.UsersVO;
import com.uni.fems.service.UsersService;

public class UsersServiceImpl implements UsersService {
 
 private UsersDAO usersDAO;
 public void setUsersDAO(UsersDAO usersDAO){
  this.usersDAO=usersDAO;
 }
 
 
}


