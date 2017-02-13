package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Consultation")
@Data
public class ConsultationVO implements Serializable {
	private String cs_Stdnt_No;   // 학생번호
	private String cs_Profsr_No;   // 교수번호
	private Timestamp cs_Dt;   // 날짜
	private String cs_Knd;   // 종류
	private String cs_Cont;   // 내용

}
