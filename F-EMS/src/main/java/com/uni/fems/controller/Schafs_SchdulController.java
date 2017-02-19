package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uni.fems.dto.Schafs_SchdulVO;
import com.uni.fems.service.Schafs_SchdulService;

@Controller
@RequestMapping("/schafs_schdul")
public class Schafs_SchdulController {
	
	@Autowired
	Schafs_SchdulService schdulSvc;
	
	public void setSchdulSvc(Schafs_SchdulService schdulSvc) {
		this.schdulSvc = schdulSvc;
	}

	@RequestMapping(value="/schdulList", method=RequestMethod.GET)
	public String schdulList(Model model) throws ServletException, IOException{
	String url="schafs_schdul/schdulList";
	
	return url;
	}
	
	@RequestMapping(value="/insertSchdul", produces = "application/text; charset=utf8")
	@ResponseBody
	public String insertSchdul(@RequestBody Map<String, Object> jsonMap, HttpServletRequest request) throws ServletException, IOException, ParseException{
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
		
		Schafs_SchdulVO schdulVO = new Schafs_SchdulVO();
		
		
		String sdbgndt = (String)jsonMap.get("sd_Bgndt");
		String sdenddt = (String)jsonMap.get("sd_Enddt");
		
/*		DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date sd_Bgnde = timeFormat.parse(sdbgnde);
		Date sd_Enddt = timeFormat.parse(sdenddt);
		*/
		
		
		Date sd_Bgndt = new SimpleDateFormat("yyyy-MM-dd").parse(sdbgndt);
		Date sd_Enddt = new SimpleDateFormat("yyyy-MM-dd").parse(sdenddt);

		System.out.println("==================================="+sd_Bgndt);
		System.out.println("==================================="+sd_Enddt);

		
		String sd_Schdul_Nm = (String)jsonMap.get("sd_Schdul_Nm");
		String sd_Schdul_Sumry = (String)jsonMap.get("sd_Schdul_Sumry");
		
		

		schdulVO.setSd_Sklstf_No(loginUser);
		schdulVO.setSd_Bgndt(sd_Bgndt);
		schdulVO.setSd_Enddt(sd_Enddt);
		schdulVO.setSd_Schdul_Nm(sd_Schdul_Nm);
		schdulVO.setSd_Schdul_Sumry(sd_Schdul_Sumry);
		
		try {
			schdulSvc.insertSchdul(schdulVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String result="<div id=\""
				+schdulVO.getSd_No()
				+"\">시작일자: "
				+schdulVO.getSd_Bgndt()
				+" / "+ "종료일자:"
				+schdulVO.getSd_Enddt()
				+"/" + "일정명 : "
				+schdulVO.getSd_Schdul_Nm()
				+"/"+"일정요약:"
				+schdulVO.getSd_Schdul_Sumry()
				+"</div>";
		return result;
		
		
		
	}
	

	
	
	
	
	
}
