package com.uni.fems.dto;

import java.io.Serializable;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("Manage")
@Data
public class ManageVO implements Serializable{
	private String mng_Univ_Nm;   // 대학이름
	private String mng_Univ_Eng_Nm;   // 대학영문이름
	private String mng_Univ_Logo;   // 대학로고
	private String mng_Post_No;   // 우편번호
	private String mng_Adres1;   // 주소1
	private String mng_Adres2;   // 주소2
	private String mng_Tlphon_No;   // 전화번호
	private String mng_Fax_No;   // 팩스번호
	private String mng_Cpyr;   // 저작권
	private String mng_Layout_Knd;   // 레이아웃 종류
	private String mng_Left_Menu_Use_Ennc;   // 좌측메뉴 사용유무
	private String mng_Main_Color;   // 메인컬러
	private String mng_Sub_Color1;   // 보조컬러1
	private String mng_Sub_Color2;   // 보조컬러2
	private String mng_Reltv_Evl_Rate;   // 상대평가비율

}
