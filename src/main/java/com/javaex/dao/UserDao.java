package com.javaex.dao;

import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	public void selectUserByIdPw(UserVo userVo) {
		System.out.println("UserDao.selectUserByIdPw");
		
		System.out.println(userVo);
	}//
	

	public int insertUser(UserVo userVo) {
		
		
		return 0;
	}//
	

	
	public UserVo selectUserById(int no) {
		
		
		return null;
	}//
	
	public int update(UserVo userVo) {
		
		
		return 0;
	}//
	
}
