package com.uni.fems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stdnt")
public class SknrgsController {
	
	@RequestMapping("register")
	public String register(){
		String url="";
		return url;
	}
	
	@RequestMapping("/absence")
	public String absence(){
		String url="";
		return url;
	}
	
	@RequestMapping("/returnToSchool")
	public String returnToSchool(){
		String url="";
		return url;
	}
}
