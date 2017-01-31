package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.ChattingDAO;
import com.uni.fems.dto.ChattingVO;
import com.uni.fems.service.ChattingService;

public class ChattingServiceImpl implements ChattingService {
 
 private ChattingDAO chattingDAO;
 public void setChattingDAO(ChattingDAO chattingDAO){
  this.chattingDAO=chattingDAO;
 }
 
 
}


