package com.icia.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.example.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/* Service 클래스에 @Service 어노테이션을 붙인 후
	 * DAO 클래스는 @Repository 어노테이션
	 * Controller 클래스에서 @Autowired를 붙여서 Service 클래스 객체를 선언하면
	 * 매번 new를 이용하여 객체를 만들지 않고도 Service 클래스의 자원 (필드, 메소드)을 활용할 수 있음.
	 */
	
	//	TestService에 있는 abc 라는 메소드를 호출하고 싶다면
	//	TestService tts = new TestService();
	//	tts.abc();
	
	@Autowired
	private TestService ts;
	
	
	@RequestMapping(value="/")
	public String home() {
		System.out.println("hello");
		return "hello"; // => hello.jsp를 출력하는 역할을 함.
	}
	
	// 링크를 통해서 온 요청 처리하기
	@RequestMapping(value="/test123")
	public void test123() {
		System.out.println("test123 주소요청");
	}
	
	@RequestMapping(value="/welcome")
	public String welcome() {
	return "welcome";
	}
	
	// msg에 담겨온 데이터를 sysout으로 출력
	// method를 쓰지 않으면 get, post 모두 받을 수 있음.
	// 참고: 링크로 요청하는 것은 무조건 get방식	
	@RequestMapping(value="/welcomemsg")
	public void welcomemsg(
			@RequestParam("msg") String msg,
			@RequestParam("msg2") String msg2) {
		System.out.println(msg);
		System.out.println(msg2);
	}
	
	// 링크로 넘어온 파라미터 받기
	@RequestMapping(value="/linkmsg")
	public void linkmsg(
			@RequestParam("val1") String val1,
			@RequestParam("val2") String val2) {
		System.out.println(val1);
		System.out.println(val2);
	}	
	
	//
	@RequestMapping(value="/insertDB")
	public void insertDB(@RequestParam("data1") String data1) {
		System.out.println(data1);
	// 패키지 추가	
	// com.icia.exmaple.service	
	// com.icia.exmaple.dao
		// src/main/java/com/icia/example/ 이하에 dao, service 폴더가
		// 같은 수준으로 보여야 함.
		
		// TestService 클래스에 있는 method1 호출	
		/*
		 * hello.jsp에서 입력하고 저장 버튼 클릭
		 * HomeController의 insertDB 메소드 호출되고
		 * 여기서 TestService의 method1 메소드 호출함.	
		 * hello.jsp -> HomeController -> TestService ->TestDAO 
		 * testMapper(쿼리문 실행) -> DataBase(저장)
		 */
		ts.method1();
		// hello.jsp에서 넘어온 데이터를 TestService로 넘김
		
		// 데이터를 넘겨 method1에서 해당 데이터를 sysout으로 출력해보시오.
		ts.method2(data1);
		// TestService클래스가 가지고 있는 Method2를 호출한다.
		// 호출하면서 data1을 전달한다.
	}
	
	
	
}
