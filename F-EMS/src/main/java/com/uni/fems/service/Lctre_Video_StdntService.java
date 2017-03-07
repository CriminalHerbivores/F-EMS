package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_Video_GntVO;
import com.uni.fems.dto.Lctre_Watch_Video_GntVO;

public interface Lctre_Video_StdntService {

	List<Lctre_Watch_Video_GntVO> listAllLctre_Video(int tpage,
			Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException;

	String pageNumber(int tpage, Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException;

	Lctre_Watch_Video_GntVO getLctre_Video(
			Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException;

	Lctre_FlpthVO getLctre_Flpth(String lf_No) throws SQLException;

	void insertLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException;

	int updateLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException;
	List<Lctre_Watch_Video_GntVO> lctre_watch_video_gnt(Lctre_Watch_Video_GntVO vo) throws SQLException;
}
