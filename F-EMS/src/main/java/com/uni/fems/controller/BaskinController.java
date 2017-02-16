package com.uni.fems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.service.BaskinService;
@Controller
@RequestMapping("baskin")
public class BaskinController {
	@Autowired
	private BaskinService baskinService;
	
	@RequestMapping(value="/baskin", method = RequestMethod.GET)
	public String getBaskin(){
		String url = "";
		return url;
	}
	@RequestMapping(value="/baskin", method = RequestMethod.POST)
	public String getThemeBaskin(String bskn_Nm){
		String url = "";
		return url;
	}
}
