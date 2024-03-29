package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//전체리스트 가져오기
	public List<GuestVo> selectList() {
		System.out.println("GuestDao.selectList()");
		
		List<GuestVo> gList = sqlSession.selectList("user.selectGuestList");
		
		return gList;
	}
	
	//방명록 등록
	public int insertGuestbook(GuestVo guestVo) {
		System.out.println("GuestDao.insertGuestbook()");
		
		int count = sqlSession.insert("user.insertGuestbook", guestVo);
		
		return count;
	}
	
	//방명록 삭제
	public int deleteGuestbook(GuestVo guestVo) {
		System.out.println("GuestDao.deleteGuestbook()");
		
		int count = sqlSession.delete("user.deleteGuestbook", guestVo);
		
		return count;
	}

}
