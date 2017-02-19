package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.Bbs_CommentDAO;
import com.uni.fems.dao.Bbs_FlpthDAO;
import com.uni.fems.dao.Bbs_ListDAO;
import com.uni.fems.dao.Notice_BbsDAO;
import com.uni.fems.dao.impl.paging.Paging;
import com.uni.fems.dto.Bbs_AtrtyVO;
import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Bbs_ListVO;
import com.uni.fems.dto.Bbs_List_AtrtyVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.service.Bbs_ListService;

/**
 * <pre>
 * 게시판 리스트와 관계 사용을 위한 service
 * </pre>
 * @author 김진수
 * @since 2017.02.18
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                   수정내용
 * --------     --------    ----------------------
 * 2017.02.18     김진수                   최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class Bbs_ListServiceImpl implements Bbs_ListService {

	private Bbs_ListDAO bbs_ListDAO;

	public void setBbs_ListDAO(Bbs_ListDAO bbs_ListDAO) {
		this.bbs_ListDAO = bbs_ListDAO;
	}
	@Override
	public List<Bbs_List_AtrtyVO> selectNameAllPage(int tpage, String bl_Bbs_Nm)
			throws SQLException {
		int totalRecord = bbs_ListDAO.totalBbs_List_Atrty(bl_Bbs_Nm);
		List<Bbs_List_AtrtyVO> list = bbs_ListDAO.listAllBbs_List_Atrty(tpage, totalRecord,bl_Bbs_Nm);
		return list;
	}

	@Override
	public String pageNumber(int tpage, String bl_Bbs_Nm) throws SQLException {
		int totalRecord = bbs_ListDAO.totalBbs_List_Atrty(bl_Bbs_Nm);
		String page = new Paging().pageNumber(tpage,totalRecord,"bbs_List_AtrtyList", "&key="+bl_Bbs_Nm);
		return page;
	}
	@Override
	public Bbs_List_AtrtyVO getBbs_List_Atrty(int bl_Bbs_No)
			throws SQLException {
		return bbs_ListDAO.getBbs_List_Atrty(bl_Bbs_No);
	}

	@Override
	public int updateBbs_Atrty(Bbs_AtrtyVO bbs_AtrtyVO) throws SQLException {
		return bbs_ListDAO.updateBbs_Atrty(bbs_AtrtyVO);
	}

	@Override
	public int updateBbs_List(Bbs_ListVO bbs_ListVO) throws SQLException {
		return bbs_ListDAO.updateBbs_List(bbs_ListVO);
	}

	@Override
	public int insertBbs_List_Atrty(Bbs_List_AtrtyVO bbs_List_AtrtyVO)
			throws SQLException {
		System.out.println("1");
		bbs_ListDAO.insertBbs_Table(bbs_List_AtrtyVO.getBl_Table_Nm());
		System.out.println("2");
		bbs_ListDAO.insertComment_Table(bbs_List_AtrtyVO.getBl_Table_Nm());
		System.out.println("3");
		return bbs_ListDAO.insertBbs_List_Atrty(bbs_List_AtrtyVO);
	}

}
