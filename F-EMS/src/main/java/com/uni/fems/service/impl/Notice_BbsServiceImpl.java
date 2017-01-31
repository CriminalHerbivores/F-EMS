package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.service.Notice_BbsService;

public class Notice_BbsServiceImpl implements Notice_BbsService {
 
 private Notice_BbsDAO notice_bbsDAO;
 public void setNotice_BbsDAO(Notice_BbsDAO notice_bbsDAO){
  this.notice_bbsDAO=notice_bbsDAO;
 }
 
 
}


