package com.uni.fems.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;

/**
 * <pre>
 * 수강신청, 강의목록조회, 강의등록, 강의수정과 같은 하나의 작업을
 * 묶어서 복합적으로 처리하는 service
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface LctreService {

	/*public ArrayList<LctreVO> getLctreList(int key);	
	public LctreVO selectLctre(int lc_Lctre_No);*/

	// 강의 등록 - 서비스로 가야함
//		Lctre_SearchVO insertLctre_Search();
		
	// 강의 수정 - 서비스로 가야함
//	Lctre_SearchVO updateLctre_Search(Lctre_SearchVO lctre_SearchVO, HttpServletRequest request);
	
	
	
}
