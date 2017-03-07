package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uni.fems.dao.GradeDAO;
import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.service.GradeService;

public class GradeServiceImpl implements GradeService {
 
	private GradeDAO gradeDAO;
	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}
	@Autowired
	private LctreDAO lctreDAO;
	
	@Override
	public void insertGrade(ReqstVO reqstVO) throws SQLException {
		gradeDAO.insertGrade(reqstVO);
		
	}
	@Override
	public void deleteGrade(ReqstVO reqstVO) throws SQLException {
		gradeDAO.deleteGrade(reqstVO);
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
	
	@Override
	public List<GradeVO> lctreGrade(GradeVO grade) throws SQLException {
		List<GradeVO> list = gradeDAO.lctreGrade(grade);
		return list;
	}
	@Override
	public GradeVO totalGrade(String gd_Stdnt_No) throws SQLException {
		GradeVO vo = gradeDAO.totalGrade(gd_Stdnt_No);
		return vo;
	}
	@Override
	public void updateOneGrade(GradeVO gradeVO) throws SQLException {
		gradeDAO.updateOneGrade(gradeVO);
	}
}


