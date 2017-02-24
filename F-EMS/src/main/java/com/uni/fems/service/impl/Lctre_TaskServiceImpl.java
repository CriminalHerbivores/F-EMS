package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_FlpthDAO;
import com.uni.fems.dao.Lctre_TaskDAO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_TaskVO;
import com.uni.fems.dto.Lctre_Task_GntVO;
import com.uni.fems.service.Lctre_TaskService;

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

public class Lctre_TaskServiceImpl implements Lctre_TaskService{
	
	private Lctre_TaskDAO lctre_TaskDAO;
	private Lctre_FlpthDAO lctre_FlpthDAO;
	public void setLctre_TaskDAO(Lctre_TaskDAO lctre_TaskDAO) {
		this.lctre_TaskDAO = lctre_TaskDAO;
	}
	public void setLctre_FlpthDAO(Lctre_FlpthDAO lctre_FlpthDAO) {
		this.lctre_FlpthDAO = lctre_FlpthDAO;
	}
	
	@Override
	public List<Lctre_TaskVO> listAllLctre_Task(int tpage, Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException {
		int totalRecord = lctre_TaskDAO.totalLctre_Task(lctre_Task_Gnt);
		return lctre_TaskDAO.listAllLctre_Task(lctre_Task_Gnt, tpage, totalRecord);
		
	}
	@Override
	public String pageNumber(int tpage,Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException {
		int totalRecord = lctre_TaskDAO.totalLctre_Task(lctre_Task_Gnt);
		String page = new Paging().pageNumber(tpage,totalRecord,"taskList", "&table_Nm="+lctre_Task_Gnt.getTable_Nm());
		return page;
	}
	@Override
	public Lctre_TaskVO getLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException {
		return lctre_TaskDAO.getLctre_Task(lctre_Task_Gnt);
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
	public void insertLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt, Lctre_FlpthVO lctre_FlpthVO) throws SQLException {
		
		if(!(lctre_FlpthVO.getLf_Flpth()==null)){
			lctre_FlpthDAO.insertLctre_Flpth(lctre_FlpthVO);
			int maxNo = lctre_FlpthDAO.maxLctre_Flpth();
			lctre_Task_Gnt.setLt_Flpth_No(maxNo+"");
		}
		lctre_TaskDAO.insertLctre_Task(lctre_Task_Gnt);
	}
	@Override
	public int updateLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt, Lctre_FlpthVO lctre_FlpthVO) throws SQLException {
		
		if(!(lctre_FlpthVO.getLf_Flpth()==null)){
			lctre_FlpthDAO.insertLctre_Flpth(lctre_FlpthVO);
			int maxNo = lctre_FlpthDAO.maxLctre_Flpth();
			lctre_Task_Gnt.setLt_Flpth_No(maxNo+"");
		}
		return lctre_TaskDAO.updateLctre_Task(lctre_Task_Gnt);
	}
	@Override
	public int deleteLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException {
			lctre_TaskDAO.deleteLctre_Task(lctre_Task_Gnt);
			if(lctre_Task_Gnt.getLt_Flpth_No() != null)
			lctre_FlpthDAO.deleteLctre_Flpth_lctre(Integer.parseInt(lctre_Task_Gnt.getLt_Flpth_No()));
		return 0;
	}


}

