package com.uni.fems.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.service.Notice_BbsService;


@Controller
@RequestMapping("/notice_bbs")
public class Notice_BbsController implements ApplicationContextAware{
	
	
	
	private WebApplicationContext context = null;
	
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
		
		/*String savePath="resources/files";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);*/ //업로드파일 저장경로가 이상 ㅠㅠ;
		
		
		String uploadFilePath ="D:/Fems_local/F-EMS/F-EMS/src/main/webapp/resources/files";
	
	
	
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
			String bbs_code = request.getServletPath();
			String[] values = bbs_code.split("/");
			
			
			bbs_FlpthVO.setBf_Bbs_Code(values[1]);
			bbs_FlpthVO.setBf_File_Type_Code(fileName.substring(pos+1));
			bbs_FlpthVO.setBf_File_Path(file.getAbsolutePath());
			bbs_FlpthVO.setBf_File_Nm(fileName);
			
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
	public String detailNotice(@RequestParam int no,@RequestParam int tpage, Model model, HttpServletRequest request){
		String url="board_management/detailNotice";
		Notice_BbsVO notice = null;
		Bbs_FlpthVO flpth = new Bbs_FlpthVO();
		List<Bbs_FlpthVO> flpthList = null;
		String bbs_code = request.getServletPath();
		String[] values = bbs_code.split("/");
		flpth.setBf_Bbs_No_No(no);
		flpth.setBf_Bbs_Code(values[1]);
		try {
			notice = (Notice_BbsVO)notice_BbsSvc.getNotice_Bbs(no);
			notice_BbsSvc.countNotice_Bbs(notice);
			notice.setNb_Rdcnt(notice.getNb_Rdcnt()+1);
			
			
			flpthList = notice_BbsSvc.getBbs_Flpth(flpth);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		model.addAttribute("notice",notice);
		model.addAttribute("tpage",tpage);
		model.addAttribute("flpthList",flpthList);
		return url;
		
		
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.GET)
	public String updateNoticeForm(@RequestParam int no, Model model, HttpServletRequest request){
		String url="board_management/updateNotice";
		Notice_BbsVO notice = null;
		Bbs_FlpthVO flpth = new Bbs_FlpthVO();
		List<Bbs_FlpthVO> flpthList = null;
		String bbs_code = request.getServletPath();
		String[] values = bbs_code.split("/");
		flpth.setBf_Bbs_No_No(no);
		flpth.setBf_Bbs_Code(values[1]);
		try {
			notice = notice_BbsSvc.getNotice_Bbs(no);
			flpthList = notice_BbsSvc.getBbs_Flpth(flpth);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		model.addAttribute("notice",notice);
		model.addAttribute("flpthList",flpthList);
		return url;
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.POST)
	public String updateNotice(@RequestParam int tpage, @RequestParam("uploadfile")MultipartFile uploadfile,Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO, HttpServletRequest request){
		String url = "redirect:detailNotice?no="+notice_BbsVO.getNb_Bbs_No()+"&tpage="+tpage;
		notice_BbsVO.setNb_Sklstf_No("1111");
		
		String uploadFilePath ="D:/Fems_local/F-EMS/F-EMS/src/main/webapp/resources/files";

		Bbs_FlpthVO updateFlpthVO = new Bbs_FlpthVO();
		
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
			String bbs_code = request.getServletPath();
			String[] values = bbs_code.split("/");
			
			updateFlpthVO.setBf_Bbs_No_No(notice_BbsVO.getNb_Bbs_No());
			updateFlpthVO.setBf_Bbs_Code(values[1]);
			updateFlpthVO.setBf_File_Type_Code(fileName.substring(pos+1));
			updateFlpthVO.setBf_File_Path(file.getAbsolutePath());
			updateFlpthVO.setBf_File_Nm(fileName);
			
		}

		
		try {
			notice_BbsSvc.updateNotice_Bbs(notice_BbsVO, bbs_FlpthVO.getBf_No(), updateFlpthVO);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value="/deleteNotice")
	public String deleteNotice(@RequestParam int no,@RequestParam int tpage,HttpServletRequest request){
		String url = "redirect:noticeList?tpage="+tpage;
		
		String bbs_code = request.getServletPath();
		String[] values = bbs_code.split("/");
		
		Bbs_FlpthVO bbs_flpthVO = new Bbs_FlpthVO();
		 
		 bbs_flpthVO.setBf_Bbs_No_No(no);
		 bbs_flpthVO.setBf_Bbs_Code(values[1]);
		 
		
		
		try {
			notice_BbsSvc.deleteNotice_Bbs(no, bbs_flpthVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	
	   @RequestMapping("/file/{fileId}")
	   public ModelAndView download(@PathVariable String fileId,
	         HttpServletResponse response, @RequestParam String filename) throws IOException {
		   
		   String downloadFilePath ="D:/Fems_local/F-EMS/F-EMS/src/main/webapp/resources/files";
		   File downloadFile =  new File(downloadFilePath, filename);
		  
		   response.setCharacterEncoding("utf-8");
	      
	      if(downloadFile == null) {
	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         return null;
	      }
	      return new ModelAndView("download", "downloadFile", downloadFile);
	   }
	   
	   @Override
	   public void setApplicationContext(ApplicationContext applicationContext)
	         throws BeansException {
	      this.context = (WebApplicationContext) applicationContext;
	   }
	
	


}















