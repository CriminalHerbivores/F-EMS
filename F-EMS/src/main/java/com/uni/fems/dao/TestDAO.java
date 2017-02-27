package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.TestVO;

/**
 * <pre>
 * 시험문제 CRUD를 위한 DAO
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
public interface TestDAO {
	
	/**
	 * <pre>
	 * 해당 시험의 문제를 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param tp_no
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<TestVO> listAllTest(int tp_no)throws SQLException;
	
	/**
	 * <pre>
	 * 해당 시험의 시험문제를 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param testVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertTest(TestVO testVO)throws SQLException;
	
	/**
	 * <pre>
	 * 시험 문제를 수정하는 메서드
	 * </pre>
	 * <pre>
	 * @param testVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int updateTest(TestVO testVO)throws SQLException;
	
	/**
	 * <pre>
	 * 시험 문제를 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param queNo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteTest(int queNo) throws SQLException;
	
	
	/**
	 * <pre>
	 * 시험지를 지우기 위해 시험문제를 먼저 지우는 메서드
	 * </pre>
	 * <pre>
	 * @param tpNo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteTestForTestPaper(int tpNo) throws SQLException;

}
