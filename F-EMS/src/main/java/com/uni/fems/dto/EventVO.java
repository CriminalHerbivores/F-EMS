package com.uni.fems.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Event")
@Data
public class EventVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String evt_Nm; //일정이름
	private Timestamp evt_Start; //시작일
	private Timestamp evt_End; //종료일
	private String evt_Useyn; //일정사용유무
}
