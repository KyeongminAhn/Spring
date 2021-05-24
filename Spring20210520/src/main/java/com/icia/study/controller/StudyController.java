package com.icia.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.study.service.StudyService;

@Controller
public class StudyController {

	@Autowired
	private StudyService ss;
	
	// 데이터와 화면 정보를 담을 수 있는 ModelAndView 클래스 타입의 변수 mav 선언
	// (import, 대소문자 // Autowired 시키지 않는다.)
	private ModelAndView mav;
	
	// 서로 다른 컨트롤러에 있다고 하더라도 주소가 같은 메소드가 있으면
	// 오류 발생함.
	// 즉, 주소로 사용하는 value= 에 쓰는 값은 중복x, 유니크해야 함!
//	@RequestMapping(value="/")
//	public String home() {
//		return "home";
//	}
	
	@RequestMapping(value="/insertpage")
	public String insertpage() {
		return "insert";
	}
	
	@RequestMapping(value="/insert")
	public String insertDB(@RequestParam("param1") String param1) {
		System.out.println(param1);
		ss.insertDB(param1);
		// insert가 완료되면 home.jsp 출력
		return "home";
	}
	
	@RequestMapping(value="/select")
	public ModelAndView selectDB() {
		System.out.println("컨트롤러");
		// 서비스클래스의 selectDB 메소드를 호출해서 결과를 mav에 저장
		mav = ss.selectDB();
		return mav; // <= 이 mav에는 dbList를 select.jsp로 가지고 가는 내용이 담겨 있음.
		// 최종적으로 컨트롤러가 리턴을 함.
	}
	
	
	
}
