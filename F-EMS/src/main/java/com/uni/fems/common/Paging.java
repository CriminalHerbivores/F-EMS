package com.uni.fems.common;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import com.uni.fems.dto.request.PageRequest;

/**
 * <pre>
 * 페이지를 만드는 클래스
 * </pre>
 * @author JAR
 * @since 2017. 2. 15.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 15.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Paging {
	
	static int view_rows = 4; // 페이지의 개수
	static int counts = 5; // 한 페이지에 나타낼 개수
	/**
	 * <pre>
	 * http://도메인/디렉토리/파일이름.확장자?쿼리키=쿼리값 (request.getRequestURI())
	 * http://도메인/디렉토리 (request.getContextPath())
	 * 
	 * 파일이름을 / 기준으로 잘라서 반환
	 * </pre>
	 * <pre>
	 * @param request
	 * @return
	 * </pre>
	 */
	public String[] callPath(HttpServletRequest request){

		String command = request.getRequestURI();
		
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length()+1);
		}
		
		String[] comm = command.split("/");
		
		return comm;
	}
	/**
	 * <pre>
	 * http://도메인/디렉토리/파일이름.확장자?쿼리키=쿼리값 (request.getRequestURI())
	 * http://도메인/디렉토리 (request.getContextPath())
	 * 
	 * 파일이름을 / 기준으로 잘라서 마지막을 반환
	 * 페이징의 경로를 줄 때 주로 사용
	 * </pre>
	 * <pre>
	 * @param request
	 * @return
	 * </pre>
	 */
	public String lastPath(HttpServletRequest request){
		String[] comm = callPath(request);
		return comm[comm.length-1];
	}
	/**
	 * <pre>
	 * 검색어 변수 값의 유무 체크
	 * </pre>
	 * <pre>
	 * @param key
	 * @return
	 * </pre>
	 */
	public String key(String key){
		if(key.equals("")) key="%";
		return key;
	}
	
	/**
	 * <pre>
	 * 현재 페이지와 페이지 총합을 받아 첫페이지와 마지막 페이지를 반환해줌
	 * </pre>
	 * <pre>
	 * @param tpage 현재 페이지
	 * @param totalRecord 테이블에 있는 데이터의 총 개수
	 * @return {counts,첫페이지, 마지막페이지}
	 * </pre>
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
	 * <pre>
	 * 페이징을 반환해줌
	 * </pre>
	 * <pre>
	 * @param tpage 현재페이지
	 * @param totalRecord 데이터 총 개수
	 * @param path 경로
	 * @param key 매개변수 (&key1=value1&key2=value2)
	 * @return 페이징 반환
	 * @throws SQLException
	 * </pre>
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
	/**
	 * <pre>
	 * vo 형식으로 페이징을 반환해줌
	 * </pre>
	 * <pre>
	 * @param p
	 * @return 페이지를 String 값으로 반환
	 * @throws SQLException
	 * </pre>
	 */
	public String pageNumber(PageRequest p)	throws SQLException {
		
		if(p.getKey()==null){
			p.setKey("");;
		}
		
		int page_count = p.getTotalRecord() / counts;

		if (p.getTotalRecord() % counts != 0)
			page_count++;

		int page = p.getTpage();
		if (p.getTpage() % view_rows == 0)
			page--;

		int start_page = page - (page % view_rows) + 1;
		int end_page = start_page + (view_rows - 1);

		if (end_page > page_count)
			end_page = page_count;

		String str = "";
		
		if (start_page > view_rows) {
			str += "<a href='"+p.getPath()+"?tpage=1" + p.getKey() + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='"+p.getPath()+"?tpage=" + (start_page - 1) + p.getKey() + "'>&lt;</a>&nbsp;&nbsp;";
		}
		for (int i = start_page; i <= end_page; i++) {
			if (i == p.getTpage()) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='"+p.getPath()+"?tpage=" + i + p.getKey() + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}
		if (page_count > end_page) {
			str += "<a href='"+p.getPath()+"?tpage=" + (end_page + 1) + p.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='"+p.getPath()+"?tpage=" + page_count + p.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	/**
	 * <pre>
	 * 댓글 페이지를 만들어서 반환해줌
	 * </pre>
	 * <pre>
	 * @param cpage 댓글의 현재 페이지
	 * @param totalRecord 댓글 페이지 총 개수
	 * @param path 경로
	 * @param key 매개변수 (&key1=value1&key2=value2)
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public String commentPageNumber(int cpage, int totalRecord, String path, String key) 
			throws SQLException {
		
		if(key==null){
			key="";
		}
		
		int page_count = totalRecord / counts;

		if (totalRecord % counts != 0)
			page_count++;

		int page = cpage;
		if (cpage % view_rows == 0)
			page--;

		int start_page = page - (page % view_rows) + 1;
		int end_page = start_page + (view_rows - 1);

		if (end_page > page_count)
			end_page = page_count;

		String str = "";
		
		if (start_page > view_rows) {
			str += "<a href=\"\" id=\"1\" class=\"pageComment\"> &lt; &lt; </a>&nbsp;&nbsp;";
			str += "<a href=\"\" id=\"" + (start_page - 1) + "\"  class=\"pageComment\">&lt;</a>&nbsp;&nbsp;";
		}
		for (int i = start_page; i <= end_page; i++) {
			if (i == cpage) {
				str += "<font color=red>[" + i + "]</font>&nbsp;&nbsp;";
			} else {
				str += "<a href=\"\" id=\""+i+"\" class=\"pageComment\">["+i+"]</a>&nbsp;&nbsp;";
			}
		}
		if (page_count > end_page) {
			str += "<a href=\"\" id=\"" + (end_page + 1) + "\" class=\"pageComment\"> &gt; </a>&nbsp;&nbsp;";
			str += "<a href=\"\" id=\"" +  page_count + "\" class=\"pageComment\"> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		
		return str;
	}
}
