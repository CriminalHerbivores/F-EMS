package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.TestDAO;
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
public class TestDAOImpl implements TestDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<TestVO> listAllTest(int tp_no) throws SQLException {
		return client.queryForList("listAllTest", tp_no);
	}
	@Override
	public int insertTest(TestVO testVO) throws SQLException {
		
		return client.update("insertTest", testVO);
	}
	@Override
	public int updateTest(TestVO testVO) throws SQLException {
		return client.update("updateTest",testVO);
	}
	@Override
	public int deleteTest(int queNo) throws SQLException {
		return client.update("deleteTest",queNo);
	}
	@Override
	public int deleteTestForTestPaper(int tpNo) throws SQLException {
		return client.update("deleteTestForTestPaper", tpNo);
	}
	
}
