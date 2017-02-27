package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;

public interface Lctre_Video_ProfsrService {

	List<Lctre_VideoVO> listAllLctre_Video(int tpage,
			Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException;

	String pageNumber(int tpage, Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	Lctre_VideoVO getLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	Lctre_FlpthVO getLctre_Flpth(String lf_No) throws SQLException;

	void insertLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;

	int updateLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;

	int deleteLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

}
