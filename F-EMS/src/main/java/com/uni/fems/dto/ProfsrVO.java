package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Profsr")
@Data
public class ProfsrVO implements Serializable{
	private String pr_Profsr_No;   // 교수 번호
	private String pr_Pw;   // 비밀번호
	private String pr_Nm;   // 이름
	private String pr_Eng_Nm;   // 영문 이름
	private String pr_Ihidnum;   // 주민번호
	private String pr_Moblphon_No;   // 핸드폰 번호
	private String pr_House_Tlphon_No;   // 집 전화번호
	private String pr_Profsr_Tlphon_No;   // 교수 전화번호
	private String pr_Post_No;   // 우편 번호
	private String pr_Adres1;   // 주소1
	private String pr_Adres2;   // 주소2
	private String pr_Email;   // 이메일

}
