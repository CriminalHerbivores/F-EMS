package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.GradeDAO;
import com.uni.fems.dto.GradeVO;
import com.uni.fems.service.GradeService;

public class GradeServiceImpl implements GradeService {
 
 private GradeDAO gradeDAO;
 public void setGradeDAO(GradeDAO gradeDAO){
  this.gradeDAO=gradeDAO;
 }
 
 
}


