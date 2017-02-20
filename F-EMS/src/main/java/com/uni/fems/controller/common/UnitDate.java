package com.uni.fems.controller.common;

import java.util.Calendar;

/**
 * <pre>
 * 현재 년도 / 월 / 일 / 학기를 반환
 * </pre>
 * @author JAR
 * @since 2017. 2. 20.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 20.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class UnitDate {
	/**
	 * <pre>
	 * 반환받은 배열의 
	 * 0번째는 현재년도
	 * 1번째는 현재월
	 * 2번째는 현재일
	 * 3번쨰는 현재학기
	 * </pre>
	 * <pre>
	 * @return
	 * </pre>
	 */
	public int[] getDay(){
		Calendar c = Calendar.getInstance();
		int[] uDay = new int[4];
		uDay[0] = c.get(Calendar.YEAR);
		uDay[1] = c.get(Calendar.MONTH);
		uDay[2] = c.get(Calendar.DATE);
		
		// 1~6월은 1학기
		// 7~12월은 2학기
		if(uDay[1]<7){
			uDay[3] = 1;
		}else{
			uDay[3] = 2;
		}
		return uDay;
	}
}
