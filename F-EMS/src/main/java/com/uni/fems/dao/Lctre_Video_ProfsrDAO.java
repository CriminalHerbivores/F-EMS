package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_VideoVO;
import com.uni.fems.dto.Lctre_Video_GntVO;

public interface Lctre_Video_ProfsrDAO {

	List<Lctre_VideoVO> listAllLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt,
			int tpage, int totalRecord) throws SQLException;

	int totalLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt) throws SQLException;

	Lctre_VideoVO getLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	int insertLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	int updateLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

	int deleteLctre_Video(Lctre_Video_GntVO lctre_Video_Gnt)
			throws SQLException;

}
