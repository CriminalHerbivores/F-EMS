package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Schafs_SchdulVO;
/**
 * <pre>
 * 학사일정 CRUD를 위한 Service
 * </pre>
 * @author 송선호
 * @since 2017.02.19
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.19     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Schafs_SchdulService {
	/**<pre>
	 * 학사일정을 추가하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param schdulVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertSchdul(Schafs_SchdulVO schdulVO)throws SQLException;
	/**
	 * <pre>
	 * 학사일정 월별 리스트를 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param monthNo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<Schafs_SchdulVO> listSchdul(int monthNo)throws SQLException;
	/**
	 * <pre>
	 * 일정 하나를 수정하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param schdulVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int updateSchdul(Schafs_SchdulVO schdulVO)throws SQLException;
	
	/**
	 * <pre>
	 * 일정 하나를 삭제하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param sd_no
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteSchdul(int sd_no)throws SQLException;
}
