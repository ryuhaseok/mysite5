package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//아이디 패스워드로 번호 이름 가져오기
	public UserVo selectUserByIdPw(UserVo userVo) {
		System.out.println("UserDao.selectUserByIdPw");
		
		System.out.println(userVo);
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		System.out.println(authUser);
		
		return authUser;
	}//
	
	//회원가입
	public int insertUser(UserVo userVo) {
		System.out.println("UserDao.insertUser");
		
		System.out.println(userVo);
		int count = sqlSession.insert("user.insertUser", userVo);
		
		return count;
	}//
	

	
	public Map<String, Object> selectIdByNo(int no) {
		System.out.println("UserDao.selectIdByNo");
		
		Map<String, Object> uMap = sqlSession.selectOne("user.selectIdByNo", no);
		
		return uMap;
	}//
	
	//수정
	public int updateUser(UserVo userVo) {
		System.out.println("UserDao.updateUser");
		
		int count = sqlSession.update("user.updateUser", userVo);
		
		return count;
	}//
	
}
