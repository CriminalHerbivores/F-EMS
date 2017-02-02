package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.FilesDAO;
import com.uni.fems.dto.FilesVO;
import com.uni.fems.service.FilesService;

public class FilesServiceImpl implements FilesService {
 
 private FilesDAO filesDAO;
 public void setFilesDAO(FilesDAO filesDAO){
  this.filesDAO=filesDAO;
 }
 
 
}


