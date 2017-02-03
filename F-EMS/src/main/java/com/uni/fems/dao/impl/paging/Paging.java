package com.uni.fems.dao.impl.paging;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

public class Paging {
	
	static int view_rows = 2; // 페이지의 개수
	static int counts = 2; // 한 페이지에 나타낼 개수
	
	/**
	 * 검색어 변수 값의 유무 체크
	 * 
	 * @param key
	 * @return
	 */
	public String key(String key){
		if(key.equals("")) key="%";
		return key;
	}
	
	/**
	 * @param tpage 현재 페이지
	 * @param totalRecord 테이블에 있는 데이터의 총 갯수
	 * @return {counts,첫페이지, 마지막페이지}
	 */
	public int[] row(int tpage, int totalRecord){
		int startRow = -1;
		int endRow = -1;

		startRow = (tpage - 1) * counts ;
		endRow = startRow + counts - 1;
		
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		int[] rows = {counts,startRow,endRow};
		
		return rows;
	}
	
	/**
	 * 페이징을 반환해줌
	 * 
	 * @param tpage 현재페이지
	 * @param totalRecord 데이터 총 갯수
	 * @param path 경로
	 * @param key 매개변수 (&key1=value1&key2=value2)
	 * @return 페이징 반환
	 * @throws SQLException
	 */
	public String pageNumber(int tpage, int totalRecord, String path, String key) 
			throws SQLException {
		
		if(key==null){
			key="";
		}
		
		int page_count = totalRecord / counts;

		if (totalRecord % counts != 0)
			page_count++;

		int page = tpage;
		if (tpage % view_rows == 0)
			page--;

		int start_page = page - (page % view_rows) + 1;
		int end_page = start_page + (view_rows - 1);

		if (end_page > page_count)
			end_page = page_count;

		String str = "";
		
		if (start_page > view_rows) {
			str += "<a href='"+path+"?tpage=1" + key + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='"+path+"?tpage=" + (start_page - 1) + key + "'>&lt;</a>&nbsp;&nbsp;";
		}
		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='"+path+"?tpage=" + i + key + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}
		if (page_count > end_page) {
			str += "<a href='"+path+"?tpage=" + (end_page + 1) + key + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='"+path+"?tpage=" + page_count + key + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
}
