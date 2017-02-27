package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.common.Paging;
import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dto.StdntVO;

public class StdntDAOImpl implements StdntDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void insertStdnt(StdntVO stdntVO) throws SQLException {
		client.update("insertStdnt", stdntVO);
	}

	@Override
	public int totalRecord(String st_Nm) throws SQLException {
		int totalRecord = 0;
		if (st_Nm.equals("")) {
			st_Nm = "%";
		}
		totalRecord = (Integer) client.queryForObject("totalStdnt", st_Nm);
		return totalRecord;
	}

	@Override
	public List<StdntVO> selectNameAllPage(int tpage, int totalRecord,
			String st_Nm) throws SQLException {
		List<StdntVO> list = null;
		Paging p = new Paging();
		st_Nm = p.key(st_Nm);

		int[] rows = p.row(tpage, totalRecord);
		list = (ArrayList<StdntVO>) client.queryForList("selectAllStdntPage", st_Nm, rows[1], rows[0]);
		return list;
	}

	@Override
	public StdntVO selectStdnt(String st_Stdnt_No) throws SQLException {
		StdntVO stdntVO = (StdntVO) client.queryForObject("selectStdnt", st_Stdnt_No);
		return stdntVO;
	}

	@Override
	public void updateStdnt(StdntVO stdntVO) throws SQLException {
		client.update("updateStdnt", stdntVO);
	}

	@Override
	public void registBrhs(StdntVO stdntVO) throws SQLException {
		client.update("updateBrhs", stdntVO);
	}

	@Override
	public void updatePw(StdntVO stdntVO) throws SQLException {
		client.update("updatePwStdnt",stdntVO);
	}

	@Override
	public ArrayList<StdntVO> subjctStdnt(String st_Subjct_Code) throws SQLException {
		ArrayList<StdntVO> list = (ArrayList<StdntVO>) client.queryForList("subjctStdnt",st_Subjct_Code);
		return list;
	}

	@Override
	public ArrayList<StdntVO> selectStdntList(StdntVO stdntVO, int start, int count) throws SQLException {
		ArrayList<StdntVO> list = (ArrayList<StdntVO>) client.queryForList("selectStdntList",stdntVO, start, count);
		return list;
	}

	@Override
	public int countStdntList(StdntVO stdntVO) throws SQLException {
		int totalRecord = (int) client.queryForObject("countStdntList",stdntVO);
		return totalRecord;
	}
}
