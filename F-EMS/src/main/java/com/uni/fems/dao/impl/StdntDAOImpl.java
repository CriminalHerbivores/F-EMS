package com.uni.fems.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dto.StdntVO;

public class StdntDAOImpl implements StdntDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	static int view_rows = 5; 	// 페이지의 개수
	static int counts = 10;		// 한 페이지에 나타낼 상품의 개수
	
	
	
	@Override
	public void insertStdnt(StdntVO stdntVO) throws SQLException {
		client.update("insertStdnt", stdntVO);
	}
	
	@Override
	public int totalRecord(String st_Nm) throws SQLException {
		int total_pages = 0;
		if (st_Nm.equals("")) {
			st_Nm = "%";
		}
		total_pages = (Integer) client.queryForObject("totalStdnt",st_Nm);
		return total_pages;
	}
	
	@Override
	public List<StdntVO> selectNameAllPage(int tpage,String st_Nm) throws SQLException {
	      List<StdntVO> list=null;
	      
	      int startRow = -1;
			int endRow = -1;

			if (st_Nm.equals("")) {
				st_Nm = "%";
			}

			int totalRecord = totalRecord(st_Nm);

			startRow = (tpage - 1) * counts ;
			endRow = startRow + counts - 1;
			if (endRow > totalRecord)
				endRow = totalRecord;
	      list = (ArrayList<StdntVO>)client.queryForList("selectAllStdntPage", st_Nm,startRow,counts);
	      return list;
	   }
	
	@Override
	public String pageNumber(int tpage, String st_Nm) throws SQLException {
		String str = "";

		int total_pages = totalRecord(st_Nm);
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
			str += "<a href='ProdStart.do?tpage=1&key="
					+ st_Nm + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='ProdStart.do?tpage="
					+ (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='ProdStart.do?tpage="
						+ i + "&key=" + st_Nm + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='ProdStart.do?tpage="
					+ (end_page + 1) + "&key=" + st_Nm
					+ "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='ProdStart.do?tpage="
					+ page_count + "&key=" + st_Nm
					+ "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
}
