package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.AnswerDAO;
import com.uni.fems.dto.AnswerVO;
/**
 * <pre>
 * 시험 답안 CRUD를 위한  DAOImpl
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
public class AnswerDAOImpl implements AnswerDAO  {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public AnswerVO getAnswerVO(AnswerVO answerVO) throws SQLException {
		return (AnswerVO) client.queryForObject("getAnswer", answerVO);
	}
	@Override
	public int insertAnswer(AnswerVO answerVO) throws SQLException {
		return client.update("insertAnswer", answerVO);
	}
	@Override
	public List<AnswerVO> listAllAnswer(String loginUser) throws SQLException {
		return client.queryForList("listAllAnswer", loginUser);
	}
	@Override
	public int deleteAnswer(int tpNo) throws SQLException {
		return client.update("deleteAnswer", tpNo);
	}
	
}
