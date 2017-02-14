package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Sklstf")
@Data
public class SklstfVO implements Serializable {
	private String stf_Sklstf_No;   // 직원 번호
	private String stf_Subject_Code;   // 학과 번호
	private String stf_Nm;   // 이름
	private String stf_Eng_Nm;   // 영문 이름
	private String stf_Ihidnum;   // 주민 번호
	private String stf_Moblphon_No;   // 핸드폰 번호
	private String stf_House_Tlphon_No;   // 집 전화 번호
	private String stf_Pw;   // 비밀번호
	private String stf_Post_No;   // 우편번호
	private String stf_Adres1;   // 주소1
	private String stf_Adres2;   // 주소2
	private String stf_Email;   // 이메일
	
}
