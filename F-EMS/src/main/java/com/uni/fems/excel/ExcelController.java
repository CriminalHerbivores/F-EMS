package com.uni.fems.excel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ExcelController {

	private ExcelService service = new ExcelService();
	
	@RequestMapping(value="/excel",method=RequestMethod.GET)
	public String insertForm(){
		
		return "insertForm";
	}
	
	@RequestMapping(value="/excel",method=RequestMethod.POST)
	public String upload(@RequestParam String file, Model model){
		//file 파일 경로를 입력 받는다.
		String url = "excelForm";
		
		List list = service.upload(file);	//받아오기<map형태>
		
		model.addAttribute("excelList", list);
		
		return "excelForm";
		
	}
	
	
}
