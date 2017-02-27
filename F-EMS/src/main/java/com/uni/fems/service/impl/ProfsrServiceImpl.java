package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dao.ProfsrDAO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.ProfsrService;

/**
 * <pre>
 * 교수와 관련된 Service를 구현
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
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class ProfsrServiceImpl implements ProfsrService {
 
	private ProfsrDAO profsrDAO;
	public void setProfsrDAO(ProfsrDAO profsrDAO){
		this.profsrDAO=profsrDAO;
	}
	@Autowired
	private LctreDAO lctreDAO;
	
 	@Override
	public void insertProfsr(ProfsrVO profsrVO) throws SQLException {
 		profsrDAO.insertProfsr(profsrVO);
 	}
 	
	@Override
	public List<ProfsrVO> selectNameAllPage(int tpage, String pr_Nm)
			throws SQLException {
		int totalRecord = profsrDAO.totalRecord(pr_Nm);
		List<ProfsrVO> list = profsrDAO.selectNameAllPage(tpage, totalRecord,pr_Nm);
		return list;
	}

	@Override
	public String pageNumber(int tpage, String st_Nm) throws SQLException {
		int totalRecord = profsrDAO.totalRecord(st_Nm);
		String page = new Paging().pageNumber(tpage,totalRecord,"profsrList", "&key="+st_Nm);
		return page;
	}

	@Override
	public ProfsrVO selectProfsr(String st_Profsr_No) throws SQLException {
		ProfsrVO profsrVO = profsrDAO.selectProfsr(st_Profsr_No);
		return profsrVO;
	}

	@Override
	public void updateProfsr(ProfsrVO profsrVO) throws SQLException {
		profsrDAO.updateProfsr(profsrVO);
	}

}


