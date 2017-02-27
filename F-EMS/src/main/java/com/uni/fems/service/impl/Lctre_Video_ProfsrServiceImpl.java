package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_FlpthDAO;
import com.uni.fems.dao.Lctre_Video_ProfsrDAO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;
import com.uni.fems.service.Lctre_Video_ProfsrService;

/**
 * <pre>
 * 강의 과제 게시판을 사용하기 위한 서비스
 * </pre>
 * @author KJS
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     kjs                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Lctre_Video_ProfsrServiceImpl implements Lctre_Video_ProfsrService{
	
	private Lctre_Video_ProfsrDAO lctre_Video_ProfsrDAO;
	private Lctre_FlpthDAO lctre_FlpthDAO;
	public void setLctre_Video_ProfsrDAO(Lctre_Video_ProfsrDAO lctre_Video_ProfsrDAO) {
		this.lctre_Video_ProfsrDAO = lctre_Video_ProfsrDAO;
	}
	public void setLctre_FlpthDAO(Lctre_FlpthDAO lctre_FlpthDAO) {
		this.lctre_FlpthDAO = lctre_FlpthDAO;
	}
	
	@Override
	public List<Lctre_VideoVO> listAllLctre_Video(int tpage, Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException {
		int totalRecord = lctre_Video_ProfsrDAO.totalLctre_Video(lctre_Video_Gnt);
		return lctre_Video_ProfsrDAO.listAllLctre_Video(lctre_Video_Gnt, tpage, totalRecord);
		
	}
	@Override
	public String pageNumber(int tpage,Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException {
		int totalRecord = lctre_Video_ProfsrDAO.totalLctre_Video(lctre_Video_Gnt);
		String page = new Paging().pageNumber(tpage,totalRecord,"taskList", "&table_Nm="+lctre_Video_Gnt.getTable_Nm());
		return page;
	}
	@Override
	public Lctre_VideoVO getLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException {
		return lctre_Video_ProfsrDAO.getLctre_Video(lctre_Video_Gnt);
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
	public void insertLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt, Lctre_FlpthVO lctre_FlpthVO) throws SQLException {
		
		if(!(lctre_FlpthVO.getLf_Flpth()==null)){
			lctre_FlpthDAO.insertLctre_Flpth(lctre_FlpthVO);
			int maxNo = lctre_FlpthDAO.maxLctre_Flpth();
			lctre_Video_Gnt.setLv_Flpth_No(maxNo+"");
		}
		lctre_Video_ProfsrDAO.insertLctre_Video(lctre_Video_Gnt);
	}
	@Override
	public int updateLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt, Lctre_FlpthVO lctre_FlpthVO) throws SQLException {
		
		if(!(lctre_FlpthVO.getLf_Flpth()==null)){
			lctre_FlpthDAO.insertLctre_Flpth(lctre_FlpthVO);
			int maxNo = lctre_FlpthDAO.maxLctre_Flpth();
			lctre_Video_Gnt.setLv_Flpth_No(maxNo+"");
		}
		return lctre_Video_ProfsrDAO.updateLctre_Video(lctre_Video_Gnt);
	}
	@Override
	public int deleteLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException {
		lctre_Video_ProfsrDAO.deleteLctre_Video(lctre_Video_Gnt);
			if(lctre_Video_Gnt.getLv_Flpth_No() != null)
			lctre_FlpthDAO.deleteLctre_Flpth_lctre(Integer.parseInt(lctre_Video_Gnt.getLv_Flpth_No()));
		return 0;
	}


}

