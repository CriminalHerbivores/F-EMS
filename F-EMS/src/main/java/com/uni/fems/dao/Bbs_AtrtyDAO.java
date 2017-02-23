package com.uni.fems.dao;

import java.sql.SQLException;

import com.uni.fems.dto.Bbs_AtrtyVO;
/**
 * <pre>
 * 게시판의 권한을 담고 있는 DAO
 * </pre>
 * @author 송선호
 * @since 2017.02.23
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일      수정자            수정내용
 * --------     --------    ----------------------
 * 2017.02.23     송선호           최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface Bbs_AtrtyDAO {

	/**
	 * <pre>
	 * 해당 게시판의 권한 정보를 가져오기 위한 메서드
	 * </pre>
	 * <pre>
	 * @param bbs_no
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public Bbs_AtrtyVO getBBS_Atrty(int bbs_no) throws SQLException;
	
}
