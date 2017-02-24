package com.uni.fems.service;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.TestVO;

/**
 * <pre>
 * 시험문제 CRUD를 위한 Service
 * </pre>
 * @author 송선호
 * @since 2017.02.24
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 *   수정일             수정자                    수정내용
 * --------     --------    ----------------------
 * 2017.02.24     SSH                    최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public interface TestService {
	/**
	 * <pre>
	 * 해당 시험의 문제를 가져오는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param tp_no
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public List<TestVO> listAllTest(int tp_no)throws SQLException;
	
	/**
	 * <pre>
	 * 해당 시험의 시험문제를 추가하는 서비스 메서드
	 * </pre>
	 * <pre>
	 * @param testVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	public int insertTest(TestVO testVO)throws SQLException;

}
