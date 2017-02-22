package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.common.Paging;
import com.uni.fems.dao.Bbs_CommentDAO;
import com.uni.fems.dao.Bbs_Comment_GntDAO;
import com.uni.fems.dao.Bbs_FlpthDAO;
import com.uni.fems.dao.Bbs_GntDAO;
import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Bbs_GntVO;
import com.uni.fems.dto.Bbs_List_GntVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.service.Bbs_GntService;
import com.uni.fems.service.Notice_BbsService;

/**
 * <pre>
 * 게시판을 사용하기 위한 서비스
 * </pre>
 * @author KJS
 * @since 2017.02.21
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.21     kjs                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public class Bbs_GntServiceImpl implements Bbs_GntService{
	
	private Bbs_GntDAO dbs_GntDAO;
	private Bbs_FlpthDAO bbs_FlpthDAO;
	private Bbs_Comment_GntDAO bbs_Comment_GntDAO;
	

	public void setBbs_Comment_GntDAO(Bbs_Comment_GntDAO bbs_Comment_GntDAO) {
		this.bbs_Comment_GntDAO = bbs_Comment_GntDAO;
	}
	public void setBbs_FlpthDAO(Bbs_FlpthDAO bbs_FlpthDAO) {
		this.bbs_FlpthDAO = bbs_FlpthDAO;
	}
	public void setBbs_GntDAO(Bbs_GntDAO dbs_GntDAO) {
		this.dbs_GntDAO = dbs_GntDAO;
	}
	
	
	@Override
	public Bbs_GntVO getBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		return dbs_GntDAO.getBbs_Gnt(bbs_list_gnt);
	}
	@Override
	public void insertBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		
		dbs_GntDAO.insertBbs_Gnt(bbs_list_gnt);
		int maxNo = dbs_GntDAO.maxNotice_No(bbs_list_gnt.getBl_Table_Nm());
		bbs_FlpthVO.setBf_Bbs_No_No(maxNo);
		
		if(!(bbs_FlpthVO.getBf_File_Nm()==null))
		bbs_FlpthDAO.insertBbs_Flpth_gen(bbs_FlpthVO);
	}
	@Override
	public List<Bbs_GntVO> listAllBbs_Gnt(int tpage, Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		int totalRecord = dbs_GntDAO.totalBbs_Gnt(bbs_list_gnt);
		return dbs_GntDAO.listAllBbs_Gnt(bbs_list_gnt, tpage, totalRecord);
		
	}
	@Override
	public int updateBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, int bf_No,Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		dbs_GntDAO.updateBbs_Gnt(bbs_list_gnt);
		 bbs_FlpthDAO.deleteBbs_Flpth(bf_No); // 수정할 때 먼저 삭제하고
		 
		 if(!(bbs_FlpthVO.getBf_File_Nm()==null)) //파일이 있을 때(null)이 아니면
		 bbs_FlpthDAO.insertBbs_Flpth_gen(bbs_FlpthVO); // 생성
		return 0;
	}
	@Override
	public int deleteBbs_Gnt(Bbs_List_GntVO bbs_list_gnt, Bbs_FlpthVO bbs_FlpthVO) throws SQLException {
		bbs_Comment_GntDAO.deleteAllBbs_Comment_Gnt(bbs_list_gnt);
		dbs_GntDAO.deleteBbs_Gnt(bbs_list_gnt);
		bbs_FlpthDAO.deleteBbs_Flpth_bbs_gen(bbs_FlpthVO);
		return 0;
	}
	@Override
	public String pageNumber(int tpage,Bbs_List_GntVO bbs_list_gnt, SearchVO searchVO) throws SQLException {
		int totalRecord = dbs_GntDAO.totalBbs_Gnt(bbs_list_gnt);
		String page = new Paging().pageNumber(tpage,totalRecord,"noticeList", "&key="+searchVO.getKey()+"&value="+searchVO.getValue());
		return page;
	}
	@Override
	public int countBbs_Gnt(Bbs_List_GntVO bbs_list_gnt) throws SQLException {
		return dbs_GntDAO.countBbs_Gnt(bbs_list_gnt);
	}
	@Override
	public List<Bbs_FlpthVO> getBbs_Flpth(Bbs_FlpthVO bbs_flpthVO)
			throws SQLException {
		return bbs_FlpthDAO.getBbs_Flpth_gen(bbs_flpthVO);
	}


}

