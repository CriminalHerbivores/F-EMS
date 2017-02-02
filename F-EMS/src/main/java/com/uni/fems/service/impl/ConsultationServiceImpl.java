package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.ConsultationDAO;
import com.uni.fems.dto.ConsultationVO;
import com.uni.fems.service.ConsultationService;

public class ConsultationServiceImpl implements ConsultationService {
 
 private ConsultationDAO consultationDAO;
 public void setConsultationDAO(ConsultationDAO consultationDAO){
  this.consultationDAO=consultationDAO;
 }
 
 
}


