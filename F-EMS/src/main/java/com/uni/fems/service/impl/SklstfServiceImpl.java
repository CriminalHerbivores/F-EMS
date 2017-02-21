package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.SklstfDAO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.service.SklstfService;

/**
 * <pre>
 * 직원과 관련된 Service를 구현
 * </pre>
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * 2017.02.22.    KJH       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class SklstfServiceImpl implements SklstfService {
 
	private SklstfDAO sklstfDAO;
	public void setSklstfDAO(SklstfDAO sklstfDAO){
		this.sklstfDAO=sklstfDAO;
	}

	@Override
	public SklstfVO getSklstf(String stf_Sklstf_No) throws SQLException {
		SklstfVO sklstfVo = sklstfDAO.getSklstf(stf_Sklstf_No); 
		return sklstfVo;
	}

	// 관리자가 직원 등록
	@Override
	public void insertSklstf(SklstfVO sklstfVo) throws SQLException {
		sklstfDAO.insertSklstf(sklstfVo);
	}
	
	@Override
	public void updateSklstf(SklstfVO sklstfVo) throws SQLException {
		sklstfDAO.updateSklstf(sklstfVo);
	}
	
	// 전체 직원의 목록 조회
	@Override
	public List<UserSubjctVO> sklstfList(String stf_Nm) throws SQLException {
		List<UserSubjctVO> userSubjctVO=sklstfDAO.sklstfList(stf_Nm);
		
		return userSubjctVO;
	}

}


