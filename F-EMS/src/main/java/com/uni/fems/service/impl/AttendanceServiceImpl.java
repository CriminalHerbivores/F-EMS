package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.AttendanceDAO;
import com.uni.fems.dto.AttendanceVO;
import com.uni.fems.service.AttendanceService;

public class AttendanceServiceImpl implements AttendanceService {
 
 private AttendanceDAO attendanceDAO;
 public void setAttendanceDAO(AttendanceDAO attendanceDAO){
  this.attendanceDAO=attendanceDAO;
 }
 
 
}


