package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

//import com.uni.fems.dao.AnswerDAO;
import com.uni.fems.dto.AnswerVO;
//import com.uni.fems.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {
 
 private AnswerDAO answerDAO;
 public void setAnswerDAO(AnswerDAO answerDAO){
  this.answerDAO=answerDAO;
 }
 
 
}


