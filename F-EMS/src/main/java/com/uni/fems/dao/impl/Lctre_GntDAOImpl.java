package com.uni.fems.dao.impl;
 
import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Lctre_GntDAO;

/**
 * <pre>
 * 강의DAO의 메서드를 구현하는 클래스
 * </pre>
 * @author KJS
 * @since 2017. 02.19
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.02.19      KJS            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Lctre_GntDAOImpl implements Lctre_GntDAO {

	private SqlMapClient client;
	private static Lctre_GntDAOImpl instance = new Lctre_GntDAOImpl();
	
	private Lctre_GntDAOImpl() {}
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	public static Lctre_GntDAO getInstance() {
		return instance;
	}
	
	@Override
	public int notice_Table(String table_nm)throws SQLException{
		return client.update("notice_Table", table_nm);
		
	}
	@Override
	public int date_Table(String table_nm)throws SQLException{
		return client.update("date_Table", table_nm);
		
	}
	@Override
	public int qna_Table(String table_nm)throws SQLException{
		return client.update("qna_Table", table_nm);
		
	}
	@Override
	public int task_Table(String table_nm)throws SQLException{
		return client.update("task_Table", table_nm);
		
	}
	@Override
	public int video_Table(String table_nm)throws SQLException{
		return client.update("video_Table", table_nm);
		
	}
	@Override
	public int watch_Table(String table_nm)throws SQLException{
		return client.update("watch_Table", table_nm);
		
	}
	

}
