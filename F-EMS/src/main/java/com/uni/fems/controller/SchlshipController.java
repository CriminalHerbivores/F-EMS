package com.uni.fems.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.dto.SchlshipVO;
import com.uni.fems.service.SchlshipService;

@Controller
@RequestMapping("/schlship")
public class SchlshipController {

	@Autowired
	private SchlshipService schlshipService;

	@RequestMapping(value = "/schlshipInsert", method = RequestMethod.GET)
	String schlshipInsertForm(Model model, HttpServletRequest request) {
		String url = "manager/schlship/schlshipInsert";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);
		return url;
	}

	@RequestMapping(value = "/schlshipInsert", method = RequestMethod.POST)
	String schlshipInsert(SchlshipVO schlshipVO,
			@RequestParam("f") MultipartFile multipartFile, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "redirect:schlshipList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");

		if (!multipartFile.isEmpty()) {

			String upload = request.getSession().getServletContext()
					.getRealPath("resources/upload");

			File file = new File(upload, System.currentTimeMillis() + "$$"
					+ multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(file);
				schlshipVO.setSs_Papers_Content(file.toString());
				schlshipService.insertSchlship(schlshipVO);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("key", key);
			model.addAttribute("tpage", tpage);
			
		}
		return url;
	}

	@RequestMapping("/schlshipList")
	public String schlshipList(Model model, HttpServletRequest request)
			throws ServletException, IOException {
		String url = "manager/schlship/schlshipListForm";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);

		List<SchlshipVO> schlshipList = null;
		String paging = null;
		try {
			System.out.println("11111111111");
			schlshipList = schlshipService.selectNameAllPage(
					Integer.parseInt(tpage), key);
			paging = schlshipService.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("schlshipList : " + schlshipList);
		model.addAttribute("schlshipList", schlshipList);
		int n = schlshipList.size();
		model.addAttribute("schlshipListSize", n);
		model.addAttribute("paging", paging);
		return url;

	}

	@RequestMapping("/schlshipDetail")
	public String schlshipDitail(@RequestParam String st_Schlship_No,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "manager/schlship/schlshipDetail";

		model.addAttribute("tpage", tpage);

		SchlshipVO schlshipVO = null;
		try {
			schlshipVO = schlshipService.selectSchlship(st_Schlship_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("schlshipVO", schlshipVO);
		return url;

	}

	@RequestMapping(value = "/schlshipUpdate", method = RequestMethod.GET)
	public String schlshipUpdateForm(@RequestParam String st_Schlship_No,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "manager/schlship/schlshipUpdate";

		model.addAttribute("tpage", tpage);

		SchlshipVO schlshipVO = null;
		try {
			schlshipVO = schlshipService.selectSchlship(st_Schlship_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("schlshipVO", schlshipVO);
		return url;

	}

	@RequestMapping(value = "/schlshipUpdate", method = RequestMethod.POST)
	public String schlshipUpdate(SchlshipVO schlshipVO,
			@RequestParam int tpage, Model model) throws ServletException,
			IOException {
		String url = "redirect:schlshipList";

		System.out.println(" schlshipVO : " + schlshipVO);
		try {
			schlshipService.updateSchlship(schlshipVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;

	}
}
