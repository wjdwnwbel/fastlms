package com.zerobase.testlms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// MainPage 클래스를 만든 목적 => 매핑하기 위해서

// 컨트롤러로 지정
// 이 안에서 매핑된 주소에 따라 메소드가 실
@RestController
public class MainPage {
	
	@RequestMapping("/")
	public String index() {
		return "Index Page";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		String msg = "hello \r\n fastlms website!!";
		
		return msg;
	}

}
