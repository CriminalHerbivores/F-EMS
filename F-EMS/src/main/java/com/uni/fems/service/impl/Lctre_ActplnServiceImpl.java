package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import lombok.Data;

import com.uni.fems.dao.Lctre_ActplnDAO;
import com.uni.fems.dto.Lctre_ActplnVO;
import com.uni.fems.service.Lctre_ActplnService;


/**
 * <pre>
 * 강의계획서를 등록, 수정, 삭제
 * </pre>
 * @author USER
 * @since 2017. 2. 18.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 18.      USER       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Data
public class Lctre_ActplnServiceImpl implements Lctre_ActplnService {
 
 private Lctre_ActplnDAO lctre_ActplnDAO;

 
 
@Override
public void insertLctre_Actpln(Lctre_ActplnVO lctre_ActplnVO)
		throws SQLException {
	System.out.println("==================================================================================Lctre_ActplnServiceImpl  111111111111111");
	lctre_ActplnDAO.insertLctre_Actpln(lctre_ActplnVO);
	System.out.println("==================================================================================Lctre_ActplnServiceImpl  22222222222222222222");

}
 
 
}


