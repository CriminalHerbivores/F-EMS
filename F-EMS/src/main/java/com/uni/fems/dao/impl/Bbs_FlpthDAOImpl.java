package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Bbs_FlpthDAO;
import com.uni.fems.dto.Bbs_FlpthVO;

/**
 * <pre>
 * 공지게시판 파일 업로드 및 다운로드를 위한 DAOImpl
 * </pre>
 * @author 송선호
 * @since 2017.02.03
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.03     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Bbs_FlpthDAOImpl implements Bbs_FlpthDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	@Override
	public List<Bbs_FlpthVO> getBbs_Flpth(Bbs_FlpthVO bbs_flpthVO) throws SQLException{
			List<Bbs_FlpthVO> result = (List<Bbs_FlpthVO>)client.queryForList("getBbs_Flpth",bbs_flpthVO);
		return result;
	}
	@Override
	public List<Bbs_FlpthVO> getBbs_Flpth_gen(Bbs_FlpthVO bbs_flpthVO) throws SQLException {
		List<Bbs_FlpthVO> result = (List<Bbs_FlpthVO>)client.queryForList("getBbs_Flpth",bbs_flpthVO);
		return result;
	}
	@Override
	public int insertBbs_Flpth(Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		int result = client.update("insertBbs_Flpth", bbs_FlpthVO);
		return result;
	}
	@Override
	public int insertBbs_Flpth_gen(Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		int result = client.update("insertBbs_Flpth_gen", bbs_FlpthVO);
		return result;
	}
	@Override
	public int deleteBbs_Flpth(int bf_No) throws SQLException {
		int result = client.update("deleteBbs_Flpth",bf_No);
		return result;
	}
	@Override
	public int deleteBbs_Flpth_bbs(Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		int result = client.update("deleteBbs_Flpth_bbs",bbs_FlpthVO);
		return result;
	}
	@Override
	public int deleteBbs_Flpth_bbs_gen(Bbs_FlpthVO bbs_FlpthVO)
			throws SQLException {
		int result = client.update("deleteBbs_Flpth_bbs_gen",bbs_FlpthVO);
		return result;
	}

	
}
