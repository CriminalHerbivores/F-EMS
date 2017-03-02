package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("SknrgsView")
@Data
public class SknrgsViewVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632669299250251114L;
	
	private String sit_Subjct;		//학과명
	private int skn_No;				//학전 번호
	private String skn_Type;		//학전 유형
	private Timestamp skn_Reost_Dt;	//학전 신청 날짜
	private String skn_Content;   	// 신청사유
	private String skn_Useyn;   	// 승인여부
	private String st_Stdnt_No;		///학생 번호
	private String st_Nm;			//학생 이름
	private String st_Moblphon_No;	//핸드폰 번호
	private String st_Email;		//이메일
	private String skn_File;   		// 첨부파일 경로

	
	
}