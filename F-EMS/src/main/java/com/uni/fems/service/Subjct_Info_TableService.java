package com.uni.fems.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.uni.fems.dto.UserSubjctVO;

/**
 * <pre>
 * 학과 관련 사항을 처리하는 Service
 * </pre>
 * @author KJH
 * @since 2017. 02. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017.02.22.    KJH           최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Subjct_Info_TableService {

	/**
	 * <pre>
	 * 사용자가 학과명으로 학과 찾기
	 * </pre>
	 * <pre>
	 * @param sit_Subjct
	 * @return
	 * @throws SQLException
	 */
	ArrayList<UserSubjctVO> selectSubjctByName(String sit_Subjct) throws SQLException;

}
