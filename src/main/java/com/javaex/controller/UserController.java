package com.javaex.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	

	//회원가입폼
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join()");
		
		userService.exeJoin(userVo);
		
		return "user/joinOk";
	}
	
	//로그인폼
	@RequestMapping(value="/user/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");
		
		System.out.println(userVo);
		
		UserVo authUser = userService.exeLogin(userVo);
		System.out.println(authUser);
		
		session.setAttribute("authUser", authUser);
		
		return "redirect:/main";
	}
	
	//로그아웃
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		session.invalidate();
		
		return "redirect:/main";
	}
	
	//회원정보수정폼
	@RequestMapping(value="/user/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(HttpSession session, Model model) {
		System.out.println("UserController.modifyForm()");
		
		//세션에 넣어놓은 키값(큰따옴표랑 같이)으로 가져와야함(변수명 X)
		UserVo authVo = (UserVo)session.getAttribute("authUser");
		System.out.println(authVo);
		
		Map<String, Object> uMap = userService.exeSelectIdByNo(authVo.getNo());
		
		model.addAttribute("uMap", uMap);
		System.out.println(uMap);
		
		return "user/modifyForm";
	}
	
	//회원정보수정
	@RequestMapping(value="/user/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.modify()");
		
		userService.exeUpdateUser(userVo);
		
		return "redirect:/main";
	}

}
