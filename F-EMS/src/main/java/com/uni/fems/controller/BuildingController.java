package com.uni.fems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.fems.dto.BuildingVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.service.BuildingService;

/**
 * <pre>
 * 건물 등록, 수정, 사용여부 Controller
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/admin")
@Data
public class BuildingController {
	
	@Autowired
	BuildingService buildingService;
	
	
	
	   /**
	 * <pre>
	 * 건물등록이 가능한 폼
	 * </pre>
	 * <pre>
	 * @param buildingVO
	 * @param model
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="/buildingInsert", method=RequestMethod.GET)
	   public String buildingInsertForm(Model model, HttpSession session) {
	      
		   
		   String url = "admin/admin_page/buildingInsert";
	      return url;
	   }
	
	
	
	/**
	 * <pre>
	 * 건물번호와 건물명을 중복하지 않는 값으로 입력받아서 건물을 새로 등록 가능한 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/buildingInsert", method=RequestMethod.POST)
	public String buildingInsert(BuildingVO buildingVO,HttpServletRequest request, Model model, HttpSession session) {
		String url = "redirect:buildingInsert";
		try {
			buildingService.insertBuilding(buildingVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("buildingVO",buildingVO);
		return url;
	}


	
	
	/**
	 * <pre>
	 * 등록한 건물의 건물번호, 건물명을 수정 가능한 폼
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/buildingUpdate", method=RequestMethod.GET)
	public String buildingUpdateForm(Model model, HttpServletRequest request, HttpSession session, BuildingVO buildingVO) {
		String url = "admin/admin_page/buildingUpdate";
		
		List<BuildingVO> BuildingList = null;
				
		if(buildingVO.getBd_Useyn()==null){
			buildingVO.setBd_Useyn("y");
		}
	
		try {
			BuildingList = buildingService.selectUseBuilding(buildingVO);
			if(buildingVO.getBd_Useyn()==null){
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		
		model.addAttribute("buildingVO",BuildingList);
		
		return url;
	}
	
	/**
	 * <pre>
	 * 등록한 건물의 건물번호, 건물명을 수정 가능한 로직
	 * </pre>
	 * <pre>
	 * @param request
	 * @param session
	 * @return
	 * </pre>
	 */
	@RequestMapping(value="/buildingUpdate", method=RequestMethod.POST)
	public String buildingUpdate(Model model, HttpSession session, BuildingVO buildingVO) {
		String url = "redirect:buildingUpdate";
		
		try {
			buildingService.updateBuilding(buildingVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("buildingVO",buildingVO);

		return url;
	}
	

}