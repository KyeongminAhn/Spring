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

	public void insert1(String mId, String mpassword, String mName, String mEmail) {

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
	
	public ModelAndView memberView(String mId) {
		mav = new ModelAndView();
		
		// 한 명 회원에 대한 정보만 필요하기 때문에 DTO타입의 객체로 리턴 받음.
		// List // DTO 구분짓기 다수 // 하나
		MemberDTO member = mdao.memberView(mId);
		
		// DB 조회 결과를 member에 받았고
		// member를 담아서 memberview.jsp로 가야함.
		mav.addObject("result", member);
		mav.setViewName("memberview");
		
		return mav;
	}
	
}
