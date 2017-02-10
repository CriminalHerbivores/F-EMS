package com.uni.fems.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schafs_schdul")
public class Schafs_SchdulController {

	
	@RequestMapping("/schdulList")
	public String schdulList(Model model) throws ServletException, IOException{
	String url="schafs_schdul/schdulList";
	
	
	return url;
	}
	
	
}
