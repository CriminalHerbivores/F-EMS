package com.uni.fems.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Baskin")
@Data
public class BaskinVO {
	private String bskn_Nm;
	private String bskn_Main;
	private String bskn_Sub1;
	private String bskn_Sub2;
	private int bskn_No;
}
