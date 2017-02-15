package com.uni.fems.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

/**
 * <pre>
 * Download 기능을 위해 필요한 자바 클래스
 * </pre>
 * @author 송선호
 * @since 2017.02.09
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.09     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class DownloadView extends AbstractView{

	/**
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * 파일 다운로드 설정을 위한 메서드
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		File file = (File) model.get("downloadFile");
		
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
		
		String userAgent = request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;
		String fileName = null;
		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		}else {
			fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		}finally{
			if(fis !=null)
				try{
					fis.close();
				}catch (IOException ex){
					
				}
		}
		out.flush();
	}

}