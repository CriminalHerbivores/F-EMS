package com.uni.fems.dao.impl;
 
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uni.fems.dao.LctreDAO;
import com.uni.fems.dto.LctreVO;
import com.uni.fems.dto.Lctre_SearchVO;

/**
 * <pre>
 * 강의DAO의 메서드를 구현하는 클래스
 * </pre>
 * @author KJH
 * @since 2017. 01. 24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017.01.24      KJH            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class LctreDAOImpl implements LctreDAO {

	private SqlMapClient client;
	private static LctreDAOImpl instance = new LctreDAOImpl();
	
	private LctreDAOImpl() {}
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	public static LctreDAO getInstance() {
		return instance;
	}
	
	ArrayList<Lctre_SearchVO> listForComboLctre=null;
	
	
	/**
	 * 한개의 강의 정보 가져오기 (완료)
	 */
//	@Override
//	public Lctre_SearchVO getLctre(String lc_Lctre_No) throws SQLException {
//		Lctre_SearchVO lctre_SearchVO = (Lctre_SearchVO) client.queryForObject("getLctre",lc_Lctre_No);
//		return lctre_SearchVO;
//	}


	/**
	 * 강의 콤보박스별 강의 리스트 가져오기......?
	 */
//	@Override
//	public ArrayList<Lctre_SearchVO> listComboLctre(int lc_Lctre_No) throws SQLException {
//		ArrayList<Lctre_SearchVO> listComboLctre=new ArrayList<Lctre_SearchVO>();
//		for(Lctre_SearchVO lctre_Search:listForComboLctre){
//			if(lctre_Search.getLc_Lctre_Code().equals(lc_Lctre_No)){
//				listComboLctre.add(lctre_Search);
//			}
//		}
//		return listComboLctre;
//	}
	
	
	
	
	/**
	 * 강의 상세 검색 (모름)
	 */
//	@Override
//	public ArrayList<Lctre_SearchVO> listDetailLctre(int lc_Lctre_No) throws SQLException {
//		
//		ArrayList<Lctre_SearchVO> lctre_SearchVO = new ArrayList<Lctre_SearchVO>();
//		String lc_Lctre_No1=lc_Lctre_No+""; //형변환
//		
//		if (lc_Lctre_No1.equals("")) {
//			lc_Lctre_No1 = "%";
//		}
//		
//		lctre_SearchVO=(ArrayList<Lctre_SearchVO>)client.queryForList("listDetailLctre",lc_Lctre_No1);
//		return lctre_SearchVO;
//		
//	}
	
	/**
	 * 전체 강의 목록 <-안쓰는
	 */
//	@Override
//	public ArrayList<Lctre_SearchVO> listLctre(String lu_lctre_no)
//			throws SQLException {
//		ArrayList<Lctre_SearchVO> lctre_SearchVO = new ArrayList<Lctre_SearchVO>();
//
//		if (lu_lctre_no.equals("")) {
//			lu_lctre_no = "%";
//		}
//		
//		lctre_SearchVO=(ArrayList<Lctre_SearchVO>)client.queryForList("listProduct",lu_lctre_nm);
//		return lctre_SearchVO;
//	}
	
	
	/**
	 * //[수강신청] 현재 학기의 전체 강의 갯수
	 */
//	@Override
//	public int selectCount(LctreVO lctreVO) throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	/**
	 * 전체 강의 목록
	 */
	@Override
	public ArrayList<LctreVO> listLctre(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		ArrayList<LctreVO> listLctre = null;
		
		listLctre = (ArrayList<LctreVO>) client.queryForList("listLctre", lctre_SearchVO);
		return listLctre;
	}


	/**
	 * 강의 등록 (완료)
	 */
//	@Override
//	public int insertLctre(LctreVO lctreVO) throws SQLException {
//		int result = -1;
//		if (client.insert("insertLctre", lctreVO) != null) {
//			result=-1;
//		} else {
//			result=1;
//		}
//		return result;
//	}


	/**
	 * 강의 수정 (완료)
	 */
//	@Override
//	public int updateLctre(LctreVO lctreVO) throws SQLException {
//		int result = (Integer)client.update("updateLctre",lctreVO);
//		return result;
//	}
	
	
	/**
	 * 강의 삭제 (완료)
	 */
//	@Override
//	public int deleteLctre(int lc_Lctre_No) throws SQLException {
//		int result = (Integer)client.update("deleteLctre",lc_Lctre_No);
//		return result;
//	}

	



	
}
