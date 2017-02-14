package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Files")
@Data
public class FilesVO implements Serializable {
	private String fl_File_Type_Code;   // 파일유형코드
	private String fl_File_Nm;   // 파일명
	

}
