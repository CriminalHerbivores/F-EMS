package com.uni.fems.dto.request;

import lombok.Data;

/**
 * <pre>
 * 메일을 보내기 위한 데이터를 담는 VO
 * </pre>
 * @author JAR
 * @since 2017. 2. 22.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 22.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Data
public class MessageRequest {
	
	private String mng_Univ_Nm; //보내는 사람 이름
	private String mng_Email; //보내는 메일
	private String email; //받는 메일
	private String title; //제목
	private String content; //내용 (html가능)
	private String filePath; //파일 경로
	
}
