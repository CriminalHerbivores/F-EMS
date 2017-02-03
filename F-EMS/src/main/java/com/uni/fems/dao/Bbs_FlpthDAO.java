package com.uni.fems.dao;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dto.Bbs_FlpthVO;

public interface Bbs_FlpthDAO {

	public List<Bbs_FlpthVO> getBbs_Flpth(Bbs_FlpthVO bbs_flpthVO) throws SQLException;
	
	public List<Bbs_FlpthVO> getBbs_Flpth_gen(Bbs_FlpthVO bbs_flpthVO) throws SQLException;
	
	public int insertBbs_Flpth(Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	public int insertBbs_Flpth_gen(Bbs_FlpthVO bbs_FlpthVO) throws SQLException;
	
	public int deleteBbs_Flpth(int bf_No) throws SQLException; //수정할때 사용할 delete쿼리
	
	public int deleteBbs_Flpth_bbs(Bbs_FlpthVO bbs_FlpthVO) throws SQLException; //삭제쿼리
	
	public int deleteBbs_Flpth_bbs_gen(Bbs_FlpthVO bbs_FlpthVO) throws SQLException; //generator 삭제쿼리
	
	
}
