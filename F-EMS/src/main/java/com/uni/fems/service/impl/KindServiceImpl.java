package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.KindDAO;
import com.uni.fems.dto.KindVO;
import com.uni.fems.service.KindService;

/**
 * <pre>
 * 강의 등록, 수정, 삭제시 강의 유형을 반영하는 Service
 * </pre>
 * @author KJH
 * @since 2017. 2. 25.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일        수정자           수정내용
 * --------     --------    ----------------------
 * 2017. 2. 25.   USER            최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
public class KindServiceImpl implements KindService {
 
 private KindDAO kindDAO;
 public void setKindDAO(KindDAO kindDAO){
  this.kindDAO=kindDAO;
 } 
 
}


