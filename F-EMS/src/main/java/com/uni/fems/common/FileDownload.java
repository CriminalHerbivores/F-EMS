package com.uni.fems.common;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.uni.fems.dto.FilesVO;

/**
 * <pre>
 * 파일을 업로드 하며 다운로드 하는 클래스
 * 
 * 파일 다운로드 경로는 하단 메소드의 방식으로 처리되므로
 * DB상에는 파일 이름만 저장되면 된다.
 * </pre>
 * @author JAR
 * @since 2017. 2. 17.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 17.      JAR       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/download")
@Data
public class FileDownload implements ApplicationContextAware {
	private WebApplicationContext context = null;
	public String filePath = "D:/F-EMS/F-EMS/F-EMS/src/main/webapp/resources/files";

	/**
	 * <pre>
	 * 파일을 업로드하며, 파일의 정보를 반환받는 메소드
	 * FilesVO에는 
	 * 
	 * 파일명 fl_File_Nm
	 * 파일유형(확장자) fl_File_Type_Code
	 * 
	 * 가 담겨서 반환된다.
	 * </pre>
	 * <pre>
	 * @param uploadfile
	 * @return
	 * </pre>
	 */
	public FilesVO uploadFile(MultipartFile uploadfile) {
		FilesVO vo = new FilesVO();
		if (!uploadfile.isEmpty()) {
			File file = new File(filePath, "$$"
					+ System.currentTimeMillis()
					+ uploadfile.getOriginalFilename());
			String fileName = file.getName();
			int pos = fileName.lastIndexOf(".");
			try {
				uploadfile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String extension = fileName.substring(pos + 1).toLowerCase();

			vo.setFl_File_Nm(fileName);
			vo.setFl_File_Type_Code(extension);
		}
		return vo;
	}
	
	/**
	 * <pre>
	 * 첨부파일 다운로드를 처리하는 메서드
	 * 
	 * jsp에서 파일을 다운로드 해야 하는 링크에 
	 * <a href="<%=request.getContextPath() %>/download/file/list?filename=${파일이름}">${파일이름}</a>
	 * 을 적어주면 된다.
	 * </pre>
	 * <pre>
	 * @param fileId
	 * @param response
	 * @param filename
	 * @return
	 * @throws IOException
	 * </pre>
	 */
	@RequestMapping("/file/{fileId}")
	public ModelAndView download(@PathVariable String fileId,
			HttpServletResponse response, @RequestParam String filename)
			throws IOException {
//		File downloadFile = getFile(fileId);
//		if (downloadFile == null) {
//			response.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return null;
//		}
//		return new ModelAndView("download", "downloadFile", downloadFile);
		File downloadFile = new File(filePath+"/"+ filename);
		response.setCharacterEncoding("utf-8");
		if (downloadFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	private File getFile(String fileId) {
		String baseDir = context.getServletContext().getRealPath("/WEB-INF/files");
		if (fileId.equals("1"))
			return new File(baseDir, "1486450785194$$excelFile.xlsx");
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
}
