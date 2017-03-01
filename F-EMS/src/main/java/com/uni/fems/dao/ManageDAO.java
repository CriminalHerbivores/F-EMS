package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.ManageVO;

/**
 * <pre>
 * 대학관리 테이블에 조회, 등록, 수정이 가능한 DAO
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * 2017.02.15      KJH            추가작성 
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface ManageDAO {
	
	/**
	 * <pre>
	 * 대학이름과 일치하는 하나의 대학정보 가져오기
	 * </pre>
	 * <pre>
	 * @param mng_Univ_Nm
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	ManageVO getManage() throws SQLException;
	/**
	 * <pre>
	 * 게시판 리스트를 가져옴
	 * </pre>
	 * <pre>
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<Bbs_ListVO> getBbsList() throws SQLException;

}
