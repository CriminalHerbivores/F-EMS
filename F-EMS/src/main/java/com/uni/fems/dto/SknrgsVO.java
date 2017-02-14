package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Sknrgs")
@Data
public class SknrgsVO implements Serializable{
	private int skn_No;   // 번호
	private String skn_Stdnt_No;   // 학생번호
	private String skn_Type;   // 유형
	private Timestamp skn_Reqst_Dt;   // 신청날짜
	private String skn_Content;   // 신청사유
	private String skn_Useyn;   // 승인여부
	private String skn_File;   // 첨부파일 경로
	
}
