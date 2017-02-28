package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Lctre_FlpthDAO;
import com.uni.fems.dao.Lctre_Video_ProfsrDAO;
import com.uni.fems.dao.Lctre_Video_StdntDAO;
import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;
import com.uni.fems.dto.Lctre_Watch_Video_GntVO;
import com.uni.fems.service.Lctre_Video_ProfsrService;
import com.uni.fems.service.Lctre_Video_StdntService;

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

public class Lctre_Video_StdntServiceImpl implements Lctre_Video_StdntService{
	
	private Lctre_Video_StdntDAO lctre_Video_StdntDAO;
	private Lctre_FlpthDAO lctre_FlpthDAO;
	public void setLctre_Video_StdntDAO(Lctre_Video_StdntDAO lctre_Video_StdntDAO) {
		this.lctre_Video_StdntDAO = lctre_Video_StdntDAO;
	}
	public void setLctre_FlpthDAO(Lctre_FlpthDAO lctre_FlpthDAO) {
		this.lctre_FlpthDAO = lctre_FlpthDAO;
	}
	
	@Override
	public List<Lctre_Watch_Video_GntVO> listAllLctre_Video(int tpage, Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException {
		int totalRecord = lctre_Video_StdntDAO.totalLctre_Video(lctre_Watch_Video_Gnt);
		return lctre_Video_StdntDAO.listAllLctre_Video(lctre_Watch_Video_Gnt, tpage, totalRecord);
		
	}
	@Override
	public String pageNumber(int tpage,Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException {
		int totalRecord = lctre_Video_StdntDAO.totalLctre_Video(lctre_Watch_Video_Gnt);
		String page = new Paging().pageNumber(tpage,totalRecord,"taskList", "&table_Nm="+lctre_Watch_Video_Gnt.getTable_Nm());
		return page;
	}
	

}

