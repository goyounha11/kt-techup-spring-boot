package com.kt.bootservice;

import org.springframework.stereotype.Service;

import com.kt.bootcontroller.HelloBootController;

import lombok.RequiredArgsConstructor;

// Controller와 같은 역할을하는 특화 어노테이션
// 여기서는 비지니스 로직을 처리할거야 라고 알려주는 어노테이션
@Service
public class MemberService {
	public String print() {
		return "This is Member Service";
	}

	public void validateLoginId(String loginId) {
		if(loginId.equals("..어디선가에서 불러옴")) {
			// 중복아이디 에러
			// 변경
		} else {
			// 회원 생성 로직 수행
		}
	}

}
