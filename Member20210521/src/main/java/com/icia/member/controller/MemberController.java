package com.icia.member.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;

	// home.jsp에서 joinpage 링크클릭 요청을 하면 
	// 아래 메소드가 호출됨 
	@RequestMapping(value="/joinpage")
	public String joinPage() {
		return "memberJoin";
	}
	
	@RequestMapping(value="/memberJoin")
	public ModelAndView insertDB(@ModelAttribute MemberDTO dto) {
		mav = ms.insertDB(dto);
		
		// 회원가입이 완료되면 로그인 페이지가 출력되도록
		return mav;
	}
	
	@RequestMapping(value="/listpage")
	public ModelAndView select() {
		mav = ms.selectDB();
		
		return mav;
	}
	
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mId") String mId) {
		mav = ms.memberView(mId);
		return mav;
	}
	
	// 로그인 화면 출력 메소드
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberLogin";
	}
	// 로그인 처리 메소드
	@RequestMapping(value="/memberLogin")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO dto) {
		// member 객체에는 memberlogin.jsp에서 입력한 mId, mPassword 값만 담겨있음.
		System.out.println("login 메소드" + dto.toString());
		mav = ms.memberLogin(dto);
		return mav;
	}
	
	// 로그아웃 처리 메소드
	@RequestMapping(value="/logout")
	public String logout() {
		// 로그아웃 세션에 저장된 내용을 지운다는 개념
		session.invalidate();
		return "home";
	}
	
	// 회원정보 수정 요청 메소드
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ms.update();
		
		return mav;
	}
	
	// 회원정보 수정 처리 메소드
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute MemberDTO dto) {
		mav = ms.updateProcess(dto);
		return mav;
	}
	
	// 회원삭제 처리 메소드
	@RequestMapping(value="/memberdelete")
	public ModelAndView memberDelete(@RequestParam("mId") String mId) {
		mav = ms.memberDelete(mId);
		return mav;
	}

	// 아이디 중복확인 메소드
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mId") String mId) {
		System.out.println("idCheck 메소드 호출됨");
		System.out.println("입력 id값"+mId);
		String result = ms.idCheck(mId);
		
		return result;
	}
	
	// ajax로 상세조회
	@RequestMapping(value="/memberviewajax")
	public @ResponseBody MemberDTO memberViewAjax(@RequestParam("mId") String mId) {
		System.out.println("memberViewAjax 메소드 호출됨");
		System.out.println("전달 id값 "+mId);
		MemberDTO dto = ms.memberViewAjax(mId);
		System.out.println(dto);
		return dto;
	}
	
	
	
}
