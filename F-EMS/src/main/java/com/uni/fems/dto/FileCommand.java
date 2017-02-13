package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

@Alias("FileCommand")
@Data
public class FileCommand implements Serializable {
	
	private String title;
	private MultipartFile uploadfile;
	

}
