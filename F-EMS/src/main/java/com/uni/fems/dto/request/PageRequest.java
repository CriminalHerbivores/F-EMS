package com.uni.fems.dto.request;

/**
 * <pre>
 * 페이지를 만들기 위해 전달되는 변수들을 저장해놓은 vo
 * 
 * tpage : 현재 페이지
 * totalRecord : 데이터의 총 개수
 * key : 매개변수(&key1=value1&key2=&value=2
 * path : 경로 (예시 = index)
 * </pre>
 * @author JAR
 * @since 2017. 01. 24.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일             수정자            수정내용
 * --------     --------    ----------------------
 * 2017.01.24.    JAR       최초작성
 * 2017.02.15.    JAR       추가작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class PageRequest {
	private int tpage;
	private int totalRecord;
	private String key;
	private String path;
	
	public int getTpage() {
		return tpage;
	}
	public void setTpage(int tpage) {
		this.tpage = tpage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
