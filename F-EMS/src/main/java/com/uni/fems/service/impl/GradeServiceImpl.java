package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.GradeDAO;
import com.uni.fems.dto.GradeVO;
import com.uni.fems.service.GradeService;

public class GradeServiceImpl implements GradeService {
 
	private GradeDAO gradeDAO;
	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}
	@Override
	public void insertGrade(GradeVO gradeVO) throws SQLException {
		gradeDAO.insertGrade(gradeVO);
	}
	@Override
	public void updateGrade(GradeVO gradeVO) throws SQLException {
		gradeDAO.updateGrade(gradeVO);
	}
	@Override
	public List<GradeVO> selectGrade(GradeVO gradeVO) throws SQLException {
		List<GradeVO> list = gradeDAO.selectGrade(gradeVO);
		return list;
	}
	@Override
	public int countGrade(GradeVO gradeVO) throws SQLException {
		int totalRecord = gradeDAO.countGrade(gradeVO);
		return totalRecord;
	}
}


