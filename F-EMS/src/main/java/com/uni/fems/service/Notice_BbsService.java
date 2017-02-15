package com.uni.fems.service;


import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_FlpthVO;
import com.uni.fems.dto.Notice_BbsVO;
import com.uni.fems.dto.SearchVO;

/**
 * <pre>
 * 
 * </pre>
 * @author 송선호
 * @since 2017.02.01
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.01     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface Notice_BbsService {
	
	/**
	 * <pre>
	 * 공지게시판 리스트를 출력하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param nb_Sklstf_No
	 * @return List<Notice_BbsVO>
	 * @throws SQLException
	 * </pre>
	 */
	public List<Notice_BbsVO> listNotice_Bbs(String nb_Sklstf_No) throws SQLException; // 공지 게시판 리스트
	
	/**
	 * <pre>
	 * 게시판 하나의 vo클래스를 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param nb_Bbs_No
	 * @return Notice_BbsVO
	 * @throws SQLException
	 * </pre>
	 */
	public Notice_BbsVO getNotice_Bbs(int nb_Bbs_No) throws SQLException; //게시판 vo클래스 하나 가져오기
	
	/**
	 * <pre>
	 * 해당하는 게시물의 업로드된 파일을 파일정보 테이블에서 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_flpthVO
	 * @return List<Bbs_FlpthVO>
	 * @throws SQLException
	 * </pre>
	 */
	public List<Bbs_FlpthVO> getBbs_Flpth(Bbs_FlpthVO bbs_flpthVO) throws SQLException;
	
	
	/**
	 * <pre>
	 * 공지게시판을 추가하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param notice_BbsVO
	 * @param bbs_FlpthVO
	 * @throws SQLException
	 * </pre>
	 */
	public void insertNotice_Bbs(Notice_BbsVO notice_BbsVO, Bbs_FlpthVO bbs_FlpthVO) throws SQLException; // 공지게시판 insert
	
	
	
	//////////////////////////////////// 관리자 ///////////////////////////////////////////////
	
	/**
	 * <pre>
	 * 공지게시판의 리스트를 출력하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param searchVO
	 * @return List<Notice_BbsVO>
	 * @throws SQLException
	 * </pre>
	 */
	public List<Notice_BbsVO> listAllNotice_Bbs(int tpage, SearchVO searchVO) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판을 수정하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param notice_BbsVO
	 * @param bf_No
	 * @param bbs_FlpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int updateNotice_Bbs(Notice_BbsVO notice_BbsVO, int bf_No, Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판을 삭제하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param nb_Bbs_No
	 * @param bbs_FlpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteNotice_Bbs(int nb_Bbs_No, Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판 리스트의 페이지를 설정하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param tpage
	 * @param searchVO
	 * @return String
	 * @throws SQLException
	 * </pre>
	 */
	public String pageNumber(int tpage,SearchVO searchVO) throws SQLException;
	
	/**
	 * <pre>
	 * 공지게시판의 개수를 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param notice_BbsVO
	 * @return int
	 * @throws SQLException
	 * </pre>
	 */
	public int countNotice_Bbs(Notice_BbsVO notice_BbsVO) throws SQLException;
	
	
	/*public Bbs_FlpthVO getBbs_Flpth(int bf_No) throws SQLException;*/
	
	

}
