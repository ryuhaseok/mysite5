package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void exeLogin(UserVo userVo) {
		System.out.println("exeLogin()");
		
		userDao.selectUserByIdPw(userVo);
	}
	

}
