package com.kt.notice;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {
	private final NoticeService noticeService;

	// handler adapter - 빈을 찾아와서 실행
	// handler mapping - if문)
	// 스프링에서 자동으로 구현해주기 때문에 그 구현체를 사용하기만 하면 됨
	// @RequestMapping
	// @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
	@PostMapping(value = "/notice")
	@ResponseBody
	public NoticeResponse create(@RequestBody NoticeRequest request) {

		// 요청에 바디라고 불리는 곳에 json으로 요청이 들어오는 경우
		noticeService.create();
		// view name => jsp 혹은 thymeleaf의 뷰를 찾는 역할을 합니다.
		// index.html
		// 기본 Spring MVC의 view resolver 설정
		// HttpMessageConverter (default) - thymeleafViewResolver
		// MappingJackson2HttpMessageConverter -> 이거로 바꿔주면 문자열자체를 리턴
		// json을 spring에서는 Jackson라이브러리로 다루게되는데
		// gson
		// @ResponseBody
		// 그렇다면 View Resolver는 단순히 html 데이터만 찾아서
		// 반환하는 것이 아닌 HTTP 프로토콜에 맞는 메세지
		// 형태로 변환해주는 역할까지 하는 것인가요?
		return new NoticeResponse(request.title());
	}
}
