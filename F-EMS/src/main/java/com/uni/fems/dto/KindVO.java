package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Kind")
@Data
public class KindVO implements Serializable {
	private int knd_Lctre_No;   // 강의번호
	private String knd_Lctre_Knd;   // 강의종류
}
