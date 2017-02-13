package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Notice_Bbs")
@Data
public class Notice_BbsVO implements Serializable{
	private int nb_Bbs_No;   // 게시판 번호
	private String nb_Sklstf_No;   // 직원 번호
	private String nb_Sj;   // 제목
	private String nb_Cn;   // 내용
	private Timestamp nb_Writng_Dt;   // 작성 날짜
	private int nb_Rdcnt; // 조회수
}
