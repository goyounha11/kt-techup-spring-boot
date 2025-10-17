package com.kt.bootcontroller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kt.bootservice.MemberService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

// controller는 제일 앞에서 요청을 처리해주는 역할과 책임
// @Bean @Component

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class HelloBootController {
	private final MemberService memberService;
	private final ApplicationEventPublisher applicationEventPublisher;


	// hello?name=철호
	// 기본적인 응답 패턴이 있음 -> MVC 패턴 -> Template Engine
	@GetMapping
	public String helloWorld(@RequestParam String name) {
		return name + "! Hello, World!";
	}

	@RequestMapping(path = "/say", method = RequestMethod.GET)
	public String say() {
		return "안녕하세요";
	}
}
