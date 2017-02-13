package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Building")
@Data
public class BuildingVO implements Serializable {
	private String bd_No;   // 건물 번호
	private String bd_Nm;   // 건물명
	private String bd_Useyn;   // 건물 사용유무

}
