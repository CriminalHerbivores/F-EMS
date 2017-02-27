package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.TestDAO;
import com.uni.fems.dao.Test_PaperDAO;
import com.uni.fems.dto.TestVO;
import com.uni.fems.service.TestService;
/**
 * <pre>
 * 시험문제 CRUD를 위한 ServiceImpl
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
public class TestServiceImpl implements TestService {
 
 private TestDAO testDAO;
 
 public void setTestDAO(TestDAO testDAO){
  this.testDAO=testDAO;
 }
 
 private Test_PaperDAO test_PaperDAO; 
public void setTest_PaperDAO(Test_PaperDAO test_PaperDAO) {
	this.test_PaperDAO = test_PaperDAO;
}


@Override
public List<TestVO> listAllTest(int tp_no) throws SQLException {
	return testDAO.listAllTest(tp_no);
}
@Override
public int insertTest(TestVO testVO) throws SQLException {
	testVO.setTe_Tp_No(Integer.toString(test_PaperDAO.maxTp_No()));
	return testDAO.insertTest(testVO);
}


@Override
public int updateTest(TestVO testVO) throws SQLException {
	return testDAO.updateTest(testVO);
}


@Override
public int deleteTest(int queNo) throws SQLException {
	return testDAO.deleteTest(queNo);
}
 
 
}


