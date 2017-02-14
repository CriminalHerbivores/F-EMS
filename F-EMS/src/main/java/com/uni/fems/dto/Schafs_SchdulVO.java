package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Schafs_Schdul")
@Data
public class Schafs_SchdulVO implements Serializable{
	private int sd_No;   // 번호
	private String sd_Sklstf_No;   // 직원번호
	private String sd_Schdul_Nm;   // 일정명
	private String sd_Schdul_Sumry;   // 일정 요약
	private String sd_Detail_Dc;   // 상세 설명
	private Timestamp sd_Bgnde;   // 시작일
	private Timestamp sd_Enddt;   // 종료일
	

}
