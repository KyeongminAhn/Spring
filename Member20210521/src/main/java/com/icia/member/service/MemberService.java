package com.icia.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;

	public void insert1(String mid, String mpassword, String mName, String mEmail) {

	}
	
	public void insert2(MemberDTO dto) {
		mdao.insert(dto);
	}

	public ModelAndView select() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.select();
		
		System.out.println("memberList 확인");
		for(int i=0; i<memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}
		
		mav.addObject("mList", memberList);
		mav.setViewName("memberList");
		
		return mav;
	}
	
}
