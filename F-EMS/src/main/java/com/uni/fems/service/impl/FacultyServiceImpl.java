package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.FacultyDAO;
import com.uni.fems.dto.FacultyVO;
import com.uni.fems.service.FacultyService;

public class FacultyServiceImpl implements FacultyService {
 
 private FacultyDAO facultyDAO;
 public void setFacultyDAO(FacultyDAO facultyDAO){
  this.facultyDAO=facultyDAO;
 }
 
 
}


