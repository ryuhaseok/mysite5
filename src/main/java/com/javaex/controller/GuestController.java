package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	//방명록등록폼 + 리스트
	@RequestMapping(value="/guest/addlist", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("GuestController.addList()");
		
		List<GuestVo> gList = guestService.exeSelectList();
		System.out.println(gList);
		
		model.addAttribute("gList", gList);
		
		return "guestbook/addList";
	}
	
	//방명록 등록
	@RequestMapping(value="/guest/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestController.add()");
		
		guestService.exeInsertGuestbook(guestVo);
	
		return "redirect:/guest/addlist";
	}
	
	//삭제폼
	//addList에서 no가 넘어오도록 만들었기때문에 삭제폼jsp에서 ${param.no}를 숨겨서 또 넘어가게 하면 됨
	@RequestMapping(value="/guest/deleteform", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("GuestController.deleteForm()");
		
		return "guestbook/deleteForm";
	}
	
	//삭제
	@RequestMapping(value="/guest/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestController.delete");
		
		guestService.exeDeleteGuestbook(guestVo);
		
		return "redirect:/guest/addlist";
	}

}
