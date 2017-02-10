package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// css 예시
	@RequestMapping("/cssExample")
	public String cssExample(){
		String url = "/cssExample";
		return url;
	}

	
	
	@RequestMapping("/")
	public String in(){
		String url = "redirect:index";
		return url;
	}
	
	@RequestMapping("/index")
	public String index(){
		String url = "/index";
		return url;
	}

	/*@RequestMapping("/a")
	public String a(){
		String url = "index";
		return url;
	}*/
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String url = "redirect:/index";
		session.invalidate();
		return url;
	}

	@RequestMapping("/loginForm")
	public String loginForm(HttpServletRequest request,HttpSession session) {
		String url = "member/loginForm";	
		return url;
	}

}
