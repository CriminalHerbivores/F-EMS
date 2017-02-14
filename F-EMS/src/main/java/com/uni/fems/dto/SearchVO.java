package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Search")
@Data
public class SearchVO implements Serializable{
	private String key;
	private String value;
	
}
