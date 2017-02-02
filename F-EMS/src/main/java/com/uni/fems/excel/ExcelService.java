package com.uni.fems.excel;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ExcelService {
	
	List upload(String file){
		
		ReadOption ro = new ReadOption();
		ro.setFilePath(file);		//경로 입력
		ro.setOutputColumns("st_Stdnt_No", "st_Subjct_Code", "st_Pw", "D", "E", "F");	//배열 명 입력
		ro.setStartRow(2);
		
		List<Map<String, String>> result = ExcelRead.read(ro);
		
		for(Map<String, String> map : result) {
			System.out.println(map.get("A")+" , "+map.get("B")+" , "+map.get("C")+" , "+map.get("D")+" , "+map.get("E")+" , "+map.get("F"));
		}	//.get("배열명")
		return result;
	}
}
