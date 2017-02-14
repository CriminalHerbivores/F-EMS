package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Compl_Pnt")
@Data
public class Compl_PntVO implements Serializable {
	private String cp_Subjct_Code;   // 학과 코드
	private int cp_Major_Choice;   // 전공 선택
	private int cp_Major_Essntl;   // 전공 필수
	private int cp_Cltr_Essntl;   // 교양 필수
	private int cp_Cltr_Choice;   // 교양 선택

}
