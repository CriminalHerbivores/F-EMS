package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.BuildingDAO;
import com.uni.fems.dto.BuildingVO;
import com.uni.fems.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
 
 private BuildingDAO buildingDAO;
 public void setBuildingDAO(BuildingDAO buildingDAO){
  this.buildingDAO=buildingDAO;
 }
 
 
}


