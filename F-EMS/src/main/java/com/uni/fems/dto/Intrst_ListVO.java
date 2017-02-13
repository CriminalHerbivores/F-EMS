package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Intrst_List")
@Data
public class Intrst_ListVO implements Serializable{
	private String in_Stdnt_No;   // 학생번호
	private int in_Lctre_No;   // 강의번호

}
