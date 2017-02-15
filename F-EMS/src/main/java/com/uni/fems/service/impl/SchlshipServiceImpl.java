package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.SchlshipDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.service.SchlshipService;

/**
 * <pre>
 * 등록금과 관련된 Service를 구현
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
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class SchlshipServiceImpl implements SchlshipService {

	private SchlshipDAO schlshipDAO;
	public void setSchlshipDAO(SchlshipDAO schlshipDAO) {
		this.schlshipDAO = schlshipDAO;
	}

	@Override
	public void insertSchlship(SchlshipVO schlshipVO) throws SQLException {
		schlshipDAO.insertSchlship(schlshipVO);
	}

	@Override
	public List<SchlshipVO> selectNameAllPage(int tpage, String ss_Schlship_Nm)
			throws SQLException {
		int totalRecord = schlshipDAO.totalRecord(ss_Schlship_Nm);
		List<SchlshipVO> list = schlshipDAO.selectNameAllPage(tpage, totalRecord,
				ss_Schlship_Nm);
		return list;
	}

	@Override
	public String pageNumber(int tpage, String ss_Schlship_Nm) throws SQLException {
		int totalRecord = schlshipDAO.totalRecord(ss_Schlship_Nm);
		String page = new Paging().pageNumber(tpage, totalRecord, "schlshipList",
				"&key=" + ss_Schlship_Nm);
		return page;
	}

	@Override
	public SchlshipVO selectSchlship(String ss_Schlship_Code) throws SQLException {
		SchlshipVO schlshipVO = schlshipDAO.selectSchlship(ss_Schlship_Code);
		return schlshipVO;
	}

	@Override
	public void updateSchlship(SchlshipVO schlshipVO) throws SQLException {
		schlshipDAO.updateSchlship(schlshipVO);
	}

}
