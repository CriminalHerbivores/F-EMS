package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Profsr_Subjct_AsnmDAO;
import com.uni.fems.dto.Profsr_Subjct_AsnmVO;
import com.uni.fems.service.Profsr_Subjct_AsnmService;

public class Profsr_Subjct_AsnmServiceImpl implements Profsr_Subjct_AsnmService {

	private Profsr_Subjct_AsnmDAO profsr_Subjct_AsnmDAO;
	public void setProfsr_Subjct_AsnmDAO(
			Profsr_Subjct_AsnmDAO profsr_Subjct_AsnmDAO) {
		this.profsr_Subjct_AsnmDAO = profsr_Subjct_AsnmDAO;
	}
	@Override
	public void insertProfsr_Subjct_Asnm(Profsr_Subjct_AsnmVO asnmVO)
			throws SQLException {
		profsr_Subjct_AsnmDAO.insertProfsr_Subjct_Asnm(asnmVO);
	}
	@Override
	public void updateProfsr_Subjct_Asnm(Profsr_Subjct_AsnmVO asnmVO)
			throws SQLException {
		profsr_Subjct_AsnmDAO.updateProfsr_Subjct_Asnm(asnmVO);
	}
	@Override
	public List<Profsr_Subjct_AsnmVO> selectProfsr_Subjct_Asnm(
			Profsr_Subjct_AsnmVO asnmVO) throws SQLException {
		List<Profsr_Subjct_AsnmVO> list = profsr_Subjct_AsnmDAO.selectProfsr_Subjct_Asnm(asnmVO);
		return list;
	}

}
