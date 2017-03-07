package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Lctre_Watch_Video_GntVO;

public interface Lctre_Video_StdntDAO {

	List<Lctre_Watch_Video_GntVO> listAllLctre_Video(
			Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt, int tpage,
			int totalRecord) throws SQLException;

	int totalLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException;

	Lctre_Watch_Video_GntVO getLctre_Video(
			Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt) throws SQLException;

	int insertLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException;

	int updateLctre_Video(Lctre_Watch_Video_GntVO lctre_Watch_Video_Gnt)
			throws SQLException;
	
	List<Lctre_Watch_Video_GntVO> lctre_watch_video_gnt(Lctre_Watch_Video_GntVO vo) throws SQLException;
	
	/**
	 * <pre>
	 * 출석률 가져오기
	 * </pre>
	 * <pre>
	 * @param vo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	Lctre_Watch_Video_GntVO attendance(Lctre_Watch_Video_GntVO vo) throws SQLException;
}
