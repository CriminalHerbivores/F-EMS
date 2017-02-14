package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Bbs_Atrty")
@Data
public class Bbs_AtrtyVO implements Serializable {
	private int ba_Bbs_No;   // 게시판 번호
	private String ba_Manage;   // 관리자
	private String ba_Sklstf;   // 직원
	private String ba_Profsr;   // 교수
	private String ba_Stdnt;   // 학생
	
}
