package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Menu")
@Data
public class MenuVO implements Serializable {
	private int mn_No;   // 메뉴번호
	private String mn_Se_Code;   // 구분코드
	private String mn_Cours;   // 경로
	

}
