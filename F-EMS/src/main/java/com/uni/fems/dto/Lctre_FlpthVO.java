package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Lctre_Flpth")
@Data
public class Lctre_FlpthVO implements Serializable {
	private int lf_No;   // 번호
	private int lf_Lctre_No;   // 강의번호
	private String lf_File_Type;   // 파일유형코드
	private String lf_Flpth;   // 파일경로

}
