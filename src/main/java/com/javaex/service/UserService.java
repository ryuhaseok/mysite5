package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin()");
		
		UserVo authUser = userDao.selectUserByIdPw(userVo);
		
		return authUser;
	}
	
	//회원가입
	public int exeJoin(UserVo userVo) {
		System.out.println("UserService.exeJoin()");
		
		int count = userDao.insertUser(userVo);
		
		return count;
	}
	
	//번호로 아이디 가져오기
	public Map<String, Object> exeSelectIdByNo(int no) {
		System.out.println("UserService.exeSelectIdByNo()");
		
		Map<String, Object> uMap = userDao.selectIdByNo(no);
		
		return uMap;
	}
	
	//회원정보수정
	public int exeUpdateUser(UserVo userVo) {
		System.out.println("UserService.exeUpdateUser()");
		
		int count = userDao.updateUser(userVo);
		
		return count;
	}

}
