package com.uni.fems.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import com.uni.fems.dao.ProfsrDAO;
import com.uni.fems.dao.SklstfDAO;
import com.uni.fems.dao.StdntDAO;
import com.uni.fems.dao.UsersDAO;
import com.uni.fems.dto.AddressVO;
import com.uni.fems.dto.ProfsrVO;
import com.uni.fems.dto.SklstfVO;
import com.uni.fems.dto.StdntVO;
import com.uni.fems.dto.UsersVO;
import com.uni.fems.service.UsersService;

@Data
public class UsersServiceImpl implements UsersService {

	private UsersDAO usersDAO;
	@Autowired
	private StdntDAO stdntDAO;
	@Autowired
	private ProfsrDAO profsrDAO;
	@Autowired
	private SklstfDAO sklstfDAO;

	@Override
	public String findId(UsersVO usersVO) throws SQLException {
		String id = usersDAO.findId(usersVO);
		return id;
	}
	@Override
	public String findPw(UsersVO usersVO) throws SQLException {
		String role = usersDAO.findPw(usersVO);
		
		if(role!="" && role!=null){
			String pw="";
			Random random = new Random();
			for(int i=0; i<10; i++){
				pw += (random.nextInt(9)+1)+"";
			}
			switch(role){
			case "ROLE_STD" :
				StdntVO stdntVO = new StdntVO();
				stdntVO.setSt_Stdnt_No(usersVO.getId());
				stdntVO.setSt_Pw(pw);
				stdntDAO.updatePw(stdntVO);
				break;
			case "ROLE_PRO" :
				ProfsrVO profsrVO = new ProfsrVO();
				profsrVO.setPr_Profsr_No(usersVO.getId());
				profsrVO.setPr_Pw(pw);
				profsrDAO.updatePw(profsrVO);
				break;
			case "ROLE_STF" : 
			case "ROLE_ADMIN" : 
				SklstfVO sklstfVO = new SklstfVO();
				sklstfVO.setStf_Sklstf_No(usersVO.getId());
				sklstfVO.setStf_Pw(pw);
				//sklstfDAO.updatePw(sklstfVO);
				break;
			default :
				break;
			}
			role = pw;
		}
		
		return role;
	}
	
	// 우편번호 찾기
	@Override
	public ArrayList<AddressVO> selectAddressByDong(String dong)
			throws SQLException {
		ArrayList<AddressVO> addressVO=usersDAO.selectAddressByDong(dong);
		return addressVO;
	}

}
