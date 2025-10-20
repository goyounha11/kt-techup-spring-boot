package com.kt.bootservice;

import org.springframework.stereotype.Service;

import com.kt.bootcontroller.HelloBootController;

import lombok.RequiredArgsConstructor;

@Service
public class MemberService {
	public String print() {
		return "This is Member Service";
	}

}
