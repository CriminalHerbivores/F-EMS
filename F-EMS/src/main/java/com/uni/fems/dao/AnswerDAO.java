package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.AnswerVO;

/**
 * <pre>
 * 시험 답안 CRUD를 위한  DAO
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
public interface AnswerDAO {

	/**
	 * <pre>
	 * 해당 시험의 문제에 답변을 가져오는 메서드
	 * </pre>
	 * <pre>
	 * @param tp_no
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public AnswerVO getAnswerVO(AnswerVO answerVO) throws SQLException;
	
	/**
	 * <pre>
	 * 해당 시험의 문제에 답변을 추가하는 메서드
	 * </pre>
	 * <pre>
	 * @param tp_no
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertAnswer(AnswerVO answerVO) throws SQLException;
	
	/**
	 * <pre>
	 * 로그인 학생의 시험 유효성 위해 만든 메서드
	 * </pre>
	 * <pre>
	 * @param loginUser
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<AnswerVO> listAllAnswer(String loginUser) throws SQLException;
	
	/**
	 * <pre>
	 * 시험본 답안지를 삭제하는 메서드(TEST_PAPER 지우기 위해) 
	 * </pre>
	 * <pre>
	 * @param tpNo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteAnswer(int tpNo) throws SQLException;
	
	
	/**
	 * <pre>
	 * 해당 시험을 본 학생 수를 구하는 메서드
	 * </pre>
	 * <pre>
	 * @param tpNo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int countAnswerSTD(int tpNo) throws SQLException;
	
	/**
	 * <pre>
	 * 해당 시험을 본 학생 이름 list를 구하는 메서드
	 * </pre>
	 * <pre>
	 * @param tpNo
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<String> nameAnswerSTD(int tpNo) throws SQLException;
}
