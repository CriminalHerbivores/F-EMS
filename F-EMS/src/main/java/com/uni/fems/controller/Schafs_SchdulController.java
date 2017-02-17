package com.uni.fems.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/schafs_schdul")
public class Schafs_SchdulController {

	
	@RequestMapping(value="/schdulList", method=RequestMethod.GET)
	public String schdulList(Model model) throws ServletException, IOException{
	String url="schafs_schdul/schdulList";
	
	return url;
	}
	
/*	@RequestMapping(value="/insertSchdul")
	@ResponseBody
	public */
	
	
	
	
	
	
}
