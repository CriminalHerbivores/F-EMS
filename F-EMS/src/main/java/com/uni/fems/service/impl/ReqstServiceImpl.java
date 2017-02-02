package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.ReqstDAO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.service.ReqstService;

public class ReqstServiceImpl implements ReqstService {
 
 private ReqstDAO reqstDAO;
 public void setReqstDAO(ReqstDAO reqstDAO){
  this.reqstDAO=reqstDAO;
 }
 
 
}


