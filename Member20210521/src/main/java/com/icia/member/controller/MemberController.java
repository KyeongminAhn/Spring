package com.icia.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;

	@RequestMapping(value="/joinpage")
	public String joinPage() {
		return "memberJoin";
	}
	
	@RequestMapping(value="/memberJoin")
	public String insertDB(@ModelAttribute MemberDTO dto) {
		System.out.println(dto.toString());
		ms.insert2(dto);
		return "home";
	}
	
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberLogin";
	}
	
	@RequestMapping(value="/listpage")
	public ModelAndView select() {
		mav = ms.select();
		return mav;
	}
	
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mId") String mId) {
		mav = ms.memberView(mId);
		return mav;
	}
	
}
