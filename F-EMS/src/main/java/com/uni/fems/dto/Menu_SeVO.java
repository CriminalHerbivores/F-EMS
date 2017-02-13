package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Menu_Se")
@Data
public class Menu_SeVO implements Serializable{
	private String ms_Se_Code;   // 구분코드
	private String ms_Type;   // 유형

}
