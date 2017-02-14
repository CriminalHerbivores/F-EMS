package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Atrty")
@Data
public class AtrtyVO  implements Serializable {
	private String au_User_No;   // 사용자번호
	private String au_Atrty;   // 권한

}
