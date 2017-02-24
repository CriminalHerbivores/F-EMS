package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

import com.uni.fems.dao.Intrst_ListDAO;
import com.uni.fems.dao.ReqstDAO;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.service.ReqstService;

@Data
public class ReqstServiceImpl implements ReqstService {
	
	private ReqstDAO reqstDAO;
	
	// 학생의 수강신청 완료 목록
	@Override
	public List<Lctre_SearchVO> selectReqst(String re_Stdnt_No) throws SQLException {
		List<Lctre_SearchVO> lctre_SearchVO= reqstDAO.selectReqst(re_Stdnt_No);
		return lctre_SearchVO;
	}
	
	// 수강 신청 등록
	@Override
	public void insertReqst(ReqstVO reqstVO) throws SQLException {
		reqstDAO.insertReqst(reqstVO);
	}
	
	// 수강 신청 삭제
	@Override
	public void deleteReqst(ReqstVO reqstVO) throws SQLException {
		reqstDAO.deleteReqst(reqstVO);
	}

}
