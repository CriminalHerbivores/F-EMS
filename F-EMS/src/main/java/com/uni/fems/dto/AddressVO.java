package com.uni.fems.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

/**
 * <pre>
 * 우편번호 검색에 활용되는 VO클래스
 * </pre>
 * @author KJH
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자      수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.    KJH       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Alias("address")
@Data
public class AddressVO {
	
	private String zipNum;  //우편번호
	private String sido;  // 시
	private String gugun; // 구
	private String dong;  // 동
	private String zipCode; //우편코드
	private String bunji; //번지
}
