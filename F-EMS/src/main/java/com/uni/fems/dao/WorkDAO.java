package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.WorkVO;

public interface WorkDAO {
	/**
	 * <pre>
	 * 교수 재직 상태 등록
	 * </pre>
	 * <pre>
	 * @param workVO
	 * @throws SQLException
	 * </pre>
	 */
	void insertWork(WorkVO workVO) throws SQLException;
	/**
	 * <pre>
	 * 교수 재직 상태 수정
	 * </pre>
	 * <pre>
	 * @param workVO
	 * @throws SQLException
	 * </pre>
	 */
	void updateWork(WorkVO workVO) throws SQLException;
	/**
	 * <pre>
	 * 교수번호로 재직 상태 조회
	 * </pre>
	 * <pre>
	 * @param workVO
	 * @return
	 * @throws SQLException
	 * </pre>
	 */
	List<WorkVO> selectWork(WorkVO workVO) throws SQLException;
}
