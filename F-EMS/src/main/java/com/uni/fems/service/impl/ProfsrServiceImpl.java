package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.ProfsrDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.ProfsrService;

public class ProfsrServiceImpl implements ProfsrService {
 
 private ProfsrDAO profsrDAO;
 public void setProfsrDAO(ProfsrDAO profsrDAO){
  this.profsrDAO=profsrDAO;
 }
 
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


