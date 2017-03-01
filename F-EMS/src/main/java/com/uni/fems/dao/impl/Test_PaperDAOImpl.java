package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Test_PaperDAO;
import com.uni.fems.dto.Test_PaperVO;
/**
 * <pre>
 * 온라인 시험 시험지 CRUD를 위한 DAOImpl
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
public class Test_PaperDAOImpl implements Test_PaperDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<Test_PaperVO> listAllTestPapaer(int lctre_no)
			throws SQLException {
		
		return client.queryForList("listAllTestPaper", lctre_no);
	}
	@Override
	public int insertTestPaper(Test_PaperVO test_paperVO) throws SQLException {
		
		return client.update("insertTestPaper", test_paperVO);
	}
	
	@Override
	public int maxTp_No() throws SQLException {
		
		return (int) client.queryForObject("maxTp_No");
	}
	@Override
	public int updateTestPaper(Test_PaperVO test_paperVO) throws SQLException {
		return client.update("updateTestPaper", test_paperVO);
	}
	@Override
	public int deleteTestPaper(int tpNo) throws SQLException {
		return client.update("deleteTestPaper", tpNo);
	}
	@Override
	public Test_PaperVO getTestPaper(int tpNo) throws SQLException {
		return (Test_PaperVO) client.queryForObject("getTestPaper", tpNo);
	}
	
}
