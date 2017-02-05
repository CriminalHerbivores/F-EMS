package com.uni.fems.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.service.SknrgsService;

@Controller
@RequestMapping("/stdnt")
public class SknrgsController {
	
	@Autowired
	private SknrgsService sknrgs_Svc;
	public void setSknrgs_Svc(SknrgsService sknrgs_Svc) {
		this.sknrgs_Svc = sknrgs_Svc;
	}

	@RequestMapping("sknrgsList")
	public String list(Model model,HttpServletRequest request){
		String url="sknrgsList/sknrgsList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		if (key ==null){
			key = "";
		}
		if (tpage ==null){
			tpage= "1";
		} else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("key", key);
		model.addAttribute("tpage",tpage);
		
		HttpSession session = request.getSession();
		String skn_Stdnt_No = (String) session.getAttribute("loginUser");
		
		String servletPath = request.getServletPath();
		String[] path = servletPath.split("/");
		
		List<SknrgsVO> sknrgsList = null;
		String paging = null;
		try {
			sknrgsList = (List<SknrgsVO>) sknrgs_Svc.getStudentSknrgs(skn_Stdnt_No);
			paging = sknrgs_Svc.pageNumber(Integer.parseInt(tpage),key, path[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("sknrgsList", sknrgsList);
		int n = sknrgsList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
	}
	
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
