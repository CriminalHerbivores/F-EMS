package com.uni.fems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Subjct_Info_TableController {

	
	// 학부학과 등록
		@RequestMapping("/subjectInsert")
		public String add_subjectForm(HttpServletRequest request,
				HttpSession session) {
			String url = "admin/admin_page/subjectInsert";
			return url;
		}

		// 학부학과 수정
		@RequestMapping("/subjectUpdate")
		public String modify_subjectForm(HttpServletRequest request,
				HttpSession session) {
			String url = "admin/admin_page/subjectUpdate";
			return url;
		}

		// 학부학과 설정
		@RequestMapping("/subjectUseUpdate")
		public String set_subjectForm(HttpServletRequest request,
				HttpSession session) {
			String url = "admin/admin_page/subjectUseUpdate";
			return url;
		}
}
