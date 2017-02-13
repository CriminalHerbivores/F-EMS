package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Bbs_List")
@Data
public class Bbs_ListVO implements Serializable{
	private int bl_Bbs_No;   // 게시판 번호
	private String bl_Bbs_Nm;   // 게시판 명
	private String bl_Table_Nm;   // 테이블 명
	private String bl_Use_Ennc;   // 사용유무
	
}
