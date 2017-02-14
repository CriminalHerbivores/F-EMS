package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Cnslt_BbsVO")
@Data
public class Cnslt_BbsVO implements Serializable{
	private int cb_No;   // 게시판번호
	private String cb_User_No;   // 사용자번호
	private String cb_Title;   // 제목
	private String cb_Cont;   // 내용
	private Timestamp cb_Writing;   // 작성날짜
	private String cb_Answer;   // 댓글

}
