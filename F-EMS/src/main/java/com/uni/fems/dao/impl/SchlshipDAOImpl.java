package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.SchlshipDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.dto.SchlshipVO;

public class SchlshipDAOImpl implements SchlshipDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<Schafs_SchdulVO> listAllSchafs_Schdul() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertSchlship(SchlshipVO schlshipVO) throws SQLException {
		client.update("insertSchlship", schlshipVO);
	}

	@Override
	public int totalRecord(String ss_Schlship_Nm) throws SQLException {
		int totalRecord = 0;
		System.out.println("33333333333333333");
		if (ss_Schlship_Nm.equals("")) {
			ss_Schlship_Nm = "%";
		}
		totalRecord = (Integer) client.queryForObject("totalSchlship", ss_Schlship_Nm);
		System.out.println(" totalRecord : "+totalRecord);
		return totalRecord;
	}

	@Override
	public List<SchlshipVO> selectNameAllPage(int tpage, int totalRecord,
			String ss_Schlship_Nm) throws SQLException {
		System.out.println("222222222222");
		List<SchlshipVO> list = null;
		Paging p = new Paging();
		ss_Schlship_Nm = p.key(ss_Schlship_Nm);

		int[] rows = p.row(tpage, totalRecord);
		System.out.println("4444444444444");
		list = (ArrayList<SchlshipVO>) client.queryForList("selectAllSchlshipPage", ss_Schlship_Nm, rows[1], rows[0]);
		System.out.println("list : "+list);
		return list;
	}

	@Override
	public SchlshipVO selectSchlship(String ss_Schlship_Code) throws SQLException {
		SchlshipVO schlshipVO = (SchlshipVO) client.queryForObject("selectSchlship", ss_Schlship_Code);
		return schlshipVO;
	}

	@Override
	public void updateSchlship(SchlshipVO schlshipVO) throws SQLException {
		client.update("updateSchlship", schlshipVO);
	}
	
}
