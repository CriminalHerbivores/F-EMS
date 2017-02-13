package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Sklstf_Atrty")
@Data
public class Sklstf_AtrtyVO implements Serializable{
	private String sa_Sklstf_No;   // 직원번호
	private String sa_Atrty;   // 권한
	

}
