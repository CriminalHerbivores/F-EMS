package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Attendance")
@Data
public class AttendanceVO implements Serializable {
	private String atd_Stdnt_No;   // 학생 번호
	private int atd_Lctre_No;   // 강의 번호
	private String atd_Atend;   // 출결
	private Timestamp atd_Dt;   // 날짜
	
}
