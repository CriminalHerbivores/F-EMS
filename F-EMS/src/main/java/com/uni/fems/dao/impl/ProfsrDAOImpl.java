package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.ProfsrDAO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.StdntVO;

public class ProfsrDAOImpl implements ProfsrDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public void insertProfsr(ProfsrVO profsrVO) throws SQLException {
		client.update("insertProfsr", profsrVO);
	}
	

	@Override
	public int totalRecord(String pt_Nm) throws SQLException {
		int totalRecord = 0;
		if (pt_Nm.equals("")) {
			pt_Nm = "%";
		}
		totalRecord = (Integer) client.queryForObject("totalProfsr", pt_Nm);
		return totalRecord;
	}

	@Override
	public List<ProfsrVO> selectNameAllPage(int tpage, int totalRecord,
			String pt_Nm) throws SQLException {
		List<ProfsrVO> list = null;
		Paging p = new Paging();
		pt_Nm = p.key(pt_Nm);

		int[] rows = p.row(tpage, totalRecord);
		list = (ArrayList<ProfsrVO>) client.queryForList("selectAllProfsrPage", pt_Nm, rows[1], rows[0]);
		return list;
	}

	@Override
	public ProfsrVO selectProfsr(String pr_Profsr_No) throws SQLException {
		ProfsrVO profsrVO = (ProfsrVO) client.queryForObject("selectProfsr", pr_Profsr_No);
		return profsrVO;
	}

	@Override
	public void updateProfsr(ProfsrVO profsrVO) throws SQLException {
		client.update("updateProfsr", profsrVO);
	}

	@Override
	public void updatePw(ProfsrVO profsrVO) throws SQLException {
		client.update("updatePwProfsr",profsrVO);
	}
	@Override
	public List<ProfsrVO> selectAllProfsrList2(ProfsrVO profarVO, int tpage, int totalRecord) throws SQLException {
		Paging p = new Paging();
		int[] rows = p.row(tpage, totalRecord);
		List<ProfsrVO> listAllLctre_Date = client.queryForList("selectAllProfsrList2",profarVO, rows[1], rows[0]);
		return listAllLctre_Date;
	}

	@Override
	public int countProfsrList2(ProfsrVO profarVO) throws SQLException{
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("countProfsrList2",profarVO);
		return total_pages;
	}
	@Override
	public String createProfsrNo(ProfsrVO profsrVO) throws SQLException {
		return (String) client.queryForObject("createProfsrNo", profsrVO);
	}
}
