package com.uni.fems.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Lctrum")
@Data
public class LctrumVO {
	private String lr_Lctrum_No;   // 강의실 번호
	private String lr_Bd_No;   // 건물 번호
	private int lr_Floor;   // 층수
	private int lr_Roomno;   // 호실
	private int lr_Accept_Nmpr;   // 수용인원
	private String lr_Useyn;   // 강의실 사용유무

}
