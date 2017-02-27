package com.uni.fems.dao;

import java.sql.SQLException;
 
/**
 * <pre>
 * 강의 공지, 자료, 질의, 과제, 비디오, 시청여부 테이블 생성DAO 
 * </pre>
 * @author KJS
 * @since 2017. 02. 19
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.02.19      KJS            강의목록
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface Lctre_GntDAO {

	/**
	 * <pre>
	 * 강의 공지게시판 생성
	 * </pre>
	 * @param table_nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int notice_Table(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 강의 자료게시판 생성
	 * </pre>
	 * @param table_nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int date_Table(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 강의 과제 테이블 생성
	 * </pre>
	 * @param table_nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int task_Table(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 강의 비디오 테이블 생성
	 * </pre>
	 * @param table_nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int video_Table(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 강의 질의 응답 테이블 생성
	 * </pre>
	 * @param table_nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int qna_Table(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 강의시청여부 테이블 생성
	 * </pre>
	 * @param table_nm
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	int watch_Table(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 초기값 생성
	 * </pre>
	 * @param table_nm
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctreTable_Date(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 초기값 생성
	 * </pre>
	 * @param table_nm
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctreTable_Notice(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 초기값 생성
	 * </pre>
	 * @param table_nm
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctreTable_Qna(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 초기값 생성
	 * </pre>
	 * @param table_nm
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctreTable_Task(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 초기값 생성
	 * </pre>
	 * @param table_nm
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctreTable_Video(String table_nm) throws SQLException;

	/**
	 * <pre>
	 * 초기값 생성
	 * </pre>
	 * @param table_nm
	 * @throws SQLException
	 * </pre>
	 */
	void insertLctreTable_Watch(String table_nm) throws SQLException;


	
}

