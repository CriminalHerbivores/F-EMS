package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Use")
@Data
public class UseVO implements Serializable{
	private int us_No;   // 번호
	private String us_Lctrum_No;   // 강의실 번호
	private String us_User_No;   // 사용자 번호
	private String us_User;   // 사용자
	private String us_Cttpc;   // 연락처
	private String us_Cn;   // 상태
	private Timestamp us_Dt;   // 날짜
	private String us_Period;   // 교시
	private String us_Sklstf_No;   // 직원 번호
	

}
