package com.uni.fems.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.uni.fems.dto.Schafs_SchdulVO;

/**
 * <pre>
 * 학사일정 CRUD를 위한 DAO
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
public interface Schafs_SchdulDAO {

	/**<pre>
	 * 학사일정을 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param schdulVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertSchdul(Schafs_SchdulVO schdulVO)throws SQLException;
	
	
	
	
}
