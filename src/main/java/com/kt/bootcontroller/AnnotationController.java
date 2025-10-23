package com.kt.bootcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kt.bootservice.MemberService;
import com.kt.bootservice.NoticeService;
import com.kt.bootservice.UserService;
import com.kt.dto.UserCreateRequest;
import com.kt.profile.ProfileService;
import com.kt.user.User;

import lombok.RequiredArgsConstructor;

// POJO -> Spring Bean으로 등록이되면서
// Spring의 Web요청과 응답을 처리하는 동작을 하도록 만드는 어노테이션
// @Controller -> html뷰를 반환하도록 되어있음.
// -> Spring AnnotationController라는 클래스는 Web요청과 응답을 처리하기위한
// 동작을 해야해라고 알려주는 특화 어노테이션(Spring이 프레임워크의 기능을 인식할 수 있는)
@RestController// -> JSON 혹은 데이터 그 자체를 반환하도록 되어있음
@RequiredArgsConstructor
public class AnnotationController {

	private final MemberService memberService;
	// @Autowired -> DI도와주는 어노테이션
	private final NoticeService noticeService;

	private final ProfileService profileService;

	//@Qualifier -> 어떤 구현체(빈)를 선택할 것인가
	// OCP 원칙 -> 확장에는 열려있고 변경에는 닫혀있다

	// spring 잘 사용하는 방법중 하나로
	// 스프링이 빈을 찾는 방법을 잘 활용한 예시

	// 서버에서 자원을 생성하는 경우 -> POST(어떤 작업을 수행하는 의미, 생성의 의미)
	// @GetMapping..
	// 서버에서 자원을 생성하기위해서 정보를 전달해줘야함 (form, json)
	// JSON으로 들어온 데이터를 POJO인 DTO로 보통은 매핑해서 처리
	// Response처럼 Request도 Jackson이 동작하도록 매핑객체를 바꿔주는 역할
	// @RequestBody

	@PostMapping("/annotation/user")
	public void create(@RequestBody UserCreateRequest request) {
		// 비지니스 로직이
		// 로그인아이디가 중복안됨
		// password가 빈값이면
		System.out.println(request.name());
		System.out.println(request.age());

		memberService.validateLoginId(request.loginId());
		// 멤버 서비스를 주입 받아서 처리해주면 됨
		// 요청..
		// 위임..
		// 주입 -> DI(Dependency Injection)

		// 분리할 필요가 있다
		// 객체가 변경되어야 하는 이유가 오직 하나여야 하다
		// 컨트롤러는 요청과 응답을 잘 처리하고 어떤 서비스로 연결할건지만 담당
	}
}
