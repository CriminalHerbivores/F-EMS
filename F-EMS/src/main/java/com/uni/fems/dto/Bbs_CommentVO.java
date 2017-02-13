package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Bbs_Comment")
@Data
public class Bbs_CommentVO implements Serializable{
	private int bc_Comnt_No; //댓글번호
	private String bc_Bbs_Code; // 게시판명 ex)notice_bbs
	private int bc_Bbs_No; // 게시판번호
	private String bc_User_Id; // 댓글 작성자 아이디
	private String bc_Comnt_Content; // 댓글 내용
	private Timestamp bc_Writng_Dt; // 댓글 작성 날짜

}
