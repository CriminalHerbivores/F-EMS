package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_TaskVO;
import com.uni.fems.dto.Lctre_Task_GntVO;

public interface Lctre_TaskDAO {

	List<Lctre_TaskVO> listAllLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt,
			int tpage, int totalRecord) throws SQLException;

	int totalLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	Lctre_TaskVO getLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt)
			throws SQLException;

	int insertLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	int updateLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	int countLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

	int deleteLctre_Task(Lctre_Task_GntVO lctre_Task_Gnt) throws SQLException;

}
