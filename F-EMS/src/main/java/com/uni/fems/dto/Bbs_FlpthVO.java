package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Bbs_Flpth")
@Data
public class Bbs_FlpthVO implements Serializable{
	private int bf_No;   // 번호
	private int bf_Bbs_No_No; // 게시물 번호
	private String bf_File_Type_Code;   // 파일유형코드
	private String bf_Bbs_Code;   // 게시판 코드
	private int bf_Bbs_No;   // 게시판 번호
	private String bf_File_Nm; // 파일 이름
	
}
