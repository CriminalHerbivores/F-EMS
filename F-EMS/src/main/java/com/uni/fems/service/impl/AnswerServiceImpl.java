package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.AnswerDAO;
import com.uni.fems.dto.AnswerVO;
import com.uni.fems.service.AnswerService;
/**
 * <pre>
 * 시험 답안 CRUD를 위한  ServiceImpl
 * </pre>
 * @author 송선호
 * @since 2017.02.26
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.26     SSH                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class AnswerServiceImpl implements AnswerService {
 
 private AnswerDAO answerDAO;
 public void setAnswerDAO(AnswerDAO answerDAO){
  this.answerDAO=answerDAO;
 }
@Override
public AnswerVO getAnswerVO(AnswerVO answerVO) throws SQLException {
	return answerDAO.getAnswerVO(answerVO);
}
@Override
public int insertAnswer(AnswerVO answerVO) throws SQLException {
	return answerDAO.insertAnswer(answerVO);
}
@Override
public List<AnswerVO> listAllAnswer(String loginUser) throws SQLException {
	return answerDAO.listAllAnswer(loginUser);
}
@Override
public int countAnswerSTD(int tpNo) throws SQLException {
	return answerDAO.countAnswerSTD(tpNo);
}
@Override
public List<String> nameAnswerSTD(int tpNo) throws SQLException {
	return answerDAO.nameAnswerSTD(tpNo);
}
 
 
}


