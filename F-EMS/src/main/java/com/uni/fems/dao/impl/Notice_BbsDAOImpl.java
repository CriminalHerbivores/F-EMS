package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dto.Notice_BbsVO;

public class Notice_BbsDAOImpl implements Notice_BbsDAO{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	static int view_rows = 10; // 페이지의 개수
	static int counts = 10; // 한 페이지에 나타낼 상품의 개수
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
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage) throws SQLException {
		 
		// 게시판의 데이터를 가지고 오는 쿼리 rep:1:게시물 2: 답변
		int startRow = -1;
		int endRow = -1;
		
		int totalRecord = totalNotice_Bbs();
		
		startRow = (tpage - 1) * counts ;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		List<Notice_BbsVO> listAllNotice_Bbs = client.queryForList("listAllNotice_Bbs",null,startRow,counts);
		return listAllNotice_Bbs;
	}
	
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
	public String pageNumber(int tpage) throws SQLException {
		String str = "";

		int total_pages = totalNotice_Bbs();
		int page_count = total_pages / counts + 1;

		if (total_pages % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}

		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='noticeList?tpage=1'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='noticeList?tpage=" + (start_page - 1);
			str += "&key=<%=nb_Bbs_No%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='noticeList?tpage=" + i +"'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='noticeList?tpage=" + (end_page + 1)
					+"'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='noticeList?tpage=" + page_count
					+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	
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
	
	
	
	
	
	
	
	


	
}
