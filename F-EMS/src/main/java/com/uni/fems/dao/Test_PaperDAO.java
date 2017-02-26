package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Test_PaperVO;

/**
 * <pre>
 * 온라인 시험 시험지 CRUD를 위한 DAO
 * </pre>
 * @author 송선호
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     SSH                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Test_PaperDAO {

	/**
	 * <pre>
	 * 해당 강의의 시험지 리스트를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param lctre_no
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<Test_PaperVO> listAllTestPapaer(int lctre_no)throws SQLException;
	
	/**
	 * <pre>
	 * 온라인 시험(지)을 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param test_paperVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertTestPaper(Test_PaperVO test_paperVO) throws SQLException;
	
	/**
	 * <pre>
	 * 가장 최근에 생성된 시험지번호를 가져오는 것(test 데이터 추가할 때 사용)
	 * </pre>
	 * <pre>
	 * @param test_paperVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int maxTp_No() throws SQLException;
	
}
