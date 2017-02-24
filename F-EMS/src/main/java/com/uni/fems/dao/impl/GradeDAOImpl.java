package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.GradeDAO;
import com.uni.fems.dto.GradeVO;

public class GradeDAOImpl implements GradeDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public void insertGrade(GradeVO gradeVO) throws SQLException {
		client.update("insertGrade", gradeVO);
	}
	@Override
	public void updateGrade(GradeVO gradeVO) throws SQLException {
		client.update("updateGrade", gradeVO);
	}
	@Override
	public List<GradeVO> selectGrade(GradeVO gradeVO) throws SQLException {
		List<GradeVO> list = client.queryForList("selectGrade",gradeVO);
		return list;
	}
	@Override
	public int countGrade(GradeVO gradeVO) throws SQLException {
		int totalRecord = (int) client.queryForObject("gradeVO",gradeVO);
		return totalRecord;
	}
}
