package com.uni.fems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lctre")
public class Lctre_TestController {
	
	
	@RequestMapping("/testList")
	public String testList(){
		String url = "lecture/test/testList";
		
		return url;
	}

}
