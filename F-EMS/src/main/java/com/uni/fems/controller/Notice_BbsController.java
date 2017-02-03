package com.uni.fems.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.service.Notice_BbsService;


@Controller
@RequestMapping("/notice_bbs")
public class Notice_BbsController {
	
	@Autowired
	private Notice_BbsService notice_BbsSvc;
	public void setNotice_BbsSvc(Notice_BbsService notice_BbsSvc) {
		this.notice_BbsSvc = notice_BbsSvc;
	}
	
	/*@RequestMapping("/noticeList")
	public String noticeList(Model model) throws ServletException, IOException{
		String url="board_management/noticeList";
		List<Notice_BbsVO> noticeList = null;
		try {
			noticeList = notice_BbsSvc.listAllNotice_Bbs1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("noticeList", noticeList);
		return url;
		
	}*/
	
	@RequestMapping("/noticeList")
	public String noticeList(Model model,HttpServletRequest request) throws ServletException, IOException{
		String url="board_management/noticeList";
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
		
		
		List<Notice_BbsVO> noticeList = null;
		String paging = null;
		try {
			noticeList = notice_BbsSvc.listAllNotice_Bbs(Integer.parseInt(tpage));
			paging = notice_BbsSvc.pageNumber(Integer.parseInt(tpage),key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("noticeList", noticeList);
		int n = noticeList.size();
		model.addAttribute("noticeListSize", n);
		model.addAttribute("paging", paging);
		return url;
		
	}
	
	@RequestMapping(value="/writeNotice", method=RequestMethod.GET)
	public String writeNoticeForm(Model model) throws ServletException, IOException {
		String url="board_management/writeNotice";
		return url;
	}
	
	@RequestMapping(value="/writeNotice", method=RequestMethod.POST)
	public String writeNotice(Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO, HttpServletRequest request,
								@RequestParam("uploadfile")MultipartFile uploadfile, HttpSession session, Model model)
								throws ServletException, IOException{
		
		String url = "redirect:noticeList";
		/*HttpSession session = request.getSession();*/
		
		
		
		notice_BbsVO.setNb_Sklstf_No("1111");
		
		String savePath="resources/files";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
	
		if(!uploadfile.isEmpty()){
			File file = new File(uploadFilePath, "$$"+System.currentTimeMillis()+uploadfile.getOriginalFilename());
			String fileName = file.getName();
			int pos = fileName.lastIndexOf(".");
			try{
			uploadfile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			bbs_FlpthVO.setBf_Bbs_Code("notice_bbs");
			bbs_FlpthVO.setBf_File_Type_Code(fileName.substring(pos+1));
			bbs_FlpthVO.setBf_File_Type(file.getAbsolutePath());
		}
		
		try {
			notice_BbsSvc.insertNotice_Bbs(notice_BbsVO,bbs_FlpthVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value="/detailNotice")
	public String detailNotice(@RequestParam int no,@RequestParam int tpage, Model model){
		String url="board_management/detailNotice";
		Notice_BbsVO notice = null;
		try {
			notice = (Notice_BbsVO)notice_BbsSvc.getNotice_Bbs(no);
			notice_BbsSvc.countNotice_Bbs(notice);
			notice.setNb_Rdcnt(notice.getNb_Rdcnt()+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("notice",notice);
		model.addAttribute("tpage",tpage);
		return url;
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.GET)
	public String updateNoticeForm(@RequestParam int no, Model model){
		String url="board_management/updateNotice";
		Notice_BbsVO notice = null;
		
		try {
			notice = notice_BbsSvc.getNotice_Bbs(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("notice",notice);
		return url;
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.POST)
	public String updateNotice(@RequestParam int tpage,Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO, HttpServletRequest request){
		String url = "redirect:detailNotice?no="+notice_BbsVO.getNb_Bbs_No()+"&tpage="+tpage;
		notice_BbsVO.setNb_Sklstf_No("1111");
		try {
			notice_BbsSvc.updateNotice_Bbs(notice_BbsVO, bbs_FlpthVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value="/deleteNotice")
	public String deleteNotice(@RequestParam int no,@RequestParam int tpage){
		String url = "redirect:noticeList?tpage="+tpage;
		
		try {
			notice_BbsSvc.deleteNotice_Bbs(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	


}
