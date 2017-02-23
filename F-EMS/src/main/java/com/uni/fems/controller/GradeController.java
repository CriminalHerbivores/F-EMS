package com.uni.fems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.service.GradeService;

@Controller
@RequestMapping("grade")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	
	
}
