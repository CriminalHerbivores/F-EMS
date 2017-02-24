package com.uni.fems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 강의 -> 온라인 게시판 Controller.
 * </pre>
 * @author 송선호
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/lctre")
public class Lctre_TestController {
	
	
	@RequestMapping("/testList")
	public String testList(){
		String url = "lecture/test/testList";
		
		return url;
	}
	@RequestMapping("/writeTest")
	public String writeTest(){
		String url = "lecture/test/writeTest";
		return url;
	}
	

}
