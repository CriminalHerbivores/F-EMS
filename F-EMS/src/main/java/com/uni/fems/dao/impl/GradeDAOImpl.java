package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.GradeDAO;
import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.ReqstVO;

public class GradeDAOImpl implements GradeDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public void insertGrade(ReqstVO reqstVO) throws SQLException {
		client.update("insertGrade", reqstVO);
	}
	@Override
	public void deleteGrade(ReqstVO reqstVO) throws SQLException {
		client.delete("deleteGrade",reqstVO);
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
	@Override
	public List<GradeVO> lctreGrade(GradeVO grade) throws SQLException {
		List<GradeVO> list = client.queryForList("lctreGrade",grade);
		return list;
	}
}
