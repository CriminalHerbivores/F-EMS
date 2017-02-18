package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.BuildingDAO;
import com.uni.fems.dto.BuildingVO;
import com.uni.fems.service.BuildingService;

/**
 * <pre>
 * 건물 등록, 수정 사용안함을 구현하는 ServiceImpl
 * </pre>
 * @author USER
 * @since 2017. 2. 18.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자          수정내용
 * --------     --------    ----------------------
 * 2017. 2. 18.   KJH            최초작성-------
 * 2017. 2. 18.      USER       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class BuildingServiceImpl implements BuildingService {
 
 private BuildingDAO buildingDAO;
 public void setBuildingDAO(BuildingDAO buildingDAO){
  this.buildingDAO=buildingDAO;
 }
 
 
@Override
public void insertBuilding(BuildingVO buildingVO) throws SQLException {
	buildingDAO.insertBuilding(buildingVO);
	System.out.println("여기1111111111111111111111111111111");
}


//@Override
//public void updateBuilding(BuildingVO buildingVO) throws SQLException {
//	buildingDAO.updateBuilding(buildingVO);
//}
//@Override
//public void deleteBuilding(String bd_No) throws SQLException {
//	buildingDAO.deleteBuilding(bd_No);
//}
 
 
}


