package com.uni.fems.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AaaController {

	
	@RequestMapping("/a")
	String indexForm(HttpSession session){
		String url = "manager/index";
		session.setAttribute("userid", "1111");
		
		return url;
		
	}
	
}
