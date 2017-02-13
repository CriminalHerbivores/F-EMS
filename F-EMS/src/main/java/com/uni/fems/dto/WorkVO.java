package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Work")
@Data
public class WorkVO implements Serializable{
	private String wk_No;   // 재직번호
	private String wk_Profsr_No;   // 교수번호
	private String wk_Dt;   // 날짜
	private String wk_Work_Status;   // 재직상태
	

}
