package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_FlpthDAO;
import com.uni.fems.dao.Lctre_DateDAO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_DateVO;
import com.uni.fems.dto.Lctre_Date_GntVO;
import com.uni.fems.service.Lctre_DateService;

/**
 * <pre>
 * 게시판을 사용하기 위한 서비스
 * </pre>
 * @author KJS
 * @since 2017.02.23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.23     kjs                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Lctre_DateServiceImpl implements Lctre_DateService{
	
	private Lctre_DateDAO lctre_DateDAO;
	private Lctre_FlpthDAO lctre_FlpthDAO;
	public void setLctre_DateDAO(Lctre_DateDAO lctre_DateDAO) {
		this.lctre_DateDAO = lctre_DateDAO;
	}
	public void setLctre_FlpthDAO(Lctre_FlpthDAO lctre_FlpthDAO) {
		this.lctre_FlpthDAO = lctre_FlpthDAO;
	}
	
	@Override
	public List<Lctre_DateVO> listAllLctre_Date(int tpage, Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		int totalRecord = lctre_DateDAO.totalLctre_Date(lctre_Date_Gnt);
		return lctre_DateDAO.listAllLctre_Date(lctre_Date_Gnt, tpage, totalRecord);
		
	}
	@Override
	public String pageNumber(int tpage,Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		int totalRecord = lctre_DateDAO.totalLctre_Date(lctre_Date_Gnt);
		String page = new Paging().pageNumber(tpage,totalRecord,"dateList", "&table_Nm="+lctre_Date_Gnt.getTable_Nm());
		return page;
	}
	@Override
	public Lctre_DateVO getLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		return lctre_DateDAO.getLctre_Date(lctre_Date_Gnt);
	}
	@Override
	public Lctre_FlpthVO getLctre_Flpth(String lf_No)
			throws SQLException {
		Lctre_FlpthVO lctre_Flpth;
		if(lf_No == null)
			lctre_Flpth = null;
		else{ 
			lctre_Flpth = lctre_FlpthDAO.getLctre_Flpth(Integer.parseInt(lf_No));
		}
		return lctre_Flpth;
	}
	@Override
	public void insertLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt, Lctre_FlpthVO lctre_FlpthVO) throws SQLException {
		
		if(!(lctre_FlpthVO.getLf_Flpth()==null)){
			lctre_FlpthDAO.insertLctre_Flpth(lctre_FlpthVO);
			int maxNo = lctre_FlpthDAO.maxLctre_Flpth();
			lctre_Date_Gnt.setLd_Flpth_No(maxNo+"");
		}
		lctre_DateDAO.insertLctre_Date(lctre_Date_Gnt);
	}
	@Override
	public int updateLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt, Lctre_FlpthVO lctre_FlpthVO) throws SQLException {
		
		if(!(lctre_FlpthVO.getLf_Flpth()==null)){
			lctre_FlpthDAO.insertLctre_Flpth(lctre_FlpthVO);
			int maxNo = lctre_FlpthDAO.maxLctre_Flpth();
			lctre_Date_Gnt.setLd_Flpth_No(maxNo+"");
		}
		return lctre_DateDAO.updateLctre_Date(lctre_Date_Gnt);
	}
	@Override
	public int countLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
		return lctre_DateDAO.countLctre_Date(lctre_Date_Gnt);
	}
	@Override
	public int deleteLctre_Date(Lctre_Date_GntVO lctre_Date_Gnt) throws SQLException {
			lctre_DateDAO.deleteLctre_Date(lctre_Date_Gnt);
			if(lctre_Date_Gnt.getLd_Flpth_No() != null)
			lctre_FlpthDAO.deleteLctre_Flpth_lctre(Integer.parseInt(lctre_Date_Gnt.getLd_Flpth_No()));
		return 0;
	}


}

