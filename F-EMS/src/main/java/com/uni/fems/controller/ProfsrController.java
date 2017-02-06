package com.uni.fems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.service.ProfsrService;

@Controller
@RequestMapping("/profsr")
public class ProfsrController {
	
	@Autowired
	private ProfsrService profsrService;
	
	

}
