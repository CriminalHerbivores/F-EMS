package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Reqst")
@Data
public class ReqstVO implements Serializable{
	private int re_No;   // 번호
	private String re_Stdnt_No;   // 학생 번호
	private String re_Lctre_No;   // 강의 번호

}
