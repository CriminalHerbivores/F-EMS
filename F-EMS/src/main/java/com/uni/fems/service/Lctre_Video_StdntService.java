package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_Watch_Video_GntVO;

public interface Lctre_Video_StdntService {

	List<Lctre_Watch_Video_GntVO> listAllLctre_Video(int tpage,
			Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException;

	String pageNumber(int tpage, Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException;

}
