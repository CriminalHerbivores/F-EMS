package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.LctrumDAO;
import com.uni.fems.dto.LctrumVO;
import com.uni.fems.service.LctrumService;

public class LctrumServiceImpl implements LctrumService {
 
 private LctrumDAO lctrumDAO;
 public void setLctrumDAO(LctrumDAO lctrumDAO){
  this.lctrumDAO=lctrumDAO;
 }
 
// 강의 등록
@Override
public void insertLctrum(LctrumVO lctrumVO) throws SQLException {
	// TODO Auto-generated method stub
	
}

//강의 수정
@Override
public void updateLctrum(LctrumVO lctrumVO) throws SQLException {
	// TODO Auto-generated method stub
	
}
//강의 삭제
@Override
public void deleteLctrum(String lr_Lctrum_No) throws SQLException {
	// TODO Auto-generated method stub
	
}
 
 
}


