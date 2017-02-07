package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.ProfsrDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.ProfsrVO;

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
}
