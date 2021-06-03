package com.icia.memberboard.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberboard.dto.MemberDTO;
import com.icia.memberboard.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/joinpage")
	public String joinPage() {
		return "memberjoin";
	}
	// 회원가입(+첨부파일)
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		mav = ms.memberJoin(member);
		return mav;
	}
	// 아이디 중복확인 메소드 
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		String result = ms.idCheck(mid);
		return result;
	}
	// 로그인 화면 출력 메소드
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberlogin";
	}
	// 로그인 처리 메소드 
	@RequestMapping(value="/login")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) { 
		mav = ms.memberLogin(member);
		return mav;
	}
	//마이페이지
	@RequestMapping(value="/mypage")
	public String myPage() {
		return "mypage";
	}	
	// 수정화면
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ms.update();
		return mav;
	}
	// 수정처리
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute MemberDTO member) {
		mav = ms.updateProcess(member);
		return mav;
	}
	// 로그아웃처리 
	@RequestMapping(value="/logout")
	public String logout() { 
		session.invalidate();
		return "home";
		}
	// 회원삭제처리
	@RequestMapping(value="/memberdelete")
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		mav = ms.memberDelete(mid);
		return mav;
	}
	// 회원목록
	@RequestMapping(value="/memberlist")
	public ModelAndView memberList() {
		mav = ms.memberList();
		return mav;
	}
	// 회원조회
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		mav = ms.memberView(mid);
		return mav;
	}
	// (ajax)상세조회 
		@RequestMapping(value="/memberviewajax")
		public @ResponseBody MemberDTO memberViewAjax(
								@RequestParam("mid") String mid) {
			MemberDTO member = ms.memberViewAjax(mid);
			return member;
		}
}

