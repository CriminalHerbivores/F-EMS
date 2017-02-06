package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.service.LctreService;

public class LctreServiceImpl implements LctreService {
 
 private LctreDAO lctreDAO;
 public void setLctreDAO(LctreDAO lctreDAO){
  this.lctreDAO=lctreDAO;
 }
	
	public ArrayList<LctreVO> getLctreList(int key){
		ArrayList<LctreVO> lctreList=null;
		try {
			lctreList = lctreDAO.listLctre(key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lctreList;
	}
	
	public LctreVO selectLctre(int lc_Lctre_No){
		LctreVO lctre=null;
		try {
			lctre=lctreDAO.getLctre(lc_Lctre_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lctre;
	}


 
}


