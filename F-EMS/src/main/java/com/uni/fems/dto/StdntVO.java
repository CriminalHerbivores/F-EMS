package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Stdnt")
@Data
public class StdntVO implements Serializable{
	private String st_Stdnt_No;   // 학생 번호
	private String st_Subjct_Code;   // 학과 코드
	private String st_Pw;   // 비밀번호
	private String st_Nm;   // 이름
	private String st_Eng_Nm;   // 영문 이름
	private String st_Ihidnum;   // 주민번호
	private String st_Moblphon_No;   // 핸드폰 번호
	private String st_House_Tlphon_No;   // 집 전화 번호
	private String st_Entsch_Dt;   // 입학 일자
	private String st_Prtctor_Nm;   // 보호자 이름
	private String st_Family_Relate;   // 가족 관계
	private String st_Post_No;   // 우편 번호
	private String st_Adres1;   // 주소1
	private String st_Adres2;   // 주소2
	private String st_Cnslt_At;   // 상담 여부
	private String st_Email;   // 이메일
	private String st_Brhs_At;   // 기숙사 여부
	private String st_Profsr_No;   // 교수 번호
	private String st_Grdtn_Dt;   // 졸업 일자
	
}
