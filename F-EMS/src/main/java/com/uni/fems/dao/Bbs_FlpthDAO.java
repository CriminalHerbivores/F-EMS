package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_FlpthVO;

/**
 * <pre>
 * 공지게시판 파일 업로드 및 다운로드를 위한 DAO
 * </pre>
 * @author 송선호
 * @since 2017.02.03
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일              수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.03     송선호                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */

public interface Bbs_FlpthDAO {

	/**
	 * <pre>
	 *  업로드한 파일의 정보를 저장하는 BBS_FLPTH 테이블의 데이터를 모두 가져오는 메서드	
	 * </pre>
	 * <pre>
	 * @param bbs_flpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<Bbs_FlpthVO> getBbs_Flpth(Bbs_FlpthVO bbs_flpthVO) throws SQLException;
	
	/**
	 * <pre>
	 * 업로드한 파일의 정보를 가져오는 메서드(제너레이터용)
	 * </pre>
	 * <pre>
	 * @param bbs_flpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<Bbs_FlpthVO> getBbs_Flpth_gen(Bbs_FlpthVO bbs_flpthVO) throws SQLException;
	
	/**
	 * <pre>
	 * 게시물 작성시 파일 업로드 할 때 정보를 테이블에 저장하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_FlpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertBbs_Flpth(Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	/**
	 * <pre>
	 * 게시물 작성시 파일 업로드 할 때 정보를 테이블에 저장하는 메서드(제너레이터용)
	 * </pre>
	 * <pre>
	 * @param bbs_FlpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertBbs_Flpth_gen(Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	/**
	 * <pre>
	 * 파일 업로드 정보(BBS_FLPTH 테이블)를 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param bf_No
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteBbs_Flpth(int bf_No) throws SQLException; //수정할때 사용할 delete쿼리
	
	/**
	 * <pre>
	 * 파일 업로드 정보(BBS_FLPTH 테이블)를 삭제하는 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_FlpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteBbs_Flpth_bbs(Bbs_FlpthVO bbs_FlpthVO) throws SQLException; //삭제쿼리
	
	/**
	 * <pre>
	 * 파일 업로드 정보(BBS_FLPTH 테이블)를 삭제하는 메서드(제너레이터용)
	 * </pre>
	 * <pre>
	 * @param bbs_FlpthVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int deleteBbs_Flpth_bbs_gen(Bbs_FlpthVO bbs_FlpthVO) throws SQLException; //generator 삭제쿼리
	
	
}
