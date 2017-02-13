package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Colege")
@Data
public class ColegeVO implements Serializable {
	private String coleg_Code;   // 단과대학코드
	private String coleg_Nm;   // 단과대학명
	private String coleg_Useyn;   // 단과대학 사용유무

}
