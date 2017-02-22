package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.SchlshipDAO;
import com.uni.fems.dto.PymntVO;
import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.dto.SchlshipVO;

public class SchlshipDAOImpl implements SchlshipDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<Schafs_SchdulVO> listAllSchafs_Schdul() throws SQLException {
		return null;
	}
	
	@Override
	public void insertSchlship(SchlshipVO schlshipVO) throws SQLException {
		client.update("insertSchlship", schlshipVO);
	}

	@Override
	public int totalRecord(String ss_Schlship_Nm) throws SQLException {
		int totalRecord = 0;
		if (ss_Schlship_Nm.equals("")) {
			ss_Schlship_Nm = "%";
		}
		totalRecord = (Integer) client.queryForObject("totalSchlship", ss_Schlship_Nm);
		return totalRecord;
	}

	@Override
	public List<SchlshipVO> selectNameAllPage(int tpage, int totalRecord,
			String ss_Schlship_Nm) throws SQLException {
		List<SchlshipVO> list = null;
		Paging p = new Paging();
		ss_Schlship_Nm = p.key(ss_Schlship_Nm);

		int[] rows = p.row(tpage, totalRecord);
		list = (ArrayList<SchlshipVO>) client.queryForList("selectAllSchlshipPage", ss_Schlship_Nm, rows[1], rows[0]);
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
	@Override
	public void deleteSchlship(SchlshipVO schlshipVO) throws SQLException {
		client.update("deleteSchlship", schlshipVO);
	}
	@Override
	public void requestschlship(PymntVO pymntVO) throws SQLException {
		client.update("requestSchlship", pymntVO);
	}
	@Override
	public List<SchlshipVO> selectAllSchlship() throws SQLException {
		List<SchlshipVO> list = null;
		list = (ArrayList<SchlshipVO>) client.queryForList("selectAllSchlship");
		return list;
	}
	@Override
	public List<SchlshipVO> selectSchlshipByStdnt(String loginUser)
			throws SQLException {
		List<SchlshipVO> list = null;
		list = (ArrayList<SchlshipVO>) client.queryForList("selectSchlshipByStdnt",loginUser);
		return list;
	}
	
}
