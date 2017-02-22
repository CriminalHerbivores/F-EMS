package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Subjct_Info_TableDAO;
import com.uni.fems.dto.ColegeVO;
import com.uni.fems.dto.FacultyVO;
import com.uni.fems.dto.Subjct_Info_TableVO;
import com.uni.fems.dto.UserSubjctVO;
/**
 * <pre>
 * 학과 관련 사항을 처리하는 DAOImpl
 * </pre>
 * @author KJH
 * @since 2017. 02. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자         수정내용
 * --------     --------    ----------------------
 * 2017.02.22.    KJH           최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Subjct_Info_TableDAOImpl implements Subjct_Info_TableDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	// 학과명으로 학과 찾기
	@Override
	public ArrayList<UserSubjctVO> selectSubjctByName(String sit_Subjct)
			throws SQLException {

		ArrayList<UserSubjctVO>	subjctList;
		subjctList=(ArrayList<UserSubjctVO>) client.queryForList("selectSubjctByName",sit_Subjct);
		return subjctList;
	}

	@Override
	public ArrayList<ColegeVO> selectColege() throws SQLException {
		ArrayList<ColegeVO> col = (ArrayList<ColegeVO>) client.queryForList("selectColege");
		return col;
	}

	@Override
	public ArrayList<FacultyVO> selectFaculty(String fc_Coleg_Code)
			throws SQLException {
		ArrayList<FacultyVO> fa = (ArrayList<FacultyVO>) client.queryForList("selectFaculty", fc_Coleg_Code);
		return fa;
	}

	@Override
	public ArrayList<Subjct_Info_TableVO> selectSubjct(String sit_Faculty)
			throws SQLException {
		ArrayList<Subjct_Info_TableVO> sub = (ArrayList<Subjct_Info_TableVO>) client.queryForList("selectSubjct",sit_Faculty);
		return sub;
	}

	@Override
	public ArrayList<UserSubjctVO> selectSubjctByCode(String sit_Subjct_Code)
			throws SQLException {
		ArrayList<UserSubjctVO> sub = (ArrayList<UserSubjctVO>) client.queryForList("selectSubjctByCode",sit_Subjct_Code);
		return sub;
	}

	@Override
	public void updateTut(Subjct_Info_TableVO sub) throws SQLException {
		client.update("updateTut",sub);
	}
	
}
