package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_FlpthVO;
import com.uni.fems.dto.Lctre_TaskVO;
import com.uni.fems.dto.Lctre_Task_GntVO;

public interface Lctre_TaskService {

	List<Lctre_TaskVO> listAllLctre_Task(int tpage,
			Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	String pageNumber(int tpage, Lctre_Task_GntVO lctre_Task_Gnt)
			throws SQLException;

	Lctre_TaskVO getLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt)
			throws SQLException;

	Lctre_FlpthVO getLctre_Flpth(String lf_No) throws SQLException;

	void insertLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;

	int updateLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt,
			Lctre_FlpthVO lctre_FlpthVO) throws SQLException;

	int countLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	int deleteLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

}
