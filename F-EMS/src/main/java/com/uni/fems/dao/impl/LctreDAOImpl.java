package com.uni.fems.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dto.LctreVO;

public class LctreDAOImpl implements LctreDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	ArrayList<LctreVO> listForCodeLctre=null;
	
	

	/**
	 * 강의등록시 강의번호 중복 체크
	 */
	@Override
	public int confirmNO(int new_lctre_No) throws SQLException {
		int result = -1;
		LctreVO lctre = (LctreVO) client.queryForObject("confirmNO", new_lctre_No);
		if (lctre != null) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}

	/**
	 * 강의 코드별 강의 가져오기
	 */
	@Override
	public ArrayList<LctreVO> listCodeLctre(String lc_Lctre_Code)
			throws SQLException {
		ArrayList<LctreVO> listCodeLctre=new ArrayList<LctreVO>();
		for(LctreVO lctre:listForCodeLctre){
			if(lctre.getLc_Lctre_Code().equals(lc_Lctre_Code)){
				listForCodeLctre.add(lctre);
			}
		}
		return listForCodeLctre;
	}

	/**
	 * 한개의 강의 정보 가져오기
	 */
	@Override
	public LctreVO getLctre(int lc_Lctre_No) throws SQLException {
		LctreVO lctre = (LctreVO) client.queryForObject("getLctre", lc_Lctre_No);
		return lctre;
	}


	/**
	 * 강의 등록
	 */
	@Override
	public int insertLctre(LctreVO lctreVO) throws SQLException {
		int result = -1;
		if (client.insert("insertLctre", lctreVO) != null) {
			result=-1;
		} else {
			result=1;
		}
		return result;
	}


	/**
	 * 강의 수정
	 */
	@Override
	public int updateLctre(LctreVO lctreVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 
	 */
	@Override
	public ArrayList<LctreVO> listLctre(int lc_Lctre_No) throws SQLException {
		String lc_Lctre_No1=lc_Lctre_No+""; //형변환
		
		if (lc_Lctre_No1 == "") { 
			lc_Lctre_No1= "%";
		}
		ArrayList<LctreVO> lctreList =(ArrayList<LctreVO>)client.queryForList("listLctre",lc_Lctre_No1);		
		return lctreList;
		
		
	}


	
}
