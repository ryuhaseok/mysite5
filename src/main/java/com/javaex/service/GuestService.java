package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	
	@Autowired
	private GuestDao guestDao;
	
	
	//전체리스트 가져오기
	public List<GuestVo> exeSelectList() {
		System.out.println("GuestService.exeSelectList()");
		
		List<GuestVo> gList = guestDao.selectList();
		
		return gList; 
	}
	
	//방명록 등록
	public int exeInsertGuestbook(GuestVo guestVo) {
		System.out.println("GuestService.exeInsertGuestbook()");
		
		int count = guestDao.insertGuestbook(guestVo);
		
		return count;
	}
	
	//삭제
	public int exeDeleteGuestbook(GuestVo guestVo) {
		System.out.println("GuestService.exeDeleteGuestbook()");
		
		int count = guestDao.deleteGuestbook(guestVo);
		
		return count;
	}

}
