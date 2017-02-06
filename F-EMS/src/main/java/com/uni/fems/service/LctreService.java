package com.uni.fems.service;

import java.util.ArrayList;

import com.uni.fems.dto.LctreVO;


public interface LctreService {

	public ArrayList<LctreVO> getLctreList(int key);	
	public LctreVO selectLctre(int lc_Lctre_No);
	

	
}
