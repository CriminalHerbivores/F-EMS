package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Test_Paper")
@Data
public class Test_PaperVO implements Serializable {
	private String tp_No;   // 시험지번호
	private int tp_Lctre_No;   // 교수번호
	private String tp_Profsr_No;   // 강의번호
	private Timestamp tp_Dt;   // 날짜

}
