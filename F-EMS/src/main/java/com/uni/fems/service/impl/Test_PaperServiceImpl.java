package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Test_PaperDAO;
import com.uni.fems.dto.Test_PaperVO;
import com.uni.fems.service.Test_PaperService;
/**
 * <pre>
 * 온라인 시험 시험지 CRUD를 위한 ServiceImpl
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
public class Test_PaperServiceImpl implements Test_PaperService {
 
 private Test_PaperDAO test_PaperDAO;
 public void setTest_PaperDAO(Test_PaperDAO test_PaperDAO){
  this.test_PaperDAO=test_PaperDAO;
 }
@Override
public List<Test_PaperVO> listAllTestPapaer(int lctre_no) throws SQLException {
	return test_PaperDAO.listAllTestPapaer(lctre_no);
}
@Override
public int insertTestPaper(Test_PaperVO test_paperVO) throws SQLException {
	return test_PaperDAO.insertTestPaper(test_paperVO);
}
 
 
}


