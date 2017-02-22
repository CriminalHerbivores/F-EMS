package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.uni.fems.dao.TuitionDAO;
import com.uni.fems.dto.TuitionVO;
import com.uni.fems.service.TuitionService;

public class TuitionServiceImpl implements TuitionService {

	private TuitionDAO tuitionDAO;
	public void setTuitionDAO(TuitionDAO tuitionDAO) {
		this.tuitionDAO = tuitionDAO;
	}

}
