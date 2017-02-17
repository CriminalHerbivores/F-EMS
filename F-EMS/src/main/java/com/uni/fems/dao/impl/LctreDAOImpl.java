package com.uni.fems.dao.impl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
//	static int view_rows = 5; // 페이지의 개수
//	static int counts = 6; // 한 페이지에 나타낼 강의 개수
	

	
	
	
	
	/**
	 * 전체 강의 목록
	 */
	@Override
	public List<Lctre_SearchVO> listLctre(String lu_Lctre_Nm) throws SQLException { //int tpage, 
		//개설강의목록 메인
		List<Lctre_SearchVO> listLctre;
		if(lu_Lctre_Nm==null){
			lu_Lctre_Nm="";
		}
		listLctre = (List<Lctre_SearchVO>) client.queryForList("listLctre", lu_Lctre_Nm);
		return listLctre;
	}
	
	/**
	 * 강의 등록 (완료)
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
	 * 강의 수정 (완료)
	 */
	@Override
	public int updateLctre(LctreVO lctreVO) throws SQLException {
		int result = (Integer)client.update("updateLctre",lctreVO);
		return result;
	}
	
	
	/**
	 * 강의 삭제 (완료)
	 */
	@Override
	public int deleteLctre(int lc_Lctre_No) throws SQLException {
		int result = (Integer)client.update("deleteLctre",lc_Lctre_No);
		return result;
	}
	
	
	
	
	
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

	
	//===========================================================================================


	
	
	// 검색어가 없으면 모든 강의 갖고오나보다...
	@Override
	public int totalRecord(String lu_Lctre_Nm) throws SQLException {
		/*int total_pages = 0;
		if (lu_Lctre_Nm.equals("")) {
			lu_Lctre_Nm = "%";
		}
		total_pages = (Integer) client.queryForObject("totalRecord",lu_Lctre_Nm);
		return total_pages;*/
		return 0;
	}
	
	
	
	@Override
	public String pageNumber(int tpage, String name) throws SQLException {
		/*String str="";
		
		int total_pages = totalRecord(name);
		int page_count = total_pages / counts + 1;

		if (total_pages % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}
		
		int page=tpage;
		if(tpage%view_rows==0) page--;
		
		int start_page = page - (page % view_rows) + 1;
		int end_page = start_page + (counts - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='course/courseAble?tpage=1&key="
					+ name + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='course/courseAble?tpage="
					+ (start_page - 1);
			str += "&key=<%=lu_Lctre_Nm%>'>&lt;</a>&nbsp;&nbsp;";
			
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='course/courseAble?tpage="
						+ i + "&key=" + name + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='course/courseAble?tpage="
					+ (end_page + 1) + "&key=" + name
					+ "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='course/courseAble?tpage="
					+ page_count + "&key=" + name
					+ "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;*/
		
		return null;
	}
	@Override
	public String pageNum(Lctre_SearchVO lctre_SearchVO) throws SQLException {
		/*int tpage = Integer.parseInt(lctre_SearchVO.getTpage());
		
		int total_pages = (Integer) client.queryForObject("listForProductCount",lctre_SearchVO);
		int page_count = total_pages / counts;
		
		if (total_pages % counts != 0) page_count++;

		int page=tpage;
		if(tpage%view_rows==0) page--;
		
		int start_page= page - (page % view_rows) +1;
		int end_page = start_page + (view_rows - 1);
		
		if (end_page > page_count) end_page = page_count;
		
		String str = "";
		String key = "";
		
		if(!lctre_SearchVO.getKind().equals("")){
			key = "&kind="+lctre_SearchVO.getKind();
		}else if(!lctre_SearchVO.getCategory().equals("")){
			key = "&category="+lctre_SearchVO.getCategory();
		}
		
		if(!lctre_SearchVO.getLu_Lctre_Nm().equals("")){
			key += "&key="+ lctre_SearchVO.getLu_Lctre_Nm();
		}
		
		////////////////////////////////////////////////////////////////////
		
		if (start_page > view_rows) {
			str += "<a href='product.ne?tpage=1" + key + "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='product.ne?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}
		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='product.ne?tpage=" + i + key + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}
		if (page_count > end_page) {
			str += "<a href='product.ne?tpage=" + (end_page + 1) + key + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='product.ne?tpage=" + page_count + key + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;*/
		
		return null;
	}
	
	
	
	//===========================================================================================
	
}
