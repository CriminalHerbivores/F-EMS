package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.GradeDAO;
import com.uni.fems.dao.Intrst_ListDAO;
import com.uni.fems.dao.ReqstDAO;
import com.uni.fems.dto.GradeVO;
import com.uni.fems.dto.Intrst_ListVO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.ReqstVO;
import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.service.ReqstService;

/**
 * <pre>
 * 수강 신청 완료 목록 조회, 추가,삭제하는 DAOImpl
 * </pre>
 * @author KJH
 * @since 2017. 2. 20.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017. 2. 20.    KJH       최초작성
 * 2017. 3. 08.    KJS       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Data
public class ReqstServiceImpl implements ReqstService {
	
	
	private ReqstDAO reqstDAO;
	private GradeDAO gradeDAO;
	
	// 학생의 수강신청 완료 목록
	@Override
	public List<Lctre_SearchVO> selectReqst(String re_Stdnt_No) throws SQLException {
		List<Lctre_SearchVO> lctre_SearchVO= reqstDAO.selectReqst(re_Stdnt_No);
		return lctre_SearchVO;
	}
	
	// 수강 신청 등록
	@Override
	public void insertReqst(ReqstVO reqstVO[]) throws SQLException {
		
		for(int i=0; i<reqstVO.length;i++){
			reqstDAO.insertReqst(reqstVO[i]);
			gradeDAO.insertGrade(reqstVO[i]);
			//reqstDAO.setNumOfStdnt(lctre_SearchVO[i]);	// 수강 신청시 수강중 인원 증가
		}
		
	}
	// 수강신청시 인원수 증가
	@Override
	public void insertReqstNum(Lctre_SearchVO[] lctre_SearchVO) throws SQLException{
		
		for(int i=0; i<lctre_SearchVO.length;i++){
			reqstDAO.setNumOfStdnt(lctre_SearchVO[i]);	// 수강 신청시 수강중 인원 증가
		}
		
	}
	
	// 수강 신청 삭제
	@Override
	public void deleteReqst(ReqstVO reqstVO[]) throws SQLException {
		for(int i=0; i<reqstVO.length;i++){
			reqstDAO.deleteReqst(reqstVO[i]);
			gradeDAO.deleteGrade(reqstVO[i]);
		}
	}
	
	@Override
	public void deleteReqstNum(Lctre_SearchVO[] lctre_SearchVO) throws SQLException{
		for(int i=0; i<lctre_SearchVO.length;i++){
			reqstDAO.setNumOfStdnt(lctre_SearchVO[i]);	// 수강 취소시 수강중 인원 감소
		}
		
	}

	// 학생의 개설학기내 수강신청완료한 학점들의 총합
	@Override
	public int getSumReqst(ReqstVO reqstVO) throws SQLException {
		int sum=reqstDAO.getSumReqst(reqstVO);
		return sum;
		
	}
	
	// 한 강의의 강의실 수용 인원
	@Override
	public int acceptNumOfStdnt(String lc_Lctre_No) throws SQLException {
		int lctrumNum = reqstDAO.acceptNumOfStdnt(lc_Lctre_No);
		return lctrumNum;
	}
	
	// 한 강의를 수강중인 학생 수
	@Override
	public int stdntNumOfLctre(String re_Lctre_No) throws SQLException {
		int lctreStdntNum = reqstDAO.stdntNumOfLctre(re_Lctre_No);
		return lctreStdntNum;
	}
	
	
	//----------------------------------------------------------------------------------
	
	@Override
	public List<Lctre_SearchVO> selectEvl_Scope(int tpage, Lctre_SearchVO lctre_Search) throws SQLException {
		int totalRecord = reqstDAO.totalEvl_Scope(lctre_Search);
		return reqstDAO.selectEvl_Scope(lctre_Search,tpage, totalRecord);
		
	}
	
	@Override
	public String pageNumberEvl_Scope(int tpage,Lctre_SearchVO lctre_Search) throws SQLException {
		int totalRecord = reqstDAO.totalEvl_Scope(lctre_Search);
		String page = new Paging().pageNumber(tpage,totalRecord,"sknrgListForm", "");
		return page;
	}
	
	@Override
	public Lctre_SearchVO getEvl_Scope(Lctre_SearchVO lctre_Search) throws SQLException {
		return reqstDAO.getEvl_Scope(lctre_Search);
	}
	@Override	
	public void updateEvl_Scope(Lctre_SearchVO lctre_Search) throws SQLException{
		reqstDAO.updateEvl_Scope(lctre_Search);
	}

}
