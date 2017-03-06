package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;
import com.uni.fems.dto.Lctre_Watch_Video_GntVO;
import com.uni.fems.service.LctreService;
import com.uni.fems.service.Lctre_Video_StdntService;

/**
 * <pre>
 * 강의 전반적인 부분
 * </pre>
 * @author JAR
 * @since 2017. 3. 6.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 3. 6.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/lctre")
public class Lctre_Unq_NoController {
	@Autowired
	private Lctre_Video_StdntService lctre_Video_StdntService;
	@Autowired
	private LctreService lctreService;
	
	@RequestMapping("lctreList")
	public String lctreList(String table_Nm, Model model, HttpSession session){
		String url="lecture/lectureList";
//		String loginUser = (String) session.getAttribute("loginUser");
//		Lctre_Watch_Video_GntVO vo = new Lctre_Watch_Video_GntVO();
//		vo.setRe_Stdnt_No(loginUser);
//		List<LctreVO> lctreList = (List<LctreVO>) session.getAttribute("lctreList");
//		List<Lctre_Watch_Video_GntVO> list = new ArrayList<Lctre_Watch_Video_GntVO>();
//		
//		for(LctreVO v : lctreList){
//			vo.setTable_Nm(v.getLc_Lctre_No()+"");
//			List<Lctre_Watch_Video_GntVO> li = new ArrayList<Lctre_Watch_Video_GntVO>();
//			try {
//				li = lctre_Video_StdntService.lctre_watch_video_gnt(vo);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			if(li!=null && li.size()>0)
//				list.add(li.get(0));
//		}
//		model.addAttribute("lctreVideoList",list);
		model.addAttribute("table_Nm",table_Nm);
		return url;
	}
	

	/**
	 * <pre>
	 * 강의계획서 조회
	 * </pre>
	 * <pre>
	 * @param model
	 * @param lctreVO
	 * @param lctre_ActplnVO
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping(value = "/detailLctre")
	String detailLctre(Model model, int lc_Lctre_No) throws ServletException, IOException {
		String url = "professor/detailLctre";
		Lctre_SearchVO vo = new Lctre_SearchVO();
		
		try {
			vo = lctreService.getDetailLctre(lc_Lctre_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("lctre_SearchVO", vo);
		return url;
	}

}
