package com.icia.memberboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberboard.dao.MemberDAO;
import com.icia.memberboard.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;
	@Autowired
	private HttpSession session;
	// 가입
	public ModelAndView memberJoin(MemberDTO member) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile mfile = member.getMfile();
		String mfilename = mfile.getOriginalFilename();
		mfilename = System.currentTimeMillis() + "-" + mfilename;
		String savePath = "C:\\Users\\Kyeongmin Ahn\\Desktop\\kmAhn\\kotlin\\source_ahn\\spring\\Spring\\MemberBoard210602\\src\\main\\webapp\\resources\\upload\\"+mfilename;
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		
		member.setMfilename(mfilename);
		mdao.memberJoin(member);
		mav.setViewName("memberlogin");
		
		return mav;
	}
	// id중복체크
	public String idCheck(String mid) {
		String checkResult = mdao.idCheck(mid);
		String result = "";
		if(checkResult == null) {
			result = "ok";
		} else {
			result = "no";
		}
		return result;
	}
	// 로그인
	public ModelAndView memberLogin(MemberDTO member) {
		mav = new ModelAndView();
		String loginId = mdao.memberLogin(member);
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("redirect:/boardlist");
		} else {
			// 로그인 실패 처리
			mav.setViewName("memberlogin");
		}
				
		return mav;
	}
	// 회원수정화면
	public ModelAndView update() {
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginMember");
		MemberDTO memberUpdate = mdao.update(loginId);
		mav.addObject("memberUp", memberUpdate);
		mav.setViewName("memberupdate");
		return mav;
	}
	// 회원수정처리
	public ModelAndView updateProcess(MemberDTO member) {
		mav = new ModelAndView();
		int updateResult = mdao.updateProcess(member);
		if(updateResult > 0) {
			mav.setViewName("home");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}
	public ModelAndView memberDelete(String mid) {
		mav = new ModelAndView();
		mdao.memberDelete(mid);
		mav.setViewName("redirect:/boardlist");
		return mav;
	}
	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();		
		mav.addObject("memberList", memberList);
		mav.setViewName("memberlist");
		return mav;
	}
	public ModelAndView memberView(String mid) {
		mav = new ModelAndView();
		MemberDTO member = mdao.memberView(mid);
		mav.addObject("result", member);
		mav.setViewName("memberview");
		
		return mav;
	}
	public MemberDTO memberViewAjax(String mid) {
		MemberDTO member = mdao.memberView(mid);
		return member;
	}

}
