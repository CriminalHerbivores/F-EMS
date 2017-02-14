package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Users")
@Data
public class UsersVO implements Serializable {
	private String user_No;   // 사용자 번호
	private String user_Sklstf_No;   // 직원번호
	private String user_Stdnt_No;   // 학생번호
	private String user_Profsr_No;   // 교수번호
	
}
