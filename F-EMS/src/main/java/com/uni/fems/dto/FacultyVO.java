package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Faculty")
@Data
public class FacultyVO implements Serializable {
	private String fc_Faculty_Code;   // 학부코드
	private String fc_Coleg_Code;   // 단과대학코드
	private String fc_Faculty_Nm;   // 학부명
	private String fc_Useyn;   // 학부 사용유무

}
