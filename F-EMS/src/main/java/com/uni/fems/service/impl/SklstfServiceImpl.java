package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import lombok.Data;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.SklstfDAO;
import com.uni.fems.dao.Sklstf_AtrtyDAO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.Sklstf_AtrtyVO;
import com.uni.fems.dto.UserSubjctVO;
import com.uni.fems.service.SklstfService;

/**
 * <pre>
 * 직원과 관련된 Service를 구현
 * </pre>
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * 2017.02.22.    KJH       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Data
public class SklstfServiceImpl implements SklstfService {
 
	private SklstfDAO sklstfDAO;
	private Sklstf_AtrtyDAO sklstf_AtrtyDAO; 
	
	
	@Override
	public SklstfVO getSklstf(String stf_Sklstf_No) throws SQLException {
		SklstfVO sklstfVo = sklstfDAO.getSklstf(stf_Sklstf_No); 
		return sklstfVo;
	}
	
	// 관리자가 전체 직원 목록 조회
//	@Override
//	public List<UserSubjctVO> listSklstf(String stf_Nm) throws SQLException {
//		
//		return null;
//	}

	// 관리자가 직원 등록
	@Override
	public void insertSklstf(SklstfVO sklstfVo, Sklstf_AtrtyVO sklstf_AtrtyVO) throws SQLException {
		sklstfDAO.insertSklstf(sklstfVo);
		sklstf_AtrtyDAO.insertSklstf_Atrty(sklstf_AtrtyVO);
	}
	
	// 관리자가 직원 정보 수정
		@Override
		public void updateSklstf(SklstfVO sklstfVo) throws SQLException {
			sklstfDAO.updateSklstf(sklstfVo);
		}
	
	// 관리자가 직원 정보와 권한 수정
	@Override
	public void updateSklstf_Atrty(SklstfVO sklstfVo, Sklstf_AtrtyVO sklstf_AtrtyVO) throws SQLException {
		sklstfDAO.updateSklstf(sklstfVo);
		sklstf_AtrtyDAO.updateSklstf_Atrty(sklstf_AtrtyVO);
	}

	//=============================================================
	
	// 전체 직원의 목록 조회
	@Override
	public List<UserSubjctVO> listAllSklstf(int tpage, SearchVO searchVO) throws SQLException {
		System.out.println("===================================== 2-2");
		int totalRecord = sklstfDAO.totalSklstf(searchVO);
		return sklstfDAO.listAllSklstf(searchVO,tpage, totalRecord);
	}
	
	// 직원목록 조회 페이지 설정
	@Override
	public String pageNumber(int tpage,SearchVO searchVO) throws SQLException {
		System.out.println("===================================== 2-1");
		int totalRecord = sklstfDAO.totalSklstf(searchVO);
		String page = new Paging().pageNumber(tpage,totalRecord,"sklstfList", "&key="+searchVO.getKey()+"&value="+searchVO.getValue());
		return page;
	}
	

}


