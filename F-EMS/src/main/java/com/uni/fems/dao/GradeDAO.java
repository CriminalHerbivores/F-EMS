package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.GradeVO;

public interface GradeDAO {
	void insertGrade(GradeVO gradeVO) throws SQLException;
	void updateGrade(GradeVO gradeVO) throws SQLException;
	List<GradeVO> selectGrade(GradeVO gradeVO) throws SQLException;
	int countGrade(GradeVO gradeVO) throws SQLException;
}
