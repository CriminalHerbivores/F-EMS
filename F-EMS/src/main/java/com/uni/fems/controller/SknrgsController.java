package com.uni.fems.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.dto.SknrgsViewVO;
import com.uni.fems.dto.SknrgsVO;
import com.uni.fems.dto.request.PageRequest;
import com.uni.fems.service.SknrgsService;

@Controller
@RequestMapping("/stdnt")
public class SknrgsController {

	@Autowired
	private SknrgsService sknrgs_Svc;
	public void setSknrgs_Svc(SknrgsService sknrgs_Svc) {
		this.sknrgs_Svc = sknrgs_Svc;
	}

	@RequestMapping(value = "/sknrgsList", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		String url = "student/sknrgsList";
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

		HttpSession session = request.getSession();
		String skn_Stdnt_No = (String) session.getAttribute("loginUser");

		String servletPath = request.getServletPath();
		String[] path = servletPath.split("/");

		List<SknrgsVO> sknrgsList = null;
		String paging = "";
		String type = "";
		PageRequest p = new PageRequest();
		p.setTpage(Integer.parseInt(tpage));
		p.setTotalRecord(0);
		p.setPath(path[2]);
		p.setKey(skn_Stdnt_No);

		try {
			p.setTotalRecord(sknrgs_Svc.totalRecord(p));
			sknrgsList = sknrgs_Svc.getStudentSknrgs(p);
			paging = sknrgs_Svc.pageNumber(p);
			type = sknrgs_Svc.getSknrgs(skn_Stdnt_No);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("sknrgsList", sknrgsList);
		model.addAttribute("paging", paging);
		model.addAttribute("type", type);
		return url;
	}

	@RequestMapping(value = "/sknrgsList", method = RequestMethod.POST)
	public String write(SknrgsVO sknrgs,
			@RequestParam("sknFile") MultipartFile uploadfile,
			HttpSession session) {
		String url = "redirect:sknrgsList";

		sknrgs.setSkn_Useyn("n");

		if (!sknrgs.getSkn_Type().equals("복학"))
			sknrgs.setSkn_Type("휴학");

		String savePath = "resources/files";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		if (!uploadfile.isEmpty()) {
			File file = new File(uploadFilePath, "$$"
					+ System.currentTimeMillis()
					+ uploadfile.getOriginalFilename());
			try {
				uploadfile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sknrgs.setSkn_File(file.getName()); // 파일이름
		}
		try {
			sknrgs_Svc.writeSknrgs(sknrgs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

	// 학적 폼
	@RequestMapping(value = "/sknrgListForm", method = RequestMethod.GET)
	public String sknrgListForm(Model model, HttpSession session) {
		String url = "manager/student/sknrgsListForm";
		String skn_Type = (String) session.getAttribute("skn_Type");
		System.out.println("skn_Typen : " + skn_Type);
		List<SknrgsViewVO> sknrgsVOList = null;
		if (skn_Type != null) {
			skn_Type = "%";
		}

		try {
			sknrgsVOList = sknrgs_Svc.getSknrgsType(skn_Type);
			System.out.println("sknrgsVOList : " + sknrgsVOList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }
		model.addAttribute("sknrgsVOList", sknrgsVOList);
		return url;
	}

	// 학적 등록
	@RequestMapping(value = "/sknrgListForm", method = RequestMethod.POST)
	public String sknrgList(@RequestParam(value = "skn_No") String[] skn_Nos,
			@RequestParam(value = "skn_Useyn") String[] skn_Useyns,
			Model model, HttpSession session) {
		String url = "redirect:sknrgListForm";

		SknrgsVO sknrgsVO = new SknrgsVO();
		try {
			for (int i = 0; i < skn_Nos.length; i++) {
				sknrgsVO.setSkn_No(Integer.parseInt(skn_Nos[i]));
				sknrgsVO.setSkn_Useyn(skn_Useyns[i]);
				try {
					sknrgs_Svc.updateUseynSknrgs(sknrgsVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
		}
		return url;
	}

}