package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Profsr_SchedlDAO;
import com.uni.fems.dto.Profsr_SchedlVO;
import com.uni.fems.service.Profsr_SchedlService;

public class Profsr_SchedlServiceImpl implements Profsr_SchedlService {
 
 private Profsr_SchedlDAO profsr_schedlDAO;
 public void setProfsr_SchedlDAO(Profsr_SchedlDAO profsr_schedlDAO){
  this.profsr_schedlDAO=profsr_schedlDAO;
 }
 
 
}


