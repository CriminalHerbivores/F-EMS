package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.StdntVO;

public class Notice_BbsDAOImpl implements Notice_BbsDAO{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No)
			throws SQLException {
		List<Notice_BbsVO> listNotice_Bbs = client.queryForList("listNotice_Bbs",nb_Sklstf_No);
		return listNotice_Bbs;
	}
	@Override
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException {
		Notice_BbsVO result = (Notice_BbsVO)client.queryForObject("getNotice_Bbs", nb_Bbs_No);
		return result;
	}
	@Override
	public int insertNotice_Bbs(Notice_BbsVO notice_BbsVO)
			throws SQLException {
		int result = client.update("insertNotice_Bbs", notice_BbsVO);
		return result;
		
	}
	@Override
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage, int totalRecord,String key) throws SQLException {
		 
		Paging p = new Paging();
		key = p.key(key);

		int[] rows = p.row(tpage, totalRecord);
		List<Notice_BbsVO> listAllNotice_Bbs = client.queryForList("listAllNotice_Bbs",key, rows[1], rows[0]);
		return listAllNotice_Bbs;
	}
	
	@Override
	public int totalNotice_Bbs() throws SQLException{
		int total_pages = 0;
		
		total_pages = (Integer) client.queryForObject("totalNotice_Bbs",null);
		return total_pages;
	}
	
	@Override
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException {
		int result = client.update("updateNotice_Bbs", notice_BbsVO);
		return result;
	}
	@Override
	public int deleteNotice_Bbs(int nb_Bbs_No) throws SQLException {
		int result = client.update("deleteNotice_Bbs", nb_Bbs_No);
		return result;
	}
	
	@Override
	public List<Notice_BbsVO> listAllNotice_Bbs1() throws SQLException {
		List<Notice_BbsVO> listAllNotice_Bbs = client.queryForList("listAllNotice_Bbs",null);
		return listAllNotice_Bbs;
	}
	@Override
	public int countNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException {
		client.update("countNotice_Bbs",notice_BbsVO);
		return 0;
	}

	@Override
	public int maxNotice_No() throws SQLException {
		int result = (Integer) client.queryForObject("maxNotice_No");
		return result;
	}
	
	


	
}
